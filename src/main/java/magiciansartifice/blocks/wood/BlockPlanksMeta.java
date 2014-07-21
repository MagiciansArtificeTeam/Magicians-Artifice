package magiciansartifice.blocks.wood;

import magiciansartifice.MagiciansArtifice;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * Created by poppypoppop on 22/07/2014.
 */
public class BlockPlanksMeta extends Block {
    public BlockPlanksMeta() {
        super(Material.wood);
        this.setCreativeTab(MagiciansArtifice.tab);
    }
}
