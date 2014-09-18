package magiciansartifice.main.core.world;

import java.util.Random;

import magiciansartifice.main.blocks.BlockRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderEnd;
import net.minecraft.world.gen.ChunkProviderHell;
import net.minecraft.world.gen.feature.WorldGenFlowers;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class GenerationHandler implements IWorldGenerator {
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        if (!(chunkGenerator instanceof ChunkProviderHell) && !(chunkGenerator instanceof ChunkProviderEnd)) {
            generateSurface(world, random, chunkX * 16, chunkZ * 16);
        } else if (chunkGenerator instanceof ChunkProviderHell) {
            generateNether(world, random, chunkX * 16, chunkZ * 16);
        } else if (chunkGenerator instanceof ChunkProviderEnd) {
            generateEnd(world, random, chunkX * 16, chunkZ * 16);
        }
    }

    private void generateSurface(World world, Random rand, int chunkX, int chunkZ) {
        for (int k = 0; k < 10; k++) {
            int firstBlockXCoord = chunkX + rand.nextInt(16);
            int firstBlockZCoord = chunkZ + rand.nextInt(16);
            int firstBlockYCoord = rand.nextInt(60);
            int secondBlockYCoord = rand.nextInt(10);

            (new WorldGenMinable(BlockRegistry.ores, 0, 12, Blocks.stone)).generate(world, rand, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
            (new WorldGenMinable(BlockRegistry.oresOres, 0, 12, Blocks.stone)).generate(world, rand, firstBlockXCoord, secondBlockYCoord, firstBlockZCoord);
        }
        int firstBlockXCoord = chunkX + rand.nextInt(16);
        int firstBlockZCoord = chunkZ + rand.nextInt(16);
        int thirdBlockYCoord = rand.nextInt(70);
        
        (new WorldGenEssenceHole(BlockRegistry.essenceHole, 0)).generate(world, rand, firstBlockXCoord, thirdBlockYCoord, firstBlockZCoord);
        (new WorldGenFlowers(BlockRegistry.angelOrchid)).generate(world, rand, firstBlockXCoord, thirdBlockYCoord, firstBlockZCoord);
    }

    private void generateNether(World world, Random rand, int chunkX, int chunkZ) {
        for (int k = 0; k < 10; k++) {
            int firstBlockXCoord = chunkX + rand.nextInt(16);
            int firstBlockZCoord = chunkZ + rand.nextInt(16);
            int firstBlockYCoord = rand.nextInt(60);

            (new WorldGenMinable(BlockRegistry.ores, 1, 12, Blocks.netherrack)).generate(world, rand, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
        }
    }

    private void generateEnd(World world, Random rand, int chunkX, int chunkZ) {
        for (int k = 0; k < 10; k++) {
            int firstBlockXCoord = chunkX + rand.nextInt(16);
            int firstBlockZCoord = chunkZ + rand.nextInt(16);
            int firstBlockYCoord = rand.nextInt(60);

            (new WorldGenMinable(BlockRegistry.ores, 2, 12, Blocks.end_stone)).generate(world, rand, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
        }
    }
}
