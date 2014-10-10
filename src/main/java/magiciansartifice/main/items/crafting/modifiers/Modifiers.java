package magiciansartifice.main.items.crafting.modifiers;

import magiciansartifice.api.IModifier;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Mitchellbrine on 2014.
 */
public class Modifiers {

    public static ArrayList<IModifier> modifiers = new ArrayList<IModifier>();
    public static HashMap<IModifier,ResourceLocation> resources = new HashMap<IModifier,ResourceLocation>();

    public static boolean registerModifier(IModifier modifier) {
        return modifiers.add(modifier);
    }

}
