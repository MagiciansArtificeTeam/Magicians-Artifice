package magiciansartifice.spells.spells;

import java.util.ArrayList;

import magiciansartifice.api.BasicSpell;

public class Spells {

    public static ArrayList<BasicSpell> spells = new ArrayList<BasicSpell>();

    public static void init() {

    }

    public static void registerRitual(BasicSpell spell) {
        if ((!spell.getUnlocalizedName().equals("") && spell.getUnlocalizedName() != null)) {
            spells.add(spell);
        } else {
            String failMessage = "";
            if ((spell.getUnlocalizedName() == null || spell.getUnlocalizedName().equals(""))) {
                failMessage = "A spell has an illegible unlocalized name";
            }
            try {
                throw new UnsafeSpellException(failMessage);
            } catch (UnsafeSpellException ex) {
                ex.printStackTrace();
            }
        }
    }

}
