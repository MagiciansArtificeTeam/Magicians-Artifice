package magiciansartifice.main.core.client.guis.book.basic;

import java.util.ArrayList;

import magiciansartifice.main.blocks.BlockRegistry;
import magiciansartifice.main.core.client.guis.book.GuiMagicBook;
import magiciansartifice.main.core.client.guis.book.GuiTab;
import magiciansartifice.main.core.client.guis.book.Page;
import magiciansartifice.main.items.ItemRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class GuiTabItems extends GuiTab
{

    public GuiTabItems(int id)
    {
        super("Wand Carving", id);
    }

    public ItemStack getIcon()
    {        
        return new ItemStack(ItemRegistry.chiselTool);
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
                text.add(" Wands are the basis");
                text.add("for a wizard's quest");
                text.add("into the spiritual ");
                text.add("realm. The wand carver");
                text.add("is essential. Supply");
                text.add("one with a chisel and");
                text.add("wood to produce a ");
                text.add("wand of your liking.");
                //Furnace recipe
                Page.addImageTextPage(gui, gui.getLeft() + xPos, gui.getTop(), new ItemStack(BlockRegistry.wandCarver, 1), text, 50f, 0, -10, false, 45, 0);
                break;
            case 2:
                text.add("  The Wand Chisel is");
                text.add("crafted with an iron");
                text.add("ingot and a stick. It");
                text.add("damages every time you");
                text.add("carve a wand with it.");
                text.add("It can be damaged 10 ");
                text.add("times before it breaks.");
                //2x2 Recipe
                Page.addImageTextPage(gui, gui.getLeft() + xPos, gui.getTop(), new ItemStack(ItemRegistry.chiselTool), text, 50f);
                break;
            case 3:
                text.add("  There are three ");
                text.add("different tiers of wand");
                text.add("carvers, to carve the ");
                text.add("three tiers of wands.");
                //3x3 recipe
                //Page.addCraftingRecipeTextPage(gui, gui.getLeft() + xPos, gui.getTop(), false, text, items, x, y);
                Page.addTextPage(gui, gui.getLeft() + xPos, gui.getTop(), text);
                break;
            case 4:
                text.add("");
                text.add("This is the recipe for");
                text.add("the wand carver. Put it");
                text.add("to good use!");
                items.add(new ItemStack(BlockRegistry.wandCarver));

                // Row 1
                items.add(null);
                items.add(new ItemStack(Blocks.glass));
                items.add(new ItemStack(Blocks.stone_slab, 1, 0));

                // Row 2
                items.add(null);
                items.add(new ItemStack(ItemRegistry.dustsMeta,1,0));
                items.add(new ItemStack(Blocks.stone_slab, 1, 0));

                // Row 3
                items.add(new ItemStack(Blocks.stone_slab, 1, 0));
                items.add(new ItemStack(Blocks.stone_slab, 1, 0));
                items.add(new ItemStack(Blocks.stone_slab, 1, 0));
                Page.addCraftingRecipeTextPage(gui, gui.getLeft() + xPos, gui.getTop(), false, text, items, x, y);
                break;
            case 5:
                text.add("Now, you can craft your");
                text.add("wands!");
                Page.addImageTextPage(gui, gui.getLeft() + xPos, gui.getTop(), new ItemStack(ItemRegistry.magiciansWand, 64), text, 50f, 0, -10, false, 45, 0);
                break;
            /*case 4:
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
                break; */
            default: break;
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
