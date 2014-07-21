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
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by poppypoppop on 21/07/2014.
 */
public class BlockLogs extends Block {
    public static IIcon[] top = new IIcon[16];
    public static IIcon[] sides = new IIcon[16];

    public BlockLogs() {
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
        top[1] = ir.registerIcon(ModInfo.MODID + ":wood/logElmTop");

        sides[2] = ir.registerIcon(ModInfo.MODID + ":wood/logRowan");
        top[2] = ir.registerIcon(ModInfo.MODID + ":wood/logRowanTop");

        sides[3] = ir.registerIcon(ModInfo.MODID + ":wood/logAlder");
        top[3] = ir.registerIcon(ModInfo.MODID + ":wood/logAlderTop");

        sides[4] = ir.registerIcon(ModInfo.MODID + ":wood/logAsh");
        top[4] = ir.registerIcon(ModInfo.MODID + ":wood/logAshTop");

        sides[5] = ir.registerIcon(ModInfo.MODID + ":wood/logElm");
        top[5] = ir.registerIcon(ModInfo.MODID + ":wood/logElmTop");

        sides[6] = ir.registerIcon(ModInfo.MODID + ":wood/logRowan");
        top[6] = ir.registerIcon(ModInfo.MODID + ":wood/logRowanTop");

        sides[7] = ir.registerIcon(ModInfo.MODID + ":wood/logAlder");
        top[7] = ir.registerIcon(ModInfo.MODID + ":wood/logAlderTop");

        sides[8] = ir.registerIcon(ModInfo.MODID + ":wood/logAsh");
        top[8] = ir.registerIcon(ModInfo.MODID + ":wood/logAshTop");

        sides[9] = ir.registerIcon(ModInfo.MODID + ":wood/logElm");
        top[9] = ir.registerIcon(ModInfo.MODID + ":wood/logElmTop");

        sides[10] = ir.registerIcon(ModInfo.MODID + ":wood/logRowan");
        top[10] = ir.registerIcon(ModInfo.MODID + ":wood/logRowanTop");

        sides[11] = ir.registerIcon(ModInfo.MODID + ":wood/logAlder");
        top[11] = ir.registerIcon(ModInfo.MODID + ":wood/logAlderTop");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        if (meta <= 3) {
            if (!(side == 0 || side == 1)) {
                return sides[meta];
            } else {
                return top[meta];
            }
        } else if (meta >= 4 || meta <= 7) {
            if (!(side == 2 || side == 3)) {
                return top[meta];
            } else {
                return sides[meta];
            }
        } else {
            if (!(side == 4 || side == 5)) {
                return top[meta];
            } else {
                return sides[meta];
            }
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

    @Override
    public boolean canSustainLeaves(IBlockAccess world, int x, int y, int z) { return true; }

    @Override
    public boolean isWood(IBlockAccess world, int x, int y, int z) { return true; }

    @Override
    public int onBlockPlaced(World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int meta) {
        int j1 = meta & 3;
        byte b0 = 0;

        switch (side) {
            case 0:
            case 1:
                b0 = 0;
                break;
            case 2:
            case 3:
                b0 = 8;
                break;
            case 4:
            case 5:
                b0 = 4;
        }

        return j1 | b0;
    }
}
