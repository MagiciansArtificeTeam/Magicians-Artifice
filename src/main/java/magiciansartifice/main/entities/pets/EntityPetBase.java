package magiciansartifice.main.entities.pets;

import magiciansartifice.api.INotKillCurseable;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/**
 * Created by poppypoppop on 2/10/2014.
 */
public abstract class EntityPetBase extends EntityTameable implements INotKillCurseable{
    private double petHealth;
    private double petFollowRange;
    private double petMovementSpeed;

    public EntityPetBase(World world, double a_petHealth, double a_petFollowRange, double a_petMovementSpeed) {
        super(world);
        this.setSize(1.0F, 1.0F);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, this.aiSit);
        this.tasks.addTask(3, new EntityAILeapAtTarget(this, 0.4F));
        this.tasks.addTask(4, new EntityAIAttackOnCollide(this, 1.0D, true));
        this.tasks.addTask(5, new EntityAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
        this.tasks.addTask(6, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(9, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(9, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
        this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));

        this.petHealth = a_petHealth;
        this.petFollowRange = a_petFollowRange;
        this.petMovementSpeed = a_petMovementSpeed;
    }

    public EntityAgeable createChild(EntityAgeable ageable) {
        return null;
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(this.getPetHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.getPetMovementSpeed());
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(this.getPetFollowRange());
    }

    public void onUpdate() {
        super.onUpdate();
        if (this.getHealth() > 0.0F) {
            if (this.rand.nextInt(100) == 0) {
                float newHealth = this.getHealth() + 1.0F;
                this.setHealth(newHealth);
            }
        }
    }

    public double getPetHealth() {
        return this.petHealth;
    }

    public double getPetFollowRange() {
        return this.petFollowRange;
    }

    public double getPetMovementSpeed() {
        return this.petMovementSpeed;
    }

}