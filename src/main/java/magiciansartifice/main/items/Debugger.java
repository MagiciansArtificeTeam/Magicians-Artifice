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
	public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                world.setBlock(x - 5 + j, y, z - 5 + i, BlockRegistry.merlinscircle);
            }
        }
        return false;
    }
}