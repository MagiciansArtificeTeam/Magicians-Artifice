package magiciansartifice.main.items.magicalitems;

import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.core.libs.ModInfo;
import magiciansartifice.main.core.utils.registries.ItemRegistry;
import net.minecraft.item.Item;

public class ItemAngelFeather extends Item {
	public ItemAngelFeather() {
		super();
		this.setUnlocalizedName("angelfeather");
		this.setCreativeTab(MagiciansArtifice.tab);
		this.setTextureName(ModInfo.MODID + ":magical/angelFeather");
		ItemRegistry.items.add(this);
	}
}
