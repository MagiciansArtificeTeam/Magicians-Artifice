package magiciansartifice.main.items.magicalitems;

import magiciansartifice.main.core.libs.ModInfo;
import magiciansartifice.main.items.ItemRegistry;
import net.minecraft.item.Item;

public class ItemAngelFeather extends Item {
	public ItemAngelFeather() {
		super();
		this.setUnlocalizedName("angelfeather");
		this.setTextureName(ModInfo.MODID + ":magical/angelFeather");
		ItemRegistry.items.add(this);
	}
}
