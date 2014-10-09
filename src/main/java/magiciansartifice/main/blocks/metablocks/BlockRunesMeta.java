package magiciansartifice.main.blocks.metablocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.core.libs.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

import java.util.List;

/**
 * Created by poppypoppop on 9/10/2014.
 */
public class BlockRunesMeta extends Block {
    public IIcon[] icon = new IIcon[16];

    public BlockRunesMeta() {
        super(Material.iron);
        setHardness(2F);
        setStepSound(soundTypeStone);
        setCreativeTab(MagiciansArtifice.tab);
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister ir) {
        blockIcon = ir.registerIcon("minecraft:stone");

        icon[0] = ir.registerIcon(ModInfo.MODID + ":magicalblocks/timeRune");
        icon[1] = ir.registerIcon(ModInfo.MODID + ":magicalblocks/motionRune");
        icon[2] = ir.registerIcon(ModInfo.MODID + ":magicalblocks/matterRune");
        icon[3] = ir.registerIcon(ModInfo.MODID + ":magicalblocks/elementsRune");
        icon[4] = ir.registerIcon(ModInfo.MODID + ":magicalblocks/transformationRune");
        icon[5] = ir.registerIcon(ModInfo.MODID + ":magicalblocks/mindRune");
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item id, CreativeTabs tab, List list) {
        for (int i = 0; i <= 5; i++) {
            list.add(new ItemStack(id, 1, i));
        }
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) { return icon[meta]; }

    public int damageDropped(int meta)
    {
        return meta;
    }
}
