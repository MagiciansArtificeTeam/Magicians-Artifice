package magiciansartifice.blocks.wood;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import magiciansartifice.MagiciansArtifice;
import magiciansartifice.blocks.BlockRegistry;
import magiciansartifice.core.libs.ModInfo;
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

    @Override
    public void func_149878_d(World world, int x, int y, int z, Random rand) {
        int meta = world.getBlockMetadata(x, y, z);
        switch (meta) {
            case 0: generateAsh(world, x, y, z, rand); break;
            case 1: generateElm(world, x, y, z, rand); break;
            case 2: generateRowan(world, x, y, z, rand); break;
            case 3: generateAlder(world, x, y, z, rand); break;
        }
    }

    public void generateAsh(World world, int x, int y, int z, Random rand) {
        int f = rand.nextInt(3);
        for (int i = 0; i < 11; i++) {
            world.setBlock(x, y + i , z, BlockRegistry.logs, f, 0);
        }
        for (int i = 4; i < 10; i++) {
            world.setBlock(x, y + i , z + 1, BlockRegistry.logs, f, 0);
            world.setBlock(x, y + i , z - 1, BlockRegistry.logs, f, 0);
            world.setBlock(x + 1, y + i , z, BlockRegistry.logs, f, 0);
            world.setBlock(x - 1, y + i , z, BlockRegistry.logs, f, 0);

        }
        for (int i = 5; i < 10; i++) {
            world.setBlock(x + 1, y + i , z + 1, BlockRegistry.leaves, f, 0);
            world.setBlock(x + 1, y + i , z - 1, BlockRegistry.leaves, f, 0);
            world.setBlock(x + 1, y + i , z + 1, BlockRegistry.leaves, f, 0);
            world.setBlock(x - 1, y + i , z + 1, BlockRegistry.leaves, f, 0);
            world.setBlock(x - 1, y + i , z + 1, BlockRegistry.leaves, f, 0);
            world.setBlock(x - 1, y + i , z - 1, BlockRegistry.leaves, f, 0);
            world.setBlock(x + 1, y + i , z - 1, BlockRegistry.leaves, f, 0);
            world.setBlock(x - 1, y + i , z - 1, BlockRegistry.leaves, f, 0);
            world.setBlock(x, y + i , z + 2, BlockRegistry.leaves, f, 0);
            world.setBlock(x, y + i , z - 2, BlockRegistry.leaves, f, 0);
            world.setBlock(x + 2, y + i , z, BlockRegistry.leaves, f, 0);
            world.setBlock(x - 2, y + i , z, BlockRegistry.leaves, f, 0);
        }
        world.setBlock(x, y + 11, z, BlockRegistry.leaves, f, 0);
        world.setBlock(x, y + 10, z + 1, BlockRegistry.leaves, f, 0);
        world.setBlock(x, y + 10, z - 1, BlockRegistry.leaves, f, 0);
        world.setBlock(x + 1, y + 10, z, BlockRegistry.leaves, f, 0);
        world.setBlock(x - 1, y + 10, z, BlockRegistry.leaves, f, 0);
    }

    public void generateElm(World world, int x, int y, int z, Random rand) {
        int f = rand.nextInt(3);
        for (int i = 0; i < 11; i++) {
            world.setBlock(x, y + i , z, BlockRegistry.logs, f, 1);
        }
        for (int i = 4; i < 10; i++) {
            world.setBlock(x, y + i , z + 1, BlockRegistry.logs, f, 1);
            world.setBlock(x, y + i , z - 1, BlockRegistry.logs, f, 1);
            world.setBlock(x + 1, y + i , z, BlockRegistry.logs, f, 1);
            world.setBlock(x - 1, y + i , z, BlockRegistry.logs, f, 1);

        }
        for (int i = 5; i < 10; i++) {
            world.setBlock(x + 1, y + i , z + 1, BlockRegistry.leaves, f, 1);
            world.setBlock(x + 1, y + i , z - 1, BlockRegistry.leaves, f, 1);
            world.setBlock(x + 1, y + i , z + 1, BlockRegistry.leaves, f, 1);
            world.setBlock(x - 1, y + i , z + 1, BlockRegistry.leaves, f, 1);
            world.setBlock(x - 1, y + i , z + 1, BlockRegistry.leaves, f, 1);
            world.setBlock(x - 1, y + i , z - 1, BlockRegistry.leaves, f, 1);
            world.setBlock(x + 1, y + i , z - 1, BlockRegistry.leaves, f, 1);
            world.setBlock(x - 1, y + i , z - 1, BlockRegistry.leaves, f, 1);
            world.setBlock(x, y + i , z + 2, BlockRegistry.leaves, f, 1);
            world.setBlock(x, y + i , z - 2, BlockRegistry.leaves, f, 1);
            world.setBlock(x + 2, y + i , z, BlockRegistry.leaves, f, 1);
            world.setBlock(x - 2, y + i , z, BlockRegistry.leaves, f, 1);
        }
        world.setBlock(x, y + 11, z, BlockRegistry.leaves, f, 1);
        world.setBlock(x, y + 10, z + 1, BlockRegistry.leaves, f, 1);
        world.setBlock(x, y + 10, z - 1, BlockRegistry.leaves, f, 1);
        world.setBlock(x + 1, y + 10, z, BlockRegistry.leaves, f, 1);
        world.setBlock(x - 1, y + 10, z, BlockRegistry.leaves, f, 1);
    }

    public void generateRowan(World world, int x, int y, int z, Random rand) {
        int f = rand.nextInt(3);
        for (int i = 0; i < 11; i++) {
            world.setBlock(x, y + i , z, BlockRegistry.logs, f, 2);
        }
        for (int i = 4; i < 10; i++) {
            world.setBlock(x, y + i , z + 1, BlockRegistry.logs, f, 2);
            world.setBlock(x, y + i , z - 1, BlockRegistry.logs, f, 2);
            world.setBlock(x + 1, y + i , z, BlockRegistry.logs, f, 2);
            world.setBlock(x - 1, y + i , z, BlockRegistry.logs, f, 2);

        }
        for (int i = 5; i < 10; i++) {
            world.setBlock(x + 1, y + i , z + 1, BlockRegistry.leaves, f, 2);
            world.setBlock(x + 1, y + i , z - 1, BlockRegistry.leaves, f, 2);
            world.setBlock(x + 1, y + i , z + 1, BlockRegistry.leaves, f, 2);
            world.setBlock(x - 1, y + i , z + 1, BlockRegistry.leaves, f, 2);
            world.setBlock(x - 1, y + i , z + 1, BlockRegistry.leaves, f, 2);
            world.setBlock(x - 1, y + i , z - 1, BlockRegistry.leaves, f, 2);
            world.setBlock(x + 1, y + i , z - 1, BlockRegistry.leaves, f, 2);
            world.setBlock(x - 1, y + i , z - 1, BlockRegistry.leaves, f, 2);
            world.setBlock(x, y + i , z + 2, BlockRegistry.leaves, f, 2);
            world.setBlock(x, y + i , z - 2, BlockRegistry.leaves, f, 2);
            world.setBlock(x + 2, y + i , z, BlockRegistry.leaves, f, 2);
            world.setBlock(x - 2, y + i , z, BlockRegistry.leaves, f, 2);
        }
        world.setBlock(x, y + 11, z, BlockRegistry.leaves, f, 2);
        world.setBlock(x, y + 10, z + 1, BlockRegistry.leaves, f, 2);
        world.setBlock(x, y + 10, z - 1, BlockRegistry.leaves, f, 2);
        world.setBlock(x + 1, y + 10, z, BlockRegistry.leaves, f, 2);
        world.setBlock(x - 1, y + 10, z, BlockRegistry.leaves, f, 2);
    }

    public void generateAlder(World world, int x, int y, int z, Random rand) {
        int f = rand.nextInt(3);
        for (int i = 0; i < 11; i++) {
            world.setBlock(x, y + i , z, BlockRegistry.logs, f, 3);
        }
        for (int i = 4; i < 10; i++) {
            world.setBlock(x, y + i , z + 1, BlockRegistry.logs, f, 3);
            world.setBlock(x, y + i , z - 1, BlockRegistry.logs, f, 3);
            world.setBlock(x + 1, y + i , z, BlockRegistry.logs, f, 3);
            world.setBlock(x - 1, y + i , z, BlockRegistry.logs, f, 3);

        }
        for (int i = 5; i < 10; i++) {
            world.setBlock(x + 1, y + i , z + 1, BlockRegistry.leaves, f, 3);
            world.setBlock(x + 1, y + i , z - 1, BlockRegistry.leaves, f, 3);
            world.setBlock(x + 1, y + i , z + 1, BlockRegistry.leaves, f, 3);
            world.setBlock(x - 1, y + i , z + 1, BlockRegistry.leaves, f, 3);
            world.setBlock(x - 1, y + i , z + 1, BlockRegistry.leaves, f, 3);
            world.setBlock(x - 1, y + i , z - 1, BlockRegistry.leaves, f, 3);
            world.setBlock(x + 1, y + i , z - 1, BlockRegistry.leaves, f, 3);
            world.setBlock(x - 1, y + i , z - 1, BlockRegistry.leaves, f, 3);
            world.setBlock(x, y + i , z + 2, BlockRegistry.leaves, f, 3);
            world.setBlock(x, y + i , z - 2, BlockRegistry.leaves, f, 3);
            world.setBlock(x + 2, y + i , z, BlockRegistry.leaves, f, 3);
            world.setBlock(x - 2, y + i , z, BlockRegistry.leaves, f, 3);
        }
        world.setBlock(x, y + 11, z, BlockRegistry.leaves, f, 3);
        world.setBlock(x, y + 10, z + 1, BlockRegistry.leaves, f, 3);
        world.setBlock(x, y + 10, z - 1, BlockRegistry.leaves, f, 3);
        world.setBlock(x + 1, y + 10, z, BlockRegistry.leaves, f, 3);
        world.setBlock(x - 1, y + 10, z, BlockRegistry.leaves, f, 3);
    }
}
