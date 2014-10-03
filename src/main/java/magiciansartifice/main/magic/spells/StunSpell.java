package magiciansartifice.main.magic.spells;

import magiciansartifice.api.BasicSpell;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/**
 * Created by Mitchellbrine on 2014.
 */
public class StunSpell extends BasicSpell {

    @Override
    public void beginSpell(World world, int x, int y, int z, EntityPlayer player, Entity entity) {
        super.beginSpell(world, x, y, z, player, entity);
    }

    @Override
    public void performEffect(World world, int x, int y, int z, EntityPlayer player, Entity entity) {
        entity.getEntityData().setInteger("isBound",60);
        super.performEffect(world, x, y, z, player, entity);
    }
}
