package magiciansartifice.main.compat.waila;

import magiciansartifice.main.blocks.machines.BlockMetalForge;
import mcp.mobius.waila.api.IWailaRegistrar;

public class WailaRegister {

        public static void registerCallbacks(IWailaRegistrar registrar)
        {
            registrar.registerBodyProvider(new MetalForgeProvider(), BlockMetalForge.class);
        }

}
