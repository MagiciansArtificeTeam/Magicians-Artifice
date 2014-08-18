package magiciansartifice.tileentities;

import cpw.mods.fml.common.registry.GameRegistry;
import magiciansartifice.core.libs.ModInfo;
import magiciansartifice.tileentities.machines.TileEntityMetalForge;
import magiciansartifice.tileentities.machines.TileEntityMysticAnvil;
import magiciansartifice.tileentities.machines.TileEntityWandCarver;
import magiciansartifice.tileentities.magic.TileEntityRitualCornerstone;
import magiciansartifice.tileentities.magic.TileEntityTeleportReciever;

public class TileEntityRegistry {
    public static void registerTEs() {
        GameRegistry.registerTileEntity(TileEntityMetalForge.class, ModInfo.MODID + ":tileEntityMetalForge");
        GameRegistry.registerTileEntity(TileEntityMysticAnvil.class, ModInfo.MODID + ":tileEntityMysticAnvil");
        GameRegistry.registerTileEntity(TileEntityWandCarver.class, ModInfo.MODID + ":tileEntityWandCarver");
        GameRegistry.registerTileEntity(TileEntityRitualCornerstone.class, ModInfo.MODID + ":tileEntityCornerstone");
        GameRegistry.registerTileEntity(TileEntityTeleportReciever.class, ModInfo.MODID + ":tileEntityTeleportReciever");
    }
}
