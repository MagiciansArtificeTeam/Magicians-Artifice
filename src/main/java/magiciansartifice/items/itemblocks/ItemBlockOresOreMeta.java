package magiciansartifice.items.itemblocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockOresOreMeta extends ItemBlock
{
    public ItemBlockOresOreMeta(Block block)
    {
        super(block);
        setHasSubtypes(true);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemstack)
    {
        String name = "";
        switch (itemstack.getItemDamage())
        {
            case 0:
            {
                name = "starsteel";
                break;
            }
            default:
                name = "nothing";
        }
        return getUnlocalizedName() + "." + name;
    }

    @Override
    public int getMetadata(int meta)
    {
        return meta;
    }
}
