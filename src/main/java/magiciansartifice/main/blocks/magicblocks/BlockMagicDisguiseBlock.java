package magiciansartifice.main.blocks.magicblocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.blocks.BlockRegistry;
import magiciansartifice.main.core.libs.ModInfo;
import magiciansartifice.main.tileentities.magic.TileEntityDisguiseBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by Mitchellbrine on 2014.
 */
public class BlockMagicDisguiseBlock extends BlockContainer {

    public BlockMagicDisguiseBlock() {
        super(Material.glass);
        this.setHardness(0.5F);
        this.setBlockName("magicianDisguise");
        this.setCreativeTab(MagiciansArtifice.tab);
        BlockRegistry.blocks.add(this);
    }

    @SuppressWarnings("unchecked")
    public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB AABB, List list, Entity entity) {}

    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass() { return 1; }

    public boolean isOpaqueCube() { return false; }

    public boolean renderAsNormalBlock() { return false; }

    public boolean shouldSideBeRendered(IBlockAccess blockAccess, int x, int y, int z, int side) {
        Block b1 = blockAccess.getBlock(x, y, z);
        if (b1 == this || b1 == this) {
            return false;
        }
        return super.shouldSideBeRendered(blockAccess, x, y, z, side);
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(IBlockAccess blockAccess, int x, int y, int z, int side) {
        if (blockAccess.getTileEntity(x,y,z) instanceof TileEntityDisguiseBlock) {
            TileEntityDisguiseBlock te = (TileEntityDisguiseBlock) blockAccess.getTileEntity(x,y,z);
            if (te != null) {
                Block block = te.getBlock();
                if (block != null) {
                    return block.getIcon(side, te.getMetadata());
                }
            }
        }
        return blockIcon;
    }

    public void registerBlockIcons(IIconRegister ir) {
        blockIcon = ir.registerIcon(ModInfo.MODID + ":magicalblocks/magician/disguise");
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        if (player.getCurrentEquippedItem() != null) {
            if (player.getCurrentEquippedItem().getItem() instanceof ItemBlock) {
                if (world.getTileEntity(x,y,z) instanceof TileEntityDisguiseBlock) {
                    TileEntityDisguiseBlock te = (TileEntityDisguiseBlock) world.getTileEntity(x,y,z);
                    if (te != null) {
                        if (!player.isSneaking()) {
                            if (!((ItemBlock) player.getCurrentEquippedItem().getItem()).field_150939_a.hasTileEntity(te.getMetadata())) {
                                te.setBlock(Block.getBlockFromItem(player.getCurrentEquippedItem().getItem()), player.getCurrentEquippedItem().getItemDamage());
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileEntityDisguiseBlock();
    }
}
