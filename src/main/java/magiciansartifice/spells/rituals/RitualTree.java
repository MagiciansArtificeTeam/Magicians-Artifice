package magiciansartifice.spells.rituals;

import magiciansartifice.blocks.BlockRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by poppypoppop on 6/08/2014.
 */
public class RitualTree {
    private static ArrayList<Item> saplings = new ArrayList<Item>();
    public static Random itemRand = new Random();

    public static void treeRitual(int x, int y, int z, World world, EntityPlayer player) {
        for (int i = 0; i < 6; i++) {
            saplings.add(new ItemStack(Blocks.sapling, 1, i).getItem());
        }
        int x1 = x;
        int y1 = y;
        int z1 = z;

        x += 1;
        z += 1;

        {
            if (!(world.getBlock(x, y, z) == BlockRegistry.storage))
                return;
            x -= 1;
            y += 1;
            if (!(world.getBlock(x, y, z) == Blocks.sapling))
                return;
            x -= 1;
            y -= 1;
            if (!(world.getBlock(x, y, z) == BlockRegistry.storage))
                return;
        }

        x += 2;
        z -= 1;

        {
            y += 1;
            if (!(world.getBlock(x, y, z) == Blocks.sapling))
                return;
            y -= 1;
            x -= 1;
            if (!(world.getBlock(x, y, z) == BlockRegistry.ritualCornerStone))
                return;
            x -= 1;
            y += 1;
            if (!(world.getBlock(x, y, z) == Blocks.sapling))
                return;
            y -= 1;
        }

        x += 2;
        z -= 1;

        {
            if (!(world.getBlock(x, y, z) == BlockRegistry.storage))
                return;
            x -= 1;
            y += 1;
            if (!(world.getBlock(x, y, z) == Blocks.sapling))
                return;
            x -= 1;
            y -= 1;
            if (!(world.getBlock(x, y, z) == BlockRegistry.storage))
                return;
        }

        spawnTree(x1, y1, z1, world, player);
        player.swingItem();
    }

    public static void spawnTree(int x, int y, int z, World world, EntityPlayer player) {
        for (int j1 = 0; j1 < 32; ++j1)
        {
            double d0 = (double)((float)x + (5.0F + itemRand.nextFloat() * 6.0F) / 16.0F);
            double d1 = (double)((float)y + 0.8125F);
            double d2 = (double)((float)z + (5.0F + itemRand.nextFloat() * 6.0F) / 16.0F);
            double d3 = 0.0D;
            double d4 = 0.0D;
            double d5 = 0.0D;
            world.spawnParticle("smoke", d0, d1, d2, d3, d4, d5);
        }

        //do tree spawn here
    }
}
