package mysticartifice.guis;

import cpw.mods.fml.common.network.IGuiHandler;

import mysticartifice.containers.*;
import mysticartifice.guis.machines.*;
import mysticartifice.tileentities.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by Millsy on 18/07/14.
 */
public class GuiHandler implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity entity = world.getTileEntity(x, y, z);
        if (entity != null) {
            switch (ID) {
                case 0:
                    return new ContainerMysticAnvil(player, (TileEntityMysticAnvil) entity);
            }
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity entity = world.getTileEntity(x, y, z);
        if (entity != null) {
            switch (ID) {
                case 0:
                    return new GuiMysticAnvil(player, (TileEntityMysticAnvil) entity);
            }
        }
        return null;
    }
}
