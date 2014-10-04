package magiciansartifice.main.containers.slot;

import magiciansartifice.main.items.ItemRegistry;
import net.minecraft.block.Block;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;

/**
 * Created by poppypoppop on 4/10/2014.
 */
public class SlotAnvilInput extends Slot {
    public static ArrayList<Block> blockInput = new ArrayList<Block>();
    public static ArrayList<Item> itemInput = new ArrayList<Item>();

    public SlotAnvilInput(IInventory inventory, int number, int xPos, int yPos) {
        super(inventory, number, xPos, yPos);
        for (int i = 0; i <= OreDictionary.getOres("steel").size(); i++) {
            itemInput.add(OreDictionary.getOres("ingotSteel").get(i).getItem());
        }
        itemInput.add(new ItemStack(ItemRegistry.dustsMeta, 1, 0).getItem());
    }

    public boolean isItemValid(ItemStack par1ItemStack) {
        for (Item item : itemInput) {
            if (item == par1ItemStack.getItem()) return true;
        }
        for (Block block : blockInput) {
            if (Item.getItemFromBlock(block) == par1ItemStack.getItem()) return true;
        }
        return false;
    }
}
