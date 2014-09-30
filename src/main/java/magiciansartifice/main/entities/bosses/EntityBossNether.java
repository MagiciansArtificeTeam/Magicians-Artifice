package magiciansartifice.main.entities.bosses;

import net.minecraft.world.World;

@SuppressWarnings("static-access")
public class EntityBossNether extends EntityBossOverworld {
	public EntityBossNether(World world) {
		super(world);
		this.isImmuneToFire = true;
		this.spawningDimension = -1;
		
		this.dropMeta = 1;
	}
}
