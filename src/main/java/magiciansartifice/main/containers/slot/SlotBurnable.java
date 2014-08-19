package magiciansartifice.main.containers.slot;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFurnace;

/**
 * Created by James Hollowell on 7/22/2014.
 */
public class SlotBurnable extends Slot
{
    public SlotBurnable(IInventory par1IInventory, int par2, int par3, int par4)
    {
        super(par1IInventory, par2, par3, par4);
    }

    @Override
    public boolean isItemValid(ItemStack par1ItemStack)
    {
        return TileEntityFurnace.isItemFuel(par1ItemStack);
    }
}
