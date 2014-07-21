package magiciansartifice.blocks;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import magiciansartifice.MagiciansArtifice;
import magiciansartifice.items.ItemRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import magiciansartifice.libs.ModInfo;

import java.util.List;
import java.util.Random;

public class BlockOresDustMeta extends Block {
    public IIcon[] icon = new IIcon[16];

    public BlockOresDustMeta() {
        super(Material.rock);
        this.setHardness(0.5F);
        this.setStepSound(soundTypeStone);
        this.setCreativeTab(MagiciansArtifice.tab);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister ir) {
        blockIcon = ir.registerIcon("minecraft:stone");

        icon[0] = ir.registerIcon(ModInfo.MODID + ":ores/essenceOverworld");
        icon[1] = ir.registerIcon(ModInfo.MODID + ":ores/essenceNether");
        icon[2] = ir.registerIcon(ModInfo.MODID + ":ores/essenceEnd");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return icon[meta];
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item id, CreativeTabs tab, List list) {
        for (int i = 0; i < 3; i++) {
            list.add(new ItemStack(id, 1, i));
        }
    }

    @Override
    public Item getItemDropped(int quantity, Random rand, int meta) {
        switch (meta) {
            case 0: return new ItemStack(ItemRegistry.dustsMeta, 1, 0).getItem();
            case 1: return new ItemStack(ItemRegistry.dustsMeta, 1, 1).getItem();
            case 2: return new ItemStack(ItemRegistry.dustsMeta, 1, 2).getItem();
        }
        return null;
    }

    @Override
    public int quantityDropped(Random rand) { return rand.nextInt(4); }

    @Override
    public int damageDropped(int meta) {
        return meta;
    }
}
