package mysticartifice.guis;

import java.awt.Desktop;
import java.net.URL;
import java.util.ArrayList;

import mysticartifice.items.ItemRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

public class GuiTabItems extends GuiTab
{

    public GuiTabItems(int id)
    {
        super("Items", id);
    }

    public ItemStack getIcon()
    {        
        return new ItemStack(ItemRegistry.book);
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
                text.add("  You look afraid.");
                text.add("Don't be afraid. This");
                text.add("is only a dream. And");
                text.add("when you wake up,");
                text.add("the nightmare will");
                text.add("begin.");
                items.add(new ItemStack(Blocks.bookshelf));
                items.add(new ItemStack(Items.clay_ball));
                Page.addSmeltingRecipeTextPage(gui, gui.getLeft() + xPos, gui.getTop(), text, items, x, y);
                break;
            default:;
        }
    }

    public int getMaxPages()
    {
        return 1;
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
