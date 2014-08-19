package magiciansartifice.main.tileentities.magic;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by poppypoppop on 8/08/2014.
 */
public class TileEntityTeleportReciever extends TileEntity {

    public TileEntityTeleportReciever() {
        super();
    }

    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
    }

    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
    }

    public int getX() {
        return xCoord;
    }

    public int getY() {
        return yCoord;
    }

    public int getZ() {
        return zCoord;
    }
}
