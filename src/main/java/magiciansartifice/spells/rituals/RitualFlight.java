package magiciansartifice.spells.rituals;

import magiciansartifice.blocks.BlockRegistry;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created by poppypoppop on 3/08/2014.
 */
public class RitualFlight {
    protected static Random itemRand = new Random();

    public static void flyingRitual(int x, int y, int z, World world, EntityPlayer player) {
        int x1 = x;
        int y1 = y;
        int z1 = z;

        x += 4;
        z += 4;

        /*Checking First row of Blocks*/
        {
            if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(Blocks.stonebrick, 1, 3).getItem()))
                return;
            x -= 1;
            for (int i = 0; i < 2; i++) {
                if (!(Item.getItemFromBlock(world.getBlock(x - i, y, z)) == new ItemStack(BlockRegistry.planks, 1, 1).getItem()))
                    return;
            }
            x -= 2;
            for (int i = 0; i < 3; i++) {
                if (!(world.getBlock(x - i, y, z) == Blocks.stonebrick))
                    return;
            }
            x -= 3;
            for (int i = 0; i < 2; i++) {
                if (!(Item.getItemFromBlock(world.getBlock(x - i, y, z)) == new ItemStack(BlockRegistry.planks, 1, 1).getItem()))
                    return;
            }
            x -= 2;
            if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(Blocks.stonebrick, 1, 3).getItem()))
                return;
        }

        x += 8;
        z -= 1;

        /* Checking the second row */
        {
            if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(BlockRegistry.planks, 1, 1).getItem()))
                return;
            x -= 1;
            for (int i = 0; i < 3; i ++) {
                if (!(Item.getItemFromBlock(world.getBlock(x - i, y, z)) == new ItemStack(BlockRegistry.storage, 1, 1).getItem()))
                    return;
            }
            x -= 3;
            if (!(world.getBlock(x, y, z) == BlockRegistry.storage))
                return;
            x -= 1;
            for (int i = 0; i < 3; i ++) {
                if (!(Item.getItemFromBlock(world.getBlock(x - i, y, z)) == new ItemStack(BlockRegistry.storage, 1, 1).getItem()))
                    return;
            }
            x -= 3;
            if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(BlockRegistry.planks, 1, 1).getItem()))
                return;
        }

        x += 8;
        z -= 1;

        /* Checking the Third Row */
        {
            if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(BlockRegistry.planks, 1, 1).getItem()))
                return;
            x -= 1;
            if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(BlockRegistry.storage, 1, 1).getItem()))
                return;
            x -= 1;
            for (int i = 0; i < 2; i++) {
                if (!(world.getBlock(x - i, y, z) == BlockRegistry.planks))
                    return;
            }
            x -= 2;
            if (!(world.getBlock(x, y, z) == BlockRegistry.storage))
                return;
            x -= 1;
            for (int i = 0; i < 2; i++) {
                if (!(world.getBlock(x - i, y, z) == BlockRegistry.planks))
                    return;
            }
            x -= 2;
            if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(BlockRegistry.storage, 1, 1).getItem()))
                return;
            x -= 1;
            if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(BlockRegistry.planks, 1, 1).getItem()))
                return;
        }

        x += 8;
        z -= 1;

        /* Checking the fourth Row */
        {
            if (!(world.getBlock(x, y, z) == Blocks.stonebrick))
                return;
            x -= 1;
            if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(BlockRegistry.storage, 1, 1).getItem()))
                return;
            x -= 1;
            if (!(world.getBlock(x, y, z) == BlockRegistry.planks))
                return;
            x -= 1;
            for (int i = 0; i < 3; i++) {
                if (!(Item.getItemFromBlock(world.getBlock(x - i, y, z)) == new ItemStack(BlockRegistry.storage, 1, 2).getItem()))
                    return;
            }
            x -= 3;
            if (!(world.getBlock(x, y, z) == BlockRegistry.planks))
                return;
            x -= 1;
            if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(BlockRegistry.storage, 1, 1).getItem()))
                return;
            x -= 1;
            if (!(world.getBlock(x, y, z) == Blocks.stonebrick))
                return;
        }

        x += 8;
        z -= 1;

        /* Checking the center row */
        {
            if (!(world.getBlock(x, y, z) == Blocks.stonebrick))
                return;
            x -= 1;
            for (int i = 0; i < 2; i++) {
                if (!(world.getBlock(x, y, z) == BlockRegistry.storage))
                    return;
            }
            x -= 2;
            if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(BlockRegistry.storage, 1, 2).getItem()))
                return;
            x -= 1;
            if (!(world.getBlock(x, y, z) == BlockRegistry.ritualCornerStone))
                return;
            x -= 1;
            if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(BlockRegistry.storage, 1, 2).getItem()))
                return;
            x -= 1;
            for (int i = 0; i < 2; i++) {
                if (!(world.getBlock(x, y, z) == BlockRegistry.storage))
                    return;
            }
            x -= 2;
            if (!(world.getBlock(x, y, z) == Blocks.stonebrick))
                return;
        }

        x += 8;
        z -= 1;

        /* Checking the sixth row */
        {
            if (!(world.getBlock(x, y, z) == Blocks.stonebrick))
                return;
            x -= 1;
            if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(BlockRegistry.storage, 1, 1).getItem()))
                return;
            x -= 1;
            if (!(world.getBlock(x, y, z) == BlockRegistry.planks))
                return;
            x -= 1;
            for (int i = 0; i < 3; i++) {
                if (!(Item.getItemFromBlock(world.getBlock(x - i, y, z)) == new ItemStack(BlockRegistry.storage, 1, 2).getItem()))
                    return;
            }
            x -= 3;
            if (!(world.getBlock(x, y, z) == BlockRegistry.planks))
                return;
            x -= 1;
            if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(BlockRegistry.storage, 1, 1).getItem()))
                return;
            x -= 1;
            if (!(world.getBlock(x, y, z) == Blocks.stonebrick))
                return;
        }

        x += 8;
        z -= 1;

        /* Checking the seventh Row */
        {
            if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(BlockRegistry.planks, 1, 1).getItem()))
                return;
            x -= 1;
            if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(BlockRegistry.storage, 1, 1).getItem()))
                return;
            x -= 1;
            for (int i = 0; i < 2; i++) {
                if (!(world.getBlock(x - i, y, z) == BlockRegistry.planks))
                    return;
            }
            x -= 2;
            if (!(world.getBlock(x, y, z) == BlockRegistry.storage))
                return;
            x -= 1;
            for (int i = 0; i < 2; i++) {
                if (!(world.getBlock(x - i, y, z) == BlockRegistry.planks))
                    return;
            }
            x -= 2;
            if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(BlockRegistry.storage, 1, 1).getItem()))
                return;
            x -= 1;
            if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(BlockRegistry.planks, 1, 1).getItem()))
                return;
        }

        x += 8;
        z -= 1;

        /* Checking the Eigth Row */
        {
            if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(BlockRegistry.planks, 1, 1).getItem()))
                return;
            x -= 1;
            for (int i = 0; i < 3; i ++) {
                if (!(Item.getItemFromBlock(world.getBlock(x - i, y, z)) == new ItemStack(BlockRegistry.storage, 1, 1).getItem()))
                    return;
            }
            x -= 3;
            if (!(world.getBlock(x, y, z) == BlockRegistry.storage))
                return;
            x -= 1;
            for (int i = 0; i < 3; i ++) {
                if (!(Item.getItemFromBlock(world.getBlock(x - i, y, z)) == new ItemStack(BlockRegistry.storage, 1, 1).getItem()))
                    return;
            }
            x -= 3;
            if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(BlockRegistry.planks, 1, 1).getItem()))
                return;
        }

        x += 8;
        z -= 1;

        /* Checking the Ninth Row */
        {
            if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(Blocks.stonebrick, 1, 3).getItem()))
                return;
            x -= 1;
            for (int i = 0; i < 2; i++) {
                if (!(Item.getItemFromBlock(world.getBlock(x - i, y, z)) == new ItemStack(BlockRegistry.planks, 1, 1).getItem()))
                    return;
            }
            x -= 2;
            for (int i = 0; i < 3; i++) {
                if (!(world.getBlock(x - i, y, z) == Blocks.stonebrick))
                    return;
            }
            x -= 3;
            for (int i = 0; i < 2; i++) {
                if (!(Item.getItemFromBlock(world.getBlock(x - i, y, z)) == new ItemStack(BlockRegistry.planks, 1, 1).getItem()))
                    return;
            }
            x -= 2;
            if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(Blocks.stonebrick, 1, 3).getItem()))
                return;
        }

        enableFlight(x1, y1, z1, world, player);
        player.swingItem();
    }

    public static void enableFlight(int x, int y, int z, World world, EntityPlayer player) {
        world.spawnEntityInWorld(new EntityLightningBolt(world, x, y, z));
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

        if (player.getEntityData().getBoolean("flightRitual") == false) player.getEntityData().setBoolean("flightRitual", true);
        else player.getEntityData().setBoolean("flightRitual", false);
        player.capabilities.allowFlying = player.getEntityData().getBoolean("flightRitual");
    }
}
