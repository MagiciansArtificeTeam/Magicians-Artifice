package magiciansartifice.spells.rituals;

import magiciansartifice.api.BasicRitual;
import magiciansartifice.blocks.BlockRegistry;
import magiciansartifice.blocks.magicblocks.BlockTeleportReciever;
import magiciansartifice.libs.ConfigHandler;
import magiciansartifice.tileentities.magic.TileEntityTeleportReciever;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

/**
 * Created by poppypoppop on 8/08/2014.
 */
public class RitualTeleport extends BasicRitual {
    public void startRitual(int x, int y, int z, World world, EntityPlayer player) { super.startRitual(x, y, z, world, player);
    System.err.println("Started ritual");
    }

    public boolean areAllBlocksCorrect(int x, int y, int z, World world, EntityPlayer player) {
        System.err.println("Starting check!");
        int x1 = x;
        int y1 = y;
        int z1 = z;
        z -= 2;

        for (int i = 0; i < 5; i++) {
            if (world.getBlock(x - 2, y, z + i) == BlockRegistry.storage) {
                if (!(world.getBlockMetadata(x - 2, y, z + i) == 0)) {
                    return false;
                }
            }
        }

        for (int i = 0; i < 5; i++) {
            if (world.getBlock(x - 2, y, z + i) == BlockRegistry.storage) {
                if (!(world.getBlockMetadata(x + 2, y, z + i) == 0)) {
                    return false;
                }
            }
        }
        z += 0;
        x -= 2;
        for (int i = 0; i < 5; i++) {
            if (world.getBlock(x + i, y, z) == BlockRegistry.storage) {
                if (!(world.getBlockMetadata(x + i, y, z) == 0)) {
                    return false;
                }
            }
        }

        for (int i = 0; i < 5; i++) {
            if (world.getBlock(x + i, y, z + 4) == BlockRegistry.storage) {
                if (!(world.getBlockMetadata(x + i, y, z) == 0)) {
                    return false;
                }
            }
        }

        x += 1;
        for (int i = 0; i < 3; i++) {
            if (!(Item.getItemFromBlock(world.getBlock(x + i, y, z + 3)) == new ItemStack(Blocks.stonebrick, 1, 3).getItem())) {
                return false;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (!(Item.getItemFromBlock(world.getBlock(x + i, y, z + 3)) == new ItemStack(Blocks.stonebrick, 1, 3).getItem() && world.getBlock(x + i, y, z + 2) != BlockRegistry.ritualCornerStone)) {
                return false;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (!(Item.getItemFromBlock(world.getBlock(x + i, y, z + 3)) == new ItemStack(Blocks.stonebrick, 1, 3).getItem())) {
                return false;
            }
        }
        System.err.println("Everything is awesome!");
        return true;
    }

    public void initEffect(int x, int y, int z, World world, EntityPlayer player) {

        System.err.println("Starting effect!");

        if (ConfigHandler.receiverDistance > 3) {
            for (int x1 = x - ConfigHandler.receiverDistance; x1 < x + (ConfigHandler.receiverDistance + 1); x1++) {
                for (int z1 = z - ConfigHandler.receiverDistance; z1 < z + (ConfigHandler.receiverDistance + 1); z1++) {
                    if (world.getBlock(x1, y, z1) != null && world.getBlock(x1, y, z1) instanceof BlockTeleportReciever) {
                        TileEntityTeleportReciever te = (TileEntityTeleportReciever) world.getTileEntity(x1, y, z1);
                        if (te != null) {
                            player.setLocationAndAngles((double) te.getX(), (double) te.getY() + 1, (double) te.getZ(), player.cameraPitch, player.cameraYaw);
                            System.err.println("Finished effect!");
                            return;
                        }
                    }
                }
            }
        } else {
            player.addChatComponentMessage(new ChatComponentTranslation("ritual.teleport.disabled").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.DARK_RED)));
        }

        if (player.getPlayerCoordinates().posX == x && player.getPlayerCoordinates().posY == y && player.getPlayerCoordinates().posZ == z) {
            player.addChatComponentMessage(new ChatComponentTranslation("ritual.teleport.failure"));
        } else {
            player.addChatComponentMessage(new ChatComponentTranslation("ritual.teleport.success"));
        }

    }
}
