package magiciansartifice.main.blocks.magicblocks;

import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.blocks.BlockRegistry;
import magiciansartifice.main.core.libs.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockRitualContainmentTop extends Block {
	public IIcon[] icons = new IIcon[16];
	
	public BlockRitualContainmentTop() {
		super(Material.rock);
		this.setHardness(50.0F);
		this.setResistance(2000.0F);
		this.setBlockName("ritual.containment.top");
		this.setCreativeTab(MagiciansArtifice.tab);
		BlockRegistry.blocks.add(this);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister ir) {
		icons[0] = ir.registerIcon(ModInfo.MODID + ":containment/pillar/ritualContainmentPillarBottom");
		icons[1] = ir.registerIcon(ModInfo.MODID + ":containment/pillar/ritualContainmentTopTop");
		icons[2] = ir.registerIcon(ModInfo.MODID + ":containment/pillar/ritualContainmentPillarSide1_0");
		icons[3] = ir.registerIcon(ModInfo.MODID + ":containment/pillar/ritualContainmentPillarSide1_0");
		icons[4] = ir.registerIcon(ModInfo.MODID + ":containment/pillar/ritualContainmentPillarSide3_0");
		icons[5] = ir.registerIcon(ModInfo.MODID + ":containment/pillar/ritualContainmentPillarSide4_0");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        switch(side) {
        case 0: return icons[0];
        case 1: return icons[1];
        case 2: return icons[2];
        case 3: return icons[3];
        case 4: return icons[4];
        case 5: return icons[5];
        }
        return blockIcon;
    }
}
