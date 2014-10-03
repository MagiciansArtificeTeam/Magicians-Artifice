package magiciansartifice.main.items.crafting;

import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.core.libs.ModInfo;
import magiciansartifice.main.items.ItemRegistry;
import net.minecraft.item.Item;

/**
 * Created by poppypoppop on 2/10/2014.
 */
public class ItemSteelPlate extends Item {
    public ItemSteelPlate() {
        super();
        this.setUnlocalizedName("steelplate");
        this.setCreativeTab(MagiciansArtifice.tab);
        this.setTextureName(ModInfo.MODID + ":crafting/steelPlate");
        ItemRegistry.items.add(this);
    }
}
