package magiciansartifice.main.tileentities.magic;

import magiciansartifice.main.items.magicalitems.ItemWand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;

import java.util.Random;

public class TileEntityEssenceHole extends TileEntity{

    Random random = new Random();

    private int overworldEssence;
    private int netherEssence;
    private int enderEssence;

    private int maxOverworld;
    private int maxNether;
    private int maxEnder;

    public TileEntityEssenceHole() {
        maxOverworld = random.nextInt(100);
        maxNether = random.nextInt(100);
        maxEnder = random.nextInt(100);

        overworldEssence = maxOverworld;
        netherEssence = maxNether;
        enderEssence = maxEnder;
    }

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
                    int oEssence = this.getOverworldEssence();
                    this.overworldEssence = oEssence - 1;
                }
            }
        }
        return stack;
    }

    @Override
    public void updateEntity() {
        super.updateEntity();
        if (random.nextInt(10000) >= 5000) {
            switch (random.nextInt(3)) {
                case 0:
                    int newEssence = this.getOverworldEssence() + 1;
                    if (newEssence <= this.getMaxOverworld()) {
                        this.overworldEssence = newEssence;
                    }
                    break;
                case 1:
                    int newNEssence = this.getNetherEssence() + 1;
                    if (newNEssence <= this.getMaxNether()) {
                        this.netherEssence = newNEssence;
                    }
                    break;
                case 2:
                    int newEEssence = this.getEnderEssence() + 1;
                    if (newEEssence <= this.getMaxEnder()) {
                        this.enderEssence = newEEssence;
                    }
                    break;
                case 3:
                    int newOEssence = this.getOverworldEssence() + 1;
                    if (newOEssence <= this.getMaxOverworld()) {
                        this.overworldEssence = newOEssence;
                    }
                    int newNNEssence = this.getNetherEssence() + 1;
                    if (newNNEssence <= this.getMaxNether()) {
                        this.netherEssence = newNNEssence;
                    }
                    int newEEEssence = this.getEnderEssence() + 1;
                    if (newEEEssence <= this.getMaxEnder()) {
                        this.enderEssence = newEEEssence;
                    }
                    break;
                default:
                    int newDefault = this.getOverworldEssence() + 1;
                    if (newDefault <= this.getMaxOverworld()) {
                        this.overworldEssence = newDefault;
                    }
                    break;
            }
        }
    }

    public ItemStack stealNEssence(ItemStack stack) {
        if (this.getNetherEssence() > 0) {
            if (stack.getItem() instanceof ItemWand) {
                ItemWand wand = (ItemWand) stack.getItem();
                int currentEssence = stack.stackTagCompound.getInteger("wandEssenceN");
                if (currentEssence < (25 * wand.getWandLevel())) {
                    stack.stackTagCompound.setInteger("wandEssenceN", currentEssence + 1);
                    stack.setTagCompound(stack.stackTagCompound);
                    int nEssence = this.getNetherEssence();
                    this.netherEssence = nEssence - 1;
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
                    int eEssence = this.getEnderEssence();
                    this.enderEssence = eEssence - 1;
                }
            }
        }
        return stack;
    }

    public void printChatMessage(EntityPlayer player) {
        if (!player.worldObj.isRemote) {
            player.addChatComponentMessage(new ChatComponentTranslation("hole.print",this.getOverworldEssence(),this.getNetherEssence(),this.getEnderEssence()).setChatStyle(new ChatStyle().setColor(EnumChatFormatting.DARK_PURPLE).setItalic(true)));
        }
    }

}
