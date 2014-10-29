package magiciansartifice.main.core.events;

import cpw.mods.fml.common.FMLCommonHandler;
import magiciansartifice.main.magic.essence.EssenceNetworkEvents;
import net.minecraftforge.common.MinecraftForge;

public class EventRegistry {
	public static void initEvents() {
        MinecraftForge.EVENT_BUS.register(new EntityEventHandler());
        MinecraftForge.EVENT_BUS.register(new EntityEventRebirth());
        MinecraftForge.EVENT_BUS.register(new EssenceNetworkEvents());
        FMLCommonHandler.instance().bus().register(new EssenceNetworkEvents());
	}
}
