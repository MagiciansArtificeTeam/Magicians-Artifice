package magiciansartifice.items;

import magiciansartifice.tileentities.recipes.RecipesMysticAnvil;
import magiciansartifice.tileentities.recipes.RecipesWandCarver;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ItemRecipeRegistry {
    public static void registerItem() {
        RecipesMysticAnvil.addRecipe(new ItemStack(Items.apple), new ItemStack(Items.arrow), new ItemStack(Blocks.dirt), new ItemStack(Items.diamond), 100);

        //wand recipes
        RecipesWandCarver.addRecipe(new ItemStack(ItemRegistry.chiselTool), new ItemStack(Blocks.log, 0, 1), new ItemStack(ItemRegistry.magiciansWand), 300);
    }
}
