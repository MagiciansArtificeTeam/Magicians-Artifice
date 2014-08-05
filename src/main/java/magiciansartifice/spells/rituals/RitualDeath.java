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
 * Created by poppypoppop on 5/08/2014.
 */
public class RitualDeath {
    public static Random itemRand = new Random();

    public static void deathRitual(int x, int y, int z, World world, EntityPlayer player) {
        int x1 = x;
        int y1 = y;
        int z1 = z;

        x += 2;
        z += 2;

        {
            x -= 1;
            if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(Blocks.stonebrick, 1, 3).getItem()))
                return;
            x -= 1;
            y += 1;
            if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(Blocks.skull, 1, 1).getItem()))
                return;
            x -= 1;
            y -= 1;
            if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(Blocks.stonebrick, 1, 3).getItem()))
                return;
            x -= 1;
        }

        x += 4;
        z -= 1;

        {
            if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(Blocks.stonebrick, 1, 3).getItem()))
                return;
            x -= 2;
            if (!(world.getBlock(x, y, z) == BlockRegistry.planks))
                return;
            x -= 2;
            if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(Blocks.stonebrick, 1, 3).getItem()))
                return;
        }

        x += 4;
        z -= 1;

        {
            y += 1;
            if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(Blocks.skull, 1, 1).getItem()))
                return;
            y -= 1;
            x -= 1;
            if (!(world.getBlock(x, y, z) == BlockRegistry.planks))
                return;
            x -= 1;
            if (!(world.getBlock(x, y, z) == BlockRegistry.ritualCornerStone))
                return;
            x -= 1;
            if (!(world.getBlock(x, y, z) == BlockRegistry.planks))
                return;
            y += 1;
            if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(Blocks.skull, 1, 1).getItem()))
                return;
            y -= 1;
        }

        x += 4;
        z -= 1;

        {
            if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(Blocks.stonebrick, 1, 3).getItem()))
                return;
            x -= 2;
            if (!(world.getBlock(x, y, z) == BlockRegistry.planks))
                return;
            x -= 2;
            if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(Blocks.stonebrick, 1, 3).getItem()))
                return;
        }

        x += 4;
        z -= 1;

        {
            x -= 1;
            if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(Blocks.stonebrick, 1, 3).getItem()))
                return;
            x -= 1;
            y += 1;
            if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(Blocks.skull, 1, 1).getItem()))
                return;
            x -= 1;
            y -= 1;
            if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(Blocks.stonebrick, 1, 3).getItem()))
                return;
            x -= 1;
        }

        player.swingItem();
    }

    public static void kill(int x, int y, int z, World world, EntityPlayer player) {
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

        player.setHealth(0F);
    }
}
