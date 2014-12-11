package magiciansartifice.main.tileentities.machines;

import magiciansartifice.main.core.utils.registries.ItemRegistry;
import magiciansartifice.main.tileentities.recipes.RecipesMysticAnvil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

@SuppressWarnings("unused")
public class TileEntityMysticAnvil extends TileEntity implements ISidedInventory, IInventory
{
    public ItemStack[] items = new ItemStack[13];
    public int facing;
    public static int HAMMER_HITS_TO_COMPLETE = 5;
    
    private String field_145958_o;
    private int hammerHits;
    private Item slot1;
    private Item slot2;
    
    public TileEntityMysticAnvil()
    {
    	hammerHits = 0;
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
        if (var1 == 1) {
            return true;
        }
        return false;
    }
    
    @Override
    public int[] getAccessibleSlotsFromSide(int var1)
    {
        return new int[0];
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
    public void updateEntity() { super.updateEntity(); }
    
    private void createMachine()
    {
        if (items[0] == null || items[1] == null) return;
        if (RecipesMysticAnvil.getRecipeFromStack(items[0], items[1]) != null)
        {
            ItemStack res = RecipesMysticAnvil.getRecipeFromStack(items[0], items[1]).getOutput();
            if (items[2] == null) items[2] = res.copy();
            else items[2].stackSize += res.stackSize;
            
            for (int i = 0; i < 2; i++)
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
        return hammerHits * scale / HAMMER_HITS_TO_COMPLETE;
    }
    
    public void hitWithHammer( World world, ItemStack hammer )
    {
    	if (hammerHits < HAMMER_HITS_TO_COMPLETE && RecipesMysticAnvil.getRecipeFromStack(items[0], items[1]) != null)
        {
            if (items[2] == null || (RecipesMysticAnvil.getRecipeFromStack(items[0], items[1]).getOutput().getItem().equals(items[2].getItem())))
            {
            	if( items[0].getItem() != slot1 || items[1].getItem() != slot2 )
            	{
            		hammerHits = 0;
            		slot1 = items[0].getItem();
            		slot2 = items[1].getItem();
            	}
            	
                hammerHits++;
                hammer.setItemDamage( hammer.getItemDamage() + 1 );  

                if( hammer.getItemDamage() >= hammer.getMaxDamage() )
            	{
            		hammer.stackSize = 0;
            	}
                
                world.playAuxSFX(1022, this.xCoord, this.yCoord, this.zCoord, 0);
                worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
            }
            else
            {
                hammerHits = 0;
            }
        }
    	
        if (RecipesMysticAnvil.getRecipeFromStack(items[0], items[1]) == null && hammerHits > 0)
        {
            hammerHits = 0;
        }
        
        if (hammerHits >= HAMMER_HITS_TO_COMPLETE)
        {
            hammerHits = 0;
            createMachine();
        }
        
        updateEntity();
    }
}
