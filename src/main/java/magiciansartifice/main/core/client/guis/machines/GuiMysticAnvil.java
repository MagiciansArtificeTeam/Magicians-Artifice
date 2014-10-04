package magiciansartifice.main.core.client.guis.machines;

import magiciansartifice.main.core.libs.ModInfo;
import magiciansartifice.main.containers.ContainerMysticAnvil;
import magiciansartifice.main.tileentities.machines.TileEntityMysticAnvil;
import magiciansartifice.main.core.utils.TextHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

@SuppressWarnings("unused")
public class GuiMysticAnvil extends GuiContainer
{
    
    public static final ResourceLocation gui = new ResourceLocation(ModInfo.MODID, "textures/guis/mysticAnvilGUI.png");
    private ContainerMysticAnvil container;
    private TileEntityMysticAnvil te;
    
    public GuiMysticAnvil(EntityPlayer player, TileEntityMysticAnvil tile)
    {
        super(new ContainerMysticAnvil(player, tile));
        this.container = (ContainerMysticAnvil) this.inventorySlots;
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
        //this.drawTexturedModalRect(xStart + 96, yStart + 35, 176, 14, i1 + 1, 16);
        this.drawTexturedModalRect(xStart + 81, yStart + 27, 176, 14, i1 + 1, 16);
    }
}
