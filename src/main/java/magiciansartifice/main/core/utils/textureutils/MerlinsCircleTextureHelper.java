package magiciansartifice.main.core.utils.textureutils;

import magiciansartifice.main.blocks.magicblocks.BlockMerlinCircle;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

/**
 * Created by poppypoppop on 9/10/2014.
 */
public class MerlinsCircleTextureHelper {
    public static IIcon getBlockTexture(IBlockAccess blockAccess, int x, int y, int z, int side) {
        IIcon icon = null;
        if (blockAccess.getBlock(x,y,z) instanceof BlockMerlinCircle) {
            for (int i = 0; i < 121; i++) {
                if (side == 1) {
                    icon = ((BlockMerlinCircle) blockAccess.getBlock(x,y,z)).getIcons()[i];
                } else {
                    icon = Blocks.stonebrick.getIcon(blockAccess, x, y, z, side);
                }
            }
        }
        return icon;
    }
}
