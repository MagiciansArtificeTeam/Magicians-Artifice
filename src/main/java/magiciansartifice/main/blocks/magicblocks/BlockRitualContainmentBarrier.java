package magiciansartifice.main.blocks.magicblocks;

import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.blocks.BlockRegistry;
import magiciansartifice.main.core.libs.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockRitualContainmentBarrier extends Block {
	public BlockRitualContainmentBarrier() {
		super(Material.rock);
		this.setBlockUnbreakable();
        this.setResistance(20000.0F);
		this.setBlockName("containmentBarrier");
		this.setCreativeTab(MagiciansArtifice.tab);
		this.setBlockTextureName(ModInfo.MODID + ":magicalblocks/containmentBarrier");
		BlockRegistry.blocks.add(this);
	}
	
	@Override
    public boolean isOpaqueCube() { return false; }

    @Override
    public boolean renderAsNormalBlock() { return false; }
	
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) { return null; }

	@Override
    public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) {
        Block b1 = par1IBlockAccess.getBlock(par2, par3, par4);
        if (b1 == this || b1 == BlockRegistry.containmentBarrier) { return false; }
        return super.shouldSideBeRendered(par1IBlockAccess, par2, par3, par4, par5);
    }
}
