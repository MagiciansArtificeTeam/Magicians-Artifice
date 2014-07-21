package magiciansartifice.blocks.wood;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import magiciansartifice.MagiciansArtifice;
import magiciansartifice.libs.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

/**
 * Created by poppypoppop on 21/07/2014.
 */
public class Logs1 extends Block {
    public static IIcon[] top = new IIcon[16];
    public static IIcon[] side = new IIcon[16];

    public Logs1() {
        super(Material.wood);
        this.setCreativeTab(MagiciansArtifice.tab);
        this.setBlockName(ModInfo.MODID + ".logs1");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister ir) {
        top[0] = ir.registerIcon(ModInfo.MODID + ":wood/logAshTop");
        side[0] = ir.registerIcon(ModInfo.MODID + ":wood/logAsh");
    }

    @Override
    public IIcon getIcon(int sides, int meta) {
        if (sides == 0 || sides == 1) {
            return top[meta];
        } else {
            return side[meta];
        }
    }
}
