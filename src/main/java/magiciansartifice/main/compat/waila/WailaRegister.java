package magiciansartifice.main.compat.waila;

import magiciansartifice.main.blocks.machines.BlockMetalForge;
import magiciansartifice.main.blocks.magicblocks.BlockRitualCornerstone;
import mcp.mobius.waila.api.IWailaRegistrar;

public class WailaRegister {

        @SuppressWarnings("unused")
        public static void registerCallbacks(IWailaRegistrar registrar)
        {
            registrar.registerBodyProvider(new CornerstoneProvider(), BlockRitualCornerstone.class);
            registrar.registerBodyProvider(new MetalForgeProvider(), BlockMetalForge.class);
        }

}
