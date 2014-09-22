package magiciansartifice.main.magic.spells;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import magiciansartifice.api.BasicSpell;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEvent;

/**
 * Created by Mitchellbrine on 2014.
 */
public class BodyBindSpell extends BasicSpell {

    public BodyBindSpell() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public void performEffect(World world, int x, int y, int z, EntityPlayer player, Entity entity) {
        if (entity.getEntityData().hasKey("isBound")) {
            int bindTime = entity.getEntityData().getInteger("isBound");
            if (bindTime > 0) {
                entity.getEntityData().setInteger("isBound",0);
            } else {
                entity.getEntityData().setInteger("isBound",1200);
            }
            super.performEffect(world, x, y, z, player, entity);
        } else {
            entity.getEntityData().setInteger("isBound",1200);
            super.performEffect(world, x, y, z, player, entity);
        }
    }

    @Override
    public void beginSpell(World world, int x, int y, int z, EntityPlayer player, Entity entity) {
        super.beginSpell(world, x, y, z, player, entity);
    }

    @SubscribeEvent
    public void livingUpdate(LivingEvent.LivingUpdateEvent event) {
        if (event.entityLiving.getEntityData().hasKey("isBound")) {
            int bindTime = event.entityLiving.getEntityData().getInteger("isBound");
            if (bindTime > 0) {
                event.entityLiving.motionX = 0;
                event.entityLiving.motionZ = 0;
                event.entityLiving.getEntityData().setInteger("isBound",bindTime-1);
            }
        }
    }
}
