package magiciansartifice.main.entities.bosses;

import magiciansartifice.main.core.utils.registries.ItemRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityBossOverworld extends EntityBossBase {
	public static int spawningDimension = 0;
	private ItemStack drop;
	public static int dropMeta;
	public ItemStack secondDrop;
	
	public EntityBossOverworld(World world) {
		super(world);
        dropMeta = 0;
        
        this.drop = new ItemStack(ItemRegistry.dustsMeta, dropMeta, 1);
        this.secondDrop = new ItemStack(ItemRegistry.angelFeather, 1, 2);
	}
}
