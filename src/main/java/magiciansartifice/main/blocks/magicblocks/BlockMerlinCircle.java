package magiciansartifice.main.blocks.magicblocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import magiciansartifice.main.blocks.BlockRegistry;
import magiciansartifice.main.core.utils.textureutils.MerlinsCircleTextureHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
 * Created by poppypoppop on 8/10/2014.
 */
public class BlockMerlinCircle extends Block {
    public IIcon icon;

    public BlockMerlinCircle() {
        super(Material.rock);
        this.setBlockName("merlincircle");
        this.setBlockTextureName("minecraft:stone");
        BlockRegistry.blocks.add(this);
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(IBlockAccess blockAccess, int x, int y, int z, int side) {
        return MerlinsCircleTextureHelper.getBlockTexture(blockAccess, x, y, z, side);
    }

    public void registerIcon(IIconRegister ir) {

    }
}
