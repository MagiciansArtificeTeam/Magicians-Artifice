package magiciansartifice.main.magic.essence;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import magiciansartifice.api.events.EssencePayEvent;
import magiciansartifice.main.core.network.PacketHandler;
import magiciansartifice.main.core.network.packet.EssencePacket;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.event.entity.living.LivingEvent;

import java.util.Random;

/**
 * Created by Mitchellbrine on 2014.
 */
public class EssenceNetworkEvents {

    @SubscribeEvent
    public void createNetwork(LivingEvent.LivingUpdateEvent event) {
        if (event.entityLiving instanceof EntityPlayer) {
            if (!event.entityLiving.getEntityData().hasKey("overworldEssence") || !event.entityLiving.getEntityData().hasKey("netherEssence") || !event.entityLiving.getEntityData().hasKey("enderEssence")) {
                if (!event.entityLiving.getEntityData().hasKey("maxOverworld")) {
                    event.entityLiving.getEntityData().setInteger("maxOverworld", 50);
                    event.entityLiving.getEntityData().setInteger("overworldEssence", 50);
                }
            if (!event.entityLiving.getEntityData().hasKey("maxNether")) {
                event.entityLiving.getEntityData().setInteger("maxNether", 50);
                event.entityLiving.getEntityData().setInteger("netherEssence", 50);
            }
            if (!event.entityLiving.getEntityData().hasKey("maxEnder")) {
                event.entityLiving.getEntityData().setInteger("maxEnder", 50);
                event.entityLiving.getEntityData().setInteger("enderEssence", 50);
            }
                if (event.entityLiving instanceof EntityPlayerMP) {
                    PacketHandler.INSTANCE.sendTo(new EssencePacket(event.entityLiving.getEntityData().getInteger("overworldEssence"),event.entityLiving.getEntityData().getInteger("netherEssence"),event.entityLiving.getEntityData().getInteger("enderEssence")),(EntityPlayerMP)event.entityLiving);
                }
            }

            Random random = new Random(((EntityPlayer) event.entityLiving).worldObj.getWorldTime());

            if (random.nextInt(100) == 0) {
                if (event.entityLiving.getEntityData().hasKey("overworldEssence") && event.entityLiving.getEntityData().hasKey("netherEssence") && event.entityLiving.getEntityData().hasKey("enderEssence")) {

                        int newOverworld = event.entityLiving.getEntityData().getInteger("overworldEssence") + 1;
                        if (!(newOverworld > event.entityLiving.getEntityData().getInteger("maxOverworld"))) {
                            event.entityLiving.getEntityData().setInteger("overworldEssence",newOverworld);
                        }
                        int newNether = event.entityLiving.getEntityData().getInteger("netherEssence") + 1;
                        if (!(newNether > event.entityLiving.getEntityData().getInteger("maxNether"))) {
                            event.entityLiving.getEntityData().setInteger("netherEssence",newNether);
                        }
                        int newEnder = event.entityLiving.getEntityData().getInteger("enderEssence") + 1;
                        if (!(newEnder > event.entityLiving.getEntityData().getInteger("maxEnder"))) {
                            event.entityLiving.getEntityData().setInteger("enderEssence",newEnder);
                        }
                        if (event.entityLiving instanceof EntityPlayerMP) {
                            PacketHandler.INSTANCE.sendTo(new EssencePacket(event.entityLiving.getEntityData().getInteger("overworldEssence"),event.entityLiving.getEntityData().getInteger("netherEssence"),event.entityLiving.getEntityData().getInteger("enderEssence")),(EntityPlayerMP)event.entityLiving);
                        }
                }
            }

        }
    }

