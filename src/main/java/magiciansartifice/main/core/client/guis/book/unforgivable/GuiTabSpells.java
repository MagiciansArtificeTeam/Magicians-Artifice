package magiciansartifice.main.core.client.guis.book.unforgivable;

import magiciansartifice.main.core.client.guis.book.GuiMagicBook;
import magiciansartifice.main.core.client.guis.book.GuiTab;
import magiciansartifice.main.core.client.guis.book.Page;
import magiciansartifice.main.core.utils.registries.ItemRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import java.util.ArrayList;

@SuppressWarnings("unused")
public class GuiTabSpells extends GuiTab{
    public GuiTabSpells(int id)
    {
        super("Spells", id);
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
                text.add("The first thing you, ");
                text.add("will need for spells ");
                text.add("is your trusty tier ");
                text.add("three wand. You know ");
                text.add("how to craft it, so ");
                text.add("let's move on. Since ");
                text.add("these spells were first");
                text.add("used, the elders wrote");
                text.add("them down as ");
                text.add("\"Unforgivable\", so");
                text.add("wizards will hear the");
                text.add("spell being cast.");
                Page.addTextPage(gui, gui.getLeft() + xPos, gui.getTop(), text);
                break;
            case 2:
                text.add("Keep that in mind when");
                text.add("when you wish to use");
                text.add("them as they will ");
                text.add("attract skilled ");
                text.add("magicians. You");
                text.add("have been " + EnumChatFormatting.DARK_RED + "WARNED!");
                text.add("");
                text.add("-\"The Mischievous One\"");
                Page.addTextPage(gui, gui.getLeft() + xPos, gui.getTop(), text);
                break;
            case 3:
                text.add(EnumChatFormatting.DARK_RED + "" + EnumChatFormatting.UNDERLINE + "Feitizo da dor");
                text.add("Wand Tier: 3");
                text.add("Type: Left-click");
                text.add("");
                text.add(EnumChatFormatting.DARK_GREEN + "Essence Used:");
                text.add(EnumChatFormatting.DARK_GREEN + "O: 1 | " + EnumChatFormatting.RED + "N: 1 | " + EnumChatFormatting.DARK_PURPLE + "E: 1");
                text.add("");
                text.add("Hurts the victim, ");
                text.add("without killing them.");
                text.add("(Useful for torture)");
                Page.addImageTextPage(gui, gui.getLeft() + xPos, gui.getTop(), new ItemStack(ItemRegistry.magiciansWand3), text, 50f, 0, -10, false, 45, 0);
                break;
            default:;
        }
    }

    public int getMaxPages()
    {
        return 4;
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
