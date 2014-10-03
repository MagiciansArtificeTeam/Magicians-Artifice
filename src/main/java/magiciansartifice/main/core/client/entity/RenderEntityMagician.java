package magiciansartifice.main.core.client.entity;

import magiciansartifice.main.core.libs.ModInfo;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderEntityMagician extends RenderLiving {
	public RenderEntityMagician(ModelBase base, float size) {
		super(base, size);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation(ModInfo.MODID, "textures/entities/magician.png");
	}
}
