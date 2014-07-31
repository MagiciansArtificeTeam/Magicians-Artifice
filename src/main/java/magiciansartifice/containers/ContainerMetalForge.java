package magiciansartifice.containers;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import magiciansartifice.MagiciansArtifice;
import magiciansartifice.containers.slot.SlotBurnable;
import magiciansartifice.containers.slot.SlotCarbon;
import magiciansartifice.containers.slot.SlotMetal;
import magiciansartifice.containers.slot.SlotOutput;
import magiciansartifice.tileentities.machines.TileEntityMetalForge;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerMetalForge extends Container
{
    private TileEntityMetalForge forge;

    private int lastFuelTime, lastCarbonTime, lastMetalTime, lastFuelMax, lastCoolTime;

    public ContainerMetalForge(EntityPlayer player, TileEntityMetalForge tile)
    {
        this.forge = tile;

        addSlotToContainer(new SlotMetal(tile, TileEntityMetalForge.METAL_SLOT, 29, 18));
        addSlotToContainer(new SlotCarbon(tile, TileEntityMetalForge.CARBON_SLOT, 29, 50));
        addSlotToContainer(new SlotBurnable(tile, TileEntityMetalForge.FUEL_SLOT, 8, 41));
        addSlotToContainer(new SlotOutput(tile, TileEntityMetalForge.OUTPUT_SLOT, 140, 36));

        //Player inventory
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                addSlotToContainer(new Slot(player.inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }
        for (int i = 0; i < 9; i++)
        {
            addSlotToContainer(new Slot(player.inventory, i, 8 + i * 18, 142));
        }
    }

    public boolean canInteractWith(EntityPlayer par1EntityPlayer)
    {
        return this.forge.isUseableByPlayer(par1EntityPlayer);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slotNum)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot) this.inventorySlots.get(slotNum);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (slotNum < TileEntityMetalForge.INV_SIZE)
            {
                if (!this.mergeItemStack(itemstack1, TileEntityMetalForge.INV_SIZE, inventorySlots.size(), false))
                {
                    return null;
                }

            }
            else
            {
                if (forge.isItemValidForSlot(TileEntityMetalForge.FUEL_SLOT, itemstack1))
                {
                    if (!this.mergeItemStack(itemstack1, TileEntityMetalForge.FUEL_SLOT, TileEntityMetalForge.FUEL_SLOT + 1, false))
                    {
                        return null;
                    }
//                    else
//                    {
//                        //Try to put it in the smelting slot if the fuel is full or of a different type
//                        if (forge.isItemValidForSlot(TileEntityMetalForge.CARBON_SLOT, itemstack1))
//                        {
//                            if (!this.mergeItemStack(itemstack1, TileEntityMetalForge.CARBON_SLOT, TileEntityMetalForge.CARBON_SLOT + 1, false))
//                            {
//                                return null;
//                            }
//                        }
//                        else if (forge.isItemValidForSlot(TileEntityMetalForge.METAL_SLOT, itemstack1))
//                        {
//                            if (!this.mergeItemStack(itemstack1, TileEntityMetalForge.METAL_SLOT - 2, TileEntityMetalForge.METAL_SLOT - 1, false))
//                            {
//                                return null;
//                            }
//                        }
//                        else return null;
//                    }
                }
                else if (forge.isItemValidForSlot(TileEntityMetalForge.CARBON_SLOT, itemstack1))
                {
                    if (!this.mergeItemStack(itemstack1, TileEntityMetalForge.CARBON_SLOT, TileEntityMetalForge.CARBON_SLOT + 1, false))
                    {
                        return null;
                    }
                }
                else if (forge.isItemValidForSlot(TileEntityMetalForge.METAL_SLOT, itemstack1))
                {
                    if (!this.mergeItemStack(itemstack1, TileEntityMetalForge.METAL_SLOT - 2, TileEntityMetalForge.METAL_SLOT - 1, false))
                    {
                        return null;
                    }
                }
            }

            if (itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack) null);
            }
            else
            {
                slot.onSlotChanged();
            }

            //            if (itemstack1.stackSize == itemstack.stackSize)
            //            {
            //                return null;
            //            }
            //
            //            slot.onPickupFromSlot(player, itemstack1);
        }

        return itemstack;
    }

    @Override
    public void detectAndSendChanges()
    {
        //update all the inventory slots
        super.detectAndSendChanges();

        for (int i = 0; i < this.crafters.size(); ++i)
        {
            ICrafting icrafting = (ICrafting) this.crafters.get(i);

            if (this.lastFuelTime != this.forge.fuelTime)
            {
                icrafting.sendProgressBarUpdate(this, 0, this.forge.fuelTime);
            }

            if (this.lastFuelMax != this.forge.fuelMax)
            {
                icrafting.sendProgressBarUpdate(this, 1, this.forge.fuelMax);
            }

            if (this.lastCarbonTime != this.forge.carbonBurnTime)
            {
                icrafting.sendProgressBarUpdate(this, 2, this.forge.carbonBurnTime);
            }

            if (this.lastMetalTime != this.forge.metalBurnTime)
            {
                icrafting.sendProgressBarUpdate(this, 3, this.forge.metalBurnTime);
            }

            if (this.lastCoolTime != this.forge.coolTime)
            {
                icrafting.sendProgressBarUpdate(this, 4, this.forge.coolTime);
            }
        }

        this.lastMetalTime = this.forge.metalBurnTime;
        this.lastCarbonTime = this.forge.carbonBurnTime;
        this.lastFuelMax = this.forge.fuelMax;
        this.lastFuelTime = this.forge.fuelTime;
        this.lastCoolTime = this.forge.coolTime;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int val)
    {
        switch (id)
        {
            case 0:
                this.forge.fuelTime = val;
                break;
            case 1:
                this.forge.fuelMax = val;
                break;
            case 2:
                this.forge.carbonBurnTime = val;
                break;
            case 3:
                this.forge.metalBurnTime = val;
                break;
            case 4:
                this.forge.coolTime = val;
                break;
            default:
                MagiciansArtifice.logger.error("Invalid id in ContainerMetalForge:updateProgressBar: " + id);
                break;
        }
    }
}
