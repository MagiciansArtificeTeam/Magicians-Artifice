package magiciansartifice.items.misc;

import magiciansartifice.MagiciansArtifice;
import magiciansartifice.items.ItemRegistry;
import magiciansartifice.libs.ModInfo;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import java.util.List;

public class ItemLetterMerlin extends Item {
    public ItemLetterMerlin() {
        this.setTextureName(ModInfo.MODID + ":misc/merlinLetter");
        this.setUnlocalizedName("merlinLetter");
        this.setCreativeTab(MagiciansArtifice.tab);
        ItemRegistry.items.add(this);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        if (!world.isRemote) {
            player.addChatComponentMessage(new ChatComponentTranslation("merlin.letter.header").setChatStyle(new ChatStyle().setItalic(true).setBold(true)));
            player.addChatComponentMessage(new ChatComponentTranslation("merlin.letter.body"));
            player.addChatComponentMessage(new ChatComponentText(""));
            player.addChatComponentMessage(new ChatComponentTranslation("merlin.letter.ending").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.DARK_BLUE)));

            for (int i = 0; i < player.inventory.getSizeInventory();i++) {
                if (player.inventory.getStackInSlot(i) != null) {
                    if (player.inventory.getStackInSlot(i).getItem() == ItemRegistry.merlinLetter) {
                        player.inventory.setInventorySlotContents(i,new ItemStack(ItemRegistry.book,1));
                    }
                }
            }

            return stack;
        }
        return stack;
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List lore, boolean par4) {
        lore.add(EnumChatFormatting.DARK_RED + "" + EnumChatFormatting.ITALIC + "This letter has an odd seal... You wonder who it is from...");
    }
}
