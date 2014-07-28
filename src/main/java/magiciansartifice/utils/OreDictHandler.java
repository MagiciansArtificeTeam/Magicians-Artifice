package magiciansartifice.utils;

import magiciansartifice.items.ItemRegistry;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Created by poppypoppop on 22/07/2014.
 */

public class OreDictHandler {
    public static void registerOreDicts() {
        OreDictionary.registerOre("ingotSteel", new ItemStack(ItemRegistry.ingotsMeta, 1, 1));
        for (int i = 0; i <= 3; i++) {
            OreDictionary.registerOre("stickWood", new ItemStack(ItemRegistry.sticksMeta, 1, i));
        }
    }
}
