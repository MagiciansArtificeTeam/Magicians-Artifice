package magiciansartifice.items.itemblocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

/**
 * Created by poppypoppop on 23/07/2014.
 */
public class ItemBlockStorageMeta extends ItemBlock
{
    public ItemBlockStorageMeta(Block block)
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
                name = "storageEssenceOverworld";
                break;
            }
            case 1:
            {
                name = "storageEssenceNether";
                break;
            }
            case 2:
            {
                name = "storageEssenceEnd";
                break;
            }
            case 3:
            {
                name = "storageStarSteel";
                break;
            }
            case 4:
            {
                name = "storageSteel";
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
