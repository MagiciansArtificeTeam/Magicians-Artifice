package magiciansartifice.blocks.machines;

import magiciansartifice.MagiciansArtifice;
import magiciansartifice.client.guis.GuiHandler;
import magiciansartifice.libs.ModInfo;
import magiciansartifice.tileentities.machines.TileEntityMetalForge;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockMetalForge extends BlockContainer
{
    public BlockMetalForge()
    {
        super(Material.iron);
        setBlockName(ModInfo.MODID + ".metalForge");
        setBlockTextureName(ModInfo.MODID + ":machines/metalForge");
        setStepSound(soundTypeMetal);
        setCreativeTab(MagiciansArtifice.tab);
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
                if (te instanceof TileEntityMetalForge)
                    System.out.println("Master te: " + ((TileEntityMetalForge) te).getMaster());
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
}
