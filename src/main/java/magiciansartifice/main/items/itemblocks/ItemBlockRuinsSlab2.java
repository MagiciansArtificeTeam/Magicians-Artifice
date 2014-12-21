package magiciansartifice.main.items.itemblocks;

import magiciansartifice.main.blocks.ruins.BlockRuinSlab2;
import net.minecraft.block.Block;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemStack;

/**
 * Created by poppypoppop on 10/12/2014.
 */
public class ItemBlockRuinsSlab2 extends ItemSlab {
    public ItemBlockRuinsSlab2(Block block, BlockRuinSlab2 singleSlab, BlockRuinSlab2 doubleSlab, Boolean bool) {
        super(block, singleSlab, doubleSlab, bool);
        this.setHasSubtypes(true);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemstack) {
        String name = "";
        switch (itemstack.getItemDamage()) {
            case 0:case 8: {
                name = "smooth3";
                break;
            }
            case 1:case 9: {
                name = "cracked3";
                break;
            }
            case 2:case 10: {
                name = "mossy3";
                break;
            }
            case 3:case 11: {
                name = "chiseled3";
                break;
            }
            default:
                name = "nothing3";
        }
        return getUnlocalizedName() + "." + name;
    }

    @Override
    public int getMetadata(int meta) {
        return meta;
    }
}