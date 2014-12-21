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
import net.minecraft.item.ItemSimpleFoiled;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.Random;

public class Debugger extends ItemSimpleFoiled {
    Random rand = new Random();

	public Debugger() {
		super();
		this.setCreativeTab(MagiciansArtifice.tab);
		this.setUnlocalizedName("debugger");
		this.setTextureName(ModInfo.MODID + ":debugger");
		ItemRegistry.items.add(this);
        Arrays.assignCrumblingItems();
	}

	public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
        if (player.isSneaking()) reverseEffect(world, x, y, z);
        else doEffect(world, x, y, z);
        return false;
    }

    private void doEffect(World world, int x, int y, int z) {
        int x1 = x-5;
        int z1 = z-5;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                world.setBlock(x1 + i, y, z1 + j, BlockRegistry.merlinscircle);
            }
        }
        /**spawnBase(world, x, y, z, Blocks.stonebrick);
        spawnTowers(rand, world, x, y, z, BlockRegistry.ruinPillar);
        crumbleBase(world, x, y, z, rand);
        world.setBlock(x, y + 1, z, BlockRegistry.pedestal);**/
    }

    private void reverseEffect(World world, int x, int y, int z) {
        int x1 = x-5;
        int z1 = z-5;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                world.setBlock(x1 + i, y, z1 + j, Blocks.grass);
            }
        }
        /**spawnBase(world, x, y, z, Blocks.grass);
        spawnTowers(rand, world, x, y, z, Blocks.air);**/
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

    private void spawnTowers(Random rand, World world, int x, int y, int z, Block block) {
        int x1 = x;
        int y1 = y;
        int z1 = z - 6;
        int randNum = rand.nextInt(2) + 5;

        for (int i = 0; i < randNum; i++) {
            world.setBlock(x1, y1 + i, z1, block);
        }
        world.setBlock(x1, y1 + randNum, z1, Blocks.stonebrick, 3, 3);
        x1 -= 4;
        z1 += 2;
        randNum = rand.nextInt(2) + 5;
        for (int i = 0; i < randNum; i++) {
            world.setBlock(x1, y1 + i, z1, block);
        }
        world.setBlock(x1, y1 + randNum, z1, Blocks.stonebrick, 3, 3);
        x1 += 8;
        randNum = rand.nextInt(2) + 5;
        for (int i = 0; i < randNum; i++) {
            world.setBlock(x1, y1 + i, z1, block);
        }
        world.setBlock(x1, y1 + randNum, z1, Blocks.stonebrick, 3, 3);
        x1 -= 10;
        z1 += 4;
        randNum = rand.nextInt(2) + 5;
        for (int i = 0; i < randNum; i++) {
            world.setBlock(x1, y1 + i, z1, block);
        }
        world.setBlock(x1, y1 + randNum, z1, Blocks.stonebrick, 3, 3);
        x1 += 12;
        randNum = rand.nextInt(2) + 5;
        for (int i = 0; i < randNum; i++) {
            world.setBlock(x1, y1 + i, z1, block);
        }
        world.setBlock(x1, y1 + randNum, z1, Blocks.stonebrick, 3, 3);
        x1 -= 10;
        z1 += 4;
        randNum = rand.nextInt(2) + 5;
        for (int i = 0; i < randNum; i++) {
            world.setBlock(x1, y1 + i, z1, block);
        }
        world.setBlock(x1, y1 + randNum, z1, Blocks.stonebrick, 3, 3);
        x1 += 8;
        randNum = rand.nextInt(2) + 5;
        for (int i = 0; i < randNum; i++) {
            world.setBlock(x1, y1 + i, z1, block);
        }
        world.setBlock(x1, y1 + randNum, z1, Blocks.stonebrick, 3, 3);
        x1 -= 4;
        z1 += 2;
        randNum = rand.nextInt(2) + 5;
        for (int i = 0; i < randNum; i++) {
            world.setBlock(x1, y1 + i, z1, block);
        }
        world.setBlock(x1, y1 + randNum, z1, Blocks.stonebrick, 3, 3);
    }

    private static void crumbleBase(World world, int x, int y, int z, Random rand) {
        int x1 = x - 6;
        int y1 = y;
        int z1 = z - 6;
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 13; j++) {
                if (world.getBlock(x1 + j, y1, z1 + i).equals(Blocks.stonebrick)) {
                    int chance = rand.nextInt(100);
                    int percentage = rand.nextInt(100);
                    if (chance >= 25) {
                        if (percentage >= 30) doSolid(world, x1 + j, y1, z1 + i, rand);
                        else doNonSolid(world, x1 + j, y1, z1 + i, rand);
                    }
                }
            }
        }
    }

    private static void doNonSolid(World world, int x, int y, int z, Random rand) {
        int random = rand.nextInt(Arrays.nonSolidBlocks.size());
        int metadata = Arrays.nonSolidBlocks.get(random).getItem().getDamage(Arrays.nonSolidBlocks.get(random));
        world.setBlock(x, y, z, Block.getBlockFromItem(Arrays.nonSolidBlocks.get(random).getItem()), metadata, 1);
    }

    private static void doSolid(World world, int x, int y, int z, Random rand) {
        int random = rand.nextInt(Arrays.solidBlocks.size());
        int metadata = Arrays.nonSolidBlocks.get(random).getItem().getDamage(Arrays.nonSolidBlocks.get(random));
        world.setBlock(x, y, z, Block.getBlockFromItem(Arrays.solidBlocks.get(random).getItem()), metadata, 1);
    }
}