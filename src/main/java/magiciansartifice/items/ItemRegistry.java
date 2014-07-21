package magiciansartifice.items;

import cpw.mods.fml.common.registry.GameRegistry;
import magiciansartifice.MagiciansArtifice;
import magiciansartifice.ModInfo;
import magiciansartifice.items.tools.ItemToolChisel;
import magiciansartifice.items.wand.Wand;
import net.minecraft.item.Item;
import org.apache.commons.lang3.ObjectUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

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

        for (int i = 0; i < items.size(); i++) {
            GameRegistry.registerItem(items.get(i),ModInfo.MODID + ":" + items.get(i).getUnlocalizedName().substring(5));
        }
    }
}
