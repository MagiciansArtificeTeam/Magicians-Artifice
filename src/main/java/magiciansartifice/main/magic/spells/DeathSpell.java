package magiciansartifice.main.magic.spells;

import magiciansartifice.api.BasicSpell;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class DeathSpell extends BasicSpell {

    public void beginSpell(World world, int x, int y, int z, EntityPlayer player, EntityLivingBase entity) {
        super.beginSpell(world, x, y, z, player, entity);
    }

    public void performEffect(World world, int x, int y, int z, EntityPlayer player, EntityLivingBase entity) {
        entity.attackEntityFrom(DamageSource.causeIndirectMagicDamage(entity,player),100.0F);
        super.performEffect(world, x, y, z, player, entity);
    }

}
