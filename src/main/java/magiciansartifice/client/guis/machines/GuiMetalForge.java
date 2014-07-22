package magiciansartifice.client.guis.machines;

import magiciansartifice.containers.ContainerMetalForge;
import magiciansartifice.containers.ContainerMysticAnvil;
import magiciansartifice.libs.ModInfo;
import magiciansartifice.tileentities.machines.TileEntityMysticAnvil;
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

    public static final ResourceLocation gui = new ResourceLocation(ModInfo.MODID, "textures/guis/mysticAnvilGUI.png");
    private ContainerMetalForge container;
    private TileEntityMysticAnvil te;

    public GuiMetalForge(EntityPlayer player, TileEntityMysticAnvil tile)
    {
        super(new ContainerMysticAnvil(player, tile));
        this.container = (ContainerMetalForge) this.inventorySlots;
        this.te = tile;
    }
    
    @Override
    protected void drawGuiContainerForegroundLayer(int x, int y)
    {
        fontRendererObj.drawString(TextHelper.localize("gui.mystic.anvil"), xSize / 2 - fontRendererObj.getStringWidth(TextHelper.localize("gui.mystic.anvil")) / 2, 2, 0xffffff);
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
        
        int i1 = this.te.getScaledProgress(24);
        this.drawTexturedModalRect(xStart + 96, yStart + 35, 176, 14, i1 + 1, 16);
        
    }
}
