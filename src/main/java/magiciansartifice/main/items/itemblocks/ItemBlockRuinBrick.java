package magiciansartifice.main.items.itemblocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

/**
 * Created by poppypoppop on 10/12/2014.
 */
public class ItemBlockRuinBrick extends ItemBlock {
    public ItemBlockRuinBrick(Block block) {
        super(block);
        this.setHasSubtypes(true);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemstack) {
        String name = "";
        switch (itemstack.getItemDamage()) {
            case 0: {
                name = "ruinBrickNormal";
                break;
            }
            case 1: {
                name = "ruinBrickCracked";
                break;
            }
            case 2: {
                name = "ruinBrickMossy";
                break;
            }
            case 3: {
                name = "ruinBrickChiseled";
                break;
            }
            case 4: {
                name = "ruinBrickNormalNether";
                break;
            }
            case 5: {
                name = "ruinBrickCrackedNether";
                break;
            }
            case 6: {
                name = "ruinBrickMossyNether";
                break;
            }
            case 7: {
                name = "ruinBrickChiseledNether";
                break;
            }
            case 8: {
                name = "ruinBrickNormalEnd";
                break;
            }
            case 9: {
                name = "ruinBrickCrackedEnd";
                break;
            }
            case 10: {
                name = "ruinBrickMossyEnd";
                break;
            }
            case 11: {
                name = "ruinBrickChiseledEnd";
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