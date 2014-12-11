package magiciansartifice.main.items.tools.steel;

import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.core.utils.registries.ItemRegistry;
import magiciansartifice.main.core.libs.ModInfo;
import net.minecraft.item.ItemPickaxe;

/**
 * Created by poppypoppop on 22/07/2014.
 */
public class ItemPickSteel extends ItemPickaxe {
    public ItemPickSteel() {
        super(ItemRegistry.steel);
        this.setCreativeTab(MagiciansArtifice.tab);
        this.setUnlocalizedName("steel.pickaxe");
        this.setTextureName(ModInfo.MODID + ":tools/steelPickaxe");
        ItemRegistry.items.add(this);
    }
}
