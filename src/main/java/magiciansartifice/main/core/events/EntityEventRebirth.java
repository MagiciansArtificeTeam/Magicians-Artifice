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
        if (entity instanceof EntityPetPheonix && !world.isRemote) {
            double x = ((EntityPetPheonix) entity).posX;
            double y = ((EntityPetPheonix) entity).posY;
            double z = ((EntityPetPheonix) entity).posZ;
            float yaw = ((EntityPetPheonix) entity).rotationYaw;
            float pitch = ((EntityPetPheonix) entity).rotationPitch;
            int iAge = -24000;

            EntityPetPheonix baby = new EntityPetPheonix(world);
            baby.setPositionAndRotation(x, y, z, yaw, pitch);
            baby.setGrowingAge(iAge);
            world.spawnEntityInWorld(baby);
        }
    }
}
