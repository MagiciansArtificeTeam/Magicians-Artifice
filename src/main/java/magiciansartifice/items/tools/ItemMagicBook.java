package magiciansartifice.items.tools;

import magiciansartifice.MagiciansArtifice;
import magiciansartifice.items.ItemRegistry;
import magiciansartifice.libs.ModInfo;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;

public class ItemMagicBook extends Item {

    public ItemMagicBook() {
        this.setUnlocalizedName(ModInfo.MODID + ".book");
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
        lore.add("by Merlin");
    }
}