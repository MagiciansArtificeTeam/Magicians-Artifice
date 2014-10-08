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
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (side == 1) {
                    return BlockMerlinCircle.icon[i];
                } else {
                    return Blocks.stonebrick.getIcon(blockAccess, x, y, z, side);
                }
            }
        }
        return null;
    }
}
