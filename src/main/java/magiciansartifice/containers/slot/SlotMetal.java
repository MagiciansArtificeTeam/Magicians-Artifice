package magiciansartifice.containers.slot;

import magiciansartifice.tileentities.machines.TileEntityMetalForge;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * Created by James Hollowell on 7/30/2014.
 */
public class SlotMetal extends Slot
{
    public SlotMetal(IInventory par1IInventory, int par2, int par3, int par4)
    {
        super(par1IInventory, par2, par3, par4);
    }

    @Override
    public boolean isItemValid(ItemStack stack)
    {
        return inventory.isItemValidForSlot(TileEntityMetalForge.CARBON_SLOT,stack);
    }
}
