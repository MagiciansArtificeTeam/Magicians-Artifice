package magiciansartifice.main.blocks.misc;

import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.blocks.BlockRegistry;
import magiciansartifice.main.core.libs.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockPotato extends Block {
    public BlockPotato() {
        super(Material.cactus);
        this.setBlockTextureName(ModInfo.MODID + ":misc/potatoBlock");
        this.setBlockName("potatoBlock");
        this.setCreativeTab(MagiciansArtifice.tab);
        BlockRegistry.blocks.add(this);
    }

}
