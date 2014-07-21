package magiciansartifice.items;

import cpw.mods.fml.common.registry.GameRegistry;
import magiciansartifice.libs.ModInfo;
import magiciansartifice.items.tools.ItemToolChisel;
import magiciansartifice.items.wand.Wand;
import net.minecraft.item.Item;

import java.util.ArrayList;

public class ItemRegistry {

    public static ArrayList<Item> items = new ArrayList<Item>();

    public static Item dustsMeta;
    public static Item magiciansWand;
    public static Item chiselTool;
    public static Item book;

    public static void initItems() {
        dustsMeta = new ItemDustMeta();
        magiciansWand = new Wand(1);
        book = new ItemMagicBook();
        chiselTool = new ItemToolChisel();

        for (Item item: items) {
            GameRegistry.registerItem(item,ModInfo.MODID + ":" + item.getUnlocalizedName().substring(5));
        }
    }
}
