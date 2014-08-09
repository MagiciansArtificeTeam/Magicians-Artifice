package magiciansartifice.tileentities.recipes;

import net.minecraft.item.ItemStack;

/**
 * Created by James Hollowell on 8/9/2014.
 */
public class RecipeMolten1_1
{
    private ItemStack input;
    private String output;
    private int outputAmount;

    /**
     *
     * @param input Input item stack
     * @param output Resultant molten name
     * @param outputAmount Resultant molten amount
     */
    public RecipeMolten1_1(ItemStack input, String output, int outputAmount)
    {
        this.input = input;
        this.output = output;
        this.outputAmount = outputAmount;
    }

    public int getOutputAmount()
    {
        return outputAmount;
    }

    public ItemStack getInput()
    {
        return input;
    }

    public String getOutput()
    {
        return output;
    }


}
