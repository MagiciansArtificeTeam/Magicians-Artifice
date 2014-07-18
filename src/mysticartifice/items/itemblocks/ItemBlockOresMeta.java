package mysticartifice.items.itemblocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockOresMeta extends ItemBlock {
    public ItemBlockOresMeta(Block block) {
        super(block);
        setHasSubtypes(true);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemstack) {
        String name = "";
        switch (itemstack.getItemDamage()) {
            case 0: {
                name = "overworldEssence";
                break;
            }
            case 1: {
                name = "netherEssence";
                break;
            }
            case 2: {
                name = "enderEssence";
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
