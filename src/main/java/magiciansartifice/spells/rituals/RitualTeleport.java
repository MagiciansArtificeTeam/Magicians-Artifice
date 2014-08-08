package magiciansartifice.spells.rituals;

import magiciansartifice.api.BasicRitual;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/**
 * Created by poppypoppop on 8/08/2014.
 */
public class RitualTeleport extends BasicRitual {
    public void startRitual(int x, int y, int z, World world, EntityPlayer player) { super.startRitual(x, y, z, world, player); }

    public boolean areAllBlocksCorrect(int x, int y, int z, World world, EntityPlayer player) {
        return false;
    }
}
