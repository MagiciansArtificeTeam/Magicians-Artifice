package magiciansartifice.main.core.utils.textureutils;

import net.minecraft.block.Block;
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
                Block block = blockAccess.getBlock(x - 5 + j, y, z - 5 + j);
                if (block != null) {
                    if (block == Blocks.grass) {
                        block.colorMultiplier(blockAccess, x, y, z);
                        return block.getIcon(blockAccess, x - 5 + j, y, z - 5 + j, side);
                    } else {
                        return block.getIcon(blockAccess, x - 5 + j, y, z - 5 + j, side);
                    }
                }
            }
        }
        return null;
    }
}
