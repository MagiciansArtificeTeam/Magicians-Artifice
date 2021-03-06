package magiciansartifice.main.items.magicalitems;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.core.libs.ModInfo;
import magiciansartifice.main.core.utils.TextHelper;
import magiciansartifice.main.core.utils.registries.ItemRegistry;
import magiciansartifice.main.magic.spells.Spells;
import magiciansartifice.main.core.utils.KeyHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ServerChatEvent;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "rawtypes", "unused"})
public class ItemWand extends Item {

    private int wandLevel;
    public static ArrayList<String> setting = new ArrayList<String>();

    public static DamageSource forbidden = (new DamageSource("forbidden")).setDamageBypassesArmor().setDamageIsAbsolute().setMagicDamage();

    public ItemWand(int level) {
        this.wandLevel = level;
        this.setMaxStackSize(1);
        if (this.wandLevel == -1) {
            this.setCreativeTab(MagiciansArtifice.tab);
        }
        if (this.wandLevel == 1) {
            this.setUnlocalizedName("magiciansWand");
        } else {
            this.setUnlocalizedName("magiciansWand" + this.wandLevel);
        }
        this.setTextureName(ModInfo.MODID + ":wands/magiciansWand" + this.wandLevel);
        addSettings();
        MinecraftForge.EVENT_BUS.register(this);
        ItemRegistry.items.add(this);
    }

    public ItemWand() {
        this.wandLevel = 1;
        this.setMaxStackSize(1);
        this.setUnlocalizedName("magiciansWand");
        this.setTextureName(ModInfo.MODID + ":wands/magicianWand");
        addSettings();
        MinecraftForge.EVENT_BUS.register(this);
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        int settingNum = 0;
        NBTTagCompound nbt = stack.getTagCompound();

        if (nbt == null) {
            nbt = new NBTTagCompound();
            nbt.setInteger("currentSpell", settingNum);
            stack.setTagCompound(nbt);
        } else {
            if (nbt.hasKey("currentSpell")) {
                settingNum = nbt.getInteger("currentSpell");
            }
        }

        if (player.isSneaking()) {
            if (++settingNum >= setting.size()) {
                settingNum = 0;
            }

            if (!Spells.spells.get(settingNum).isWandLevelMet(stack)) {
                settingNum++;
            }

            nbt.setInteger("currentSpell", settingNum);
            stack.setTagCompound(nbt);
            world.playSoundAtEntity(player, ModInfo.MODID + ":magic_evil", 1.0F, 1.0F);
        } else {
            if (Spells.spells.get(settingNum).isRightClickSpell()) {
                Spells.spells.get(settingNum).beginSpell(world, (int) Math.floor(player.posX), (int) Math.floor(player.posY), (int) Math.floor(player.posZ), player);
            } else if (Spells.spells.get(settingNum).getEaten()) {
                player.setItemInUse(stack, 40);
            }
        }

        return stack;
    }

    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    public EnumAction getItemUseAction(ItemStack stack) {
        return EnumAction.bow;
    }


    @Override
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {

        int x = (int) Math.floor(player.posX);
        int y = (int) Math.floor(player.posY);
        int z = (int) Math.floor(player.posZ);

        if (Spells.spells.get(stack.stackTagCompound.getInteger("currentSpell")).isLeftClickEntitySpell()) {
            Spells.spells.get(stack.stackTagCompound.getInteger("currentSpell")).beginSpell(player.worldObj, x, y, z, player, entity);
        }
        return true;
    }

