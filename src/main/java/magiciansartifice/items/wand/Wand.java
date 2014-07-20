package magiciansartifice.items.wand;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import magiciansartifice.MagiciansArtifice;
import magiciansartifice.ModInfo;
import magiciansartifice.items.ItemRegistry;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ServerChatEvent;

import java.util.Random;

public class Wand extends Item {

    public Wand() {
        this.setMaxStackSize(1);
        this.setCreativeTab(MagiciansArtifice.tab);
        this.setUnlocalizedName("magiciansWand");
        this.setTextureName(ModInfo.MODID + ":wands/magicianWand");
        this.setFull3D();
        GameRegistry.registerItem(this,this.getUnlocalizedName().substring(5));
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void magicWords(ServerChatEvent event) {
        if (event.player.getCurrentEquippedItem() != null && event.player.getCurrentEquippedItem().getItem() == ItemRegistry.wand) {
            if (event.message.contains("Abra-cadabra")) {
                if (event.message.contains("sheep-cadabra")) {
                    event.component = new ChatComponentTranslation("");
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
