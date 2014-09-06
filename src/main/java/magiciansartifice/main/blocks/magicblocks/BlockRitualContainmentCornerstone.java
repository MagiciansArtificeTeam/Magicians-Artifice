package magiciansartifice.main.blocks.magicblocks;

import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.blocks.BlockRegistry;
import magiciansartifice.main.core.libs.ModInfo;
import magiciansartifice.main.tileentities.magic.TileEntityContainmentCornerstone;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockRitualContainmentCornerstone extends BlockContainer {
	
	public BlockRitualContainmentCornerstone() {
		super(Material.rock);
		this.getHarvestTool(0);
		this.setHardness(50.0F);
		this.setResistance(2000.0F);
		this.setCreativeTab(MagiciansArtifice.tab);
		this.setBlockName("ritualContainmentCornerstone");
		this.setBlockTextureName(ModInfo.MODID + ":magicalblocks/ritualContainmentTopTop");
		BlockRegistry.blocks.add(this);
	}

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float hitX, float hitY, float hitZ) {
    	TileEntityContainmentCornerstone te = (TileEntityContainmentCornerstone) world.getTileEntity(x, y, z);
    	te.createField(world, player, x, y, z);
        return true;
    }

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntityContainmentCornerstone();
	}
}