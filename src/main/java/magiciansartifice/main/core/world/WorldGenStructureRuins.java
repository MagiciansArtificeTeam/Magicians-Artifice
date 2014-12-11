package magiciansartifice.main.core.world;

import cpw.mods.fml.common.IWorldGenerator;
import magiciansartifice.api.utils.Arrays;
import magiciansartifice.main.core.utils.registries.BlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

/**
 * Created by poppypoppop on 6/12/2014.
 */
public class WorldGenStructureRuins extends WorldGenerator implements IWorldGenerator {
    public WorldGenStructureRuins() {
        Arrays.assignCrumblingItems();
    }

    public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        /**int ruinNum = rand.nextInt(4);
        switch (ruinNum) {
            case 0: Ruins1.generate();
        }
         **/
        Ruins1.generate(rand, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
    }

    public boolean generate(World world, Random rand, int x, int y, int z) {
        return false;
    }
}

class Ruins1 {
    public static void generate(Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        int x = chunkX * 16 + rand.nextInt(16);
        int z = chunkZ * 16 + rand.nextInt(16);
        int y = world.getHeightValue(x, z);

        if (!canPlaceHere(world, x, y, z)) return;

        createBaseStructure(world, x, y, z, Blocks.stonebrick);
        createTowers(world, x, y, z, Blocks.stonebrick);
        crumbleBase(world, x, y, z, rand);
        crumbleTowers(world, x, y, z, rand);
        world.setBlock(x, y + 1, z, BlockRegistry.pedestal);
    }

    private static void createBaseStructure(World world, int x, int y, int z, Block block) {
        int x1 = x;
        int y1 = y;
        int z1 = z - 6;

        world.setBlock(x1, y1, z1, block);
        z1 += 1;
        x1 -= 2;
        for (int i = 0; i <= 4; i++) {
            world.setBlock(x1 + i, y1, z1, block);
        }
        z1 += 1;
        x1 -= 2;
        for (int i = 0; i <= 8; i++) {
            world.setBlock(x1 + i, y1, z1, block);
        }
        z1 += 1;
        for (int i = 0; i <= 8; i++) {
            world.setBlock(x1 + i, y1, z1, block);
        }
        z1 += 1;
        x1 -= 1;
        for (int i = 0; i <= 10; i++) {
            world.setBlock(x1 + i, y1, z1, block);
        }
        z1 += 1;
        for (int i = 0; i <= 10; i++) {
            world.setBlock(x1 + i, y1, z1, block);
        }
        z1 += 1;
        x1 -= 1;
        for (int i = 0; i <= 12; i++) {
            world.setBlock(x1 + i, y1, z1, block);
        }
        z1 += 1;
        x1 += 1;
        for (int i = 0; i <= 10; i++) {
            world.setBlock(x1 + i, y1, z1, block);
        }
        z1 += 1;
        for (int i = 0; i <= 10; i++) {
            world.setBlock(x1 + i, y1, z1, block);
        }
        z1 += 1;
        x1 += 1;
        for (int i = 0; i <= 8; i++) {
            world.setBlock(x1 + i, y1, z1, block);
        }
        z1 += 1;
        for (int i = 0; i <= 8; i++) {
            world.setBlock(x1 + i, y1, z1, block);
        }
        z1 += 1;
        x1 += 2;
        for (int i = 0; i <= 4; i++) {
            world.setBlock(x1 + i, y1, z1, block);
        }
        z1 += 1;
        x1 += 2;
        world.setBlock(x1, y1, z1, block);
    }

