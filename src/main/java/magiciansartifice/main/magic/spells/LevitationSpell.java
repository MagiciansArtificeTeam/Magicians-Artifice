package magiciansartifice.main.magic.spells;

import magiciansartifice.api.BasicSpell;
import magiciansartifice.main.core.libs.ModInfo;
import magiciansartifice.main.core.utils.PlayerHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import java.util.Random;

public class LevitationSpell extends BasicSpell{

    Random random = new Random();

    public void beginSpell(World world, int x, int y, int z, EntityPlayer player, Entity entity) {
        super.beginSpell(world, x, y, z, player, entity);
    }

    public void performEffect(World world, int x, int y, int z, EntityPlayer player, Entity entity) {
        if (player.isSneaking()) {
            entity.motionY = 0.1;
            entity.fallDistance = 0.0F;
        } else {
            entity.motionY += 0.4;
            entity.fallDistance = 0.0F;
        }
        if (random.nextInt(100) >= 75) {
            super.performEffect(world, x, y, z, player, entity);
        }
    }
}
