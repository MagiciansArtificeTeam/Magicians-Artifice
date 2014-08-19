package magiciansartifice.main.items.tools;

import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.items.ItemRegistry;
import magiciansartifice.main.core.libs.ModInfo;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import java.util.List;

public class ItemMagicBook extends Item {

    public ItemMagicBook() {
        this.setUnlocalizedName("basic.book");
        this.setTextureName(ModInfo.MODID + ":tools/book");
        this.setCreativeTab(MagiciansArtifice.tab);
        ItemRegistry.items.add(this);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        if (world.isRemote) {
            player.openGui(MagiciansArtifice.instance, 2, world, 0, 0, 0);
        }

        return stack;
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List lore, boolean par4) {
        lore.add("by 'The White-Eyed One'");
        lore.add(EnumChatFormatting.ITALIC + "Notes by Merlin");
    }
}