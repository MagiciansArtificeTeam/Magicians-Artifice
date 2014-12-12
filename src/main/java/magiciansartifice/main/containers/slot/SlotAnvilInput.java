package magiciansartifice.main.containers.slot;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * Created by poppypoppop on 4/10/2014.
 */
public class SlotAnvilInput extends Slot {

    public SlotAnvilInput(IInventory inventory, int number, int xPos, int yPos) {
        super(inventory, number, xPos, yPos);
    }

    public boolean isItemValid(ItemStack par1ItemStack) {
        return true;
    }
}
