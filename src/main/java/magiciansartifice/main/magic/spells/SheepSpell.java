package magiciansartifice.main.magic.spells;

import magiciansartifice.api.BasicSpell;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import java.util.Random;

public class SheepSpell extends BasicSpell{

    public void beginSpell(World world, int x, int y, int z, EntityPlayer player, EntityLivingBase entity) {
        if (entity instanceof EntitySheep) {
            super.beginSpell(world, x, y, z, player, entity);
        }
    }

    public void performEffect(World world, int x, int y, int z, EntityPlayer player, EntityLivingBase entity) {
        EntitySheep sheep = (EntitySheep) entity;
        int sheepColor = sheep.getFleeceColor() + 1;
        if (sheepColor == 16) {
            sheep.setFleeceColor(0);
        } else {
            sheep.setFleeceColor(sheepColor);
        }
        super.performEffect(world,x,y,z,player,entity);
    }

}
