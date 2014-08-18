package magiciansartifice.items.tools.steel;

import magiciansartifice.MagiciansArtifice;
import magiciansartifice.items.ItemRegistry;
import magiciansartifice.core.libs.ModInfo;
import net.minecraft.item.ItemSword;

/**
 * Created by poppypoppop on 22/07/2014.
 */
public class ItemSwordSteel extends ItemSword {
    public ItemSwordSteel() {
        super(ItemRegistry.steel);
        this.setTextureName(ModInfo.MODID + ":tools/steelSword");
        this.setUnlocalizedName("steel.sword");
        this.setCreativeTab(MagiciansArtifice.tab);
        ItemRegistry.items.add(this);
    }
}
