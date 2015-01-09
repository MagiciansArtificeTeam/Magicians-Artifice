package magiciansartifice.main.core.world;

import java.util.ArrayList;
import java.util.Random;

import magiciansartifice.api.utils.Arrays;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.oredict.OreDictionary;

public class WorldGenEssenceHole extends WorldGenerator {
	public Block block;
	
	public WorldGenEssenceHole(Block a_block, int number) {
        super(false);
        this.block = a_block;
        Arrays.addBlacklistBlocks();
    }
	
	@Override
	public boolean generate(World world, Random rand, int x, int y, int z) {
		int randomNum = rand.nextInt(11);
		if (randomNum >= 9 && canPlaceHere(world, x, y, z)) {
			world.setBlock(x, y, z, this.block);
		}
		return true;
	}

	private boolean canPlaceHere(World world, int x, int y, int z) {	
    	// cannot place above water or leaves
        for (Item item : Arrays.blockBlackList) {
        	final Block block = world.getBlock(x, y - 1, z);
            if (block == null || Item.getItemFromBlock(block) == item) return false;
        }
        
        // blacklist radius (horizontal and vertical)
        final int _h = 1, _v = 3;	// this will ensure an area of 3x7x3
        try {
        	// let's only do the TE check if the block itself is not air
    		if( !world.isAirBlock(x, y, z) && world.getTileEntity(x,y,z) != null )
    			return false;
    		
    		// now we can scan in a reasonable cube for other essence holes
    		// since I'm assuming this is what you meant to do
    		for( int i = -_h; i < _h*2; ++i ) {
    			for( int j = -_v; j < _v*2; ++j ) {
    				for( int k = -_h; k < _h*2; ++k ) {
    					final Block block = world.getBlock(x+i, y+j, z+k);
    					if( block == this.block )
    						return false;
    				}
    			}
    		}
    		
        } catch( NullPointerException npe ) {
        	// if this explodes, let's err on the side of not trying to set a block
        	return false;
        }
        
        return true;
    }
}