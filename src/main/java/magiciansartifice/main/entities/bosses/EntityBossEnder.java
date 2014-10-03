package magiciansartifice.main.entities.bosses;

import magiciansartifice.main.items.ItemRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

@SuppressWarnings("static-access")
public class EntityBossEnder extends EntityBossBase {
	public EntityBossEnder(World world) {
		super(world);
		this.getNavigator().setCanSwim(false);
		this.spawningDimension = 1;
		
		this.dropMeta = 2;
		this.secondDrop = new ItemStack(ItemRegistry.beastClawsClaw);
	}
}
