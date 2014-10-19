package magiciansartifice.main.blocks.metablocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.blocks.BlockRegistry;
import magiciansartifice.main.core.libs.ModInfo;
import magiciansartifice.main.core.utils.BlockHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.*;

/**
 * Created by poppypoppop on 9/10/2014.
 */
public class BlockRunesMeta extends Block {
    public IIcon[] icon = new IIcon[16];
    private static ArrayList<Block> blocks = new ArrayList<Block>();
    private Block sb = Blocks.stonebrick;

    public BlockRunesMeta() {
        super(Material.iron);
        setHardness(2F);
        setStepSound(soundTypeStone);
        setCreativeTab(MagiciansArtifice.tab);
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister ir) {
        blockIcon = ir.registerIcon("minecraft:stone");

        icon[0] = ir.registerIcon(ModInfo.MODID + ":magicalblocks/runes/timeRune");
        icon[1] = ir.registerIcon(ModInfo.MODID + ":magicalblocks/runes/motionRune");
        icon[2] = ir.registerIcon(ModInfo.MODID + ":magicalblocks/runes/matterRune");
        icon[3] = ir.registerIcon(ModInfo.MODID + ":magicalblocks/runes/elementsRune");
        icon[4] = ir.registerIcon(ModInfo.MODID + ":magicalblocks/runes/transformationRune");
        icon[5] = ir.registerIcon(ModInfo.MODID + ":magicalblocks/runes/mindRune");
        icon[6] = ir.registerIcon(ModInfo.MODID + ":magicalblocks/runes/lightConnectorRune");
        icon[7] = ir.registerIcon(ModInfo.MODID + ":magicalblocks/runes/darkConnectorRune");
        icon[8] = ir.registerIcon(ModInfo.MODID + ":magicalblocks/runes/midConnectorRune");
        icon[9] = ir.registerIcon(ModInfo.MODID + ":magicalblocks/runes/centerRune");
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item id, CreativeTabs tab, List list) {
        for (int i = 0; i <= 9; i++) {
            list.add(new ItemStack(id, 1, i));
        }
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) { return icon[meta]; }

    public int damageDropped(int meta)
    {
        return meta;
    }

    public int onBlockPlaced(World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int meta) {
        if (meta == 9 && checkForCircle(world, x, y, z)) {
            formMerlinCircle(world, x, y, z);
        }
        return meta;
    }

    private void formMerlinCircle(World world, int x, int y, int z) {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                world.setBlock(x - 5 + j, y, z - 5 + i, BlockRegistry.merlinscircle);
            }
        }
    }

    private boolean checkForCircle(World world, int x, int y, int z) {
        return false;
    }
}
