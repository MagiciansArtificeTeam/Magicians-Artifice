package magiciansartifice.main.core.client.entity.pets;

import magiciansartifice.main.core.libs.ModInfo;
import magiciansartifice.main.entities.pets.EntityPetPheonix;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

/**
 * Created by poppypoppop on 2/10/2014.
 */
public class RenderPetAppling extends RenderLiving {
    ResourceLocation texture = new ResourceLocation(ModInfo.MODID, "textures/entities/appling.png");

    public RenderPetAppling(ModelBase model, float size) {
        super(model, size);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return texture;
    }

    public void renderBoss(EntityPetPheonix entity, double x, double y, double z, float yaw, float partialRenderTicks) {
        super.doRender(entity, x, y, z, yaw, partialRenderTicks);
    }

    public void doRender(Entity entity, double x, double y, double z, float yaw, float partialRenderTicks) {
        this.renderBoss((EntityPetPheonix) entity, x, y, z, yaw, partialRenderTicks);
    }
}
