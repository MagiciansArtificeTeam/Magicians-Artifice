package magiciansartifice.main.magic.rituals;

import magiciansartifice.api.BasicRitual;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;

public class Rituals {

    public static ArrayList<BasicRitual> rituals = new ArrayList<BasicRitual>();

    public static BasicRitual waterRitual;
    public static BasicRitual flightRitual;
    public static BasicRitual healRitual;
    public static BasicRitual deathRitual;
    public static BasicRitual treeRitual;
    public static BasicRitual teleportRitual;
    public static BasicRitual enderRitual;

    public static void init() {
        waterRitual = new RitualWaterCreation().doesNotUseBarrier().setRitualLength(1).setUnlocalizedName("ritual.water.creation");
        flightRitual = new RitualFlight().lightningRitual().setRitualLength(4).setUnlocalizedName("ritual.flight");
        healRitual = new RitualHeal().doesNotUseBarrier().setRitualLength(2).setRitualParticle("heart").setUnlocalizedName("ritual.heal");
        deathRitual = new RitualDeath().setRitualLength(2).setUnlocalizedName("ritual.death");
        treeRitual = new RitualTree().doesNotUseBarrier().setRitualLength(1).setRitualParticle("happyVillager").setUnlocalizedName("ritual.tree.spawn");
        teleportRitual = new RitualTeleport().setRitualLength(1).setRitualParticle("ender").setUnlocalizedName("ritual.teleport");
        enderRitual = new RitualEnderEssence().setRitualLength(1).setUnlocalizedName("ritual.ender").doesNotUseBarrier();

        for (int i = 0; i < 6; i++) {
            RitualTree.saplings.add(new ItemStack(Blocks.sapling, 1, i).getItem());
        }

        registerRitual(waterRitual);
        registerRitual(flightRitual);
        registerRitual(healRitual);
        registerRitual(deathRitual);
        registerRitual(treeRitual);
        registerRitual(teleportRitual);
        registerRitual(enderRitual);
    }

    public static void registerRitual(BasicRitual ritual) {
        if ((!ritual.getUnlocalizedName().equals("") && ritual.getUnlocalizedName() != null) && (ritual.getRitualLength() != 0)) {
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
