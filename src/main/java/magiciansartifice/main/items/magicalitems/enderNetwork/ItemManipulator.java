package magiciansartifice.main.items.magicalitems.enderNetwork;

import magiciansartifice.main.core.libs.ModInfo;
import magiciansartifice.main.items.ItemRegistry;
import net.minecraft.block.BlockChest;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryEnderChest;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

/**
 * Created by Mitchellbrine on 2014.
 */
public class ItemManipulator extends Item{

    InventoryEnderChest chestInv = new InventoryEnderChest();

    public ItemManipulator() {
        this.setMaxStackSize(1);
        this.setUnlocalizedName("ender.manipulator");
        this.setTextureName(ModInfo.MODID + ":magical/manipulator");
        ItemRegistry.items.add(this);
    }

    public boolean onItemUse(ItemStack stack, EntityPlayer player, int x, int y, int z, int meta, float hitX, float hitY, float hitZ) {
        if (player.isSneaking()) {
            if (stack.hasTagCompound() && stack.stackTagCompound.hasKey("currentFreq")) {
                if (player.worldObj.getBlock(x, y, z) instanceof BlockChest) {
                    TileEntityChest chest = (TileEntityChest) player.worldObj.getTileEntity(x, y, z);
                    if (chest != null) {
                        chestInv.loadInventoryFromNBT(player.getEntityData().getTagList("EnderItems", 10));
                        for (int i = 0; i < chestInv.getSizeInventory();i++) {
                            chest.setInventorySlotContents(i,chestInv.getStackInSlot(i));
                        }
                    }
                }
            }
        }
            return false;
    }

    @Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int meta, boolean p_77663_5_) {
        if (!stack.hasTagCompound()) {
            stack.stackTagCompound = new NBTTagCompound();
        }
        if (!stack.stackTagCompound.hasKey("currentFreq")) {
            stack.stackTagCompound.setInteger("currentFreq",0);
        }
    }
}
