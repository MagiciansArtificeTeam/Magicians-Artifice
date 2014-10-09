package magiciansartifice.main.core.utils.textureutils;

import magiciansartifice.main.blocks.magicblocks.BlockMerlinCircle;
import magiciansartifice.main.tileentities.magic.TileEntityMerlinCircle;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

/**
 * Created by poppypoppop on 9/10/2014.
 */
public class MerlinsCircleTextureHelper {
    public static IIcon getBlockTexture(IBlockAccess blockAccess, int x, int y, int z, int side) {
        TileEntityMerlinCircle te = (TileEntityMerlinCircle) blockAccess.getTileEntity(x, y, z);
        IIcon icon = null;
        boolean formed_correctly = true;
        
        if (te != null && side == 1) 
        {
        	int x1 = x;
        	int x2 = x;
        	int z1 = z;
        	int z2 = z;
        	
        	Block block = blockAccess.getBlock(x1, y, z);
        	
        	//Keep going in each of the 4 cardinal directions to figure out how big this thing is
        	
        	do
        	{
        		x1 -= 1;
        		block = blockAccess.getBlock(x1,y,z);
        	} while( block instanceof BlockMerlinCircle );
        	
        	block = blockAccess.getBlock(x2, y, z);
        	
        	do
        	{
        		x2 += 1;
        		block = blockAccess.getBlock(x2,y,z);
        	} while( block instanceof BlockMerlinCircle );
        	
        	block = blockAccess.getBlock(x, y, z1);
        	
        	do 
        	{
        		z1 -= 1;
        		block = blockAccess.getBlock(x,y,z1);
        	} while( block instanceof BlockMerlinCircle );
        	
        	block = blockAccess.getBlock(x, y, z2);
        	
        	do 
        	{
        		z2 += 1;
        		block = blockAccess.getBlock(x,y,z2);
        	}while( block instanceof BlockMerlinCircle );
        	
        	
        	//Fix the off-by-one errors
        	x1++;
        	x2--;
        	z1++;
        	z2--;
        	
        	//Check the size based on the cardinals
        	if( Math.abs( x1-x2 ) != 10 || Math.abs( z1-z2 ) != 10 )
        	{
        		return null;
        	}
        	
        	int x_start = Math.min(x1,x2);
        	int x_end = Math.max( x1, x2 );
        	int z_start = Math.min( z1, z2 );
        	int z_end = Math.max(z1,z2);
        	
        	//Check that each and every block inside it is the correct block
        	for( int x_counter = x_start; x_counter <= x_end; x_counter++ )
        	{
        		for( int z_counter = z_start; z_counter <= z_end; z_counter++ )
            	{       			
        			block = blockAccess.getBlock(x_counter, y, z_counter);
        			
            		if( !(block instanceof BlockMerlinCircle) )
            		{
            			return null;
            		}
            	}
        	}
        	      
        	//Convert from absolute coords to relative to get the row and column numbers
        	int col = 11 - ( x_end - x ) - 2;
        	int row = 11 - ( z_end - z ) - 1;
        	
        	if( formed_correctly )
        	{
        		int texture_id = (row*11)+1+col;
        		
        		if( texture_id < 0 || texture_id >= ((BlockMerlinCircle) block).getIcons().length )
        		{
        			return null;
        		}
        		
        		return ((BlockMerlinCircle) block).getIcons()[texture_id];
            }
        	else
            {
                return Blocks.stonebrick.getIcon(0,0);
        	}
        }
    	return BlockMerlinCircle.trans;
    }
}
