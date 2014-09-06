package magiciansartifice.main.tileentities;

import cpw.mods.fml.common.registry.GameRegistry;
import magiciansartifice.main.core.libs.ModInfo;
import magiciansartifice.main.tileentities.machines.*;
import magiciansartifice.main.tileentities.magic.*;

public class TileEntityRegistry {
    public static void registerTEs() {
    	GameRegistry.registerTileEntity(TileEntityWandCarver.class, ModInfo.MODID + ":tileEntityWandCarver");
        GameRegistry.registerTileEntity(TileEntityMetalForge.class, ModInfo.MODID + ":tileEntityMetalForge");
        GameRegistry.registerTileEntity(TileEntityMysticAnvil.class, ModInfo.MODID + ":tileEntityMysticAnvil");
        GameRegistry.registerTileEntity(TileEntityRitualCornerstone.class, ModInfo.MODID + ":tileEntityCornerstone");
        GameRegistry.registerTileEntity(TileEntityTeleportReciever.class, ModInfo.MODID + ":tileEntityTeleportReciever");
        GameRegistry.registerTileEntity(TileEntityContainmentCornerstone.class, ModInfo.MODID + ":tileEntityContainmentCornerstone");
    }
}
