package magiciansartifice.main.core.network.packet;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.tileentities.machines.TileEntityMetalForge;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by James Hollowell on 7/29/2014.
 */
public class FluidPacket
        implements IMessage, IMessageHandler<FluidPacket, IMessage>
{
    private String name = "";
    private int amount = 0;
    private int x, y, z;

    public FluidPacket()
    {
    }

    public FluidPacket(String name, int amount, int x, int y, int z)
    {
        this.name = name;
        this.amount = amount;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        name = ByteBufUtils.readUTF8String(buf);
        amount = buf.readInt();
        x = buf.readInt();
        y = buf.readInt();
        z = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        ByteBufUtils.writeUTF8String(buf, name);
        buf.writeInt(amount);
        buf.writeInt(x);
        buf.writeInt(y);
        buf.writeInt(z);
    }

    @Override
    public IMessage onMessage(FluidPacket message, MessageContext ctx)
    {
        TileEntity te = FMLClientHandler.instance().getClient().theWorld.getTileEntity(message.x, message.y, message.z);
        if (te instanceof TileEntityMetalForge)
        {
            if (((TileEntityMetalForge) te).hasMaster() && ((TileEntityMetalForge) te).isMaster())
            {
                ((TileEntityMetalForge) te).fluids.put(message.name, message.amount);
                ((TileEntityMetalForge) te).needsFluidUpdate = true;
            }
            else
            {
                MagiciansArtifice.logger.error("Error on client receiving fluid info from client: not master");
            }
        }
        return null;
    }
}
