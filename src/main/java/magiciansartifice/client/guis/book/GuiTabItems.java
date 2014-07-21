package magiciansartifice.client.guis.book;

import java.util.ArrayList;

import magiciansartifice.items.ItemRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

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
                text.add("  You look afraid. Don't");
                text.add("be afraid. This is a");
                text.add("dream, the last dream");
                text.add("you may ever have, for");
                text.add("nightmares are coming.");
                items.add(new ItemStack(Blocks.bookshelf));
                items.add(new ItemStack(Items.clay_ball));
                //Furnace recipe
                Page.addSmeltingRecipeTextPage(gui, gui.getLeft() + xPos, gui.getTop(), text, items, x, y);
                break;
            case 2:
                text.add("  You look afraid. Don't");
                text.add("be afraid. This is a");
                text.add("dream, the last dream");
                text.add("you may ever have, for");
                text.add("nightmares are coming.");
                items.add(new ItemStack(Blocks.bookshelf));
                items.add(new ItemStack(Items.clay_ball));
                //2x2 Recipe
                Page.addCraftingRecipeTextPage(gui, gui.getLeft() + xPos, gui.getTop(), true, text, items, x, y);
                break;                
            case 3:
                text.add("  You look afraid. Don't");
                text.add("be afraid. This is a");
                text.add("dream, the last dream");
                text.add("you may ever have, for");
                text.add("nightmares are coming.");
                items.add(new ItemStack(Blocks.bookshelf));
                items.add(new ItemStack(Items.clay_ball));
                //3x3 recipe
                Page.addCraftingRecipeTextPage(gui, gui.getLeft() + xPos, gui.getTop(), false, text, items, x, y);
                break;              
            case 4:
                text.add("  You look afraid. Don't");
                text.add("be afraid. This is a");
                text.add("dream, the last dream");
                text.add("you may ever have, for");
                text.add("nightmares are coming.");
                //Simple page with a picture in the top left
                Page.addImageTextPage(gui, gui.getLeft() + xPos, gui.getTop(), new ItemStack(Items.blaze_rod, 64), text, 50f);
                break;                
            case 5:
                text.add("  You look afraid. Don't");
                text.add("be afraid. This is a");
                text.add("dream, the last dream");
                text.add("you may ever have, for");
                text.add("nightmares are coming.");
                //Simple text page
                Page.addTextPage(gui, gui.getLeft() + xPos, gui.getTop(), text);
                break;           
            case 6:
                text.add("  You look afraid. Don't");
                text.add("be afraid. This is a");
                text.add("dream, the last dream");
                text.add("you may ever have, for");
                text.add("nightmares are coming.");
                items.add(new ItemStack(Blocks.bookshelf));
                items.add(new ItemStack(Items.clay_ball));
                //A more configurable text + image page. After the text and size of image comes the x and y position of the text,
                //a boolean for whether you want the items name to be displayed or not, then the x and y positions for the item
                Page.addImageTextPage(gui, gui.getLeft() + xPos, gui.getTop(), new ItemStack(Items.leather_boots, 1), text, 50f, 0, -10, false, 45, 0);
                break;          
            default:;
        }
    }

    public int getMaxPages()
    {
        return 5;
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
