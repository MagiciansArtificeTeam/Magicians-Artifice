package magiciansartifice.main.core.client.machines;

import magiciansartifice.main.blocks.BlockRegistry;
import magiciansartifice.main.core.libs.ModInfo;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import org.lwjgl.opengl.GL11;

/**
 * Created by Millsy on 18/07/14.
 */
public class RenderPipe extends TileEntitySpecialRenderer {
    private ResourceLocation text = new ResourceLocation(ModInfo.MODID, "textures/blocks/machines/essenceConduit.png");
    private final ModelEssencePipe model = new ModelEssencePipe();

    public RenderPipe() { }

    @Override
    public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
        Minecraft.getMinecraft().renderEngine.bindTexture(text);
        GL11.glPushMatrix();
        GL11.glRotatef(180F, 90.0F, 0.0F, 90.0F);
        //checkSides(te.getWorldObj());
        this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }

    private void checkSides(World world) {
        for (int i = 0; i <= ForgeDirection.VALID_DIRECTIONS.length; i++) {
            switch (i) {
                case 0: {
                    if (!(world.getBlock(ForgeDirection.DOWN.offsetX, ForgeDirection.DOWN.offsetY, ForgeDirection.DOWN.offsetZ) == BlockRegistry.essencePipe)) {
                        if (model.Bottom.isHidden) {
                            model.Bottom.isHidden = false;
                        } else {
                            model.Bottom.isHidden = true;
                        }
                    }
                    break;
                }
                case 1: {
                    if (!(world.getBlock(ForgeDirection.UP.offsetX, ForgeDirection.UP.offsetY, ForgeDirection.UP.offsetZ) == BlockRegistry.essencePipe)) {
                        if (model.Top.isHidden) {
                            model.Top.isHidden = false;
                        } else {
                            model.Top.isHidden = true;
                        }
                    }
                    break;
                }
                case 2: {
                    if (!(world.getBlock(ForgeDirection.NORTH.offsetX, ForgeDirection.NORTH.offsetY, ForgeDirection.NORTH.offsetZ) == BlockRegistry.essencePipe)) {
                        if (model.Front.isHidden) {
                            model.Front.isHidden = false;
                        } else {
                            model.Front.isHidden = true;
                        }
                    }
                    break;
                }
                case 3: {
                    if (!(world.getBlock(ForgeDirection.SOUTH.offsetX, ForgeDirection.SOUTH.offsetY, ForgeDirection.SOUTH.offsetZ) == BlockRegistry.essencePipe)) {
                        if (model.Back.isHidden) {
                            model.Back.isHidden = false;
                        } else {
                            model.Back.isHidden = true;
                        }
                    }
                    break;
                }
                case 4: {
                    if (!(world.getBlock(ForgeDirection.WEST.offsetX, ForgeDirection.WEST.offsetY, ForgeDirection.WEST.offsetZ) == BlockRegistry.essencePipe)) {
                        if (model.Left.isHidden) {
                            model.Left.isHidden = false;
                        } else {
                            model.Left.isHidden = true;
                        }
                    }
                    break;
                }
                case 5: {
                    if (!(world.getBlock(ForgeDirection.EAST.offsetX, ForgeDirection.EAST.offsetY, ForgeDirection.EAST.offsetZ) == BlockRegistry.essencePipe)) {
                        if (model.Right.isHidden) {
                            model.Right.isHidden = false;
                        } else {
                            model.Right.isHidden = true;
                        }
                    }
                    break;
                }
                default:
                    return;
            }
        }
    }

    public void renderAll(){
    }
}
