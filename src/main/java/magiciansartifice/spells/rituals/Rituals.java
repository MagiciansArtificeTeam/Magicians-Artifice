package magiciansartifice.spells.rituals;

import magiciansartifice.api.BasicRitual;

import java.util.ArrayList;

public class Rituals {

    public static ArrayList<BasicRitual> rituals = new ArrayList<BasicRitual>();

    public static BasicRitual flightRitual;
    public static BasicRitual healRitual;

    public static void init() {
        flightRitual = new RitualFlight().lightningRitual().setRitualLength(4).setUnlocalizedName("ritual.flight");
        healRitual = new RitualHeal().setRitualLength(2).setRitualParticle("heart").setUnlocalizedName("ritual.heal");

        registerRitual(flightRitual);
        registerRitual(healRitual);
    }

    public static void registerRitual(BasicRitual ritual) {
        if ((ritual.getUnlocalizedName() != "" && ritual.getUnlocalizedName() != null) && (ritual.getRitualLength() != 0)) {
            rituals.add(ritual);
        } else {
            try {
                throw new UnsafeRitualException();
            } catch (UnsafeRitualException ex) {
                ex.printStackTrace();
            }
        }
    }

}
