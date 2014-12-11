package magiciansartifice.main.items;

import magiciansartifice.api.utils.Arrays;
import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.core.utils.registries.BlockRegistry;
import magiciansartifice.main.core.libs.ModInfo;
import magiciansartifice.main.core.utils.registries.ItemRegistry;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.Random;

public class Debugger extends Item {
    Random rand = new Random();

	public Debugger() {
		super();
		this.setCreativeTab(MagiciansArtifice.tab);
		this.setUnlocalizedName("debugger");
		this.setTextureName(ModInfo.MODID + ":debugger");
		ItemRegistry.items.add(this);
        Arrays.assignCrumblingItems();
	}

    @Override
	public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
        if (player.isSneaking()) reverseEffect(world, x, y, z);
        else doEffect(world, x, y, z);
        return false;
    }

    private void doEffect(World world, int x, int y, int z) {
        spawnBase(world, x, y, z, Blocks.stonebrick);
        spawnTowers(world, x, y, z, Blocks.stonebrick);
        crumbleBase(world, x, y, z);
        crumbleTowers(world, x, y, z);
        world.setBlock(x, y + 1, z, BlockRegistry.pedestal);
    }

    private void reverseEffect(World world, int x, int y, int z) {
        spawnBase(world, x, y, z, Blocks.grass);
        spawnTowers(world, x, y, z, Blocks.air);
    }

    private void spawnBase(World world, int x, int y, int z, Block block) {
        int x1 = x;
        int y1 = y;
        int z1 = z - 6;

        world.setBlock(x1, y1, z1, block);
        z1 += 1;
        x1 -= 2;
        for (int i = 0; i <= 4; i++) {
            world.setBlock(x1 + i, y1, z1, block);
        }
        z1 += 1;
        x1 -= 2;
        for (int i = 0; i <= 8; i++) {
            world.setBlock(x1 + i, y1, z1, block);
        }
        z1 += 1;
        for (int i = 0; i <= 8; i++) {
            world.setBlock(x1 + i, y1, z1, block);
        }
        z1 += 1;
        x1 -= 1;
        for (int i = 0; i <= 10; i++) {
            world.setBlock(x1 + i, y1, z1, block);
        }
        z1 += 1;
        for (int i = 0; i <= 10; i++) {
            world.setBlock(x1 + i, y1, z1, block);
        }
        z1 += 1;
        x1 -= 1;
        for (int i = 0; i <= 12; i++) {
            world.setBlock(x1 + i, y1, z1, block);
        }
        z1 += 1;
        x1 += 1;
        for (int i = 0; i <= 10; i++) {
            world.setBlock(x1 + i, y1, z1, block);
        }
        z1 += 1;
        for (int i = 0; i <= 10; i++) {
            world.setBlock(x1 + i, y1, z1, block);
        }
        z1 += 1;
        x1 += 1;
        for (int i = 0; i <= 8; i++) {
            world.setBlock(x1 + i, y1, z1, block);
        }
        z1 += 1;
        for (int i = 0; i <= 8; i++) {
            world.setBlock(x1 + i, y1, z1, block);
        }
        z1 += 1;
        x1 += 2;
        for (int i = 0; i <= 4; i++) {
            world.setBlock(x1 + i, y1, z1, block);
        }
        z1 += 1;
        x1 += 2;
        world.setBlock(x1, y1, z1, block);
    }

    private void spawnTowers(World world, int x, int y, int z, Block block) {
        int x1 = x;
        int y1 = y;
        int z1 = z - 6;

        for (int i = 0; i < 5; i++) {
            world.setBlock(x1, y1 + i, z1, block);
        }
        world.setBlock(x1, y1 + 5, z1, Blocks.stonebrick, 3, 1);
        x1 -= 4;
        z1 += 2;
        for (int i = 0; i < 5; i++) {
            world.setBlock(x1, y1 + i, z1, block);
        }
        world.setBlock(x1, y1 + 5, z1, Blocks.stonebrick, 3, 1);
        x1 += 8;
        for (int i = 0; i < 5; i++) {
            world.setBlock(x1, y1 + i, z1, block);
        }
        world.setBlock(x1, y1 + 5, z1, Blocks.stonebrick, 3, 1);
        x1 -= 10;
        z1 += 4;
        for (int i = 0; i < 5; i++) {
            world.setBlock(x1, y1 + i, z1, block);
        }
        world.setBlock(x1, y1 + 5, z1, Blocks.stonebrick, 3, 1);
        x1 += 12;
        for (int i = 0; i < 5; i++) {
            world.setBlock(x1, y1 + i, z1, block);
        }
        world.setBlock(x1, y1 + 5, z1, Blocks.stonebrick, 3, 1);
        x1 -= 10;
        z1 += 4;
        for (int i = 0; i < 5; i++) {
            world.setBlock(x1, y1 + i, z1, block);
        }
        world.setBlock(x1, y1 + 5, z1, Blocks.stonebrick, 3, 1);
        x1 += 8;
        for (int i = 0; i < 5; i++) {
            world.setBlock(x1, y1 + i, z1, block);
        }
        world.setBlock(x1, y1 + 5, z1, Blocks.stonebrick, 3, 1);
        x1 -= 4;
        z1 += 2;
        for (int i = 0; i < 5; i++) {
            world.setBlock(x1, y1 + i, z1, block);
        }
        world.setBlock(x1, y1 + 5, z1, Blocks.stonebrick, 3, 1);
    }

    private void crumbleBase(World world, int x, int y, int z) {
        int x1 = x - 6;
        int y1 = y;
        int z1 = z - 6;
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 13; j++) {
                if (world.getBlock(x1 + j, y1, z1 + i).equals(Blocks.stonebrick)) {
                    int chance = rand.nextInt(100);
                    int percentage = rand.nextInt(100);
                    if (chance >= 25) {
                        if (percentage >= 30) doSolid(world, x1 + j, y1, z1 + i);
                        else doNonSolid(world, x1 + j, y1, z1 + i);
                    }
                }
            }
        }
    }

    private void crumbleTowers(World world, int x, int y, int z) {
        int x1 = x - 6;
        int y1 = y + 1;
        int z1 = z - 6;
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 13; j++) {
                for (int k = 0; k < 4; k++) {
                    if (world.getBlock(x1 + j, y1 + k, z1 + i).equals(Blocks.stonebrick)) {
                        int chance = rand.nextInt(100);
                        if (chance >= 25) {
                            doSolid(world, x1 + j, y1 + k, z1 + i);
                        }
                    }
                }
            }
        }
    }

    private void doNonSolid(World world, int x, int y, int z) {
        int random = rand.nextInt(Arrays.nonSolidBlocks.size());
        int metadata = Arrays.nonSolidBlocks.get(random).getItem().getDamage(Arrays.nonSolidBlocks.get(random));
        world.setBlock(x, y, z, Block.getBlockFromItem(Arrays.nonSolidBlocks.get(random).getItem()), metadata, 1);
    }

    private void doSolid(World world, int x, int y, int z) {
        int random = rand.nextInt(Arrays.solidBlocks.size());
        int metadata = Arrays.nonSolidBlocks.get(random).getItem().getDamage(Arrays.nonSolidBlocks.get(random));
        world.setBlock(x, y, z, Block.getBlockFromItem(Arrays.solidBlocks.get(random).getItem()), metadata, 1);
    }
}