package magiciansartifice.main.blocks.magicblocks;

import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.blocks.BlockRegistry;
import magiciansartifice.main.core.libs.ModInfo;
import magiciansartifice.main.tileentities.magic.TileEntityRitualCornerstone;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import java.util.Random;

public class BlockRitualCornerstone extends BlockContainer {

    public static int distance;

    public BlockRitualCornerstone() {
        super(Material.iron);
        this.setBlockName("ritual.cornerStone");
        this.setBlockTextureName(ModInfo.MODID + ":magicalblocks/ritualCornerstone");
        this.setBlockUnbreakable();
        this.setResistance(20000.0F);
        this.setCreativeTab(MagiciansArtifice.tab);
        BlockRegistry.blocks.add(this);
    }

    public TileEntity createTileEntity(World world, int var2) {
        return new TileEntityRitualCornerstone();
    }

    public TileEntity createNewTileEntity(World world, int var2) {
        return new TileEntityRitualCornerstone();
    }

    public void updateTick(World world, int x, int y, int z,Random random) {
        world.addWeatherEffect(new EntityLightningBolt(world, x - distance, y, z - distance));
        world.addWeatherEffect(new EntityLightningBolt(world, x + distance, y, z + distance));
        world.addWeatherEffect(new EntityLightningBolt(world, x + distance, y, z - distance));
        world.addWeatherEffect(new EntityLightningBolt(world, x - distance, y, z + distance));
    }

    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase,ItemStack itemStack) {
        TileEntityRitualCornerstone te = (TileEntityRitualCornerstone)world.getTileEntity(x,y,z);

        if (te != null) {
            if (entityLivingBase instanceof EntityPlayer) {
                EntityPlayer player = (EntityPlayer) entityLivingBase;
                te.setOwner(player.getPersistentID());
            }
        }
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float hitX, float hitY, float hitZ) {
        if (player.getCurrentEquippedItem() == null) {
            if (player.isSneaking()) {
                TileEntityRitualCornerstone te = (TileEntityRitualCornerstone) world.getTileEntity(x,y,z);
                if (te != null) {
                    if (te.getOwner() == null || te.getOwner().compareTo(player.getPersistentID()) == 0) {
                        player.swingItem();
                        world.func_147480_a(x,y,z,true);
                    } else {
                        player.addChatComponentMessage(new ChatComponentTranslation("cornerstone.owner.incorrect", te.getOwner().toString()).setChatStyle(new ChatStyle().setColor(EnumChatFormatting.DARK_RED)));
                    }
                }
            }

        }
        return false;
    }

}
