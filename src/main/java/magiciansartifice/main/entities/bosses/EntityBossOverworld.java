package magiciansartifice.main.entities.bosses;

import magiciansartifice.api.INotKillCurseable;
import magiciansartifice.main.blocks.BlockRegistry;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityBossOverworld extends EntityMob implements IBossDisplayData, IMob, INotKillCurseable {
	public static int spawningDimension = 0;
	
	private static final IEntitySelector attackEntitySelector = new IEntitySelector()
    {
        public boolean isEntityApplicable(Entity entity)
        {
            return entity instanceof EntityLivingBase && ((EntityLivingBase)entity).getCreatureAttribute() != EnumCreatureAttribute.UNDEAD;
        }
    };
	
	public EntityBossOverworld(World world) {
		super(world);
		this.setHealth(this.getMaxHealth());
        this.setSize(0.9F, 4.0F);
        this.isImmuneToFire = false;
        this.getNavigator().setCanSwim(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityLiving.class, 0, false, false, attackEntitySelector));
        this.experienceValue = 50;
	}
	
	protected String getHurtSound() { return "game.hostile.hurt"; }
	
    protected String getDeathSound() { return "game.hostile.die"; }
    
    protected String func_146067_o(int distance) { return distance > 4 ? "game.hostile.hurt.fall.big" : "game.hostile.hurt.fall.small"; }
    
    public boolean getCanSpawnHere() { return this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && isCorrectBlock() && isCorrectDimension(); } 
    
    private boolean isCorrectBlock() { return worldObj.getBlock(this.chunkCoordX, this.chunkCoordY, this.chunkCoordZ) == BlockRegistry.ritualCornerStone; }
    
    private boolean isCorrectDimension() { return this.dimension == spawningDimension; }
}
