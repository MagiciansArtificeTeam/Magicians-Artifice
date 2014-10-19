package magiciansartifice.main.core.utils;

import net.minecraft.block.Block;
import net.minecraft.world.World;

/**
 * Created by poppypoppop on 9/10/2014.
 */
public class BlockHelper {

    public static int getMeta(World world, int x, int y, int z) {
        return world.getBlockMetadata(x, y, z);
    }

    public static Block getBlock(World world, int x, int y, int z) {
        return world.getBlock(x, y, z);
    }
}
