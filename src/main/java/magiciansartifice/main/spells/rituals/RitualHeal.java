package magiciansartifice.main.spells.rituals;

import magiciansartifice.api.BasicRitual;
import magiciansartifice.main.blocks.BlockRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.world.World;

import java.util.Random;

@SuppressWarnings("unused")
public class RitualHeal extends BasicRitual {

    public static Random itemRand = new Random();

    // CALL YOUR SUPER!
    @Override
    public void startRitual(int x, int y, int z, World world, EntityPlayer player) {
        super.startRitual(x,y,z,world,player);
    }

    public void initEffect(int x, int y, int z, World world, EntityPlayer player) {
        this.spawnParticles(world,x,y,z,itemRand,true);

        player.setHealth(20F);
        player.worldObj.playSoundAtEntity(player,"random.levelup",1.0F,1.0F);
        for (int i = 0; i < Potion.potionTypes.length;i++) {
            if (player.isPotionActive(i)) {
                player.removePotionEffect(i);
            }
        }
    }

    public boolean areAllBlocksCorrect(int x, int y, int z, World world, EntityPlayer player) {
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
                return false;
            y += 1;
            x -= 1;
            if (!(world.getBlock(x, y, z) == BlockRegistry.angelOrchid))
                return false;
            y -= 1;
            x -= 1;
            if (!(world.getBlock(x, y, z) == Blocks.stonebrick))
                return false;
            y += 1;
            x -= 1;
            if (!(world.getBlock(x, y, z) == BlockRegistry.angelOrchid))
                return false;
            y -= 1;
            x -= 1;
            if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(Blocks.stonebrick, 1, 3).getItem()))
                return false;
        }

        x += 4;
        z -= 1;

        {
            y += 1;
            if (!(world.getBlock(x, y, z) == BlockRegistry.angelOrchid))
                return false;
            y -= 1;
            x -= 1;
            if (!(world.getBlock(x, y, z) == BlockRegistry.planks))
                return false;
            x -= 2;
            if (!(world.getBlock(x, y, z) == BlockRegistry.planks))
                return false;
            y += 1;
            x -= 1;
            if (!(world.getBlock(x, y, z) == BlockRegistry.angelOrchid))
                return false;
            y -= 1;
        }

        x += 4;
        z -= 1;

        {
            if (!(world.getBlock(x, y, z) == Blocks.stonebrick))
                return false;
            x -= 2;
            if (!(world.getBlock(x, y, z) == BlockRegistry.ritualCornerStone))
                return false;
            x -= 2;
            if (!(world.getBlock(x, y, z) == Blocks.stonebrick))
                return false;
        }

        x += 4;
        z -= 1;

        {
            y += 1;
            if (!(world.getBlock(x, y, z) == BlockRegistry.angelOrchid))
                return false;
            y -= 1;
            x -= 1;
            if (!(world.getBlock(x, y, z) == BlockRegistry.planks))
                return false;
            x -= 2;
            if (!(world.getBlock(x, y, z) == BlockRegistry.planks))
                return false;
            y += 1;
            x -= 1;
            if (!(world.getBlock(x, y, z) == BlockRegistry.angelOrchid))
                return false;
            y -= 1;
        }

        x += 4;
        z -= 1;

        {
            if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(Blocks.stonebrick, 1, 3).getItem()))
                return false;
            y += 1;
            x -= 1;
            if (!(world.getBlock(x, y, z) == BlockRegistry.angelOrchid))
                return false;
            y -= 1;
            x -= 1;
            if (!(world.getBlock(x, y, z) == Blocks.stonebrick))
                return false;
            y += 1;
            x -= 1;
            if (!(world.getBlock(x, y, z) == BlockRegistry.angelOrchid))
                return false;
            y -= 1;
            x -= 1;
            if (!(Item.getItemFromBlock(world.getBlock(x, y, z)) == new ItemStack(Blocks.stonebrick, 1, 3).getItem()))
                return false;
        }
        return true;
    }

}
