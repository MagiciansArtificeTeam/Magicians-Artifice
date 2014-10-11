package magiciansartifice.main.blocks.machines;

import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.blocks.BlockRegistry;
import magiciansartifice.main.tileentities.machines.TileEntityWandMaker;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by poppypoppop on 11/10/2014.
 */
public class BlockWandMaker extends BlockContainer {
    public BlockWandMaker() {
        super(Material.rock);
        this.setBlockName("wandmaker");
        this.setCreativeTab(MagiciansArtifice.tab);
        this.setBlockBounds(0F, 0F, 0F, 1F, 1.4F, 1F);
        BlockRegistry.blocks.add(this);
    }

    @Override
    public int getRenderType()
    {
        return -1;
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileEntityWandMaker();
    }
}
