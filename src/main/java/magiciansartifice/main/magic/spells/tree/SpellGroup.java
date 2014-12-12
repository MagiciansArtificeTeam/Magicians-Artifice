package magiciansartifice.main.magic.spells.tree;

import net.minecraft.util.StatCollector;

/**
 * Created by Mitchellbrine on 2014.
 */
public class SpellGroup {

    private String unlocalizedName;
    private int id;

    public SpellGroup() {
        IllegalArgumentException table = new IllegalArgumentException("I made this for no reason. Bask in its useless glory.");
        throw table;
    }

    public SpellGroup(String groupName,int id) {
        this.unlocalizedName = "spellGroup." + groupName;
        this.id = id;
        SpellGroups.groups.put(this.id,this);
    }

    public String getUnlocalizedName() {
        return this.unlocalizedName;
    }

    public String getLocalizedName() {
        return StatCollector.translateToLocal(this.unlocalizedName);
    }

    public int getId() {
        return this.id;
    }


}
