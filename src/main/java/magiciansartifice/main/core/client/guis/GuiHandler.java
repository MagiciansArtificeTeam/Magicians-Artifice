package magiciansartifice.main.core.client.guis;

import magiciansartifice.main.core.client.guis.machines.GuiMetalForge;
import magiciansartifice.main.containers.ContainerMagicBook;
import magiciansartifice.main.containers.ContainerMetalForge;
import magiciansartifice.main.containers.ContainerMysticAnvil;
import magiciansartifice.main.containers.ContainerWandCarver;
import magiciansartifice.main.core.client.guis.book.GuiMagicBook;
import magiciansartifice.main.core.client.guis.machines.GuiMysticAnvil;
import magiciansartifice.main.core.client.guis.machines.GuiWandCarver;
import magiciansartifice.main.tileentities.machines.TileEntityMetalForge;
import magiciansartifice.main.tileentities.machines.TileEntityMysticAnvil;
import magiciansartifice.main.tileentities.machines.TileEntityWandCarver;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

/**
 * Created by Millsy on 18/07/14.
 */
public class GuiHandler implements IGuiHandler
{
    public static class IDS
    {
        public static final int MysticAnvil=0;
        public static final int WandCarver=1;
        public static final int MagicBook=2;
        public static final int MetalForge=3;
    }
    
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        TileEntity entity = world.getTileEntity(x, y, z);
        if (entity != null)
        {
            switch (ID)
            {
                case IDS.MysticAnvil:
                    return new ContainerMysticAnvil(player, (TileEntityMysticAnvil) entity);
                case IDS.WandCarver:
                    return new ContainerWandCarver(player, (TileEntityWandCarver) entity);
                case IDS.MetalForge:
                    return new ContainerMetalForge(player, ((TileEntityMetalForge)entity).getMaster());
            }
        }
        if (ID == IDS.MagicBook) return new ContainerMagicBook();
        return null;
    }
    
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        TileEntity entity = world.getTileEntity(x, y, z);
        if (entity != null)
        {
            switch (ID)
            {
                case IDS.MysticAnvil:
                    return new GuiMysticAnvil(player, (TileEntityMysticAnvil) entity);
                case IDS.WandCarver:
                    return new GuiWandCarver(player, (TileEntityWandCarver) entity);
                case IDS.MetalForge:
                    return new GuiMetalForge(player, ((TileEntityMetalForge)entity).getMaster());
            }
        }
        if (ID == IDS.MagicBook) return new GuiMagicBook((ContainerMagicBook) getServerGuiElement(ID, player, world, x, y, z), world);
        return null;
    }
}
