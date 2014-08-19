package magiciansartifice.main.items.tools;

import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.core.libs.ModInfo;
import magiciansartifice.main.items.ItemRegistry;
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
