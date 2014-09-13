package magiciansartifice.tileentities.recipes;

import com.google.common.collect.ImmutableList;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by James Hollowell on 8/9/2014.
 */
public class MetalForgeMeltingRecipes
{
    public final List<RecipeMolten1_1> recipes = new ArrayList<RecipeMolten1_1>();

    public static final MetalForgeMeltingRecipes INSTANCE = new MetalForgeMeltingRecipes();

    /** Add a recipe to this manager's list
     *
     * @param input OreDict name of item to melt
     * @param output Output molten name (semi-arbitrary)
     * @param outputAmount Ouput molten amount (See {@link magiciansartifice.tileentities.machines.TileEntityMetalForge} for amount constants)
     */
    public void addRecipe(String input, int inputAmmount, String output, int outputAmount)
    {
        ArrayList<ItemStack> ore=OreDictionary.getOres(input);
        for(ItemStack stack: ore)
        {
            stack.stackSize=inputAmmount;
            addRecipe(stack,output,outputAmount);
        }
    }

    /** Add a recipe to this manager's list
     *
     * @param input ItemStack to melt
     * @param output Output molten name (semi-arbitrary)
     * @param outputAmount Ouput molten amount (See {@link magiciansartifice.tileentities.machines.TileEntityMetalForge} for amount constants)
     */
    public void addRecipe(ItemStack input, String output, int outputAmount)
    {
        this.addRecipe(new RecipeMolten1_1(input, output, outputAmount));
    }

    /**Add a recipe to this manager's list
     *
     * @param r Recipe to add
     */
    public void addRecipe(RecipeMolten1_1 r)
    {
        recipes.add(r);
    }

    public RecipeMolten1_1 getRecipeFromStack(ItemStack input)
    {
        if(input==null) return null;
        for(RecipeMolten1_1 r: recipes)
        {
            if(r.getInput().isItemEqual(input)) return r;
        }
        return  null;
    }

    public boolean isValidInput(ItemStack input)
    {
        return getRecipeFromStack(input)!=null;
    }


    /**Gets the list of all the recipees this manager contains.
     *
     * @return The list of all recipes
     */
    public List<RecipeMolten1_1> getAllRecipes()
    {
        return ImmutableList.copyOf(recipes);
    }

}
