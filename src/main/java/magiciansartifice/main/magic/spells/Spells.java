package magiciansartifice.main.magic.spells;

import java.util.ArrayList;

import magiciansartifice.api.BasicSpell;

public class Spells {

    public static ArrayList<BasicSpell> spells = new ArrayList<BasicSpell>();

    public static BasicSpell sheepSpell;
    public static BasicSpell deathSpell;
    public static BasicSpell healSpell;

    public static void init() {
        sheepSpell = new SheepSpell().canClickEntity().setWandLevel(1).useParticles().setSpellRequirements(2,0,0).setUnlocalizedName("spell.sheep");
        deathSpell = new DeathSpell().canClickEntity().isForbidden().setWandLevel(3).setSpellRequirements(5,5,5).setUnlocalizedName("spell.death");
        healSpell = new HealSpell().isEatingSpell().setWandLevel(2).setSpellRequirements(3,3,0).setUnlocalizedName("spell.heal");

        registerRitual(sheepSpell);
        registerRitual(deathSpell);
        registerRitual(healSpell);
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
