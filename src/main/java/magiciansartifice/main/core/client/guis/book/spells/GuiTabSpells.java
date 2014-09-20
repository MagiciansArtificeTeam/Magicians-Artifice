package magiciansartifice.main.core.client.guis.book.spells;

import magiciansartifice.main.core.client.guis.book.GuiMagicBook;
import magiciansartifice.main.core.client.guis.book.GuiTab;
import magiciansartifice.main.core.client.guis.book.Page;
import magiciansartifice.main.items.ItemRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import java.util.ArrayList;

/**
 * Created by Mitchellbrine on 2014.
 */
@SuppressWarnings("unused")
public class GuiTabSpells extends GuiTab {

    public GuiTabSpells(int id)
    {
        super("Spells", id);
    }

    public ItemStack getIcon()
    {
        return new ItemStack(ItemRegistry.magiciansWand3);
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
                text.add(EnumChatFormatting.DARK_BLUE + "" + EnumChatFormatting.UNDERLINE + "Feitizo de levitación");
                text.add("Wand Tier: 1");
                text.add("Type: Left-click");
                text.add("");
                text.add(EnumChatFormatting.DARK_GREEN + "Essence Used:");
                text.add(EnumChatFormatting.DARK_GREEN + "O: 1");
                text.add("");
                text.add("Not-Shifting: Rises mob");
                text.add("Shifting: Holds mob");
                Page.addImageTextPage(gui, gui.getLeft() + xPos, gui.getTop(), new ItemStack(ItemRegistry.magiciansWand), text, 50f, 0, -10, false, 45, 0);
                break;
            case 2:
                text.add(EnumChatFormatting.DARK_BLUE + "" + EnumChatFormatting.UNDERLINE + "Cor de ovella");
                text.add("Wand Tier: 1");
                text.add("Type: Right-click");
                text.add("");
                text.add(EnumChatFormatting.DARK_GREEN + "Essence Used:");
                text.add(EnumChatFormatting.DARK_GREEN + "O: 2");
                text.add("");
                text.add("Changes sheep's color");
                Page.addImageTextPage(gui, gui.getLeft() + xPos, gui.getTop(), new ItemStack(ItemRegistry.magiciansWand), text, 50f, 0, -10, false, 45, 0);
                break;
            case 3:
                text.add(EnumChatFormatting.DARK_BLUE + "" + EnumChatFormatting.UNDERLINE + "Feitizo de contención");
                text.add("Wand Tier: 2");
                text.add("Type: Right-click");
                text.add("");
                text.add(EnumChatFormatting.DARK_GREEN + "Essence Used:");
                text.add(EnumChatFormatting.DARK_GREEN + "O: 2 | " + EnumChatFormatting.DARK_RED + "N: 4");
                text.add("");
                text.add("Activates/Deactivates ");
                text.add("containment field");
                Page.addImageTextPage(gui, gui.getLeft() + xPos, gui.getTop(), new ItemStack(ItemRegistry.magiciansWand2), text, 50f, 0, -10, false, 45, 0);
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
    }

    @Override
    public void drawForeground(GuiMagicBook gui, int x, int y, int page)
    {
    }
}
