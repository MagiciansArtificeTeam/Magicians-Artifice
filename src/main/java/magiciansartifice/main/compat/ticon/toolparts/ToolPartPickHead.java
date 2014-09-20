package magiciansartifice.main.compat.ticon.toolparts;

import tconstruct.library.util.IToolPart;
import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.items.ItemRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ToolPartPickHead extends Item implements IToolPart {
	public ToolPartPickHead() {
		super();
		this.setUnlocalizedName("starSteelHead");
		this.setCreativeTab(MagiciansArtifice.tab);
		ItemRegistry.items.add(this);
	}
	
	@Override
	public int getMaterialID(ItemStack stack) { return 250; }
}
