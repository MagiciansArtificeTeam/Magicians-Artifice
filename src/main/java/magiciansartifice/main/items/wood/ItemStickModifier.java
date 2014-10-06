package magiciansartifice.main.items.wood;

import magiciansartifice.api.modifiers.BasicWandStick;
import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.core.libs.ModInfo;
import magiciansartifice.main.items.ItemRegistry;
import magiciansartifice.main.items.crafting.modifiers.Modifiers;

/**
 * Created by Mitchellbrine on 2014.
 */
public class ItemStickModifier extends BasicWandStick{

    public ItemStickModifier(int capacity, String woodType) {
        super(capacity);
        this.setUnlocalizedName("wandStick." + woodType);
        this.setCreativeTab(MagiciansArtifice.partsTab);
        this.setTextureName(ModInfo.MODID + ":wands/sticks/"+woodType);
        Modifiers.modifiers.add(this);
        ItemRegistry.items.add(this);
    }

}
