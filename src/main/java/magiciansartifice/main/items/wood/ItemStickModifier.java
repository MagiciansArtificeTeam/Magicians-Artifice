package magiciansartifice.main.items.wood;

import magiciansartifice.api.modifiers.BasicWandStick;
import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.core.libs.ModInfo;
import magiciansartifice.main.items.ItemRegistry;
import magiciansartifice.main.items.crafting.modifiers.Modifiers;
import net.minecraft.util.ResourceLocation;

/**
 * Created by Mitchellbrine on 2014.
 */
public class ItemStickModifier extends BasicWandStick{

    public ItemStickModifier(int capacity, String woodType, ResourceLocation location) {
        super(capacity);
        this.setUnlocalizedName("wandStick." + woodType);
        this.setCreativeTab(MagiciansArtifice.partsTab);
        this.setTextureName(ModInfo.MODID + ":wands/sticks/"+woodType);
        Modifiers.modifiers.add(this);
        Modifiers.resources.put(this,location);
        ItemRegistry.items.add(this);
    }

}
