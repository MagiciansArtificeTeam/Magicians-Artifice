package mysticartifice.blocks.machines;

import mysticartifice.ModInfo;
import mysticartifice.MysticArtifice;
import mysticartifice.tileentities.TileEntityMetalForge;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockMetalForge extends BlockContainer {
    public BlockMetalForge() {
        super(Material.iron);
        setBlockName(ModInfo.MODID + ".metalForge");
        setBlockTextureName(ModInfo.MODID + ":machines/metalForge");
        setStepSound(soundTypeMetal);
        setCreativeTab(MysticArtifice.tab);
    }

    @Override
    public TileEntity createNewTileEntity(World var1, int var2) {
        return new TileEntityMetalForge();
    }
}
