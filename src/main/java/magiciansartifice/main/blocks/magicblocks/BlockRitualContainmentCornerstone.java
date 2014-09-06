package magiciansartifice.main.blocks.magicblocks;

import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.blocks.BlockRegistry;
import magiciansartifice.main.core.libs.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockRitualContainmentCornerstone extends Block{
	public BlockRitualContainmentCornerstone() {
		super(Material.rock);
		this.setHardness(50.0F);
		this.setResistance(2000.0F);
		this.setCreativeTab(MagiciansArtifice.tab);
		this.setBlockName("ritualContainmentCornerstone");
		this.setBlockTextureName(ModInfo.MODID + ":magicalblocks/ritualContainmentTopTop");
		BlockRegistry.blocks.add(this);
	}
}
