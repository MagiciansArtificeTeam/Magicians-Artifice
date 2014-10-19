package magiciansartifice.main.blocks.magicblocks;

import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.blocks.BlockRegistry;
import magiciansartifice.main.core.libs.ModInfo;
import magiciansartifice.main.items.magicalitems.ItemWand;
import magiciansartifice.main.items.magicalitems.wand.ItemModularWand;
import magiciansartifice.main.tileentities.magic.TileEntityEssenceHole;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

import java.util.List;

public class BlockEssenceHole extends BlockContainer {

    public BlockEssenceHole() {
        super(Material.rock);
        this.setHardness(5.0F);
        this.setBlockUnbreakable();
        this.setResistance(2000.0F);
        this.setBlockName("essenceHole");
        this.setCreativeTab(MagiciansArtifice.tab);
        this.setBlockTextureName(ModInfo.MODID + ":magicalblocks/essenceHole");
        this.setBlockBounds(0.25F, 0.25F, 0.25F, 0.75F, 0.75F, 0.75F);
        BlockRegistry.blocks.add(this);
    }

    public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB aabb, List list, Entity entity) {}

    public boolean isOpaqueCube() { return false; }

    public boolean renderAsNormalBlock() {
        return false;
    }

    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileEntityEssenceHole();
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        if (player.getCurrentEquippedItem() != null) {
            if (player.getCurrentEquippedItem().getItem() instanceof ItemWand || player.getCurrentEquippedItem().getItem() instanceof ItemModularWand) {
	            TileEntityEssenceHole te = (TileEntityEssenceHole) world.getTileEntity(x, y, z);
	            if (te != null) {
	                if (!player.isSneaking()) {
	                    if (player.getCurrentEquippedItem().stackTagCompound.getInteger("wandLevel") >= 1) {
	                        te.stealOEssence(player.getCurrentEquippedItem());
	                    }
	                    if (player.getCurrentEquippedItem().stackTagCompound.getInteger("wandLevel") >= 2) {
	                        te.stealNEssence(player.getCurrentEquippedItem());
	                    }
	                    if (player.getCurrentEquippedItem().stackTagCompound.getInteger("wandLevel") >= 3) {
	                        te.stealEEssence(player.getCurrentEquippedItem());
	                    }
	                    te.printChatMessage(player);
	                } else {
	                    te.printChatMessage(player);
	                }
	            }
	            return true;
	        }
        }
        return false;
    }
}
