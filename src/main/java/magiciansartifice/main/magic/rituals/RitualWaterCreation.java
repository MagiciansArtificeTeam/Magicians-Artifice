package magiciansartifice.main.magic.rituals;

import magiciansartifice.api.BasicRitual;
import magiciansartifice.main.core.utils.registries.BlockRegistry;
import magiciansartifice.main.fluids.LiquidRegistry;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

import java.util.Random;

@SuppressWarnings("unused")
public class RitualWaterCreation extends BasicRitual {

    public static Random itemRand = new Random();

    public void startRitual(int x, int y, int z, World world, EntityPlayer player) {
        super.startRitual(x, y, z, world, player);
    }

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
            if (!(world.getBlock(x + i, y, z + 3) == Blocks.water)) {
                return false;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (!(world.getBlock(x + i, y, z + 2) == Blocks.water || world.getBlock(x + i, y, z + 2) == BlockRegistry.ritualCornerStone)) {
                return false;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (!(world.getBlock(x + i, y, z + 1) == Blocks.water)) {
                return false;
            }
        }
        return true;
    }

    public void initEffect(int x, int y, int z, World world, EntityPlayer player) {
        x -= 1;
        z -= 1;

        for (int i = 0; i < 3; i++) {
            world.setBlockToAir(x + i, y, z);
            world.spawnEntityInWorld(new EntityLightningBolt(world, (double) x + i, (double) y + 1, (double) z));
            world.setBlock(x + i, y, z, LiquidRegistry.magicWaterBlock);
        }

        z += 1;
        for (int i = 0; i < 3; i++) {
            world.setBlockToAir(x + i, y, z);
            world.spawnEntityInWorld(new EntityLightningBolt(world, (double) x + i, (double) y + 1, (double) z));
            world.setBlock(x + i, y, z, LiquidRegistry.magicWaterBlock);
        }

        z += 1;
        for (int i = 0; i < 3; i++) {
            world.setBlockToAir(x + i, y, z);
            world.spawnEntityInWorld(new EntityLightningBolt(world, (double) x + i, (double) y + 1, (double) z));
            world.setBlock(x + i, y, z, LiquidRegistry.magicWaterBlock);
        }

        x += 1;
        z -= 1;
        world.setBlock(x, y, z, BlockRegistry.ritualCornerStone);
    }
}
