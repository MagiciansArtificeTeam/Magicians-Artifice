package magiciansartifice.main.core.client.guis;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import magiciansartifice.main.blocks.BlockRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CreativeTab extends CreativeTabs{

    private ItemStack stack;

    public CreativeTab(String lable) {
        super(lable);
    }

    public CreativeTab(String lable, ItemStack stack) {
        super(lable);
        this.stack = stack;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Item getTabIconItem() {
        return new ItemStack(BlockRegistry.ores,1,0).getItem();
        //return new ItemStack(BlockRegistry.ores, 1, 0).getItem();
    }
}
