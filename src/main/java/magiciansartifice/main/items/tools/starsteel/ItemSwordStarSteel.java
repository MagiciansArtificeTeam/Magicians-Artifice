package magiciansartifice.main.items.tools.starsteel;

import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.items.ItemRegistry;
import magiciansartifice.main.core.libs.ModInfo;
import net.minecraft.item.ItemSword;

/**
 * Created by poppypoppop on 22/07/2014.
 */
public class ItemSwordStarSteel extends ItemSword {
    public ItemSwordStarSteel() {
        super(ItemRegistry.starSteel);
        this.setTextureName(ModInfo.MODID + ":tools/starSteelSword");
        this.setUnlocalizedName("star.steel.sword");
        this.setCreativeTab(MagiciansArtifice.tab);
        ItemRegistry.items.add(this);
    }
}
