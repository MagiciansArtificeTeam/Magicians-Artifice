package magiciansartifice.main.entities.pets;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.world.World;

/**
 * Created by poppypoppop on 2/10/2014.
 */
public class EntityPetRat extends EntityPetBase {
    private static double health = 40.0D;
    private static double range = 40.0D;
    private static double speed = 0.6000000238418579D;

    public EntityPetRat(World world) {
        super(world, health, range, speed);
    }

    public EntityPetRat createChild(EntityAgeable ageable) {
        EntityPetRat baby = new EntityPetRat(this.worldObj);
        baby.onSpawnWithEgg((IEntityLivingData)null);
        return baby;
    }
}
