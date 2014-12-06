package magiciansartifice.main.core.network.packet;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import magiciansartifice.main.tileentities.magic.TileEntityDisguiseBlock;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by Mitchellbrine on 2014.
 */
public class BlockUpdatePacket
        implements IMessage, IMessageHandler<BlockUpdatePacket, IMessage> {

    private Block block;
    private int meta;
    private int x,y,z;

    public BlockUpdatePacket() {}

    public BlockUpdatePacket(Block block,int meta,int x, int y, int z) {
        this.block = block;
        this.meta = meta;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        block = Block.getBlockById(buf.readInt());
        meta = buf.readInt();
        x = buf.readInt();
        y = buf.readInt();
        z = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(Block.getIdFromBlock(block));
        buf.writeInt(meta);
        buf.writeInt(x);
        buf.writeInt(y);
        buf.writeInt(z);
    }

    @Override
    public IMessage onMessage(BlockUpdatePacket message, MessageContext ctx) {
        TileEntity tileEntity = FMLClientHandler.instance().getClient().theWorld.getTileEntity(message.x, message.y, message.z);
        if (tileEntity instanceof TileEntityDisguiseBlock) {
            TileEntityDisguiseBlock te = (TileEntityDisguiseBlock) tileEntity;
            te.setBlock(message.block,message.meta);
        }
        return null;
    }

}
