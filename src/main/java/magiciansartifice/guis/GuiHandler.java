package magiciansartifice.guis;

import cpw.mods.fml.common.network.IGuiHandler;

import magiciansartifice.containers.*;
import magiciansartifice.guis.machines.*;
import magiciansartifice.tileentities.machines.TileEntityMysticAnvil;
import magiciansartifice.tileentities.machines.TileEntityWandCarver;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity entity = world.getTileEntity(x, y, z);
        if (entity != null) {
            switch (ID) {
                case 0:
                    return new ContainerMysticAnvil(player, (TileEntityMysticAnvil) entity);
                case 1:
                    return new ContainerWandCarver(player, (TileEntityWandCarver) entity);
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
                case 1:
                    return new GuiWandCarver(player, (TileEntityWandCarver) entity);
            }
        }
        return null;
    }
}
