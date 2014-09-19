package magiciansartifice.main.core.world.village;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureVillagePieces;

public class ComponentMageTower extends StructureVillagePieces.Church 
{
    public ComponentMageTower() {
    }

    public void setBlock(World world, int x, int y, int z, Block block, int metadata)
    {
        Block b1 = world.getBlock(x, y, z);

        if(b1.isAir(world, x, y, z) || b1.isLeaves(world, x, y, z))
        {
            world.setBlock(x, y, z, block, metadata, 2);
        }
    }

    @Override
	public boolean addComponentParts(World world, Random random, StructureBoundingBox structBoundingBox) {
    	
        return true;
    }
}