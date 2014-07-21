package magiciansartifice.utils;

import cpw.mods.fml.common.IWorldGenerator;
import magiciansartifice.blocks.BlockRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Random;

public class GenerationHandler implements IWorldGenerator {
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.dimensionId) {
            case -1:
                generateNether(world, random, chunkX * 16, chunkZ * 16);
                break;
            case 0:
                generateSurface(world, random, chunkX * 16, chunkZ * 16);
                break;
            case 1:
                generateEnd(world, random, chunkX * 16, chunkZ * 16);
                break;
        }
    }

    private void generateSurface(World world, Random rand, int chunkX, int chunkZ) {
        for (int k = 0; k < 10; k++) {
            int firstBlockXCoord = chunkX + rand.nextInt(16);
            int firstBlockZCoord = chunkZ + rand.nextInt(16);
            int firstBlockYCoord = rand.nextInt(60);

            (new WorldGenMinable(BlockRegistry.ores, 0, 4, Blocks.stone)).generate(world, rand, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
        }
    }

    private void generateNether(World world, Random rand, int chunkX, int chunkZ) {
        for (int k = 0; k < 10; k++) {
            int firstBlockXCoord = chunkX + rand.nextInt(16);
            int firstBlockZCoord = chunkZ + rand.nextInt(16);
            int firstBlockYCoord = rand.nextInt(60);

            (new WorldGenMinable(BlockRegistry.ores, 1, 4, Blocks.stone)).generate(world, rand, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
        }
    }

    private void generateEnd(World world, Random rand, int chunkX, int chunkZ) {
        for (int k = 0; k < 10; k++) {
            int firstBlockXCoord = chunkX + rand.nextInt(16);
            int firstBlockZCoord = chunkZ + rand.nextInt(16);
            int firstBlockYCoord = rand.nextInt(60);

            (new WorldGenMinable(BlockRegistry.ores, 2, 4, Blocks.stone)).generate(world, rand, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
        }
    }
}
