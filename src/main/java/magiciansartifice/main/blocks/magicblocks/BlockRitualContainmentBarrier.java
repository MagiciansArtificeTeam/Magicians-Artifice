package magiciansartifice.main.blocks.magicblocks;

import java.util.Random;

import magiciansartifice.main.blocks.BlockRegistry;
import magiciansartifice.main.core.libs.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
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
		this.setBlockName("ritual.containment.barrier");
        this.setResistance(20000.0F);
		BlockRegistry.blocks.add(this);
	}
	
	@Override
	public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
		super.randomDisplayTick(world, x, y, z, rand);
	    if (rand.nextInt(2) == 0) {
	      	world.spawnParticle("enchantmenttable", x + rand.nextFloat(), y + 1.1F, z + rand.nextFloat(), 0.0D, 0.0D, 0.0D);
	    }
	}
	
	@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) { return null; }
	
	@Override
	@SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister ir) { 
		for (int i = 0; i <= 3; i++) { 
			icons[i] = ir.registerIcon(ModInfo.MODID + ":containment/containmentBarrier" + i); 
		} 
	}
	
	@Override
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        int textureNum = rand.nextInt(3);
        return icons[textureNum];
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
