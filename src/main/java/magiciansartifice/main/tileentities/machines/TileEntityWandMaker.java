package magiciansartifice.main.tileentities.machines;

import magiciansartifice.api.modifiers.BasicWandCore;
import magiciansartifice.api.modifiers.BasicWandHandle;
import magiciansartifice.api.modifiers.BasicWandStick;
import magiciansartifice.main.core.utils.OreDictHandler;
import magiciansartifice.main.items.ItemRegistry;
import magiciansartifice.main.tileentities.recipes.Recipes2_1;
import magiciansartifice.main.tileentities.recipes.RecipesWandCarver;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Created by poppypoppop on 11/10/2014.
 */
@SuppressWarnings("unused")
public class TileEntityWandMaker extends TileEntity implements ISidedInventory,IInventory{

    public ItemStack[] items = new ItemStack[4];

    @Override
    public int[] getAccessibleSlotsFromSide(int slot) {
        return new int[0];
    }

    @Override
    public boolean canInsertItem(int p_102007_1_, ItemStack p_102007_2_, int p_102007_3_) {
        return false;
    }

    @Override
    public boolean canExtractItem(int p_102008_1_, ItemStack p_102008_2_, int p_102008_3_) {
        return false;
    }

    @Override
    public int getSizeInventory()
    {
        return 4;
    }

    @Override
    public ItemStack getStackInSlot(int var1)
    {
        return this.items[var1];
    }

    @Override
    public String getInventoryName()
    {
        return "Wand Fabricator";
    }

    @Override
    public boolean hasCustomInventoryName()
    {
        return true;
    }


    @Override
    public ItemStack decrStackSize(int var1, int var2)
    {
        if (this.items[var1] != null)
        {
            ItemStack itemstack;

            if (this.items[var1].stackSize <= var2)
            {
                itemstack = this.items[var1];
                this.items[var1] = null;
                this.markDirty();
                return itemstack;
            }
            else
            {
                itemstack = this.items[var1].splitStack(var2);
                if (this.items[var1].stackSize == 0)
                {
                    this.items[var1] = null;
                }

                this.markDirty();
                return itemstack;
            }
        }
        else
        {
            return null;
        }
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int var1)
    {
        if (this.items[var1] != null)
        {
            ItemStack itemstack = this.items[var1];
            this.items[var1] = null;
            return itemstack;
        }
        else
        {
            return null;
        }
    }

    @Override
    public void setInventorySlotContents(int var1, ItemStack var2)
    {
        this.items[var1] = var2;

        if (var2 != null && var2.stackSize > this.getInventoryStackLimit())
        {
            var2.stackSize = this.getInventoryStackLimit();
        }

        this.markDirty();
    }

    public int func_146019_a(ItemStack p_146019_1_)
    {
        for (int i = 0; i < this.items.length; ++i)
        {
            if (this.items[i] == null || this.items[i].getItem() == null)
            {
                this.setInventorySlotContents(i, p_146019_1_);
                return i;
            }
        }

        return -1;
    }

    @Override
    public int getInventoryStackLimit() {
        return 1;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer var1) {
        return true;
    }

    @Override
    public void openInventory() {}

    @Override
    public void closeInventory() {}

    @Override
    public boolean isItemValidForSlot(int var1, ItemStack var2)
    {
        if (var1 == 1) {
            return true;
        }
        return false;
    }

    public void readFromNBT(NBTTagCompound p_145839_1_)
    {
        super.readFromNBT(p_145839_1_);
        NBTTagList nbttaglist = p_145839_1_.getTagList("Items", 10);
        this.items = new ItemStack[this.getSizeInventory()];

        for (int i = 0; i < nbttaglist.tagCount(); ++i)
        {
            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
            byte b0 = nbttagcompound1.getByte("Slot");

            if (b0 >= 0 && b0 < this.items.length)
            {
                this.items[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
            }
        }
    }

    public void writeToNBT(NBTTagCompound p_145841_1_)
    {
        super.writeToNBT(p_145841_1_);
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < this.items.length; ++i)
        {
            if (this.items[i] != null)
            {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte)i);
                this.items[i].writeToNBT(nbttagcompound1);
                nbttaglist.appendTag(nbttagcompound1);
            }
        }

        p_145841_1_.setTag("Items", nbttaglist);
    }

    @Override
    public void updateEntity() {
        super.updateEntity();

        if (items[0] != null && items[1] != null && items[2] != null && items[0].getItem() instanceof BasicWandHandle && items[1].getItem() instanceof BasicWandStick && items[2].getItem() instanceof BasicWandCore) {
            if (items[3] == null) {
                ItemStack newStack = new ItemStack(ItemRegistry.wand);
                NBTTagCompound nbt = new NBTTagCompound();
                nbt.setString("wandHandle",items[0].getItem().getUnlocalizedName());
                nbt.setString("wandStick",items[1].getItem().getUnlocalizedName());
                nbt.setString("wandCore",items[2].getItem().getUnlocalizedName());
                newStack.setTagCompound(nbt);
                items[3] = newStack.copy();
                items[0] = null;
                items[1] = null;
                items[2] = null;
                EntityPlayer player = worldObj.getClosestPlayer(xCoord,yCoord,zCoord,10);
                if (player != null) {
                    worldObj.playSoundAtEntity(player,"ambient.weather.thunder",1.0F,1.0F);
                }
            }
        }


    }


    }
