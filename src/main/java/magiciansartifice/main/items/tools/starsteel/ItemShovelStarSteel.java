package magiciansartifice.main.items.tools.starsteel;

import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.core.utils.registries.ItemRegistry;
import magiciansartifice.main.core.libs.ModInfo;
import net.minecraft.item.ItemSpade;

/**
 * Created by poppypoppop on 22/07/2014.
 */
public class ItemShovelStarSteel extends ItemSpade {
    public ItemShovelStarSteel() {
        super(ItemRegistry.starSteel);
        this.setCreativeTab(MagiciansArtifice.tab);
        this.setUnlocalizedName("star.steel.shovel");
        this.setTextureName(ModInfo.MODID + ":tools/starSteelShovel");
        ItemRegistry.items.add(this);
    }
}
