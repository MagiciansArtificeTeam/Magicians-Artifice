package magiciansartifice.items.tools;

import cpw.mods.fml.common.registry.GameRegistry;
import magiciansartifice.MagiciansArtifice;
import magiciansartifice.ModInfo;
import net.minecraft.item.Item;

/**
 * Created by poppypoppop on 21/07/2014.
 */
public class ItemToolChisel extends Item {
    public ItemToolChisel() {
        this.setCreativeTab(MagiciansArtifice.tab);
        this.setUnlocalizedName(ModInfo.MODID + ".chiselTool");
        this.setTextureName(ModInfo.MODID + ":tools/chisel");

        GameRegistry.registerItem(this, this.getUnlocalizedName().substring(5));
    }
}
