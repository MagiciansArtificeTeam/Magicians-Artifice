package magiciansartifice.items;

import magiciansartifice.tileentities.recipes.RecipesMysticAnvil;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ItemRecipeRegistry {
    public static void registerItem() {
        RecipesMysticAnvil.addRecipe(new ItemStack(Items.apple), new ItemStack(Items.arrow), new ItemStack(Blocks.dirt), new ItemStack(Items.diamond), 100);
    }
}
