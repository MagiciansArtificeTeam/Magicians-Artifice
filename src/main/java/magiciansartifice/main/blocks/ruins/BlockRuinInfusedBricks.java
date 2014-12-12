package magiciansartifice.main.blocks.ruins;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.core.libs.ModInfo;
import magiciansartifice.main.items.itemblocks.ItemBlockRuinsInfused;
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
public class BlockRuinInfusedBricks extends Block {
    public IIcon[] icon = new IIcon[16];

    public BlockRuinInfusedBricks() {
        super(Material.rock);
        this.setHardness(1.5F);
        this.setStepSound(soundTypeStone);
        this.setCreativeTab(MagiciansArtifice.tab);
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister ir) {
        blockIcon = ir.registerIcon("minecraft:stone");

        icon[0] = ir.registerIcon(ModInfo.MODID + ":ruins/infusedOverworld");
        icon[1] = ir.registerIcon(ModInfo.MODID + ":ruins/infusedNether");
        icon[2] = ir.registerIcon(ModInfo.MODID + ":ruins/infusedEnd");
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        return icon[meta];
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item id, CreativeTabs tab, List list) {
        for (int i = 0; i < 3; i++) {
            list.add(new ItemStack(id, 1, i));
        }
    }

    public int damageDropped(int meta)
    {
        return meta;
    }
}
