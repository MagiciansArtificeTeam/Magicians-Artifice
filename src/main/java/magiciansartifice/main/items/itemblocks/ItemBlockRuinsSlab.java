package magiciansartifice.main.items.itemblocks;

import magiciansartifice.main.blocks.ruins.BlockRuinSlabMeta;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemStack;

/**
 * Created by poppypoppop on 10/12/2014.
 */
public class ItemBlockRuinsSlab extends ItemSlab {
    public ItemBlockRuinsSlab(Block block, BlockRuinSlabMeta singleSlab, BlockRuinSlabMeta doubleSlab, Boolean bool) {
        super(block, singleSlab, doubleSlab, bool);
        this.setHasSubtypes(true);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemstack) {
        String name = "";
        switch (itemstack.getItemDamage()) {
            case 0:case 8: {
                name = "smooth";
                break;
            }
            case 1:case 9: {
                name = "cracked";
                break;
            }
            case 2:case 10: {
                name = "mossy";
                break;
            }
            case 3:case 11: {
                name = "chiseled";
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