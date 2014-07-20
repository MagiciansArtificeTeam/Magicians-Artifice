package magiciansartifice.items.wand;

import cpw.mods.fml.common.registry.GameRegistry;
import magiciansartifice.MagiciansArtifice;
import magiciansartifice.ModInfo;
import net.minecraft.item.Item;

public class Wand extends Item {

    public Wand() {
        this.setMaxStackSize(1);
        this.setCreativeTab(MagiciansArtifice.tab);
        this.setUnlocalizedName("magiciansWand");
        this.setTextureName(ModInfo.MODID + ":magicianWand");
        GameRegistry.registerItem(this,this.getUnlocalizedName().substring(5));
    }

}
