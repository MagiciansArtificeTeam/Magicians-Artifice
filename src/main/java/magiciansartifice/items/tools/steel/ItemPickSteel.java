package magiciansartifice.items.tools.steel;

import magiciansartifice.MagiciansArtifice;
import magiciansartifice.items.ItemRegistry;
import magiciansartifice.libs.ModInfo;
import net.minecraft.item.ItemPickaxe;

/**
 * Created by poppypoppop on 22/07/2014.
 */
public class ItemPickSteel extends ItemPickaxe {
    public ItemPickSteel() {
        super(ItemRegistry.steel);
        this.setCreativeTab(MagiciansArtifice.tab);
        this.setUnlocalizedName(ModInfo.MODID + ".steel.pickaxe");
        this.setTextureName(ModInfo.MODID + ":tools/steelPickaxe");
        ItemRegistry.items.add(this);
    }
}
