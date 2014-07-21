package magiciansartifice.items;

import magiciansartifice.MagiciansArtifice;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemMagicBook extends Item {

    static {
        ItemRegistry.prepareForRegister(new ItemMagicBook());
    }

    public ItemMagicBook() {
        this.setUnlocalizedName("book");
        this.setTextureName("magiciansartifice:book");
        this.setCreativeTab(MagiciansArtifice.tab);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        if (world.isRemote) {
            player.openGui(MagiciansArtifice.instance, 2, world, 0, 0, 0);
        }

        return stack;
    }
}