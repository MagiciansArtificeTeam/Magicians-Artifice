package magiciansartifice.main.magic.spells;

import magiciansartifice.api.BasicSpell;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import java.util.Random;

public class HurtSpell extends BasicSpell {

    Random random = new Random();

    @Override
    public void beginSpell(World world, int x, int y, int z, EntityPlayer player, EntityLivingBase entity) {
        super.beginSpell(world, x, y, z, player, entity);
    }

    @Override
    public void performEffect(World world, int x, int y, int z, EntityPlayer player, EntityLivingBase entity) {
        entity.attackEntityFrom(DamageSource.causeIndirectMagicDamage(player,entity),0.025F);
        if (random.nextInt(100) >= 50) {
            super.performEffect(world, x, y, z, player, entity);
        }
        if (entity instanceof EntityPlayer) {
            world.playSoundAtEntity(entity,"random.fizz",1.0F,1.0F);
        }
    }
}
