package magiciansartifice.items.wand;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import magiciansartifice.MagiciansArtifice;
import magiciansartifice.libs.ModInfo;
import magiciansartifice.items.ItemRegistry;
import magiciansartifice.spells.PlayerSpells;
import magiciansartifice.utils.KeyHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;

import java.util.Random;

public class Wand extends Item {

    private int wandLevel;

    public Wand(int level) {
        this.wandLevel = level;
        this.setMaxStackSize(1);
        this.setCreativeTab(MagiciansArtifice.tab);
        this.setUnlocalizedName("magiciansWand");
        this.setTextureName(ModInfo.MODID + ":wands/magicianWand");
        this.setFull3D();
        MinecraftForge.EVENT_BUS.register(this);
        ItemRegistry.items.add(this);
    }

    public Wand() {
        this.wandLevel = 1;
        this.setMaxStackSize(1);
        this.setCreativeTab(MagiciansArtifice.tab);
        this.setUnlocalizedName("magiciansWand");
        this.setTextureName(ModInfo.MODID + ":wands/magicianWand");
        this.setFull3D();
        MinecraftForge.EVENT_BUS.register(this);
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
    {
        if (!player.isSneaking()) {
            if (player.getEntityData().hasKey("currentSpell")) {
                if (player.getEntityData().getInteger("currentSpell") == 1 && player.getEntityData().hasKey("spell1") && player.getEntityData().getBoolean("spell1") == true) {
                    if (stack.getTagCompound().getInteger("wandEssence") > 0) {
                        PlayerSpells.levitation(player);
                        Random random = new Random();
                        if (random.nextInt(100) > 75) {
                            if (stack.getTagCompound().hasKey("wandEssence")) {
                                int newEssence = stack.getTagCompound().getInteger("wandEssence") - 1;
                                stack.getTagCompound().setInteger("wandEssence", newEssence);
                            }
                        }
                    }
                }
            }
        } else {
            if (player.getEntityData().hasKey("currentSpell")) {
                int nextSpell = player.getEntityData().getInteger("currentSpell") + 1;
                if (nextSpell == 3) {
                    player.getEntityData().setInteger("currentSpell",0);
                } else {
                    if (player.getEntityData().hasKey("spell" + nextSpell)) {
                        if (player.getEntityData().getBoolean("spell" + nextSpell) == true) {
                            player.getEntityData().setInteger("currentSpell",nextSpell);
                        }
                    }
                }
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
                itemStack.getTagCompound().setInteger("wandLevel",this.wandLevel);
                itemStack.getTagCompound().setInteger("wandEssence",25);
                if (itemStack.getItem() instanceof Wand) {
                    if (((Wand) itemStack.getItem()).wandLevel >= 2) {
                        itemStack.getTagCompound().setInteger("wandEssenceN",25);
                    }
                    if (((Wand) itemStack.getItem()).wandLevel >= 3) {
                        itemStack.getTagCompound().setInteger("wandEssenceE",25);
                    }
                }
                if (entity instanceof EntityPlayer) {
                    EntityPlayer player = (EntityPlayer) entity;
                    itemStack.getTagCompound().setString("ownerName",player.getCommandSenderName());
                    itemStack.getTagCompound().setFloat("ownerHealth",player.getHealth());
                    itemStack.getTagCompound().setInteger("ownerHunger",player.getFoodStats().getFoodLevel());
                }
            } else {
                if (!itemStack.getTagCompound().hasKey("wandLevel")) {
                    itemStack.getTagCompound().setInteger("wandLevel",this.wandLevel);
                }
                if (!itemStack.getTagCompound().hasKey("wandEssence")) {
                    itemStack.getTagCompound().setInteger("wandEssence",25);
                }
                if (itemStack.getItem() instanceof Wand) {
                    if (((Wand) itemStack.getItem()).wandLevel >= 2) {
                        if (!itemStack.getTagCompound().hasKey("wandEssenceN")) {
                            itemStack.getTagCompound().setInteger("wandEssenceN", 25);
                        }
                    }
                    if (((Wand) itemStack.getItem()).wandLevel >= 3) {
                        if (!itemStack.getTagCompound().hasKey("wandEssenceE")) {
                            itemStack.getTagCompound().setInteger("wandEssenceE", 25);
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
            }

            if (entity instanceof EntityPlayer) {
                EntityPlayer player = (EntityPlayer) entity;
                if (!player.getEntityData().hasKey("currentSpell")) {
                    player.getEntityData().setInteger("currentSpell", 0);
                }
                if (!player.getEntityData().hasKey("spell1")) {
                    player.getEntityData().setBoolean("spell1", true);
                }
                if (!player.getEntityData().hasKey("spell2")) {
                    player.getEntityData().setBoolean("spell2", true);
                }
                if (!player.getEntityData().hasKey("spell3")) {
                    player.getEntityData().setBoolean("spell3",true);
                }
            }

    }


    @Override
    public boolean itemInteractionForEntity(ItemStack itemStack, EntityPlayer player, EntityLivingBase entityLivingBase) {
        if (entityLivingBase instanceof EntitySheep) {

            if (player.getEntityData().getInteger("currentSpell") == 2 && player.getEntityData().hasKey("spell2") && player.getEntityData().getBoolean("spell2") == true) {
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
            return true;
        }
        return false;
    }

    @SubscribeEvent
    public void toolTip(ItemTooltipEvent event) {
        if (event.itemStack != null && event.itemStack.getItem() instanceof Wand) {
            if (KeyHelper.isShiftKeyDown()) {
                event.toolTip.add(EnumChatFormatting.GOLD + "~-~-~");
                event.toolTip.add(EnumChatFormatting.BLUE + "" + EnumChatFormatting.ITALIC + "Wand Level: " + this.wandLevel);
                event.toolTip.add("");
                if (event.itemStack.getTagCompound() != null && event.itemStack.getTagCompound().hasKey("wandEssence")) {
                    event.toolTip.add(EnumChatFormatting.GREEN + "Overworld Essence: " + event.itemStack.getTagCompound().getInteger("wandEssence"));
                    if (event.itemStack.getItem() instanceof Wand) {
                        Wand item = (Wand) event.itemStack.getItem();
                        if (item.wandLevel >= 2) {
                            event.toolTip.add(EnumChatFormatting.RED + "Nether Essence: " + event.itemStack.getTagCompound().getInteger("wandEssenceN"));
                        }
                        if (item.wandLevel >= 3) {
                            event.toolTip.add(EnumChatFormatting.DARK_PURPLE + "End Essence: " + event.itemStack.getTagCompound().getInteger("wandEssenceE"));
                        }
                    }
                }
                event.toolTip.add("");
                if (event.entityPlayer.getEntityData().hasKey("currentSpell")) {
                    if (event.entityPlayer.getEntityData().getInteger("currentSpell") == 0) {
                            event.toolTip.add(EnumChatFormatting.AQUA + "" + EnumChatFormatting.ITALIC + "Current Spell: NOT SET");
                    } else if (event.entityPlayer.getEntityData().getInteger("currentSpell") == 1) {
                            event.toolTip.add(EnumChatFormatting.AQUA + "" + EnumChatFormatting.ITALIC + "Current Spell: The Levitating Man");
                    } else if (event.entityPlayer.getEntityData().getInteger("currentSpell") == 2) {
                        event.toolTip.add(EnumChatFormatting.AQUA + "" + EnumChatFormatting.ITALIC + "Current Spell: Rainbow Fleece");
                    }
                    event.toolTip.add("");
                }
                event.toolTip.add("");
                if (!KeyHelper.isCtrlKeyDown()) {
                    event.toolTip.add(EnumChatFormatting.YELLOW + "" + EnumChatFormatting.BOLD + "" + EnumChatFormatting.ITALIC + "" + EnumChatFormatting.UNDERLINE + "RELEASE SHIFT TO HIDE INFORMATION");
                }
            }

            if (KeyHelper.isCtrlKeyDown() && event.itemStack.getTagCompound() != null && event.itemStack.getTagCompound().hasKey("ownerName") && event.itemStack.getTagCompound().hasKey("ownerHealth") && event.itemStack.getTagCompound().hasKey("ownerHunger")) {
                event.toolTip.add(EnumChatFormatting.GOLD + "~-~-~");
                event.toolTip.add(EnumChatFormatting.BLUE + "" + EnumChatFormatting.ITALIC + "On creation, the wand's owner had these stats:");
                event.toolTip.add("");
                event.toolTip.add(EnumChatFormatting.BLUE + "" + EnumChatFormatting.UNDERLINE + "Owner Name: " + event.itemStack.getTagCompound().getString("ownerName"));
                event.toolTip.add(EnumChatFormatting.BLUE + "" + EnumChatFormatting.UNDERLINE + "Owner Health: " + event.itemStack.getTagCompound().getFloat("ownerHealth"));
                event.toolTip.add(EnumChatFormatting.BLUE + "" + EnumChatFormatting.UNDERLINE + "Owner Hunger: " + event.itemStack.getTagCompound().getInteger("ownerHunger"));
                event.toolTip.add("");
                event.toolTip.add("");
                if (!KeyHelper.isShiftKeyDown()) {
                    event.toolTip.add(EnumChatFormatting.BLUE + "" + EnumChatFormatting.BOLD + "" + EnumChatFormatting.ITALIC + "" + EnumChatFormatting.UNDERLINE + "RELEASE CTRL TO HIDE OWNER INFORMATION");
                }
            }

            if (KeyHelper.isCtrlKeyDown() && KeyHelper.isShiftKeyDown()) {
                event.toolTip.add("");
                event.toolTip.add(EnumChatFormatting.YELLOW + "" + EnumChatFormatting.BOLD + "" + EnumChatFormatting.ITALIC + "" + EnumChatFormatting.UNDERLINE + "RELEASE SHIFT TO HIDE INFORMATION");
                event.toolTip.add(EnumChatFormatting.BLUE + "" + EnumChatFormatting.BOLD + "" + EnumChatFormatting.ITALIC + "" + EnumChatFormatting.UNDERLINE + "RELEASE CTRL TO HIDE OWNER INFORMATION");
            }

            if (!KeyHelper.isShiftKeyDown() && !KeyHelper.isCtrlKeyDown()) {
                event.toolTip.add(EnumChatFormatting.GOLD + "~-~-~");
                event.toolTip.add(EnumChatFormatting.YELLOW + "" + EnumChatFormatting.BOLD + "" + EnumChatFormatting.ITALIC + "" + EnumChatFormatting.UNDERLINE + "HOLD DOWN SHIFT TO SHOW INFORMATION");
                event.toolTip.add(EnumChatFormatting.BLUE + "" + EnumChatFormatting.BOLD + "" + EnumChatFormatting.ITALIC + "" + EnumChatFormatting.UNDERLINE + "HOLD DOWN CTRL TO SHOW OWNER INFORMATION");
            }
        }
    }

    @SubscribeEvent
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
    }

}
