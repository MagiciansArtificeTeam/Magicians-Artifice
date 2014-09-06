package magiciansartifice.main.blocks.magicblocks;

import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.blocks.BlockRegistry;
import magiciansartifice.main.core.libs.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockRitualContainmentRing extends Block {
	public BlockRitualContainmentRing() {
		super(Material.rock);
		this.setHardness(50.0F);
		this.setResistance(2000.0F);
		this.setBlockName("ritualContainmentRing");
		this.setCreativeTab(MagiciansArtifice.tab);
		this.setBlockTextureName(ModInfo.MODID + ":magicalblocks/ritualContainmentPillarBottom");
		BlockRegistry.blocks.add(this);
	}
}
