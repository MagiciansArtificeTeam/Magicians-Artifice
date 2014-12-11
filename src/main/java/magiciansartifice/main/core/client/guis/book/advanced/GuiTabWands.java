package magiciansartifice.main.core.client.guis.book.advanced;

import magiciansartifice.main.core.client.guis.book.GuiMagicBook;
import magiciansartifice.main.core.client.guis.book.GuiTab;
import magiciansartifice.main.core.client.guis.book.Page;
import magiciansartifice.main.core.utils.TextHelper;
import magiciansartifice.main.core.utils.registries.ItemRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import java.util.ArrayList;

@SuppressWarnings("unused")
public class GuiTabWands extends GuiTab
{

    public GuiTabWands(int id)
    {
        super("Wands [Tiers 2+]", id);
    }

    public ItemStack getIcon()
    {
        return new ItemStack(ItemRegistry.magiciansWand3);
    }

    @Override
    public void drawBackground(GuiMagicBook gui, int x, int y, int page)
    {
        ArrayList<String> text = new ArrayList<String>();
        ArrayList<ItemStack> items = new ArrayList<ItemStack>();
        int xPos = (page%2==0)?107:-35;
        switch(page)
        {
            case 1:
                text.add(EnumChatFormatting.DARK_BLUE + "" + EnumChatFormatting.UNDERLINE + "Magician's Wand [Tier 2]");
                text.add("");
                text.add(EnumChatFormatting.DARK_GREEN + "Wood Used:");
                text.add(EnumChatFormatting.DARK_GREEN + "Ashwood Log");
                text.add(" ");
                text.add(EnumChatFormatting.DARK_AQUA + "Chisel Tier:");
                text.add(EnumChatFormatting.DARK_AQUA + "2+");
                text.add(" ");
                text.add(EnumChatFormatting.GREEN + "Max Essence:");
                text.add(EnumChatFormatting.GREEN + "O: 75 |" + EnumChatFormatting.DARK_RED + " N: 75");
                text.add(" ");
                //Furnace recipe
                Page.addImageTextPage(gui, gui.getLeft() + xPos, gui.getTop(), new ItemStack(ItemRegistry.magiciansWand2, 1), text, 50f, 0, -10, false, 45, 0);
                break;
            case 2:
                text.add(EnumChatFormatting.LIGHT_PURPLE + "Spells Wand Can Cast:");
                text.add(EnumChatFormatting.LIGHT_PURPLE + TextHelper.localize("spell.levitation"));
                text.add(EnumChatFormatting.LIGHT_PURPLE + TextHelper.localize("spell.sheep"));
                text.add(EnumChatFormatting.LIGHT_PURPLE + TextHelper.localize("spell.containment"));
                text.add("");
                //2x2 Recipe
                Page.addImageTextPage(gui, gui.getLeft() + xPos, gui.getTop(), new ItemStack(ItemRegistry.magiciansWand2, 1), text, 50f, 0, -10, false, 45, 0);
                break;
            case 3:
                text.add(EnumChatFormatting.DARK_BLUE + "" + EnumChatFormatting.UNDERLINE + "Magician's Wand [Tier 3]");
                text.add("");
                text.add(EnumChatFormatting.DARK_GREEN + "Wood Used:");
                text.add(EnumChatFormatting.DARK_GREEN + "Rowan Wood Log");
                text.add(" ");
                text.add(EnumChatFormatting.DARK_AQUA + "Chisel Tier:");
                text.add(EnumChatFormatting.DARK_AQUA + "3");
                text.add(" ");
                text.add(EnumChatFormatting.GREEN + "Max Essence:");
                text.add(EnumChatFormatting.GREEN + "O: 75 |" + EnumChatFormatting.DARK_RED + " N: 75 |" + EnumChatFormatting.DARK_PURPLE + " E: 75");
                text.add(" ");
                //Furnace recipe
                Page.addImageTextPage(gui, gui.getLeft() + xPos, gui.getTop(), new ItemStack(ItemRegistry.magiciansWand3, 1), text, 50f, 0, -10, false, 45, 0);
                break;
            case 4:
                text.add(EnumChatFormatting.LIGHT_PURPLE + "Spells Wand Can Cast:");
                text.add(EnumChatFormatting.LIGHT_PURPLE + TextHelper.localize("spell.levitation"));
                text.add(EnumChatFormatting.LIGHT_PURPLE + TextHelper.localize("spell.sheep"));
                text.add(EnumChatFormatting.LIGHT_PURPLE + TextHelper.localize("spell.containment"));
                text.add("");
                text.add(EnumChatFormatting.RED + "" + EnumChatFormatting.ITALIC + "It seems my spells work");
                text.add(EnumChatFormatting.RED + "" + EnumChatFormatting.ITALIC + "with this tier. Haha!");
                text.add(EnumChatFormatting.RED + "" + EnumChatFormatting.ITALIC + "-\"The Mischievous One\"");
                //2x2 Recipe
                Page.addImageTextPage(gui, gui.getLeft() + xPos, gui.getTop(), new ItemStack(ItemRegistry.magiciansWand3, 1), text, 50f, 0, -10, false, 45, 0);
                break;
            case 5:
                text.add(" ");
                text.add(EnumChatFormatting.RED + "" + EnumChatFormatting.ITALIC + "Hey, you! If you're");
                text.add(EnumChatFormatting.RED + "" + EnumChatFormatting.ITALIC + "reading this, I want you");
                text.add(EnumChatFormatting.RED + "" + EnumChatFormatting.ITALIC + "to find my book. It ");
                text.add(EnumChatFormatting.RED + "" + EnumChatFormatting.ITALIC + "contains awesome");
                text.add(EnumChatFormatting.RED + "" + EnumChatFormatting.ITALIC + "spells and rituals!");
                text.add(EnumChatFormatting.RED + "" + EnumChatFormatting.ITALIC + "It's called:");
                text.add(EnumChatFormatting.RED + "" + EnumChatFormatting.ITALIC + EnumChatFormatting.UNDERLINE + "The Unforgivable Magic");
                text.add("");
                text.add(EnumChatFormatting.RED + "" + EnumChatFormatting.ITALIC + "-\"The Mischievous One\"");
                Page.addTextPage(gui, gui.getLeft() + xPos, gui.getTop(), text);
                break;
            default:;
        }
    }

    public int getMaxPages()
    {
        return 6;
    }

    public void mouseClick(GuiMagicBook gui, int x, int y, int button)
    {
        //A way to add links. Very easy
//        if(gui.page == 13 && x >= gui.getLeft() + 138 && x <= gui.getLeft() + 168 && y >= gui.getTop() + 98 && y <= gui.getTop() + 108)
//        {
//            try
//            {
//                Desktop.getDesktop().browse(new URL("http://www.google.com/").toURI());
//            }
//            catch (Exception e) {}
//        }
    }

    @Override
    public void drawForeground(GuiMagicBook gui, int x, int y, int page)
    {
    }

}
