package magiciansartifice.main.tileentities.machines;

import magiciansartifice.main.items.ItemRegistry;
import magiciansartifice.main.tileentities.recipes.Recipe3_1;
import magiciansartifice.main.tileentities.recipes.RecipesMysticAnvil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

@SuppressWarnings("unused")
public class TileEntityMysticAnvil extends TileEntity implements ISidedInventory, IInventory
{
    public ItemStack[] items = new ItemStack[13];
    public int facing;
    public int ticksLeft = 0;
    public int maxTicks = 0;
    
    private String field_145958_o;
    
    public TileEntityMysticAnvil()
    {
    }
    
    @Override
    public int getSizeInventory()
    {
        return 13;
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
        return "Magic Anvil";
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
        return true;
    }
    
    @Override
    public int[] getAccessibleSlotsFromSide(int var1)
    {
        return null;
    }
    
    @Override
    public boolean canInsertItem(int var1, ItemStack var2, int var3)
    {
        return true;
    }
    
    @Override
    public boolean canExtractItem(int var1, ItemStack var2, int var3)
    {
        return true;
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
        
        if (items[0] != null && items[1] != null && items[2] != null && ticksLeft == 0)
        {
            Recipe3_1 r = RecipesMysticAnvil.getRecipeFromStack(items[0], items[1], items[2]);
            if (r != null)
            {
                maxTicks = r.getTime();
            }
        }
        
        if (ticksLeft < maxTicks && RecipesMysticAnvil.getRecipeFromStack(items[0], items[1], items[2]) != null)
        {
            if (items[3] == null || (RecipesMysticAnvil.getRecipeFromStack(items[0], items[1], items[2]).getOutput().getItem().equals(items[3].getItem()) && RecipesMysticAnvil.getRecipeFromStack(items[0], items[1], items[2]).getOutput().getItemDamage() == items[3].getItemDamage()))
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
        if (RecipesMysticAnvil.getRecipeFromStack(items[0], items[1], items[2]) == null && ticksLeft > 0)
        {
            ticksLeft = 0;
            resetTimeAndTexture();
        }
        if (ticksLeft == maxTicks)
        {
            ticksLeft = 0;
            createMachine();
        }
    }
    
    private void createMachine()
    {
        if (items[0] == null || items[1] == null || items[2] == null) return;
        if (RecipesMysticAnvil.getRecipeFromStack(items[0], items[1], items[2]) != null)
        {
            ItemStack res = RecipesMysticAnvil.getRecipeFromStack(items[0], items[1], items[2]).getOutput();
            if (items[3] == null) items[3] = res.copy();
            else items[3].stackSize += res.stackSize;
            
            for (int i = 0; i <= 2; i++)
            {
                if (items[i].getItem() != ItemRegistry.forgeHammer) {
                    items[i].stackSize--;
                    if (items[i].stackSize <= 0) {
                        items[i] = null;
                    }
                } else {
                    items[i].damageItem(1, worldObj.getClosestPlayer(xCoord, yCoord, zCoord, 5D));
                }
            }
        }
    }
    
    public int getScaledProgress(int scale)
    {
        if (maxTicks == 0) return 0;
        return ticksLeft * scale / maxTicks;
    }
}
