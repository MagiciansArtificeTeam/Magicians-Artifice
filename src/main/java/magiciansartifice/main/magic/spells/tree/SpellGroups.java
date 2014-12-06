package magiciansartifice.main.magic.spells.tree;

import java.util.HashMap;

/**
 * Created by Mitchellbrine on 2014.
 */
public class SpellGroups {

    public static HashMap<Integer, SpellGroup> groups = new HashMap<Integer, SpellGroup>();

    public static SpellGroup elements;
    public static SpellGroup transformation;
    public static SpellGroup mind;
    public static SpellGroup time;
    public static SpellGroup motion;
    public static SpellGroup matter;

    public static void init() {
        elements = new SpellGroup("element",0);
        transformation = new SpellGroup("transformation",getNextID());
        mind = new SpellGroup("mind",getNextID());
        time = new SpellGroup("time",getNextID());
        motion = new SpellGroup("motion",getNextID());
        matter = new SpellGroup("matter",getNextID());
    }

    public static int getNextID() {
            return groups.size();
    }

}
