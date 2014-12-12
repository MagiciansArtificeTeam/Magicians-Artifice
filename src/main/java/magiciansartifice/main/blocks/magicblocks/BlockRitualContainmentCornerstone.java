package magiciansartifice.main.blocks.magicblocks;

import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.core.utils.registries.BlockRegistry;
import magiciansartifice.main.core.libs.ModInfo;
import magiciansartifice.main.tileentities.magic.TileEntityContainmentCornerstone;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockRitualContainmentCornerstone extends BlockContainer {
	
	public BlockRitualContainmentCornerstone() {
		super(Material.rock);
		this.getHarvestTool(0);
		this.setHardness(40.0F);
		this.setResistance(2000.0F);
		this.setCreativeTab(MagiciansArtifice.tab);
		this.setBlockName("ritual.containment.cornerstone");
		this.setBlockTextureName(ModInfo.MODID + ":containment/pillar/ritualContainmentTopTop");
		BlockRegistry.blocks.add(this);
	}

    @Override
    public boolean isOpaqueCube() { return false; }

    @Override
    public boolean renderAsNormalBlock() { return false; }

    @Override
	public TileEntity createNewTileEntity(World world, int meta) { return new TileEntityContainmentCornerstone(); }
}