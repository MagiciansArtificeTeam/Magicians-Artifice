package magiciansartifice.main.items;

import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.blocks.BlockRegistry;
import magiciansartifice.main.core.libs.ModInfo;
import net.minecraft.entity.player.EntityPlayer;
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
	public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
    {
		buildTower(x,y,z,world);
        return false;
    }
	
	private void buildTower(int x, int y, int z, World world) {
		int x1 = x;
		int y1 = y;
		int z1 = z;
		{
			x -= 1;
			z -= 1;
			for (int i = 0; i < 3; i++) {
				for (int ii = 0; ii < 3; ii++) {
					world.setBlock(x1 + ii, y1, z1 + i, BlockRegistry.planks, 0, 1);
				}
			}
		}
	}
}
