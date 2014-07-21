package magiciansartifice.blocks.wood;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import magiciansartifice.MagiciansArtifice;
import magiciansartifice.libs.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

/**
 * Created by poppypoppop on 21/07/2014.
 */
public class Logs1 extends Block {
    public static IIcon[] top = new IIcon[16];
    public static IIcon[] side = new IIcon[16];

    public Logs1() {
        super(Material.wood);
        this.setHardness(0.5F);
        this.setStepSound(soundTypeWood);
        this.setCreativeTab(MagiciansArtifice.tab);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister ir) {
        side[0] = ir.registerIcon(ModInfo.MODID + ":wood/logAsh");
        top[0] = ir.registerIcon(ModInfo.MODID + ":wood/logAshTop");

        side[1] = ir.registerIcon(ModInfo.MODID + ":wood/logElm");
        top[1] = ir.registerIcon(ModInfo.MODID + "wood/logElmTop");

        side[2] = ir.registerIcon(ModInfo.MODID + ":wood/logRowan");
        top[2] = ir.registerIcon(ModInfo.MODID + "wood/logRowanTop");

        side[3] = ir.registerIcon(ModInfo.MODID + ":wood/logAlder");
        top[3] = ir.registerIcon(ModInfo.MODID + "wood/logAlderTop");
    }

    @Override
    public IIcon getIcon(int sides, int meta) {
        if (sides == 0 || sides == 1) {
            return top[meta];
        } else {
            return side[meta];
        }
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item id, CreativeTabs tab, List list) {
        for (int i = 0; i < 4; i++) {
            list.add(new ItemStack(id, 1, i));
        }
    }

    @Override
    public int damageDropped(int meta) {
        return meta;
    }
}
