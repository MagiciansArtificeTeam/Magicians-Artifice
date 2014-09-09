package magiciansartifice.main.magic.rituals;

import magiciansartifice.api.BasicRitual;
import magiciansartifice.main.blocks.BlockRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

@SuppressWarnings("unused")
public class RitualFlight extends BasicRitual{

    public static Random itemRand = new Random();

    @Override
    public void startRitual(int x, int y, int z, World world, EntityPlayer player) {
        super.startRitual(x,y,z,world,player);
    }

    @Override
    public void initEffect(int x, int y, int z, World world, EntityPlayer player) {
        enableFlight(x,y,z,world,player,this.canSummonLightning());
    }

    public static void enableFlight(int x, int y, int z, World world, EntityPlayer player, boolean spawnLightning) {
        for (int j1 = 0; j1 < 32; ++j1) {
            double d0 = (double)((float)x + (5.0F + itemRand.nextFloat() * 6.0F) / 16.0F);
            double d1 = (double)((float)y + 0.8125F);
            double d2 = (double)((float)z + (5.0F + itemRand.nextFloat() * 6.0F) / 16.0F);
            double d3 = 1.0D;
            double d4 = 1.0D;
            double d5 = 1.0D;
            world.spawnParticle("smoke", d0, d1, d2, d3, d4, d5);
        }

        if (!player.capabilities.isCreativeMode) {
            player.capabilities.allowFlying = player.getEntityData().getBoolean("flightRitualActive");
            player.capabilities.isFlying = player.getEntityData().getBoolean("flightRitualActive");
            player.sendPlayerAbilities();
        }
        if (spawnLightning) summonLightning(world, x, y, z);
    }

    private static void summonLightning(World world, int x, int y, int z) {
        world.addWeatherEffect(new EntityLightningBolt(world,x,y,z));
    }

    @Override
    public boolean areAllBlocksCorrect(int x, int y, int z, World world, EntityPlayer player) {
		int x1 = x;
        int y1 = y;
        int z1 = z;

        int lx = x;
        int ly = y;
        int lz = z;

        x += 4;
        z += 4;

        /*Checking First row of blocks*/
        {
            if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(Blocks.stonebrick, 1, 3).getItem())) {
                return false;
            } else {
                lx = x; ly = y; lz = z;
            }

            x -= 1;
            for (int i = 0; i < 2; i++) {
                if (!(Item.getItemFromBlock(world.getBlock(x - i, y, z)) == new ItemStack(BlockRegistry.planks, 1, 1).getItem()))
                    return false;
            }

            x -= 2;
            for (int i = 0; i < 3; i++) {
                if (!(world.getBlock(x - i, y, z) == Blocks.stonebrick))
                    return false;
            }

            x -= 3;
            for (int i = 0; i < 2; i++) {
                if (!(Item.getItemFromBlock(world.getBlock(x - i, y, z)) == new ItemStack(BlockRegistry.planks, 1, 1).getItem()))
                    return false;
            }

