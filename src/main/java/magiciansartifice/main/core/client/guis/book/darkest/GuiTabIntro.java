package magiciansartifice.main.core.client.guis.book.darkest;

import java.util.ArrayList;

import magiciansartifice.main.core.client.guis.book.GuiMagicBook;
import magiciansartifice.main.core.client.guis.book.GuiTab;
import magiciansartifice.main.core.client.guis.book.Page;
import magiciansartifice.main.items.ItemRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

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
                text.add("the darkest magic ");
                text.add("in the universe is ");
                text.add("life's greatest treasure ");
                text.add("that we all strive for. ");
                text.add("If you are any great ");
                text.add("magician, you've wondered");
                text.add("or delved into the");
                text.add("dark magic. Whether ");
                text.add("you used them or not, ");
                text.add("you have always used them.");
                Page.addTextPage(gui, gui.getLeft() + xPos, gui.getTop(), text);
                break;
            case 2:
                text.add("Death, destruction,");
                text.add("and chaos can be ");
                text.add("harnessed to do");
                text.add("great things. ");
                text.add("You can become");
                text.add("a great magician");
                text.add("by learning these");
                text.add("simple incantations");
                text.add("and objects. Your");
                text.add("destiny is yours!");
                text.add("-Grimnwaldor");
                Page.addTextPage(gui, gui.getLeft() + xPos, gui.getTop(), text);
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
