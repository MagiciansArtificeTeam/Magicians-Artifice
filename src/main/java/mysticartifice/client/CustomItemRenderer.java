package mysticartifice.client;

import cpw.mods.fml.client.FMLClientHandler;
import mysticartifice.ModInfo;
import mysticartifice.blocks.BlockRegistry;
import mysticartifice.client.machines.ModelAnvil;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

public class CustomItemRenderer implements IItemRenderer {
    private final ModelAnvil anvil = new ModelAnvil();
    private ResourceLocation anvilTexture = new ResourceLocation(ModInfo.MODID, "textures/blocks/machines/mysticAnvil.png");

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        return true;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return true;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        switch (type) {
            case ENTITY: {
                renderAnvil(0.5F, 15F, -0.5F, 0.09F);
            }
            case EQUIPPED: {
                renderAnvil(2F, 15F, 5F, 0.10F);
            }
            case EQUIPPED_FIRST_PERSON: {
                renderAnvil(1F, 19F, 7F, 0.08F);
            }
            case INVENTORY: {
                renderAnvil(-0.01F, 10F, 0.0F, 0.1F);
            }
            default:
                return;
        }
    }

    private void renderAnvil(float x, float y, float z, float size) {
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(anvilTexture);
        GL11.glPushMatrix(); // start
        GL11.glScalef(size,size,size);
        GL11.glTranslatef(x, y, z); // size
        GL11.glRotatef(180, 1, 0, 0);
        GL11.glRotatef(-90, 0, 1, 0);
        anvil.renderAll();
        GL11.glPopMatrix(); // end
    }
}
