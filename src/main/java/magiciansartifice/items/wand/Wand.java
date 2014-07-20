package magiciansartifice.items.wand;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import magiciansartifice.MagiciansArtifice;
import magiciansartifice.ModInfo;
import magiciansartifice.items.ItemRegistry;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ServerChatEvent;

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
            if (event.message.contains("Abra-cadabra") || event.message.contains("Sheep-cadabra")) {
                EntitySheep sheep = new EntitySheep(event.player.worldObj);
                sheep.setLocationAndAngles(event.player.posX,event.player.posY + 1,event.player.posZ,event.player.cameraYaw,event.player.cameraPitch);
                event.player.worldObj.spawnEntityInWorld(sheep);
            }
        }
    }
}
