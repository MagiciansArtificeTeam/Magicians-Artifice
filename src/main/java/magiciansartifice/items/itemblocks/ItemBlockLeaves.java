package magiciansartifice.items.itemblocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

/**
 * Created by poppypoppop on 6/08/2014.
 */
public class ItemBlockLeaves extends ItemBlock{
    public ItemBlockLeaves(Block block) {
        super(block);
        setHasSubtypes(true);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemstack) {
        String name = "";
        switch (itemstack.getItemDamage()) {
            case 0: {
                name = "leaveAsh";
                break;
            }
            case 1: {
                name = "leaveElm";
                break;
            }
            case 2: {
                name = "leaveRowan";
                break;
            }
            case 3: {
                name = "leaveAlder";
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
