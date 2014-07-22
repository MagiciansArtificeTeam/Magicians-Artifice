package magiciansartifice.utils;

import magiciansartifice.items.ItemRegistry;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Created by poppypoppop on 22/07/2014.
 */
public class OreDictHandler {
    public static void registerOreDicts() {
        for (int i = 0; i <= 3;) {
            OreDictionary.registerOre("stickWood", new ItemStack(ItemRegistry.sticksMeta, 1, i));
        }
    }
}
