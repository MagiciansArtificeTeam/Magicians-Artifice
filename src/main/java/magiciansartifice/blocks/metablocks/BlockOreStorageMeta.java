package magiciansartifice.blocks.metablocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import magiciansartifice.MagiciansArtifice;
import magiciansartifice.core.libs.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

/**
 * Created by poppypoppop on 23/07/2014.
 */
public class BlockOreStorageMeta extends Block
{
    public IIcon[] icon = new IIcon[16];

    public BlockOreStorageMeta()
    {
        super(Material.iron);
        setHardness(2F);
        setStepSound(soundTypeMetal);
        setCreativeTab(MagiciansArtifice.tab);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister ir)
    {
        blockIcon = ir.registerIcon("minecraft:stone");

        icon[0] = ir.registerIcon(ModInfo.MODID + ":storage/essenceOverworld");
        icon[1] = ir.registerIcon(ModInfo.MODID + ":storage/essenceNether");
        icon[2] = ir.registerIcon(ModInfo.MODID + ":storage/essenceEnd");
        icon[3] = ir.registerIcon(ModInfo.MODID + ":storage/starSteel");
        icon[4] = ir.registerIcon(ModInfo.MODID + ":storage/steel");
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
        for (int i = 0; i < 5; i++)
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