            x -= 2;
            if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(Blocks.stonebrick, 1, 3).getItem())) {
                return false;
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
                return false;

            x -= 1;
            for (int i = 0; i < 3; i++) {
                if (!(Item.getItemFromBlock(world.getBlock(x - i, y, z)) == new ItemStack(BlockRegistry.storage, 1, 1).getItem()))
                    return false;
            }

            x -= 3;
            if (!(world.getBlock(x, y, z) == BlockRegistry.storage))
                return false;

            x -= 1;
            for (int i = 0; i < 3; i++) {
                if (!(Item.getItemFromBlock(world.getBlock(x - i, y, z)) == new ItemStack(BlockRegistry.storage, 1, 1).getItem()))
                    return false;
            }

            x -= 3;
            if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(BlockRegistry.planks, 1, 1).getItem()))
                return false;

        }

        x += 8;
        z -= 1;


        /* Checking the Third Row */
        {
            if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(BlockRegistry.planks, 1, 1).getItem()))
                return false;
            x -= 1;

            if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(BlockRegistry.storage, 1, 1).getItem()))
                return false;

            x -= 1;
            for (int i = 0; i < 2; i++) {
                if (!(world.getBlock(x - i, y, z) == BlockRegistry.planks))
                    return false;
            }

            x -= 2;
            if (!(world.getBlock(x, y, z) == BlockRegistry.storage))
                return false;

            x -= 1;
            for (int i = 0; i < 2; i++) {
                if (!(world.getBlock(x - i, y, z) == BlockRegistry.planks))
                    return false;
            }

            x -= 2;
            if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(BlockRegistry.storage, 1, 1).getItem()))
                return false;

            x -= 1;
            if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(BlockRegistry.planks, 1, 1).getItem()))
                return false;

        }

        x += 8;
        z -= 1;


        /* Checking the fourth Row */
        {
            if (!(world.getBlock(x, y, z) == Blocks.stonebrick))
                return false;

            x -= 1;
            if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(BlockRegistry.storage, 1, 1).getItem()))
                return false;

            x -= 1;
            if (!(world.getBlock(x, y, z) == BlockRegistry.planks))
                return false;

            x -= 1;
            for (int i = 0; i < 3; i++) {
                if (!(Item.getItemFromBlock(world.getBlock(x - i, y, z)) == new ItemStack(BlockRegistry.storage, 1, 2).getItem()))
                    return false;
            }

            x -= 3;
            if (!(world.getBlock(x, y, z) == BlockRegistry.planks))
                return false;

            x -= 1;
            if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(BlockRegistry.storage, 1, 1).getItem()))
                return false;

            x -= 1;
            if (!(world.getBlock(x, y, z) == Blocks.stonebrick))
                return false;

        }

        x += 8;
        z -= 1;

        /* Checking the center row */

        {
            if (!(world.getBlock(x, y, z) == Blocks.stonebrick))
                return false;

            x -= 1;
            for (int i = 0; i < 2; i++) {
                if (!(world.getBlock(x, y, z) == BlockRegistry.storage))
                    return false;
            }

            x -= 2;
            if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(BlockRegistry.storage, 1, 2).getItem()))
                return false;

            x -= 1;
            if (!(world.getBlock(x, y, z) == BlockRegistry.ritualCornerStone))
                return false;

            x -= 1;
            if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(BlockRegistry.storage, 1, 2).getItem()))
                return false;

            x -= 1;
            for (int i = 0; i < 2; i++) {
                if (!(world.getBlock(x, y, z) == BlockRegistry.storage))
                    return false;
            }

            x -= 2;
            if (!(world.getBlock(x, y, z) == Blocks.stonebrick))
                return false;

        }

        x += 8;
        z -= 1;

        /* Checking the sixth row */


        {
            if (!(world.getBlock(x, y, z) == Blocks.stonebrick))
                return false;

            x -= 1;
            if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(BlockRegistry.storage, 1, 1).getItem()))
                return false;

            x -= 1;
            if (!(world.getBlock(x, y, z) == BlockRegistry.planks))
                return false;

            x -= 1;
            for (int i = 0; i < 3; i++) {
                if (!(Item.getItemFromBlock(world.getBlock(x - i, y, z)) == new ItemStack(BlockRegistry.storage, 1, 2).getItem()))
                    return false;
            }

            x -= 3;
            if (!(world.getBlock(x, y, z) == BlockRegistry.planks))
                return false;

            x -= 1;
            if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(BlockRegistry.storage, 1, 1).getItem()))
                return false;

            x -= 1;
            if (!(world.getBlock(x, y, z) == Blocks.stonebrick))
                return false;

        }

        x += 8;
        z -= 1;

        /* Checking the seventh Row */


        {
            if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(BlockRegistry.planks, 1, 1).getItem()))
                return false;

            x -= 1;
            if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(BlockRegistry.storage, 1, 1).getItem()))
                return false;

            x -= 1;
            for (int i = 0; i < 2; i++) {
                if (!(world.getBlock(x - i, y, z) == BlockRegistry.planks))
                    return false;
            }

            x -= 2;
            if (!(world.getBlock(x, y, z) == BlockRegistry.storage))
                return false;

            x -= 1;
            for (int i = 0; i < 2; i++) {
                if (!(world.getBlock(x - i, y, z) == BlockRegistry.planks))
                    return false;
            }

            x -= 2;
            if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(BlockRegistry.storage, 1, 1).getItem()))
                return false;

            x -= 1;
            if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(BlockRegistry.planks, 1, 1).getItem()))
                return false;

        }

        x += 8;
        z -= 1;

        /* Checking the Eigth Row */


        {

            if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(BlockRegistry.planks, 1, 1).getItem()))
                return false;

            x -= 1;
            for (int i = 0; i < 3; i++) {
                if (!(Item.getItemFromBlock(world.getBlock(x - i, y, z)) == new ItemStack(BlockRegistry.storage, 1, 1).getItem()))
                    return false;
            }

            x -= 3;
            if (!(world.getBlock(x, y, z) == BlockRegistry.storage))
                return false;

            x -= 1;
            for (int i = 0; i < 3; i++) {
                if (!(Item.getItemFromBlock(world.getBlock(x - i, y, z)) == new ItemStack(BlockRegistry.storage, 1, 1).getItem()))
                    return false;
            }
            x -= 3;
            if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(BlockRegistry.planks, 1, 1).getItem()))
                return false;
        }

        x += 8;
        z -= 1;

        /* Checking the Ninth Row */

        {
            if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(Blocks.stonebrick, 1, 3).getItem())) {
                return false;
            } else {
                lx = x; ly = y; lz = z;
            }
            x -= 1;
            for (int i = 0; i < 2; i++) {
                if (!(Item.getItemFromBlock(world.getBlock(x - i, y, z)) == new ItemStack(BlockRegistry.planks, 1, 1).getItem()))
                    return false;
            }
            x -= 2;
            for (int i = 0; i < 3; i++) {
                if (!(world.getBlock(x - i, y, z) == Blocks.stonebrick))
                    return false;
            }
            x -= 3;
            for (int i = 0; i < 2; i++) {
                if (!(Item.getItemFromBlock(world.getBlock(x - i, y, z)) == new ItemStack(BlockRegistry.planks, 1, 1).getItem()))
                    return false;
            }
            x -= 2;
            if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(Blocks.stonebrick, 1, 3).getItem())) {
                return false;
            } else {
                lx = x; ly = y; lz = z;
            }
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void uncontainedEffect(int x, int y, int z, World world, EntityPlayer player) {
        super.uncontainedEffect(x, y, z, world, player);
        Vec3 cornerstone = Vec3.createVectorHelper(x,y,z);
        List<Entity> playerMPs = world.loadedEntityList;
        for (int i = 0; i < playerMPs.size();i++) {
            Entity entity = playerMPs.get(i);
            if (entity instanceof EntityLivingBase) {
                if (!(entity instanceof EntityPlayer) && !(entity instanceof EntityBat) && !(entity instanceof EntityChicken)) {
                     Vec3 location = Vec3.createVectorHelper(entity.posX,entity.posY,entity.posZ);
                    if (location.distanceTo(cornerstone) < 100) {
                        entity.motionY += 3.0F;
                    }
                }
            }
        }
    }

}
