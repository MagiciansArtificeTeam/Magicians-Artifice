package magiciansartifice.api.modifiers;

import magiciansartifice.api.IModifier;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

/**
 * Created by Mitchellbrine on 2014.
 */
public class BasicWandCore extends Item implements IModifier{

    private int wandLevel;

    public BasicWandCore(int wandLevel) {
        this.wandLevel = wandLevel;

    }

    public BasicWandCore() {}

    public BasicWandCore setWandLevel(int level) {
        this.wandLevel = level;
        return this;
    }

    public int getWandLevel() {
        return this.wandLevel;
    }

}
