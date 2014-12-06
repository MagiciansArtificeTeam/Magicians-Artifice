package magiciansartifice.main.blocks.magicblocks;

import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.blocks.BlockRegistry;
import magiciansartifice.main.tileentities.magic.TileEntityPedestal;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by poppypoppop on 6/12/2014.
 */
public class BlockPedestal extends BlockContainer {

    public BlockPedestal() {
        super(Material.rock);
        this.setCreativeTab(MagiciansArtifice.tab);
        this.setBlockName("pedestal");
        this.setBlockBounds(0.07F, 0, 0.07F, 0.93F, 1F, 0.93F);
        BlockRegistry.blocks.add(this);
    }

    public int getRenderType()
    {
        return -1;
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileEntityPedestal();
    }
}
