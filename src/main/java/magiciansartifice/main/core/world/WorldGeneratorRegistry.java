package magiciansartifice.main.core.world;

import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Created by poppypoppop on 2/10/2014.
 */
public class WorldGeneratorRegistry {
    public static void registerWorldGens() {
        GameRegistry.registerWorldGenerator(new GenerationHandler(), 8);
        GameRegistry.registerWorldGenerator(new WorldGenStructureObelisk(), 1);
    }
}
