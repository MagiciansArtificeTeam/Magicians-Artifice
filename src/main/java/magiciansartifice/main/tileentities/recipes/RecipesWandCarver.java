package magiciansartifice.main.tileentities.recipes;

import com.google.common.collect.ImmutableList;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by poppypoppop on 22/07/2014.
 */
public class RecipesWandCarver {
    public static List<Recipes2_1> recipe21List = new ArrayList<Recipes2_1>();

    public static void addRecipe(ItemStack input1, ItemStack input2, ItemStack output, int time) {
        Recipes2_1 r = new Recipes2_1(input1, input2, output, time);
        recipe21List.add(r);
    }

    public static void addOreDictRecipe(String ore1, String ore2, ItemStack output, int time) {
        ArrayList<ItemStack> ores1 = OreDictionary.getOres(ore1);
        ArrayList<ItemStack> ores2 = OreDictionary.getOres(ore2);
        if (ores1 != null && ores1.size() > 0 && ores2 != null && ores2.size() > 0) {
            for (ItemStack oreList1 : OreDictionary.getOres(ore1)) {
                for (ItemStack oreList2 : OreDictionary.getOres(ore2)) {
                    addRecipe(oreList1, oreList2, output, time);
                }
            }
        }
    }

    public static void addOreDictRecipe(ItemStack input1, ItemStack input2, String output, int time, int stackSize) {
        ArrayList<ItemStack> outputs = OreDictionary.getOres(output);
        if (output != null && outputs.size() > 0) {
            ItemStack outputsFinal = outputs.get(0);
            outputsFinal.stackSize = stackSize;
            addRecipe(input1, input2, outputsFinal, time);
        }
    }

    public static void addOreDictRecipe(String ore1, String ore2, String output, int time, int stackSize) {
        ArrayList<ItemStack> ores1 = OreDictionary.getOres(ore1);
        ArrayList<ItemStack> ores2 = OreDictionary.getOres(ore2);
        ArrayList<ItemStack> outputs = OreDictionary.getOres(output);
        if (ores1 != null && ores1.size() > 0 && ores2 != null && ores2.size() > 0 && output != null && outputs.size() > 0) {
            for (ItemStack oreList1 : OreDictionary.getOres(ore1)) {
                for (ItemStack oreList2 : OreDictionary.getOres(ore2)) {
                    ItemStack outputsFinal = outputs.get(0);
                    outputsFinal.stackSize = stackSize;
                    addRecipe(oreList1, oreList2, outputsFinal, time);
                }
            }
        }
    }

    public static Recipes2_1 getRecipeFromStack(ItemStack stack1, ItemStack stack2) {
        if (stack1 == null || stack2 == null) return null;
        for (Recipes2_1 r : recipe21List) {
            if (r.getInput1().getItem().equals(stack1.getItem()) && r.getInput2().getItem().equals(stack2.getItem()))
                return r;
            if (r.getInput2().getItem().equals(stack1.getItem()) && r.getInput1().getItem().equals(stack2.getItem()))
                return r;
        }
        return null;
    }

    public static Recipes2_1[] getRecipesFromStack(ItemStack stack) {
        List<Recipes2_1> out = new ArrayList<Recipes2_1>();
        if (stack == null) return null;
        for (Recipes2_1 r : recipe21List) {
            if (r.getInput1().getItem().equals(stack.getItem()) || r.getInput2().getItem().equals(stack.getItem()))
                out.add(r);
        }
        return out.toArray(new Recipes2_1[0]);
    }

    public static List<Recipes2_1> getAllRecipes() {
        return ImmutableList.copyOf(recipe21List);
    }
}
