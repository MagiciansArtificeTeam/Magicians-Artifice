package magiciansartifice.main.tileentities.magic;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

import java.util.UUID;

public class TileEntityRitualCornerstone extends TileEntity{

    UUID owner;
    String ownerName;

    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        if (owner != null) {
            nbt.setString("owner",owner.toString());
        }
        if (ownerName != null) {
            nbt.setString("ownerName", ownerName);
        }
    }

    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        if (nbt != null) {
            if (nbt.hasKey("owner")) {
                owner = UUID.fromString(nbt.getString("owner"));
            }
            if (nbt.hasKey("ownerName")) {
                ownerName = nbt.getString("ownerName");
            }
        } else {
            nbt = new NBTTagCompound();
        }
    }

    public UUID setOwner(UUID newOwner) {
        owner = newOwner;
        return this.owner;
    }

    public String setOwnerName(String name) {
        ownerName = name;
        return this.ownerName;
    }

    public UUID getOwner() {
        return this.owner;
    }

    public String getOwnerName() { return this.ownerName; }

}
