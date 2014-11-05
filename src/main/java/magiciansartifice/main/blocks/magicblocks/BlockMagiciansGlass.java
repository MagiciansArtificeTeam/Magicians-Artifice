package magiciansartifice.main.blocks.magicblocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.blocks.BlockRegistry;
import magiciansartifice.main.core.libs.ModInfo;
import main.flowstoneenergy.core.utils.FancyConnectedTextureHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by poppypoppop on 4/10/2014.
 */
public class BlockMagiciansGlass extends Block {
    public static final int iconNum = 47;
    protected IIcon[] icons = new IIcon[iconNum];

    public BlockMagiciansGlass() {
        super(Material.glass);
        this.setHardness(0.5F);
        this.setBlockName("magicianGlass");
        this.setCreativeTab(MagiciansArtifice.tab);
        BlockRegistry.blocks.add(this);
    }

    @SuppressWarnings("unchecked")
    public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB AABB, List list, Entity entity) {
        AxisAlignedBB axisalignedbb1 = this.getCollisionBoundingBoxFromPool(world, x, y, z);
        EntityPlayer player = world.getClosestPlayer(x, y, z, 3);

        if (!(entity instanceof EntityPlayer) || (player != null && player.isSneaking())) {
            if (axisalignedbb1 != null && AABB.intersectsWith(axisalignedbb1)) {
                list.add(axisalignedbb1);
            }
        }
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
        blockIcon = ir.registerIcon(ModInfo.MODID + ":magicalblocks/magiciansglass/glass_0");

        for( int i = 0; i < iconNum; i++ ) {
            icons[i] = ir.registerIcon(ModInfo.MODID + ":magicalblocks/magiciansglass/glass_" + i);
        }
    }

    public boolean canPlaceTorchOnTop(World world, int x, int y, int z) { return true; }

    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
        if (entity instanceof EntityPlayer) {
            if (((EntityPlayer) entity).isSneaking()) {
                entity.motionX = 0.0D;
                entity.motionY = 0.0D;
                entity.motionZ = 0.0D;

            } else {
                return;
            }
        } else {
            entity.motionX = 0.0D;
            entity.motionY = 0.0D;
            entity.motionZ = 0.0D;
        }
    }
}
