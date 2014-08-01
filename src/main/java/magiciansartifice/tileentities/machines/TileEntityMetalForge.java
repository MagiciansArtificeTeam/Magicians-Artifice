package magiciansartifice.tileentities.machines;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import magiciansartifice.network.PacketHandler;
import magiciansartifice.network.packet.FluidPacket;
import magiciansartifice.tileentities.recipes.RecipesMetalForge;
import magiciansartifice.tileentities.recipes.RecipesMolten2_1;
import magiciansartifice.utils.ItemStackHelper;
import net.minecraft.entity.player.EntityPlayer;
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
    public static final int FUEL_SLOT = 0;
    public static final int CARBON_SLOT = 1;
    public static final int METAL_SLOT = 2;
    public static final int OUTPUT_SLOT = 3;

    public static final int MAX_CARBON_TIME = 800;//1600;
    public static final int MAX_METAL_TIME = 800;//1600;
    public static final int MAX_COOL_TIME = 1600;//6400;

    public static final int INGOT_MB = 144;
    public static final int BLOCK_MB = INGOT_MB * 9;
    public static final int MAX_LIQUID_MB = BLOCK_MB * 4;

    private static final HashMap<Item, Integer> meltingAmountRegistry = new HashMap<Item, Integer>();
    private static final HashMap<Item, String> meltingNameRegistry = new HashMap<Item, String>();

    //Inventory variables
    private ItemStack[] inventory = new ItemStack[INV_SIZE];
    public final Map<String, Integer> fluids = new HashMap<String, Integer>();

    //Functional variables
    public int fuelTime = 0;
    public int fuelMax = 0;
    public int carbonBurnTime = 0;
    public int metalBurnTime = 0;
    public int coolTime = 0;
    private RecipesMolten2_1 currentRecipe = null;
    @SideOnly(Side.CLIENT)
    public boolean needsFluidUpdate;

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
                        if (fuelBurnTime > 0 && (inventory[METAL_SLOT] != null || inventory[CARBON_SLOT] != null))
                        {
                            fuelTime += fuelBurnTime + 1;
                            fuelMax = fuelBurnTime + 1;
                            decrStackSize(FUEL_SLOT, 1);
                        }
                        else
                        {
                            setMBSides(false);
                        }
                    }
                    else
                    {
                        fuelTime--;
                        setMBSides(true);
                        if (getStackInSlot(METAL_SLOT) != null)
                        {
                            metalBurnTime++;
                            if (metalBurnTime + 1 == MAX_METAL_TIME)
                            {
                                metalBurnTime = 0;
                                melt(METAL_SLOT);
                            }
                        }
                        else
                        {
                            metalBurnTime = 0;
                        }

                        if (getStackInSlot(CARBON_SLOT) != null)
                        {
                            carbonBurnTime++;
                            if (carbonBurnTime == MAX_CARBON_TIME)
                            {
                                carbonBurnTime = 0;
                                melt(CARBON_SLOT);
                            }
                        }
                        else
                        {
                            carbonBurnTime = 0;
                        }

                    }

                    if (getStackInSlot(METAL_SLOT) == null)
                    {
                        metalBurnTime = 0;
                    }

                    if (getStackInSlot(CARBON_SLOT) == null)
                    {
                        carbonBurnTime = 0;
                    }

                    if (!fluids.entrySet().isEmpty())
                    {
                        if (currentRecipe != null || canCraft())
                        {
                            if (coolTime == MAX_COOL_TIME)
                            {
                                //Create output
                                craft();
                                currentRecipe = null;
                                coolTime = 0;
                            }
                            else
                            {
                                coolTime++;
                            }
                        }
                    }
                }
            }
        }
    }

    /*
     * ----------------------------------------------------------------------------------------
     *                          Multi-block Functions
     * ----------------------------------------------------------------------------------------
     */
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
        setMBSides(false);
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
        dropContents();
        carbonBurnTime = 0;
        metalBurnTime = 0;
        fuelMax = 0;
        fuelTime = 0;
        fluids.clear();
        for (int x = xCoord - 1; x < xCoord + 2; x++)
            for (int y = yCoord; y < yCoord + 3; y++)
                for (int z = zCoord - 1; z < zCoord + 2; z++)
                {
                    TileEntity tile = worldObj.getTileEntity(x, y, z);
                    if (tile != null && (tile instanceof TileEntityMetalForge))
                        ((TileEntityMetalForge) tile).reset();
                    worldObj.markBlockForUpdate(x, y, z);
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

    public void setMBSides(boolean onoff)
    {
        if (onoff)
        {
            worldObj.setBlockMetadataWithNotify(xCoord + 1, yCoord + 1, zCoord, 3, 3);
            worldObj.setBlockMetadataWithNotify(xCoord - 1, yCoord + 1, zCoord, 3, 3);
            worldObj.setBlockMetadataWithNotify(xCoord, yCoord + 1, zCoord + 1, 3, 3);
            worldObj.setBlockMetadataWithNotify(xCoord, yCoord + 1, zCoord - 1, 3, 3);
        }
        else
        {
            worldObj.setBlockMetadataWithNotify(xCoord + 1, yCoord + 1, zCoord, 2, 3);
            worldObj.setBlockMetadataWithNotify(xCoord - 1, yCoord + 1, zCoord, 2, 3);
            worldObj.setBlockMetadataWithNotify(xCoord, yCoord + 1, zCoord + 1, 2, 3);
            worldObj.setBlockMetadataWithNotify(xCoord, yCoord + 1, zCoord - 1, 2, 3);
        }
    }

    /*
     * ----------------------------------------------------------------------------------------
     *                                      NBT Functions
     * ----------------------------------------------------------------------------------------
     */
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
            data.setInteger("coolTime", coolTime);

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
            for (int i = 0; i < INV_SIZE; i++)
            {
                ItemStack stack = inventory[i];
                NBTTagCompound tag = new NBTTagCompound();
                if (stack != null)
                {
                    stack.writeToNBT(tag);
                    tag.setByte("Slot", (byte) i);
                    inventoryList.appendTag(tag);
                }

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
            coolTime = data.getInteger("coolTime");

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
                NBTTagCompound tag = invList.getCompoundTagAt(i);
                byte slot = tag.getByte("Slot");
                inventory[slot] = ItemStack.loadItemStackFromNBT(tag);
            }
        }
    }

    /*
     * ----------------------------------------------------------------------------------------
     *                                      IInventory Functions
     * ----------------------------------------------------------------------------------------
     */

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
        if (slot >= OUTPUT_SLOT) return false;
        if (slot == FUEL_SLOT && TileEntityFurnace.isItemFuel(stack))
            return true;
        for (Item comp : meltingNameRegistry.keySet())
        {
            if (stack.getItem().equals(comp) && (slot == CARBON_SLOT || slot == METAL_SLOT))
                return true;
        }
        return false;
    }

    public void dropContents()
    {
        if (!isMaster && hasMaster) getMaster().dropContents();
        if (isMaster)
        {
            for (int i = 0; i < INV_SIZE; i++)
            {
                ItemStackHelper.spawnItemStackInWorld(getStackInSlot(i), worldObj, xCoord, yCoord + 1, zCoord);
                setInventorySlotContents(i, null);
            }
        }
    }

    /*
     * ----------------------------------------------------------------------------------------
     *                                  Packet Functions
     * ----------------------------------------------------------------------------------------
     */
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

    /*
     * ----------------------------------------------------------------------------------------
     *                                 Crafting Functions
     * ----------------------------------------------------------------------------------------
     */

    public static void registerMeltingItem(ItemStack stack, String moltenName, int moltenMB)
    {
        Item item = stack.getItem();
        meltingAmountRegistry.put(item, moltenMB);
        meltingNameRegistry.put(item, moltenName);
    }

    private boolean canCraft()
    {
        for (int main = 0; main < fluids.entrySet().size(); main++)
        {
            for (int sub = 0; sub < fluids.entrySet().size(); sub++)
            {
                if (sub == main) continue;
                RecipesMolten2_1 r = RecipesMetalForge.getRecipeFromStack((String) fluids.keySet().toArray()[main], (String) fluids.keySet().toArray()[sub]);
                if (r != null)
                {
                    Integer amt1 = fluids.get(r.getInput1());
                    Integer amt2 = fluids.get(r.getInput2());
                    if (amt1 >= r.getAmount1() && amt2 >= r.getAmount2() && (getStackInSlot(OUTPUT_SLOT) == null
                            || (getStackInSlot(OUTPUT_SLOT).isItemEqual(r.getOutput())
                            && getStackInSlot(OUTPUT_SLOT).stackSize + r.getOutput().stackSize < getStackInSlot(OUTPUT_SLOT).getMaxStackSize())))
                    {
                        currentRecipe = r;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void craft()
    {
        Integer amount1 = fluids.get(currentRecipe.getInput1());
        Integer amount2 = fluids.get(currentRecipe.getInput2());
        amount1 -= currentRecipe.getAmount1();
        amount2 -= currentRecipe.getAmount2();
        fluids.put(currentRecipe.getInput1(), amount1);
        fluids.put(currentRecipe.getInput2(), amount2);
        PacketHandler.INSTANCE.sendToAll(new FluidPacket(currentRecipe.getInput1(), amount1, xCoord, yCoord, zCoord));
        PacketHandler.INSTANCE.sendToAll(new FluidPacket(currentRecipe.getInput2(), amount2, xCoord, yCoord, zCoord));

        if (getStackInSlot(OUTPUT_SLOT) != null)
            getStackInSlot(OUTPUT_SLOT).stackSize += currentRecipe.getOutput().stackSize;
        else
            setInventorySlotContents(OUTPUT_SLOT, currentRecipe.getOutput().copy());
    }

    private void melt(int slot)
    {
        String name = meltingNameRegistry.get(getStackInSlot(slot).getItem());
        Integer currentMolten = fluids.get(name);
        currentMolten = currentMolten == null ? 0 : currentMolten;//null check
        int newMolten = meltingAmountRegistry.get(getStackInSlot(slot).getItem());
        fluids.put(name, currentMolten + newMolten);
        PacketHandler.INSTANCE.sendToAll(new FluidPacket(name, currentMolten + newMolten, xCoord, yCoord, zCoord));
        decrStackSize(slot, 1);
    }

    /*
     * ----------------------------------------------------------------------------------------
     *                                  Scaled (Gui) Functions
     * ----------------------------------------------------------------------------------------
     */
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

    public int getScaledCoolingProgress(int scale)
    {
        return coolTime * scale / MAX_COOL_TIME;
    }
}