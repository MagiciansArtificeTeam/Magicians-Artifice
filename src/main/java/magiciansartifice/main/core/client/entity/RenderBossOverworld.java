package magiciansartifice.main.core.client.entity;

import magiciansartifice.main.core.libs.ModInfo;
import magiciansartifice.main.entities.bosses.EntityBossOverworld;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderBossOverworld extends RenderLiving {
	ResourceLocation texture = new ResourceLocation(ModInfo.MODID, "textures/entities/overworldBoss.png");
	
	public RenderBossOverworld(ModelBase model, float size) {
		super(model, size);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}
	
	public void renderBoss(EntityBossOverworld entity, double x, double y, double z, float yaw, float partialRenderTicks)
    {
        super.doRender(entity, x, y, z, yaw, partialRenderTicks);
    }

    public void doRenderLiving(EntityBossOverworld living, double x, double y, double z, float yaw, float partialRenderTicks)
    {
        this.renderBoss((EntityBossOverworld) living, x, y, z, yaw, partialRenderTicks);
    }

    public void doRender(EntityBossOverworld entity, double x, double y, double z, float yaw, float partialRenderTicks)
    {
        this.renderBoss((EntityBossOverworld) entity, x, y, z, yaw, partialRenderTicks);
    }
}
