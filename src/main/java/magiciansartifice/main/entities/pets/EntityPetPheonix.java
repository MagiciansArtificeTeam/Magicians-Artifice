package magiciansartifice.main.entities.pets;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

/**
 * Created by poppypoppop on 1/10/2014.
 */
public class EntityPetPheonix extends EntityPetBase {
    private static double health = 30.0D;
    private static double range = 40.0D;
    private static double speed = 0.6000000238418579D;

    public EntityPetPheonix(World world) {
        super(world, health, range, speed);
    }

    public EntityPetPheonix createChild(EntityAgeable ageable) {
        EntityPetPheonix baby = new EntityPetPheonix(this.worldObj);
        baby.onSpawnWithEgg((IEntityLivingData)null);
        return baby;
    }
}
