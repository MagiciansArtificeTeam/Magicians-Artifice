package magiciansartifice.main.blocks.magicblocks;

import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.blocks.BlockRegistry;
import magiciansartifice.main.core.libs.ModInfo;
import magiciansartifice.main.items.magicalitems.ItemWand;
import magiciansartifice.main.tileentities.magic.TileEntityEssenceHole;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockEssenceHole extends BlockContainer {

    public BlockEssenceHole() {
        super(Material.rock);
        this.setResistance(2000.0F);
        this.setHardness(5.0F);
        this.setBlockName("essenceHole");
        this.setCreativeTab(MagiciansArtifice.tab);
        this.setBlockTextureName(ModInfo.MODID + ":magicalblocks/essenceHole");
        this.setBlockBounds(0.25F, 0.25F, 0.25F, 0.75F, 0.75F, 0.75F);
        BlockRegistry.blocks.add(this);
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
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileEntityEssenceHole();
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        if (player.getCurrentEquippedItem() != null) {
            if (player.getCurrentEquippedItem().getItem() instanceof ItemWand) {
            TileEntityEssenceHole te = (TileEntityEssenceHole) world.getTileEntity(x, y, z);
            if (te != null) {
                ItemWand wand = (ItemWand) player.getCurrentEquippedItem().getItem();
                if (wand.getWandLevel() >= 1) {
                    te.stealOEssence(player.getCurrentEquippedItem());
                } else {
                    System.err.println("Not level 1!");
                }
                if (wand.getWandLevel() >= 2) {
                    te.stealNEssence(player.getCurrentEquippedItem());
                } else {
                    System.err.println("Not level 2!");
                }
                if (wand.getWandLevel() >= 3) {
                    te.stealEEssence(player.getCurrentEquippedItem());
                } else {
                    System.err.println("Not level 3!");
                }
            } else {
                System.err.println("Did this work now? Nope.avi!");
            }
            return true;
        }
        } else {
            System.err.println("DAMN STACK IS NULL!");
        }
        return false;
    }
}
