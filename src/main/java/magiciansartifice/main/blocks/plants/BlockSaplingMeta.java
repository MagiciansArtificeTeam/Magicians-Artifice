package magiciansartifice.main.blocks.plants;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.core.utils.registries.BlockRegistry;
import magiciansartifice.main.core.libs.ModInfo;
import net.minecraft.block.BlockSapling;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

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
        blockIcon = ir.registerIcon(ModInfo.MODID + ":plants/saplingAsh");

        icon[0] = ir.registerIcon(ModInfo.MODID + ":plants/saplingAsh");
        icon[1] = ir.registerIcon(ModInfo.MODID + ":plants/saplingElm");
        icon[2] = ir.registerIcon(ModInfo.MODID + ":plants/saplingRowan");
        icon[3] = ir.registerIcon(ModInfo.MODID + ":plants/saplingAlder");
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
    public void func_149878_d(World world, int x, int y, int z, Random rand) {
        int meta = world.getBlockMetadata(x, y, z);
        if (meta <= 3) {
            generateAsh(world,x,y,z,meta);
        } else {
            throw new RuntimeException("Incorrect Metadata on Generator");
        }
    }

    public void generateAsh(World world, int x, int y, int z, int meta) {
        for (int i = 0; i < 11; i++) {
            world.setBlock(x, y + i , z, BlockRegistry.logs, meta,3);
        }
        for (int i = 4; i < 10; i++) {
            world.setBlock(x, y + i , z + 1, BlockRegistry.logs, meta,3);
            world.setBlock(x, y + i , z - 1, BlockRegistry.logs, meta, 3);
            world.setBlock(x + 1, y + i , z, BlockRegistry.logs, meta, 3);
            world.setBlock(x - 1, y + i , z, BlockRegistry.logs, meta, 3);

        }
        for (int i = 5; i < 10; i++) {
            world.setBlock(x + 1, y + i , z + 1, BlockRegistry.leaves, meta, 3);
            world.setBlock(x + 1, y + i , z - 1, BlockRegistry.leaves, meta, 3);
            world.setBlock(x + 1, y + i , z + 1, BlockRegistry.leaves, meta, 3);
            world.setBlock(x - 1, y + i , z + 1, BlockRegistry.leaves, meta, 3);
            world.setBlock(x - 1, y + i , z + 1, BlockRegistry.leaves, meta, 3);
            world.setBlock(x - 1, y + i , z - 1, BlockRegistry.leaves, meta, 3);
            world.setBlock(x + 1, y + i , z - 1, BlockRegistry.leaves, meta, 3);
            world.setBlock(x - 1, y + i , z - 1, BlockRegistry.leaves, meta, 3);
            world.setBlock(x, y + i , z + 2, BlockRegistry.leaves, meta, 3);
            world.setBlock(x, y + i , z - 2, BlockRegistry.leaves, meta, 3);
            world.setBlock(x + 2, y + i , z, BlockRegistry.leaves, meta, 3);
            world.setBlock(x - 2, y + i , z, BlockRegistry.leaves, meta, 3);
        }
        world.setBlock(x, y + 11, z, BlockRegistry.leaves, meta, 3);
        world.setBlock(x, y + 10, z + 1, BlockRegistry.leaves, meta, 3);
        world.setBlock(x, y + 10, z - 1, BlockRegistry.leaves, meta, 3);
        world.setBlock(x + 1, y + 10, z, BlockRegistry.leaves, meta, 3);
        world.setBlock(x - 1, y + 10, z, BlockRegistry.leaves, meta, 3);
    }
}
