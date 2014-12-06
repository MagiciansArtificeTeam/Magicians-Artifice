package magiciansartifice.main.core.world;

import cpw.mods.fml.common.IWorldGenerator;
import magiciansartifice.main.blocks.BlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by poppypoppop on 6/12/2014.
 */
public class WorldGenStructureRuins extends WorldGenerator implements IWorldGenerator {
    public static ArrayList<Item> solidBlocks = new ArrayList<Item>();
    public static ArrayList<Item> nonSolidBlocks = new ArrayList<Item>();

    public WorldGenStructureRuins() {
        addBlocksToArrays();
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

    public void addBlocksToArrays() {
        for (int i = 0; i <= 3; i++) {
            solidBlocks.add(new ItemStack(Blocks.stonebrick, 1, i).getItem());
        }
        solidBlocks.add(Item.getItemFromBlock(Blocks.cobblestone));
        solidBlocks.add(Item.getItemFromBlock(Blocks.gravel));
        solidBlocks.add(Item.getItemFromBlock(Blocks.mossy_cobblestone));
        nonSolidBlocks.add(new ItemStack(Blocks.stone_slab, 1, 3).getItem());
        nonSolidBlocks.add(new ItemStack(Blocks.stone_slab, 1, 5).getItem());
        for (int i = 0; i <= 3; i++) {
            nonSolidBlocks.add(new ItemStack(Blocks.stone_brick_stairs, 1, i).getItem());
        }
        for (int i = 0; i <= 3; i++) {
            nonSolidBlocks.add(new ItemStack(Blocks.stone_stairs, 1, i).getItem());
        }
    }
}

class Ruins1 {
    public static void generate(Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        int x = chunkX * 16 + rand.nextInt(16);
        int z = chunkZ * 16 + rand.nextInt(16);
        int y = world.getHeightValue(x, z);

        if (canPlaceHere(world, x, y, z)) return;

        createBaseStructure(world, x, y, z);
    }

    private static void createBaseStructure(World world, int x, int y, int z) {
        Block block = Blocks.stonebrick;
        int x1 = x - 6;
        int y1 = y;
        int z1 = z - 6;

        world.setBlock(x1, y1, z1, block);
        z1 += 1;
        for (int i = 0; i <= 4; i++) {
            world.setBlock(x1 + i, y1, z1, block);
        }
        z1 += 1;
        for (int i = 0; i <= 6; i++) {
            world.setBlock(x1 + i, y1, z1, block);
        }
        z1 += 1;
        for (int i = 0; i <= 6; i++) {
            world.setBlock(x1 + i, y1, z1, block);
        }
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