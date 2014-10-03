package magiciansartifice.main.core.events;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import magiciansartifice.main.entities.pets.EntityPetPheonix;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

/**
 * Created by poppypoppop on 2/10/2014.
 */
public class EntityEventRebirth {
    @SubscribeEvent()
    public void pheonixReborn(LivingDeathEvent event) {
        World world = event.entity.worldObj;
        EntityLivingBase entity = event.entityLiving;
        if (entity instanceof EntityVillager && !world.isRemote) {
            double x = ((EntityVillager) entity).posX;
            double y = ((EntityVillager) entity).posY;
            double z = ((EntityVillager) entity).posZ;
            float yaw = ((EntityVillager) entity).rotationYaw;
            float pitch = ((EntityVillager) entity).rotationPitch;
            int iAge = -24000;

            EntityVillager baby = new EntityVillager(world);
            baby.setPositionAndRotation(x, y, z, yaw, pitch);
            baby.setGrowingAge(iAge);
            world.spawnEntityInWorld(baby);
        }
    }
}
