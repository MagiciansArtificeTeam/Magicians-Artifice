package magiciansartifice.spells;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;

public class PlayerSpells {

    public static void levitation(EntityPlayer player) {
            if (player.motionY <= -0.5) {
                double newMotion = player.motionY / 2;
                player.motionY = newMotion;
                player.fallDistance = 0;
            }
    }

    public static void murderSpell(EntityPlayer player, EntityLivingBase entityLivingBase) {
        entityLivingBase.attackEntityFrom(DamageSource.causeIndirectMagicDamage(player,entityLivingBase),20.0F);
        EntityPlayer player2 = player.worldObj.getClosestVulnerablePlayerToEntity(player,100);
        player2.addChatComponentMessage(new ChatComponentTranslation("spell.unforgivable.announce").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.DARK_GRAY)));
    }

}