    @Override
    public void onUpdate(ItemStack itemStack, World world, Entity entity, int meta, boolean someBoolean) {
        if (itemStack.stackTagCompound == null) {
            itemStack.stackTagCompound = new NBTTagCompound();
        }

        if (!itemStack.getTagCompound().hasKey("wandLevel")) {
            itemStack.getTagCompound().setInteger("wandLevel", this.wandLevel);
        }
        if (!itemStack.getTagCompound().hasKey("wandEssence")) {
            if (itemStack.getTagCompound().getInteger("wandLevel") < 4) {
                itemStack.getTagCompound().setInteger("wandEssence", 25 * this.getWandLevel());
            } else {
                itemStack.getTagCompound().setInteger("wandEssence", Integer.MAX_VALUE);
            }
        }
        if (itemStack.getItem() instanceof ItemWand) {
            if (((ItemWand) itemStack.getItem()).wandLevel >= 2) {
                if (!itemStack.getTagCompound().hasKey("wandEssenceN")) {
                    if (itemStack.getTagCompound().getInteger("wandLevel") < 4) {
                        itemStack.getTagCompound().setInteger("wandEssenceN", 25 * this.getWandLevel());
                    } else {
                        itemStack.getTagCompound().setInteger("wandEssenceN", Integer.MAX_VALUE);
                    }
                }
            }
            if (((ItemWand) itemStack.getItem()).wandLevel >= 3) {
                if (!itemStack.getTagCompound().hasKey("wandEssenceE")) {
                    if (itemStack.getTagCompound().getInteger("wandLevel") < 4) {
                        itemStack.getTagCompound().setInteger("wandEssenceE", 25 * this.getWandLevel());
                    } else {
                        itemStack.getTagCompound().setInteger("wandEssenceE", Integer.MAX_VALUE);
                    }
                }
            }
        }
        if (entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entity;
            if (!itemStack.getTagCompound().hasKey("ownerName")) {
                itemStack.getTagCompound().setString("ownerName", player.getCommandSenderName());
            }
            if (!itemStack.getTagCompound().hasKey("ownerHealth")) {
                itemStack.getTagCompound().setFloat("ownerHealth", player.getHealth());
            }
            if (!itemStack.getTagCompound().hasKey("ownerHunger")) {
                itemStack.getTagCompound().setInteger("ownerHunger", player.getFoodStats().getFoodLevel());
            }
        }
        if (!itemStack.stackTagCompound.hasKey("currentSpell")) {
            itemStack.getTagCompound().setInteger("currentSpell", 0);
        }

        if (itemStack.getTagCompound().getInteger("currentSpell") >= setting.size()) {
            itemStack.getTagCompound().setInteger("currentSpell", 0);
        }

    }


    @Override
        public boolean itemInteractionForEntity(ItemStack itemStack, EntityPlayer player, EntityLivingBase entityLivingBase) {
        int x = (int) Math.floor(player.posX);
        int y = (int) Math.floor(player.posY);
        int z = (int) Math.floor(player.posZ);

        if (Spells.spells.get(itemStack.stackTagCompound.getInteger("currentSpell")).isEntitySpell()) {
            Spells.spells.get(itemStack.stackTagCompound.getInteger("currentSpell")).beginSpell(player.worldObj, x, y, z, player, entityLivingBase);
        }

        return true;
    }

