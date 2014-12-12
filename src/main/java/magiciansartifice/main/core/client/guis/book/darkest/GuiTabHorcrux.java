package magiciansartifice.main.core.client.guis.book.darkest;

import magiciansartifice.main.core.utils.registries.BlockRegistry;
import magiciansartifice.main.core.client.guis.book.GuiMagicBook;
import magiciansartifice.main.core.client.guis.book.GuiTab;
import magiciansartifice.main.core.client.guis.book.Page;
import magiciansartifice.main.core.utils.registries.ItemRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;

import java.util.ArrayList;

/**
 * Created by Mitchellbrine on 2014.
 */
public class GuiTabHorcrux extends GuiTab {

    public GuiTabHorcrux(int id)
    {
        super("Alma Dividir", id);
    }

    public ItemStack getIcon()
    {
        return new ItemStack(ItemRegistry.horcrux);
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
                text.add("Death is not the ");
                text.add("end. It is only the");
                text.add("beginning. If one ");
                text.add("truly wishes to be a");
                text.add("powerful magician, one");
                text.add("must know how to ");
                text.add("conquer death. When ");
                text.add("life gives you lemons,");
                text.add("make limeade.");
                text.add("");
                text.add("-Grimnwaldor");
                Page.addTextPage(gui, gui.getLeft() + xPos, gui.getTop(), text);
                break;
            case 2:
                text.add("");
                text.add("Death can be ");
                text.add("conquered many ");
                text.add("ways, but one way");
                text.add("is through the ");
                text.add("Alma Dividir!");
                items.add(new ItemStack(ItemRegistry.horcrux));

                // First row
                items.add(new ItemStack(Items.ender_eye));
                items.add(new ItemStack(BlockRegistry.storage,1,2));
                items.add(new ItemStack(Items.ender_eye));

                // Second row
                items.add(new ItemStack(BlockRegistry.storage,1,2));
                items.add(new ItemStack(Items.diamond));
                items.add(new ItemStack(BlockRegistry.storage,1,2));

                // Third row
                items.add(new ItemStack(Items.ender_eye));
                items.add(new ItemStack(BlockRegistry.storage,1,2));
                items.add(new ItemStack(Items.ender_eye));
                Page.addCraftingRecipeTextPage(gui, gui.getLeft() + xPos, gui.getTop(), false, text, items,x,y);
                break;
            case 3:
                text.add("Once the Alma ");
                text.add("Dividir is crafted,");
                text.add("a soul needs to be ");
                text.add("taken to bound it to");
                text.add("its owner. One can ");
                text.add("kill a Wither (SSP)");
                text.add("or a player (SMP)");
                text.add("to bind an Alma Dividir");
                text.add("to themselves.");
                Page.addImageTextPage(gui, gui.getLeft() + xPos, gui.getTop(), new ItemStack(Items.skull, 1, 3), text, 50f, 0, -10, false, 45, 0);
                break;
            case 4:
                ItemStack horcrux = new ItemStack(ItemRegistry.horcrux);
                horcrux.stackTagCompound = new NBTTagCompound();
                horcrux.getTagCompound().setString("ownerName","Grimnwaldor");
                text.add("");
                text.add("One must be");
                text.add("careful when");
                text.add("hiding these Alma");
                text.add("Dividirs because one");
                text.add("can come and destroy ");
                text.add("it if found.");
                items.add(new ItemStack(ItemRegistry.spiderFang));
                items.add(horcrux);
                items.add(new ItemStack(ItemRegistry.spiderFang));
                Page.addCraftingRecipeTextPage(gui, gui.getLeft() + xPos, gui.getTop(), true, text, items,x,y);
                break;
            case 5:
                text.add("There is a chance");
                text.add("when you \"die\" that");
                text.add("the Alma Dividir will");
                text.add("pop out of the chest.");
                text.add("Since the Alma Dividirs");
                text.add("don't despawn, they ");
                text.add("can be placed ");
                text.add("anywhere to hide them.");
                text.add("");
                text.add(EnumChatFormatting.DARK_RED + "WARNING ------>");
                Page.addTextPage(gui, gui.getLeft() + xPos, gui.getTop(), text);
                break;
            case 6:
                text.add("If you decide to bind");
                text.add("your soul more than ");
                text.add("once, there is a small ");
                text.add("chance that you will die ");
                text.add("and an Alma Dividir will ");
                text.add("be destroyed. You have");
                text.add("been" + EnumChatFormatting.DARK_RED + " WARNED!");
                Page.addTextPage(gui, gui.getLeft() + xPos, gui.getTop(), text);
            default:;
        }
    }

    public int getMaxPages()
    {
        return 6;
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
