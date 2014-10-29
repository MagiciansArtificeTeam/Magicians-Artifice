package magiciansartifice.main.magic.spells;

import magiciansartifice.api.BasicSpell;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import java.util.Random;

public class HealSpell extends BasicSpell {

    @Override
    public void beginSpell(World world, int x, int y, int z, EntityPlayer player) {
        super.beginSpell(world, x, y, z, player);
    }

    @Override
    public void performEffect(World world, int x, int y, int z, EntityPlayer player) {
        float difference = player.getMaxHealth() - player.getHealth();
        if (!player.capabilities.isCreativeMode && difference > 0) {
            Random random = new Random();
            float newHealth = random.nextInt(Math.round(difference));
            if (player.getHealth() < player.getMaxHealth() - 1f) {
                player.setHealth(player.getHealth() + newHealth);
            } else {
                player.setHealth(player.getMaxHealth());
            }
        }
    }
}
