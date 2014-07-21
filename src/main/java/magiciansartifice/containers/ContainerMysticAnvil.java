package magiciansartifice.containers;

import magiciansartifice.tileentities.machines.TileEntityMysticAnvil;
import magiciansartifice.tileentities.machines.TileEntityWandCarver;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityDispenser;

public class ContainerMysticAnvil extends Container
{
    private TileEntityMysticAnvil mysticAnvil;
    
    public ContainerMysticAnvil(EntityPlayer player, TileEntityMysticAnvil tile)
    {
        this.mysticAnvil = tile;
//        addSlotToContainer(new Slot(tile, 0, 13, 26));
//        addSlotToContainer(new Slot(tile, 1, 35, 26));
//        addSlotToContainer(new Slot(tile, 2, 57, 26));
//        addSlotToContainer(new SlotFurnace(player, tile, 3, 124, 26));
        for (int i = 0; i < 9; i++)
        {
            addSlotToContainer(new Slot(tile, i + 4, 8 + i * 18, 53));
        }
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                addSlotToContainer(new Slot(player.inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }
        for (int i = 0; i < 9; i++)
        {
            addSlotToContainer(new Slot(player.inventory, i, 8 + i * 18, 142));
        }
    }
    
    public boolean canInteractWith(EntityPlayer par1EntityPlayer)
    {
        return this.mysticAnvil.isUseableByPlayer(par1EntityPlayer);
    }
    
    private boolean isUseableByPlayer(EntityPlayer player)
    {
        return true;
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
            
            if (par2 < 13)
            {
                if (!this.mergeItemStack(itemstack1, 13, 45, true)) { return null; }
            }
            else if (!this.mergeItemStack(itemstack1, 0, 3, false) && !this.mergeItemStack(itemstack1, 4, 13, false)) { return null; }
            
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
    
    public void detectAndSendChanges()
    {
    }
}
