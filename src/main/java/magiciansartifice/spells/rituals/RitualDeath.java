package magiciansartifice.spells.rituals;

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
            
        }
    }
}
