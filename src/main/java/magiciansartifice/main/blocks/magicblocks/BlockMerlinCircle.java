package magiciansartifice.main.blocks.magicblocks;

import magiciansartifice.main.blocks.BlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * Created by poppypoppop on 8/10/2014.
 */
public class BlockMerlinCircle extends Block {
    public BlockMerlinCircle() {
        super(Material.rock);
        this.setBlockName("merlincircle");
        this.setBlockTextureName("minecraft:stone");
        BlockRegistry.blocks.add(this);
    }
}
