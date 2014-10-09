package magiciansartifice.main.blocks.magicblocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import magiciansartifice.main.blocks.BlockRegistry;
import magiciansartifice.main.core.libs.ModInfo;
import magiciansartifice.main.core.utils.textureutils.MerlinsCircleTextureHelper;
import magiciansartifice.main.tileentities.magic.TileEntityMerlinCircle;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
 * Created by poppypoppop on 8/10/2014.
 */
public class BlockMerlinCircle extends BlockContainer {
    protected IIcon[] icon = new IIcon[122];

    public BlockMerlinCircle() {
        super(Material.rock);
        this.setBlockName("merlincircle");
        this.setBlockTextureName("minecraft:stone");
        BlockRegistry.blocks.add(this);
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(IBlockAccess blockAccess, int x, int y, int z, int side) {
        TileEntityMerlinCircle te = (TileEntityMerlinCircle) blockAccess.getTileEntity(x, y, z);
        System.out.println(te.textureNum++);
        return icon[te.textureNum++];
        //return MerlinsCircleTextureHelper.getBlockTexture(blockAccess, x, y, z, side);
    }

    public void registerBlockIcons(IIconRegister ir) {
        blockIcon = ir.registerIcon("minecraft:stone");
        for (int i = 0; i <= 120; i++) {
            icon[i] = ir.registerIcon(ModInfo.MODID + ":magicalblocks/merlinscircle/active/blueprint_" + (i + 1));
        }
    }

    public IIcon[] getIcons() {
        return icon;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileEntityMerlinCircle();
    }
}
