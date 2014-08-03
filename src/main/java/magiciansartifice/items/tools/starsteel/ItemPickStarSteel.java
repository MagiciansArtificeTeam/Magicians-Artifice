package magiciansartifice.items.tools.starsteel;

import magiciansartifice.MagiciansArtifice;
import magiciansartifice.items.ItemRegistry;
import magiciansartifice.libs.ModInfo;
import net.minecraft.item.ItemPickaxe;

/**
 * Created by poppypoppop on 22/07/2014.
 */
public class ItemPickStarSteel extends ItemPickaxe {
    public ItemPickStarSteel() {
        super(ItemRegistry.starSteel);
        this.setCreativeTab(MagiciansArtifice.tab);
        this.setUnlocalizedName("star.steel.pickaxe");
        this.setTextureName(ModInfo.MODID + ":tools/starSteelPickaxe");
        ItemRegistry.items.add(this);
    }
}
