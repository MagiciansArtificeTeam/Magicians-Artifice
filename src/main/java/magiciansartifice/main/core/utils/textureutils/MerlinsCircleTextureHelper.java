package magiciansartifice.main.core.utils.textureutils;

import magiciansartifice.main.blocks.magicblocks.BlockMerlinCircle;
import magiciansartifice.main.tileentities.magic.TileEntityMerlinCircle;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

/**
 * Created by poppypoppop on 9/10/2014.
 */
public class MerlinsCircleTextureHelper {
    public static IIcon getBlockTexture(IBlockAccess blockAccess, int x, int y, int z, int side) {
        TileEntityMerlinCircle te = (TileEntityMerlinCircle) blockAccess.getTileEntity(x, y, z);
        IIcon icon = null;
        if (te != null) {
            if (blockAccess.getBlock(x, y, z) instanceof BlockMerlinCircle) {
                for (int i = 0; i < 121; i++) {
                    if (side == 1) {
                        if (!(i > 120)) {
                            icon = ((BlockMerlinCircle) blockAccess.getBlock(x, y, z)).getIcons()[te.textureNum + i];
                        }
                    } else {
                        icon = Blocks.stonebrick.getIcon(blockAccess, x, y, z, side);
                    }
                }
            }
        }
        return icon;
    }
}
