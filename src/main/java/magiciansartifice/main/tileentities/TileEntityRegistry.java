package magiciansartifice.main.tileentities;

import cpw.mods.fml.common.registry.GameRegistry;
import magiciansartifice.main.core.libs.ModInfo;
import magiciansartifice.main.tileentities.machines.TileEntityMetalForge;
import magiciansartifice.main.tileentities.machines.TileEntityMysticAnvil;
import magiciansartifice.main.tileentities.machines.TileEntityWandCarver;
import magiciansartifice.main.tileentities.magic.TileEntityRitualCornerstone;
import magiciansartifice.main.tileentities.magic.TileEntityTeleportReciever;

public class TileEntityRegistry {
    public static void registerTEs() {
        GameRegistry.registerTileEntity(TileEntityMetalForge.class, ModInfo.MODID + ":tileEntityMetalForge");
        GameRegistry.registerTileEntity(TileEntityMysticAnvil.class, ModInfo.MODID + ":tileEntityMysticAnvil");
        GameRegistry.registerTileEntity(TileEntityWandCarver.class, ModInfo.MODID + ":tileEntityWandCarver");
        GameRegistry.registerTileEntity(TileEntityRitualCornerstone.class, ModInfo.MODID + ":tileEntityCornerstone");
        GameRegistry.registerTileEntity(TileEntityTeleportReciever.class, ModInfo.MODID + ":tileEntityTeleportReciever");
    }
}
