package magiciansartifice.main.tileentities.magic;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityEssenceHole extends TileEntity{

    private int overworldEssence;
    private int netherEssence;
    private int enderEssence;

    private int maxOverworld;
    private int maxNether;
    private int maxEnder;

    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        if (nbt != null) {
            if (nbt.hasKey("overworldEssence")) {
                overworldEssence = nbt.getInteger("overworldEssence");
            }
            if (nbt.hasKey("netherEssence")) {
                netherEssence = nbt.getInteger("netherEssence");
            }
            if (nbt.hasKey("enderEssence")) {
                enderEssence = nbt.getInteger("enderEssence");
            }
            if (nbt.hasKey("maxOverworld")) {
                maxOverworld = nbt.getInteger("maxOverworld");
            }
            if (nbt.hasKey("maxNether")) {
                maxNether = nbt.getInteger("maxNether");
            }
            if (nbt.hasKey("maxEnder")) {
                maxEnder = nbt.getInteger("maxEnder");
            }
        }
    }

    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
    }

    public int getOverworldEssence() {
        return this.overworldEssence;
    }

    public int getNetherEssence() {
        return this.netherEssence;
    }

    public int getEnderEssence() {
        return this.enderEssence;
    }

    public int getMaxOverworld() {
        return this.maxOverworld;
    }

    public int getMaxNether() {
        return this.maxNether;
    }

    public int getMaxEnder() {
        return this.maxEnder;
    }

}
