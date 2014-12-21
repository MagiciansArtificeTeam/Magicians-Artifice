package magiciansartifice.main.blocks.ruins;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.core.libs.ModInfo;
import magiciansartifice.main.core.utils.registries.BlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

import java.util.List;

/**
 * Created by poppypoppop on 10/12/2014.
 */
public class BlockRuinPillar extends Block {
    public IIcon[] icon = new IIcon[16];

    public BlockRuinPillar() {
        super(Material.rock);
        this.setHardness(1.5F);
        this.setStepSound(soundTypeStone);
        this.setBlockName("ruinPillar");
        this.setCreativeTab(MagiciansArtifice.tab);
        BlockRegistry.blocks.add(this);
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister ir) {
        blockIcon = ir.registerIcon("minecraft:stone");

        icon[0] = ir.registerIcon(ModInfo.MODID + ":ruins/pillarTop");
        icon[1] = ir.registerIcon(ModInfo.MODID + ":ruins/pillarNoneSide");
        icon[2] = ir.registerIcon(ModInfo.MODID + ":ruins/pillarTopSide");
        icon[3] = ir.registerIcon(ModInfo.MODID + ":ruins/pillarBottomSide");
        icon[4] = ir.registerIcon(ModInfo.MODID + ":ruins/pillarNormalSide");
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item id, CreativeTabs tab, List list) {
        for (int i = 0; i < 3; i++) {
            list.add(new ItemStack(id, 1, i));
        }
    }

    public int damageDropped(int meta)
    {
        return meta & 3;
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(IBlockAccess blockAccess, int x, int y, int z, int side) {
        if (side == 0 || side == 1) {
            return icon[0];
        } else {
            if (!blockAccess.getBlock(x, y + 1, z).equals(this) && !blockAccess.getBlock(x, y - 1, z).equals(this)) return icon[1];
            if (!blockAccess.getBlock(x, y + 1, z).equals(this) && blockAccess.getBlock(x, y - 1, z).equals(this)) return icon[2];
            if (blockAccess.getBlock(x, y + 1, z).equals(this) && !blockAccess.getBlock(x, y - 1, z).equals(this)) return icon[3];
            if (blockAccess.getBlock(x, y + 1, z).equals(this) && blockAccess.getBlock(x, y - 1, z).equals(this)) return icon[4];
        }
        return blockIcon;
    }

    public IIcon getIcon(int side, int meta) {
        if (side == 0 || side == 1) return icon[0];
        else return icon[1];
    }
}