package magiciansartifice.main.core.world;

import cpw.mods.fml.common.IWorldGenerator;
import magiciansartifice.main.core.utils.registries.BlockRegistry;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

import java.util.Random;

/**
 * Created by poppypoppop on 19/10/2014.
 */
public class WorldGenTree implements IWorldGenerator {
    public WorldGenTree() {
        super();
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        int x = chunkX * 16 + random.nextInt(16);
        int z = chunkZ * 16 + random.nextInt(16);
        int y = world.getHeightValue(x, z);
        int f = random.nextInt(4);

        if (world.getBlock(x, y, z) != null) return;

        for (int i = 0; i < 11; i++) {
            world.setBlock(x, y + i , z, BlockRegistry.logs, f, f);
        }
        for (int i = 4; i < 10; i++) {
            world.setBlock(x, y + i , z + 1, BlockRegistry.logs, f, f);
            world.setBlock(x, y + i , z - 1, BlockRegistry.logs, f, f);
            world.setBlock(x + 1, y + i , z, BlockRegistry.logs, f, f);
            world.setBlock(x - 1, y + i , z, BlockRegistry.logs, f, f);

        }
        for (int i = 5; i < 10; i++) {
            world.setBlock(x + 1, y + i , z + 1, BlockRegistry.leaves, f, f);
            world.setBlock(x + 1, y + i , z - 1, BlockRegistry.leaves, f, f);
            world.setBlock(x + 1, y + i , z + 1, BlockRegistry.leaves, f, f);
            world.setBlock(x - 1, y + i , z + 1, BlockRegistry.leaves, f, f);
            world.setBlock(x - 1, y + i , z + 1, BlockRegistry.leaves, f, f);
            world.setBlock(x - 1, y + i , z - 1, BlockRegistry.leaves, f, f);
            world.setBlock(x + 1, y + i , z - 1, BlockRegistry.leaves, f, f);
            world.setBlock(x - 1, y + i , z - 1, BlockRegistry.leaves, f, f);
            world.setBlock(x, y + i , z + 2, BlockRegistry.leaves, f, f);
            world.setBlock(x, y + i , z - 2, BlockRegistry.leaves, f, f);
            world.setBlock(x + 2, y + i , z, BlockRegistry.leaves, f, f);
            world.setBlock(x - 2, y + i , z, BlockRegistry.leaves, f, f);

        }
        world.setBlock(x, y + 11, z, BlockRegistry.leaves, f, f);
        world.setBlock(x, y + 10, z + 1, BlockRegistry.leaves, f, f);
        world.setBlock(x, y + 10, z - 1, BlockRegistry.leaves, f, f);
        world.setBlock(x + 1, y + 10, z, BlockRegistry.leaves, f, f);
        world.setBlock(x - 1, y + 10, z, BlockRegistry.leaves, f, f);
    }
}
