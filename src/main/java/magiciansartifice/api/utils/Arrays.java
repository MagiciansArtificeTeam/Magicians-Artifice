package magiciansartifice.api.utils;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;

/**
 * Created by poppypoppop on 10/12/2014.
 */
public class Arrays {

    public static ArrayList<Item> blockBlackList = new ArrayList<Item>();
    public static ArrayList<ItemStack> solidBlocks = new ArrayList<ItemStack>();
    public static ArrayList<ItemStack> nonSolidBlocks = new ArrayList<ItemStack>();

    public static void assignCrumblingItems() {
        for (int i = 0; i <= 3; i++) {
            solidBlocks.add(new ItemStack(Blocks.stonebrick, 1, i));
        }
        solidBlocks.add(new ItemStack(Blocks.cobblestone, 1, 0));
        solidBlocks.add(new ItemStack(Blocks.gravel, 1, 0));
        solidBlocks.add(new ItemStack(Blocks.mossy_cobblestone, 1, 0));
        solidBlocks.add(new ItemStack(Blocks.stone, 1, 0));
        nonSolidBlocks.add(new ItemStack(Blocks.stone_slab, 1, 3));
        nonSolidBlocks.add(new ItemStack(Blocks.stone_slab, 1, 5));
        for (int i = 0; i <= 3; i++) {
            nonSolidBlocks.add(new ItemStack(Blocks.stone_brick_stairs, 1, i));
        }
        for (int i = 0; i <= 3; i++) {
            nonSolidBlocks.add(new ItemStack(Blocks.stone_stairs, 1, i));
        }
    }

    public static void addBlacklistBlocks() {
        blockBlackList.add(Item.getItemFromBlock(Blocks.water));
        blockBlackList.add(Item.getItemFromBlock(Blocks.leaves));
        blockBlackList.add(Item.getItemFromBlock(Blocks.leaves2));
        for (int i = 0; i < OreDictionary.getOres("treeLeaves").size(); i++) {
            blockBlackList.add(OreDictionary.getOres("treeLeaves").get(i).getItem());
        }
    }
}
