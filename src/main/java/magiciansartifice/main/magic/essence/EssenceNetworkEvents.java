package magiciansartifice.main.magic.essence;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import magiciansartifice.api.events.EssencePayEvent;
import magiciansartifice.main.blocks.BlockRegistry;
import magiciansartifice.main.core.network.PacketHandler;
import magiciansartifice.main.core.network.packet.EssencePacket;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.event.entity.living.LivingEvent;

import java.util.Random;

/**
 * Created by Mitchellbrine on 2014.
 */
public class EssenceNetworkEvents {

    @SubscribeEvent
    public void onJoinPacket(PlayerEvent.PlayerLoggedInEvent event) {
        if (!event.player.worldObj.isRemote) {
            if (event.player.getEntityData().hasKey("overworldEssence") && event.player.getEntityData().hasKey("netherEssence") && event.player.getEntityData().hasKey("enderEssence")) {
                if (event.player instanceof EntityPlayerMP) {
                    PacketHandler.INSTANCE.sendTo(new EssencePacket(event.player.getEntityData().getInteger("overworldEssence"), event.player.getEntityData().getInteger("netherEssence"), event.player.getEntityData().getInteger("enderEssence")), (EntityPlayerMP) event.player);
                }
            }
        }
    }

    @SubscribeEvent
    public void createNetwork(LivingEvent.LivingUpdateEvent event) {
        if (event.entityLiving instanceof EntityPlayer) {

            if (!((EntityPlayer) event.entityLiving).worldObj.isRemote) {
                if (!event.entityLiving.getEntityData().hasKey("overworldEssence") || !event.entityLiving.getEntityData().hasKey("netherEssence") || !event.entityLiving.getEntityData().hasKey("enderEssence")) {
                    if (!event.entityLiving.getEntityData().hasKey("maxOverworld")) {
                        event.entityLiving.getEntityData().setInteger("maxOverworld", 50);
                        event.entityLiving.getEntityData().setInteger("overworldEssence", 50);
                    }
                    if (!event.entityLiving.getEntityData().hasKey("maxNether")) {
                        event.entityLiving.getEntityData().setInteger("maxNether", 50);
                        event.entityLiving.getEntityData().setInteger("netherEssence", 50);
                    }
                    if (!event.entityLiving.getEntityData().hasKey("maxEnder")) {
                        event.entityLiving.getEntityData().setInteger("maxEnder", 50);
                        event.entityLiving.getEntityData().setInteger("enderEssence", 50);
                    }
                    if (event.entityLiving instanceof EntityPlayerMP) {
                        PacketHandler.INSTANCE.sendTo(new EssencePacket(event.entityLiving.getEntityData().getInteger("overworldEssence"), event.entityLiving.getEntityData().getInteger("netherEssence"), event.entityLiving.getEntityData().getInteger("enderEssence")), (EntityPlayerMP) event.entityLiving);
                    }
                }

                Random random = new Random(((EntityPlayer) event.entityLiving).worldObj.getWorldTime());

                if (random.nextInt(100) == 0) {
                    if (event.entityLiving.getEntityData().hasKey("overworldEssence") && event.entityLiving.getEntityData().hasKey("netherEssence") && event.entityLiving.getEntityData().hasKey("enderEssence")) {

                        int newOverworld = event.entityLiving.getEntityData().getInteger("overworldEssence") + 1;
                        if (!(newOverworld > event.entityLiving.getEntityData().getInteger("maxOverworld"))) {
                            event.entityLiving.getEntityData().setInteger("overworldEssence", newOverworld);
                        }
                        int newNether = event.entityLiving.getEntityData().getInteger("netherEssence") + 1;
                        if (!(newNether > event.entityLiving.getEntityData().getInteger("maxNether"))) {
                            event.entityLiving.getEntityData().setInteger("netherEssence", newNether);
                        }
                        int newEnder = event.entityLiving.getEntityData().getInteger("enderEssence") + 1;
                        if (!(newEnder > event.entityLiving.getEntityData().getInteger("maxEnder"))) {
                            event.entityLiving.getEntityData().setInteger("enderEssence", newEnder);
                        }
                        if (event.entityLiving instanceof EntityPlayerMP) {
                            PacketHandler.INSTANCE.sendTo(new EssencePacket(event.entityLiving.getEntityData().getInteger("overworldEssence"), event.entityLiving.getEntityData().getInteger("netherEssence"), event.entityLiving.getEntityData().getInteger("enderEssence")), (EntityPlayerMP) event.entityLiving);
                        }
                    }
                }

                EntityPlayer player = (EntityPlayer) event.entityLiving;

                int x = (int) Math.floor(player.posX);
                int y = (int) Math.floor(player.posY);
                int z = (int) Math.floor(player.posZ);

                if (!player.worldObj.isRemote) {
                    for (int xx = x - 3; xx < x + 3; xx++) {
                        for (int yy = y - 3; yy < y + 3; yy++) {
                            for (int zz = z - 3; zz < z + 3; zz++) {
                                if (player.worldObj.getBlock(xx, yy, zz) == BlockRegistry.essenceHole) {
                                    if (player.worldObj.getWorldTime() % 20 == 0) {
                                        int newOverworld = event.entityLiving.getEntityData().getInteger("overworldEssence") + random.nextInt(3);
                                        if (!(newOverworld > event.entityLiving.getEntityData().getInteger("maxOverworld"))) {
                                            event.entityLiving.getEntityData().setInteger("overworldEssence", newOverworld);
                                        } else {
                                            event.entityLiving.getEntityData().setInteger("overworldEssence", event.entityLiving.getEntityData().getInteger("maxOverworld"));
                                        }
                                        int newNether = event.entityLiving.getEntityData().getInteger("netherEssence") + random.nextInt(3);
                                        if (!(newNether > event.entityLiving.getEntityData().getInteger("maxNether"))) {
                                            event.entityLiving.getEntityData().setInteger("netherEssence", newNether);
                                        } else {
                                            event.entityLiving.getEntityData().setInteger("netherEssence", event.entityLiving.getEntityData().getInteger("maxNether"));
                                        }
                                        int newEnder = event.entityLiving.getEntityData().getInteger("enderEssence") + random.nextInt(3);
                                        if (!(newEnder > event.entityLiving.getEntityData().getInteger("maxEnder"))) {
                                            event.entityLiving.getEntityData().setInteger("enderEssence", newEnder);
                                        } else {
                                            event.entityLiving.getEntityData().setInteger("enderEssence", event.entityLiving.getEntityData().getInteger("maxEnder"));
                                        }

                                        if (event.entityLiving instanceof EntityPlayerMP) {
                                            PacketHandler.INSTANCE.sendTo(new EssencePacket(event.entityLiving.getEntityData().getInteger("overworldEssence"), event.entityLiving.getEntityData().getInteger("netherEssence"), event.entityLiving.getEntityData().getInteger("enderEssence")), (EntityPlayerMP) event.entityLiving);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

            }
        }
    }

}
