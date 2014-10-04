package magiciansartifice.main.core.world;

import cpw.mods.fml.common.IWorldGenerator;
import magiciansartifice.main.blocks.BlockRegistry;
import magiciansartifice.main.core.libs.ConfigHandler;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;

import javax.vecmath.Vector3d;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by poppypoppop on 2/10/2014.
 */
public class WorldGenStructureObelisk extends WorldGenerator implements IWorldGenerator {
    public static ArrayList<Block> blockBlackList = new ArrayList<Block>();
    public int xBefore;
    public int yBefore;
    public int zBefore;
    public static int distanceBetween = ConfigHandler.distanceBetween;

    public WorldGenStructureObelisk() {
        blockBlackList.add(Blocks.water);
        blockBlackList.add(Blocks.leaves);
        blockBlackList.add(Blocks.leaves2);

    }

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

        if (canPlaceHere(world, x, y, z)) return;
        if (getDistance(x, y, z) < distanceBetween) return;

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

        xBefore = x;
        yBefore = y;
        zBefore = z;
    }

    private boolean canPlaceHere(World world, int x, int y, int z) {
        for (Block block : blockBlackList) {
            if (world.getBlock(x, y - 1, z) == block) return true;
        }

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if(world.getTileEntity(x + j, y + i, z + k) != null) return true;
                }
            }
        }
        return false;
    }

    public double getDistance(double x, double y, double z)
    {
        double d3 = this.xBefore - x;
        double d4 = this.yBefore - y;
        double d5 = this.zBefore - z;
        return (double) MathHelper.sqrt_double(d3 * d3 + d4 * d4 + d5 * d5);
    }

    @Override
    public boolean generate(World world, Random rand, int x, int y, int z) {
        return false;
    }
}
