package magiciansartifice.main.items;

import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.blocks.BlockRegistry;
import magiciansartifice.main.core.libs.ModInfo;
import magiciansartifice.main.core.world.WorldGenStructureRuins;
import magiciansartifice.main.tileentities.magic.TileEntityMerlinCircle;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Random;

public class Debugger extends Item {
    Random rand = new Random();
    public static ArrayList<Item> solidBlocks = new ArrayList<Item>();
    public static ArrayList<Item> nonSolidBlocks = new ArrayList<Item>();

	public Debugger() {
		super();
		this.setCreativeTab(MagiciansArtifice.tab);
		this.setUnlocalizedName("debugger");
		this.setTextureName(ModInfo.MODID + ":debugger");
		ItemRegistry.items.add(this);
        assignItems();
	}

    private void assignItems() {
        for (int i = 0; i <= 3; i++) {
            solidBlocks.add(new ItemStack(Blocks.stonebrick, 1, i).getItem());
        }
        solidBlocks.add(Item.getItemFromBlock(Blocks.cobblestone));
        solidBlocks.add(Item.getItemFromBlock(Blocks.gravel));
        solidBlocks.add(Item.getItemFromBlock(Blocks.mossy_cobblestone));
        nonSolidBlocks.add(new ItemStack(Blocks.stone_slab, 1, 3).getItem());
        nonSolidBlocks.add(new ItemStack(Blocks.stone_slab, 1, 5).getItem());
        for (int i = 0; i <= 3; i++) {
            nonSolidBlocks.add(new ItemStack(Blocks.stone_brick_stairs, 1, i).getItem());
        }
        for (int i = 0; i <= 3; i++) {
            nonSolidBlocks.add(new ItemStack(Blocks.stone_stairs, 1, i).getItem());
        }
    }

    @Override
	public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
        if (player.isSneaking()) reverseEffect(world, x, y, z);
        else doEffect(world, x, y, z);
        return false;
    }

    private void doEffect(World world, int x, int y, int z) {
        spawnBase(world, x, y, z, Blocks.stonebrick);
        crumbleBase(world, x, y, z);
    }

    private void reverseEffect(World world, int x, int y, int z) {
        spawnBase(world, x, y, z, Blocks.grass);
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

    private void crumbleBase(World world, int x, int y, int z) {
        int x1 = x - 6;
        int z1 = z - 6;
        for (int i = 0; i < 13; i++) {
            for (int ii = 0; i < 13; i++) {
                if (!(world.getBlock(x, y, z) == Blocks.stonebrick)) {
                    boolean doSolid = rand.nextBoolean();
                    if (!doSolid) {
                        doSolid = rand.nextBoolean();
                        if (!doSolid) {
                            doSolid = rand.nextBoolean();
                        }
                    }
                    int chance = rand.nextInt(100);
                    if (chance >= 80) {
                        if (doSolid) doSolid(world, x1 + ii, y, z1 + i);
                        else doNonSolid(world, x1 + ii, y, z1 + i);
                    }
                }
            }
        }
    }

    private void doNonSolid(World world, int x, int y, int z) {
        int random = rand.nextInt(nonSolidBlocks.size() + 1);
        world.setBlock(x, y, z, Block.getBlockFromItem(nonSolidBlocks.get(random)));
    }

    private void doSolid(World world, int x, int y, int z) {
        int random = rand.nextInt(solidBlocks.size() + 1);
        world.setBlock(x, y, z, Block.getBlockFromItem(solidBlocks.get(random)));
    }
}