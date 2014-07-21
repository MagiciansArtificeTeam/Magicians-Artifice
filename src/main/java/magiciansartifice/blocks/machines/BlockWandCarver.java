package magiciansartifice.blocks.machines;

import magiciansartifice.MagiciansArtifice;
import magiciansartifice.ModInfo;
import magiciansartifice.tileentities.machines.TileEntityWandCarver;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockWandCarver extends BlockContainer {
    public BlockWandCarver() {
        super(Material.wood);
        this.setBlockName(ModInfo.MODID + ".wandCarver");
        this.setCreativeTab(MagiciansArtifice.tab);
        this.setBlockBounds(0F, 0F, 0F, 1F, 0.7F, 1F);
    }

    @Override
    public int getRenderType() { return -1; }

    @Override
    public boolean isOpaqueCube() { return false; }

    @Override
    public boolean renderAsNormalBlock() { return false; }

    @Override
    public TileEntity createNewTileEntity(World var1, int var2) { return new TileEntityWandCarver(); }

    @Override
    public void registerBlockIcons(IIconRegister ir) { blockIcon = ir.registerIcon(ModInfo.MODID + ":machines/wandCarverIcon"); }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        if (world.isRemote) {
            player.openGui(MagiciansArtifice.instance, 1, world, x, y, z);
        }
        return false;
    }
}