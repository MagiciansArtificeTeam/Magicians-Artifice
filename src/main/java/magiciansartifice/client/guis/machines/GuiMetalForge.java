package magiciansartifice.client.guis.machines;

import magiciansartifice.containers.ContainerMetalForge;
import magiciansartifice.libs.ModInfo;
import magiciansartifice.tileentities.machines.TileEntityMetalForge;
import magiciansartifice.utils.TextHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/**
 * Created by Millsy on 19/07/14.
 */
public class GuiMetalForge extends GuiContainer
{

    public static final ResourceLocation gui = new ResourceLocation(ModInfo.MODID, "textures/guis/metalForgeGUI.png");
    private ContainerMetalForge container;
    private TileEntityMetalForge te;

    public GuiMetalForge(EntityPlayer player, TileEntityMetalForge tile)
    {
        super(new ContainerMetalForge(player, tile));
        this.container = (ContainerMetalForge) this.inventorySlots;
        this.te = tile;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int x, int y)
    {
        fontRendererObj.drawString(TextHelper.localize(te.getInventoryName()), xSize - fontRendererObj.getStringWidth(TextHelper.localize(te.getInventoryName())) - 5, 5, 0xffffff);
        fontRendererObj.drawString(TextHelper.localize("container.inventory"), 8, ySize - 96 + 4, 0xffffff);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3)
    {
        GL11.glColor4f(1F, 1F, 1F, 1F);

        Minecraft.getMinecraft().getTextureManager().bindTexture(gui);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

        int xStart = (width - xSize) / 2;
        int yStart = (height - ySize) / 2;
        this.drawTexturedModalRect(xStart, yStart, 0, 0, xSize, ySize);

        int burnHeight = te.getScaledBurnTime(13);
        this.drawTexturedModalRect(xStart + 8, yStart + 24 + 14 - burnHeight, 176, 14 - burnHeight, 14, burnHeight + 1);

        int metalWidth = te.getScaledMetalProgress(24);
        this.drawTexturedModalRect(xStart + 47, yStart + 19, 176, 14, metalWidth + 1, 15);

        int carbonWidth = te.getScaledCarbonProgress(24);
        this.drawTexturedModalRect(xStart + 47, yStart + 51, 176, 14, carbonWidth + 1, 15);

    }

    protected void drawFluid()
    {

    }
}
