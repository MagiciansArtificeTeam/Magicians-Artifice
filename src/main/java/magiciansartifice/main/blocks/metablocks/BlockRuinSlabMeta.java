package magiciansartifice.main.blocks.metablocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.core.libs.ModInfo;
import magiciansartifice.main.core.utils.registries.BlockRegistry;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

/**
 * Created by poppypoppop on 11/12/2014.
 */
public class BlockRuinSlabMeta extends BlockSlab {
    public static final String[] names = new String[] {"smooth", "cracked", "mossy", "chiseled"};
    public static final String name = "ruinSlab";
    public static IIcon[] icon = new IIcon[16];

    public BlockRuinSlabMeta() {
        super(false, Material.rock);
        this.setHardness(1.5F);
        this.setCreativeTab(MagiciansArtifice.tab);
        this.useNeighborBrightness = true;
    }

    public boolean isOpaqueCube() { return false; }

    @Override
    public String func_150002_b(int meta) {
        if (meta < 0 || meta >= names.length) {
            meta = 0;
        }

        return super.getUnlocalizedName() + "." + names[meta];
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister ir) {
        blockIcon = ir.registerIcon("minecraft:stone");

        icon[0] = ir.registerIcon(ModInfo.MODID + ":ruins/brickNormal");
        icon[1] = ir.registerIcon(ModInfo.MODID + ":ruins/brickCracked");
        icon[2] = ir.registerIcon(ModInfo.MODID + ":ruins/brickMossy");
        icon[3] = ir.registerIcon(ModInfo.MODID + ":ruins/brickChiseled");
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return icon[meta];
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item id, CreativeTabs tab, List list) {
        for (int i = 0; i < 4; i++) {
            list.add(new ItemStack(id, 1, i));
        }
    }

    public int damageDropped(int meta)
    {
        return meta;
    }
}
