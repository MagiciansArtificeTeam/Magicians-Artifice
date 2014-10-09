package magiciansartifice.main.core.utils.textureutils;

import magiciansartifice.main.blocks.magicblocks.BlockMerlinCircle;
import magiciansartifice.main.tileentities.magic.TileEntityMerlinCircle;
import net.minecraft.block.Block;
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
            for (int i = 0; i < 11; i++) {
                for (int j = 0; j < 11; j++) {
                    Block block = blockAccess.getBlock(x - 4 + i, y, z - 4 + j);
                    if (block instanceof BlockMerlinCircle) {
                        if (side == 1) {
                            if (j != 0 && i != 0) {
                                icon = ((BlockMerlinCircle) block).getIcons()[te.textureNum + j * i];
                            } else {
                                icon = ((BlockMerlinCircle) block).getIcons()[te.textureNum + j + i];
                            }
                        } else {
                            icon = Blocks.stonebrick.getIcon(blockAccess, x, y, z, side);
                        }
                    }
                }
            }
        }
        return icon;
    }
}
