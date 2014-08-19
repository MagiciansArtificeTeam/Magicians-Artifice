package magiciansartifice.main.items.tools.steel;

import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.items.ItemRegistry;
import magiciansartifice.main.core.libs.ModInfo;
import net.minecraft.item.ItemSpade;

/**
 * Created by poppypoppop on 22/07/2014.
 */
public class ItemShovelSteel extends ItemSpade {
    public ItemShovelSteel() {
        super(ItemRegistry.steel);
        this.setCreativeTab(MagiciansArtifice.tab);
        this.setUnlocalizedName("steel.shovel");
        this.setTextureName(ModInfo.MODID + ":tools/steelShovel");
        ItemRegistry.items.add(this);
    }
}
