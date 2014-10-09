package magiciansartifice.main.items.itemblocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

/**
 * Created by poppypoppop on 9/10/2014.
 */
public class ItemBlockRunes extends ItemBlock {
    public ItemBlockRunes(Block block) {
        super(block);
        setHasSubtypes(true);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemstack) {
        String name = "";
        switch (itemstack.getItemDamage()) {
            case 0: {
                name = "runeTime";
                break;
            }
            case 1: {
                name = "runeMotion";
                break;
            }
            case 2: {
                name = "runeMatter";
                break;
            }
            case 3: {
                name = "runeElements";
                break;
            }
            case 4: {
                name = "runeTransformation";
                break;
            }
            case 5:  {
                name = "runeMind";
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
