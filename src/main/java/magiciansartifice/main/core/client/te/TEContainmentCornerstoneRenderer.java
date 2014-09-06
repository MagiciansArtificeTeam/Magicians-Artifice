package magiciansartifice.main.core.client.te;

import magiciansartifice.main.core.libs.ModInfo;
import magiciansartifice.main.tileentities.magic.TileEntityContainmentCornerstone;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class TEContainmentCornerstoneRenderer extends TileEntitySpecialRenderer{

    private static final ResourceLocation beaconTexture = new ResourceLocation(ModInfo.MODID + ":textures/blocks/containment/beacon_beam.png");

    public void renderTileEntityAt(TileEntityContainmentCornerstone te, double p_147500_2_, double p_147500_4_, double p_147500_6_, float p_147500_8_)
    {
        GL11.glAlphaFunc(GL11.GL_GREATER, 0.1F);

        if (te.fieldActive) {
            Tessellator tessellator = Tessellator.instance;
            this.bindTexture(beaconTexture);
            GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S, 10497.0F);
            GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_T, 10497.0F);
            GL11.glDisable(GL11.GL_LIGHTING);
            GL11.glDisable(GL11.GL_CULL_FACE);
            GL11.glDisable(GL11.GL_BLEND);
            GL11.glDepthMask(true);
            OpenGlHelper.glBlendFunc(770, 1, 1, 0);
            float f2 = (float) te.getWorldObj().getTotalWorldTime() + p_147500_8_;
            float f3 = -f2 * 0.2F - (float) MathHelper.floor_float(-f2 * 0.1F);
            byte b0 = 1;
            double d3 = (double) f2 * 0.025D * (1.0D - (double) (b0 & 1) * 2.5D);
            tessellator.startDrawingQuads();
            tessellator.setColorRGBA(255, 255, 255, 32);
            double d5 = (double) b0 * 0.2D;
            double d7 = 0.5D + Math.cos(d3 + 2.356194490192345D) * d5;
            double d9 = 0.5D + Math.sin(d3 + 2.356194490192345D) * d5;
            double d11 = 0.5D + Math.cos(d3 + (Math.PI / 4D)) * d5;
            double d13 = 0.5D + Math.sin(d3 + (Math.PI / 4D)) * d5;
            double d15 = 0.5D + Math.cos(d3 + 3.9269908169872414D) * d5;
            double d17 = 0.5D + Math.sin(d3 + 3.9269908169872414D) * d5;
            double d19 = 0.5D + Math.cos(d3 + 5.497787143782138D) * d5;
            double d21 = 0.5D + Math.sin(d3 + 5.497787143782138D) * d5;
            double d23 = (double) (256.0F);
            double d25 = 0.0D;
            double d27 = 1.0D;
            double d28 = (double) (-1.0F + f3);
            double d29 = (double) (256.0F) * (0.5D / d5) + d28;
            tessellator.addVertexWithUV(p_147500_2_ + d7, p_147500_4_ + d23, p_147500_6_ + d9, d27, d29);
            tessellator.addVertexWithUV(p_147500_2_ + d7, p_147500_4_, p_147500_6_ + d9, d27, d28);
            tessellator.addVertexWithUV(p_147500_2_ + d11, p_147500_4_, p_147500_6_ + d13, d25, d28);
            tessellator.addVertexWithUV(p_147500_2_ + d11, p_147500_4_ + d23, p_147500_6_ + d13, d25, d29);
            tessellator.addVertexWithUV(p_147500_2_ + d19, p_147500_4_ + d23, p_147500_6_ + d21, d27, d29);
            tessellator.addVertexWithUV(p_147500_2_ + d19, p_147500_4_, p_147500_6_ + d21, d27, d28);
            tessellator.addVertexWithUV(p_147500_2_ + d15, p_147500_4_, p_147500_6_ + d17, d25, d28);
            tessellator.addVertexWithUV(p_147500_2_ + d15, p_147500_4_ + d23, p_147500_6_ + d17, d25, d29);
            tessellator.addVertexWithUV(p_147500_2_ + d11, p_147500_4_ + d23, p_147500_6_ + d13, d27, d29);
            tessellator.addVertexWithUV(p_147500_2_ + d11, p_147500_4_, p_147500_6_ + d13, d27, d28);
            tessellator.addVertexWithUV(p_147500_2_ + d19, p_147500_4_, p_147500_6_ + d21, d25, d28);
            tessellator.addVertexWithUV(p_147500_2_ + d19, p_147500_4_ + d23, p_147500_6_ + d21, d25, d29);
            tessellator.addVertexWithUV(p_147500_2_ + d15, p_147500_4_ + d23, p_147500_6_ + d17, d27, d29);
            tessellator.addVertexWithUV(p_147500_2_ + d15, p_147500_4_, p_147500_6_ + d17, d27, d28);
            tessellator.addVertexWithUV(p_147500_2_ + d7, p_147500_4_, p_147500_6_ + d9, d25, d28);
            tessellator.addVertexWithUV(p_147500_2_ + d7, p_147500_4_ + d23, p_147500_6_ + d9, d25, d29);
            tessellator.draw();
            GL11.glEnable(GL11.GL_BLEND);
            OpenGlHelper.glBlendFunc(770, 771, 1, 0);
            GL11.glDepthMask(false);
            tessellator.startDrawingQuads();
            tessellator.setColorRGBA(255, 255, 255, 32);
            double d30 = 0.2D;
            double d4 = 0.2D;
            double d6 = 0.8D;
            double d8 = 0.2D;
            double d10 = 0.2D;
            double d12 = 0.8D;
            double d14 = 0.8D;
            double d16 = 0.8D;
            double d18 = (double) (256.0F);
            double d20 = 0.0D;
            double d22 = 1.0D;
            double d24 = (double) (-1.0F + f3);
            double d26 = (double) (256.0F) + d24;
            tessellator.addVertexWithUV(p_147500_2_ + d30, p_147500_4_ + d18, p_147500_6_ + d4, d22, d26);
            tessellator.addVertexWithUV(p_147500_2_ + d30, p_147500_4_, p_147500_6_ + d4, d22, d24);
            tessellator.addVertexWithUV(p_147500_2_ + d6, p_147500_4_, p_147500_6_ + d8, d20, d24);
            tessellator.addVertexWithUV(p_147500_2_ + d6, p_147500_4_ + d18, p_147500_6_ + d8, d20, d26);
            tessellator.addVertexWithUV(p_147500_2_ + d14, p_147500_4_ + d18, p_147500_6_ + d16, d22, d26);
            tessellator.addVertexWithUV(p_147500_2_ + d14, p_147500_4_, p_147500_6_ + d16, d22, d24);
            tessellator.addVertexWithUV(p_147500_2_ + d10, p_147500_4_, p_147500_6_ + d12, d20, d24);
            tessellator.addVertexWithUV(p_147500_2_ + d10, p_147500_4_ + d18, p_147500_6_ + d12, d20, d26);
            tessellator.addVertexWithUV(p_147500_2_ + d6, p_147500_4_ + d18, p_147500_6_ + d8, d22, d26);
            tessellator.addVertexWithUV(p_147500_2_ + d6, p_147500_4_, p_147500_6_ + d8, d22, d24);
            tessellator.addVertexWithUV(p_147500_2_ + d14, p_147500_4_, p_147500_6_ + d16, d20, d24);
            tessellator.addVertexWithUV(p_147500_2_ + d14, p_147500_4_ + d18, p_147500_6_ + d16, d20, d26);
            tessellator.addVertexWithUV(p_147500_2_ + d10, p_147500_4_ + d18, p_147500_6_ + d12, d22, d26);
            tessellator.addVertexWithUV(p_147500_2_ + d10, p_147500_4_, p_147500_6_ + d12, d22, d24);
            tessellator.addVertexWithUV(p_147500_2_ + d30, p_147500_4_, p_147500_6_ + d4, d20, d24);
            tessellator.addVertexWithUV(p_147500_2_ + d30, p_147500_4_ + d18, p_147500_6_ + d4, d20, d26);
            tessellator.draw();
            GL11.glEnable(GL11.GL_LIGHTING);
            GL11.glEnable(GL11.GL_TEXTURE_2D);
            GL11.glDepthMask(true);
        }
        }

    public void renderTileEntityAt(TileEntity p_147500_1_, double p_147500_2_, double p_147500_4_, double p_147500_6_, float p_147500_8_)
    {
        this.renderTileEntityAt((TileEntityContainmentCornerstone)p_147500_1_, p_147500_2_, p_147500_4_, p_147500_6_, p_147500_8_);
    }

}
