package magiciansartifice.main.items.crafting.modifiers;

import magiciansartifice.api.modifiers.BasicWandHandle;
import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.items.ItemRegistry;

/**
 * Created by Mitchellbrine on 2014.
 */
public class ItemHandleModifier extends BasicWandHandle{

    public ItemHandleModifier(int capacity, String handleName) {
        super(capacity);
        this.setMaxStackSize(1);
        this.setCreativeTab(MagiciansArtifice.partsTab);
        this.setUnlocalizedName("wandHandle."+handleName);
        Modifiers.modifiers.add(this);
        ItemRegistry.items.add(this);
    }

}
