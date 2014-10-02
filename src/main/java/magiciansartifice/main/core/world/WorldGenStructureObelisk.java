package magiciansartifice.main.core.world;

import cpw.mods.fml.common.IWorldGenerator;
import magiciansartifice.main.blocks.BlockRegistry;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;
import org.lwjgl.Sys;

import java.util.Random;

/**
 * Created by poppypoppop on 2/10/2014.
 */
public class WorldGenStructureObelisk extends WorldGenerator implements IWorldGenerator {
    Random rand = new Random();

    public WorldGenStructureObelisk() {

    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        if (world.provider.dimensionId != 1 || world.provider.dimensionId != -1) {
            generateObelisk(world, random, chunkX, chunkZ);
        }
    }

    public void generateObelisk(World world, Random rand, int chunkX, int chunkZ) {
        int y = world.getHeightValue(chunkX, chunkZ);

        System.out.println("Generating an Obelisk at: " + chunkX * 16 + " " + y + " " + chunkZ * 16);

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    world.setBlockToAir(chunkX + j, y + i, chunkZ + k);
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                world.setBlock(chunkX + i, y, chunkZ + j, BlockRegistry.containmentRing);
            }
        }

        for (int i = 0; i < 4; i++) {
            world.setBlock(chunkX + 1, y + i + 1, chunkZ + 1, BlockRegistry.containmentPillar);
        }

        world.setBlock(chunkX + 1, y + 5, chunkZ + 1, BlockRegistry.containmentTop);
    }

    @Override
    public boolean generate(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
        return false;
    }
}
