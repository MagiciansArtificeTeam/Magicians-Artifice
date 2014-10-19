package magiciansartifice.main.items.crafting.modifiers;

import magiciansartifice.api.BasicSpell;
import magiciansartifice.api.modifiers.BasicWandCore;
import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.core.libs.ModInfo;
import magiciansartifice.main.core.utils.KeyHelper;
import magiciansartifice.main.core.utils.TextHelper;
import magiciansartifice.main.items.ItemRegistry;
import magiciansartifice.main.magic.spells.Spells;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.oredict.OreDictionary;

import java.util.List;

/**
 * Created by Mitchellbrine on 2014.
 */
public class ItemCoreModifier extends BasicWandCore{

    public ItemCoreModifier(int wandLevel, String coreName, ResourceLocation location) {
        super(wandLevel);
        this.setMaxStackSize(1);
        this.setCreativeTab(MagiciansArtifice.partsTab);
        this.setUnlocalizedName("wandCore." + coreName);
        this.setTextureName(ModInfo.MODID + ":wands/cores/"+coreName);
        Modifiers.modifiers.add(this);
        Modifiers.resources.put(this,location);
        ItemRegistry.items.add(this);
    }

    @Override
    @SuppressWarnings({"rawtypes","unchecked"})
    public void addInformation(ItemStack stack, EntityPlayer player, List lore, boolean par4) {
        if (KeyHelper.isShiftKeyDown()) {
            lore.add(TextHelper.PINK + "Wand Core Modifier: " + this.getWandLevel());
        }
        if (KeyHelper.isCtrlKeyDown()) {
            lore.add(TextHelper.TEAL + "~~~");
            lore.add(TextHelper.TEAL + "Can Perform These Spells: ");
            for (BasicSpell spell : Spells.spells) {
                if (spell.getWandLevelRequired() <= this.getWandLevel()) {
                    lore.add(TextHelper.TEAL + "- " + spell.getLocalizedName());
                }
            }
            lore.add(TextHelper.TEAL + "~~~");
        }
    }

}
