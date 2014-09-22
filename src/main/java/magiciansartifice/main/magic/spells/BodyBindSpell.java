package magiciansartifice.main.magic.spells;

import magiciansartifice.api.BasicSpell;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/**
 * Created by Mitchellbrine on 2014.
 */
public class BodyBindSpell extends BasicSpell {

    @Override
    public void performEffect(World world, int x, int y, int z, EntityPlayer player, Entity entity) {
        if (entity.getEntityData().hasKey("isBinded")) {
            int bindTime = entity.getEntityData().getInteger("isBinded");
            if (bindTime > 0) {
                entity.getEntityData().setInteger("isBinded",0);
            } else {
                entity.getEntityData().setInteger("isBinded",1200);
            }
            super.performEffect(world, x, y, z, player, entity);
        }
    }

    @Override
    public void beginSpell(World world, int x, int y, int z, EntityPlayer player, Entity entity) {
        super.beginSpell(world, x, y, z, player, entity);
    }
}
