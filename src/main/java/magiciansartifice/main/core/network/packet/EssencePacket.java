package magiciansartifice.main.core.network.packet;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;

/**
 * Created by Mitchellbrine on 2014.
 */
public class EssencePacket
        implements IMessage, IMessageHandler<EssencePacket, IMessage> {

    private int earth, nether, ender;

    public EssencePacket()
    {
    }

    public EssencePacket(int x, int y, int z)
    {
        this.earth = x;
        this.nether = y;
        this.ender = z;
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        earth = buf.readInt();
        nether = buf.readInt();
        ender = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeInt(earth);
        buf.writeInt(nether);
        buf.writeInt(ender);
    }

    @Override
    public IMessage onMessage(EssencePacket message, MessageContext ctx)
    {
        Minecraft.getMinecraft().thePlayer.getEntityData().setInteger("overworldEssence",earth);
        Minecraft.getMinecraft().thePlayer.getEntityData().setInteger("netherEssence",nether);
        Minecraft.getMinecraft().thePlayer.getEntityData().setInteger("enderEssence",ender);
        return null;
    }

}
