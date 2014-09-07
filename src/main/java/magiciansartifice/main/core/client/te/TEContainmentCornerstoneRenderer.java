package magiciansartifice.main.core.client.te;

import magiciansartifice.main.blocks.BlockRegistry;
import magiciansartifice.main.core.libs.ModInfo;
import magiciansartifice.main.tileentities.magic.TileEntityContainmentCornerstone;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class TEContainmentCornerstoneRenderer extends TileEntitySpecialRenderer{

    private static final ResourceLocation beaconTexture = new ResourceLocation(ModInfo.MODID + ":textures/blocks/containment/beacon_beam.png");
    private static final ResourceLocation beaconBlankTexture = new ResourceLocation("textures/entity/beacon_beam.png");
    public int barrierRadius = 8;

    public void renderTileEntityAt(TileEntityContainmentCornerstone te, double p_147500_2_, double p_147500_4_, double p_147500_6_, float p_147500_8_)
    {
        GL11.glAlphaFunc(GL11.GL_GREATER, 0.1F);
        if (te != null) {
                int x = te.xCoord;
                int y = te.yCoord;
                int z = te.zCoord;
                EntityPlayer player = te.getWorldObj().getClosestPlayer(x,y,z,30000);
                if (player != null) {
                    if (this.containmentReady(x, y - 8, z, te.getWorldObj(), player)) {
                        Tessellator tessellator = Tessellator.instance;
                        if (te.getFieldActive()) {
                            this.bindTexture(beaconTexture);
                        } else {
                            this.bindTexture(beaconBlankTexture);
                        }
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
        } else {
        }
        }

    public void renderTileEntityAt(TileEntity p_147500_1_, double p_147500_2_, double p_147500_4_, double p_147500_6_, float p_147500_8_)
    {
        this.renderTileEntityAt((TileEntityContainmentCornerstone)p_147500_1_, p_147500_2_, p_147500_4_, p_147500_6_, p_147500_8_);
    }

    private boolean containmentReady(int x, int y, int z, World world, EntityPlayer player) {
        int x1 = x;
        int y1 = y;
        int z1 = z;
        {
            x1 += barrierRadius;
            for (int i = 0; i <= 6; i++) {
                if (world.getBlock(x1, y1 + i, z1) != BlockRegistry.containmentPillar) {
                    return false;
                }
            }
            if (world.getBlock(x1, y1 + 7, z1) != BlockRegistry.containmentTop) {
                return false;
            }
        }
        x1 = x;
        {
            z1 += barrierRadius;
            for (int i = 0; i <= 6; i++) {
                if (world.getBlock(x1, y1 + i, z1) != BlockRegistry.containmentPillar) {
                    return false;
                }
            }
            if (world.getBlock(x1, y1 + 7, z1) != BlockRegistry.containmentTop) {
                return false;
            }
        }
        z1 = z;
        {
            x1 -= barrierRadius;
            for (int i = 0; i <= 6; i++) {
                if (world.getBlock(x1, y1 + i, z1) != BlockRegistry.containmentPillar) {
                    return false;
                }
            }
            if (world.getBlock(x1, y1 + 7, z1) != BlockRegistry.containmentTop) {
                return false;
            }
        }
        x1 = x;
        {
            z1 -= barrierRadius;
            for (int i = 0; i <= 6; i++) {
                if (world.getBlock(x1, y1 + i, z1) != BlockRegistry.containmentPillar) {
                    return false;
                }
            }
            if (world.getBlock(x1, y1 + 7, z1) != BlockRegistry.containmentTop) {
                return false;
            }
        }
        z1 = z;
        {
            x1 += barrierRadius;
            z1 += 1;
            for (int i = 0; i <= 6; i++) {
                if (world.getBlock(x1, y1, z1 + i) != BlockRegistry.containmentRing) {
                    return false;
                }
            }
            if (world.getBlock(x1, y1, z1 + 7) != BlockRegistry.containmentTop) {
                return false;
            }
            for (int i = 1; i <= 6; i++) {
                if (world.getBlock(x1 - i, y1, z1 + 7) != BlockRegistry.containmentRing) {
                    return false;
                }
            }
        }
        x1 = x;
        z1 = z;
        {
            z1 += barrierRadius;
            x1 += 1;
            for (int i = 0; i <= 6; i++) {
                if (world.getBlock(x1 + i, y1, z1) != BlockRegistry.containmentRing) {
                    return false;
                }
            }
            if (world.getBlock(x1 + 7, y1, z1) != BlockRegistry.containmentTop) {
                return false;
            }
            for (int i = 1; i <= 6; i++) {
                if (world.getBlock(x1 + 7, y1, z1 - i) != BlockRegistry.containmentRing) {
                    return false;
                }
            }
        }
        x1 = x;
        z1 = z;
        {
            x1 -= barrierRadius;
            z1 -= 1;
            for (int i = 0; i <= 6; i++) {
                if (world.getBlock(x1, y1, z1 - i) != BlockRegistry.containmentRing) {
                    return false;
                }
            }
            if (world.getBlock(x1, y1, z1 - 7) != BlockRegistry.containmentTop) {
                return false;
            }
            for (int i = 1; i <= 6; i++) {
                if (world.getBlock(x1 + i, y1, z1 - 7) != BlockRegistry.containmentRing) {
                    return false;
                }
            }
        }
        x1 = x;
        z1 = z;
        {
            z1 -= barrierRadius;
            x1 -= 1;
            for (int i = 0; i <= 6; i++) {
                if (world.getBlock(x1 - i, y1, z1) != BlockRegistry.containmentRing) {
                    return false;
                }
            }
            if (world.getBlock(x1 - 7, y1, z1) != BlockRegistry.containmentTop) {
                return false;
            }
            for (int i = 1; i <= 6; i++) {
                if (world.getBlock(x1 - 7, y1, z1 + i) != BlockRegistry.containmentRing) {
                    return false;
                }
            }
        }
        if (world.getBlock(x, y + 8, z) != BlockRegistry.containmentCornerstone) {
            return false;
        }
        return true;
    }
}
