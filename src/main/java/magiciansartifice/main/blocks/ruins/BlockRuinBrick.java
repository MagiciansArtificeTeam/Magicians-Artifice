package magiciansartifice.main.blocks.ruins;

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

import java.util.List;

/**
 * Created by poppypoppop on 10/12/2014.
 */
public class BlockRuinBrick extends Block {
    public IIcon[] icon = new IIcon[16];

    public BlockRuinBrick() {
        super(Material.rock);
        this.setHardness(1.5F);
        this.setStepSound(soundTypeStone);
        this.setCreativeTab(MagiciansArtifice.tab);
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister ir) {
        blockIcon = ir.registerIcon("minecraft:stone");

        icon[0] = ir.registerIcon(ModInfo.MODID + ":ruins/brickNormal");
        icon[1] = ir.registerIcon(ModInfo.MODID + ":ruins/brickCracked");
        icon[2] = ir.registerIcon(ModInfo.MODID + ":ruins/brickMossy");
        icon[3] = ir.registerIcon(ModInfo.MODID + ":ruins/brickChiseled");
        icon[4] = ir.registerIcon(ModInfo.MODID + ":ruins/brickNormalNether");
        icon[5] = ir.registerIcon(ModInfo.MODID + ":ruins/brickCrackedNether");
        icon[6] = ir.registerIcon(ModInfo.MODID + ":ruins/brickMossyNether");
        icon[7] = ir.registerIcon(ModInfo.MODID + ":ruins/brickChiseledNether");
        icon[8] = ir.registerIcon(ModInfo.MODID + ":ruins/brickNormalEnd");
        icon[9] = ir.registerIcon(ModInfo.MODID + ":ruins/brickCrackedEnd");
        icon[10] = ir.registerIcon(ModInfo.MODID + ":ruins/brickMossyEnd");
        icon[11] = ir.registerIcon(ModInfo.MODID + ":ruins/brickChiseledEnd");
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        return icon[meta];
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item id, CreativeTabs tab, List list) {
        for (int i = 0; i < 12; i++) {
            list.add(new ItemStack(id, 1, i));
        }
    }

    public int damageDropped(int meta)
    {
        return meta;
    }
}
