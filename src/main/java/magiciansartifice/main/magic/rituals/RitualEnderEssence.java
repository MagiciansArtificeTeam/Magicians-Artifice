package magiciansartifice.main.magic.rituals;

import magiciansartifice.api.BasicRitual;
import magiciansartifice.main.blocks.BlockRegistry;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class RitualEnderEssence extends BasicRitual {

    @Override
    public void startRitual(int x, int y, int z, World world, EntityPlayer player) {
        super.startRitual(x,y,z,world,player);
    }

    @Override
    public void initEffect(int x, int y, int z, World world, EntityPlayer player) {
        System.err.println("Called it!");
        world.func_147480_a(x-1,y,z-1,false);
        world.func_147480_a(x-1,y,z+1,false);
        world.func_147480_a(x+1,y,z-1,false);
        world.func_147480_a(x+1,y,z+1,false);
        EntityItem item = new EntityItem(world,x,y+1,z,new ItemStack(BlockRegistry.storage,1,2));
        item.setLocationAndAngles(x,y,z,0,0);
        item.setEntityItemStack(new ItemStack(BlockRegistry.storage,1,2));
        world.spawnEntityInWorld(item);
    }

    public boolean areAllBlocksCorrect(int x, int y, int z, World world, EntityPlayer player) {
        int x2 = x;
        int y2 = y;
        int z2 = z;

        x2 -= 1;

        if (Item.getItemFromBlock(world.getBlock(x2,y2,z2)) != new ItemStack(BlockRegistry.storage,1,0).getItem()) {
            System.err.println("If 1");
            return false;
        }

        x2 += 2;

        if (Item.getItemFromBlock(world.getBlock(x2,y2,z2)) != new ItemStack(BlockRegistry.storage,1,0).getItem()) {
            System.err.println("If 2");
            return false;
        }

        x2 -= 1;
        z2 -= 1;

        if (Item.getItemFromBlock(world.getBlock(x2,y2,z2)) != new ItemStack(BlockRegistry.storage,1,0).getItem()) {
            System.err.println("If 3");
            return false;
        }

        z2 += 2;

        if (Item.getItemFromBlock(world.getBlock(x2,y2,z2)) != new ItemStack(BlockRegistry.storage,1,0).getItem()) {
            System.err.println("If 4");
            return false;
        }

        z2 -= 2;
        x2 -= 1;

        if (Item.getItemFromBlock(world.getBlock(x2,y2,z2)) != new ItemStack(BlockRegistry.storage,1,1).getItem()) {
            System.err.println("If 5");
            return false;
        }

        z2 += 2;

        if (Item.getItemFromBlock(world.getBlock(x2,y2,z2)) != new ItemStack(BlockRegistry.storage,1,1).getItem()) {
            System.err.println("If 6");
            return false;
        }

        x2 += 2;
        z2 -= 2;

        if (Item.getItemFromBlock(world.getBlock(x2,y2,z2)) != new ItemStack(BlockRegistry.storage,1,1).getItem()) {
            System.err.println("If 7");
            return false;
        }

        z2 += 2;

        if (Item.getItemFromBlock(world.getBlock(x2,y2,z2)) != new ItemStack(BlockRegistry.storage,1,1).getItem()) {
            System.err.println("If 8");
            return false;
        }
        System.err.println("Returned true!");
        return true;
    }

    }
