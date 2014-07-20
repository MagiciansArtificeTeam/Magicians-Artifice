package magiciansartifice.items.tools;

import cpw.mods.fml.common.registry.GameRegistry;
import magiciansartifice.MagiciansArtifice;
import magiciansartifice.ModInfo;
import magiciansartifice.items.ItemRegistry;
import net.minecraft.item.Item;

/**
 * Created by poppypoppop on 21/07/2014.
 */
public class ItemToolChisel extends Item {

    static {
        ItemRegistry.prepareForRegister(new ItemToolChisel());
    }

    public ItemToolChisel() {
        this.setCreativeTab(MagiciansArtifice.tab);
        this.setUnlocalizedName("chiselTool");
        this.setTextureName(ModInfo.MODID + ":tools/chisel");
    }
}
