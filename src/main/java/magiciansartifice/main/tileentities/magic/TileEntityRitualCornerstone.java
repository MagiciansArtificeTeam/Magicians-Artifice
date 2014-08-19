package magiciansartifice.main.tileentities.magic;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

import java.util.UUID;

public class TileEntityRitualCornerstone extends TileEntity{

    UUID owner;

    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        if (owner != null) {
            nbt.setString("owner",owner.toString());
        }
    }

    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        if (nbt != null) {
            if (nbt.hasKey("owner")) {
                owner = UUID.fromString(nbt.getString("owner"));
            }
        } else {
            nbt = new NBTTagCompound();
        }
    }

    public UUID setOwner(UUID newOwner) {
        owner = newOwner;
        return this.owner;
    }

    public UUID getOwner() {
        return this.owner;
    }

}
