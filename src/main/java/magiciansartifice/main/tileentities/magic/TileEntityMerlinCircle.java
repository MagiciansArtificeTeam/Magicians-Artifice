package magiciansartifice.main.tileentities.magic;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by poppypoppop on 9/10/2014.
 */
public class TileEntityMerlinCircle extends TileEntity {
    public ItemStack replacingBlock;

    public TileEntityMerlinCircle() {
        replacingBlock = null;
    }

    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);
        replacingBlock.readFromNBT(tag.getCompoundTag("replacingBlock"));
    }

    public void writeToNBT(NBTTagCompound tag) {
        tag.setTag("replacingBlock", replacingBlock.writeToNBT(new NBTTagCompound()));
        super.writeToNBT(tag);
    }

    public ItemStack getItemStack() {
        return this.replacingBlock;
    }

    public void setItemStack(Block block, int i, int blockMetadata) {
        this.replacingBlock = new ItemStack(block, i, blockMetadata);
    }

    public void setItemStack(ItemStack stack) {
        this.replacingBlock = stack;
    }
}
