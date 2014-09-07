package magiciansartifice.main.blocks.magicblocks;

import java.util.Random;

import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.blocks.BlockRegistry;
import magiciansartifice.main.core.libs.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockRitualContainmentBarrier extends Block {
	Random rand = new Random();
	public IIcon[] icons = new IIcon[16];
	
	public BlockRitualContainmentBarrier() {
		super(Material.rock);
		this.setBlockUnbreakable();
		this.setBlockName("containmentBarrier");
		this.setCreativeTab(MagiciansArtifice.tab);
        this.setResistance(20000.0F);
		BlockRegistry.blocks.add(this);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister ir)
    {
        icons[0] = ir.registerIcon(ModInfo.MODID + ":magicalblocks/containmentBarrier");
        icons[1] = ir.registerIcon(ModInfo.MODID + ":magicalblocks/containmentBarrier");
        icons[2] = ir.registerIcon(ModInfo.MODID + ":magicalblocks/containmentBarrier");
        icons[3] = ir.registerIcon(ModInfo.MODID + ":magicalblocks/containmentBarrier");
    }
	
	@Override
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        int textureNum = rand.nextInt(3);
        switch (textureNum) {
        case 0: return icons[0];
        case 1: return icons[1];
        case 2: return icons[2];
        case 3: return icons[3];
        }
        return null;
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
