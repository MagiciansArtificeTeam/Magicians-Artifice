package magiciansartifice.items.tools.starsteel;

import magiciansartifice.MagiciansArtifice;
import magiciansartifice.items.ItemRegistry;
import magiciansartifice.libs.ModInfo;
import net.minecraft.item.ItemSpade;

/**
 * Created by poppypoppop on 22/07/2014.
 */
public class ItemShovelStarSteel extends ItemSpade {
    public ItemShovelStarSteel() {
        super(ItemRegistry.starSteel);
        this.setCreativeTab(MagiciansArtifice.tab);
        this.setUnlocalizedName(ModInfo.MODID + ".star.steel.shovel");
        this.setTextureName(ModInfo.MODID + ":tools/starSteelShovel");
        ItemRegistry.items.add(this);
    }
}
