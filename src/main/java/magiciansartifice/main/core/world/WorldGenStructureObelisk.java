package magiciansartifice.main.core.world;

import cpw.mods.fml.common.IWorldGenerator;
import magiciansartifice.main.blocks.BlockRegistry;
import magiciansartifice.main.core.libs.ConfigHandler;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.oredict.OreDictionary;

import javax.vecmath.Vector3d;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by poppypoppop on 2/10/2014.
 */
public class WorldGenStructureObelisk extends WorldGenerator implements IWorldGenerator {
    public static ArrayList<Item> blockBlackList = new ArrayList<Item>();
    public int xBefore = 0;
    public int yBefore = 0;
    public int zBefore = 0;
    public static int obeliskRarity = ConfigHandler.obeliskRarity;

    public WorldGenStructureObelisk() {
        blockBlackList.add(Item.getItemFromBlock(Blocks.water));
        blockBlackList.add(Item.getItemFromBlock(Blocks.leaves));
        blockBlackList.add(Item.getItemFromBlock(Blocks.leaves2));
        for (int i = 0; i <= OreDictionary.getOres("treeLeaves").size(); i++) {
            blockBlackList.add(OreDictionary.getOres("treeLeaves").get(i).getItem());
        }
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        if (world.provider.dimensionId == 0) {
            if (obeliskRarity > 0) {
                if (random.nextInt(obeliskRarity) == 0) {
                    generateObelisk(world, random, chunkX, chunkZ);
                }
            }
        }
    }

    public void generateObelisk(World world, Random rand, int chunkX, int chunkZ) {
        int x = chunkX * 16 + rand.nextInt(16);
        int z = chunkZ * 16 + rand.nextInt(16);
        int y = world.getHeightValue(x, z);

        if (canPlaceHere(world, x, y, z)) return;

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
        for (Item item : blockBlackList) {
            if (Item.getItemFromBlock(world.getBlock(x, y - 1, z)) == item) return true;
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
