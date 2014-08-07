package magiciansartifice.spells.rituals;

import magiciansartifice.api.BasicRitual;

import java.util.ArrayList;

public class Rituals {

    public static ArrayList<BasicRitual> rituals = new ArrayList<BasicRitual>();

    public static BasicRitual flightRitual;
    public static BasicRitual healRitual;
    public static BasicRitual deathRitual;

    public static void init() {
        flightRitual = new RitualFlight().lightningRitual().setRitualLength(4).setUnlocalizedName("ritual.flight");
        healRitual = new RitualHeal().setRitualLength(2).setRitualParticle("heart").setUnlocalizedName("ritual.heal");
        deathRitual = new RitualDeath().setRitualLength(2).setUnlocalizedName("ritual.death");

        registerRitual(flightRitual);
        registerRitual(healRitual);
        registerRitual(deathRitual);
    }

    public static void registerRitual(BasicRitual ritual) {
        if ((ritual.getUnlocalizedName() != "" && ritual.getUnlocalizedName() != null) && (ritual.getRitualLength() != 0)) {
            rituals.add(ritual);
        } else {
            String failMessage = "";
            if ((ritual.getUnlocalizedName() == null || ritual.getUnlocalizedName().equals(""))) {
                failMessage = "A ritual has an illegible unlocalized name";
            } else if (ritual.getRitualLength() == 0){
                failMessage = "The ritual, " + ritual.getUnlocalizedName() + ", has an illegible ritual length and wasn't added due to the modder's stupidity!";
            }
            try {
                throw new UnsafeRitualException(failMessage);
            } catch (UnsafeRitualException ex) {
                ex.printStackTrace();
            }
        }
    }

}
