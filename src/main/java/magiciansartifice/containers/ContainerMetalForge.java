package magiciansartifice.containers;

import magiciansartifice.containers.slot.SlotBurnable;
import magiciansartifice.containers.slot.SlotCarbon;
import magiciansartifice.containers.slot.SlotOutput;
import magiciansartifice.tileentities.machines.TileEntityMetalForge;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerMetalForge extends Container
{
    private TileEntityMetalForge forge;

    public ContainerMetalForge(EntityPlayer player, TileEntityMetalForge tile)
    {
        this.forge = tile;

        addSlotToContainer(new Slot(tile, TileEntityMetalForge.METAL_SLOT, 29, 18));
        addSlotToContainer(new SlotCarbon(tile, TileEntityMetalForge.CARBON_SLOT, 29, 50));
        addSlotToContainer(new SlotBurnable(tile, TileEntityMetalForge.FUEL_SLOT, 8, 41));
        addSlotToContainer(new SlotOutput(tile, TileEntityMetalForge.OUTPUT_SLOT, 140, 36));

        //Player inventory
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
        return this.forge.isUseableByPlayer(par1EntityPlayer);
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

            //            if (par2 < 13)
            //            {
            //                if (!this.mergeItemStack(itemstack1, 13, 49, false))
            //                {
            //                    return null;
            //                }
            //            }
            //            else
            if (!this.mergeItemStack(itemstack1, 0, 3, false))
            {
                return null;
            }

            if (itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack) null);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize)
            {
                return null;
            }

            slot.onPickupFromSlot(player, itemstack1);
        }

        return itemstack;
    }

    public void detectAndSendChanges()
    {
    }
}
