package magiciansartifice.main.core.client.guis.book.basic;

import magiciansartifice.main.blocks.BlockRegistry;
import magiciansartifice.main.core.client.guis.book.GuiMagicBook;
import magiciansartifice.main.core.client.guis.book.GuiTab;
import magiciansartifice.main.core.client.guis.book.Page;
import magiciansartifice.main.core.utils.TextHelper;
import magiciansartifice.main.items.ItemRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import java.util.ArrayList;

public class GuiTabTier1 extends GuiTab
{

    public GuiTabTier1(int id)
    {
        super("Magician's Wand [Tier 1]", id);
    }

    public ItemStack getIcon()
    {
        return new ItemStack(ItemRegistry.magiciansWand);
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
                text.add(EnumChatFormatting.DARK_BLUE + "" + EnumChatFormatting.UNDERLINE + "Magician's Wand [Tier 1]");
                text.add("");
                text.add(EnumChatFormatting.DARK_GREEN + "Wood Used:");
                text.add(EnumChatFormatting.DARK_GREEN + "Oak Wood Log");
                text.add(" ");
                text.add(EnumChatFormatting.DARK_AQUA + "Chisel Tier:");
                text.add(EnumChatFormatting.DARK_AQUA + "1+");
                text.add(" ");
                text.add(EnumChatFormatting.GREEN + "Max Essence:");
                text.add(EnumChatFormatting.GREEN + "O: 25");
                text.add(" ");
                //Furnace recipe
                Page.addImageTextPage(gui, gui.getLeft() + xPos, gui.getTop(), new ItemStack(ItemRegistry.magiciansWand, 1), text, 50f, 0, -10, false, 45, 0);
                break;
            case 2:
                text.add(EnumChatFormatting.LIGHT_PURPLE + "Spells Wand Can Cast:");
                text.add(EnumChatFormatting.LIGHT_PURPLE + TextHelper.localize("spell.levitation"));
                text.add(EnumChatFormatting.LIGHT_PURPLE + TextHelper.localize("spell.sheep"));
                text.add("");
                text.add("");
                text.add(EnumChatFormatting.ITALIC + "This is your first wand.");
                text.add(EnumChatFormatting.ITALIC + "Treat it well. -M");
                //2x2 Recipe
                Page.addImageTextPage(gui, gui.getLeft() + xPos, gui.getTop(), new ItemStack(ItemRegistry.magiciansWand, 1), text, 50f, 0, -10, false, 45, 0);
                break;
            /*case 3:
                text.add("  There are three ");
                text.add("different tiers of wand");
                text.add("carvers, to carve the ");
                text.add("three tiers of wands.");
                //3x3 recipe
                //Page.addCraftingRecipeTextPage(gui, gui.getLeft() + xPos, gui.getTop(), false, text, items, x, y);
                Page.addTextPage(gui, gui.getLeft() + xPos, gui.getTop(), text);
                break;
            case 4:
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
