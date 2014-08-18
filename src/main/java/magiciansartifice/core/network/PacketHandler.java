package magiciansartifice.core.network;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import magiciansartifice.core.libs.ModInfo;
import magiciansartifice.core.network.packet.FluidPacket;

/**
 * Created by James Hollowell on 7/29/2014.
 */
public class PacketHandler
{
    public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(ModInfo.MODID);

    public static void init()
    {
        INSTANCE.registerMessage(FluidPacket.class, FluidPacket.class, 0, Side.CLIENT);
    }
}
