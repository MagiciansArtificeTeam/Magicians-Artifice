package magiciansartifice.main.core.utils;

import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by poppypoppop on 5/10/2014.
 */
public class EntityHelper {
    public static Entity getClosestEntity(World world, int x, int y, int z, int range, EntityPlayer player) {
        // unfortunately the method returns a list without a generic type, so we have to treat the elements of the list as objects. thats why i didn't do List<Entity>, its not my fault
        List entities = world.getEntitiesWithinAABBExcludingEntity(player, AxisAlignedBB.getBoundingBox(x - range, y - range, z - range, x + range, y + range, z + range), IEntitySelector.selectAnything);

        Entity closest = null;
        double dist = -1;
        for(Object o : entities) {
            System.out.println(o);
            Entity e = (Entity) o;

            double d = Math.sqrt((x - e.posX) + (x - e.posY) + (z + e.posZ));
            if(dist == -1 && d < dist) {
                dist = d;
                closest = e;
            }
        }

        //System.out.println(closest);
        return closest;
    }
}
