package magiciansartifice.main.core.proxies;

import net.minecraft.world.World;

public class CommonProxy {

    public void load() {
        initRenderers();
        initSounds();
    }

    public void initSounds() {}

    public void initRenderers() {}

    public void flowerParticle(World world, double x, double y, double z, float hitX, float hitY, float hitZ, float size, int currentAmount) { flowerParticle(world, x, y, z, hitX, hitY, hitZ, size, currentAmount, false); }

    public void flowerParticle(World world, double x, double y, double z, float hitX, float hitY, float hitZ, float size, int currentAmount, boolean fake) {}
}
