package magiciansartifice.main.blocks.wood;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.core.libs.ModInfo;
import net.minecraft.block.BlockLog;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

public class BlockLogs extends BlockLog {
    public static IIcon[] top = new IIcon[16];
    public static IIcon[] sides = new IIcon[16];

    public BlockLogs() {
        super();
        this.setCreativeTab(MagiciansArtifice.tab);
        this.setHardness(2.0F);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister ir) {
        sides[0] = ir.registerIcon(ModInfo.MODID + ":wood/logAsh");
        top[0] = ir.registerIcon(ModInfo.MODID + ":wood/logAshTop");

        sides[1] = ir.registerIcon(ModInfo.MODID + ":wood/logElm");
        top[1] = ir.registerIcon(ModInfo.MODID + ":wood/logElmTop");

        sides[2] = ir.registerIcon(ModInfo.MODID + ":wood/logRowan");
        top[2] = ir.registerIcon(ModInfo.MODID + ":wood/logRowanTop");

        sides[3] = ir.registerIcon(ModInfo.MODID + ":wood/logAlder");
        top[3] = ir.registerIcon(ModInfo.MODID + ":wood/logAlderTop");
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
    @SideOnly(Side.CLIENT)
    protected IIcon getSideIcon(int p_150163_1_) {
        return this.sides[p_150163_1_ % this.sides.length];
    }

    @Override
    @SideOnly(Side.CLIENT)
    protected IIcon getTopIcon(int p_150161_1_) {
        return this.top[p_150161_1_ % this.top.length];
    }

    @Override
    public int damageDropped(int meta) {
        return meta;
    }
}
