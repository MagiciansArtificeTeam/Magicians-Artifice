package magiciansartifice.tileentities.magic;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by poppypoppop on 8/08/2014.
 */
public class TileEntityTeleportReciever extends TileEntity {
    public static int x = 0;
    public static int y = 0;
    public static int z = 0;

    public TileEntityTeleportReciever() {
        super();
    }

    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        if (x == 0) {
            nbt.setInteger("x", x);
        }
        if (y == 0) {
            nbt.setInteger("y", y);
        }
        if (z == 0) {
            nbt.setInteger("z", z);
        }
    }

    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        if (nbt != null) {
            if (nbt.hasKey("x")) {
                x = nbt.getInteger("x");
            }
            if (nbt.hasKey("y")) {
                y = nbt.getInteger("y");
            }
            if (nbt.hasKey("z")) {
                z = nbt.getInteger("z");
            }
        } else {
            nbt = new NBTTagCompound();
        }
    }

    public void setTeleportRecieveCoords(int x1, int y1, int z1) {
        x = x1;
        y = y1;
        z = z1;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }
}
