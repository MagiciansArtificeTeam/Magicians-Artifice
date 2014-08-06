package magiciansartifice.spells.rituals;

import magiciansartifice.blocks.BlockRegistry;
import magiciansartifice.blocks.misc.BlockRitualCornerstone;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.world.World;

import java.util.Random;

public class RitualHeal {

    public static Random itemRand = new Random();

    public static void healRitual(int x, int y, int z, World world, EntityPlayer player) {
        int x1 = x;
        int y1 = y;
        int z1 = z;

        int cx = x;
        int cy = y;
        int cz = z;

        x += 2;
        z += 2;

        {
            if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(Blocks.stonebrick, 1, 3).getItem()))
                return;
            y += 1;
            x -= 1;
            if (!(world.getBlock(x, y, z) == Blocks.red_flower))
                return;
            y -= 1;
            x -= 1;
            if (!(world.getBlock(x, y, z) == Blocks.stonebrick))
                return;
            y += 1;
            x -= 1;
            if (!(world.getBlock(x, y, z) == Blocks.red_flower))
                return;
            y -= 1;
            x -= 1;
            if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(Blocks.stonebrick, 1, 3).getItem()))
                return;
        }

        x += 4;
        z -= 1;

        {
            y += 1;
            if (!(world.getBlock(x, y, z) == Blocks.red_flower))
                return;
            y -= 1;
            x -= 1;
            if (!(world.getBlock(x, y, z) == BlockRegistry.planks))
                return;
            x -= 2;
            if (!(world.getBlock(x, y, z) == BlockRegistry.planks))
                return;
            y += 1;
            x -= 1;
            if (!(world.getBlock(x, y, z) == Blocks.red_flower))
                return;
            y -= 1;
        }

        x += 4;
        z -= 1;

        {
            if (!(world.getBlock(x, y, z) == Blocks.stonebrick))
                return;
            x -= 2;
            if (!(world.getBlock(x, y, z) == BlockRegistry.ritualCornerStone))
                return;
            x -= 2;
            if (!(world.getBlock(x, y, z) == Blocks.stonebrick))
                return;
        }

        x += 4;
        z -= 1;

        {
            y += 1;
            if (!(world.getBlock(x, y, z) == Blocks.red_flower))
                return;
            y -= 1;
            x -= 1;
            if (!(world.getBlock(x, y, z) == BlockRegistry.planks))
                return;
            x -= 2;
            if (!(world.getBlock(x, y, z) == BlockRegistry.planks))
                return;
            y += 1;
            x -= 1;
            if (!(world.getBlock(x, y, z) == Blocks.red_flower))
                return;
            y -= 1;
        }

        x += 4;
        z -= 1;

        {
            if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(Blocks.stonebrick, 1, 3).getItem()))
                return;
            y += 1;
            x -= 1;
            if (!(world.getBlock(x, y, z) == Blocks.red_flower))
                return;
            y -= 1;
            x -= 1;
            if (!(world.getBlock(x, y, z) == Blocks.stonebrick))
                return;
            y += 1;
            x -= 1;
            if (!(world.getBlock(x, y, z) == Blocks.red_flower))
                return;
            y -= 1;
            x -= 1;
            if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(Blocks.stonebrick, 1, 3).getItem()))
                return;
        }


        player.swingItem();
        healPlayer(x1, y1, z1, world, player);
    }

    public static void healPlayer(int x, int y, int z, World world, EntityPlayer player) {
        for (int j1 = 0; j1 < 32; ++j1)
        {
            double d0 = (double)((float)x + (5.0F + itemRand.nextFloat() * 6.0F) / 16.0F);
            double d1 = (double)((float)y + 0.8125F);
            double d2 = (double)((float)z + (5.0F + itemRand.nextFloat() * 6.0F) / 16.0F);
            double d3 = 1.0D;
            double d4 = 1.0D;
            double d5 = 1.0D;
            world.spawnParticle("heart", d0, d1, d2, d3, d4, d5);
            world.spawnParticle("heart",d0-2,d1,d2-2,d3,d4,d5);
            world.spawnParticle("heart",d0+2,d1,d2+2,d3,d4,d5);
            world.spawnParticle("heart",d0+2,d1,d2-2,d3,d4,d5);
            world.spawnParticle("heart",d0-2,d1,d2+2,d3,d4,d5);
        }

        player.setHealth(20F);
        player.worldObj.playSoundAtEntity(player,"random.levelup",1.0F,1.0F);
        for (int i = 0; i < Potion.potionTypes.length;i++) {
            if (player.isPotionActive(i)) {
                player.removePotionEffect(i);
            }
        }
    }
}
