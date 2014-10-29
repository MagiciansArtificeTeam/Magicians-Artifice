package magiciansartifice.main.tileentities.magic;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * Created by Mitchellbrine on 2014.
 */
public class TileEntitySpellTable extends TileEntity implements ISidedInventory {

    private ItemStack[] inventory = new ItemStack[1];

    @Override
    public int[] getAccessibleSlotsFromSide(int side)
    {
        return side == ForgeDirection.DOWN.ordinal() ? new int[] { 0 } : null;
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
        return slot == 0 && side != ForgeDirection.UP.ordinal();
    }

    @Override
    public int getSizeInventory()
    {
        return 1;
    }

    @Override
    public ItemStack getStackInSlot(int slot)
    {
        if (slot > 1) return null;
        return inventory[slot];
    }

    @Override
    public ItemStack decrStackSize(int slot, int amount)
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

    @Override
    public ItemStack getStackInSlotOnClosing(int slot)
    {
            ItemStack itemStack = getStackInSlot(slot);
            if (itemStack != null)
            {
                setInventorySlotContents(slot, null);
            }
            return itemStack;
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack stack)
    {
            inventory[slot] = stack;
            if (stack != null && stack.stackSize > getInventoryStackLimit())
            {
                stack.stackSize = getInventoryStackLimit();
            }
    }

    @Override
    public String getInventoryName()
    {
        return "container.spellTable";
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
        return true;
    }

    /*
    * ----------------------------------------------
    *                   Packet Stuff
    *
    * ----------------------------------------------
    * */


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
     * ---------------------------------------------
     *             Reading/Write Stuff
     *
     * ---------------------------------------------
     */

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        NBTTagList invList = nbt.getTagList("inventory", 10);
        for (int i = 0; i < invList.tagCount(); i++)
        {
            NBTTagCompound tag = invList.getCompoundTagAt(i);
            byte slot = tag.getByte("Slot");
            inventory[slot] = ItemStack.loadItemStackFromNBT(tag);
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        NBTTagList inventoryList = new NBTTagList();
        for (int i = 0; i < 1; i++)
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
        nbt.setTag("inventory", inventoryList);
    }

}
