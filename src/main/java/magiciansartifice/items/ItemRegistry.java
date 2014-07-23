package magiciansartifice.items;

import cpw.mods.fml.common.registry.GameRegistry;
import magiciansartifice.items.ores.ItemDustMeta;
import magiciansartifice.items.ores.ItemIngotMeta;
import magiciansartifice.items.misc.ItemLetterMerlin;
import magiciansartifice.items.misc.ItemSticksMeta;
import magiciansartifice.items.ores.ItemOreDropMeta;
import magiciansartifice.items.tools.ItemMagicBook;
import magiciansartifice.items.tools.ItemToolChisel;
import magiciansartifice.items.tools.steel.*;
import magiciansartifice.items.wand.Wand;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;

import java.util.ArrayList;

public class ItemRegistry
{
    private static Item.ToolMaterial iron = Item.ToolMaterial.IRON;

    public static ArrayList<Item> items = new ArrayList<Item>();

    public static Item.ToolMaterial steel = EnumHelper.addToolMaterial("steel", iron.getHarvestLevel(), iron.getMaxUses() + 50, iron.getEfficiencyOnProperMaterial(), iron.getDamageVsEntity(), iron.getEnchantability());

    public static Item ingotsMeta;
    public static Item dustsMeta;
    public static Item sticksMeta;
    public static Item oreDropsMeta;

    public static Item magiciansWand;
    public static Item level3Test;
    public static Item chiselTool;
    public static Item book;
    public static Item merlinLetter;

    public static Item steelSword;
    public static Item steelPick;
    public static Item steelShovel;
    public static Item steelAxe;
    public static Item steelHoe;

    public static void initItems() {

        dustsMeta = new ItemDustMeta();
        ingotsMeta = new ItemIngotMeta();
        sticksMeta = new ItemSticksMeta();
        oreDropsMeta = new ItemOreDropMeta();
        
        magiciansWand = new Wand(1);
        level3Test = new Wand(3);
        book = new ItemMagicBook();
        chiselTool = new ItemToolChisel();
        merlinLetter = new ItemLetterMerlin();

        steelSword = new ItemSwordSteel();
        steelPick = new ItemPickSteel();
        steelShovel = new ItemShovelSteel();
        steelAxe = new ItemAxeSteel();
        steelHoe = new ItemHoeSteel();
        
        for (Item item : items) {
            GameRegistry.registerItem(item, item.getUnlocalizedName().substring(5));
        }
    }
}
