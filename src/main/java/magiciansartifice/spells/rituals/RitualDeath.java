package magiciansartifice.spells.rituals;

import magiciansartifice.api.BasicRitual;
import magiciansartifice.blocks.BlockRegistry;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.Random;

public class RitualDeath extends BasicRitual{
    public static Random itemRand = new Random();

    public void startRitual(int x, int y, int z, World world, EntityPlayer player) {
        super.startRitual(x,y,z,world,player);
    }

    public void initEffect(int x, int y, int z, World world, EntityPlayer player) {
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
    
    public boolean areAllBlocksCorrect(int x, int y, int z, World world, EntityPlayer player) {
        x += 2;
        z += 2;

        {
            x -= 1;
            if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(Blocks.stonebrick, 1, 3).getItem()))
                return false;
            x -= 1;
            y += 1;
            if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(Blocks.skull, 1, 1).getItem()))
                return false;
            x -= 1;
            y -= 1;
            if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(Blocks.stonebrick, 1, 3).getItem()))
                return false;
            x -= 1;
        }

        x += 4;
        z -= 1;

        {
            if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(Blocks.stonebrick, 1, 3).getItem()))
                return false;
            x -= 2;
            if (!(world.getBlock(x, y, z) == BlockRegistry.planks))
                return false;
            x -= 2;
            if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(Blocks.stonebrick, 1, 3).getItem()))
                return false;
        }

        x += 4;
        z -= 1;

        {
            y += 1;
            if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(Blocks.skull, 1, 1).getItem()))
                return false;
            y -= 1;
            x -= 1;
            if (!(world.getBlock(x, y, z) == BlockRegistry.planks))
                return false;
            x -= 1;
            if (!(world.getBlock(x, y, z) == BlockRegistry.ritualCornerStone))
                return false;
            x -= 1;
            if (!(world.getBlock(x, y, z) == BlockRegistry.planks))
                return false;
            y += 1;
            if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(Blocks.skull, 1, 1).getItem()))
                return false;
            y -= 1;
        }

        x += 4;
        z -= 1;

        {
            if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(Blocks.stonebrick, 1, 3).getItem()))
                return false;
            x -= 2;
            if (!(world.getBlock(x, y, z) == BlockRegistry.planks))
                return false;
            x -= 2;
            if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(Blocks.stonebrick, 1, 3).getItem()))
                return false;
        }

        x += 4;
        z -= 1;

        {
            x -= 1;
            if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(Blocks.stonebrick, 1, 3).getItem()))
                return false;
            x -= 1;
            y += 1;
            if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(Blocks.skull, 1, 1).getItem()))
                return false;
            x -= 1;
            y -= 1;
            if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(Blocks.stonebrick, 1, 3).getItem()))
                return false;
            x -= 1;
        }
        return true;
    }
    
}
