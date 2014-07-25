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
 * Created by poppypoppop on 22/07/2014.
 */
public class BlockPlanksMeta extends Block {
    public static IIcon[] icon = new IIcon[16];

    public BlockPlanksMeta() {
        super(Material.wood);
        this.setCreativeTab(MagiciansArtifice.tab);
        this.setStepSound(soundTypeWood);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister ir) {
        icon[0] = ir.registerIcon(ModInfo.MODID + ":wood/plankAsh");
        icon[1] = ir.registerIcon(ModInfo.MODID + ":wood/plankElm");
        icon[2] = ir.registerIcon(ModInfo.MODID + ":wood/plankRowan");
        icon[3] = ir.registerIcon(ModInfo.MODID + ":wood/plankAlder");
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        return icon[meta];
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
