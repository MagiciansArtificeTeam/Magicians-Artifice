package magiciansartifice.main.tileentities.magic;

import magiciansartifice.main.blocks.BlockRegistry;
import magiciansartifice.main.core.network.PacketHandler;
import magiciansartifice.main.core.network.packet.BlockUpdatePacket;
import magiciansartifice.main.core.network.packet.EssencePacket;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by Mitchellbrine on 2014.
 */
public class TileEntityDisguiseBlock extends TileEntity {

    private Block block;
    private int meta;

    public TileEntityDisguiseBlock() {
        block = null;
        meta = 0;
    }

    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        if (block != null) {
            nbt.setInteger("blockID", Block.getIdFromBlock(block));
        }
        nbt.setInteger("blockMeta", meta);
    }

    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        if (nbt.hasKey("blockID")) {
            block = Block.getBlockById(nbt.getInteger("blockID"));
        }
        if (nbt.hasKey("blockMeta")) {
            meta = nbt.getInteger("blockMeta");
        }

    }

    public void updateEntity() {
        if (worldObj != null)
        if (block != null) {
            if (worldObj.getWorldTime() % 20 == 0) {
                this.setBlock(block,meta);
            }
        }
    }

    public Block getBlock() {
        return this.block;
    }

    public int getMetadata() {
        return this.meta;
    }

    public void setBlock(Block block, int meta) {
        this.block = block;
        this.meta = meta;
        if (!worldObj.isRemote) {
            if (worldObj.getClosestPlayer(xCoord, yCoord, zCoord, 500) != null && worldObj.getClosestPlayer(xCoord, yCoord, zCoord, 500) instanceof EntityPlayerMP) {
                PacketHandler.INSTANCE.sendTo(new BlockUpdatePacket(this.block, this.meta, xCoord, yCoord, zCoord), (EntityPlayerMP) worldObj.getClosestPlayer(xCoord, yCoord, zCoord, 500));
            }
        }
        worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
    }

}
