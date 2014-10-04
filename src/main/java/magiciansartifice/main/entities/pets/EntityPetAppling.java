package magiciansartifice.main.entities.pets;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

/**
 * Created by poppypoppop on 2/10/2014.
 */
public class EntityPetAppling extends EntityPetBase {
    private static double health = 20.0D;
    private static double range = 40.0D;
    private static double speed = 0.6000000238418579D;

    public EntityPetAppling(World world) { super(world, health, range, speed); }

    public boolean interact(EntityPlayer player) {
        player.getFoodStats().setFoodLevel(20);
        this.damageEntity(DamageSource.magic, 10.0F);
        return false;
    }

    public EntityPetAppling createChild(EntityAgeable ageable) {
        EntityPetAppling baby = new EntityPetAppling(this.worldObj);
        baby.onSpawnWithEgg((IEntityLivingData)null);
        return baby;
    }
}
