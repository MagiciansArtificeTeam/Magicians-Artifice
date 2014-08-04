package magiciansartifice.blocks.machines;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import magiciansartifice.MagiciansArtifice;
import magiciansartifice.blocks.BlockRegistry;
import magiciansartifice.client.guis.GuiHandler;
import magiciansartifice.libs.ModInfo;
import magiciansartifice.tileentities.machines.TileEntityMetalForge;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockMetalForge extends BlockContainer {

    protected IIcon[] icons = new IIcon[17];
    public BlockMetalForge()
    {
        super(Material.iron);
        setStepSound(soundTypeMetal);
        setCreativeTab(MagiciansArtifice.tab);
        setHardness(3F);
        setBlockName("metalForge");
        BlockRegistry.blocks.add(this);
    }

    @Override
    public TileEntity createNewTileEntity(World var1, int var2)
    {
        return new TileEntityMetalForge();
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
    {
        super.onBlockActivated(world, x, y, z, player, side, hitX, hitY, hitZ);
        if (player.isSneaking()) return false;
        TileEntity te = world.getTileEntity(x, y, z);
        if (te instanceof TileEntityMetalForge && !((TileEntityMetalForge) te).hasMaster())
            return false;
        else
        {
            if (!world.isRemote)
            {
                player.openGui(MagiciansArtifice.instance, GuiHandler.IDS.MetalForge, world, x, y, z);
            }
            return true;
        }
    }

    @Override
    public void breakBlock(World world, int x, int y, int z, Block block, int meta)
    {
        TileEntityMetalForge te = (TileEntityMetalForge) world.getTileEntity(x, y, z);

        if (te != null)
        {
//            te.resetStructure();
//            te.dropContents();
        }
        super.breakBlock(world, x, y, z, block, meta);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) {
        if(par1IBlockAccess.getBlockMetadata(par2,par3,par4)==2) return icons[16];
        if(par1IBlockAccess.getBlockMetadata(par2, par3, par4)==3) return icons[17];
        return par1IBlockAccess.getBlockMetadata(par2, par3, par4) == 15 ? icons[0] : getConnectedBlockTexture(par1IBlockAccess, par2, par3, par4, par5, icons);
    }

    public boolean shouldConnectToBlock(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, Block par5, int par6) {
        return par5 == (Block) this;
    }

    public IIcon getConnectedBlockTexture(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5, IIcon[] icons) {

        boolean isOpenUp = false, isOpenDown = false, isOpenLeft = false, isOpenRight = false;

        switch (par5) {
            case 0:
                if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlock(par2 - 1, par3, par4), par1IBlockAccess.getBlockMetadata(par2 - 1, par3, par4))) {
                    isOpenDown = true;
                }

                if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlock(par2 + 1, par3, par4), par1IBlockAccess.getBlockMetadata(par2 + 1, par3, par4))) {
                    isOpenUp = true;
                }

                if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlock(par2, par3, par4 - 1), par1IBlockAccess.getBlockMetadata(par2, par3, par4 - 1))) {
                    isOpenLeft = true;
                }

                if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlock(par2, par3, par4 + 1), par1IBlockAccess.getBlockMetadata(par2, par3, par4 + 1))) {
                    isOpenRight = true;
                }

                if (isOpenUp && isOpenDown && isOpenLeft && isOpenRight) {
                    return icons[15];
                } else if (isOpenUp && isOpenDown && isOpenLeft) {
                    return icons[11];
                } else if (isOpenUp && isOpenDown && isOpenRight) {
                    return icons[12];
                } else if (isOpenUp && isOpenLeft && isOpenRight) {
                    return icons[13];
                } else if (isOpenDown && isOpenLeft && isOpenRight) {
                    return icons[14];
                } else if (isOpenDown && isOpenUp) {
                    return icons[5];
                } else if (isOpenLeft && isOpenRight) {
                    return icons[6];
                } else if (isOpenDown && isOpenLeft) {
                    return icons[8];
                } else if (isOpenDown && isOpenRight) {
                    return icons[10];
                } else if (isOpenUp && isOpenLeft) {
                    return icons[7];
                } else if (isOpenUp && isOpenRight) {
                    return icons[9];
                } else if (isOpenDown) {
                    return icons[3];
                } else if (isOpenUp) {
                    return icons[4];
                } else if (isOpenLeft) {
                    return icons[2];
                } else if (isOpenRight) {
                    return icons[1];
                }
                break;
            case 1:
                if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlock(par2 - 1, par3, par4), par1IBlockAccess.getBlockMetadata(par2 - 1, par3, par4))) {
                    isOpenDown = true;
                }

                if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlock(par2 + 1, par3, par4), par1IBlockAccess.getBlockMetadata(par2 + 1, par3, par4))) {
                    isOpenUp = true;
                }

                if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlock(par2, par3, par4 - 1), par1IBlockAccess.getBlockMetadata(par2, par3, par4 - 1))) {
                    isOpenLeft = true;
                }

                if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlock(par2, par3, par4 + 1), par1IBlockAccess.getBlockMetadata(par2, par3, par4 + 1))) {
                    isOpenRight = true;
                }

                if (isOpenUp && isOpenDown && isOpenLeft && isOpenRight) {
                    return icons[15];
                } else if (isOpenUp && isOpenDown && isOpenLeft) {
                    return icons[11];
                } else if (isOpenUp && isOpenDown && isOpenRight) {
                    return icons[12];
                } else if (isOpenUp && isOpenLeft && isOpenRight) {
                    return icons[13];
                } else if (isOpenDown && isOpenLeft && isOpenRight) {
                    return icons[14];
                } else if (isOpenDown && isOpenUp) {
                    return icons[5];
                } else if (isOpenLeft && isOpenRight) {
                    return icons[6];
                } else if (isOpenDown && isOpenLeft) {
                    return icons[8];
                } else if (isOpenDown && isOpenRight) {
                    return icons[10];
                } else if (isOpenUp && isOpenLeft) {
                    return icons[7];
                } else if (isOpenUp && isOpenRight) {
                    return icons[9];
                } else if (isOpenDown) {
                    return icons[3];
                } else if (isOpenUp) {
                    return icons[4];
                } else if (isOpenLeft) {
                    return icons[2];
                } else if (isOpenRight) {
                    return icons[1];
                }
                break;
            case 2:
                if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlock(par2, par3 - 1, par4), par1IBlockAccess.getBlockMetadata(par2, par3 - 1, par4))) {
                    isOpenDown = true;
                }

                if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlock(par2, par3 + 1, par4), par1IBlockAccess.getBlockMetadata(par2, par3 + 1, par4))) {
                    isOpenUp = true;
                }

                if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlock(par2 - 1, par3, par4), par1IBlockAccess.getBlockMetadata(par2 - 1, par3, par4))) {
                    isOpenLeft = true;
                }

                if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlock(par2 + 1, par3, par4), par1IBlockAccess.getBlockMetadata(par2 + 1, par3, par4))) {
                    isOpenRight = true;
                }

                if (isOpenUp && isOpenDown && isOpenLeft && isOpenRight) {
                    return icons[15];
                } else if (isOpenUp && isOpenDown && isOpenLeft) {
                    return icons[13];
                } else if (isOpenUp && isOpenDown && isOpenRight) {
                    return icons[14];
                } else if (isOpenUp && isOpenLeft && isOpenRight) {
                    return icons[11];
                } else if (isOpenDown && isOpenLeft && isOpenRight) {
                    return icons[12];
                } else if (isOpenDown && isOpenUp) {
                    return icons[6];
                } else if (isOpenLeft && isOpenRight) {
                    return icons[5];
                } else if (isOpenDown && isOpenLeft) {
                    return icons[9];
                } else if (isOpenDown && isOpenRight) {
                    return icons[10];
                } else if (isOpenUp && isOpenLeft) {
                    return icons[7];
                } else if (isOpenUp && isOpenRight) {
                    return icons[8];
                } else if (isOpenDown) {
                    return icons[1];
                } else if (isOpenUp) {
                    return icons[2];
                } else if (isOpenLeft) {
                    return icons[4];
                } else if (isOpenRight) {
                    return icons[3];
                }
                break;
            case 3:
                if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlock(par2, par3 - 1, par4), par1IBlockAccess.getBlockMetadata(par2, par3 - 1, par4))) {
                    isOpenDown = true;
                }

                if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlock(par2, par3 + 1, par4), par1IBlockAccess.getBlockMetadata(par2, par3 + 1, par4))) {
                    isOpenUp = true;
                }

                if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlock(par2 - 1, par3, par4), par1IBlockAccess.getBlockMetadata(par2 - 1, par3, par4))) {
                    isOpenLeft = true;
                }

                if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlock(par2 + 1, par3, par4), par1IBlockAccess.getBlockMetadata(par2 + 1, par3, par4))) {
                    isOpenRight = true;
                }

                if (isOpenUp && isOpenDown && isOpenLeft && isOpenRight) {
                    return icons[15];
                } else if (isOpenUp && isOpenDown && isOpenLeft) {
                    return icons[13];
                } else if (isOpenUp && isOpenDown && isOpenRight) {
                    return icons[14];
                } else if (isOpenUp && isOpenLeft && isOpenRight) {
                    return icons[11];
                } else if (isOpenDown && isOpenLeft && isOpenRight) {
                    return icons[12];
                } else if (isOpenDown && isOpenUp) {
                    return icons[6];
                } else if (isOpenLeft && isOpenRight) {
                    return icons[5];
                } else if (isOpenDown && isOpenLeft) {
                    return icons[9];
                } else if (isOpenDown && isOpenRight) {
                    return icons[10];
                } else if (isOpenUp && isOpenLeft) {
                    return icons[7];
                } else if (isOpenUp && isOpenRight) {
                    return icons[8];
                } else if (isOpenDown) {
                    return icons[1];
                } else if (isOpenUp) {
                    return icons[2];
                } else if (isOpenLeft) {
                    return icons[4];
                } else if (isOpenRight) {
                    return icons[3];
                }
                break;
            case 4:
                if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlock(par2, par3 - 1, par4), par1IBlockAccess.getBlockMetadata(par2, par3 - 1, par4))) {
                    isOpenDown = true;
                }

                if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlock(par2, par3 + 1, par4), par1IBlockAccess.getBlockMetadata(par2, par3 + 1, par4))) {
                    isOpenUp = true;
                }

                if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlock(par2, par3, par4 - 1), par1IBlockAccess.getBlockMetadata(par2, par3, par4 - 1))) {
                    isOpenLeft = true;
                }

                if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlock(par2, par3, par4 + 1), par1IBlockAccess.getBlockMetadata(par2, par3, par4 + 1))) {
                    isOpenRight = true;
                }

                if (isOpenUp && isOpenDown && isOpenLeft && isOpenRight) {
                    return icons[15];
                } else if (isOpenUp && isOpenDown && isOpenLeft) {
                    return icons[14];
                } else if (isOpenUp && isOpenDown && isOpenRight) {
                    return icons[13];
                } else if (isOpenUp && isOpenLeft && isOpenRight) {
                    return icons[11];
                } else if (isOpenDown && isOpenLeft && isOpenRight) {
                    return icons[12];
                } else if (isOpenDown && isOpenUp) {
                    return icons[6];
                } else if (isOpenLeft && isOpenRight) {
                    return icons[5];
                } else if (isOpenDown && isOpenLeft) {
                    return icons[10];
                } else if (isOpenDown && isOpenRight) {
                    return icons[9];
                } else if (isOpenUp && isOpenLeft) {
                    return icons[8];
                } else if (isOpenUp && isOpenRight) {
                    return icons[7];
                } else if (isOpenDown) {
                    return icons[1];
                } else if (isOpenUp) {
                    return icons[2];
                } else if (isOpenLeft) {
                    return icons[3];
                } else if (isOpenRight) {
                    return icons[4];
                }
                break;
            case 5:
                if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlock(par2, par3 - 1, par4), par1IBlockAccess.getBlockMetadata(par2, par3 - 1, par4))) {
                    isOpenDown = true;
                }

                if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlock(par2, par3 + 1, par4), par1IBlockAccess.getBlockMetadata(par2, par3 + 1, par4))) {
                    isOpenUp = true;
                }

                if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlock(par2, par3, par4 - 1), par1IBlockAccess.getBlockMetadata(par2, par3, par4 - 1))) {
                    isOpenLeft = true;
                }

                if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlock(par2, par3, par4 + 1), par1IBlockAccess.getBlockMetadata(par2, par3, par4 + 1))) {
                    isOpenRight = true;
                }

                if (isOpenUp && isOpenDown && isOpenLeft && isOpenRight) {
                    return icons[15];
                } else if (isOpenUp && isOpenDown && isOpenLeft) {
                    return icons[14];
                } else if (isOpenUp && isOpenDown && isOpenRight) {
                    return icons[13];
                } else if (isOpenUp && isOpenLeft && isOpenRight) {
                    return icons[11];
                } else if (isOpenDown && isOpenLeft && isOpenRight) {
                    return icons[12];
                } else if (isOpenDown && isOpenUp) {
                    return icons[6];
                } else if (isOpenLeft && isOpenRight) {
                    return icons[5];
                } else if (isOpenDown && isOpenLeft) {
                    return icons[10];
                } else if (isOpenDown && isOpenRight) {
                    return icons[9];
                } else if (isOpenUp && isOpenLeft) {
                    return icons[8];
                } else if (isOpenUp && isOpenRight) {
                    return icons[7];
                } else if (isOpenDown) {
                    return icons[1];
                } else if (isOpenUp) {
                    return icons[2];
                } else if (isOpenLeft) {
                    return icons[3];
                } else if (isOpenRight) {
                    return icons[4];
                }
                break;
        }

        return icons[0];
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
