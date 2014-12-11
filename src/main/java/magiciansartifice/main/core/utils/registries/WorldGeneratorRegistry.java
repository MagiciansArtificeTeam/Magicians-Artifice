package magiciansartifice.main.core.utils.registries;

import cpw.mods.fml.common.registry.GameRegistry;
import magiciansartifice.main.core.world.GenerationHandler;
import magiciansartifice.main.core.world.WorldGenStructureObelisk;
import magiciansartifice.main.core.world.WorldGenStructureRuins;
import magiciansartifice.main.core.world.WorldGenTree;

/**
 * Created by poppypoppop on 2/10/2014.
 */
public class WorldGeneratorRegistry {
    public static void registerWorldGens() {
        GameRegistry.registerWorldGenerator(new GenerationHandler(), 8);
        GameRegistry.registerWorldGenerator(new WorldGenStructureObelisk(), 8);
        GameRegistry.registerWorldGenerator(new WorldGenTree(), 8);
        //GameRegistry.registerWorldGenerator(new WorldGenStructureRuins(), 8);
    }
}
