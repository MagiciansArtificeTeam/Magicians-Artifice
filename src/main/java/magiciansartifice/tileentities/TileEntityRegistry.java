package magiciansartifice.tileentities;

import cpw.mods.fml.common.registry.GameRegistry;
import magiciansartifice.libs.ModInfo;
import magiciansartifice.tileentities.machines.TileEntityMetalForge;
import magiciansartifice.tileentities.machines.TileEntityMysticAnvil;
import magiciansartifice.tileentities.machines.TileEntityWandCarver;

public class TileEntityRegistry {
    public static void registerTEs() {
        GameRegistry.registerTileEntity(TileEntityMetalForge.class, ModInfo.MODID + ":tileEntityMetalForge");
        GameRegistry.registerTileEntity(TileEntityMysticAnvil.class, ModInfo.MODID + ":tileEntityMysticAnvil");
        GameRegistry.registerTileEntity(TileEntityWandCarver.class, ModInfo.MODID + ":tileEntityWandCarver");
    }
}
