package magiciansartifice.main.items.magicalitems;

import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.blocks.BlockRegistry;
import magiciansartifice.main.core.libs.ModInfo;
import magiciansartifice.main.items.ItemRegistry;
import net.minecraft.block.BlockLog;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created by Mitchellbrine on 2014.
 */
public class ItemTreeMutation extends Item {

    public ItemTreeMutation() {
        super();
        this.setCreativeTab(MagiciansArtifice.tab);
        this.setUnlocalizedName("treeMutation");
        this.setTextureName(ModInfo.MODID + ":misc/bonemeal");
        ItemRegistry.items.add(this);
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int meta, float hitX, float hitY, float hitZ) {
        itemRand = new Random(world.getWorldTime());
        if (!world.isRemote) {
            if (world.getBlock(x, y, z) == Blocks.log || world.getBlock(x, y, z) == Blocks.log2) {
                if (itemRand.nextInt(100) >= 75) {
                    if (itemRand.nextInt(100) < 90) {
                        switch (itemRand.nextInt(4)) {
                            case 0:
                                world.setBlock(x, y, z, BlockRegistry.logs, 0, 3);
                                break;
                            case 1:
                                world.setBlock(x, y, z, BlockRegistry.logs, 3, 3);
                                break;
                            case 2:
                                world.setBlock(x, y, z, BlockRegistry.logs, 2, 3);
                                break;
                            case 3:
                                world.setBlock(x, y, z, BlockRegistry.logs, 3, 3);
                                break;
                            default:
                                world.setBlock(x, y, z, BlockRegistry.logs, 3, 3);
                                break;
                        }
                    } else {
                        world.setBlock(x, y, z, BlockRegistry.logs, 1, 3);
                    }
                    world.playSoundAtEntity(player,ModInfo.MODID + ":magic",1.0F,1.0F);
                }
                stack.stackSize--;
                return true;
            }
        }
        player.swingItem();
        return false;
    }
}
