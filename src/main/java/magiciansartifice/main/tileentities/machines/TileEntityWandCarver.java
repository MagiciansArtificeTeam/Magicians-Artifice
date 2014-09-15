package magiciansartifice.main.tileentities.machines;

import magiciansartifice.main.items.tools.ItemToolChisel;
import magiciansartifice.main.tileentities.recipes.Recipes2_1;
import magiciansartifice.main.tileentities.recipes.RecipesWandCarver;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraftforge.common.util.ForgeDirection;

@SuppressWarnings("unused")
public class TileEntityWandCarver extends TileEntity implements ISidedInventory, IInventory
{
    
    public ItemStack[] items = new ItemStack[4];
    public int facing;
    public int ticksLeft = 0;
    public int maxTicks = 0;

    private final int upDirection = ForgeDirection.UP.ordinal();
    private final int downDirection = ForgeDirection.DOWN.ordinal();
    
    private String field_145958_o;
    
    public TileEntityWandCarver()
    {
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
    public String getInventoryName()
    {
        return "Wand Carver";
    }
    
    @Override
    public boolean hasCustomInventoryName()
    {
        return true;
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
    public boolean isItemValidForSlot(int var1, ItemStack var2)
    {
        if (var1 == 1) {
            return true;
        }
        return false;
    }
    
    @Override
    public int[] getAccessibleSlotsFromSide(int var1)
    {
        if (var1 == 1) {
            return new int[]{1};
        } else if (var1 == 0) {
            return new int[]{2};
        } else {
            return new int[]{0};
        }
    }
    
    @Override
    public boolean canInsertItem(int var1, ItemStack var2, int var3)
    {
        if (var3 == ForgeDirection.UP.ordinal()) {
            if (var1 == 1) {
                return true;
            }
        } else if (var3 != ForgeDirection.DOWN.ordinal()) {
            if (var1 == 0) {
                if (var2 != null && var2.getItem() instanceof ItemToolChisel) {
                    return true;
                }
            }
        }
            return false;
    }
    
    @Override
    public boolean canExtractItem(int var1, ItemStack var2, int var3)
    {
        if (var3 == ForgeDirection.DOWN.ordinal()) {
            if (var1 == 2) {
                return true;
            }
        }
        return false;
    }
    
    public void func_145951_a(String displayName)
    {
        this.field_145958_o = displayName;
    }
    
    public void resetTimeAndTexture()
    {
        ticksLeft = 0;
    }
    
    @Override
    public void updateEntity()
    {
        super.updateEntity();
        
        if (items[0] != null && items[1] != null && items[2] == null && ticksLeft == 0)
        {
            Recipes2_1 r = RecipesWandCarver.getRecipeFromStack(items[0], items[1]);
            if (r != null)
            {
                maxTicks = r.getTime();
            }
        }
        
        if (ticksLeft < maxTicks && RecipesWandCarver.getRecipeFromStack(items[0], items[1]) != null)
        {
            if (items[2] == null || (RecipesWandCarver.getRecipeFromStack(items[0], items[1]).getOutput().getItem().equals(items[2].getItem()) && RecipesWandCarver.getRecipeFromStack(items[0], items[1]).getOutput() == items[2]))
            {
                ticksLeft++;
                worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
            }
            else
            {
                ticksLeft = 0;
                resetTimeAndTexture();
            }
        }
        if (RecipesWandCarver.getRecipeFromStack(items[0], items[1]) == null && ticksLeft > 0)
        {
            ticksLeft = 0;
            resetTimeAndTexture();
        }
        if (ticksLeft == maxTicks)
        {
            ticksLeft = 0;
            carveWand();
        }
    }
    
    private void carveWand()
    {
        if (items[0] == null || items[1] == null) {
            return;
        }
        if (RecipesWandCarver.getRecipeFromStack(items[0], items[1]) != null)
        {
            ItemStack res = RecipesWandCarver.getRecipeFromStack(items[0], items[1]).getOutput();

            if (res != null) {
            	if (items[2] == null) {
                    items[2] = res.copy();
                }
                this.markDirty();
                
                items[1].stackSize--;
                if (items[1].stackSize <= 0) {
                	items[1] = null;
                }
                items[0].damageItem(10, (EntityLivingBase)worldObj.getClosestPlayer(xCoord, yCoord, zCoord, 50D));
                if (items[0].getItemDamage() >= 100) {
                	items[0] = null;
                }
            	this.markDirty();
            }
        }
    }
    
    public int getScaledProgress(int scale)
    {
        if (maxTicks == 0) return 0;
        return ticksLeft * scale / maxTicks;
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
}
