package magiciansartifice.main.magic.spells;

import magiciansartifice.api.BasicSpell;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class DeathSpell extends BasicSpell {

    public void beginSpell(World world, int x, int y, int z, EntityPlayer player, EntityLivingBase entity) {
        super.beginSpell(world, x, y, z, player, entity);
    }

    public void performEffect(World world, int x, int y, int z, EntityPlayer player, EntityLivingBase entity) {
        if (!(entity instanceof IBossDisplayData)) {
            entity.setHealth(0.0F);
        }
        super.performEffect(world, x, y, z, player, entity);
    }

}
