package magiciansartifice.main.core.client.entity;

import magiciansartifice.main.core.libs.ModInfo;
import magiciansartifice.main.entities.EntitySoulFragment;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/**
 * Created by Mitchellbrine on 2014.
 */
public class RenderSoulFragment extends RenderBiped {
    protected ModelBiped model;

    private ResourceLocation herobrineEyesTexture = new ResourceLocation(ModInfo.MODID,"textures/entities/herobrineEyes.png");

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
        ResourceLocation resourcelocation;

        if (((EntitySoulFragment)entity).playerName != null && !((EntitySoulFragment) entity).getPlayerName().equals(""))
        {
            resourcelocation = AbstractClientPlayer.getLocationSkin(((EntitySoulFragment)entity).playerName);
            AbstractClientPlayer.getDownloadImageSkin(resourcelocation, ((EntitySoulFragment)entity).playerName);
        } else {
            resourcelocation = new ResourceLocation(ModInfo.MODID, "textures/entities/herobrine.png");
        }
        return resourcelocation;
    }

    /**
     * Queries whether should render the specified pass or not.
     */
    protected int shouldRenderPass(EntitySpider p_77032_1_, int p_77032_2_, float p_77032_3_)
    {
            this.bindTexture(herobrineEyesTexture);
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glDisable(GL11.GL_ALPHA_TEST);
            GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);

            if (p_77032_1_.isInvisible())
            {
                GL11.glDepthMask(false);
            }
            else
            {
                GL11.glDepthMask(true);
            }

            char c0 = 61680;
            int j = c0 % 65536;
            int k = c0 / 65536;
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float) j / 1.0F, (float) k / 1.0F);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            return 1;
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

    /**
     * Queries whether should render the specified pass or not.
     */
    protected int shouldRenderPass(EntityLivingBase p_77032_1_, int p_77032_2_, float p_77032_3_)
    {
        return this.shouldRenderPass((EntitySoulFragment)p_77032_1_, p_77032_2_, p_77032_3_);
    }
}
