package magiciansartifice.compat.nei;

import codechicken.lib.gui.GuiDraw;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;
import magiciansartifice.client.guis.machines.GuiMetalForge;
import magiciansartifice.libs.ModInfo;
import magiciansartifice.tileentities.machines.TileEntityMetalForge;
import magiciansartifice.tileentities.recipes.MetalForgeMeltingRecipes;
import magiciansartifice.tileentities.recipes.RecipeMolten1_1;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by James Hollowell on 8/8/2014.
 */
public class MetalForgeMoltenHandler extends TemplateRecipeHandler
{
    class CachedMetalForgeMoltenRecipe extends CachedRecipe
    {
        private ItemStack input;
        private String output;
        private int outputAmount = 0;

        public CachedMetalForgeMoltenRecipe(ItemStack input, String output, int outputAmount)
        {
            this.input = input;
            this.output = output;
            this.outputAmount = outputAmount;
        }

        public CachedMetalForgeMoltenRecipe(RecipeMolten1_1 r)
        {
            this(r.getInput(), r.getOutput(), r.getOutputAmount());
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
            stacks.add(new PositionedStack(input, 34, 21));
            return stacks;
        }

        public ItemStack getInput()
        {
            return input;
        }

        public String getOutput()
        {
            return output;
        }

        public int getOutputAmount()
        {
            return outputAmount;
        }
    }

    @Override
    public String getGuiTexture()
    {
        return ModInfo.MODID + ":textures/guis/NEI/metalForgeMolten.png";
    }

    @Override
    public String getRecipeName()
    {
        return StatCollector.translateToLocal("metalForge.Molten");
    }

    @Override
    public void loadCraftingRecipes(String outputID, Object... results)
    {
        if ("item".equals(outputID) && results[0] instanceof String) loadCraftingRecipes((String) results[0]);
        else if ("allMAMolten".equals(outputID))
        {
            for (RecipeMolten1_1 r : MetalForgeMeltingRecipes.INSTANCE.getAllRecipes())
            {
                arecipes.add(new CachedMetalForgeMoltenRecipe(r));
            }
        }

    }

    public void loadCraftingRecipes(String result)
    {
        for (RecipeMolten1_1 r : MetalForgeMeltingRecipes.INSTANCE.getAllRecipes())
        {
            if (r.getOutput().equals(result))
                arecipes.add(new CachedMetalForgeMoltenRecipe(r));
        }
    }

    @Override
    public void loadUsageRecipes(String inputID, Object... ingredients)
    {
        if (ingredients.length == 0) return;
        if ("item".equals(inputID))
        {
            for (RecipeMolten1_1 r : MetalForgeMeltingRecipes.INSTANCE.getAllRecipes())
            {
                if (r.getInput().isItemEqual((ItemStack) ingredients[0]))
                    arecipes.add(new CachedMetalForgeMoltenRecipe(r));
            }
        }
    }

    @Override
    public void drawExtras(int recipe)
    {
        CachedMetalForgeMoltenRecipe r = (CachedMetalForgeMoltenRecipe) arecipes.get(recipe);
        int height = r.getOutputAmount() * 65 / TileEntityMetalForge.MAX_LIQUID_MB;
        GuiDraw.changeTexture(new ResourceLocation(ModInfo.MODID, "textures/fluid/" + r.getOutput() + ".png"));
        GuiDraw.drawTexturedModalRect(95, 64 - height, 0, 0, 30, height);
        //        GuiDraw.changeTexture(getGuiTexture());
        //        GuiDraw.drawTexturedModalRect(94, 0, 176, 30, 32, 72);
        GuiDraw.drawString(StatCollector.translateToLocal("nei.amount"), 130, 35, 0xF0F0F0);
        GuiDraw.drawString(StatCollector.translateToLocalFormatted("nei.amount2", r.getOutputAmount()), 131, 45, 0xF0F0F0);

        GuiDraw.drawString(StatCollector.translateToLocal("nei.molten"), 130, 10, 0xF0F0F0);
        GuiDraw.drawString(StatCollector.translateToLocal(r.getOutput()), 131, 20, 0xF0F0F0);
    }

    @Override
    public void loadTransferRects()
    {
        RecipeTransferRect rect = new RecipeTransferRect(new Rectangle(43, 7, 22, 15), "allMAMolten");
        RecipeTransferRect rect2 = new RecipeTransferRect(new Rectangle(43, 37, 22, 15), "allMAMolten");
        transferRects.add(rect);
        transferRects.add(rect2);
        List<Class<? extends GuiContainer>> guis = new ArrayList<Class<? extends GuiContainer>>();
        guis.add(GuiMetalForge.class);
        RecipeTransferRectHandler.registerRectsToGuis(guis, transferRects);
    }
}
