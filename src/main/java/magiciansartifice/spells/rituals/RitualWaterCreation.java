package magiciansartifice.spells.rituals;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import magiciansartifice.blocks.BlockRegistry;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

/**
 * Created by poppypoppop on 30/07/2014.
 */
public class RitualWaterCreation {
    @SubscribeEvent
    public static void waterCreation(PlayerInteractEvent event) {
        int x = event.x;
        int y = event.y;
        int z = event.z;
        World world = event.world;

        z -= 2;
        for (int i = 0; i < 5; i++) {
            if (world.getBlock(x - 2, y, z + i) == BlockRegistry.storage) {
                if (!(world.getBlockMetadata(x - 2, y, z + i) == 0)) {
                    System.out.println("1");
                    return;
                }
            }
        }

        for (int i = 0; i < 5; i++) {
            if (world.getBlock(x - 2, y, z + i) == BlockRegistry.storage) {
                if (!(world.getBlockMetadata(x + 2, y, z + i) == 0)) {
                    System.out.println("2");
                    return;
                }
            }
        }

        x -= 2;
        for (int i = 0; i < 5; i++) {
            if (world.getBlock(x + i, y, z) == BlockRegistry.storage) {
                if (!(world.getBlockMetadata(x + 2, y, z + i) == 0)) {
                    System.out.println("3");
                    return;
                }
            }
        }

        for (int i = 0; i < 5; i++) {
            if (world.getBlock(x + i, y, z + 4) == BlockRegistry.storage) {
                if (!(world.getBlockMetadata(x + 2, y, z + i) == 0)) {
                    System.out.println("4");
                    return;
                }
            }
        }

        System.out.println("it formed");
    }
}
