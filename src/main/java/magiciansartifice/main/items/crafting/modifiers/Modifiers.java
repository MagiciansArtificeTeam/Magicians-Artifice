package magiciansartifice.main.items.crafting.modifiers;

import magiciansartifice.api.IModifier;

import java.util.ArrayList;

/**
 * Created by Mitchellbrine on 2014.
 */
public class Modifiers {

    public static ArrayList<IModifier> modifiers = new ArrayList<IModifier>();

    public static boolean registerModifier(IModifier modifier) {
        return modifiers.add(modifier);
    }

}
