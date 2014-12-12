package magiciansartifice.main.blocks.ruins;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.core.libs.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRotatedPillar;
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
public class BlockRuinPillarMeta extends Block {
    public IIcon[] icon = new IIcon[16];

    public BlockRuinPillarMeta() {
        super(Material.rock);
        this.setHardness(1.5F);
        this.setStepSound(soundTypeStone);
        this.setCreativeTab(MagiciansArtifice.tab);
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister ir) {
        blockIcon = ir.registerIcon("minecraft:stone");

        icon[0] = ir.registerIcon(ModInfo.MODID + ":ruins/pillarTop");
        icon[1] = ir.registerIcon(ModInfo.MODID + ":ruins/pillarNormalSide");
        icon[2] = ir.registerIcon(ModInfo.MODID + ":ruins/pillarBottomSide");
        icon[3] = ir.registerIcon(ModInfo.MODID + ":ruins/pillarTopSide");
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
        return meta & 3;
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        if (side == 0 || side == 1) {
            return icon[0];
        } else {
            switch (meta) {
                case 0:
                    return icon[1];
                case 1:
                    return icon[2];
                case 2:
                    return icon[3];
            }
        }
        return blockIcon;
    }
}