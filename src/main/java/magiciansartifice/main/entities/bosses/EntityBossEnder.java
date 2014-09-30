package magiciansartifice.main.entities.bosses;

import net.minecraft.world.World;

@SuppressWarnings("static-access")
public class EntityBossEnder extends EntityBossOverworld {
	public EntityBossEnder(World world) {
		super(world);
		this.getNavigator().setCanSwim(false);
		this.spawningDimension = 1;
	}
}
