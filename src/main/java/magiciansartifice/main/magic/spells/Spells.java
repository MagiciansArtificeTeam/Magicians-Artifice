package magiciansartifice.main.magic.spells;

import java.util.ArrayList;

import magiciansartifice.api.BasicSpell;

public class Spells {

    public static ArrayList<BasicSpell> spells = new ArrayList<BasicSpell>();

    public static BasicSpell sheepSpell;
    public static BasicSpell deathSpell;
    public static BasicSpell healSpell;
    public static BasicSpell fieldSpell;
    public static BasicSpell levitationSpell;
    public static BasicSpell hurtSpell;
    public static BasicSpell summoningSpell;
    public static BasicSpell bindSpell;

    public static void init() {
        sheepSpell = new SheepSpell().canClickEntity().setWandLevel(1).useParticles().setSpellRequirements(2,0,0).setUnlocalizedName("spell.sheep");
        deathSpell = new DeathSpell().canLeftClickEntity().isForbidden().setWandLevel(3).setSpellRequirements(5,5,5).setUnlocalizedName("spell.death");
        //healSpell = new HealSpell().isEatingSpell().setWandLevel(2).setSpellRequirements(3,3,0).setUnlocalizedName("spell.heal");
        fieldSpell = new ContainSpell().canRightClick().setWandLevel(2).setSpellRequirements(2,4,0).setUnlocalizedName("spell.containment");
        levitationSpell = new LevitationSpell().canLeftClickEntity().setWandLevel(1).useParticles().setSpellRequirements(1,0,0).setUnlocalizedName("spell.levitation");
        hurtSpell = new HurtSpell().canClickEntity().setWandLevel(3).setSpellRequirements(1,1,1).setUnlocalizedName("spell.hurt");
        //summoningSpell = new SummoningSpell().isCastSpell().setSpellBeginning("Come").setWandLevel(2).setSpellRequirements(3,2,0).setUnlocalizedName("spell.summon");
        bindSpell = new BodyBindSpell().canLeftClickEntity().setWandLevel(2).setSpellRequirements(3,3,0).setUnlocalizedName("spell.bind");

        registerSpell(levitationSpell);
        registerSpell(sheepSpell);
        registerSpell(fieldSpell);
        //registerRitual(healSpell);
        //registerSpell(summoningSpell);
        registerSpell(bindSpell);
        registerSpell(hurtSpell);
        registerSpell(deathSpell);
    }

    public static void registerSpell(BasicSpell spell) {
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