    @SubscribeEvent
    public void spellEvent(EssencePayEvent event) {
        if (event.entityPlayer.getCurrentEquippedItem().stackTagCompound.hasKey("wandEssence")) {
            if (event.entityPlayer.getCurrentEquippedItem().stackTagCompound.getInteger("wandEssence") < event.overworldSpent) {
                if (event.entityPlayer.getEntityData().hasKey("overworldEssence") && event.entityPlayer.getEntityData().getInteger("overworldEssence") >= (event.overworldSpent - event.entityPlayer.getCurrentEquippedItem().stackTagCompound.getInteger("wandEssence"))) {
                    int remainingEssence = event.overworldSpent - event.entityPlayer.getCurrentEquippedItem().stackTagCompound.getInteger("wandEssence");
                    event.overworldSpent = event.entityPlayer.getCurrentEquippedItem().stackTagCompound.getInteger("wandEssence");
                    event.entityPlayer.getEntityData().setInteger("overworldEssence",event.entityPlayer.getEntityData().getInteger("overworldEssence")-remainingEssence);
                    /*if (!event.entityPlayer.worldObj.isRemote)
                        event.entityPlayer.addChatComponentMessage(new ChatComponentTranslation("essence.network.overworld",event.entityPlayer.getEntityData().getInteger("overworldEssence")).setChatStyle(new ChatStyle().setColor(EnumChatFormatting.GREEN))); */
                }
            }
        }

        if (event.entityPlayer.getCurrentEquippedItem().stackTagCompound.hasKey("wandEssenceN")) {
            if (event.entityPlayer.getCurrentEquippedItem().stackTagCompound.getInteger("wandEssenceN") < event.overworldSpent) {
                if (event.entityPlayer.getEntityData().hasKey("netherEssence") && event.entityPlayer.getEntityData().getInteger("netherEssence") >= (event.overworldSpent - event.entityPlayer.getCurrentEquippedItem().stackTagCompound.getInteger("wandEssenceN"))) {
                    int remainingEssenceE = event.overworldSpent - event.entityPlayer.getCurrentEquippedItem().stackTagCompound.getInteger("wandEssenceN");
                    event.netherSpent = event.entityPlayer.getCurrentEquippedItem().stackTagCompound.getInteger("wandEssenceN");
                    event.entityPlayer.getEntityData().setInteger("netherEssence",event.entityPlayer.getEntityData().getInteger("netherEssence")-remainingEssenceE);
                    /*if (!event.entityPlayer.worldObj.isRemote)
                        event.entityPlayer.addChatComponentMessage(new ChatComponentTranslation("essence.network.nether",event.entityPlayer.getEntityData().getInteger("netherEssence")).setChatStyle(new ChatStyle().setColor(EnumChatFormatting.RED))); */
                }
            }
        }

        if (event.entityPlayer.getCurrentEquippedItem().stackTagCompound.hasKey("wandEssenceE")) {
            if (event.entityPlayer.getCurrentEquippedItem().stackTagCompound.getInteger("wandEssenceE") < event.overworldSpent) {
                if (event.entityPlayer.getEntityData().hasKey("enderEssence") && event.entityPlayer.getEntityData().getInteger("enderEssence") >= (event.overworldSpent - event.entityPlayer.getCurrentEquippedItem().stackTagCompound.getInteger("wandEssenceE"))) {
                    int remainingEssenceE = event.overworldSpent - event.entityPlayer.getCurrentEquippedItem().stackTagCompound.getInteger("wandEssenceE");
                    event.enderSpent = event.entityPlayer.getCurrentEquippedItem().stackTagCompound.getInteger("wandEssenceE");
                    event.entityPlayer.getEntityData().setInteger("enderEssence", event.entityPlayer.getEntityData().getInteger("enderEssence") - remainingEssenceE);
                    /*if (!event.entityPlayer.worldObj.isRemote)
                    event.entityPlayer.addChatComponentMessage(new ChatComponentTranslation("essence.network.ender",event.entityPlayer.getEntityData().getInteger("enderEssence")).setChatStyle(new ChatStyle().setColor(EnumChatFormatting.LIGHT_PURPLE)));*/
                }
            }
        }

        if (event.entityPlayer.getEntityData().hasKey("overworldEssence") && event.entityPlayer.getEntityData().hasKey("netherEssence") && event.entityPlayer.getEntityData().hasKey("enderEssence")) {
            if (event.entityPlayer instanceof EntityPlayerMP) {
                PacketHandler.INSTANCE.sendTo(new EssencePacket(event.entityPlayer.getEntityData().getInteger("overworldEssence"),event.entityPlayer.getEntityData().getInteger("netherEssence"),event.entityPlayer.getEntityData().getInteger("enderEssence")),(EntityPlayerMP)event.entityPlayer);
            }
        }


    }

}
