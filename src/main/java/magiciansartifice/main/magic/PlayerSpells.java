package magiciansartifice.main.magic;

import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.core.utils.FlipTableException;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.*;

public class PlayerSpells {

    public static void levitation(EntityPlayer player) {
            if (player.motionY <= -0.3) {
                double newMotion = 0.0D;
                player.moveFlying(0.0F,0.0F,0.0F);
                System.err.println(newMotion);
                player.fallDistance = 0;
            } else {
                MagiciansArtifice.logger.error("Not enough motion!");
            }
    }

    public static void murderSpell(EntityPlayer player, EntityLivingBase entityLivingBase) {
            if (entityLivingBase.attackEntityFrom(DamageSource.magic, 40.0F)) {
                System.err.println("Finished code!");
            } else {
                try {
                    throw new FlipTableException();
                } catch (FlipTableException ex) {
                    ex.printStackTrace();
                }
            }
    }

    public static void broadcastUnforgivableCurse(EntityPlayer player) {
        for (int i = 0; i < player.worldObj.playerEntities.size(); i++) {
            Vec3 playerVec = Vec3.createVectorHelper(player.posX, player.posY, player.posZ);
            Vec3 player2Vec = Vec3.createVectorHelper(((EntityPlayer) player.worldObj.playerEntities.get(i)).posX, ((EntityPlayer) player.worldObj.playerEntities.get(i)).posY, ((EntityPlayer) player.worldObj.playerEntities.get(i)).posZ);
            if (playerVec.distanceTo(player2Vec) <= 100) {
                if (((EntityPlayer) player.worldObj.playerEntities.get(i)).getCommandSenderName() != player.getCommandSenderName()) {
                    ((EntityPlayer) player.worldObj.playerEntities.get(i)).addChatComponentMessage(new ChatComponentTranslation("spell.unforgivable.announce").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.DARK_GRAY)));
                }
            }
        }
    }

    public static void dimensionShift(EntityPlayer player) {
        switch (player.dimension) {
            case 1: player.travelToDimension(0); break;
            case 0: player.setInPortal(); player.travelToDimension(-1); break;
            case -1: player.travelToDimension(1); player.moveEntity(0,10,0); break;
            default: break;
        }
    }

}
