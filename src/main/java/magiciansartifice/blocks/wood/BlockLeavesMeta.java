package magiciansartifice.blocks.wood;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import magiciansartifice.MagiciansArtifice;
import magiciansartifice.blocks.BlockRegistry;
import magiciansartifice.libs.ModInfo;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.IShearable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by poppypoppop on 6/08/2014.
 */
public class BlockLeavesMeta extends BlockLeaves implements IShearable {
    public static IIcon[] icon = new IIcon[16];

    public BlockLeavesMeta() {
        super();
        this.setCreativeTab(MagiciansArtifice.tab);
        this.setStepSound(soundTypeGrass);
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister ir) {
        icon[0] = ir.registerIcon(ModInfo.MODID + ":wood/leaveAsh");
        icon[1] = ir.registerIcon(ModInfo.MODID + ":wood/leaveElm");
        icon[2] = ir.registerIcon(ModInfo.MODID + ":wood/leaveRowan");
        icon[3] = ir.registerIcon(ModInfo.MODID + ":wood/leaveAlder");
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        return icon[meta];
    }

    @Override
    public String[] func_150125_e() {
        return new String[0];
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
    public boolean isShearable(ItemStack item, IBlockAccess world, int x, int y, int z) {
        return true;
    }

    @Override
    public ArrayList<ItemStack> onSheared(ItemStack item, IBlockAccess world, int x, int y, int z, int fortune) {
        return null;
    }

    @Override
    public Item getItemDropped(int amount, Random random, int meta) {
        switch (meta) {
            case 0: return new ItemStack(BlockRegistry.saplings, 1, 0).getItem();
            case 1: return new ItemStack(BlockRegistry.saplings, 1, 1).getItem();
            case 2: return new ItemStack(BlockRegistry.saplings, 1, 2).getItem();
            case 3: return new ItemStack(BlockRegistry.saplings, 1, 3).getItem();
        }
        return null;
    }
}
