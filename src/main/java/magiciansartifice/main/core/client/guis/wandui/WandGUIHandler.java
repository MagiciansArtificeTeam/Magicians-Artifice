package magiciansartifice.main.core.client.guis.wandui;

import org.lwjgl.opengl.GL11;

import magiciansartifice.main.items.magicalitems.wand.ItemModularWand;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by maxpowa on 8/10/2014.
 */
public class WandGUIHandler extends GuiScreen {

	ResourceLocation wandui = new ResourceLocation("magiciansartifice:textures/guis/wandEssenceUI.png");
	
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void onRenderExperienceBar(RenderGameOverlayEvent event) {
		// Render only after everything else has renderered
		if (event.isCancelable() || event.type != ElementType.ALL) {
			return;
		}

		// Render only if the player is holding a wand
		if (Minecraft.getMinecraft().thePlayer == null || Minecraft.getMinecraft().thePlayer.getHeldItem() == null || !(Minecraft.getMinecraft().thePlayer.getHeldItem().getItem() instanceof ItemModularWand)) {
			return;
		}
		
		// Bind the wand overlay textures to the render engine
		Minecraft.getMinecraft().renderEngine.bindTexture(wandui);
		// Push our GL matrix, so we can safely scale/stretch/etc
		GL11.glPushMatrix();
		// Scale the image 0.5 on both axis, keeping z the same
		GL11.glScalef(0.5f, 0.5f, 1.0f);
		
		// Grab an instance of the held itemstack
		ItemStack stack = Minecraft.getMinecraft().thePlayer.getHeldItem();
		
		// Figure out the capacity
		float cap = 25 * ItemModularWand.getCapacityModifier(stack);
		if (stack.getTagCompound().getInteger("wandLevel") >= 4)
			cap = Integer.MAX_VALUE;
		
		int yOffset = 3;
		if (stack.getTagCompound().hasKey("wandEssence")) {
			this.drawTexturedModalRect(3, yOffset, 0, 0, 64, 22);
			float widthGreen = stack.getTagCompound().getInteger("wandEssence") / cap;
			this.drawTexturedModalRect(3, yOffset, 64, 0, Math.round(66*widthGreen), 21);
			yOffset += 22;
		}
		if (stack.getTagCompound().hasKey("wandEssenceN")) {
			this.drawTexturedModalRect(3, yOffset, 0, 0, 64, 22);
			float widthYellow = stack.getTagCompound().getInteger("wandEssenceN") / cap;
			this.drawTexturedModalRect(3, yOffset, 64, 22, Math.round(66*widthYellow), 21);
			yOffset += 22;
		}
		if (stack.getTagCompound().hasKey("wandEssenceE")) {
			this.drawTexturedModalRect(3, yOffset, 0, 0, 64, 22);
			float widthPurple = stack.getTagCompound().getInteger("wandEssenceE") / cap;
			this.drawTexturedModalRect(3, yOffset, 64, 44, Math.round(66*widthPurple), 21);
		}
		// Pop the matrix to finalize our transforms
		GL11.glPopMatrix();
	}
	
}
