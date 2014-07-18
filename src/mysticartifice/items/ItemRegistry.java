package mysticartifice.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ItemRegistry {
    public static Item dusts;

    public static void registerItems() {
        dusts = new ItemDustMeta().setUnlocalizedName("dustsMeta");
        GameRegistry.registerItem(dusts, "ItemDustsMeta");
    }
}
