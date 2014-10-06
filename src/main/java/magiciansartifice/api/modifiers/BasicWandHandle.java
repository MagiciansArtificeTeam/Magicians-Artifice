package magiciansartifice.api.modifiers;

import magiciansartifice.api.IModifier;
import net.minecraft.item.Item;

/**
 * Created by Mitchellbrine on 2014.
 */
public class BasicWandHandle extends Item implements IModifier{

    private int capacityModifier;

    public BasicWandHandle(int capacityModifier) {
        this.capacityModifier = capacityModifier;
    }

    public BasicWandHandle() {}

    public BasicWandHandle setCapacity(int capacity) {
        this.capacityModifier = capacity;
        return this;
    }

    public int getCapacity() {
        return this.capacityModifier;
    }

}
