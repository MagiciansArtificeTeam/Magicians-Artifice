package magiciansartifice.main.entities.bosses;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.world.World;

public class EntityBossOverworld extends EntityLiving implements IBossDisplayData {

	public EntityBossOverworld(World world) {
		super(world);
	}
}
