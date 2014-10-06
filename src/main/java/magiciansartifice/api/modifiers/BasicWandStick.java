package magiciansartifice.api.modifiers;

import magiciansartifice.api.IModifier;
import net.minecraft.item.Item;

/**
 * Created by Mitchellbrine on 2014.
 */
public class BasicWandStick extends Item implements IModifier {

    private int capacity;

    public BasicWandStick(int modifier) {
        this.capacity = modifier;
    }

    public BasicWandStick() {}

    public BasicWandStick setCapacity(int capacity) {
        this.capacity = capacity;
        return this;
    }

    public int getCapacity() {
        return this.capacity;
    }

}
