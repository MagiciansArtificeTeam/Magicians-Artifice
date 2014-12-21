package magiciansartifice.main.blocks.ruins;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.core.libs.ModInfo;
import magiciansartifice.main.core.utils.registries.BlockRegistry;
import net.minecraft.block.BlockStoneSlab;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by poppypoppop on 11/12/2014.
 */
public class BlockRuinSlab2 extends BlockStoneSlab {
    public static final String[] names = new String[] {"smooth", "cracked", "mossy", "chiseled"};
    public static IIcon[] icon = new IIcon[16];

    public BlockRuinSlab2(boolean isDoubleSlab) {
        super(isDoubleSlab);
        this.setHardness(1.5F);
        if (!isDoubleSlab) {
            this.setCreativeTab(MagiciansArtifice.tab);
        }
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

        icon[0] = ir.registerIcon(ModInfo.MODID + ":ruins/brickNormalEnd");
        icon[1] = ir.registerIcon(ModInfo.MODID + ":ruins/brickCrackedEnd");
        icon[2] = ir.registerIcon(ModInfo.MODID + ":ruins/brickMossyEnd");
        icon[3] = ir.registerIcon(ModInfo.MODID + ":ruins/brickChiseledEnd");
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        switch (meta) {
            case 0:case 8: return icon[0];
            case 1:case 9: return icon[1];
            case 2:case 10: return icon[2];
            case 3:case 11: return icon[3];
        }
        return null;
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

    public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
        return new ItemStack(BlockRegistry.ruinSlabs, 1, this.getDamageValue(world, x, y, z));
    }

    protected ItemStack createStackedBlock(int meta) {
        return new ItemStack(this, 2, meta);
    }
}
