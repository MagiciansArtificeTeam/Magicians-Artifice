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

public class Debugger extends Item {
	public Debugger() {
		super();
		this.setCreativeTab(MagiciansArtifice.tab);
		this.setUnlocalizedName("debugger");
		this.setTextureName(ModInfo.MODID + ":debugger");
		ItemRegistry.items.add(this);
	}
	
	@Override
	public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
        if (player.isSneaking()) reverseEffect(world, x, y, z);
        else doEffect(world, x, y, z);
        return false;
    }

    private void doEffect(World world, int x, int y, int z) {
        Block block = Blocks.stonebrick;
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
    }

    private void reverseEffect(World world, int x, int y, int z) {
        Block block = Blocks.grass;
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
    }
}