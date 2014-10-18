package magiciansartifice.main.core.world;

import magiciansartifice.main.blocks.BlockRegistry;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

/**
 * Created by poppypoppop on 19/10/2014.
 */
public class WorldGenTree extends WorldGenerator {
    public WorldGenTree() {
        super(false);
    }

    @Override
    public boolean generate(World world, Random random, int x, int y, int z) {
        Random rand = new Random();
        int f = rand.nextInt(4);
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

        return false;
    }
}
