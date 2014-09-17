package magiciansartifice.main.items.magicalitems;

import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.blocks.BlockRegistry;
import magiciansartifice.main.items.ItemRegistry;
import magiciansartifice.main.magic.rituals.*;
import magiciansartifice.main.core.libs.ModInfo;
import magiciansartifice.main.tileentities.magic.TileEntityRitualCornerstone;
import magiciansartifice.main.core.utils.KeyHelper;
import magiciansartifice.main.core.utils.TextHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "rawtypes"})
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
                    list.add(TextHelper.localize("setting.invalid"));
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
            if (world.getTileEntity(x,y,z) instanceof TileEntityRitualCornerstone) {
                TileEntityRitualCornerstone te = (TileEntityRitualCornerstone) world.getTileEntity(x,y,z);
                if (te.getOwner() != null && te.getOwner().equals(player.getPersistentID())) {
                    switch (settingNum) {
                        //case 0: RitualWaterCreation.waterCreation(x, y, z, world, player); break;
                        case 0:
                            player.getEntityData().setBoolean("flightRitualActive", true); /*Rituals.rituals.get(settingNum).startRitual(x,y,z,world,player);*/
                            break;
                        //case 2: RitualHeal.healRitual(x, y, z, world, player); break;
                        //case 3: RitualDeath.deathRitual(x, y, z, world, player); break;
                        case 4:
                            break;
                    }

                    Rituals.rituals.get(settingNum).startRitual(x, y, z, world, player);
                } else {
                    if (te.getOwner() != null) {
                        if (!world.isRemote) {
                            player.addChatComponentMessage(new ChatComponentTranslation("cornerstone.owner.incorrect", te.getOwner().toString()).setChatStyle(new ChatStyle().setColor(EnumChatFormatting.DARK_RED)));
                        }
                    } else {
                        if (!world.isRemote) {
                            player.addChatComponentMessage(new ChatComponentTranslation("cornerstone.owner.null").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.DARK_RED)));
                        }
                    }
                }
            }
        }
        return false;
    }

    public void addSettings() {
        for (int i = 0; i < Rituals.rituals.size(); i++) {
            setting.add(Rituals.rituals.get(i).getLocalizedName());
        }
    }

}
