package magiciansartifice.items.tools.steel;

import magiciansartifice.MagiciansArtifice;
import magiciansartifice.items.ItemRegistry;
import magiciansartifice.libs.ModInfo;
import net.minecraft.item.ItemHoe;

/**
 * Created by poppypoppop on 22/07/2014.
 */
public class ItemHoeSteel extends ItemHoe {
    public ItemHoeSteel() {
        super(ItemRegistry.steel);
        this.setCreativeTab(MagiciansArtifice.tab);
        this.setTextureName(ModInfo.MODID + ":tools/steelHoe");
        this.setUnlocalizedName("steel.hoe");
        ItemRegistry.items.add(this);
    }
}
