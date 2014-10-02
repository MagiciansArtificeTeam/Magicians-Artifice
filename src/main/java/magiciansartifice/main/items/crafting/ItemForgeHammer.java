package magiciansartifice.main.items.crafting;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.core.libs.ModInfo;
import magiciansartifice.main.core.utils.KeyHelper;
import magiciansartifice.main.core.utils.TextHelper;
import magiciansartifice.main.items.ItemRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import java.util.List;

/**
 * Created by poppypoppop on 2/10/2014.
 */
public class ItemForgeHammer extends Item {

    public ItemForgeHammer() {
        super();
        this.setMaxDamage(100);
        this.setCreativeTab(MagiciansArtifice.tab);
        this.setUnlocalizedName("forgehammer");
        this.setTextureName(ModInfo.MODID + ":crafting/forgehammer");
        ItemRegistry.items.add(this);
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean b) {
        int uses;
        NBTTagCompound nbt = stack.getTagCompound();
        if (nbt != null && nbt.hasKey("Uses")) {
            uses = nbt.getInteger("Uses");
        } else {
            uses = 100;
            nbt.setInteger("Uses", uses);
            stack.setTagCompound(nbt);
        }
        if (!KeyHelper.isShiftKeyDown()) {
            list.add(TextHelper.SHIFTFORMORE);
        } else {
            if (uses >= 0) {
                list.add("Uses left: " + uses);
            }
        }
    }
}
