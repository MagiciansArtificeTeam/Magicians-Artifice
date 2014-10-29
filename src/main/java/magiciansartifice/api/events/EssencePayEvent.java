package magiciansartifice.api.events;

import cpw.mods.fml.common.eventhandler.Cancelable;
import magiciansartifice.api.BasicSpell;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.player.PlayerEvent;

/**
 * Created by Mitchellbrine on 2014.
 */
@Cancelable
public class EssencePayEvent extends PlayerEvent {

    public BasicSpell spell;
    public int overworldSpent;
    public int netherSpent;
    public int enderSpent;

    public EssencePayEvent(EntityPlayer player,BasicSpell spell, int oSpent, int nSpent, int eSpent) {
        super(player);
        this.spell = spell;
        this.overworldSpent = oSpent;
        this.netherSpent = nSpent;
        this.enderSpent = eSpent;
    }
}
