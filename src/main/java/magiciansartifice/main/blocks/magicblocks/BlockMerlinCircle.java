package magiciansartifice.main.blocks.magicblocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import magiciansartifice.main.blocks.BlockRegistry;
import magiciansartifice.main.core.libs.ModInfo;
import magiciansartifice.main.core.proxies.ClientProxy;
import magiciansartifice.main.core.utils.textureutils.MerlinsCircleTextureHelper;
import magiciansartifice.main.tileentities.magic.TileEntityMerlinCircle;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
 * Created by poppypoppop on 8/10/2014.
 */
public class BlockMerlinCircle extends BlockContainer {
    protected IIcon[] icon = new IIcon[122];
    public static IIcon trans = null;

    public BlockMerlinCircle() {
        super(Material.rock);
        this.setBlockName("merlincircle");
        this.setBlockTextureName("minecraft:stone");
        BlockRegistry.blocks.add(this);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getRenderType() {
    	return ClientProxy.merlinsCircleRenderer;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public boolean isOpaqueCube() {
    	return false;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public boolean renderAsNormalBlock() {
    	return false;
	}
    
    @Override
    @SideOnly(Side.CLIENT)
    public boolean canRenderInPass(int pass) {
	    ClientProxy.renderPass = pass;
	    return true; // RENDER IN ALL THE PASSES >.<
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass() {
        return 1;
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(IBlockAccess blockAccess, int x, int y, int z, int side) {
        return MerlinsCircleTextureHelper.getBlockTexture(blockAccess, x, y, z, side);
    }

    public void registerBlockIcons(IIconRegister ir) {
        blockIcon = ir.registerIcon("minecraft:stone");
        for (int i = 0; i <= 120; i++) {
            icon[i] = ir.registerIcon(ModInfo.MODID + ":magicalblocks/merlinscircle/active/blueprint_" + (i + 1));
        }
        trans = ir.registerIcon(ModInfo.MODID + ":magicalblocks/merlinscircle/active/blueprint_trans");
    }

    public IIcon[] getIcons() {
        return icon;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileEntityMerlinCircle();
    }
}
