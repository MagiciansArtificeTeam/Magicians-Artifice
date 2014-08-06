package magiciansartifice.spells.rituals;

import magiciansartifice.blocks.BlockRegistry;
import magiciansartifice.blocks.misc.BlockRitualCornerstone;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.Random;

public class RitualFlight{

    public static Random itemRand = new Random();

    public static void flyingRitual(int x, int y, int z, World world, EntityPlayer player) {
            int x1 = x;
            int y1 = y;
            int z1 = z;

            int lx = x;
            int ly = y;
            int lz = z;

            int cx = x;
            int cy = y;
            int cz = z;

        x += 4;
            z += 4;

        /*Checking First row of Blocks*/
            {
                if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(Blocks.stonebrick, 1, 3).getItem())) {
                    return;
                } else {
                    lx = x; ly = y; lz = z;
                }
                
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
                if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(Blocks.stonebrick, 1, 3).getItem())) {
                    return;
                } else {
                        lx = x;
                        ly = y;
                        lz = z;
                }
                
            }

            x += 8;
            z -= 1;


        /* Checking the second row */
            {
                if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(BlockRegistry.planks, 1, 1).getItem()))
                    return;
                
                x -= 1;
                for (int i = 0; i < 3; i++) {
                    if (!(Item.getItemFromBlock(world.getBlock(x - i, y, z)) == new ItemStack(BlockRegistry.storage, 1, 1).getItem()))
                        return;
                }
                
                x -= 3;
                if (!(world.getBlock(x, y, z) == BlockRegistry.storage))
                    return;
                
                x -= 1;
                for (int i = 0; i < 3; i++) {
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
                for (int i = 0; i < 3; i++) {
                    if (!(Item.getItemFromBlock(world.getBlock(x - i, y, z)) == new ItemStack(BlockRegistry.storage, 1, 1).getItem()))
                        return;
                }
                
                x -= 3;
                if (!(world.getBlock(x, y, z) == BlockRegistry.storage))
                    return;
                
                x -= 1;
                for (int i = 0; i < 3; i++) {
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
                if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(Blocks.stonebrick, 1, 3).getItem())) {
                    return;
                } else {
                    lx = x; ly = y; lz = z;
                }
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
                if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(Blocks.stonebrick, 1, 3).getItem())) {
                    return;
                } else {
                    lx = x; ly = y; lz = z;
                }
            }

            BlockRitualCornerstone.distance = 4;

            world.scheduleBlockUpdate(cx,cy,cz,BlockRegistry.ritualCornerStone,20);

            enableFlight(x1, y1, z1, world, player,true);
            player.swingItem();
    }

    public static void enableFlight(int x, int y, int z, World world, EntityPlayer player, boolean spawnLightning) {
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
        if (!player.capabilities.isCreativeMode) player.capabilities.allowFlying = player.getEntityData().getBoolean("flightRitualActive");
        player.capabilities.isFlying = player.getEntityData().getBoolean("flightRitualActive");
        player.sendPlayerAbilities();
        if (spawnLightning) summonLightning(world, x, y, z);
    }

    private static void summonLightning(World world, int x, int y, int z) {
        world.addWeatherEffect(new EntityLightningBolt(world,x,y,z));
    }

}
