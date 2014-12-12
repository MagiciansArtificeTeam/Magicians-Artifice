package magiciansartifice.main.items.crafting;

import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.core.libs.ModInfo;
import magiciansartifice.main.core.utils.registries.ItemRegistry;
import net.minecraft.item.Item;

/**
 * Created by poppypoppop on 2/10/2014.
 */
public class ItemForgeHammer extends Item {
    public ItemForgeHammer() {
        super();
        this.setMaxDamage(120);
        this.setCreativeTab(MagiciansArtifice.tab);
        this.setUnlocalizedName("forgehammer");
        this.setTextureName(ModInfo.MODID + ":crafting/forgeHammer");
        ItemRegistry.items.add(this);
    }

    /*@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean b) {
        if (KeyHelper.isShiftKeyDown()) {
            NBTTagCompound nbt = stack.getTagCompound();
            if (nbt != null && nbt.hasKey("Uses"))
            {
                uses = nbt.getInteger("Uses");
                if (uses >= 0) {
                    list.add(TextHelper.localize("forgehammer.current") + " " + uses);
                }
                else {
                    list.add(TextHelper.localize("forgehammer.invalid"));
                }
            }
            else {
                list.add(TextHelper.localize("forgehammer.none"));
            }
        }
        else {
            list.add(TextHelper.SHIFTFORMORE);
        }
    }*/
    
    @Override
    public boolean isDamageable()
    {
    	return true;
    }
}
