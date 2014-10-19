package magiciansartifice.main.core.client.guis.machines;

import magiciansartifice.main.containers.ContainerWandCarver;
import magiciansartifice.main.containers.ContainerWandMaker;
import magiciansartifice.main.core.libs.ModInfo;
import magiciansartifice.main.core.utils.TextHelper;
import magiciansartifice.main.tileentities.machines.TileEntityWandCarver;
import magiciansartifice.main.tileentities.machines.TileEntityWandMaker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/**
 * Created by poppypoppop on 21/07/2014.
 */
public class GuiWandMaker extends GuiContainer {
    public static final ResourceLocation gui = new ResourceLocation(ModInfo.MODID, "textures/guis/wandMakerGUI.png");
    @SuppressWarnings("unused")
    private ContainerWandMaker container;
    private TileEntityWandMaker te;

    public GuiWandMaker(EntityPlayer player, TileEntityWandMaker tile) {
        super(new ContainerWandMaker(player, tile));
        this.container = (ContainerWandMaker) this.inventorySlots;
        this.te = tile;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int x, int y) {
        fontRendererObj.drawString(TextHelper.localize("gui.wand.maker"), xSize / 2 - fontRendererObj.getStringWidth(TextHelper.localize("gui.wand.maker")) / 2, 4, 0xffffff);
        fontRendererObj.drawString(TextHelper.localize("container.inventory"), 8, ySize - 96 + 4, 0xffffff);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
        GL11.glColor4f(1F, 1F, 1F, 1F);

        Minecraft.getMinecraft().getTextureManager().bindTexture(gui);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

/*        int xStart = (width - xSize) / 2;
        int yStart = (height - ySize) / 2;
        this.drawTexturedModalRect(xStart, yStart, 0, 0, xSize, ySize);

        int i1 = this.te.getScaledProgress(24);
        this.drawTexturedModalRect(xStart + 82, yStart + 35, 176, 14, i1 + 1, 16); */

    }
}
