package magiciansartifice.spells;

import net.minecraft.entity.player.EntityPlayer;

public class PlayerSpells {

    public static void levitation(EntityPlayer player) {
        if (player.motionY < -0.5) {
            double newMotion = player.motionY / 2;
            player.motionY = newMotion;
            player.fallDistance = 0;
        }
    }

}
