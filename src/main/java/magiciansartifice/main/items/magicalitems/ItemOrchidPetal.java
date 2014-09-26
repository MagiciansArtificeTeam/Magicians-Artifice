package magiciansartifice.main.items.magicalitems;

import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.core.libs.ModInfo;
import magiciansartifice.main.items.ItemRegistry;
import net.minecraft.item.Item;

public class ItemOrchidPetal extends Item {
	public ItemOrchidPetal() {
		super();
		this.setMaxStackSize(16);
		this.setUnlocalizedName("orchidpetal");
		this.setCreativeTab(MagiciansArtifice.tab);
		this.setTextureName(ModInfo.MODID + ":magical/orchidPetal");
		ItemRegistry.items.add(this);
	}
}
