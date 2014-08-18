package magiciansartifice.blocks.magicblocks;

import magiciansartifice.blocks.BlockRegistry;
import magiciansartifice.core.libs.ModInfo;
import magiciansartifice.tileentities.magic.TileEntityEssenceHole;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockEssenceHole extends BlockContainer{

    public BlockEssenceHole() {
        super(Material.glass);
        this.setResistance(2000.0F);
        this.setHardness(5.0F);
        this.setBlockName("essenceHole");
        this.setBlockTextureName(ModInfo.MODID + ":magicalblocks/essenceHole");
        BlockRegistry.blocks.add(this);
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileEntityEssenceHole();
    }

    @Override
    public TileEntity createTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileEntityEssenceHole();
    }
}
