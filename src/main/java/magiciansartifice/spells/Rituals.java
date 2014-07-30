package magiciansartifice.spells;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import magiciansartifice.blocks.BlockRegistry;
import magiciansartifice.spells.rituals.RitualWaterCreation;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

/**
 * Created by poppypoppop on 29/07/2014.
 */
public class Rituals {
    public static void initRituals() {
        MinecraftForge.EVENT_BUS.register(new RitualWaterCreation());
    }
}
