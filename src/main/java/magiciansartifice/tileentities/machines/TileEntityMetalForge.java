package magiciansartifice.tileentities.machines;

import magiciansartifice.utils.ItemStackHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.HashMap;
import java.util.Map;

public class TileEntityMetalForge extends TileEntity implements ISidedInventory
{
    public static final int INV_SIZE = 4;
    public static final int METAL_SLOT = 0;
    public static final int CARBON_SLOT = 1;
    public static final int FUEL_SLOT = 2;
    public static final int OUTPUT_SLOT = 3;

    public static final int MAX_CARBON_TIME = 300;
    public static final int MAX_METAL_TIME = 600;

    public static final int INGOT_MB = 144;
    public static final int BLOCK_MB = INGOT_MB * 9;

    private static final HashMap<Item, Integer> meltingAmountRegistry = new HashMap<Item, Integer>();
    private static final HashMap<Item, String> meltingNameRegistry = new HashMap<Item, String>();

    //Inventory variables
    private ItemStack[] inventory = new ItemStack[INV_SIZE];
    private final Map<String, Integer> fluids = new HashMap<String, Integer>();

    //Functional variables
    private int fuelTime = 0;
    private int fuelMax = 0;
    private int carbonBurnTime = 0;
    private int metalBurnTime = 0;

    //Multi-block variables
    private boolean hasMaster, isMaster;
    private int masterX, masterY, masterZ;

    @Override
    public void updateEntity()
    {
        super.updateEntity();
        if (!worldObj.isRemote)
        {
            //-------------Multi-block Checking------------------
            if (hasMaster())
            {
                if (isMaster())
                {
                    if (!checkMultiBlockForm())
                        resetStructure();
                }
                else
                {
                    if (!checkForMaster())
                        reset();
                }
            }
            else
            {
                // Constantly check if structure is formed until it is.
                if (checkMultiBlockForm())
                    setupStructure();
            }

            //-------------Functioning--------------------
            if (hasMaster && isMaster)
            {
                if (!worldObj.isRemote)
                {
                    //refuel
                    if (fuelTime == 0)
                    {
                        int fuelBurnTime = TileEntityFurnace.getItemBurnTime(getStackInSlot(FUEL_SLOT));
                        if (fuelBurnTime > 0)
                        {
                            fuelTime += fuelBurnTime;
                            fuelMax = fuelBurnTime;
                            decrStackSize(FUEL_SLOT, 1);
                        }
                    }
                    else
                    {
                        fuelTime--;
                        if (worldObj.getTotalWorldTime() % 5 == 0)
                        {
                            if (getStackInSlot(METAL_SLOT) != null)
                            {
                                if (metalBurnTime == MAX_METAL_TIME)
                                {
                                    metalBurnTime = 0;
                                    String name = meltingNameRegistry.get(getStackInSlot(METAL_SLOT).getItem());
                                    Integer currentMetal = fluids.get(name);
                                    currentMetal = currentMetal == null ? 0 : currentMetal;//null check
                                    int newMetal = meltingAmountRegistry.get(getStackInSlot(METAL_SLOT).getItem());
                                    fluids.put(name, currentMetal + newMetal);
                                    decrStackSize(METAL_SLOT, 1);
                                }
                                else
                                {
                                    metalBurnTime++;
                                }
                            }
                            if (getStackInSlot(CARBON_SLOT) != null)
                            {
                                if (carbonBurnTime == MAX_CARBON_TIME)
                                {
                                    carbonBurnTime = 0;
                                    String name = meltingNameRegistry.get(getStackInSlot(CARBON_SLOT).getItem());
                                    Integer currentMetal = fluids.get(name);
                                    currentMetal = currentMetal == null ? 0 : currentMetal;//null check
                                    int newMetal = meltingAmountRegistry.get(getStackInSlot(CARBON_SLOT).getItem());
                                    fluids.put(name, currentMetal + newMetal);
                                    decrStackSize(METAL_SLOT, 1);
                                }
                                else
                                {
                                    carbonBurnTime++;
                                }
                            }
                        }
                    }
//                    if (worldObj.getTotalWorldTime() % 20 == 0)
//                    {
//                        worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
//                    }
                }
//                else
//                {
//                    //only have the client tick down... it will get updates every once in a while..
//                    if (worldObj.getTotalWorldTime() % 5 == 0)
//                    {
//                        if (fuelTime > 0) fuelTime--;
//                        if (carbonBurnTime < MAX_CARBON_TIME) carbonBurnTime++;
//                        if (metalBurnTime < MAX_METAL_TIME) metalBurnTime++;
//                    }
//                }
            }
        }
    }

