package magiciansartifice.main.core.world;

import cpw.mods.fml.common.IWorldGenerator;
import magiciansartifice.main.blocks.BlockRegistry;
import magiciansartifice.main.core.libs.ConfigHandler;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

/**
 * Created by poppypoppop on 2/10/2014.
 */
public class WorldGenStructureObelisk extends WorldGenerator implements IWorldGenerator {
    public WorldGenStructureObelisk() { }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        if (world.provider.dimensionId != 1 || world.provider.dimensionId != -1) {
            generateObelisk(world, random, chunkX, chunkZ);
        }
    }

    public void generateObelisk(World world, Random rand, int chunkX, int chunkZ) {
        int x = chunkX * 16 + rand.nextInt(16);
        int z = chunkZ * 16 + rand.nextInt(16);
        int y = world.getHeightValue(x, z);

        if (ConfigHandler.obeliskRarity > 100 || ConfigHandler.obeliskRarity <= 0) return;
        if (rand.nextInt(100) < ConfigHandler.obeliskRarity) return;
        if (canPlaceHere(world, x, y, z)) return;

        System.out.println("Spawning an Obelisk at: " + x + " " + y + " " + z);

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    world.setBlockToAir(x + j, y + i, z + k);
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                world.setBlock(x + i, y, z + j, BlockRegistry.containmentRing);
            }
        }

        for (int i = 0; i < 4; i++) {
            world.setBlock(x + 1, y + i + 1, z + 1, BlockRegistry.containmentPillar);
        }

        world.setBlock(x + 1, y + 5, z + 1, BlockRegistry.containmentTop);
    }

    private boolean canPlaceHere(World world, int x, int y, int z) {
        if (world.getBlock(x, y - 1, z) != Blocks.stone) return false;
        if (world.getBlock(x, y - 1, z) != Blocks.grass) return false;
        if (world.getBlock(x, y - 1, z) != Blocks.sand) return false;

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if(world.getTileEntity(x + j, y + i, z + k) != null) return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean generate(World world, Random rand, int x, int y, int z) {
        return false;
    }
}
