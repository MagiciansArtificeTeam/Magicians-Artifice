package magiciansartifice.tileentities.recipes;

import com.google.common.collect.ImmutableList;
import magiciansartifice.tileentities.machines.TileEntityMetalForge;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by poppypoppop on 22/07/2014.
 */
public class RecipesMetalForgeCooling
{
    public final List<RecipesMolten2_1> recipe21List = new ArrayList<RecipesMolten2_1>();

    public static final RecipesMetalForgeCooling INSTANCE=new RecipesMetalForgeCooling();

    public void addRecipe(String input1, int input1Amount, String input2, int input2Ammount, ItemStack output)
    {
        RecipesMolten2_1 r = new RecipesMolten2_1(input1, input1Amount, input2, input2Ammount, output);
        recipe21List.add(r);
        TileEntityMetalForge.checkCanBlock(output);
    }

    public RecipesMolten2_1 getRecipeFromStack(String input1, String input2)
    {
        if (input1 == null || input2 == null) return null;
        for (RecipesMolten2_1 r : recipe21List)
        {
            if (r.getInput1().equals(input1) && r.getInput2().equals(input2))
                return r;
            if (r.getInput2().equals(input1) && r.getInput1().equals(input2))
                return r;
        }
        return null;
    }

    public RecipesMolten2_1[] getRecipesFromStack(String input)
    {
        List<RecipesMolten2_1> out = new ArrayList<RecipesMolten2_1>();
        if (input == null) return null;
        for (RecipesMolten2_1 r : recipe21List)
        {
            if (r.getInput1().equals(input) || r.getInput2().equals(input))
                out.add(r);
        }
        return out.toArray(new RecipesMolten2_1[0]);
    }

    public List<RecipesMolten2_1> getAllRecipes()
    {
        return ImmutableList.copyOf(recipe21List);
    }
}
