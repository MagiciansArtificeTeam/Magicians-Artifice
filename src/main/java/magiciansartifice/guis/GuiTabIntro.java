package magiciansartifice.guis;

import java.util.ArrayList;

import magiciansartifice.items.ItemRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

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
                text.add("You look afraid. Don't");
                text.add("be afraid. This is a");
                text.add("dream, the last dream");
                text.add("you may ever have, for");
                text.add("nightmares are coming.");
                text.add("They will take over the ");
                text.add("world if you don't stop ");
                text.add("them. It's up to you now...");
                text.add("Go now and help save");
                text.add("this world!");
                Page.addTextPage(gui, gui.getLeft() + xPos, gui.getTop(), text);
                break;
            case 2:
                text.add("The end of our known");
                text.add("world is upon is...");
                text.add("My light is fading,");
                text.add("dimming slightly...");
                text.add("and only a great");
                text.add("sorcerer or magician");
                text.add("can save us now...");
                text.add("Be the one magician to");
                text.add("rise to power and save");
                text.add("the mortals!");
                text.add("-Merlin");
                //2x2 Recipe
                Page.addImageTextPage(gui, gui.getLeft() + xPos, gui.getTop(), new ItemStack(Items.writable_book), text, 50f, 0, -10, false, 45, 0);
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
