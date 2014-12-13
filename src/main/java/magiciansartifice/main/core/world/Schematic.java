package magiciansartifice.main.core.world;

import magiciansartifice.main.MagiciansArtifice;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

import java.io.InputStream;

/**
 * Created by poppypoppop on 13/12/2014.
 */
public class Schematic {
    public NBTTagList tileentities;
    public short width;
    public short height;
    public short length;
    public byte[] blocks;
    public byte[] data;

    public Schematic(NBTTagList tileentities, short width, short height, short length, byte[] blocks, byte[] data) {
        this.tileentities = tileentities;
        this.width = width;
        this.height = height;
        this.length = length;
        this.blocks = blocks;
        this.data = data;
    }

    public static Schematic get(String schemname) {
        try {
            InputStream is = Schematic.class.getClassLoader().getResourceAsStream("assets/magiciansartifice/schematics/" + schemname + ".schematic");
            NBTTagCompound nbtdata = CompressedStreamTools.readCompressed(is);
            short width = nbtdata.getShort("Width");
            short height = nbtdata.getShort("Height");
            short length = nbtdata.getShort("Length");

            byte[] blocks = nbtdata.getByteArray("Blocks");
            byte[] data = nbtdata.getByteArray("Data");

            NBTTagList tileentities = nbtdata.getTagList("TileEntities", 10);
            is.close();

            System.err.println("schem size:" + width + " x " + height + " x " + length);

            return new Schematic(tileentities, width, height, length, blocks, data);
        }
        catch (Exception e) {
            System.err.println("I can't load schematic, because " + e.getMessage() + " at " + e.getStackTrace()[0]);
            return null;
        }
    }
}