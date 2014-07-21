package magiciansartifice.items.itemblocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

/**
 * Created by poppypoppop on 21/07/2014.
 */
public class ItemBlockLogs1Meta extends ItemBlock {
    public ItemBlockLogs1Meta(Block block) {
        super(block);
        setHasSubtypes(true);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemstack) {
        String name = "";
        switch (itemstack.getItemDamage()) {
            case 0: {
                name = "logAsh";
                break;
            }
            case 1: {
                name = "logElm";
                break;
            }
            case 2: {
                name = "logRowan";
                break;
            }
            case 3: {
                name = "logAlder";
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
