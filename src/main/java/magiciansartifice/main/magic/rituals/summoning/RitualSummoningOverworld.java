package magiciansartifice.main.magic.rituals.summoning;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import magiciansartifice.api.BasicRitual;

public class RitualSummoningOverworld extends BasicRitual {
	public static Random itemRand = new Random();

    public void startRitual(int x, int y, int z, World world, EntityPlayer player) {
        super.startRitual(x,y,z,world,player);
    }
    
    public void initEffect(int x, int y, int z, World world, EntityPlayer player) {
    	//summon the Moonlight Guardian of the Overwold
    }
    
    public boolean areAllBlocksCorrect(int x, int y, int z, World world, EntityPlayer player) {
    	int x1 = x;
    	int y1 = y;
    	int z1 = z;
    	
    	if (player.dimension != 0) return false;
    	return true;
    }
}
