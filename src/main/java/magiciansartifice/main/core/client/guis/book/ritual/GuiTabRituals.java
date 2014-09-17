package magiciansartifice.main.core.client.guis.book.ritual;

import magiciansartifice.main.core.client.guis.book.GuiMagicBook;
import magiciansartifice.main.core.client.guis.book.GuiTab;
import magiciansartifice.main.core.client.guis.book.Page;
import magiciansartifice.main.items.ItemRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;

@SuppressWarnings("unused")
public class GuiTabRituals extends GuiTab{

    public GuiTabRituals(int id)
    {
        super("Ritual Beginnings", id);
    }

    public ItemStack getIcon()
    {
        return new ItemStack(ItemRegistry.ritualCatalyst);
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
                text.add("");
                text.add("The first thing you, ");
                text.add("will need for rituals ");
                text.add("is your trusty ritual ");
                text.add("catalyst. It can be ");
                text.add("crafted as so.");
                items.add(new ItemStack(ItemRegistry.ritualCatalyst));
                items.add(new ItemStack(Blocks.cobblestone));
                items.add(new ItemStack(Blocks.cobblestone));
                items.add(null);

                items.add(null);
                items.add(new ItemStack(Blocks.cobblestone));
                items.add(new ItemStack(ItemRegistry.dustsMeta,1,1));

                items.add(new ItemStack(Blocks.cobblestone));
                items.add(null);
                items.add(new ItemStack(Blocks.cobblestone));

                Page.addCraftingRecipeTextPage(gui, gui.getLeft() + xPos, gui.getTop(), false, text, items,x,y);
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
