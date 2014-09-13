package magiciansartifice.main.items.magicalitems;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.core.libs.ModInfo;
import magiciansartifice.main.items.ItemRegistry;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import java.util.List;
import java.util.Random;

public class ItemHorcrux extends Item{

    Random random = new Random();

    public ItemHorcrux() {
        this.setMaxStackSize(1);
        this.setCreativeTab(MagiciansArtifice.tab);
        this.setUnlocalizedName("horcrux");
        this.setTextureName(ModInfo.MODID + ":magical/horcrux");
        MinecraftForge.EVENT_BUS.register(this);
        ItemRegistry.items.add(this);
    }

    @SuppressWarnings("unchecked")
    public void addInformation(ItemStack stack, EntityPlayer player, List lore, boolean par4) {
        if (stack.hasTagCompound()) {
            if (stack.stackTagCompound.hasKey("ownerName")) {
                lore.add("Owner: " + stack.stackTagCompound.getString("ownerName"));
            } else if (stack.stackTagCompound.hasKey("owner")) {
                lore.add("Owner: " + stack.stackTagCompound.getString("owner"));
            } else {
                lore.add("Not bound to any owner");
            }
        } else {
            lore.add("Not bound to any owner");
        }
    }

    public void searchAndDestroy(EntityPlayer player) {
        for (int i = 0; i < player.inventory.getSizeInventory();i++) {
            if (player.inventory.getStackInSlot(i) != null) {
                if (player.inventory.getStackInSlot(i).getItem() instanceof ItemHorcrux) {
                    ItemStack stack = player.inventory.getStackInSlot(i);
                    if (!stack.hasTagCompound()) {
                        stack.stackTagCompound = new NBTTagCompound();
                    }
                    if (!stack.stackTagCompound.hasKey("owner")) {
                        stack.stackTagCompound.setString("owner",player.getGameProfile().getId().toString());
                        stack.stackTagCompound.setString("ownerName",player.getDisplayName());
                        break;
                    }
                }
            }
        }

    }

    public void searchAndDestroyHorcrux(EntityPlayer player) {
        for (int i = 0; i < player.inventory.getSizeInventory();i++) {
            if (player.inventory.getStackInSlot(i) != null) {
                if (player.inventory.getStackInSlot(i).getItem() instanceof ItemHorcrux) {
                    ItemStack stack = player.inventory.getStackInSlot(i);
                    EntityItem item = new EntityItem(player.worldObj,player.posX,player.posY,player.posZ,stack);
                    item.setEntityItemStack(stack);
                    item.setLocationAndAngles(player.posX, player.posY + 20, player.posZ, 0.0F, 0.0F);
                    item.delayBeforeCanPickup = 100;
                    player.worldObj.spawnEntityInWorld(item);
                    player.inventory.setInventorySlotContents(i, null);
                    break;
                }
            }
        }

    }

    public boolean doesHaveHorcrux(EntityPlayer player) {
        for (int i = 0; i < player.inventory.getSizeInventory();i++) {
            if (player.inventory.getStackInSlot(i) != null) {
                if (player.inventory.getStackInSlot(i).getItem() instanceof ItemHorcrux) {
                    ItemStack stack = player.inventory.getStackInSlot(i);
                    if (stack.hasTagCompound()) {
                        if (stack.stackTagCompound.hasKey("owner")) {
                            if (stack.stackTagCompound.getString("owner").equalsIgnoreCase(player.getGameProfile().getId().toString())) {
                                return true;
                            }
                        }
                    }

                }
            }
        }
        return false;
    }

    @SubscribeEvent
    public void onDeath(LivingDeathEvent event) {
        if (event.source.getEntity() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer)event.source.getEntity();
            if (event.entityLiving instanceof EntityPlayer) {
                searchAndDestroy(player);
            }
        }
    }

    @SubscribeEvent
    public void onHurt(LivingHurtEvent event) {
        if (event.entityLiving instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.entityLiving;
            if ((player.getHealth() - event.ammount) <= 0) {
                if (doesHaveHorcrux(player)) {
                    if (random.nextInt(100) <= 50) {
                        searchAndDestroyHorcrux(player);
                    }
                        event.setCanceled(true);
                }
            }
        }
    }

}
