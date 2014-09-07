package magiciansartifice.main.items.itemblocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockSaplingMeta extends ItemBlock {
    public ItemBlockSaplingMeta(Block block)
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
                name = "saplingAsh";
                break;
            }
            case 1:
            {
                name = "saplingElm";
                break;
            }
            case 2:
            {
                name = "saplingRowan";
                break;
            }
            case 3:
            {
                name = "saplingAlder";
                break;
            }
            default:
                name = "nothing";
        }
        return getUnlocalizedName() + "." + name;
    }

    @Override
    public int getMetadata(int meta) {
        return meta;
    }
}
