package mysticartifice.items;

import mysticartifice.MysticArtifice;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemMagicBook extends Item 
{
    public ItemMagicBook() 
    {
        super();
    }
    
    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) 
    {
        if (world.isRemote) 
        {
            player.openGui(MysticArtifice.instance, 1, world, 0, 0, 0);
        }

        return stack;
    }
}