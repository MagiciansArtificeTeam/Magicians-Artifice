package magiciansartifice.main.core.events;

import magiciansartifice.main.entities.EntitySoulFragment;
import net.minecraft.block.BlockDispenser;
import net.minecraft.dispenser.IBehaviorDispenseItem;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

/**
 * Created by Mitchellbrine on 2014.
 */
public class DispenserSoulBehavior implements IBehaviorDispenseItem{


    protected ItemStack dispenseStack(IBlockSource par1IBlockSource, ItemStack par2ItemStack)
    {
        EnumFacing enumfacing = BlockDispenser.func_149937_b(par1IBlockSource.getBlockMetadata());
        World world = par1IBlockSource.getWorld();
        int i = par1IBlockSource.getXInt() + enumfacing.getFrontOffsetX();
        int j = par1IBlockSource.getYInt() + enumfacing.getFrontOffsetY();
        int k = par1IBlockSource.getZInt() + enumfacing.getFrontOffsetZ();

        if (par2ItemStack.hasTagCompound() && par2ItemStack.stackTagCompound.hasKey("ownerName")) {
            EntitySoulFragment soul = new EntitySoulFragment(world);
            soul.setPlayerName(par2ItemStack.stackTagCompound.getString("ownerName"));
            soul.setLocationAndAngles(i,j,k,0,0);
            world.spawnEntityInWorld(soul);
            System.err.println(soul);
            System.err.println(soul.playerName);
        }

        return par2ItemStack;
    }

    @Override
    public ItemStack dispense(IBlockSource p_82482_1_, ItemStack p_82482_2_) {
        return this.dispenseStack(p_82482_1_, p_82482_2_);
    }
}
