package magiciansartifice.main.blocks.ruins;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.core.libs.ModInfo;
import magiciansartifice.main.core.utils.registries.BlockRegistry;
import main.flowstoneenergy.core.utils.FancyConnectedTextureHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

/**
 * Created by poppypoppop on 12/12/2014.
 */
public class BlockRuneGlass extends Block {
    public static final int iconNum = 47;
    protected IIcon[] icons = new IIcon[iconNum];

    public BlockRuneGlass() {
        super(Material.glass);
        this.setHardness(0.5F);
        this.setBlockName("runeGlass");
        this.setCreativeTab(MagiciansArtifice.tab);
        BlockRegistry.blocks.add(this);
    }

    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass() { return 1; }

    public boolean isOpaqueCube() { return false; }

    public boolean renderAsNormalBlock() { return false; }

    public boolean shouldSideBeRendered(IBlockAccess blockAccess, int x, int y, int z, int side) {
        Block b1 = blockAccess.getBlock(x, y, z);
        if (b1 == this || b1 == BlockRegistry.magicianGlass) {
            return false;
        }
        return super.shouldSideBeRendered(blockAccess, x, y, z, side);
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(IBlockAccess blockAccess, int x, int y, int z, int side) {
        return blockAccess.getBlockMetadata(x, y, z) == 15 ? icons[0] : FancyConnectedTextureHelper.getConnectedBlockTexture(blockAccess, x, y, z, side, icons, this);
    }

    public void registerBlockIcons(IIconRegister ir) {
        blockIcon = ir.registerIcon(ModInfo.MODID + ":ruins/rune_glass_0");

        for( int i = 0; i < iconNum; i++ ) {
            icons[i] = ir.registerIcon(ModInfo.MODID + ":ruins/rune_glass_" + i);
        }
    }
}
