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
    public static IIcon[] sides = new IIcon[16];

    public Logs1() {
        super(Material.wood);
        this.setHardness(0.5F);
        this.setStepSound(soundTypeWood);
        this.setCreativeTab(MagiciansArtifice.tab);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister ir) {
        sides[0] = ir.registerIcon(ModInfo.MODID + ":wood/logAsh");
        top[0] = ir.registerIcon(ModInfo.MODID + ":wood/logAshTop");

        sides[1] = ir.registerIcon(ModInfo.MODID + ":wood/logElm");
        top[1] = ir.registerIcon(ModInfo.MODID + "wood/logElmTop");

        sides[2] = ir.registerIcon(ModInfo.MODID + ":wood/logRowan");
        top[2] = ir.registerIcon(ModInfo.MODID + "wood/logRowanTop");

        sides[3] = ir.registerIcon(ModInfo.MODID + ":wood/logAlder");
        top[3] = ir.registerIcon(ModInfo.MODID + "wood/logAlderTop");
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        if (side == 0 || side == 1) {
            return top[meta];
        } else {
            return sides[meta];
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
