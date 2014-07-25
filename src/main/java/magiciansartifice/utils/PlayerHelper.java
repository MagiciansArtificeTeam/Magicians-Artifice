package magiciansartifice.utils;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

import java.util.ArrayList;

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
}