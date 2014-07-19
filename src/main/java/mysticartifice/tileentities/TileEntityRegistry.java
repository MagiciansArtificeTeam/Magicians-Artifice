package mysticartifice.tileentities;

import cpw.mods.fml.common.registry.GameRegistry;
import mysticartifice.ModInfo;

public class TileEntityRegistry {
    public static void registerTEs() {
        GameRegistry.registerTileEntity(TileEntityMetalForge.class, ModInfo.MODID + ":tileEntityMetalForge");
    }
}
