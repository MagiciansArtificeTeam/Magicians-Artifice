package magiciansartifice.main.core.client.guis.wandui;

import net.minecraft.client.entity.EntityClientPlayerMP;
import org.lwjgl.opengl.GL11;

import magiciansartifice.main.items.magicalitems.wand.ItemModularWand;
import net.minecraft.client.Minecraft;
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
        if (stack.getTagCompound().getInteger("wandLevel") == -1)
            cap = Integer.MAX_VALUE;

        int yOffset = 3;
        if (stack.getTagCompound().hasKey("wandEssence")) {
            this.drawTexturedModalRect(3, yOffset, 0, 0, 64, 22);
            float widthGreen = stack.getTagCompound().getInteger("wandEssence") / cap;
            this.drawTexturedModalRect(3, yOffset, 64, 0, Math.round(66 * widthGreen), 21);
            yOffset += 22;
        }
        if (stack.getTagCompound().hasKey("wandEssenceN")) {
            this.drawTexturedModalRect(3, yOffset, 0, 22, 64, 22);
            float widthYellow = stack.getTagCompound().getInteger("wandEssenceN") / cap;
            this.drawTexturedModalRect(3, yOffset, 64, 22, Math.round(66 * widthYellow), 21);
            yOffset += 22;
        }
        if (stack.getTagCompound().hasKey("wandEssenceE")) {
            this.drawTexturedModalRect(3, yOffset, 0, 44, 64, 22);
            float widthPurple = stack.getTagCompound().getInteger("wandEssenceE") / cap;
            this.drawTexturedModalRect(3, yOffset, 64, 44, Math.round(66 * widthPurple), 21);
            yOffset += 22;
        }

        /*

            TODO: Y This no work help!

        if (Minecraft.getMinecraft().thePlayer.getEntityData().hasKey("overworldEssence")) {
            this.drawTexturedModalRect(3, yOffset, 0, 0, 64, 22);
            float widthGreen = Minecraft.getMinecraft().thePlayer.getEntityData().getInteger("overworldEssence") / 50;
            this.drawTexturedModalRect(3, yOffset, 64, 0, Math.round(66 * widthGreen), 21);
            yOffset += 22;
        }
        if (Minecraft.getMinecraft().thePlayer.getEntityData().hasKey("netherEssence")) {
            this.drawTexturedModalRect(3, yOffset, 0, 22, 64, 22);
            float widthYellow = Minecraft.getMinecraft().thePlayer.getEntityData().getInteger("netherEssence") / 50;
            this.drawTexturedModalRect(3, yOffset, 64, 22, Math.round(66 * widthYellow), 21);
            yOffset += 22;
        }
        if (Minecraft.getMinecraft().thePlayer.getEntityData().hasKey("enderEssence")) {
            this.drawTexturedModalRect(3, yOffset, 0, 44, 64, 22);
            float widthPurple = Minecraft.getMinecraft().thePlayer.getEntityData().getInteger("enderEssence") / 50;
            this.drawTexturedModalRect(3, yOffset, 64, 44, Math.round(66 * widthPurple), 21);
            yOffset += 22;
        }

        */

        /*
            TODO: Fix the client server de-sync so this will work!

        EntityClientPlayerMP player = Minecraft.getMinecraft().thePlayer;

        Vec3 vec3 = player.getPosition(0);
        if (player.getEyeHeight() != 0.12F) {
            vec3.yCoord += player.getEyeHeight();
        }

        Vec3 vec31 = Minecraft.getMinecraft().thePlayer.getLook(0);

        double distance = Minecraft.getMinecraft().playerController.getBlockReachDistance() - 0.5;

        Vec3 vec32 = vec3.addVector(vec31.xCoord * distance,vec31.yCoord * distance,vec31.zCoord * distance);

        MovingObjectPosition mop = player.worldObj.rayTraceBlocks(vec3, vec32, true);

        if (mop != null) {
        if (player.worldObj.getBlock(mop.blockX,mop.blockY,mop.blockZ) instanceof BlockEssenceHole) {
            if (player.worldObj.getTileEntity(mop.blockX,mop.blockY,mop.blockZ) != null) {
                TileEntityEssenceHole te = (TileEntityEssenceHole) player.worldObj.getTileEntity(mop.blockX, mop.blockY, mop.blockZ);
                Minecraft.getMinecraft().fontRenderer.drawStringWithShadow("Overworld: " + Math.floor(te.getOverworldEssence()/te.getMaxOverworld()),0,yOffset,0x01DF01);
                yOffset += 22;
                Minecraft.getMinecraft().fontRenderer.drawStringWithShadow("Nether: " + Math.floor(te.getNetherEssence()/te.getMaxNether() * 100),0,yOffset,0xFF0000);
                yOffset += 22;
                Minecraft.getMinecraft().fontRenderer.drawStringWithShadow("Ender: " + Math.floor(te.getEnderEssence()/te.getMaxEnder() * 100),0,yOffset,0x8000FF);
            }
        }
        } */

		// Pop the matrix to finalize our transforms
		GL11.glPopMatrix();
	}
	
}
