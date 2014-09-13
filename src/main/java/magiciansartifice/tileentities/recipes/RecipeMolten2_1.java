package magiciansartifice.tileentities.recipes;

import net.minecraft.item.ItemStack;

/**
 * Created by poppypoppop on 22/07/2014.
 */
public class RecipeMolten2_1
{
    private String input1;
    private int amount1;
    private String input2;
    private int amount2;
    private ItemStack output;

    /**
     * Creates a new recipe with 2 inputs and one output.
     *
     * @param input1        Molten name of input 1
     * @param input1Amount  Amount (in mb) of molten metal needed for this recipe of input 1
     * @param input2        Molten name of input 2
     * @param input2Ammount Amount (in mb) of molten metal needed for this recipe of input 2
     * @param output        ItemStack of output
     */
    public RecipeMolten2_1(String input1, int input1Amount, String input2, int input2Ammount, ItemStack output)
    {
        this.input1 = input1;
        this.amount1 = input1Amount;
        this.input2 = input2;
        this.amount2 = input2Ammount;
        this.output = output.copy();
    }

    public String getInput1()
    {
        return input1;
    }

    public String getInput2()
    {
        return input2;
    }

    public int getAmount1()
    {
        return amount1;
    }

    public int getAmount2()
    {
        return amount2;
    }

    public ItemStack getOutput()
    {
        return output;
    }
}
