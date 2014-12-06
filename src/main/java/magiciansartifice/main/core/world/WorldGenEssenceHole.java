package magiciansartifice.main.core.world;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.oredict.OreDictionary;

public class WorldGenEssenceHole extends WorldGenerator {
    public static ArrayList<Item> blockBlackList = new ArrayList<Item>();
	public Block block;
	
	public WorldGenEssenceHole(Block a_block, int number) {
        super(false);
        this.block = a_block;
        blockBlackList.add(Item.getItemFromBlock(Blocks.water));
        blockBlackList.add(Item.getItemFromBlock(Blocks.leaves));
        blockBlackList.add(Item.getItemFromBlock(Blocks.leaves2));
        for (int i = 0; i < OreDictionary.getOres("treeLeaves").size(); i++) {
            blockBlackList.add(OreDictionary.getOres("treeLeaves").get(i).getItem());
        }
    }
	
	@Override
	public boolean generate(World world, Random rand, int x, int y, int z) {
		int randomNum = rand.nextInt(11);
		if (randomNum >= 9 && canPlaceHere(world, x, y, z)) { world.setBlock(x, y, z, this.block); }
        return true;
	}

    private boolean canPlaceHere(World world, int x, int y, int z) {
        for (Item item : blockBlackList) {
            if (Item.getItemFromBlock(world.getBlock(x, y - 1, z)) == item) return false;
        }

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if(world.getTileEntity(x + j, y + i, z + k) != null) return false;
                }
            }
        }
        return true;
    }
}