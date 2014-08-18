package magiciansartifice.core.client.guis.machines;

import magiciansartifice.containers.ContainerMetalForge;
import magiciansartifice.core.libs.ModInfo;
import magiciansartifice.tileentities.machines.TileEntityMetalForge;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Millsy on 19/07/14.
 */
public class GuiMetalForge extends GuiContainer
{

    public static final ResourceLocation gui = new ResourceLocation(ModInfo.MODID, "textures/guis/metalForgeGUI.png");
    private ContainerMetalForge container;
    private TileEntityMetalForge te;

    private final List<Info> fluidRects = new ArrayList<Info>();

    public GuiMetalForge(EntityPlayer player, TileEntityMetalForge tile)
    {
        super(new ContainerMetalForge(player, tile));
        this.container = (ContainerMetalForge) this.inventorySlots;
        this.te = tile;
    }

    @Override
    public void initGui()
    {
        super.initGui();
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int x, int y)
    {
        fontRendererObj.drawString(StatCollector.translateToLocal(te.getInventoryName()), xSize - fontRendererObj.getStringWidth(StatCollector.translateToLocal(te.getInventoryName())) - 5, 5, 0xffffff);
        fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 4, 0xffffff);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3)
    {
        GL11.glColor4f(1F, 1F, 1F, 1F);

        Minecraft.getMinecraft().getTextureManager().bindTexture(gui);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

        this.drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

        int burnHeight = te.getScaledBurnTime(13);
        this.drawTexturedModalRect(guiLeft + 8, guiTop + 24 + 14 - burnHeight, 176, 14 - burnHeight, 14, burnHeight + 1);

        int metalWidth = te.getScaledMetalProgress(24);
        this.drawTexturedModalRect(guiLeft + 47, guiTop + 19, 176, 14, metalWidth + 1, 15);

        int carbonWidth = te.getScaledCarbonProgress(24);
        this.drawTexturedModalRect(guiLeft + 47, guiTop + 51, 176, 14, carbonWidth + 1, 15);

        int coolWidth = te.getScaledCoolingProgress(24);
        this.drawTexturedModalRect(guiLeft + 110, guiTop + 34, 176, 14, coolWidth + 1, 15);

        drawFluid();
    }

    @Override
    @SuppressWarnings("unchecked")
    public void drawScreen(int mouseX, int mouseY, float par3)
    {
        super.drawScreen(mouseX, mouseY, par3);
        for (Info i : fluidRects)
        {
            if (i.getRect().contains(mouseX - guiLeft, mouseY - guiTop))
            {
                List text = new ArrayList();
                text.add(StatCollector.translateToLocal(i.getName()));
                text.add(StatCollector.translateToLocalFormatted("fluid.amount", i.getAmount()));
                drawHoveringText(text, mouseX, mouseY, fontRendererObj);
            }
        }
    }

    protected void drawFluid()
    {
        if (te.fluids.entrySet().size() != fluidRects.size() || te.needsFluidUpdate)//1 != fluidRects.size())
        {
            setupRectangles();
            te.needsFluidUpdate = false;
        }
        for (Info i : fluidRects)
        {
            Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(ModInfo.MODID, "textures/fluid/" + i.name + ".png"));
            drawTexturedModalRect(guiLeft + i.rect.x, guiTop + i.rect.y, 0, 0, i.rect.width, i.rect.height);
        }
        Minecraft.getMinecraft().renderEngine.bindTexture(gui);
        drawTexturedModalRect(guiLeft + 74, guiTop + 7, 176, 30, 31, 71);
    }

    protected void setupRectangles()
    {
        int y = 78;
        fluidRects.clear();
        for (Map.Entry<String, Integer> entry : te.fluids.entrySet())
        {
            Info i = new Info(entry.getKey(), entry.getValue(), y);
            y = i.getRect().y;
            fluidRects.add(i);
        }
        //        fluidRects.clear();
        //        Info i1 = new Info("gaseous.coal", 2592, y);
        //        y = i1.getRect().y;
        //        Info i2  = new Info("molten.iron", 1880, y);
        //        fluidRects.add(i2);
        //        fluidRects.add(i1);

    }

    private static class Info
    {
        private String name = "";
        private int amount = 0;
        private Rectangle rect;

        public Info(String name, int amount, int y)
        {
            int height = amount * 65 / TileEntityMetalForge.MAX_LIQUID_MB;
            rect = new Rectangle(75, y - height, 30, height);
            this.amount = amount;
            this.name = name;
        }

        public String getName()
        {
            return name;
        }

        public int getAmount()
        {
            return amount;
        }

        public Rectangle getRect()
        {
            return rect;
        }
    }
}
