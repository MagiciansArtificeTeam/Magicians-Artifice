package magiciansartifice.blocks;

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
 * These ores drop the ore blocks
 */
public class BlockOresOreMeta extends Block
{
    public IIcon[] icon = new IIcon[16];

    public BlockOresOreMeta()
    {
        super(Material.rock);
        setHardness(0.5F);
        setStepSound(soundTypeStone);
        setCreativeTab(MagiciansArtifice.tab);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister ir)
    {
        blockIcon = ir.registerIcon("minecraft:stone");

        icon[0] = ir.registerIcon(ModInfo.MODID + ":ores/oreStarSteel");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        return icon[meta];
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item id, CreativeTabs tab, List list)
    {
        for (int i = 0; i < 1; i++)
        {
            list.add(new ItemStack(id, 1, i));
        }
    }

    @Override
    public int damageDropped(int meta)
    {
        return meta;
    }
}