    private static void createTowers(World world, int x, int y, int z, Block block) {
        int x1 = x;
        int y1 = y;
        int z1 = z - 6;

        for (int i = 0; i < 5; i++) {
            world.setBlock(x1, y1 + i, z1, block);
        }
        world.setBlock(x1, y1 + 5, z1, Blocks.stonebrick, 3, 1);
        x1 -= 4;
        z1 += 2;
        for (int i = 0; i < 5; i++) {
            world.setBlock(x1, y1 + i, z1, block);
        }
        world.setBlock(x1, y1 + 5, z1, Blocks.stonebrick, 3, 1);
        x1 += 8;
        for (int i = 0; i < 5; i++) {
            world.setBlock(x1, y1 + i, z1, block);
        }
        world.setBlock(x1, y1 + 5, z1, Blocks.stonebrick, 3, 1);
        x1 -= 10;
        z1 += 4;
        for (int i = 0; i < 5; i++) {
            world.setBlock(x1, y1 + i, z1, block);
        }
        world.setBlock(x1, y1 + 5, z1, Blocks.stonebrick, 3, 1);
        x1 += 12;
        for (int i = 0; i < 5; i++) {
            world.setBlock(x1, y1 + i, z1, block);
        }
        world.setBlock(x1, y1 + 5, z1, Blocks.stonebrick, 3, 1);
        x1 -= 10;
        z1 += 4;
        for (int i = 0; i < 5; i++) {
            world.setBlock(x1, y1 + i, z1, block);
        }
        world.setBlock(x1, y1 + 5, z1, Blocks.stonebrick, 3, 1);
        x1 += 8;
        for (int i = 0; i < 5; i++) {
            world.setBlock(x1, y1 + i, z1, block);
        }
        world.setBlock(x1, y1 + 5, z1, Blocks.stonebrick, 3, 1);
        x1 -= 4;
        z1 += 2;
        for (int i = 0; i < 5; i++) {
            world.setBlock(x1, y1 + i, z1, block);
        }
        world.setBlock(x1, y1 + 5, z1, Blocks.stonebrick, 3, 1);
    }

    private static void crumbleBase(World world, int x, int y, int z, Random rand) {
        int x1 = x - 6;
        int y1 = y;
        int z1 = z - 6;
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 13; j++) {
                if (world.getBlock(x1 + j, y1, z1 + i).equals(Blocks.stonebrick)) {
                    int chance = rand.nextInt(100);
                    int percentage = rand.nextInt(100);
                    if (chance >= 25) {
                        if (percentage >= 30) doSolid(world, x1 + j, y1, z1 + i, rand);
                        else doNonSolid(world, x1 + j, y1, z1 + i, rand);
                    }
                }
            }
        }
    }

    private static void crumbleTowers(World world, int x, int y, int z, Random rand) {
        int x1 = x - 6;
        int y1 = y + 1;
        int z1 = z - 6;
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 13; j++) {
                for (int k = 0; k < 4; k++) {
                    if (world.getBlock(x1 + j, y1 + k, z1 + i).equals(Blocks.stonebrick)) {
                        int chance = rand.nextInt(100);
                        if (chance >= 25) {
                            doSolid(world, x1 + j, y1 + k, z1 + i, rand);
                        }
                    }
                }
            }
        }
    }

    private static void doNonSolid(World world, int x, int y, int z, Random rand) {
        int random = rand.nextInt(Arrays.nonSolidBlocks.size());
        int metadata = Arrays.nonSolidBlocks.get(random).getItem().getDamage(Arrays.nonSolidBlocks.get(random));
        world.setBlock(x, y, z, Block.getBlockFromItem(Arrays.nonSolidBlocks.get(random).getItem()), metadata, 1);
    }

    private static void doSolid(World world, int x, int y, int z, Random rand) {
        int random = rand.nextInt(Arrays.solidBlocks.size());
        int metadata = Arrays.nonSolidBlocks.get(random).getItem().getDamage(Arrays.nonSolidBlocks.get(random));
        world.setBlock(x, y, z, Block.getBlockFromItem(Arrays.solidBlocks.get(random).getItem()), metadata, 1);
    }

    private static boolean canPlaceHere(World world, int x, int y, int z) {
        if (world.getBlock(x, y, z) == Blocks.water) return false;

        if (y != world.getActualHeight()) return false;

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if(world.getTileEntity(x + j, y + i, z + k) != null) return false;
                }
            }
        }
        return true;
    }
}