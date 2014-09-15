package magiciansartifice.main.compat.nei;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.lang.reflect.Field;
import java.util.List;

import magiciansartifice.main.core.libs.ModInfo;
import magiciansartifice.main.tileentities.recipes.Recipes2_1;
import magiciansartifice.main.tileentities.recipes.RecipesWandCarver;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.input.Mouse;

import codechicken.nei.NEIServerUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.GuiRecipe;
import codechicken.nei.recipe.TemplateRecipeHandler;

public class WandCarverHandler extends TemplateRecipeHandler {
    public class CachedCarverRecipe extends CachedRecipe {
        PositionedStack input;
        PositionedStack input2;
        PositionedStack output;
        int time;

        public CachedCarverRecipe(Recipes2_1 recipe) {
            input = new PositionedStack(recipe.getInput1(),14,34);
            input2 = new PositionedStack(recipe.getInput2(),39,34);
            output = new PositionedStack(recipe.getOutput(),129, 34);
            time = recipe.getTime();

        }

        @Override
        public PositionedStack getIngredient() {
            return input;
        }

        public PositionedStack getInput2() {
            return input2;
        }

        @Override
        public PositionedStack getResult() {
            return output;
        }
    }

    @Override
    public void loadCraftingRecipes(String outputId, Object... results) {
        if (outputId.equals("wandCarverRecipes") && getClass() == WandCarverHandler.class) {
            for(Recipes2_1 recipe: RecipesWandCarver.recipe21List) {
                if(recipe.getOutput() != null) arecipes.add(new CachedCarverRecipe(recipe));
            }
        } else {
            super.loadCraftingRecipes(outputId, results);
        }
    }

    @Override
    public void loadCraftingRecipes(ItemStack result) {
        for(Recipes2_1 recipe: RecipesWandCarver.recipe21List) {
            if(NEIServerUtils.areStacksSameTypeCrafting(recipe.getOutput(), result)) {
                if(recipe.getOutput() != null) arecipes.add(new CachedCarverRecipe(recipe));
            }
        }
    }

    @Override
    public void loadUsageRecipes(ItemStack ingredient)  {
        for(Recipes2_1 recipe: RecipesWandCarver.recipe21List) {
            if(NEIServerUtils.areStacksSameTypeCrafting(recipe.getInput1(), ingredient)) {
                if(recipe.getOutput() != null) arecipes.add(new CachedCarverRecipe(recipe));
            }
        }
    }

    @Override
    public void drawExtras(int id) {
        CachedCarverRecipe recipe = (CachedCarverRecipe) arecipes.get(id);
        Minecraft.getMinecraft().fontRenderer.drawString("\u00a77" + "Time Required to Create: " + recipe.time, 78, 5, 0);
    }


    @Override
    public String getOverlayIdentifier() {
        return "wandCarverRecipes";
    }

    @Override
    public void loadTransferRects() {
        transferRects.add(new RecipeTransferRect(new Rectangle(90, 32, 22, 16), "wandCarverRecipes"));
    }

    @Override
    public String getRecipeName() {
        return "   " + StatCollector.translateToLocal("tile.wandCarver.name");
    }

    @Override
    public String getGuiTexture() {
        return new ResourceLocation(ModInfo.MODID, "gui/nei/carver.png").toString();
    }

    @Override
    public List<String> handleTooltip(GuiRecipe gui, List<String> currenttip, int id) {
        currenttip = super.handleTooltip(gui, currenttip, id);
        /*Point mouse = getMouse(getGuiWidth(gui), getGuiHeight(gui));
        CachedCarverRecipe recipe = (CachedCarverRecipe) arecipes.get(id);
        int yLow = id % 2 == 0 ? 38 : 102;
        int yHigh = id % 2 == 0 ? 72 : 136;
        if(mouse.x >= 19 && mouse.x <= 80 && mouse.y >= yLow && mouse.y <= yHigh) {
            if (!recipe.isMat) {
                currenttip.add(EnumChatFormatting.DARK_RED + StatCollector.translateToLocal("former.template.needed"));
            } else {
                currenttip.add(EnumChatFormatting.DARK_RED + StatCollector.translateToLocal("former.templateMat.needed"));
            }
            if (recipe.temporalThread) {
                currenttip.add(EnumChatFormatting.DARK_PURPLE + StatCollector.translateToLocal("former.temporalThread"));
            } else {
                currenttip.add(EnumChatFormatting.GRAY + StatCollector.translateToLocal("former.regularThread"));
            }
        } */

        return currenttip;
    }

    //Mouse Position helper
    public Point getMouse(int width, int height) {
        Point mousepos = this.getMousePosition();
        int guiLeft = (width - 176) / 2;
        int guiTop = (height - 166) / 2;
        Point relMouse = new Point(mousepos.x - guiLeft, mousepos.y - guiTop);
        return relMouse;
    }

    //width helper, getting width normal way hates me on compile
    public int getGuiWidth(GuiRecipe gui) {
        try {
            Field f = gui.getClass().getField("width");
            return (Integer) f.get(gui);
        } catch (NoSuchFieldException e) {
            try {
                Field f = gui.getClass().getField("field_146294_l");
                return (Integer) f.get(gui);
            } catch (Exception e2) {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    //height helper, getting height normal way hates me on compile
    public int getGuiHeight(GuiRecipe gui) {
        try {
            Field f = gui.getClass().getField("height");
            return (Integer) f.get(gui);
        } catch (NoSuchFieldException e) {
            try {
                Field f = gui.getClass().getField("field_146295_m");
                return (Integer) f.get(gui);
            } catch (Exception e2) {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static Point getMousePosition() {
        Dimension size = displaySize();
        Dimension res = displayRes();
        return new Point(Mouse.getX() * size.width / res.width, size.height - Mouse.getY() * size.height / res.height - 1);
    }

    public static Dimension displaySize() {
        Minecraft mc = Minecraft.getMinecraft();
        ScaledResolution res = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
        return new Dimension(res.getScaledWidth(), res.getScaledHeight());
    }

    public static Dimension displayRes() {
        Minecraft mc = Minecraft.getMinecraft();
        return new Dimension(mc.displayWidth, mc.displayHeight);
    }

}