package magiciansartifice.main.blocks.magicblocks;

import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.blocks.BlockRegistry;
import magiciansartifice.main.core.libs.ModInfo;
import magiciansartifice.main.tileentities.magic.TileEntityTeleportReciever;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

/**
 * Created by poppypoppop on 8/08/2014.
 */
public class BlockTeleportReciever extends BlockContainer {
    public BlockTeleportReciever() {
        super(Material.rock);
        this.setCreativeTab(MagiciansArtifice.tab);
        this.setBlockTextureName(ModInfo.MODID + ":magicalblocks/teleportReciever");
        this.setBlockName("teleport.receiver");
        BlockRegistry.blocks.add(this);
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        TileEntityTeleportReciever te = (TileEntityTeleportReciever)world.getTileEntity(x,y,z);
        y += 1;

        if (te != null) {
            if (entityLivingBase instanceof EntityPlayer) {
                if (world.isRemote) {
                    ((EntityPlayer) entityLivingBase).addChatComponentMessage(new ChatComponentText("Coordinates of Teleport Reciever set too"));
                    ((EntityPlayer) entityLivingBase).addChatComponentMessage(new ChatComponentText("X: " + te.getX()));
                    ((EntityPlayer) entityLivingBase).addChatComponentMessage(new ChatComponentText("Y: " + te.getY()));
                    ((EntityPlayer) entityLivingBase).addChatComponentMessage(new ChatComponentText("Z: " + te.getZ()));
                }
            }
        }
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileEntityTeleportReciever();
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        TileEntityTeleportReciever te = (TileEntityTeleportReciever)world.getTileEntity(x,y,z);
        if (world.isRemote) {
            player.addChatComponentMessage(new ChatComponentText("Coordinates of Teleport Reciever set too"));
            player.addChatComponentMessage(new ChatComponentText("X: " + te.getX()));
            player.addChatComponentMessage(new ChatComponentText("Y: " + te.getY()));
            player.addChatComponentMessage(new ChatComponentText("Z: " + te.getZ()));
        }
        return false;
    }
}
