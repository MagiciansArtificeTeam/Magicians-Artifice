package magiciansartifice.main.blocks.machines;

import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.blocks.BlockRegistry;
import magiciansartifice.main.core.client.guis.GuiHandler;
import magiciansartifice.main.tileentities.machines.TileEntityWandMaker;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

/**
 * Created by poppypoppop on 11/10/2014.
 */
public class BlockWandMaker extends BlockContainer {
    public BlockWandMaker() {
        super(Material.rock);
        this.setBlockName("wandmaker");
        this.setCreativeTab(MagiciansArtifice.tab);
        this.setBlockBounds(0F, 0F, 0F, 1F, 1.4F, 1F);
        BlockRegistry.blocks.add(this);
    }

    public BlockWandMaker(String extraEnd) {
        super(Material.rock);
        this.setBlockName("wandmaker"+extraEnd);
        this.setBlockBounds(0F, 0F, 0F, 1F, 1.4F, 1F);
        BlockRegistry.blocks.add(this);
    }

    @Override
    public int getRenderType()
    {
        return -1;
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float hitX, float hitY, float hitZ) {
        if (!player.isSneaking()) {
            if (/*world.getBlock(x,y,z) == BlockRegistry.wandMakerLit || */world.getBlockLightValue(x,y,z) >= 10 || player.isPotionActive(Potion.nightVision)) {
                if (!world.isRemote) {
                    player.openGui(MagiciansArtifice.instance, GuiHandler.IDS.WandMaker, world, x, y, z);
                }
            } else {
                if (!world.isRemote) {
                    player.addChatComponentMessage(new ChatComponentTranslation("maker.read.nope").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.GRAY).setItalic(true)));
                }
            }
        } else {
            if (world.getBlock(x,y,z) == BlockRegistry.wandMaker) {
                updateMakerState(false,world,x,y,z);
            } else if (world.getBlock(x,y,z) == BlockRegistry.wandMakerLit){
                updateMakerState(true,world,x,y,z);
            }
        }
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileEntityWandMaker();
    }

    private void updateMakerState(boolean isLit, World world, int x, int y, int z) {
        TileEntity te = world.getTileEntity(x,y,z);

        if (isLit) {
            world.setBlock(x,y,z,BlockRegistry.wandMaker);
        } else {
            world.setBlock(x,y,z,BlockRegistry.wandMakerLit);
        }

        if (te != null) {
            te.validate();
            world.setTileEntity(x,y,z,te);
        }

    }
}
