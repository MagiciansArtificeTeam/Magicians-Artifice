package magiciansartifice.main.entities;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import magiciansartifice.api.INotKillCurseable;
import magiciansartifice.main.items.ItemRegistry;
import magiciansartifice.main.items.magicalitems.ItemHorcrux;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIMoveTowardsTarget;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.*;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import java.util.List;

/**
 * Created by Mitchellbrine on 2014.
 */
public class EntitySoulFragment extends EntityMob implements INotKillCurseable {

    public String playerName;

    public EntitySoulFragment(World p_i1738_1_) {
        super(p_i1738_1_);
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 10.0F));
        this.tasks.addTask(1, new EntityAIMoveTowardsTarget(this, 0.3D, 10.0F));
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public boolean doesEntityNotTriggerPressurePlate() {
        return true;
    }

    @Override
    protected void entityInit() {
        super.entityInit();
    }

    @Override
    public void onEntityUpdate() {
        super.onEntityUpdate();
        this.setCurrentItemOrArmor(0,new ItemStack(ItemRegistry.starSteelSword));
        if (this.getPlayerName() != null && !this.getPlayerName().equals("")) {
            this.setCustomNameTag(this.getPlayerName());
        }
    }

    public String getPlayerName() {
        return this.playerName;
    }

    public String setPlayerName(String name) {
        this.playerName = name;
        return this.playerName;
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound var1) {
        super.readEntityFromNBT(var1);
        if (var1.hasKey("player")) {
            playerName = var1.getString("player");
        }
        else {
            playerName = "";
        }
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound var1) {
        super.writeEntityToNBT(var1);
        if (playerName != null) {
            var1.setString("player", playerName);
        }
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
        if (this.isSprinting()) {
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.75D);
        }
        else {
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.5D);
        }
    }

    @SuppressWarnings("unchecked")
    public boolean doesHaveHorcrux(World world, String owner) {
        List<TileEntity> tileEntities = world.loadedTileEntityList;
        List<EntityPlayerMP> players = world.playerEntities;

        Vec3 entityVec = Vec3.createVectorHelper(posX,posY,posZ);

        for (EntityPlayerMP player : players) {
            Vec3 playerVec = Vec3.createVectorHelper(player.posX,player.posY,player.posZ);
            for (int i = 0; i < player.inventory.getSizeInventory(); i++) {
                if (player.inventory.getStackInSlot(i) != null) {
                    if (player.inventory.getStackInSlot(i).getItem() instanceof ItemHorcrux) {
                        ItemStack stack = player.inventory.getStackInSlot(i);
                        if (stack.hasTagCompound()) {
                            if (stack.stackTagCompound.hasKey("ownerName")) {
                                if (stack.stackTagCompound.getString("ownerName").equalsIgnoreCase(owner)) {
                                    if (entityVec.distanceTo(playerVec) <= 50) {
                                        return true;
                                    }
                                }
                            }
                        }

                    }
                }
            }
        }
        for (TileEntity tileEntity : tileEntities) {
            Vec3 teVec = Vec3.createVectorHelper(tileEntity.xCoord,tileEntity.yCoord,tileEntity.zCoord);
            if (tileEntity instanceof TileEntityChest) {
                TileEntityChest chest = (TileEntityChest) tileEntity;
                for (int i = 0; i < chest.getSizeInventory(); i++) {
                    if (chest.getStackInSlot(i) != null) {
                        if (chest.getStackInSlot(i).getItem() instanceof ItemHorcrux) {
                            ItemStack stack = chest.getStackInSlot(i);
                            if (stack.hasTagCompound()) {
                                if (stack.stackTagCompound.hasKey("ownerName")) {
                                    if (stack.stackTagCompound.getString("ownerName").equalsIgnoreCase(owner)) {
                                        return true;
                                    }
                                }
                            }

                        }
                    }
                }
            } else if (tileEntity instanceof TileEntityDispenser) {
                TileEntityDispenser chest = (TileEntityDispenser) tileEntity;
                for (int i = 0; i < chest.getSizeInventory(); i++) {
                    if (chest.getStackInSlot(i) != null) {
                        if (chest.getStackInSlot(i).getItem() instanceof ItemHorcrux) {
                            ItemStack stack = chest.getStackInSlot(i);
                            if (stack.hasTagCompound()) {
                                if (stack.stackTagCompound.hasKey("ownerName")) {
                                    if (stack.stackTagCompound.getString("ownerName").equalsIgnoreCase(owner)) {
                                        if (entityVec.distanceTo(teVec) <= 50) {
                                            return true;
                                        }
                                    }
                                }
                            }

                        }
                    }
                }
            } else if (tileEntity instanceof TileEntityHopper) {
                TileEntityHopper chest = (TileEntityHopper) tileEntity;
                for (int i = 0; i < chest.getSizeInventory(); i++) {
                    if (chest.getStackInSlot(i) != null) {
                        if (chest.getStackInSlot(i).getItem() instanceof ItemHorcrux) {
                            ItemStack stack = chest.getStackInSlot(i);
                            if (stack.hasTagCompound()) {
                                if (stack.stackTagCompound.hasKey("ownerName")) {
                                    if (stack.stackTagCompound.getString("ownerName").equalsIgnoreCase(owner)) {
                                        if (entityVec.distanceTo(teVec) <= 50) {
                                            return true;
                                        }
                                    }
                                }
                            }

                        }
                    }
                }
            } else if (tileEntity instanceof TileEntityFurnace) {
                TileEntityFurnace chest = (TileEntityFurnace) tileEntity;
                for (int i = 0; i < chest.getSizeInventory(); i++) {
                    if (chest.getStackInSlot(i) != null) {
                        if (chest.getStackInSlot(i).getItem() instanceof ItemHorcrux) {
                            ItemStack stack = chest.getStackInSlot(i);
                            if (stack.hasTagCompound()) {
                                if (stack.stackTagCompound.hasKey("ownerName")) {
                                    if (stack.stackTagCompound.getString("ownerName").equalsIgnoreCase(owner)) {
                                        if (entityVec.distanceTo(teVec) <= 50) {
                                            return true;
                                        }
                                    }
                                }
                            }

                        }
                    }
                }
            }
        }
        return false;
    }

    @SubscribeEvent
    public void onHurt(LivingHurtEvent event) {
        if (event.entityLiving instanceof EntitySoulFragment) {
            EntitySoulFragment player = (EntitySoulFragment) event.entityLiving;
            if ((player.getHealth() - event.ammount) <= 0) {
                if (player.getPlayerName() != null && !player.getPlayerName().equals("")) {
                    if (doesHaveHorcrux(player.worldObj, player.getPlayerName())) {
                        event.setCanceled(true);
                    }
                }
            }
        }
    }
}
