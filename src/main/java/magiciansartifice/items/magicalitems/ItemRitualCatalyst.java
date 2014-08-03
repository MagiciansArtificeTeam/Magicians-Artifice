package magiciansartifice.items.magicalitems;

import magiciansartifice.MagiciansArtifice;
import magiciansartifice.blocks.BlockRegistry;
import magiciansartifice.items.ItemRegistry;
import magiciansartifice.libs.ModInfo;
import magiciansartifice.spells.rituals.RitualWaterCreation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Created by poppypoppop on 3/08/2014.
 */
public class ItemRitualCatalyst extends Item {
    public ItemRitualCatalyst()
    {
        this.setUnlocalizedName(ModInfo.MODID + ".ritual.catalyst");
        this.setTextureName(ModInfo.MODID + ":magical/ritualCatalyst");
        this.setCreativeTab(MagiciansArtifice.tab);
        ItemRegistry.items.add(this);
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
    {
        if (Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(BlockRegistry.storage, 1, 1).getItem())
        {
            RitualWaterCreation.waterCreation(x, y, z, world, player);
        }

        return false;
    }
}
