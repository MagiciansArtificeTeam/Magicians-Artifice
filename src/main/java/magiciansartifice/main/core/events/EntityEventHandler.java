package magiciansartifice.main.core.events;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import magiciansartifice.main.blocks.magicblocks.BlockEssenceHole;
import magiciansartifice.main.items.ItemRegistry;
import magiciansartifice.main.magic.rituals.RitualFlight;
import magiciansartifice.main.core.utils.PlayerHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingEvent;

public class EntityEventHandler {

    public static final String MAGICIANSARTIFICE_PERSIST_TAG = "MagiciansArtifice";
    public static final String GIVEN_GUIDE_TAG = "givenGuide";

    @SubscribeEvent()
    public void onEntityJoinWorld(EntityJoinWorldEvent event) {
        final Entity entity = event.entity;
        if (!event.world.isRemote && entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer)entity;
            NBTTagCompound persistTag = PlayerHelper.getModPlayerPersistTag(player, "MagiciansArtifice");

            boolean shouldGiveManual = ItemRegistry.merlinLetter != null && !persistTag.getBoolean(GIVEN_GUIDE_TAG);
            if (shouldGiveManual) {
                ItemStack manual = new ItemStack(ItemRegistry.merlinLetter);
                if (!player.inventory.addItemStackToInventory(manual)) {
                    dropItemStackInWorld(player.worldObj, player.posX, player.posY, player.posZ, manual);
                }
                persistTag.setBoolean(GIVEN_GUIDE_TAG, true);
            }

            RitualFlight.enableFlight((int)Math.floor(player.posX),(int)Math.floor(player.posY),(int)Math.floor(player.posZ),player.worldObj,player,false);

        }
    }

    public static EntityItem dropItemStackInWorld(World worldObj, double x, double y, double z, ItemStack stack) {
        float f = 0.7F;
        float d0 = worldObj.rand.nextFloat() * f + (1.0F - f) * 0.5F;
        float d1 = worldObj.rand.nextFloat() * f + (1.0F - f) * 0.5F;
        float d2 = worldObj.rand.nextFloat() * f + (1.0F - f) * 0.5F;
        EntityItem entityitem = new EntityItem(worldObj, x + d0, y + d1, z + d2, stack);
        entityitem.delayBeforeCanPickup = 1;
        if (stack.hasTagCompound()) {
            entityitem.getEntityItem().setTagCompound((NBTTagCompound)stack.getTagCompound().copy());
        }
        worldObj.spawnEntityInWorld(entityitem);
        return entityitem;
    }

    public void livingUpdate(LivingEvent.LivingUpdateEvent event) {

        if (event.entityLiving instanceof EntityPlayer) {

            EntityPlayer player = (EntityPlayer) event.entityLiving;

            RitualFlight.enableFlight((int)Math.floor(player.posX),(int)Math.floor(player.posY),(int)Math.floor(player.posZ),player.worldObj,player,false);

            int x = (int) Math.floor(player.posX);
            int y = (int) Math.floor(player.posY);
            int z = (int) Math.floor(player.posZ);

            for (int i = x - 5; i < x + 5;i++) {
                for (int ii = y - 5; ii < y + 5;ii++) {
                    for (int zz = z - 5; zz < z + 5;zz++) {
                        if (player.worldObj.getBlock(i,ii,zz) instanceof BlockEssenceHole) {
                            System.err.println("Coords: " + i + " " + ii + " " + zz);
                        }
                    }
                }
            }

        }

    }

}
