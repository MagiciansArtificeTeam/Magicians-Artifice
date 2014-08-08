package magiciansartifice.spells.rituals;

import magiciansartifice.api.BasicRitual;
import magiciansartifice.blocks.BlockRegistry;
import magiciansartifice.tileentities.magic.TileEntityTeleportReciever;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Created by poppypoppop on 8/08/2014.
 */
public class RitualTeleport extends BasicRitual {
    public void startRitual(int x, int y, int z, World world, EntityPlayer player) { super.startRitual(x, y, z, world, player); }

    public boolean areAllBlocksCorrect(int x, int y, int z, World world, EntityPlayer player) {
        int x1 = x;
        int y1 = y;
        int z1 = z;
        z -= 2;
        for (int i = 0; i < 5; i++) {
            if (world.getBlock(x - 2, y, z + i) == BlockRegistry.storage) {
                if (!(world.getBlockMetadata(x - 2, y, z + i) == 0)) {
                    return false;
                }
            }
        }

        for (int i = 0; i < 5; i++) {
            if (world.getBlock(x - 2, y, z + i) == BlockRegistry.storage) {
                if (!(world.getBlockMetadata(x + 2, y, z + i) == 0)) {
                    return false;
                }
            }
        }

        x -= 2;
        for (int i = 0; i < 5; i++) {
            if (world.getBlock(x + i, y, z) == BlockRegistry.storage) {
                if (!(world.getBlockMetadata(x + i, y, z) == 0)) {
                    return false;
                }
            }
        }

        for (int i = 0; i < 5; i++) {
            if (world.getBlock(x + i, y, z + 4) == BlockRegistry.storage) {
                if (!(world.getBlockMetadata(x + i, y, z) == 0)) {
                    return false;
                }
            }
        }

        x += 1;
        for (int i = 0; i < 3; i++) {
            if (!(Item.getItemFromBlock(world.getBlock(x + i, y, z + 3)) == new ItemStack(Blocks.stonebrick, 1, 3).getItem())) {
                return false;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (!(Item.getItemFromBlock(world.getBlock(x + i, y, z + 3)) == new ItemStack(Blocks.stonebrick, 1, 3).getItem() || world.getBlock(x + i, y, z + 2) == BlockRegistry.ritualCornerStone)) {
                return false;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (!(Item.getItemFromBlock(world.getBlock(x + i, y, z + 3)) == new ItemStack(Blocks.stonebrick, 1, 3).getItem())) {
                return false;
            }
        }
        return true;
    }

    public void initEffect(int x, int y, int z, World world, EntityPlayer player) {
        //TileEntityTeleportReciever te = (TileEntityTeleportReciever) world.getTileEntity(x, y, z);
        //player.setPosition((double)te.getX(), (double)te.getY() + 1, (double) te.getZ());
    }
}
