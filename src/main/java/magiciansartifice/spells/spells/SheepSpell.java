package magiciansartifice.spells.spells;

import magiciansartifice.api.BasicSpell;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class SheepSpell extends BasicSpell{

    public void beginSpell(World world, int x, int y, int z, EntityPlayer player, EntityLivingBase entity) {
        System.err.println("Do the shit");
        super.beginSpell(world, x, y, z, player, entity);
    }

    public void performEffect(World world, int x, int y, int z, EntityPlayer player, EntityLivingBase entity) {
        super.performEffect(world,x,y,z,player,entity);
    }

}
