package magiciansartifice.main.items.magicalitems;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.core.libs.ModInfo;
import magiciansartifice.main.items.ItemRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.item.ItemExpireEvent;
import net.minecraftforge.event.entity.item.ItemTossEvent;
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
                        if (!player.getEntityData().hasKey("madeAHorcrux") || !player.getEntityData().getBoolean("madeAHorcrux")) {
                                stack.stackTagCompound.setString("owner", player.getGameProfile().getId().toString());
                                stack.stackTagCompound.setString("ownerName", player.getDisplayName());
                                player.getEntityData().setBoolean("madeAHorcrux",true);
                                break;
                            } else {
                            if (random.nextInt(100) >= 95) {
                                searchAndDestroyHorcrux(player.worldObj, player);
                                player.setHealth(0.0F);
                            } else {
                                stack.stackTagCompound.setString("owner", player.getGameProfile().getId().toString());
                                stack.stackTagCompound.setString("ownerName", player.getDisplayName());
                            }
                            break;
                        }
                        }
                    }
                }
            }

    }

    @SuppressWarnings("unchecked")
    public void searchAndDestroyHorcrux(World world, EntityPlayer owner) {
        List<EntityPlayerMP> players = world.playerEntities;
        List<TileEntity> tileEntities = world.loadedTileEntityList;

        for (EntityPlayerMP player : players) {
            for (int i = 0; i < player.inventory.getSizeInventory(); i++) {
                if (player.inventory.getStackInSlot(i) != null) {
                    if (player.inventory.getStackInSlot(i).getItem() instanceof ItemHorcrux) {
                        ItemStack stack = player.inventory.getStackInSlot(i);
                        if (stack.hasTagCompound()) {
                            if (stack.stackTagCompound.hasKey("owner") && stack.stackTagCompound.getString("owner").equalsIgnoreCase(owner.getGameProfile().getId().toString())) {
                                EntityItem item = new EntityItem(player.worldObj, player.posX, player.posY, player.posZ, stack);
                                item.setEntityItemStack(stack);
                                item.setLocationAndAngles(player.posX, player.posY + 1, player.posZ, 0.0F, 0.0F);
                                item.delayBeforeCanPickup = 100;
                                world.spawnEntityInWorld(item);
                                player.inventory.setInventorySlotContents(i, null);
                                break;
                            }
                        }
                    }
                }
            }
        }

        for (TileEntity tileEntity : tileEntities) {
            if (tileEntity instanceof TileEntityChest) {
                TileEntityChest chest = (TileEntityChest) tileEntity;
                for (int i = 0; i < chest.getSizeInventory(); i++) {
                    if (chest.getStackInSlot(i) != null) {
                        if (chest.getStackInSlot(i).getItem() instanceof ItemHorcrux) {
                            ItemStack stack = chest.getStackInSlot(i);
                            if (stack.hasTagCompound()) {
                                if (stack.stackTagCompound.hasKey("owner") && stack.stackTagCompound.getString("owner").equalsIgnoreCase(owner.getGameProfile().getId().toString())) {
                                    EntityItem item = new EntityItem(chest.getWorldObj(), chest.xCoord, chest.yCoord, chest.zCoord, stack);
                                    item.setEntityItemStack(stack);
                                    item.setLocationAndAngles(chest.xCoord, chest.yCoord + 1, chest.zCoord, 0.0F, 0.0F);
                                    item.delayBeforeCanPickup = 100;
                                    world.spawnEntityInWorld(item);
                                    chest.setInventorySlotContents(i, null);
                                    break;
                                }
                            }
                        }
                    }
                }

            }
        }

    }

    @SuppressWarnings("unchecked")
    public boolean doesHaveHorcrux(World world, EntityPlayer owner) {
        List<EntityPlayerMP> players = world.playerEntities;
        List<TileEntity> tileEntities = world.loadedTileEntityList;
        List<Entity> entities = world.loadedEntityList;

        for (EntityPlayerMP player : players) {
            for (int i = 0; i < player.inventory.getSizeInventory(); i++) {
                if (player.inventory.getStackInSlot(i) != null) {
                    if (player.inventory.getStackInSlot(i).getItem() instanceof ItemHorcrux) {
                        ItemStack stack = player.inventory.getStackInSlot(i);
                        if (stack.hasTagCompound()) {
                            if (stack.stackTagCompound.hasKey("owner")) {
                                if (stack.stackTagCompound.getString("owner").equalsIgnoreCase(owner.getGameProfile().getId().toString())) {
                                    return true;
                                }
                            }
                        }

                    }
                }
            }
        }
        for (TileEntity tileEntity : tileEntities) {
            if (tileEntity instanceof TileEntityChest) {
                TileEntityChest chest = (TileEntityChest) tileEntity;
                for (int i = 0; i < chest.getSizeInventory(); i++) {
                    if (chest.getStackInSlot(i) != null) {
                        if (chest.getStackInSlot(i).getItem() instanceof ItemHorcrux) {
                            ItemStack stack = chest.getStackInSlot(i);
                            if (stack.hasTagCompound()) {
                                if (stack.stackTagCompound.hasKey("owner")) {
                                    if (stack.stackTagCompound.getString("owner").equalsIgnoreCase(owner.getGameProfile().getId().toString())) {
                                        return true;
                                    }
                                }
                            }

                        }
                    }
                }
            }
        }

        for (Entity entity : entities) {
            if (entity instanceof EntityItem) {
                EntityItem item = (EntityItem) entity;
                if (item.getEntityItem() != null && item.getEntityItem().getItem() instanceof ItemHorcrux) {
                    ItemStack stack = item.getEntityItem();
                    if (stack.hasTagCompound()) {
                        if (stack.stackTagCompound.hasKey("owner")) {
                            if (stack.stackTagCompound.getString("owner").equalsIgnoreCase(owner.getGameProfile().getId().toString())) {
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
            if (MinecraftServer.getServer().isDedicatedServer()) {
                if (event.entityLiving instanceof EntityPlayer) {
                    searchAndDestroy(player);
                }
            }  else {
                if (event.entityLiving instanceof EntityWither) {
                    searchAndDestroy(player);
                }
            }
        }
    }

    @SubscribeEvent
    public void onHurt(LivingHurtEvent event) {
        if (event.entityLiving instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.entityLiving;
            if ((player.getHealth() - event.ammount) <= 0) {
                if (doesHaveHorcrux(player.worldObj,player)) {
                    if (random.nextInt(100) <= 50) {
                        searchAndDestroyHorcrux(player.worldObj,player);
                    }
                        event.setCanceled(true);
                }
            }
        }
    }

    @SubscribeEvent
    public void despawn(ItemExpireEvent event) {
        if (event.entityItem.getEntityItem() != null) {
            if (event.entityItem.getEntityItem().getItem() instanceof ItemHorcrux) {
                if (event.entityItem.getEntityItem().hasTagCompound()) {
                    if (event.entityItem.getEntityItem().stackTagCompound.hasKey("owner")) {
                        event.setCanceled(true);
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public void onDrop(ItemTossEvent e) {
        if(e.entity.worldObj.isRemote) return;
        if(e.entityItem.getEntityItem() != null && e.entityItem.getEntityItem().getItem() instanceof ItemHorcrux) {
            e.setCanceled(true);
            e.player.inventory.addItemStackToInventory(e.entityItem.getEntityItem());
        }
    }

}
