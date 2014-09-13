package magiciansartifice.main.magic.spells;

import magiciansartifice.api.BasicSpell;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class SheepSpell extends BasicSpell{

    public void beginSpell(World world, int x, int y, int z, EntityPlayer player, EntityLivingBase entity) {
        if (entity instanceof EntitySheep) {
            super.beginSpell(world, x, y, z, player, entity);
        }
    }

    public void performEffect(World world, int x, int y, int z, EntityPlayer player, EntityLivingBase entity) {
        System.err.println("This started!");
        EntitySheep sheep = (EntitySheep) entity;

        int sheepColor = (sheep.getDataWatcher().getWatchableObjectByte(16) & 15) + 1;
        byte b0 = sheep.getDataWatcher().getWatchableObjectByte(16);
        if (sheepColor == 16) {
            sheep.getDataWatcher().updateObject(16, Byte.valueOf((byte)(b0 & 240 | 0 & 15)));
            super.performEffect(world,x,y,z,player);
        } else {
            sheep.getDataWatcher().updateObject(16, Byte.valueOf((byte)(b0 & 240 | sheepColor & 15)));
            super.performEffect(world,x,y,z,player);
        }
    }

}
