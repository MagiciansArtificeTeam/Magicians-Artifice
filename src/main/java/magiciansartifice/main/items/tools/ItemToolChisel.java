package magiciansartifice.main.items.tools;

import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.core.libs.ModInfo;
import magiciansartifice.main.items.ItemRegistry;
import net.minecraft.item.Item;

public class ItemToolChisel extends Item {

    public ItemToolChisel() {
        this.setMaxDamage(100);
        this.setMaxStackSize(1);
        this.setUnlocalizedName("chiselTool");
        this.setCreativeTab(MagiciansArtifice.tab);
        this.setTextureName(ModInfo.MODID + ":tools/chisel");
        ItemRegistry.items.add(this);
    }

    public ItemToolChisel(int tier) {
        this.setMaxDamage(100);
        this.setMaxStackSize(1);
        this.setUnlocalizedName("chiselTool"+tier);
        this.setCreativeTab(MagiciansArtifice.tab);
        this.setTextureName(ModInfo.MODID + ":tools/chisel"+tier);
        ItemRegistry.items.add(this);
    }
}
