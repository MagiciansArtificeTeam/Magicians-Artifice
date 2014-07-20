package magiciansartifice.items;

import cpw.mods.fml.common.registry.GameRegistry;
import magiciansartifice.items.wand.Wand;
import net.minecraft.item.Item;

public class ItemRegistry {
    public static Item dusts;
    public static Item wand;

    public static void registerItems() {
        dusts = new ItemDustMeta().setUnlocalizedName("dustsMeta");
        wand = new Wand();
        GameRegistry.registerItem(dusts, "ItemDustsMeta");
    }
}
