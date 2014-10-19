package magiciansartifice.main.blocks.magicblocks;

import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.blocks.BlockRegistry;
import magiciansartifice.main.core.libs.ModInfo;
import main.flowstoneenergy.core.utils.ConnectedTextureHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

public class BlockRitualContainmentRing extends Block {
	protected IIcon[] icons = new IIcon[16];
	
	public BlockRitualContainmentRing() {
		super(Material.rock);
		this.setHardness(40.0F);
		this.setResistance(2000.0F);
		this.setBlockName("ritual.containment.ring");
		this.setCreativeTab(MagiciansArtifice.tab);
		BlockRegistry.blocks.add(this);
	}
	
	public IIcon getIcon(IBlockAccess blockAccess, int x, int y, int z, int side) {
		return ConnectedTextureHelper.getConnectedBlockTexture(blockAccess, x, y, z, side, icons, this);
	}
	
	public void registerBlockIcons(IIconRegister ir) {
		blockIcon = ir.registerIcon(ModInfo.MODID + ":containment/ring/ritualContainmentRing_0");
        icons[0] = ir.registerIcon(ModInfo.MODID + ":containment/ring/ritualContainmentRing_0");
        icons[1] = ir.registerIcon(ModInfo.MODID + ":containment/ring/ritualContainmentRing_1");
        icons[2] = ir.registerIcon(ModInfo.MODID + ":containment/ring/ritualContainmentRing_2");
        icons[3] = ir.registerIcon(ModInfo.MODID + ":containment/ring/ritualContainmentRing_3");
        icons[4] = ir.registerIcon(ModInfo.MODID + ":containment/ring/ritualContainmentRing_4");
        icons[5] = ir.registerIcon(ModInfo.MODID + ":containment/ring/ritualContainmentRing_5");
        icons[6] = ir.registerIcon(ModInfo.MODID + ":containment/ring/ritualContainmentRing_6");
        icons[7] = ir.registerIcon(ModInfo.MODID + ":containment/ring/ritualContainmentRing_7");
        icons[8] = ir.registerIcon(ModInfo.MODID + ":containment/ring/ritualContainmentRing_8");
        icons[9] = ir.registerIcon(ModInfo.MODID + ":containment/ring/ritualContainmentRing_9");
        icons[10] = ir.registerIcon(ModInfo.MODID + ":containment/ring/ritualContainmentRing_10");
        icons[11] = ir.registerIcon(ModInfo.MODID + ":containment/ring/ritualContainmentRing_11");
        icons[12] = ir.registerIcon(ModInfo.MODID + ":containment/ring/ritualContainmentRing_12");
        icons[13] = ir.registerIcon(ModInfo.MODID + ":containment/ring/ritualContainmentRing_13");
        icons[14] = ir.registerIcon(ModInfo.MODID + ":containment/ring/ritualContainmentRing_14");
        icons[15] = ir.registerIcon(ModInfo.MODID + ":containment/ring/ritualContainmentRing_15");
	}
}