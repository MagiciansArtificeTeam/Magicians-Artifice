package magiciansartifice.items.tools;

import magiciansartifice.MagiciansArtifice;
import magiciansartifice.core.libs.ModInfo;
import magiciansartifice.items.ItemRegistry;
import net.minecraft.item.Item;

/**
 * Created by poppypoppop on 21/07/2014.
 */
public class ItemToolChisel extends Item {

    public ItemToolChisel() {
        this.setCreativeTab(MagiciansArtifice.tab);
        this.setUnlocalizedName("chiselTool");
        this.setTextureName(ModInfo.MODID + ":tools/chisel");
        ItemRegistry.items.add(this);
    }
}
