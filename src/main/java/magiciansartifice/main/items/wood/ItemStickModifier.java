package magiciansartifice.main.items.wood;

import magiciansartifice.api.modifiers.BasicWandStick;
import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.core.libs.ModInfo;
import magiciansartifice.main.core.utils.KeyHelper;
import magiciansartifice.main.core.utils.TextHelper;
import magiciansartifice.main.items.ItemRegistry;
import magiciansartifice.main.items.crafting.modifiers.Modifiers;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import java.util.List;

/**
 * Created by Mitchellbrine on 2014.
 */
public class ItemStickModifier extends BasicWandStick{

    public ItemStickModifier(int capacity, String woodType, ResourceLocation location) {
        super(capacity);
        this.setUnlocalizedName("wandStick." + woodType);
        this.setCreativeTab(MagiciansArtifice.partsTab);
        this.setTextureName(ModInfo.MODID + ":wands/sticks/"+woodType);
        Modifiers.modifiers.add(this);
        Modifiers.resources.put(this,location);
        ItemRegistry.items.add(this);
    }

    @Override
    @SuppressWarnings({"rawtypes","unchecked"})
    public void addInformation(ItemStack stack, EntityPlayer player, List lore, boolean par4) {
        if (KeyHelper.isShiftKeyDown()) {
            if (this.getCapacity() != 0) {
                lore.add(TextHelper.PINK + "Wand Capacity Modifier: " + this.getCapacity() + "x");
            }
        }
    }

}
