package magiciansartifice.main.blocks.ruins;

import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.core.utils.registries.BlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;

/**
 * Created by poppypoppop on 11/12/2014.
 */
public class BlockRuinStairs extends BlockStairs {
    public BlockRuinStairs(Block block, int num, String name) {
        super(block, num);
        this.setHardness(1.5F);
        this.setBlockName("ruinStairs." + name);
        this.setCreativeTab(MagiciansArtifice.tab);
        this.useNeighborBrightness = true;
        BlockRegistry.blocks.add(this);
    }
}
