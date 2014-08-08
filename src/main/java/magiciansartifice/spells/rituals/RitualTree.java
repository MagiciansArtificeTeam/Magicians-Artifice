package magiciansartifice.spells.rituals;

import magiciansartifice.api.BasicRitual;
import magiciansartifice.blocks.BlockRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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

        for (int x1 = x - 1;x1 < x + 2;x1++) {
            for (int z1 = z - 1; z1 < z + 2;z1++) {
                int y1 = y + 1;

                if (world.getBlock(x1,y1,z1) != null && world.getBlock(x1,y1,z1).equals(Blocks.sapling)) {
                    switch (itemRand.nextInt(saplings.size())) {
                        case 0:
                            world.setBlock(x1, y1, z1, Blocks.sapling, 0, 3); break;
                        case 1:
                            world.setBlock(x1, y1, z1, Blocks.sapling, 1, 3); break;
                        case 2:
                            world.setBlock(x1, y1, z1, Blocks.sapling, 2, 3); break;
                        case 3:
                            world.setBlock(x1, y1, z1, Blocks.sapling, 3, 3); break;
                        case 4:
                            world.setBlock(x1, y1, z1, Blocks.sapling, 4, 3); break;
                        case 5:
                            world.setBlock(x1, y1, z1, Blocks.sapling, 5, 3); break;
                        case 6:
                            world.setBlock(x1, y1, z1, Blocks.sapling, 6, 3); break;
                    }
                }

            }
        }

    }

    public boolean areAllBlocksCorrect(int x, int y, int z, World world, EntityPlayer player) {
        x += 1;
        z += 1;

        {
            if (!(world.getBlock(x, y, z) == BlockRegistry.storage))
                return false;
            x -= 1;
            y += 1;
            if (!(world.getBlock(x, y, z) == Blocks.sapling))
                return false;
            x -= 1;
            y -= 1;
            if (!(world.getBlock(x, y, z) == BlockRegistry.storage))
                return false;
        }

        x += 2;
        z -= 1;

        {
            y += 1;
            if (!(world.getBlock(x, y, z) == Blocks.sapling))
                return false;
            y -= 1;
            x -= 1;
            if (!(world.getBlock(x, y, z) == BlockRegistry.ritualCornerStone))
                return false;
            x -= 1;
            y += 1;
            if (!(world.getBlock(x, y, z) == Blocks.sapling))
                return false;
            y -= 1;
        }

        x += 2;
        z -= 1;

        {
            if (!(world.getBlock(x, y, z) == BlockRegistry.storage))
                return false;
            x -= 1;
            y += 1;
            if (!(world.getBlock(x, y, z) == Blocks.sapling))
                return false;
            x -= 1;
            y -= 1;
            if (!(world.getBlock(x, y, z) == BlockRegistry.storage))
                return false;
        }
        return true;
    }

}
