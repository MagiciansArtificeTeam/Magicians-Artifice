package magiciansartifice.main.core.client.guis.book;

import java.util.ArrayList;

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
                text.add("I have used my powers");
                text.add("to spread books ");
                text.add("'round the known world,");
                text.add(" so you can be knowing");
                text.add(" in the way of magic.");
                text.add("Unfortunately, I can");
                text.add("only give so little");
                text.add("comments, so the");
                text.add("rest of the learning");
                text.add("is up to you!");
                Page.addTextPage(gui, gui.getLeft() + xPos, gui.getTop(), text);
                break;
            case 2:
                text.add("This first book is ");
                text.add("about basic wand craft,");
                text.add("the bread and butter");
                text.add("of a magician's journey.");
                text.add("This book will teach you");
                text.add("many ways I form my");
                text.add("powerful wands! I hope");
                text.add("you learn well!");
                text.add("Good luck!");
                text.add("");
                text.add("-Merlin");
                //2x2 Recipe
                Page.addImageTextPage(gui, gui.getLeft() + xPos, gui.getTop(), new ItemStack(ItemRegistry.magiciansWand), text, 50f, 0, -10, false, 45, 0);
                break;
            case 3:
                text.add("");
                text.add("");
                text.add("");
                text.add(EnumChatFormatting.ITALIC + "I may have made a");
                text.add(EnumChatFormatting.ITALIC + "few edits and tore");
                text.add(EnumChatFormatting.ITALIC + "out a couple hundred");
                text.add(EnumChatFormatting.ITALIC + "pages. I'm only giving");
                text.add(EnumChatFormatting.ITALIC + "you what you need!");
                text.add("");
                text.add("");
                text.add("");
                Page.addTextPage(gui, gui.getLeft() + xPos, gui.getTop(), text);
                break;
            case 4:
                text.add("");
                text.add("");
                text.add("");
                text.add("");
                text.add("");
                text.add(EnumChatFormatting.ITALIC + "-Merlin");
                text.add("");
                text.add("");
                text.add("");
                text.add("");
                text.add("");
                Page.addTextPage(gui, gui.getLeft() + xPos, gui.getTop(), text);
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
