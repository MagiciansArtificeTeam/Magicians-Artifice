package magiciansartifice.main.magic.spells;

import magiciansartifice.api.BasicSpell;
import magiciansartifice.main.core.utils.TextHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.*;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class SummoningSpell extends BasicSpell{

    /*
                for (EntityItem e : list) {
                if (e.age >= 8) {
                    double x = player.posX - e.posX;
                    double y = player.posY - e.posY;
                    double z = player.posZ - e.posZ;

                    double length = Math.sqrt(x * x + y * y + z * z) * 2.0D;

                    x = x / length + player.motionX / 2.0D;
                    y = y / length + player.motionY / 2.0D;
                    z = z / length + player.motionZ / 2.0D;

                    e.motionX = x;
                    e.motionY = y;
                    e.motionZ = z;
                    e.isAirBorne = true;
                    if (e.isCollidedHorizontally) {
                        e.motionY += 1.0D;
                    }
                }
            }
     */

    @Override
    public void beginSpell(World world, int x, int y, int z, EntityPlayer player, String spell) {
        super.beginSpell(world, x, y, z, player, spell);
    }

    @Override
    public void performEffect(World world, int x, int y, int z, EntityPlayer player, String spell) {
            String itemName = (String)Item.itemRegistry.getKeys().iterator().next();
            Item item = (Item)Item.itemRegistry.getObject(itemName);
            String localized = TextHelper.localize(item.getUnlocalizedName());
            if (localized.equalsIgnoreCase(spell)) {
                System.err.println(localized);
                searchAndRemove(world,item);
                bringTheItems(world,player,item);
                super.performEffect(world, x, y, z, player, spell);
            }
    }

    @SuppressWarnings("unchecked")
    private void searchAndRemove(World world, Item item) {
        System.err.println(item);
        List<TileEntity> tileEntities = world.loadedTileEntityList;
        for (TileEntity tileEntity : tileEntities) {
            if (tileEntity instanceof TileEntityChest) {
                TileEntityChest chest = (TileEntityChest) tileEntity;
                for (int i = 0; i < chest.getSizeInventory(); i++) {
                    if (chest.getStackInSlot(i) != null) {
                        if (chest.getStackInSlot(i).getItem() == item) {
                            ItemStack stack = chest.getStackInSlot(i);
                                    EntityItem itemEntity = new EntityItem(chest.getWorldObj(), chest.xCoord, chest.yCoord, chest.zCoord, stack);
                                    itemEntity.setEntityItemStack(stack);
                                    itemEntity.setLocationAndAngles(chest.xCoord, chest.yCoord + 1, chest.zCoord, 0.0F, 0.0F);
                                    itemEntity.delayBeforeCanPickup = 100;
                                    world.spawnEntityInWorld(itemEntity);
                                    chest.setInventorySlotContents(i, null);
                        }
                    }
                }

            } else if (tileEntity instanceof TileEntityFurnace) {
                TileEntityFurnace chest = (TileEntityFurnace) tileEntity;
                for (int i = 0; i < chest.getSizeInventory(); i++) {
                    if (chest.getStackInSlot(i) != null) {
                        if (chest.getStackInSlot(i).getItem().equals(item)) {
                            ItemStack stack = chest.getStackInSlot(i);
                                    EntityItem itemEntity = new EntityItem(chest.getWorldObj(), chest.xCoord, chest.yCoord, chest.zCoord, stack);
                                    itemEntity.setEntityItemStack(stack);
                                    itemEntity.setLocationAndAngles(chest.xCoord, chest.yCoord + 1, chest.zCoord, 0.0F, 0.0F);
                                    itemEntity.delayBeforeCanPickup = 100;
                                    world.spawnEntityInWorld(itemEntity);
                                    chest.setInventorySlotContents(i, null);
                        }
                    }
                }
            } else if (tileEntity instanceof TileEntityDispenser) {
                TileEntityDispenser chest = (TileEntityDispenser) tileEntity;
                for (int i = 0; i < chest.getSizeInventory(); i++) {
                    if (chest.getStackInSlot(i) != null) {
                        if (chest.getStackInSlot(i).getItem().equals(item)) {
                            ItemStack stack = chest.getStackInSlot(i);
                            EntityItem itemEntity = new EntityItem(chest.getWorldObj(), chest.xCoord, chest.yCoord, chest.zCoord, stack);
                            itemEntity.setEntityItemStack(stack);
                            itemEntity.setLocationAndAngles(chest.xCoord, chest.yCoord + 1, chest.zCoord, 0.0F, 0.0F);
                            itemEntity.delayBeforeCanPickup = 100;
                            world.spawnEntityInWorld(itemEntity);
                            chest.setInventorySlotContents(i, null);
                        }
                    }
                }
            } else if (tileEntity instanceof TileEntityHopper) {
                TileEntityHopper chest = (TileEntityHopper) tileEntity;
                for (int i = 0; i < chest.getSizeInventory(); i++) {
                    if (chest.getStackInSlot(i) != null) {
                        if (chest.getStackInSlot(i).getItem().equals(item)) {
                            ItemStack stack = chest.getStackInSlot(i);
                            EntityItem itemEntity = new EntityItem(chest.getWorldObj(), chest.xCoord, chest.yCoord, chest.zCoord, stack);
                            itemEntity.setEntityItemStack(stack);
                            itemEntity.setLocationAndAngles(chest.xCoord, chest.yCoord + 1, chest.zCoord, 0.0F, 0.0F);
                            itemEntity.delayBeforeCanPickup = 100;
                            world.spawnEntityInWorld(itemEntity);
                            chest.setInventorySlotContents(i, null);
                        }
                    }
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    private void bringTheItems(World world, EntityPlayer player, Item item) {
        List<Entity> entities = world.loadedEntityList;
        List<EntityItem> list = new ArrayList<EntityItem>();
        for (Entity entity : entities) {
            if (entity instanceof EntityItem) {
                if (((EntityItem) entity).getEntityItem().getItem() == item) {
                    list.add((EntityItem)entity);
                }
            }
        }

        for (EntityItem e : list) {
            if (e.age >= 8) {
                double x = player.posX - e.posX;
                double y = player.posY - e.posY;
                double z = player.posZ - e.posZ;

                double length = Math.sqrt(x * x + y * y + z * z) * 2.0D;

                x = x / length + player.motionX / 2.0D;
                y = y / length + player.motionY / 2.0D;
                z = z / length + player.motionZ / 2.0D;

                e.motionX = x;
                e.motionY = y;
                e.motionZ = z;
                e.isAirBorne = true;
                if (e.isCollidedHorizontally) {
                    e.motionY += 1.0D;
                }
            }
        }

    }

}
