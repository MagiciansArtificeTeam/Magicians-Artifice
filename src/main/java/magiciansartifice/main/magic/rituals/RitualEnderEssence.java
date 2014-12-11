package magiciansartifice.main.magic.rituals;

import magiciansartifice.api.BasicRitual;
import magiciansartifice.main.core.utils.registries.BlockRegistry;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
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
        world.func_147480_a(x-1,y,z-1,false);
        world.func_147480_a(x-1,y,z+1,false);
        world.func_147480_a(x+1,y,z-1,false);
        world.func_147480_a(x+1,y,z+1,false);
        world.func_147480_a(x+1,y,z,false);
        world.func_147480_a(x-1,y,z,false);
        world.func_147480_a(x,y,z+1,false);
        world.func_147480_a(x,y,z-1,false);
        EntityItem item = new EntityItem(world,x,y+1,z,new ItemStack(BlockRegistry.storage,1,2));
        item.setLocationAndAngles(x,y+1,z,0,0);
        item.setAir(10);
        item.setEntityItemStack(new ItemStack(BlockRegistry.storage,1,2));
        world.spawnEntityInWorld(item);
    }
    
    @Override
    public boolean areAllBlocksCorrect(int x, int y, int z, World world, EntityPlayer player) {
        int x2 = x;
        int z2 = z;

        x -= 1;

        if (Item.getItemFromBlock(world.getBlock(x, y, z)) != new ItemStack(BlockRegistry.storage, 1, 0).getItem()) {
            return false;
        }
        
        x = x2;
        x += 1;

        if (Item.getItemFromBlock(world.getBlock(x, y, z)) != new ItemStack(BlockRegistry.storage, 1, 0).getItem()) {
            return false;
        }
        
        x = x2;
        z -= 1;

        if (Item.getItemFromBlock(world.getBlock(x, y, z)) != new ItemStack(BlockRegistry.storage, 1, 0).getItem()) {
            return false;
        }

        z = z2;
        z += 1;

        if (Item.getItemFromBlock(world.getBlock(x, y, z)) != new ItemStack(BlockRegistry.storage, 1, 0).getItem()) {
            return false;
        }
        
        z = z2;
        z -= 1;
        x -= 1;

        if (Item.getItemFromBlock(world.getBlock(x, y, z)) != new ItemStack(BlockRegistry.storage, 1, 1).getItem()) {
            return false;
        }
        
        x = x2;
        z = z2;
        z += 1;

        if (Item.getItemFromBlock(world.getBlock(x, y, z)) != new ItemStack(BlockRegistry.storage, 1, 1).getItem()) {
            return false;
        }

        z = z2;
        x = x2;
        x += 1;
        z -= 1;

        if (Item.getItemFromBlock(world.getBlock(x, y, z)) != new ItemStack(BlockRegistry.storage, 1, 1).getItem()) {
            return false;
        }
        
        z = z2;
        z += 1;

        if (Item.getItemFromBlock(world.getBlock(x, y, z)) != new ItemStack(BlockRegistry.storage, 1, 1).getItem()) {
            return false;
        }
        return true;
    }
}