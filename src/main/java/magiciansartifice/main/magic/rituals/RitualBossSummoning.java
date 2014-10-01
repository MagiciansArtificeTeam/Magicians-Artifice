package magiciansartifice.main.magic.rituals;

import java.util.Random;

import magiciansartifice.api.BasicRitual;
import magiciansartifice.main.blocks.BlockRegistry;
import magiciansartifice.main.entities.bosses.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class RitualBossSummoning extends BasicRitual {
	public static Random itemRand = new Random();

    public void startRitual(int x, int y, int z, World world, EntityPlayer player) {
        super.startRitual(x,y,z,world,player);
    }
    
    public void initEffect(int x, int y, int z, World world, EntityPlayer player) {
    	switch (player.dimension) {
    	case -1: world.spawnEntityInWorld(new EntityBossNether(world)); break;
    	case 0: world.spawnEntityInWorld(new EntityBossOverworld(world)); break;
    	case 1: world.spawnEntityInWorld(new EntityBossEnder(world)); break;
    	}
    }
    
    public boolean areAllBlocksCorrect(int x, int y, int z, World world, EntityPlayer player) {
    	int x1 = x;
    	int y1 = y;
    	int z1 = z;
    	
    	{
    		x1 += 6;
    		if (world.getBlock(x1, y1, z1) != Blocks.stonebrick) return false;
    	}
    	
    	System.out.println(x1);
    	
    	{
    		x1 -= 1;
    		if (world.getBlock(x1, y1, z1) != BlockRegistry.storage) return false;
    	}
    	
    	System.out.println(x1);
    	
    	{
    		x1 -= 1;
    		z1 -= 4;
    		if (world.getBlock(x1, y1, z1) != Blocks.stonebrick) return false;
    		z1 += 4;
    		if (world.getBlock(x1, y1, z1) != BlockRegistry.storage) return false;
    		z1 += 4;
    		if (world.getBlock(x1, y1, z1) != Blocks.stonebrick) return false;
    	}
    	
    	z1 = z;
    	System.out.println(x1);
    	
    	{
    		x1 -= 1;
    		z1 -= 3;
    		if (Item.getItemFromBlock(world.getBlock(x1, y1, z1)) != new ItemStack(BlockRegistry.storage, 1, 2).getItem()) return false; 
    		z1 += 3;
    		if (world.getBlock(x1, y1, z1) != BlockRegistry.storage) return false;
    		z1 += 3;
    		if (Item.getItemFromBlock(world.getBlock(x1, y1, z1)) != new ItemStack(BlockRegistry.storage, 1, 2).getItem()) return false;
    	}
    	
    	z1 = z;
    	System.out.println(x1);
    	
    	{
    		x1 -= 1;
    		z1 -= 2;
    		if (Item.getItemFromBlock(world.getBlock(x1, y1, z1)) != new ItemStack(BlockRegistry.storage, 1, 2).getItem()) return false;
    		z1 += 2;
    		if (world.getBlock(x1, y1, z1) != BlockRegistry.storage) return false;
    		z1 += 2;
    		if (Item.getItemFromBlock(world.getBlock(x1, y1, z1)) != new ItemStack(BlockRegistry.storage, 1, 2).getItem()) return false;
    	}
    	
    	z1 = z;
    	System.out.println(x1);
    	
    	{
    		x1 -= 1;
    		z1 -= 1;
    		if (Item.getItemFromBlock(world.getBlock(x1, y1, z1)) != new ItemStack(BlockRegistry.storage, 1, 2).getItem()) return false;
    		z1 += 1;
    		if (Item.getItemFromBlock(world.getBlock(x1, y1, z1)) != new ItemStack(BlockRegistry.storage, 1, 1).getItem()) return false;
    		z1 += 1;
    		if (Item.getItemFromBlock(world.getBlock(x1, y1, z1)) != new ItemStack(BlockRegistry.storage, 1, 2).getItem()) return false;
    	}
    	
    	z1 = z;
    	
    	{
    		x1 -= 1;
    		z1 -= 1;
    		if (Item.getItemFromBlock(world.getBlock(x1, y1, z1)) != new ItemStack(BlockRegistry.storage, 1, 1).getItem()) return false;
    		z1 += 1;
    		if (world.getBlock(x1, y1, z1) != BlockRegistry.ritualCornerStone) return false;
    		z1 += 1;
    		if (Item.getItemFromBlock(world.getBlock(x1, y1, z1)) != new ItemStack(BlockRegistry.storage, 1, 1).getItem()) return false;
    	}
    	
    	z1 = z;
    	System.out.println(x1);
    	
    	{
    		x1 -= 1;
    		z1 -= 1;
    		if (Item.getItemFromBlock(world.getBlock(x1, y1, z1)) != new ItemStack(BlockRegistry.storage, 1, 2).getItem()) return false;
    		z1 += 1;
    		if (Item.getItemFromBlock(world.getBlock(x1, y1, z1)) != new ItemStack(BlockRegistry.storage, 1, 1).getItem()) return false;
    		z1 += 1;
    		if (Item.getItemFromBlock(world.getBlock(x1, y1, z1)) != new ItemStack(BlockRegistry.storage, 1, 2).getItem()) return false;
    	}
    	
    	z1 = z;
    	System.out.println(x1);
    	
    	{
    		x1 -= 1;
    		z1 -= 2;
    		if (Item.getItemFromBlock(world.getBlock(x1, y1, z1)) != new ItemStack(BlockRegistry.storage, 1, 2).getItem()) return false;
    		z1 += 2;
    		if (world.getBlock(x1, y1, z1) != BlockRegistry.storage) return false;
    		z1 += 2;
    		if (Item.getItemFromBlock(world.getBlock(x1, y1, z1)) != new ItemStack(BlockRegistry.storage, 1, 2).getItem()) return false;
    	}
    	
    	z1 = z;
    	System.out.println(x1);
    	
    	{
    		x1 -= 1;
    		z1 -= 3;
    		if (Item.getItemFromBlock(world.getBlock(x1, y1, z1)) != new ItemStack(BlockRegistry.storage, 1, 2).getItem()) return false;
    		z1 += 3;
    		if (world.getBlock(x1, y1, z1) != BlockRegistry.storage) return false;
    		z1 += 3;
    		if (Item.getItemFromBlock(world.getBlock(x1, y1, z1)) != new ItemStack(BlockRegistry.storage, 1, 2).getItem()) return false;
    	}
    	
    	z1 = z;
    	System.out.println(x1);
    	
    	{
    		x1 -= 1;
    		z1 -= 4;
    		if (world.getBlock(x1, y1, z1) != Blocks.stonebrick) return false;
    		z1 += 4;
    		if (world.getBlock(x1, y1, z1) != BlockRegistry.storage) return false;
    		z1 += 4;
    		if (world.getBlock(x1, y1, z1) != Blocks.stonebrick) {
    			System.out.println(x1 + ", " + y1 + ", " + z1 + ": " + world.getBlock(x1, y1, z1).getLocalizedName());
    			return false;
    		}
    	}
    	
    	z1 = z;
    	System.out.println(x1);
    	
    	{
    		x1 -= 1;
    		if (world.getBlock(x1, y1, z1) != BlockRegistry.storage) {
    			System.out.println(x1 + ", " + y1 + ", " + z1 + ": " + world.getBlock(x1, y1, z1).getLocalizedName());
    			return false;
    		}
    	}
    	
    	System.out.println(x1);
    	
    	{
    		x1 -= 1;
    		if (world.getBlock(x1, y1, z1) != Blocks.stonebrick){
    			System.out.println(x1 + ", " + y1 + ", " + z1 + ": " + world.getBlock(x1, y1, z1).getLocalizedName());
    			return false;
    		}
    	}
    	
    	System.out.println(x1);
    	
    	return true;
    }
}
