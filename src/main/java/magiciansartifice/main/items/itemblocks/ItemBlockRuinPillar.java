package magiciansartifice.main.items.itemblocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

/**
 * Created by poppypoppop on 10/12/2014.
 */
public class ItemBlockRuinPillar extends ItemBlock {
    public ItemBlockRuinPillar(Block block) {
        super(block);
        this.setHasSubtypes(true);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemstack) {
        String name = "";
        switch (itemstack.getItemDamage()) {
            case 0:case 4:case 8: {
                name = "ruinPillarNormal";
                break;
            }
            case 1:case 5:case 9: {
                name = "ruinPillarBottom";
                break;
            }
            case 2:case 6:case 10: {
                name = "ruinPillarTop";
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