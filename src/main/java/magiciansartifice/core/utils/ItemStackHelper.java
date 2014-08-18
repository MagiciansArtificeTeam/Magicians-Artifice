package magiciansartifice.core.utils;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created by James Hollowell on 7/22/2014.
 */
public class ItemStackHelper
{
    private static final Random random = new Random();

    /**
     * Spawn an item stack in the world from a specific location
     * @param stack The stack to spawn
     * @param world The world to spawn into
     * @param x X coordinate to start at
     * @param y Y coordinate to start at
     * @param z Z coordinate to start at
     */
    public static void spawnItemStackInWorld(ItemStack stack, World world, int x, int y, int z)
    {
        if (world.isRemote) return; //only spawn entities on the server
        if(stack!=null)
        {
            float f = random.nextFloat() * 0.8F + 0.1F;
            float f1 = random.nextFloat() * 0.8F + 0.1F;
            EntityItem entityitem;

            for (float f2 = random.nextFloat() * 0.8F + 0.1F; stack.stackSize > 0; world.spawnEntityInWorld(entityitem))
            {
                int j1 = random.nextInt(21) + 10;

                if (j1 > stack.stackSize)
                {
                    j1 = stack.stackSize;
                }

                stack.stackSize -= j1;
                entityitem = new EntityItem(world, (double) ((float) x + f), (double) ((float) y + f1), (double) ((float) z + f2), new ItemStack(stack.getItem(), j1, stack.getItemDamage()));
                float f3 = 0.05F;
                entityitem.motionX = (double) ((float) random.nextGaussian() * f3);
                entityitem.motionY = (double) ((float) random.nextGaussian() * f3 + 0.2F);
                entityitem.motionZ = (double) ((float) random.nextGaussian() * f3);

                if (stack.hasTagCompound())
                {
                    entityitem.getEntityItem().setTagCompound((NBTTagCompound) stack.getTagCompound().copy());
                }
            }
        }
    }
}
