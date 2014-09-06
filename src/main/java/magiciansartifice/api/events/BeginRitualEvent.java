package magiciansartifice.api.events;

import magiciansartifice.api.BasicRitual;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerEvent;

public class BeginRitualEvent extends PlayerEvent {

    public BasicRitual ritual;
    public int x;
    public int y;
    public int z;
    public World world;
    public boolean areBlocksRight;

    public BeginRitualEvent(BasicRitual ritual, int x, int y, int z, World world, EntityPlayer player,boolean areAllBlocksThere) {
        super(player);
        this.ritual = ritual;
        this.x = x;
        this.y = y;
        this.z = z;
        this.world = world;
        this.areBlocksRight = areAllBlocksThere;
    }
}
