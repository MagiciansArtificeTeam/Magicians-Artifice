package magiciansartifice.main.core.network;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import magiciansartifice.main.core.libs.ModInfo;
import magiciansartifice.main.core.network.packet.EssencePacket;
import magiciansartifice.main.core.network.packet.FluidPacket;

/**
 * Created by James Hollowell on 7/29/2014.
 */
public class PacketHandler
{
    public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(ModInfo.MODID);

    public static void init()
    {
        INSTANCE.registerMessage(FluidPacket.class, FluidPacket.class, 0, Side.CLIENT);
        INSTANCE.registerMessage(EssencePacket.class, EssencePacket.class, 1, Side.CLIENT);
    }
}
