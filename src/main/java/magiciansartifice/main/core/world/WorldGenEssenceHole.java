package magiciansartifice.main.core.world;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenEssenceHole extends WorldGenerator {
	public Block block;
	
	public WorldGenEssenceHole(Block a_block, int number) {
        super(false);
        this.block = a_block;
    }
	
	@Override
	public boolean generate(World world, Random rand, int x, int y, int z) {
		int randomNum = rand.nextInt(11);
		if (randomNum >= 9) { world.setBlock(x, y, z, this.block); }
        return true;
	}
}