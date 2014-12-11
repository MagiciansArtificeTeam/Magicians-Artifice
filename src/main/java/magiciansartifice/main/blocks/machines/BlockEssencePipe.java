package magiciansartifice.main.blocks.machines;

import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.tileentities.machines.TileEntityEssencePipe;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by poppypoppop on 14/10/2014.
 */
public class BlockEssencePipe extends BlockContainer {
    public BlockEssencePipe() {
        super(Material.iron);
        this.setBlockName("essenceConduit");
        this.setCreativeTab(MagiciansArtifice.tab);
        //BlockRegistry.blocks.add(this);
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

    public TileEntity createNewTileEntity(World world, int meta) { return new TileEntityEssencePipe(); }
}
