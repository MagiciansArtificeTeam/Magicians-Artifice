package magiciansartifice.spells;

import magiciansartifice.spells.rituals.*;
import net.minecraftforge.common.MinecraftForge;

/**
 * Created by poppypoppop on 29/07/2014.
 */
public class Rituals {
    public static void initRituals() {
        MinecraftForge.EVENT_BUS.register(new RitualWaterCreation());
    }
}
