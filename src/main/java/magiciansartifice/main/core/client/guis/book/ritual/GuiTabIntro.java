package magiciansartifice.main.core.client.guis.book.ritual;

import java.util.ArrayList;

import magiciansartifice.main.core.client.guis.book.GuiMagicBook;
import magiciansartifice.main.core.client.guis.book.GuiTab;
import magiciansartifice.main.core.client.guis.book.Page;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

@SuppressWarnings("unused")
public class GuiTabIntro extends GuiTab
{

    public GuiTabIntro(int id)
    {
        super("Introduction", id);
    }

    public ItemStack getIcon()
    {
        return new ItemStack(Items.writable_book);
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
                text.add("To Whom it May Concern,");
                text.add("Rituals are needed for");
                text.add("harnessing the excess ");
                text.add("power of the universe.");
                text.add("They can help you, ");
                text.add("harm you, and let you");
                text.add(" soar. You must know");
                text.add(" about these rituals");
                text.add(" to save the mortals");
                text.add(" and the wizards once");
                text.add(" and for all! -Merlin");
                Page.addTextPage(gui, gui.getLeft() + xPos, gui.getTop(), text);
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
