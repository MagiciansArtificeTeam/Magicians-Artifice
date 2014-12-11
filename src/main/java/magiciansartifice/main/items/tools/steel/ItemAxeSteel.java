package magiciansartifice.main.items.tools.steel;

import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.core.utils.registries.ItemRegistry;
import magiciansartifice.main.core.libs.ModInfo;
import net.minecraft.item.ItemAxe;

/**
 * Created by poppypoppop on 22/07/2014.
 */
public class ItemAxeSteel extends ItemAxe {
    public ItemAxeSteel() {
        super(ItemRegistry.steel);
        this.setCreativeTab(MagiciansArtifice.tab);
        this.setTextureName(ModInfo.MODID + ":tools/steelAxe");
        this.setUnlocalizedName("steel.axe");
        ItemRegistry.items.add(this);
    }
}
