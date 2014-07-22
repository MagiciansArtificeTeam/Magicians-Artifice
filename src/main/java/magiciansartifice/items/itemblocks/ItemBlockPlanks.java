package magiciansartifice.items.itemblocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

/**
 * Created by poppypoppop on 22/07/2014.
 */
public class ItemBlockPlanks extends ItemBlock {
    public ItemBlockPlanks(Block block) {
        super(block);
        setHasSubtypes(true);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemstack) {
        String name = "";
        switch (itemstack.getItemDamage()) {
            case 0: {
                name = "plankAsh";
                break;
            }
            case 1: {
                name = "plankElm";
                break;
            }
            case 2: {
                name = "plankRowan";
                break;
            }
            case 3: {
                name = "plankAlder";
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
