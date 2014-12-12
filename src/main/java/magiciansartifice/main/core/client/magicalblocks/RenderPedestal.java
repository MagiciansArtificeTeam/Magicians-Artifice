package magiciansartifice.main.core.client.magicalblocks;

import magiciansartifice.main.core.libs.ModInfo;
import magiciansartifice.main.core.utils.EntityHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

/**
 * Created by poppypoppop on 5/10/2014.
 */
public class RenderPedestal extends TileEntitySpecialRenderer {

    private ResourceLocation text = new ResourceLocation(ModInfo.MODID, "textures/blocks/magicalblocks/pedestal.png");
    private final ModelPedestal model = new ModelPedestal();

    public RenderPedestal() {}

    @Override
    public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale) {
        World world = te.getWorldObj();
        GL11.glPushMatrix();
        GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
        Minecraft.getMinecraft().renderEngine.bindTexture(text);
        GL11.glPushMatrix();
        GL11.glRotatef(180F, 90.0F, 0.0F, 90.0F);
        this.model.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }

    public void renderAll() {}
}
