package magiciansartifice.blocks.machines;

import magiciansartifice.MagiciansArtifice;
import magiciansartifice.ModInfo;
import magiciansartifice.tileentities.machines.TileEntityMetalForge;
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
        setCreativeTab(MagiciansArtifice.tab);
    }

    @Override
    public TileEntity createNewTileEntity(World var1, int var2) {
        return new TileEntityMetalForge();
    }
}
