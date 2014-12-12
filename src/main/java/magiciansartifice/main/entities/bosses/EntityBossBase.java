package magiciansartifice.main.entities.bosses;

import magiciansartifice.main.core.utils.registries.BlockRegistry;
import magiciansartifice.main.core.utils.registries.ItemRegistry;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

/**
 * Created by poppypoppop on 2/10/2014.
 */
@SuppressWarnings("static-access")
public class EntityBossBase extends EntityMob implements IBossDisplayData, IMob {
    public int spawningDimension = 0;
    private ItemStack drop;
    public int dropMeta;
    public ItemStack secondDrop;

    private static final IEntitySelector attackEntitySelector = new IEntitySelector()
    {
        public boolean isEntityApplicable(Entity entity)
        {
            return entity instanceof EntityLivingBase && ((EntityLivingBase)entity).getCreatureAttribute() != EnumCreatureAttribute.UNDEAD;
        }
    };

    public EntityBossBase(World world) {
        super(world);
        this.setHealth(this.getMaxHealth());
        this.setSize(0.9F, 4.0F);
        this.isImmuneToFire = true;
        this.getNavigator().setCanSwim(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityLiving.class, 0, false, false, attackEntitySelector));
        this.experienceValue = 50;

        dropMeta = 0;

        this.drop = new ItemStack(ItemRegistry.dustsMeta, dropMeta, 1);
        this.secondDrop = new ItemStack(ItemRegistry.angelFeather, 1, 2);
    }

    protected String getHurtSound() { return "game.hostile.hurt"; }

    protected String getDeathSound() { return "game.hostile.die"; }

    protected String func_146067_o(int distance) { return distance > 4 ? "game.hostile.hurt.fall.big" : "game.hostile.hurt.fall.small"; }

    public boolean getCanSpawnHere() { return this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && isCorrectBlock() && isCorrectDimension() && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox); }

    private boolean isCorrectBlock() { return worldObj.getBlock(this.chunkCoordX, this.chunkCoordY, this.chunkCoordZ) == BlockRegistry.ritualCornerStone; }

    private boolean isCorrectDimension() { return this.dimension == spawningDimension; }

    protected Item getDropItem() {
        return drop.getItem();
    }

    protected void dropFewItems(boolean doDrop, int amount)
    {
        Item item = this.getDropItem();

        if (item != null)
        {
            this.dropItem(item, 16);
            this.dropItem(secondDrop.getItem(), 2);
        }
    }

}