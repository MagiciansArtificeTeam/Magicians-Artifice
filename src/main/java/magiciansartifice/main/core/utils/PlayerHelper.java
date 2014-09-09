package magiciansartifice.main.core.utils;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class PlayerHelper {

    public static final ArrayList<String> players = new ArrayList<String>();

    public static NBTTagCompound getModPlayerPersistTag(EntityPlayer player, String modName) {

        NBTTagCompound tag = player.getEntityData();

        NBTTagCompound persistTag = null;
        if (tag.hasKey(EntityPlayer.PERSISTED_NBT_TAG)) {
            persistTag = tag.getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG);
        } else {
            persistTag = new NBTTagCompound();
            tag.setTag(EntityPlayer.PERSISTED_NBT_TAG, persistTag);
        }

        NBTTagCompound modTag = null;
        if (persistTag.hasKey(modName)) {
            modTag = persistTag.getCompoundTag(modName);
        } else {
            modTag = new NBTTagCompound();
            persistTag.setTag(modName, modTag);
        }

        return modTag;
    }

    @SuppressWarnings("unchecked")
    public static boolean broadcastSoundToRadius(EntityLivingBase entity, World world, String sound, float volume, float pitch, int radius) {
        if (!world.isRemote) {
            Vec3 entityLoc = Vec3.createVectorHelper(entity.posX, entity.posY, entity.posZ);
            List<EntityPlayerMP> players = world.playerEntities;
            for (EntityPlayerMP playerMP : players) {
                Vec3 playerLoc = Vec3.createVectorHelper(playerMP.posX, playerMP.posY, playerMP.posZ);
                if (entityLoc.distanceTo(playerLoc) <= radius) {
                    if (entity instanceof EntityPlayer) {
                        EntityPlayer player = (EntityPlayer) entity;
                        if (!player.getCommandSenderName().equalsIgnoreCase(playerMP.getCommandSenderName())) {
                            world.playSoundAtEntity(playerMP, sound, volume, pitch);
                            return true;
                        }
                    } else {
                        world.playSoundAtEntity(playerMP, sound, volume, pitch);
                        return true;
                    }
                }
            }
        }
        return false;
    }

}