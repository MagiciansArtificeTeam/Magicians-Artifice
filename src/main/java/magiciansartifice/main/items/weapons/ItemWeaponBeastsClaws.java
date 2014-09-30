package magiciansartifice.main.items.weapons;

import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.items.ItemRegistry;
import net.minecraft.item.ItemSword;

public class ItemWeaponBeastsClaws extends ItemSword {
	public ItemWeaponBeastsClaws(ToolMaterial material) {
		super(material);
		this.setUnlocalizedName("endBeastClaws");
		this.setCreativeTab(MagiciansArtifice.tab);
		ItemRegistry.items.add(this);
	}
}
