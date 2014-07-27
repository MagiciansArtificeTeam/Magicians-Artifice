package magiciansartifice.utils;

import cpw.mods.fml.common.registry.GameRegistry;
import magiciansartifice.blocks.BlockRegistry;
import magiciansartifice.items.ItemRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;

/**
 * Created by poppypoppop on 23/07/2014.
 */
public class RecipeRegistry {
    private static void registerItems() {
        //book
        GameRegistry.addShapelessRecipe(new ItemStack(ItemRegistry.book), new ItemStack(ItemRegistry.dustsMeta, 1, 1), Items.book);
    }

    private static void registerBlocks() {
        //machines
        GameRegistry.addRecipe(new ItemStack(BlockRegistry.mysticAnvil), new Object[] { "WWW", "IAI", "III", 'W', new ItemStack(Blocks.wool, 1, 14), 'A', Blocks.anvil, 'I', Items.iron_ingot});
        GameRegistry.addRecipe(new ItemStack(BlockRegistry.metalForge, 8), new Object[] { "BBB", "BIB", "BBB", 'B', Blocks.stonebrick, 'I', Blocks.iron_block});

        //storage blocks
        GameRegistry.addRecipe(new ItemStack(BlockRegistry.storage, 1, 0), new Object[] { "XXX", "XXX", "XXX", 'X', new ItemStack(ItemRegistry.dustsMeta, 1, 0)});
        GameRegistry.addRecipe(new ItemStack(BlockRegistry.storage, 1, 1), new Object[] { "XXX", "XXX", "XXX", 'X', new ItemStack(ItemRegistry.dustsMeta, 1, 1)});
        GameRegistry.addRecipe(new ItemStack(BlockRegistry.storage, 1, 2), new Object[] { "XXX", "XXX", "XXX", 'X', new ItemStack(ItemRegistry.dustsMeta, 1, 2)});
        GameRegistry.addRecipe(new ItemStack(BlockRegistry.storage, 1, 3), new Object[] { "XXX", "XXX", "XXX", 'X', new ItemStack(ItemRegistry.ingotsMeta, 1, 0)});
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockRegistry.storage, 1, 4), new Object[] {"XXX", "XXX", "XXX", 'X', "ingotSteel"}));
    }

    public static void registerModRecipes() {
        registerItems();
        registerBlocks();
    }
}
