package magiciansartifice.main.items.crafting;

import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.core.libs.ModInfo;
import magiciansartifice.main.core.utils.registries.ItemRegistry;
import net.minecraft.item.Item;

/**
 * Created by poppypoppop on 4/10/2014.
 */
public class ItemBeastClaw extends Item {
    public ItemBeastClaw() {
        super();
        this.setTextureName(ModInfo.MODID + ":crafting/claw");
        this.setCreativeTab(MagiciansArtifice.tab);
        this.setUnlocalizedName("beastClaw");
        ItemRegistry.items.add(this);
    }
}