    public boolean checkMultiBlockForm()
    {
        int i = 0;
        // Scan a 3x3x3 area, starting with the bottom left corner
        for (int x = xCoord - 1; x < xCoord + 2; x++)
            for (int y = yCoord; y < yCoord + 3; y++)
                for (int z = zCoord - 1; z < zCoord + 2; z++)
                {
                    TileEntity tile = worldObj.getTileEntity(x, y, z);
                    // Make sure tile isn't null, is an instance of the same Tile, and isn't already a part of a multiblock (if ours is already part of one)
                    if (tile != null && (tile instanceof TileEntityMetalForge))
                    {
                        if (this.isMaster())
                        {
                            if (((TileEntityMetalForge) tile).hasMaster())
                                i++;
                        }
                        else if (!((TileEntityMetalForge) tile).hasMaster())
                            i++;
                    }
                }
        // check if there are 26 blocks present ((3*3*3) - 1) and check that center block is empty
        return i == 26 && worldObj.isAirBlock(xCoord, yCoord + 1, zCoord);
    }

    public void setupStructure()
    {
        for (int x = xCoord - 1; x < xCoord + 2; x++)
            for (int y = yCoord; y < yCoord + 3; y++)
                for (int z = zCoord - 1; z < zCoord + 2; z++)
                {
                    TileEntity tile = worldObj.getTileEntity(x, y, z);
                    // Check if block is bottom center block
                    boolean master = (x == xCoord && y == yCoord && z == zCoord);
                    if (tile != null && (tile instanceof TileEntityMetalForge))
                    {
                        ((TileEntityMetalForge) tile).setMasterCoords(xCoord, yCoord, zCoord);
                        ((TileEntityMetalForge) tile).setHasMaster(true);
                        ((TileEntityMetalForge) tile).setIsMaster(master);

                        //Tell client about all the new info
                        worldObj.markBlockForUpdate(x, y, z);
                    }
                }
    }

    public void reset()
    {
        masterX = 0;
        masterY = 0;
        masterZ = 0;
        hasMaster = false;
        isMaster = false;
    }

    public boolean checkForMaster()
    {
        TileEntity tile = worldObj.getTileEntity(masterX, masterY, masterZ);
        return (tile != null && (tile instanceof TileEntityMetalForge));
    }

    public void resetStructure()
    {
        //        if (!isMaster && hasMaster) getMaster().resetStructure();
        //        else if (isMaster)
        //        {
        for (int x = xCoord - 1; x < xCoord + 2; x++)
            for (int y = yCoord; y < yCoord + 3; y++)
                for (int z = zCoord - 1; z < zCoord + 2; z++)
                {
                    TileEntity tile = worldObj.getTileEntity(x, y, z);
                    if (tile != null && (tile instanceof TileEntityMetalForge))
                        ((TileEntityMetalForge) tile).reset();
                    worldObj.markBlockForUpdate(x, y, z);
                }
        //        }
    }

