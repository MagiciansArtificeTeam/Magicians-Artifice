package magiciansartifice.main.core.client.guis.book.advanced;

import magiciansartifice.main.core.client.guis.book.GuiMagicBook;
import magiciansartifice.main.core.client.guis.book.GuiTab;
import magiciansartifice.main.core.client.guis.book.Page;
import magiciansartifice.main.items.ItemRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;

@SuppressWarnings("unused")
public class GuiTabIntroAdv extends GuiTab
{

    public GuiTabIntroAdv(int id)
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
                text.add("Now that you have ");
                text.add("advanced past the ");
                text.add("basic wandcraft level,");
                text.add("I can introduce you to");
                text.add("the advanced wand-");
                text.add("craft. Unfortunately, it");
                text.add("appears this book ");
                text.add("has been defaced.");
                text.add("I have made the ");
                text.add("vandalism apparent.");
                Page.addTextPage(gui, gui.getLeft() + xPos, gui.getTop(), text);
                break;
            case 2:
                text.add("I must find out ");
                text.add("who \"The Mischievous");
                text.add(" One\" is...");
                text.add(" He must be truly");
                text.add("diabolical! Do not ");
                text.add("listen to his words");
                text.add("and dark spells. They");
                text.add("will only corrupt you.");
                text.add("");
                text.add("-Merlin");
                //2x2 Recipe
                Page.addImageTextPage(gui, gui.getLeft() + xPos, gui.getTop(), new ItemStack(ItemRegistry.magiciansWand), text, 50f, 0, -10, false, 45, 0);
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