    public void addInformation(ItemStack itemStack, EntityPlayer player, List lore, boolean par4) {
            TextHelper.deprecateText(lore);
        if (KeyHelper.isShiftKeyDown()) {
            lore.add(EnumChatFormatting.GOLD + "~-~-~");
            lore.add(EnumChatFormatting.BLUE + "" + EnumChatFormatting.ITALIC + "Wand Level: " + ((ItemWand) itemStack.getItem()).wandLevel);
            lore.add("");
            if (itemStack.getTagCompound() != null && itemStack.getTagCompound().hasKey("wandEssence")) {
                lore.add(EnumChatFormatting.GREEN + "Overworld Essence: " + itemStack.getTagCompound().getInteger("wandEssence"));
                if (((ItemWand) itemStack.getItem()).wandLevel >= 2) {
                    lore.add(EnumChatFormatting.RED + "Nether Essence: " + itemStack.getTagCompound().getInteger("wandEssenceN"));
                }
                if (((ItemWand) itemStack.getItem()).wandLevel >= 3) {
                    lore.add(EnumChatFormatting.DARK_PURPLE + "End Essence: " + itemStack.getTagCompound().getInteger("wandEssenceE"));
                }
            }

            lore.add("");
            if (itemStack.hasTagCompound()) {
                if (!itemStack.stackTagCompound.hasKey("currentSpell")) {
                    lore.add(TextHelper.TEAL + "Current Spell: None");
                } else {
                    lore.add(TextHelper.TEAL + "Current Spell: " + Spells.spells.get(itemStack.stackTagCompound.getInteger("currentSpell")).getLocalizedName());
                }
                lore.add("");
            }

            lore.add("");
            if (!KeyHelper.isCtrlKeyDown()) {
                lore.add(EnumChatFormatting.YELLOW + "" + EnumChatFormatting.ITALIC + "" + EnumChatFormatting.UNDERLINE + "RELEASE SHIFT TO HIDE INFORMATION");
            }
        }

        if (KeyHelper.isCtrlKeyDown() && itemStack.getTagCompound() != null && itemStack.getTagCompound().hasKey("ownerName") && itemStack.getTagCompound().hasKey("ownerHealth") && itemStack.getTagCompound().hasKey("ownerHunger")) {
            lore.add(EnumChatFormatting.GOLD + "~-~-~");
            lore.add(EnumChatFormatting.BLUE + "" + EnumChatFormatting.ITALIC + "On creation, the wand's owner had these stats:");
            lore.add("");
            lore.add(EnumChatFormatting.BLUE + "" + EnumChatFormatting.UNDERLINE + "Owner Name: " + itemStack.getTagCompound().getString("ownerName"));
            lore.add(EnumChatFormatting.BLUE + "" + EnumChatFormatting.UNDERLINE + "Owner Health: " + itemStack.getTagCompound().getFloat("ownerHealth"));
            lore.add(EnumChatFormatting.BLUE + "" + EnumChatFormatting.UNDERLINE + "Owner Hunger: " + itemStack.getTagCompound().getInteger("ownerHunger"));
            lore.add("");
            lore.add("");
            if (!KeyHelper.isShiftKeyDown()) {
                lore.add(EnumChatFormatting.BLUE + "" + EnumChatFormatting.ITALIC + "" + EnumChatFormatting.UNDERLINE + "RELEASE CTRL TO HIDE OWNER INFORMATION");
            }
        }

        if (KeyHelper.isCtrlKeyDown() && KeyHelper.isShiftKeyDown()) {
            lore.add("");
            lore.add(EnumChatFormatting.YELLOW + "" + EnumChatFormatting.ITALIC + "" + EnumChatFormatting.UNDERLINE + "RELEASE SHIFT TO HIDE INFORMATION");
            lore.add(EnumChatFormatting.BLUE + "" + EnumChatFormatting.ITALIC + "" + EnumChatFormatting.UNDERLINE + "RELEASE CTRL TO HIDE OWNER INFORMATION");
        }

        if (!KeyHelper.isShiftKeyDown() && !KeyHelper.isCtrlKeyDown()) {
            lore.add(EnumChatFormatting.GOLD + "~-~-~");
            lore.add(EnumChatFormatting.YELLOW + "" + EnumChatFormatting.ITALIC + "" + EnumChatFormatting.UNDERLINE + "HOLD DOWN SHIFT TO SHOW INFORMATION");
            lore.add(EnumChatFormatting.BLUE + "" + EnumChatFormatting.ITALIC + "" + EnumChatFormatting.UNDERLINE + "HOLD DOWN CTRL TO SHOW OWNER INFORMATION");
        }
    }

    public int getWandLevel() {
        return this.wandLevel;
    }

    public void addSettings() {
        setting = new ArrayList<String>();
        for (int i = 0; i < Spells.spells.size(); i++) {
            setting.add(Spells.spells.get(i).getLocalizedName());
        }
    }

    public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
        int x = (int) Math.floor(player.posX);
        int y = (int) Math.floor(player.posY);
        int z = (int) Math.floor(player.posZ);

        if (Spells.spells.get(stack.stackTagCompound.getInteger("currentSpell")).getEaten()) {
            Spells.spells.get(stack.stackTagCompound.getInteger("currentSpell")).beginSpell(world, x, y, z, player);
        }
        return stack;
    }


    @SubscribeEvent
    public void magicWords(ServerChatEvent event) {

        int x = (int) Math.floor(event.player.posX);
        int y = (int) Math.floor(event.player.posY);
        int z = (int) Math.floor(event.player.posZ);

        if (event.player.getCurrentEquippedItem() != null) {
            if (event.player.getCurrentEquippedItem().getItem() instanceof ItemWand) {
                if (Spells.spells.get(event.player.getCurrentEquippedItem().stackTagCompound.getInteger("currentSpell")).getCastSpell()) {
                    if (event.message.startsWith(Spells.spells.get(event.player.getCurrentEquippedItem().stackTagCompound.getInteger("currentSpell")).getMagicWords())) {
                        Spells.spells.get(event.player.getCurrentEquippedItem().stackTagCompound.getInteger("currentSpell")).beginSpell(event.player.worldObj,x,y,z,event.player,event.message.substring(Spells.spells.get(event.player.getCurrentEquippedItem().stackTagCompound.getInteger("currentSpell")).getMagicWords().length() + 1));
                    }
                }
            }
        }
    }
}
