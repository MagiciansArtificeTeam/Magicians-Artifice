package magiciansartifice.main.core.events;

import magiciansartifice.main.items.magicalitems.ItemHorcrux;
import net.minecraftforge.common.MinecraftForge;

public class EventRegistry {
	public static void initEvents() {
		MinecraftForge.EVENT_BUS.register(new EntityEventHandler());
        MinecraftForge.EVENT_BUS.register(new ItemHorcrux());
	}
}
