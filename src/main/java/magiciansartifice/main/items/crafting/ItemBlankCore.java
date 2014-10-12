package magiciansartifice.main.items.crafting;

import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.core.libs.ModInfo;
import magiciansartifice.main.items.ItemRegistry;
import net.minecraft.item.Item;

/**
 * Created by Mitchellbrine on 2014.
 */
public class ItemBlankCore extends Item{

    public ItemBlankCore() {
        super();
        this.setCreativeTab(MagiciansArtifice.partsTab);
        this.setMaxStackSize(1);
        this.setUnlocalizedName("blankCore");
        this.setTextureName(ModInfo.MODID + ":wands/cores/blankCore");
        ItemRegistry.items.add(this);
    }

}
