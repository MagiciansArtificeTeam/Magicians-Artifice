package magiciansartifice.main.blocks.machines;

import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.blocks.BlockRegistry;
import magiciansartifice.main.core.client.guis.GuiHandler;
import magiciansartifice.main.core.libs.ModInfo;
import magiciansartifice.main.tileentities.machines.TileEntityMetalForge;
import main.flowstoneenergy.core.utils.ConnectedTextureHelper;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockMetalForge extends BlockContainer {

    protected IIcon[] icons = new IIcon[18];
    public BlockMetalForge() {
        super(Material.iron);
        setStepSound(soundTypeMetal);
        setCreativeTab(MagiciansArtifice.tab);
        setHardness(3F);
        setBlockName("metalForge");
        BlockRegistry.blocks.add(this);
    }

    @Override
    public TileEntity createNewTileEntity(World var1, int var2) {
        return new TileEntityMetalForge();
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        super.onBlockActivated(world, x, y, z, player, side, hitX, hitY, hitZ);
        if (player.isSneaking()) return false;
        TileEntity te = world.getTileEntity(x, y, z);
        if (te instanceof TileEntityMetalForge && !((TileEntityMetalForge) te).hasMaster())
            return false;
        else {
            if (!world.isRemote) {
                player.openGui(MagiciansArtifice.instance, GuiHandler.IDS.MetalForge, world, x, y, z);
            }
            return true;
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(IBlockAccess blockAccess, int x, int y, int z, int side) {
    	TileEntityMetalForge te = (TileEntityMetalForge)blockAccess.getTileEntity(x, y, z);
    	if (!te.hasMaster()) return blockIcon;
        if(blockAccess.getBlockMetadata(x, y, z)==2) return icons[16];
        if(blockAccess.getBlockMetadata(x, y, z)==3) return icons[17];
        return blockAccess.getBlockMetadata(x, y, z) == 15 ? icons[0] : ConnectedTextureHelper.getConnectedBlockTexture(blockAccess, x, y, z, side, icons, this);
    }

    @Override
    public void registerBlockIcons (IIconRegister par1IconRegister) {
        blockIcon = par1IconRegister.registerIcon(ModInfo.MODID + ":machines/metalForge_0");
        icons[0] = par1IconRegister.registerIcon(ModInfo.MODID + ":machines/metalForge_0");
        icons[1] = par1IconRegister.registerIcon(ModInfo.MODID + ":machines/metalForge_1");
        icons[2] = par1IconRegister.registerIcon(ModInfo.MODID + ":machines/metalForge_2");
        icons[3] = par1IconRegister.registerIcon(ModInfo.MODID + ":machines/metalForge_3");
        icons[4] = par1IconRegister.registerIcon(ModInfo.MODID + ":machines/metalForge_4");
        icons[5] = par1IconRegister.registerIcon(ModInfo.MODID + ":machines/metalForge_5");
        icons[6] = par1IconRegister.registerIcon(ModInfo.MODID + ":machines/metalForge_6");
        icons[7] = par1IconRegister.registerIcon(ModInfo.MODID + ":machines/metalForge_7");
        icons[8] = par1IconRegister.registerIcon(ModInfo.MODID + ":machines/metalForge_8");
        icons[9] = par1IconRegister.registerIcon(ModInfo.MODID + ":machines/metalForge_9");
        icons[10] = par1IconRegister.registerIcon(ModInfo.MODID + ":machines/metalForge_10");
        icons[11] = par1IconRegister.registerIcon(ModInfo.MODID + ":machines/metalForge_11");
        icons[12] = par1IconRegister.registerIcon(ModInfo.MODID + ":machines/metalForge_12");
        icons[13] = par1IconRegister.registerIcon(ModInfo.MODID + ":machines/metalForge_13");
        icons[14] = par1IconRegister.registerIcon(ModInfo.MODID + ":machines/metalForge_14");
        icons[15] = par1IconRegister.registerIcon(ModInfo.MODID + ":machines/metalForge_15");
        icons[16] = par1IconRegister.registerIcon(ModInfo.MODID + ":machines/metalForgeOff");
        icons[17] = par1IconRegister.registerIcon(ModInfo.MODID + ":machines/metalForgeOn");
    }
}