    @Override
    public void writeToNBT(NBTTagCompound data)
    {
        super.writeToNBT(data);
        data.setInteger("masterX", masterX);
        data.setInteger("masterY", masterY);
        data.setInteger("masterZ", masterZ);
        data.setBoolean("hasMaster", hasMaster);
        data.setBoolean("isMaster", isMaster);
        if (hasMaster() && isMaster())
        {
            // Any other values should ONLY BE SAVED TO THE MASTER
            data.setInteger("fuelTime", fuelTime);
            data.setInteger("fuelMax", fuelMax);
            data.setInteger("carbonTime", carbonBurnTime);
            data.setInteger("metalTime", metalBurnTime);

            NBTTagList moltenList = new NBTTagList();
            for (Map.Entry<String, Integer> entry : fluids.entrySet())
            {
                NBTTagCompound tag = new NBTTagCompound();
                tag.setString("name", entry.getKey());
                tag.setInteger("amount", entry.getValue());
                moltenList.appendTag(tag);
            }
            data.setTag("molten", moltenList);

            NBTTagList inventoryList = new NBTTagList();
            for (int i=0;i<INV_SIZE;i++)
            {
                ItemStack stack=inventory[i];
                NBTTagCompound tag = new NBTTagCompound();
                if (stack != null)
                {
                    stack.writeToNBT(tag);
                    tag.setByte("Slot", (byte) i);
                }
                inventoryList.appendTag(tag);
            }
            data.setTag("inventory", inventoryList);
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound data)
    {
        super.readFromNBT(data);
        masterX = data.getInteger("masterX");
        masterY = data.getInteger("masterY");
        masterZ = data.getInteger("masterZ");
        hasMaster = data.getBoolean("hasMaster");
        isMaster = data.getBoolean("isMaster");
        if (hasMaster() && isMaster())
        {
            // Any other values should ONLY BE READ BY THE MASTER
            fuelMax = data.getInteger("fuelMax");
            fuelTime = data.getInteger("fuelTime");
            carbonBurnTime = data.getInteger("carbonTime");
            metalBurnTime = data.getInteger("metalTime");

            NBTTagList moltenList = data.getTagList("molten", 10);
            fluids.clear();
            for (int i = 0; i < moltenList.tagCount(); i++)
            {
                NBTTagCompound tag = moltenList.getCompoundTagAt(i);
                fluids.put(tag.getString("name"), tag.getInteger("amount"));
            }

            NBTTagList invList = data.getTagList("inventory", 10);
            for (int i = 0; i < invList.tagCount(); i++)
            {
                NBTTagCompound tag=invList.getCompoundTagAt(i);
                byte slot=tag.getByte("Slot");
                inventory[slot] = ItemStack.loadItemStackFromNBT(tag);
            }
        }
    }

    public boolean hasMaster()
    {
        return hasMaster;
    }

    public boolean isMaster()
    {
        return isMaster;
    }

    public int getMasterX()
    {
        return masterX;
    }

    public int getMasterY()
    {
        return masterY;
    }

    public int getMasterZ()
    {
        return masterZ;
    }

    public TileEntityMetalForge getMaster()
    {
        if (isMaster && hasMaster) return this; //save a step
        return hasMaster ? (TileEntityMetalForge) worldObj.getTileEntity(masterX, masterY, masterZ) : null;
    }

    public void setHasMaster(boolean bool)
    {
        hasMaster = bool;
    }

    public void setIsMaster(boolean bool)
    {
        isMaster = bool;
    }

    public void setMasterCoords(int x, int y, int z)
    {
        masterX = x;
        masterY = y;
        masterZ = z;
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int side)
    {
        return side == ForgeDirection.DOWN.ordinal() ? new int[] { OUTPUT_SLOT } : new int[] { METAL_SLOT, CARBON_SLOT, FUEL_SLOT };
    }

    @Override
    public boolean canInsertItem(int slot, ItemStack stack, int side)
    {
        if (side == ForgeDirection.DOWN.ordinal()) return false;
        return isItemValidForSlot(slot, stack);
    }

    @Override
    public boolean canExtractItem(int slot, ItemStack var2, int side)
    {
        return slot == OUTPUT_SLOT && side != ForgeDirection.UP.ordinal();
    }

    @Override
    public int getSizeInventory()
    {
        return INV_SIZE;
    }

    @Override
    public ItemStack getStackInSlot(int slot)
    {
        if (slot > INV_SIZE) return null;
        if (!isMaster && hasMaster) return getMaster().getStackInSlot(slot);
        return inventory[slot];
    }

    @Override
    public ItemStack decrStackSize(int slot, int amount)
    {
        if (!isMaster() && hasMaster())
            return getMaster().decrStackSize(slot, amount);

        if (isMaster)
        {
            ItemStack itemStack = getStackInSlot(slot);
            if (itemStack != null)
            {
                if (itemStack.stackSize <= amount)
                {
                    setInventorySlotContents(slot, null);
                }
                else
                {
                    itemStack = itemStack.splitStack(amount);
                    if (itemStack.stackSize == 0)
                    {
                        setInventorySlotContents(slot, null);
                    }
                }
            }
            return itemStack;
        }

        return null;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int slot)
    {
        if (!isMaster && hasMaster)
            return getMaster().getStackInSlotOnClosing(slot);

        if (isMaster)
        {
            ItemStack itemStack = getStackInSlot(slot);
            if (itemStack != null)
            {
                setInventorySlotContents(slot, null);
            }
            return itemStack;
        }

        return null;
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack stack)
    {
        if (!isMaster && hasMaster)
            getMaster().setInventorySlotContents(slot, stack);

        if (isMaster)
        {
            inventory[slot] = stack;
            if (stack != null && stack.stackSize > getInventoryStackLimit())
            {
                stack.stackSize = getInventoryStackLimit();
            }
        }
    }

    @Override
    public String getInventoryName()
    {
        return "container.metalForge";
    }

    @Override
    public boolean hasCustomInventoryName()
    {
        return false;
    }

    @Override
    public int getInventoryStackLimit()
    {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer var1)
    {
        return true;
    }

    @Override
    public void openInventory()
    {
    }

    @Override
    public void closeInventory()
    {
    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack stack)
    {
        if (stack.getItem().equals(Items.coal) && (slot != CARBON_SLOT && slot != FUEL_SLOT))
            return false;
        if (stack.getItem().equals(Items.iron_ingot) && (slot != METAL_SLOT))
            return false;
        if (TileEntityFurnace.isItemFuel(stack) && (slot != FUEL_SLOT))
            return false;
        if (slot >= OUTPUT_SLOT) return false;
        return true;
    }

    public void dropContents()
    {
        if (!isMaster && hasMaster) getMaster().dropContents();
        if (isMaster)
        {
            for (int i = 0; i < INV_SIZE; i++)
            {
                ItemStackHelper.spawnItemStackInWorld(getStackInSlot(i), worldObj, xCoord, yCoord, zCoord);
                setInventorySlotContents(i, null);
            }
        }
    }

    /* Packets */
    @Override
    public Packet getDescriptionPacket()
    {
        NBTTagCompound tag = new NBTTagCompound();
        writeToNBT(tag);
        return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, tag);
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet)
    {
        readFromNBT(packet.func_148857_g());
        worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
    }

    public static void registerMeltingItem(ItemStack stack, String moltenName, int moltenMB)
    {
        Item item = stack.getItem();
        meltingAmountRegistry.put(item, moltenMB);
        meltingNameRegistry.put(item, moltenName);
    }

    public int getScaledBurnTime(int scale)
    {
        if (fuelMax == 0) return 0;
        return fuelTime * scale / fuelMax;
    }

    public int getScaledMetalProgress(int scale)
    {
        return metalBurnTime * scale / MAX_METAL_TIME;
    }

    public int getScaledCarbonProgress(int scale)
    {
        return carbonBurnTime * scale / MAX_CARBON_TIME;
    }
}