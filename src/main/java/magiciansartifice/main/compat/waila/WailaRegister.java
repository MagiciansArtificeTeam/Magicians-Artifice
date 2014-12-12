package magiciansartifice.main.compat.waila;

import magiciansartifice.main.blocks.machines.BlockMetalForge;
import magiciansartifice.main.blocks.magicblocks.BlockMagicDisguiseBlock;
import mcp.mobius.waila.api.IWailaRegistrar;

public class WailaRegister {

        public static void registerCallbacks(IWailaRegistrar registrar)
        {
            registrar.registerStackProvider(new DisguiseProvider(), BlockMagicDisguiseBlock.class);
            registrar.registerBodyProvider(new MetalForgeProvider(), BlockMetalForge.class);
        }

}
