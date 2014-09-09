package magiciansartifice.main.magic.rituals;

import magiciansartifice.api.BasicRitual;
import magiciansartifice.main.blocks.BlockRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Random;

public class RitualTree extends BasicRitual{
    public static ArrayList<Item> saplings = new ArrayList<Item>();
    public static Random itemRand = new Random();

    public void startRitual(int x, int y, int z, World world, EntityPlayer player) {
        super.startRitual(x,y,z,world,player);
    }

    public void initEffect(int x, int y, int z, World world, EntityPlayer player) {
        this.spawnParticles(world, x, y + 1, z, itemRand, true);
		
		generateTrees(world, x, y + 1, z + 1);
        generateTrees(world, x + 1, y + 1, z);
        generateTrees(world, x, y + 1, z - 1);
        generateTrees(world, x - 1, y + 1, z);
    }
	
	public static void generateTrees(World w, int x, int y, int z) {
        Random rand = new Random();
        int f = rand.nextInt(3);
            for (int i = 0; i < 11; i++) {
                w.setBlock(x, y + i , z, BlockRegistry.logs, f, f);
            }
            for (int i = 4; i < 10; i++) {
                w.setBlock(x, y + i , z + 1, BlockRegistry.logs, f, f);
                w.setBlock(x, y + i , z - 1, BlockRegistry.logs, f, f);
                w.setBlock(x + 1, y + i , z, BlockRegistry.logs, f, f);
                w.setBlock(x - 1, y + i , z, BlockRegistry.logs, f, f);

            }
            for (int i = 5; i < 10; i++) {
                w.setBlock(x + 1, y + i , z + 1, BlockRegistry.leaves, f, f);
                w.setBlock(x + 1, y + i , z - 1, BlockRegistry.leaves, f, f);
                w.setBlock(x + 1, y + i , z + 1, BlockRegistry.leaves, f, f);
                w.setBlock(x - 1, y + i , z + 1, BlockRegistry.leaves, f, f);
                w.setBlock(x - 1, y + i , z + 1, BlockRegistry.leaves, f, f);
                w.setBlock(x - 1, y + i , z - 1, BlockRegistry.leaves, f, f);
                w.setBlock(x + 1, y + i , z - 1, BlockRegistry.leaves, f, f);
                w.setBlock(x - 1, y + i , z - 1, BlockRegistry.leaves, f, f);
                w.setBlock(x, y + i , z + 2, BlockRegistry.leaves, f, f);
                w.setBlock(x, y + i , z - 2, BlockRegistry.leaves, f, f);
                w.setBlock(x + 2, y + i , z, BlockRegistry.leaves, f, f);
                w.setBlock(x - 2, y + i , z, BlockRegistry.leaves, f, f);

            }
            w.setBlock(x, y + 11, z, BlockRegistry.leaves, f, f);
            w.setBlock(x, y + 10, z + 1, BlockRegistry.leaves, f, f);
            w.setBlock(x, y + 10, z - 1, BlockRegistry.leaves, f, f);
            w.setBlock(x + 1, y + 10, z, BlockRegistry.leaves, f, f);
            w.setBlock(x - 1, y + 10, z, BlockRegistry.leaves, f, f);

    }

    public boolean areAllBlocksCorrect(int x, int y, int z, World world, EntityPlayer player) {
        x += 1;
        z += 1;

        {
            if (!(world.getBlock(x, y, z) == BlockRegistry.storage)) return false;
            x -= 1;
            y += 1;
            if (!(world.getBlock(x, y, z) == Blocks.sapling)) return false;
            x -= 1;
            y -= 1;
            if (!(world.getBlock(x, y, z) == BlockRegistry.storage)) return false;
        }

        x += 2;
        z -= 1;

        {
            y += 1;
            if (!(world.getBlock(x, y, z) == Blocks.sapling)) return false;
            y -= 1;
            x -= 1;
            if (!(world.getBlock(x, y, z) == BlockRegistry.ritualCornerStone)) return false;
            x -= 1;
            y += 1;
            if (!(world.getBlock(x, y, z) == Blocks.sapling)) return false;
            y -= 1;
        }

        x += 2;
        z -= 1;

        {
            if (!(world.getBlock(x, y, z) == BlockRegistry.storage)) return false;
            x -= 1;
            y += 1;
            if (!(world.getBlock(x, y, z) == Blocks.sapling)) return false;
            x -= 1;
            y -= 1;
            if (!(world.getBlock(x, y, z) == BlockRegistry.storage)) return false;
        }
        return true;
    }

}
