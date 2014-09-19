package magiciansartifice.main.village;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class VillagerMageTower implements IWorldGenerator
{
    public VillagerMageTower() {
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) { }

    public void setBlock(World world, int x, int y, int z, Block block, int metadata)
    {
        Block b1 = world.getBlock(x, y, z);

        if(b1.isAir(world, x, y, z) || b1.isLeaves(world, x, y, z))
        {
            world.setBlock(x, y, z, block, metadata, 2);
        }
    }

    public boolean generate(World world, Random rand, int i, int j, int k) {
        this.setBlock(world, i + 0, j + 0, k + 1, Blocks.stonebrick, 3);
        this.setBlock(world, i + 0, j + 0, k + 2, Blocks.log, 0);
        this.setBlock(world, i + 0, j + 0, k + 3, Blocks.stonebrick, 3);
        this.setBlock(world, i + 0, j + 0, k + 4, Blocks.log, 0);
        this.setBlock(world, i + 0, j + 0, k + 5, Blocks.stonebrick, 3);
        this.setBlock(world, i + 0, j + 1, k + 2, Blocks.cobblestone, 0);
        this.setBlock(world, i + 0, j + 1, k + 3, Blocks.cobblestone, 0);
        this.setBlock(world, i + 0, j + 1, k + 4, Blocks.cobblestone, 0);
        this.setBlock(world, i + 0, j + 2, k + 2, Blocks.cobblestone, 0);
        this.setBlock(world, i + 0, j + 2, k + 3, Blocks.glass_pane, 0);
        this.setBlock(world, i + 0, j + 2, k + 4, Blocks.cobblestone, 0);
        this.setBlock(world, i + 0, j + 3, k + 2, Blocks.cobblestone, 0);
        this.setBlock(world, i + 0, j + 3, k + 3, Blocks.glass_pane, 0);
        this.setBlock(world, i + 0, j + 3, k + 4, Blocks.cobblestone, 0);
        this.setBlock(world, i + 0, j + 4, k + 1, Blocks.stonebrick, 3);
        this.setBlock(world, i + 0, j + 4, k + 2, Blocks.log, 0);
        this.setBlock(world, i + 0, j + 4, k + 3, Blocks.stonebrick, 3);
        this.setBlock(world, i + 0, j + 4, k + 4, Blocks.log, 0);
        this.setBlock(world, i + 0, j + 4, k + 5, Blocks.stonebrick, 3);
        this.setBlock(world, i + 0, j + 5, k + 2, Blocks.cobblestone, 0);
        this.setBlock(world, i + 0, j + 5, k + 3, Blocks.cobblestone, 0);
        this.setBlock(world, i + 0, j + 5, k + 4, Blocks.cobblestone, 0);
        this.setBlock(world, i + 0, j + 6, k + 2, Blocks.cobblestone, 0);
        this.setBlock(world, i + 0, j + 6, k + 3, Blocks.glass_pane, 0);
        this.setBlock(world, i + 0, j + 6, k + 4, Blocks.cobblestone, 0);
        this.setBlock(world, i + 0, j + 7, k + 2, Blocks.cobblestone, 0);
        this.setBlock(world, i + 0, j + 7, k + 3, Blocks.glass_pane, 0);
        this.setBlock(world, i + 0, j + 7, k + 4, Blocks.cobblestone, 0);
        this.setBlock(world, i + 0, j + 8, k + 2, Blocks.stonebrick, 3);
        this.setBlock(world, i + 0, j + 8, k + 3, Blocks.cobblestone, 0);
        this.setBlock(world, i + 0, j + 8, k + 4, Blocks.stonebrick, 3);
        this.setBlock(world, i + 0, j + 9, k + 1, Blocks.stonebrick, 3);
        this.setBlock(world, i + 0, j + 9, k + 2, Blocks.log, 0);
        this.setBlock(world, i + 0, j + 9, k + 3, Blocks.stonebrick, 3);
        this.setBlock(world, i + 0, j + 9, k + 4, Blocks.log, 0);
        this.setBlock(world, i + 0, j + 9, k + 5, Blocks.stonebrick, 3);
        this.setBlock(world, i + 0, j + 10, k + 2, Blocks.stonebrick, 3);
        this.setBlock(world, i + 0, j + 10, k + 3, Blocks.log, 0);
        this.setBlock(world, i + 0, j + 10, k + 4, Blocks.stonebrick, 3);
        this.setBlock(world, i + 0, j + 11, k + 3, Blocks.stonebrick, 3);
        this.setBlock(world, i + 1, j + 0, k + 1, Blocks.log, 0);
        this.setBlock(world, i + 1, j + 0, k + 5, Blocks.log, 0);
        this.setBlock(world, i + 1, j + 1, k + 1, Blocks.cobblestone, 0);
        this.setBlock(world, i + 1, j + 1, k + 5, Blocks.cobblestone, 0);
        this.setBlock(world, i + 1, j + 2, k + 1, Blocks.cobblestone, 0);
        this.setBlock(world, i + 1, j + 2, k + 5, Blocks.cobblestone, 0);
        this.setBlock(world, i + 1, j + 3, k + 1, Blocks.cobblestone, 0);
        this.setBlock(world, i + 1, j + 3, k + 5, Blocks.cobblestone, 0);
        this.setBlock(world, i + 1, j + 4, k + 1, Blocks.log, 0);
        this.setBlock(world, i + 1, j + 4, k + 5, Blocks.log, 0);
        this.setBlock(world, i + 1, j + 5, k + 1, Blocks.cobblestone, 0);
        this.setBlock(world, i + 1, j + 5, k + 2, Blocks.chest, 3);
        this.setBlock(world, i + 1, j + 5, k + 5, Blocks.cobblestone, 0);
        this.setBlock(world, i + 1, j + 6, k + 1, Blocks.cobblestone, 0);
        this.setBlock(world, i + 1, j + 6, k + 5, Blocks.cobblestone, 0);
        this.setBlock(world, i + 1, j + 7, k + 1, Blocks.cobblestone, 0);
        this.setBlock(world, i + 1, j + 7, k + 5, Blocks.cobblestone, 0);
        this.setBlock(world, i + 1, j + 8, k + 1, Blocks.stonebrick, 3);
        this.setBlock(world, i + 1, j + 8, k + 5, Blocks.stonebrick, 3);
        this.setBlock(world, i + 1, j + 9, k + 1, Blocks.log, 0);
        this.setBlock(world, i + 1, j + 9, k + 5, Blocks.log, 0);
        this.setBlock(world, i + 1, j + 10, k + 1, Blocks.stonebrick, 3);
        this.setBlock(world, i + 1, j + 10, k + 5, Blocks.stonebrick, 3);
        this.setBlock(world, i + 2, j + 0, k + 0, Blocks.stone_stairs, 2);
        this.setBlock(world, i + 2, j + 0, k + 5, Blocks.stonebrick, 3);
        this.setBlock(world, i + 2, j + 1, k + 5, Blocks.cobblestone, 0);
        this.setBlock(world, i + 2, j + 2, k + 5, Blocks.cobblestone, 0);
        this.setBlock(world, i + 2, j + 3, k + 1, Blocks.cobblestone, 0);
        this.setBlock(world, i + 2, j + 3, k + 5, Blocks.cobblestone, 0);
        this.setBlock(world, i + 2, j + 4, k + 1, Blocks.stonebrick, 3);
        this.setBlock(world, i + 2, j + 4, k + 5, Blocks.stonebrick, 3);
        this.setBlock(world, i + 2, j + 5, k + 1, Blocks.cobblestone, 0);
        this.setBlock(world, i + 2, j + 5, k + 2, Blocks.crafting_table, 0);
        this.setBlock(world, i + 2, j + 5, k + 5, Blocks.cobblestone, 0);
        this.setBlock(world, i + 2, j + 6, k + 1, Blocks.glass_pane, 0);
        this.setBlock(world, i + 2, j + 6, k + 5, Blocks.cobblestone, 0);
        this.setBlock(world, i + 2, j + 7, k + 1, Blocks.glass_pane, 0);
        this.setBlock(world, i + 2, j + 7, k + 5, Blocks.cobblestone, 0);
        this.setBlock(world, i + 2, j + 8, k + 1, Blocks.cobblestone, 0);
        this.setBlock(world, i + 2, j + 8, k + 5, Blocks.cobblestone, 0);
        this.setBlock(world, i + 2, j + 9, k + 1, Blocks.stonebrick, 3);
        this.setBlock(world, i + 2, j + 9, k + 5, Blocks.stonebrick, 3);
        this.setBlock(world, i + 2, j + 10, k + 1, Blocks.log, 0);
        this.setBlock(world, i + 2, j + 10, k + 5, Blocks.log, 0);
        this.setBlock(world, i + 2, j + 11, k + 1, Blocks.stonebrick, 3);
        this.setBlock(world, i + 2, j + 11, k + 5, Blocks.stonebrick, 3);
        this.setBlock(world, i + 3, j + 0, k + 1, Blocks.log, 0);
        this.setBlock(world, i + 3, j + 0, k + 5, Blocks.log, 0);
        this.setBlock(world, i + 3, j + 1, k + 1, Blocks.cobblestone, 0);
        this.setBlock(world, i + 3, j + 1, k + 5, Blocks.cobblestone, 0);
        this.setBlock(world, i + 3, j + 2, k + 1, Blocks.cobblestone, 0);
        this.setBlock(world, i + 3, j + 2, k + 5, Blocks.cobblestone, 0);
        this.setBlock(world, i + 3, j + 3, k + 1, Blocks.cobblestone, 0);
        this.setBlock(world, i + 3, j + 3, k + 5, Blocks.cobblestone, 0);
        this.setBlock(world, i + 3, j + 4, k + 1, Blocks.log, 0);
        this.setBlock(world, i + 3, j + 4, k + 5, Blocks.log, 0);
        this.setBlock(world, i + 3, j + 5, k + 1, Blocks.cobblestone, 0);
        this.setBlock(world, i + 3, j + 5, k + 2, Blocks.chest, 3);
        this.setBlock(world, i + 3, j + 5, k + 5, Blocks.cobblestone, 0);
        this.setBlock(world, i + 3, j + 6, k + 1, Blocks.cobblestone, 0);
        this.setBlock(world, i + 3, j + 6, k + 5, Blocks.cobblestone, 0);
        this.setBlock(world, i + 3, j + 7, k + 1, Blocks.cobblestone, 0);
        this.setBlock(world, i + 3, j + 7, k + 5, Blocks.cobblestone, 0);
        this.setBlock(world, i + 3, j + 8, k + 1, Blocks.stonebrick, 3);
        this.setBlock(world, i + 3, j + 8, k + 5, Blocks.stonebrick, 3);
        this.setBlock(world, i + 3, j + 9, k + 1, Blocks.log, 0);
        this.setBlock(world, i + 3, j + 9, k + 5, Blocks.log, 0);
        this.setBlock(world, i + 3, j + 10, k + 1, Blocks.stonebrick, 3);
        this.setBlock(world, i + 3, j + 10, k + 5, Blocks.stonebrick, 3);
        this.setBlock(world, i + 4, j + 0, k + 1, Blocks.stonebrick, 3);
        this.setBlock(world, i + 4, j + 0, k + 2, Blocks.log, 0);
        this.setBlock(world, i + 4, j + 0, k + 3, Blocks.stonebrick, 3);
        this.setBlock(world, i + 4, j + 0, k + 4, Blocks.log, 0);
        this.setBlock(world, i + 4, j + 0, k + 5, Blocks.stonebrick, 3);
        this.setBlock(world, i + 4, j + 1, k + 2, Blocks.cobblestone, 0);
        this.setBlock(world, i + 4, j + 1, k + 3, Blocks.cobblestone, 0);
        this.setBlock(world, i + 4, j + 1, k + 4, Blocks.cobblestone, 0);
        this.setBlock(world, i + 4, j + 2, k + 2, Blocks.cobblestone, 0);
        this.setBlock(world, i + 4, j + 2, k + 3, Blocks.glass_pane, 0);
        this.setBlock(world, i + 4, j + 2, k + 4, Blocks.cobblestone, 0);
        this.setBlock(world, i + 4, j + 3, k + 2, Blocks.cobblestone, 0);
        this.setBlock(world, i + 4, j + 3, k + 3, Blocks.glass_pane, 0);
        this.setBlock(world, i + 4, j + 3, k + 4, Blocks.cobblestone, 0);
        this.setBlock(world, i + 4, j + 4, k + 1, Blocks.stonebrick, 3);
        this.setBlock(world, i + 4, j + 4, k + 2, Blocks.log, 0);
        this.setBlock(world, i + 4, j + 4, k + 3, Blocks.stonebrick, 3);
        this.setBlock(world, i + 4, j + 4, k + 4, Blocks.log, 0);
        this.setBlock(world, i + 4, j + 4, k + 5, Blocks.stonebrick, 3);
        this.setBlock(world, i + 4, j + 5, k + 2, Blocks.cobblestone, 0);
        this.setBlock(world, i + 4, j + 5, k + 3, Blocks.cobblestone, 0);
        this.setBlock(world, i + 4, j + 5, k + 4, Blocks.cobblestone, 0);
        this.setBlock(world, i + 4, j + 6, k + 2, Blocks.cobblestone, 0);
        this.setBlock(world, i + 4, j + 6, k + 3, Blocks.glass_pane, 0);
        this.setBlock(world, i + 4, j + 6, k + 4, Blocks.cobblestone, 0);
        this.setBlock(world, i + 4, j + 7, k + 2, Blocks.cobblestone, 0);
        this.setBlock(world, i + 4, j + 7, k + 3, Blocks.glass_pane, 0);
        this.setBlock(world, i + 4, j + 7, k + 4, Blocks.cobblestone, 0);
        this.setBlock(world, i + 4, j + 8, k + 2, Blocks.stonebrick, 3);
        this.setBlock(world, i + 4, j + 8, k + 3, Blocks.cobblestone, 0);
        this.setBlock(world, i + 4, j + 8, k + 4, Blocks.stonebrick, 3);
        this.setBlock(world, i + 4, j + 9, k + 1, Blocks.stonebrick, 3);
        this.setBlock(world, i + 4, j + 9, k + 2, Blocks.log, 0);
        this.setBlock(world, i + 4, j + 9, k + 3, Blocks.stonebrick, 3);
        this.setBlock(world, i + 4, j + 9, k + 4, Blocks.log, 0);
        this.setBlock(world, i + 4, j + 9, k + 5, Blocks.stonebrick, 3);
        this.setBlock(world, i + 4, j + 10, k + 2, Blocks.stonebrick, 3);
        this.setBlock(world, i + 4, j + 10, k + 3, Blocks.log, 0);
        this.setBlock(world, i + 4, j + 10, k + 4, Blocks.stonebrick, 3);
        this.setBlock(world, i + 4, j + 11, k + 3, Blocks.stonebrick, 3);
        world.setBlockMetadataWithNotify(i + 1, j + 3, k + 2, 3, 2);
        world.setBlockMetadataWithNotify(i + 1, j + 3, k + 4, 4, 2);
        world.setBlockMetadataWithNotify(i + 1, j + 7, k + 4, 4, 2);
        world.setBlockMetadataWithNotify(i + 2, j + 1, k + 1, 1, 2);
        world.setBlockMetadataWithNotify(i + 2, j + 1, k + 4, 2, 2);
        world.setBlockMetadataWithNotify(i + 2, j + 2, k + 1, 8, 2);
        world.setBlockMetadataWithNotify(i + 2, j + 2, k + 4, 2, 2);
        world.setBlockMetadataWithNotify(i + 2, j + 3, k + 4, 2, 2);
        world.setBlockMetadataWithNotify(i + 2, j + 4, k + 4, 2, 2);
        world.setBlockMetadataWithNotify(i + 2, j + 5, k + 4, 2, 2);
        world.setBlockMetadataWithNotify(i + 2, j + 6, k + 4, 2, 2);
        world.setBlockMetadataWithNotify(i + 2, j + 7, k + 4, 2, 2);
        world.setBlockMetadataWithNotify(i + 2, j + 8, k + 4, 2, 2);
        world.setBlockMetadataWithNotify(i + 2, j + 9, k + 4, 2, 2);
        world.setBlockMetadataWithNotify(i + 3, j + 3, k + 2, 3, 2);
        world.setBlockMetadataWithNotify(i + 3, j + 3, k + 4, 4, 2);
        world.setBlockMetadataWithNotify(i + 3, j + 7, k + 2, 3, 2);
        world.setBlockMetadataWithNotify(i + 3, j + 7, k + 4, 4, 2);

        return true;
    }
}