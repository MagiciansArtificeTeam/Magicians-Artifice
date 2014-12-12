package magiciansartifice.main.core.client.guis.book.darkest;

import magiciansartifice.main.core.client.guis.book.GuiMagicBook;
import magiciansartifice.main.core.client.guis.book.GuiTab;
import magiciansartifice.main.core.client.guis.book.Page;
import magiciansartifice.main.core.utils.registries.ItemRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import java.util.ArrayList;

@SuppressWarnings("unused")
public class GuiTabSpells extends GuiTab {

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
                text.add("All of the spells ");
                text.add("listed below are");
                text.add("listed as \"Unforgivable\"");
                text.add("by the Elder ");
                text.add("Magicians. A WARNING:");
                text.add("If you use these spells,");
                text.add("the powerful magicians ");
                text.add("WILL find you.");
                text.add("");
                text.add("Good luck!");
                text.add("");
                text.add("-Grimnwaldor");
                Page.addTextPage(gui,gui.getLeft() + xPos, gui.getTop(),text);
                break;
            case 2:
                text.add(EnumChatFormatting.DARK_RED + "" + EnumChatFormatting.UNDERLINE + "Morte rápida");
                text.add("Wand Tier: 3");
                text.add("Type: Left-click");
                text.add("");
                text.add(EnumChatFormatting.DARK_GREEN + "Essence Used:");
                text.add(EnumChatFormatting.DARK_GREEN + "O: 5 | " + EnumChatFormatting.RED + "N: 5 | " + EnumChatFormatting.DARK_PURPLE + "E: 5");
                text.add("");
                text.add("Kills the victim");
                Page.addImageTextPage(gui, gui.getLeft() + xPos, gui.getTop(), new ItemStack(ItemRegistry.magiciansWand3), text, 50f, 0, -10, false, 45, 0);
                break;
            default:;
        }
    }

    public int getMaxPages()
    {
        return 2;
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
