package magiciansartifice.main.core.client.guis.book.unforgivable;

import magiciansartifice.main.core.utils.registries.BlockRegistry;
import magiciansartifice.main.core.client.guis.book.GuiMagicBook;
import magiciansartifice.main.core.client.guis.book.GuiTab;
import magiciansartifice.main.core.client.guis.book.Page;
import magiciansartifice.main.core.utils.registries.ItemRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import java.util.ArrayList;

@SuppressWarnings("unused")
public class GuiTabRituals extends GuiTab{

    public GuiTabRituals(int id)
    {
        super("Rituals", id);
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
                text.add("catalyst. You should ");
                text.add("know how to craft it.");
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
            case 2:
                text.add("Most of these rituals");
                text.add("require you to contain");
                text.add("it. They may have nasty");
                text.add("effects if unconstrained.");
                text.add("Keep that in mind, you ");
                text.add("have been " + EnumChatFormatting.DARK_RED + "WARNED!");
                text.add("-\"The Mischievous One\"");
                Page.addTextPage(gui, gui.getLeft() + xPos, gui.getTop(), text);
                break;
            case 3:
                text.add(EnumChatFormatting.DARK_BLUE + "" + EnumChatFormatting.UNDERLINE + "Ritual of Morte");
                text.add(EnumChatFormatting.DARK_BLUE + " CHC ");
                text.add(EnumChatFormatting.DARK_BLUE + "C W  C");
                text.add(EnumChatFormatting.DARK_BLUE + "HWRWH");
                text.add(EnumChatFormatting.DARK_BLUE + "C W  C");
                text.add(EnumChatFormatting.DARK_BLUE + " CHC ");
                Page.addImageTextPage(gui, gui.getLeft() + xPos, gui.getTop(), new ItemStack(BlockRegistry.ritualCornerStone, 1), text, 50f, 0, -10, false, 45, 0);
                break;
            case 4:
                text.add("C = Chiseled SB");
                text.add("W = Ashwood Planks");
                text.add("R = Ritual Cornerstone");
                text.add("H = Wither Skeleton Skull");
                text.add("");
                text.add(EnumChatFormatting.LIGHT_PURPLE + "Requires containment!");
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
