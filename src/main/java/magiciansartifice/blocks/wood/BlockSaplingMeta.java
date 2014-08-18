package magiciansartifice.blocks.wood;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import magiciansartifice.MagiciansArtifice;
import magiciansartifice.libs.ModInfo;
import net.minecraft.block.BlockSapling;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

/**
 * Created by poppypoppop on 18/08/2014.
 */
public class BlockSaplingMeta extends BlockSapling {
    public IIcon[] icon = new IIcon[16];

    public BlockSaplingMeta() {
        super();
        this.setCreativeTab(MagiciansArtifice.tab);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        switch (meta) {
            case 0: return icon[0];
            case 1: return icon[1];
            case 2: return icon[2];
            case 3: return icon[3];
        }
        return blockIcon;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister ir)
    {
        blockIcon = ir.registerIcon(ModInfo.MODID + ":wood/saplingAsh");

        icon[0] = ir.registerIcon(ModInfo.MODID + ":wood/saplingAsh");
        icon[1] = ir.registerIcon(ModInfo.MODID + ":wood/saplingElm");
        icon[2] = ir.registerIcon(ModInfo.MODID + ":wood/saplingRowan");
        icon[3] = ir.registerIcon(ModInfo.MODID + ":wood/saplingAlder");
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item id, CreativeTabs tab, List list) {
        for (int i = 0; i < 4; i++) {
            list.add(new ItemStack(id, 1, i));
        }
    }
}
