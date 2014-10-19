package magiciansartifice.main.containers;

import magiciansartifice.main.tileentities.machines.TileEntityWandCarver;
import magiciansartifice.main.tileentities.machines.TileEntityWandMaker;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;

/**
 * Created by poppypoppop on 21/07/2014.
 */
public class ContainerWandMaker extends Container
{
    public ContainerWandMaker(EntityPlayer player, TileEntityWandMaker entity)
    {
        createSlots(entity, player);
        bindPlayerInventory(player.inventory);
    }
    
    @Override
    public boolean canInteractWith(EntityPlayer player)
    {
        return this.isUseableByPlayer(player);
    }
    
    private boolean isUseableByPlayer(EntityPlayer player)
    {
        return true;
    }
    
    private void createSlots(TileEntityWandMaker tile, EntityPlayer player)
    {
        addSlotToContainer(new Slot(tile, 0, 14, 34));
        addSlotToContainer(new Slot(tile, 1, 39, 34));
        addSlotToContainer(new Slot(tile, 2, 64, 34));
        addSlotToContainer(new SlotFurnace(player, tile, 3, 129, 34));
    }
    
    private void bindPlayerInventory(InventoryPlayer inv)
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                addSlotToContainer(new Slot(inv, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }
        for (int i = 0; i < 9; i++)
        {
            addSlotToContainer(new Slot(inv, i, 8 + i * 18, 142));
        }
    }
    
    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int par2)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot) this.inventorySlots.get(par2);
        
        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            
            if (par2 < 3)
            {
                if (!this.mergeItemStack(itemstack1, 3, 39, false)) { return null; }
            }
            else if (!this.mergeItemStack(itemstack1, 0, 2, false)) { return null; }
            
            if (itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack) null);
            }
            else
            {
                slot.onSlotChanged();
            }
            
            if (itemstack1.stackSize == itemstack.stackSize) { return null; }
            
            slot.onPickupFromSlot(player, itemstack1);
        }        
        return itemstack;
    }
}
