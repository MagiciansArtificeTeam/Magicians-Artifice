package mysticartifice.blocks.machines;

import mysticartifice.ModInfo;
import mysticartifice.MysticArtifice;
import mysticartifice.tileentities.TileEntityMysticAnvil;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockMysticAnvil extends BlockContainer {
    public BlockMysticAnvil() {
        super(Material.anvil);
        setBlockName(ModInfo.MODID + ".mysticAnvil");
        setStepSound(soundTypeAnvil);
        setCreativeTab(MysticArtifice.tab);
        setBlockBounds(0.125F, 0F, 0F, 0.875F, 1F, 1F);
    }

    @Override
    public int getRenderType() {
        return -1;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World var1, int var2) {
        return new TileEntityMysticAnvil();
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        if (world.isRemote) {
            player.openGui(MysticArtifice.instance, 0, world, x, y, z);
        }
        return false;
    }
}
