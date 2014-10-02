package magiciansartifice.main.core.client.entity.boss;

import magiciansartifice.main.core.libs.ModInfo;
import magiciansartifice.main.entities.bosses.EntityBossNether;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.util.ResourceLocation;

public class RenderBossNether extends RenderLiving {
	ResourceLocation texture = new ResourceLocation(ModInfo.MODID, "textures/entities/netherBoss.png");
	
	public RenderBossNether(ModelBase model, float size) {
		super(model, size);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}
	
	public void renderBoss(EntityBossNether entity, double x, double y, double z, float yaw, float partialRenderTicks) {
        super.doRender(entity, x, y, z, yaw, partialRenderTicks);
    }

    public void doRender(Entity entity, double x, double y, double z, float yaw, float partialRenderTicks) {
    	EntityBossNether boss = (EntityBossNether) entity;
    	
    	BossStatus.setBossStatus(boss, true);
        this.renderBoss((EntityBossNether) entity, x, y, z, yaw, partialRenderTicks);
    }
}