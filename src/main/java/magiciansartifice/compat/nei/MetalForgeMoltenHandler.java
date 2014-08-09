package magiciansartifice.compat.nei;

import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;
import magiciansartifice.libs.ModInfo;
import magiciansartifice.tileentities.machines.TileEntityMetalForge;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by James Hollowell on 8/8/2014.
 */
public class MetalForgeMoltenHandler extends TemplateRecipeHandler
{
    class CachedMetalForgeMoltenRecipie extends CachedRecipe
    {
        private ItemStack input;
        private String output;

        public CachedMetalForgeMoltenRecipie(ItemStack input, String output)
        {
            this.input = input;
            this.output = output;
        }

        @Override
        public PositionedStack getResult()
        {
            return null;
        }

        @Override
        public List<PositionedStack> getIngredients()
        {
            ArrayList<PositionedStack> stacks = new ArrayList<PositionedStack>();
            stacks.add(new PositionedStack(input, 50, 23));
            return stacks;
        }
    }

    @Override
    public String getGuiTexture()
    {
        return ModInfo.MODID + ":textures/guis/NEI/metalForgeMolten";
    }

    @Override
    public String getRecipeName()
    {
        return StatCollector.translateToLocal("metalForge.Molten");
    }

    @Override
    public void loadCraftingRecipes(String outputID, Object... results)
    {
        if("item".equals(outputID)) return;

    }

    public void loadCraftingRecipes(String result)
    {

    }
}
