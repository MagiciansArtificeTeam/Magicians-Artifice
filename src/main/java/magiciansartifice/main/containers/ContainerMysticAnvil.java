package magiciansartifice.main.containers;

import magiciansartifice.main.tileentities.machines.TileEntityMysticAnvil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;

@SuppressWarnings("unused")
public class ContainerMysticAnvil extends Container {
    private TileEntityMysticAnvil mysticAnvil;

    public ContainerMysticAnvil(EntityPlayer player, TileEntityMysticAnvil tile) {
        this.mysticAnvil = tile;
        addPlayerInv(player);
        addSlots(tile, player);
    }

    private void addPlayerInv(EntityPlayer player) {
        for (int i = 0; i < 9; i++) {
            addSlotToContainer(new Slot(player.inventory, i, 8 + i * 18, 142));
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                addSlotToContainer(new Slot(player.inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }
    }

    private void addSlots(TileEntityMysticAnvil tile, EntityPlayer player) {
        addSlotToContainer(new Slot(tile, 0, 35, 26));
        addSlotToContainer(new Slot(tile, 1, 57, 26));
        addSlotToContainer(new SlotFurnace(player, tile, 2, 124, 26));
        for (int i = 0; i < 9; i++) {
            addSlotToContainer(new Slot(tile, i + 3, 8 + i * 18, 53));
        }
    }
    
    public boolean canInteractWith(EntityPlayer par1EntityPlayer) {
        return this.mysticAnvil.isUseableByPlayer(par1EntityPlayer);
    }
    
	private boolean isUseableByPlayer(EntityPlayer player)
    {
        return true;
    }
    
    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int par2) {
        ItemStack itemstack = null;
        Slot slot = (Slot) this.inventorySlots.get(par2);

        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (par2 < 3) {
                if (!this.mergeItemStack(itemstack1, 3, 39, false)) { return null; }
            }
            else if (!this.mergeItemStack(itemstack1, 0, 2, false)) { return null; }

            if (itemstack1.stackSize == 0) {
                slot.putStack((ItemStack) null);
            } else {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize) { return null; }

            slot.onPickupFromSlot(player, itemstack1);
        }
        return itemstack;
    }
    
    public void detectAndSendChanges() {}
}
