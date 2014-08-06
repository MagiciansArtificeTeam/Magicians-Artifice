package magiciansartifice.items.magicalitems;

import magiciansartifice.MagiciansArtifice;
import magiciansartifice.blocks.BlockRegistry;
import magiciansartifice.items.ItemRegistry;
import magiciansartifice.libs.ModInfo;
import magiciansartifice.spells.rituals.RitualDeath;
import magiciansartifice.spells.rituals.RitualFlight;
import magiciansartifice.spells.rituals.RitualHeal;
import magiciansartifice.spells.rituals.RitualWaterCreation;
import magiciansartifice.utils.KeyHelper;
import magiciansartifice.utils.TextHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.world.World;
import scala.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by poppypoppop on 3/08/2014.
 */
public class ItemRitualCatalyst extends Item {
    public static ArrayList<String> setting = new ArrayList<String>();

    public ItemRitualCatalyst()
    {
        this.setUnlocalizedName("ritual.catalyst");
        this.setTextureName(ModInfo.MODID + ":magical/ritualCatalyst");
        this.setCreativeTab(MagiciansArtifice.tab);
        ItemRegistry.items.add(this);
        addSettings();
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean p_77624_4_) {
        if (KeyHelper.isShiftKeyDown()) {
            NBTTagCompound nbt = stack.getTagCompound();
            if (nbt != null && nbt.hasKey("SettingNum"))
            {
                int settingNum = nbt.getInteger("SettingNum");
                if (settingNum >= 0 && settingNum < setting.size()) {
                    list.add(TextHelper.localize("setting.current") + setting.get(settingNum));
                }
                else {
                    list.add(TextHelper.localize("setting.invalid") + settingNum);
                }
            }
            else {
                list.add(TextHelper.localize("setting.none"));
            }
        }
        else {
            list.add(TextHelper.SHIFTFORMORE);
        }
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
    {
        int settingNum = 0;
        NBTTagCompound nbt = itemStack.getTagCompound();

        if (nbt == null) {
            nbt = new NBTTagCompound();
            nbt.setInteger("SettingNum", settingNum);
            itemStack.setTagCompound(nbt);
        }
        else {
            settingNum = nbt.getInteger("SettingNum");
        }

        if (player.isSneaking()) {
            if (++settingNum >= setting.size()) {
                settingNum = 0;
            }
            nbt.setInteger("SettingNum", settingNum);
            itemStack.setTagCompound(nbt);
            return false;
        }
        if (world.getBlock(x, y, z) == BlockRegistry.ritualCornerStone) {
            switch (settingNum) {
                case 0: RitualWaterCreation.waterCreation(x, y, z, world, player); break;
                case 1: player.getEntityData().setBoolean("flightRitualActive",true); RitualFlight.flyingRitual(x, y, z, world, player); break;
                case 2: RitualHeal.healRitual(x, y, z, world, player); break;
                case 3: RitualDeath.deathRitual(x, y, z, world, player); break;
            }
        }
        return false;
    }

    public void addSettings() {
        setting.add(" Ritual of Auga Creación");
        setting.add(" Ritual of Máxico do");
        setting.add(" Ritual of Cura");
        setting.add(" Ritual of Morte");
    }
}
