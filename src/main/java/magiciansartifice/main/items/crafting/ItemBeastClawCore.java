package magiciansartifice.main.items.crafting;

import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.core.libs.ModInfo;
import magiciansartifice.main.items.ItemRegistry;
import net.minecraft.item.Item;

/**
 * Created by poppypoppop on 4/10/2014.
 */
public class ItemBeastClawCore extends Item {
    public ItemBeastClawCore() {
        super();
        this.setTextureName(ModInfo.MODID + ":crafting/clawsCore");
        this.setCreativeTab(MagiciansArtifice.tab);
        this.setUnlocalizedName("beastClawCore");
        ItemRegistry.items.add(this);
    }
}
