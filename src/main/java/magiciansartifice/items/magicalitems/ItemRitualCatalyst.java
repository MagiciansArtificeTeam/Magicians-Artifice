package magiciansartifice.items.magicalitems;

import magiciansartifice.MagiciansArtifice;
import magiciansartifice.blocks.BlockRegistry;
import magiciansartifice.items.ItemRegistry;
import magiciansartifice.libs.ModInfo;
import magiciansartifice.spells.rituals.RitualFlight;
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
    private static int settingNum = 0;

    public ItemRitualCatalyst()
    {
        this.setUnlocalizedName("ritual.catalyst");
        this.setTextureName(ModInfo.MODID + ":magical/ritualCatalyst");
        this.setCreativeTab(MagiciansArtifice.tab);
        ItemRegistry.items.add(this);
        //ItemStack stack = new ItemStack(this);
        //settingNum = stack.getTagCompound().getInteger("settingNBT");
        addSettings();
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean p_77624_4_) {
        list.add(TextHelper.SHIFTFORMORE);
        if (KeyHelper.isShiftKeyDown()) {
            list.remove(1);
            list.add("Current ritual setting: " + setting.get(settingNum));
        }
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
    {
        if (player.isSneaking()) {
            settingNum += 1;
            if (settingNum > setting.size()) {
                settingNum = 0;
            }
            NBTBase settingNBT = new NBTTagInt(settingNum);
            itemStack.setTagInfo("settingNBT", settingNBT);
            return false;
        }
        if (world.getBlock(x, y, z) == BlockRegistry.ritualCornerStone) {
            switch (settingNum) {
                case 0: RitualWaterCreation.waterCreation(x, y, z, world, player); break;
                case 1: RitualFlight.flyingRitual(x, y, z, world, player); break;
            }
        }
        return false;
    }

    public void addSettings() {
        setting.add("Auga Creación");
        setting.add("Máxico do");
    }

}
