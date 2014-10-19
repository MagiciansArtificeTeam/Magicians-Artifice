package magiciansartifice.main.entities.bosses;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

@SuppressWarnings("static-access")
public class EntityBossNether extends EntityBossBase {
	public EntityBossNether(World world) {
		super(world);
		this.isImmuneToFire = true;
		this.spawningDimension = -1;
		this.dropMeta = 1;
	}

    public void onLivingUpdate() {
        super.onLivingUpdate();
    }

    @Override
    public boolean attackEntityAsMob(Entity player) {
        if (player.isBurning()) {
            player.setFire(player.getEntityData().getShort("Fire") + 40);
            player.attackEntityFrom(DamageSource.onFire,4.0F);
        } else {
            player.setFire(60);
        }
        return super.attackEntityAsMob(player);
    }

    protected void attackEntity(Entity p_70785_1_, float p_70785_2_)
    {
        double d0 = p_70785_1_.posX - this.posX;
        double d1 = p_70785_1_.boundingBox.minY + (double)(p_70785_1_.height / 2.0F) - (this.posY + (double)(this.height / 2.0F));
        double d2 = p_70785_1_.posZ - this.posZ;
        float f1 = MathHelper.sqrt_float(p_70785_2_) * 0.5F;

        if (rand.nextInt(100) <= 10) {
            for (int i = 0; i < 1; ++i) {
                EntitySmallFireball entitysmallfireball = new EntitySmallFireball(this.worldObj, this, d0 + this.rand.nextGaussian() * (double) f1, d1, d2 + this.rand.nextGaussian() * (double) f1);
                entitysmallfireball.posY = this.posY + (double) (this.height / 2.0F) + 0.5D;
                this.worldObj.spawnEntityInWorld(entitysmallfireball);
            }
        }
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(300.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.3D);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(40);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(4.0D);
    }

}
