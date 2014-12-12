package magiciansartifice.main.blocks.magicblocks;

import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.core.utils.registries.BlockRegistry;
import magiciansartifice.main.core.libs.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockRitualContainmentTop extends Block {
    public IIcon[] icons = new IIcon[16];

    public BlockRitualContainmentTop() {
        super(Material.rock);
        this.setHardness(40.0F);
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
        icons[6] = ir.registerIcon(ModInfo.MODID + ":containment/pillar/ritualContainmentPillarSide1_2");
        icons[7] = ir.registerIcon(ModInfo.MODID + ":containment/pillar/ritualContainmentPillarSide2_2");
        icons[8] = ir.registerIcon(ModInfo.MODID + ":containment/pillar/ritualContainmentPillarSide3_2");
        icons[9] = ir.registerIcon(ModInfo.MODID + ":containment/pillar/ritualContainmentPillarSide4_2");
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

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(IBlockAccess blockAccess, int x, int y, int z, int side) {

        if( blockAccess.getBlockMetadata(x, y, z) == 15 ) {
            return icons[0];
        }

        final int up = 1;
        final int down = 0;
        final int north = 2;
        final int east = 5;
        final int south = 3;
        final int west = 4;

        boolean bottomConnected;

        if (Block.getIdFromBlock(blockAccess.getBlock(x, y - 1, z)) == Block.getIdFromBlock(this)) {
            bottomConnected = true;
        } else {
            bottomConnected = false;
        }

        if (bottomConnected) {
            switch(side) {
                case up: return icons[1];
                case down: return icons[0];
                case north: return icons[2];
                case south: return icons[3];
                case west: return icons[4];
                case east: return icons[5];
            }
        } else {
            switch(side) {
                case up: return icons[1];
                case down: return icons[0];
                case north: return icons[6];
                case south: return icons[7];
                case west: return icons[8];
                case east: return icons[9];
            }
        }
        return blockIcon;
    }
}