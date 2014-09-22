package magiciansartifice.main.core.client.entity;

import magiciansartifice.main.entities.EntitySoulFragment;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/**
 * Created by Mitchellbrine on 2014.
 */
public class RenderSoulFragment extends RenderBiped {
    protected ModelBiped model;

    public RenderSoulFragment(ModelBiped modelBiped, float f)
    {
        super(modelBiped, f);
        this.model = (ModelBiped) this.mainModel;
    }

    public void renderSoul(EntitySoulFragment entity, double x, double y, double z, float yaw, float partialRenderTicks)
    {
        super.doRender(entity, x, y, z, yaw, partialRenderTicks);
    }

    public void doRenderLiving(EntitySoulFragment living, double x, double y, double z, float yaw, float partialRenderTicks)
    {
        this.renderSoul((EntitySoulFragment) living, x, y, z, yaw, partialRenderTicks);
    }

    public void doRender(EntitySoulFragment entity, double x, double y, double z, float yaw, float partialRenderTicks)
    {
        this.renderSoul((EntitySoulFragment) entity, x, y, z, yaw, partialRenderTicks);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    @Override
    protected ResourceLocation getEntityTexture(Entity entity)
    {
        ResourceLocation resourcelocation = AbstractClientPlayer.locationStevePng;

        if (((EntitySoulFragment)entity).playerName != null && ((EntitySoulFragment)entity).playerName.length() > 0)
        {
                resourcelocation = AbstractClientPlayer.getLocationSkin(((EntitySoulFragment)entity).playerName);
                AbstractClientPlayer.getDownloadImageSkin(resourcelocation, ((EntitySoulFragment)entity).playerName);
        }
        return resourcelocation;
    }

    @Override
    protected void rotateCorpse(EntityLivingBase entity, float x, float y, float z)
    {
        GL11.glRotatef(180.0F - y, 0.0F, 1.0F, 0.0F);

        if (entity.deathTime > 0)
        {
            float f3 = ((float)entity.deathTime + z - 1.0F) / 20.0F * 1.6F;
            f3 = MathHelper.sqrt_float(f3);

            if (f3 > 1.0F)
            {
                f3 = 1.0F;
            }

            GL11.glRotatef(f3 * this.getDeathMaxRotation(entity), 0.0F, 0.0F, 1.0F);
        }
        else
        {
            String s = EnumChatFormatting.getTextWithoutFormattingCodes(entity.getCommandSenderName());

            if ((s.equals("Dinnerbone") || (s.equals("Grumm"))))
            {
                GL11.glTranslatef(0.0F, entity.height + 0.1F, 0.0F);
                GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
            }
        }
    }
}
