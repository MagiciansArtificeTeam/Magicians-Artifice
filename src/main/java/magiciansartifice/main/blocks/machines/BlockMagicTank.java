package magiciansartifice.main.blocks.machines;

import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.blocks.BlockRegistry;
import magiciansartifice.main.tileentities.machines.TileEntityMagicTank;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockMagicTank extends BlockContainer {
    public BlockMagicTank() {
        super(Material.iron);
        this.getHarvestTool(0);
        this.setCreativeTab(MagiciansArtifice.tab);
        this.setBlockName("magic.tank");
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
        return new TileEntityMagicTank();
    }
}
