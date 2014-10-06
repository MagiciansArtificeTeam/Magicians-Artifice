package magiciansartifice.main.items.crafting.modifiers;

import magiciansartifice.api.modifiers.BasicWandCore;
import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.items.ItemRegistry;

/**
 * Created by Mitchellbrine on 2014.
 */
public class ItemCoreModifier extends BasicWandCore{

    public ItemCoreModifier(int wandLevel, String coreName) {
        super(wandLevel);
        this.setMaxStackSize(1);
        this.setCreativeTab(MagiciansArtifice.partsTab);
        this.setUnlocalizedName("wandCore."+coreName);
        Modifiers.modifiers.add(this);
        ItemRegistry.items.add(this);
    }

}
