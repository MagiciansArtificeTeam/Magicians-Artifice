package magiciansartifice.main.tileentities.magic;

import magiciansartifice.main.items.magicalitems.ItemWand;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

import java.util.Random;

public class TileEntityEssenceHole extends TileEntity{

    Random random = new Random();

    private int overworldEssence;
    private int netherEssence;
    private int enderEssence;

    private int maxOverworld;
    private int maxNether;
    private int maxEnder;

    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        if (nbt != null) {
            if (nbt.hasKey("maxOverworld")) {
                maxOverworld = nbt.getInteger("maxOverworld");
            } else {
                maxOverworld = random.nextInt(100);
            }
            if (nbt.hasKey("maxNether")) {
                maxNether = nbt.getInteger("maxNether");
            } else {
                maxNether = random.nextInt(100);
            }
            if (nbt.hasKey("maxEnder")) {
                maxEnder = nbt.getInteger("maxEnder");
            } else {
                maxEnder = random.nextInt(100);
            }

            if (nbt.hasKey("overworldEssence")) {
                overworldEssence = nbt.getInteger("overworldEssence");
            }
            if (nbt.hasKey("netherEssence")) {
                netherEssence = nbt.getInteger("netherEssence");
            }
            if (nbt.hasKey("enderEssence")) {
                enderEssence = nbt.getInteger("enderEssence");
            }

        } else {
            maxOverworld = random.nextInt(100);
            maxNether = random.nextInt(100);
            maxEnder = random.nextInt(100);

            overworldEssence = maxOverworld;
            netherEssence = maxNether;
            enderEssence = maxEnder;
        }
    }

    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        if (nbt == null) {
            nbt = new NBTTagCompound();
        }
        nbt.setInteger("overworldEssence",this.overworldEssence);
        nbt.setInteger("netherEssence",this.netherEssence);
        nbt.setInteger("enderEssence",this.enderEssence);

        nbt.setInteger("maxOverworld",this.maxOverworld);
        nbt.setInteger("maxNether",this.maxNether);
        nbt.setInteger("maxEnder",this.maxEnder);

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

    public ItemStack stealOEssence(ItemStack stack) {
        if (this.getOverworldEssence() > 0) {
            if (stack.getItem() instanceof ItemWand) {
                ItemWand wand = (ItemWand) stack.getItem();
                int currentEssence = stack.stackTagCompound.getInteger("wandEssence");
                if (currentEssence < (25 * wand.getWandLevel())) {
                    stack.stackTagCompound.setInteger("wandEssence", currentEssence + 1);
                    stack.setTagCompound(stack.stackTagCompound);
                    currentEssence = stack.stackTagCompound.getInteger("wandEssence");
                    System.err.println(currentEssence);
                }
            }
        }
        return stack;
    }

    public ItemStack stealNEssence(ItemStack stack) {
        if (this.getNetherEssence() > 0) {
            if (stack.getItem() instanceof ItemWand) {
                ItemWand wand = (ItemWand) stack.getItem();
                int currentEssence = stack.stackTagCompound.getInteger("wandEssenceN");
                if (currentEssence < (25 * wand.getWandLevel())) {
                    stack.stackTagCompound.setInteger("wandEssenceN", currentEssence + 1);
                    stack.setTagCompound(stack.stackTagCompound);
                    currentEssence = stack.stackTagCompound.getInteger("wandEssenceN");
                    System.err.println(currentEssence);
                }
            }
        }
        return stack;
    }

    public ItemStack stealEEssence(ItemStack stack) {
        if (this.getEnderEssence() > 0) {
            if (stack.getItem() instanceof ItemWand) {
                ItemWand wand = (ItemWand) stack.getItem();
                int currentEssence = stack.stackTagCompound.getInteger("wandEssenceE");
                if (currentEssence < (25 * wand.getWandLevel())) {
                    stack.stackTagCompound.setInteger("wandEssenceE", currentEssence + 1);
                    stack.setTagCompound(stack.stackTagCompound);
                    currentEssence = stack.stackTagCompound.getInteger("wandEssenceE");
                    System.err.println(currentEssence);
                }
            }
        }
        return stack;
    }

}
