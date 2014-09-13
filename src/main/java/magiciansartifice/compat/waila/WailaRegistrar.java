package magiciansartifice.compat.waila;

import magiciansartifice.blocks.machines.BlockMetalForge;
import mcp.mobius.waila.api.IWailaRegistrar;

/**
 * Created by James Hollowell on 8/12/2014.
 */
public class WailaRegistrar
{
    @SuppressWarnings("unused")
    public static void registerCallbacks(IWailaRegistrar registrar)
    {
        registrar.registerBodyProvider(new MetalForgeProvider(), BlockMetalForge.class);
    }
}
