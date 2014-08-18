package magiciansartifice.items.tools.starsteel;

import magiciansartifice.MagiciansArtifice;
import magiciansartifice.items.ItemRegistry;
import magiciansartifice.core.libs.ModInfo;
import net.minecraft.item.ItemAxe;

/**
 * Created by poppypoppop on 22/07/2014.
 */
public class ItemAxeStarSteel extends ItemAxe {
    public ItemAxeStarSteel() {
        super(ItemRegistry.starSteel);
        this.setCreativeTab(MagiciansArtifice.tab);
        this.setTextureName(ModInfo.MODID + ":tools/starSteelAxe");
        this.setUnlocalizedName("star.steel.axe");
        ItemRegistry.items.add(this);
    }
}
