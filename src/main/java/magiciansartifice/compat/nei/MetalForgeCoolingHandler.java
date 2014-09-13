package magiciansartifice.compat.nei;

import codechicken.lib.gui.GuiDraw;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;
import magiciansartifice.client.guis.machines.GuiMetalForge;
import magiciansartifice.libs.ModInfo;
import magiciansartifice.tileentities.machines.TileEntityMetalForge;
import magiciansartifice.tileentities.recipes.MetalForgeCoolingRecipes;
import magiciansartifice.tileentities.recipes.MetalForgeMeltingRecipes;
import magiciansartifice.tileentities.recipes.RecipeMolten1_1;
import magiciansartifice.tileentities.recipes.RecipeMolten2_1;
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
public class MetalForgeCoolingHandler extends TemplateRecipeHandler
{
    class CachedMetalForgeCoolingRecipe extends CachedRecipe
    {
        private String input1;
        private int inputAmt1 = 0;
        private String input2;
        private int inputAmt2 = 0;
        private ItemStack output;

        CachedMetalForgeCoolingRecipe(String input1, int inputAmt1, String input2, int inputAmt2, ItemStack output)
        {
            this.input1 = input1;
            this.inputAmt1 = inputAmt1;
            this.input2 = input2;
            this.inputAmt2 = inputAmt2;
            this.output = output;
        }

        public CachedMetalForgeCoolingRecipe(RecipeMolten2_1 r)
        {
            this(r.getInput1(), r.getAmount1(), r.getInput2(), r.getAmount2(), r.getOutput());
        }

        @Override
        public PositionedStack getResult()
        {
            return new PositionedStack(output, 130, 31);
        }

        @Override
        public List<PositionedStack> getIngredients()
        {
            return null;
        }

        public String getInput1()
        {
            return input1;
        }

        public int getInputAmt1()
        {
            return inputAmt1;
        }

        public String getInput2()
        {
            return input2;
        }

        public int getInputAmt2()
        {
            return inputAmt2;
        }

        public ItemStack getOutput()
        {
            return output;
        }
    }

    @Override
    public String getGuiTexture()
    {
        return ModInfo.MODID + ":textures/guis/NEI/metalForgeCooling.png";
    }

    @Override
    public String getRecipeName()
    {
        return StatCollector.translateToLocal("metalForge.Cooling");
    }

    @Override
    public void loadCraftingRecipes(String outputID, Object... results)
    {
        if ("item".equals(outputID)) loadCraftingRecipes((String) results[0]);
        else if ("allMACooling".equals(outputID))
        {
            for (RecipeMolten2_1 r : MetalForgeCoolingRecipes.INSTANCE.getAllRecipes())
            {
                arecipes.add(new CachedMetalForgeCoolingRecipe(r));
            }
        }

    }

    @Override
    public void loadCraftingRecipes(ItemStack result)
    {
        for (RecipeMolten2_1 r : MetalForgeCoolingRecipes.INSTANCE.getAllRecipes())
        {
            if (r.getOutput().equals(result))
                arecipes.add(new CachedMetalForgeCoolingRecipe(r));
        }
    }

    @Override
    public void loadUsageRecipes(String inputID, Object... ingredients)
    {
        if (ingredients.length == 0) return;
        if ("item".equals(inputID))
        {
            for (RecipeMolten2_1 r : MetalForgeCoolingRecipes.INSTANCE.getAllRecipes())
            {
                if (r.getInput1().equals(ingredients[0])||r.getInput2().equals(ingredients[0]))
                    arecipes.add(new CachedMetalForgeCoolingRecipe(r));
            }
        }
    }

    @Override
    public void drawExtras(int recipe)
    {
        CachedMetalForgeCoolingRecipe r = (CachedMetalForgeCoolingRecipe) arecipes.get(recipe);
        int y = 64;
        int h1 = r.getInputAmt1() * 65 / TileEntityMetalForge.MAX_LIQUID_MB;
        GuiDraw.changeTexture(new ResourceLocation(ModInfo.MODID, "textures/fluid/" + r.getInput1() + ".png"));
        GuiDraw.drawTexturedModalRect(45, y - h1, 0, 0, 30, h1);

        y = y - h1;

        int h2 = r.getInputAmt1() * 65 / TileEntityMetalForge.MAX_LIQUID_MB;
        GuiDraw.changeTexture(new ResourceLocation(ModInfo.MODID, "textures/fluid/" + r.getInput2() + ".png"));
        GuiDraw.drawTexturedModalRect(45, y - h2, 0, 0, 30, h2);

        //        GuiDraw.changeTexture(getGuiTexture());
        //        GuiDraw.drawTexturedModalRect(94, 0, 176, 30, 32, 72);
    }

    @Override
    public void loadTransferRects()
    {
        RecipeTransferRect rect = new RecipeTransferRect(new Rectangle(110, 34, 22, 15), "allMACooling");
        transferRects.add(rect);
        List<Class<? extends GuiContainer>> guis = new ArrayList<Class<? extends GuiContainer>>();
        guis.add(GuiMetalForge.class);
        RecipeTransferRectHandler.registerRectsToGuis(guis, transferRects);
    }
}
