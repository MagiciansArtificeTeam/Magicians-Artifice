package magiciansartifice.main.compat.nei;

import codechicken.nei.NEIServerUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.GuiRecipe;
import codechicken.nei.recipe.TemplateRecipeHandler;
import magiciansartifice.main.core.libs.ModInfo;
import magiciansartifice.main.tileentities.recipes.Recipes2_1;
import magiciansartifice.main.tileentities.recipes.RecipesMysticAnvil;
import magiciansartifice.main.tileentities.recipes.RecipesWandCarver;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.input.Mouse;

import java.awt.*;
import java.awt.List;
import java.lang.reflect.Field;
import java.util.*;

/**
 * Created by Mitchellbrine on 2014.
 */
@SuppressWarnings("static-access")
public class MysticAnvilHandler extends TemplateRecipeHandler{

    public class CachedAnvilRecipe extends CachedRecipe {
        PositionedStack input2;
        PositionedStack input;
        PositionedStack output;
        int time;

        public CachedAnvilRecipe(Recipes2_1 recipe) {
            input = new PositionedStack(recipe.getInput2(),30,15);
            input2 = new PositionedStack(recipe.getInput1(),52,15);
            output = new PositionedStack(recipe.getOutput(),119, 15);
            time = recipe.getTime();

        }

        @Override
        public PositionedStack getIngredient() {
            return input;
        }

        @Override
        public PositionedStack getOtherStack() {
            return input2;
        }

        @Override
        public PositionedStack getResult() {
            return output;
        }
    }

    @Override
    public void loadCraftingRecipes(String outputId, Object... results) {
        if (outputId.equals("mysticAnvilRecipes") && getClass() == MysticAnvilHandler.class) {
            for(Recipes2_1 recipe: RecipesMysticAnvil.recipe21List) {
                if(recipe.getOutput() != null) arecipes.add(new CachedAnvilRecipe(recipe));
            }
        } else {
            super.loadCraftingRecipes(outputId, results);
        }
    }

    @Override
    public void loadCraftingRecipes(ItemStack result) {
        for(Recipes2_1 recipe: RecipesMysticAnvil.recipe21List) {
            if(NEIServerUtils.areStacksSameTypeCrafting(recipe.getOutput(), result)) {
                if(recipe.getOutput() != null) arecipes.add(new CachedAnvilRecipe(recipe));
            }
        }
    }

    @Override
    public void loadUsageRecipes(ItemStack ingredient)  {
        for(Recipes2_1 recipe: RecipesMysticAnvil.recipe21List) {
            if(NEIServerUtils.areStacksSameTypeCrafting(recipe.getInput1(), ingredient) || NEIServerUtils.areStacksSameTypeCrafting(recipe.getInput2(),ingredient)) {
                if(recipe.getOutput() != null) arecipes.add(new CachedAnvilRecipe(recipe));
            }
        }
    }

    @Override
    public void drawExtras(int id) {
        CachedAnvilRecipe recipe = (CachedAnvilRecipe) arecipes.get(id);
        Minecraft.getMinecraft().fontRenderer.drawString("\u00a77" + "Difficulty to Create: Level " + (recipe.time/100), 18, 5, 0);
    }


    @Override
    public String getOverlayIdentifier() {
        return "mysticAnvilRecipes";
    }

    @Override
    public void loadTransferRects() {
        transferRects.add(new RecipeTransferRect(new Rectangle(78, 22, 21, 32), "mysticAnvilRecipes"));
    }

    @Override
    public String getRecipeName() {
        return "   " + StatCollector.translateToLocal("tile.mysticAnvil.name");
    }

    @Override
    public String getGuiTexture() {
        return new ResourceLocation(ModInfo.MODID, "textures/guis/mysticAnvilGUI.png").toString();
    }

    @Override
    public java.util.List<String> handleTooltip(GuiRecipe gui, java.util.List<String> currenttip, int id) {
        currenttip = super.handleTooltip(gui, currenttip, id);
        /*Point mouse = getMouse(getGuiWidth(gui), getGuiHeight(gui));
        CachedCarverRecipe recipe = (CachedCarverRecipe) arecipes.get(id);
        int yLow = id % 2 == 0 ? 36 : 36;
        int yHigh = id % 2 == 0 ? 52 : 52;
        if(mouse.x >= 14 && mouse.x <= 30 && mouse.y >= yLow && mouse.y <= yHigh) {
            currenttip.add("Time Required to Create: " + recipe.time);
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
