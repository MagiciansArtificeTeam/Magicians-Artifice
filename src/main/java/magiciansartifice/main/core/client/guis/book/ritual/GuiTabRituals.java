package magiciansartifice.main.core.client.guis.book.ritual;

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
            case 2:
                text.add(EnumChatFormatting.DARK_BLUE + "" + EnumChatFormatting.UNDERLINE + "Ritual of Cura");
                text.add(EnumChatFormatting.DARK_BLUE + "CASAC");
                text.add(EnumChatFormatting.DARK_BLUE + "AWWWA");
                text.add(EnumChatFormatting.DARK_BLUE + "SWRWS");
                text.add(EnumChatFormatting.DARK_BLUE + "AWWWA");
                text.add(EnumChatFormatting.DARK_BLUE + "CASAC");
                text.add("S = Stone Brick");
                text.add("C = Chiseled SB");
                text.add("A = Angel Orchid");
                text.add("W = Ashwood Planks");
                text.add("R = Ritual CornerStone");
                Page.addImageTextPage(gui, gui.getLeft() + xPos, gui.getTop(), new ItemStack(BlockRegistry.ritualCornerStone, 1), text, 50f, 0, -10, false, 45, 0);
                break;
            case 3:
                text.add(EnumChatFormatting.DARK_BLUE + "" + EnumChatFormatting.UNDERLINE + "Ritual of Máxico do");
                text.add(EnumChatFormatting.DARK_BLUE + "CEESSSEEC");
                text.add(EnumChatFormatting.DARK_BLUE + "ENNNONNNE");
                text.add(EnumChatFormatting.DARK_BLUE + "ENWWOWWNE");
                text.add(EnumChatFormatting.DARK_BLUE + "SNWVVVWNS");
                text.add(EnumChatFormatting.DARK_BLUE + "SOOVRVOOS");
                text.add(EnumChatFormatting.DARK_BLUE + "SNWVVVWNS");
                text.add(EnumChatFormatting.DARK_BLUE + "ENWWOWWNE");
                text.add(EnumChatFormatting.DARK_BLUE + "ENNNONNNE");
                text.add(EnumChatFormatting.DARK_BLUE + "CEESSSEEC");
                Page.addImageTextPage(gui, gui.getLeft() + xPos, gui.getTop(), new ItemStack(BlockRegistry.ritualCornerStone, 1), text, 50f, 0, -10, false, 45, 0);
                break;
            case 4:
                text.add("S = Stone Brick");
                text.add("C = Chiseled SB");
                text.add("A = Angel Orchid");
                text.add("W = Ashwood Planks");
                text.add("R = Ritual Cornerstone");
                text.add("E = Elm Planks");
                text.add("O = Overworld Essence");
                text.add("N = Nether Essence");
                text.add("V = Ender Essence");
                text.add("");
                text.add(EnumChatFormatting.LIGHT_PURPLE + "Requires containment!");
                Page.addTextPage(gui, gui.getLeft() + xPos, gui.getTop(), text);
                break;
            case 5:
                text.add(EnumChatFormatting.DARK_BLUE + "" + EnumChatFormatting.UNDERLINE + "Ritual of End Essence");
                text.add(EnumChatFormatting.DARK_BLUE + "ONO");
                text.add(EnumChatFormatting.DARK_BLUE + "NRN");
                text.add(EnumChatFormatting.DARK_BLUE + "ONO");
                text.add("");
                text.add("R = Ritual Cornerstone");
                text.add("O = Overworld Essence");
                text.add("N = Nether Essence");
                Page.addImageTextPage(gui, gui.getLeft() + xPos, gui.getTop(), new ItemStack(BlockRegistry.ritualCornerStone, 1), text, 50f, 0, -10, false, 45, 0);
                break;
            case 6:
                text.add("");
                text.add("");
                text.add("");
                text.add("");
                text.add(EnumChatFormatting.LIGHT_PURPLE + "" + EnumChatFormatting.ITALIC + "- Useful if The End");
                text.add(EnumChatFormatting.LIGHT_PURPLE + "" + EnumChatFormatting.ITALIC + "is already generated!");
                Page.addTextPage(gui, gui.getLeft() + xPos, gui.getTop(), text);
                break;
            case 7:
                text.add(EnumChatFormatting.DARK_BLUE + "" + EnumChatFormatting.UNDERLINE + "Arbore que medra");
                text.add(EnumChatFormatting.DARK_BLUE + "OSO");
                text.add(EnumChatFormatting.DARK_BLUE + "SRS");
                text.add(EnumChatFormatting.DARK_BLUE + "OSO");
                Page.addImageTextPage(gui, gui.getLeft() + xPos, gui.getTop(), new ItemStack(BlockRegistry.ritualCornerStone, 1), text, 50f, 0, -10, false, 45, 0);
                break;
            case 8:
                text.add("R = Ritual Cornerstone");
                text.add("O = Overworld Essence");
                text.add("S = Oak Sapling");
                text.add("");
                text.add(EnumChatFormatting.LIGHT_PURPLE + "" + EnumChatFormatting.ITALIC + "(Is currently buggy)");
                Page.addTextPage(gui, gui.getLeft() + xPos, gui.getTop(), text);
            default:;
        }
    }

    public int getMaxPages()
    {
        return 8;
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
