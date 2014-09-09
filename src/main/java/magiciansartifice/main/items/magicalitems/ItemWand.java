package magiciansartifice.main.items.magicalitems;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.core.libs.ModInfo;
import magiciansartifice.main.core.utils.TextHelper;
import magiciansartifice.main.items.ItemRegistry;
import magiciansartifice.main.magic.PlayerSpells;
import magiciansartifice.main.magic.spells.Spells;
import magiciansartifice.main.core.utils.KeyHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ItemWand extends Item {

    private int wandLevel;
    public static ArrayList<String> setting = new ArrayList<String>();

    public static DamageSource forbidden = (new DamageSource("forbidden")).setDamageBypassesArmor().setDamageIsAbsolute().setMagicDamage();

    public ItemWand(int level) {
        this.wandLevel = level;
        this.setMaxStackSize(1);
        this.setCreativeTab(MagiciansArtifice.tab);
        if (this.wandLevel == 1) {
            this.setUnlocalizedName("magiciansWand");
        } else {
            this.setUnlocalizedName("magiciansWand" + this.wandLevel);
        }
        this.setTextureName(ModInfo.MODID + ":wands/magiciansWand" + this.wandLevel);
        this.setFull3D();
        addSettings();
        MinecraftForge.EVENT_BUS.register(this);
        ItemRegistry.items.add(this);
    }

    public ItemWand() {
        this.wandLevel = 1;
        this.setMaxStackSize(1);
        this.setCreativeTab(MagiciansArtifice.tab);
        this.setUnlocalizedName("magiciansWand");
        this.setTextureName(ModInfo.MODID + ":wands/magicianWand");
        this.setFull3D();
        addSettings();
        MinecraftForge.EVENT_BUS.register(this);
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
    {
        int settingNum = 0;
        NBTTagCompound nbt = stack.getTagCompound();

        if (nbt == null) {
            nbt = new NBTTagCompound();
            nbt.setInteger("currentSpell", settingNum);
            stack.setTagCompound(nbt);
        }
        else {
            if (nbt.hasKey("currentSpell")) {
                settingNum = nbt.getInteger("currentSpell");
            }
        }

/*        if (!player.isSneaking()) {
            if (player.getEntityData().hasKey("currentSpell")) {
                System.err.println("Has current spell!");
                if (player.getEntityData().getInteger("currentSpell") == 1 && player.getEntityData().hasKey("spell1") && player.getEntityData().getBoolean("spell1") == true) {
                    System.err.println("Current spell is one and working!");
                    if (stack.getTagCompound().getInteger("wandEssence") > 0) {
                        System.err.println("Essence != 0");
                        PlayerSpells.levitation(player);
                        Random random = new Random();
                        if (random.nextInt(100) > 75) {
                            if (stack.getTagCompound().hasKey("wandEssence")) {
                                int newEssence = stack.getTagCompound().getInteger("wandEssence") - 1;
                                stack.getTagCompound().setInteger("wandEssence", newEssence);
                            }
                        }
                    } else {
                        player.addChatComponentMessage(new ChatComponentTranslation("spell.essence.out").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.DARK_AQUA).setItalic(true)));
                    }
                } else if (!player.getEntityData().getBoolean("spell1")) {
                    player.addChatComponentMessage(new ChatComponentTranslation("spell.complicated").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.DARK_RED).setBold(true)));
                }

                if (player.getEntityData().getInteger("currentSpell") == 3 && player.getEntityData().hasKey("spell3") && player.getEntityData().getBoolean("spell3")) {
                    PlayerSpells.dimensionShift(player);
                }

            }
        } else {
            if (player.getEntityData().hasKey("currentSpell")) {
                int nextSpell = player.getEntityData().getInteger("currentSpell") + 1;
                if (nextSpell == 4) {
                    player.getEntityData().setInteger("currentSpell",0);
                    System.err.println("Reset the amount!");
                } else {
                    if (player.getEntityData().hasKey("spell" + nextSpell)) {
                        if (player.getEntityData().getBoolean("spell" + nextSpell)) {
                            if (!player.worldObj.isRemote) {
                                player.getEntityData().setInteger("currentSpell", nextSpell);
                                System.err.println(nextSpell);
                            }
                        }
                    }
                }
            } else {
                player.getEntityData().setInteger("currentSpell",0);
            }
        } */

        if (player.isSneaking()) {
            if (++settingNum >= setting.size()) {
                    settingNum = 0;
            }

            nbt.setInteger("currentSpell", settingNum);
            stack.setTagCompound(nbt);
        } else {
            if (Spells.spells.get(settingNum).isRightClickSpell()) {
                Spells.spells.get(settingNum).beginSpell(world,(int)Math.floor(player.posX),(int)Math.floor(player.posY),(int)Math.floor(player.posZ),player);
            } else if (Spells.spells.get(settingNum).getEaten()) {
                player.setItemInUse(stack,40);
            }
        }

        return stack;
    }

    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.bow;
    }


    @Override
    public void onUpdate(ItemStack itemStack, World world, Entity entity, int meta, boolean someBoolean) {
            if (itemStack.stackTagCompound == null) {
                itemStack.stackTagCompound = new NBTTagCompound();
            }

                if (!itemStack.getTagCompound().hasKey("wandLevel")) {
                    itemStack.getTagCompound().setInteger("wandLevel",this.wandLevel);
                }
                if (!itemStack.getTagCompound().hasKey("wandEssence")) {
                    itemStack.getTagCompound().setInteger("wandEssence",25 * this.getWandLevel());
                }
                if (itemStack.getItem() instanceof ItemWand) {
                    if (((ItemWand) itemStack.getItem()).wandLevel >= 2) {
                        if (!itemStack.getTagCompound().hasKey("wandEssenceN")) {
                            itemStack.getTagCompound().setInteger("wandEssenceN", 25 * this.getWandLevel());
                        }
                    }
                    if (((ItemWand) itemStack.getItem()).wandLevel >= 3) {
                        if (!itemStack.getTagCompound().hasKey("wandEssenceE")) {
                            itemStack.getTagCompound().setInteger("wandEssenceE", 25 * this.getWandLevel());
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
                    itemStack.getTagCompound().setInteger("currentSpell",0);
                }

    }


    @Override
    public boolean itemInteractionForEntity(ItemStack itemStack, EntityPlayer player, EntityLivingBase entityLivingBase) {

            /*if (player.getEntityData().getInteger("currentSpell") == 2 && player.getEntityData().hasKey("spell2") && player.getEntityData().getBoolean("spell2") == true) {
                if (entityLivingBase instanceof EntitySheep) {
                    if (itemStack.getTagCompound().getInteger("wandEssence") > 0) {
                        EntitySheep sheep = (EntitySheep) entityLivingBase;
                        int sheepColor = sheep.getFleeceColor() + 1;
                        if (sheepColor == 16) {
                            sheep.setFleeceColor(0);
                        } else {
                            sheep.setFleeceColor(sheepColor);
                        }
                        Random random = new Random();
                        if (random.nextInt(100) > 90) {
                            if (itemStack.getTagCompound().hasKey("wandEssence")) {
                                int newEssence = itemStack.getTagCompound().getInteger("wandEssence") - 1;
                                itemStack.getTagCompound().setInteger("wandEssence", newEssence);
                            }
                        }
                    }
                }
            }

            if (player.getEntityData().getInteger("currentSpell") == 4 && player.getEntityData().hasKey("spell4") && player.getEntityData().getBoolean("spell4") == true) {
                System.err.println("Code pass 1!");
                if (itemStack.getItem() instanceof ItemWand && ((ItemWand) itemStack.getItem()).wandLevel >= 3) {
                    System.err.println("Code pass 2!");
                    if (itemStack.getTagCompound().getInteger("wandEssenceE") > 0 && itemStack.getTagCompound().getInteger("wandEssenceN") > 0) {
                        System.err.println("Code pass 3!");
                        PlayerSpells.murderSpell(player,entityLivingBase);
                        if (player.worldObj.isRemote) {
                            PlayerSpells.broadcastUnforgivableCurse(player);
                        }
                    }
                }
            } */

            int x = (int) Math.floor(player.posX);
            int y = (int) Math.floor(player.posY);
            int z = (int) Math.floor(player.posZ);

            if (Spells.spells.get(itemStack.stackTagCompound.getInteger("currentSpell")).isEntitySpell()) {
                Spells.spells.get(itemStack.stackTagCompound.getInteger("currentSpell")).beginSpell(player.worldObj,x,y,z,player,entityLivingBase);
            }

        return true;
    }

    @SuppressWarnings("unchecked")
    public void addInformation(ItemStack itemStack, EntityPlayer player, List lore, boolean par4) {
        if (KeyHelper.isShiftKeyDown()) {
            lore.add(EnumChatFormatting.GOLD + "~-~-~");
            lore.add(EnumChatFormatting.BLUE + "" + EnumChatFormatting.ITALIC + "Wand Level: " + ((ItemWand)itemStack.getItem()).wandLevel);
            lore.add("");
            if (itemStack.getTagCompound() != null && itemStack.getTagCompound().hasKey("wandEssence")) {
                lore.add(EnumChatFormatting.GREEN + "Overworld Essence: " + itemStack.getTagCompound().getInteger("wandEssence"));
                if (((ItemWand)itemStack.getItem()).wandLevel >= 2) {
                    lore.add(EnumChatFormatting.RED + "Nether Essence: " + itemStack.getTagCompound().getInteger("wandEssenceN"));
                }
                if (((ItemWand)itemStack.getItem()).wandLevel >= 3) {
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
                lore.add(EnumChatFormatting.YELLOW + "" + EnumChatFormatting.BOLD + "" + EnumChatFormatting.ITALIC + "" + EnumChatFormatting.UNDERLINE + "RELEASE SHIFT TO HIDE INFORMATION");
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
                lore.add(EnumChatFormatting.BLUE + "" + EnumChatFormatting.BOLD + "" + EnumChatFormatting.ITALIC + "" + EnumChatFormatting.UNDERLINE + "RELEASE CTRL TO HIDE OWNER INFORMATION");
            }
        }

        if (KeyHelper.isCtrlKeyDown() && KeyHelper.isShiftKeyDown()) {
            lore.add("");
            lore.add(EnumChatFormatting.YELLOW + "" + EnumChatFormatting.BOLD + "" + EnumChatFormatting.ITALIC + "" + EnumChatFormatting.UNDERLINE + "RELEASE SHIFT TO HIDE INFORMATION");
            lore.add(EnumChatFormatting.BLUE + "" + EnumChatFormatting.BOLD + "" + EnumChatFormatting.ITALIC + "" + EnumChatFormatting.UNDERLINE + "RELEASE CTRL TO HIDE OWNER INFORMATION");
        }

        if (!KeyHelper.isShiftKeyDown() && !KeyHelper.isCtrlKeyDown()) {
            lore.add(EnumChatFormatting.GOLD + "~-~-~");
            lore.add(EnumChatFormatting.YELLOW + "" + EnumChatFormatting.BOLD + "" + EnumChatFormatting.ITALIC + "" + EnumChatFormatting.UNDERLINE + "HOLD DOWN SHIFT TO SHOW INFORMATION");
            lore.add(EnumChatFormatting.BLUE + "" + EnumChatFormatting.BOLD + "" + EnumChatFormatting.ITALIC + "" + EnumChatFormatting.UNDERLINE + "HOLD DOWN CTRL TO SHOW OWNER INFORMATION");
        }
    }

    @SubscribeEvent
    public void lore(ItemTooltipEvent event) {
        if (event.entityPlayer.worldObj.isRemote) {
            if (event.itemStack != null && event.itemStack.getItem() instanceof ItemWand) {
                ItemWand item = (ItemWand) event.itemStack.getItem();

            }
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
            Spells.spells.get(stack.stackTagCompound.getInteger("currentSpell")).beginSpell(world,x,y,z,player);
        }
        return stack;
    }

}


    /*@SubscribeEvent
    public void magicWords(ServerChatEvent event) {
        if (event.player.getCurrentEquippedItem() != null && event.player.getCurrentEquippedItem().getItem() == ItemRegistry.magiciansWand) {
            if (event.message.contains("Abra-cadabra")) {
                if (event.message.contains("sheep-cadabra")) {
                    event.component = new ChatComponentTranslation("spell.sheep");
                    event.component.setChatStyle(new ChatStyle().setItalic(true));
                    if (!event.message.contains("egg")) {
                        EntitySheep sheep = new EntitySheep(event.player.worldObj);
                        Random random = new Random();
                        sheep.setFleeceColor(random.nextInt(15));
                        sheep.setLocationAndAngles(event.player.posX, event.player.posY + 1, event.player.posZ, event.player.cameraYaw, event.player.cameraPitch);
                        event.player.worldObj.spawnEntityInWorld(sheep);
                    } else {
                        event.player.inventory.addItemStackToInventory(new ItemStack(Items.spawn_egg,1,91));
                    }
                }
                if (event.message.contains("zombie-cadabra")) {
                    event.component = new ChatComponentTranslation("spell.zombie");
                    event.component.setChatStyle(new ChatStyle().setItalic(true));
                    if (!event.message.contains("egg")) {
                        EntityZombie zombie = new EntityZombie(event.player.worldObj);
                        zombie.setLocationAndAngles(event.player.posX, event.player.posY + 1, event.player.posZ, event.player.cameraYaw, event.player.cameraPitch);
                        event.player.worldObj.spawnEntityInWorld(zombie);
                    } else {
                        event.player.inventory.addItemStackToInventory(new ItemStack(Items.spawn_egg,1,54));
                    }
                }
            }
        }
    } */
