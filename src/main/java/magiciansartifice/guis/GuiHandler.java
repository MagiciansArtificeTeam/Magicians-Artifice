package magiciansartifice.guis;

import magiciansartifice.containers.ContainerMysticAnvil;
import magiciansartifice.containers.ContainerWandCarver;
import magiciansartifice.guis.machines.GuiMysticAnvil;
import magiciansartifice.guis.machines.GuiWandCarver;
import magiciansartifice.tileentities.machines.TileEntityMysticAnvil;
import magiciansartifice.tileentities.machines.TileEntityWandCarver;
import mysticartifice.containers.ContainerMagicBook;
import mysticartifice.guis.GuiMagicBook;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
/**
 * Created by Millsy on 18/07/14.
 */
public class GuiHandler implements IGuiHandler
{
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        TileEntity entity = world.getTileEntity(x, y, z);
        if (entity != null) {
            switch (ID) {
                case 0:
                    return new ContainerMysticAnvil(player, (TileEntityMysticAnvil) entity);
                case 1:
                    return new ContainerWandCarver(player, (TileEntityWandCarver) entity);
            }
        }
        if(ID == 2) return new ContainerMagicBook();
        return null;
    }
    
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        TileEntity entity = world.getTileEntity(x, y, z);
        if (entity != null) {
            switch (ID) {
                case 0:
                    return new GuiMysticAnvil(player, (TileEntityMysticAnvil) entity);
                case 1:
                    return new GuiWandCarver(player, (TileEntityWandCarver) entity);
            }
        }
        if(ID == 2) return new GuiMagicBook((ContainerMagicBook) getServerGuiElement(ID, player, world, x, y, z), world);
        return null;
    }
}
