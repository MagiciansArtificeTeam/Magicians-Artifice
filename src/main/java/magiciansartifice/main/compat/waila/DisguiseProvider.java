package magiciansartifice.main.compat.waila;

import magiciansartifice.main.core.utils.registries.BlockRegistry;
import magiciansartifice.main.tileentities.magic.TileEntityDisguiseBlock;
import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;
import mcp.mobius.waila.api.IWailaDataProvider;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

import java.util.List;

/**
 * Created by Mitchellbrine on 2014.
 */
public class DisguiseProvider implements IWailaDataProvider {

    @Override
    public ItemStack getWailaStack(IWailaDataAccessor accessor, IWailaConfigHandler configHandler)
    {
        Block block = accessor.getBlock();
        if (block == BlockRegistry.disguiseBlock) {
            TileEntity tileEntity = accessor.getTileEntity();
            if (tileEntity instanceof TileEntityDisguiseBlock) {
                TileEntityDisguiseBlock te = (TileEntityDisguiseBlock) tileEntity;
                if (te.getBlock() != null) {
                    return new ItemStack(te.getBlock(),1,te.getMetadata());
                }
            }
        }
        return null;
    }

    @Override
    public List<String> getWailaHead(ItemStack itemStack, List<String> list, IWailaDataAccessor iWailaDataAccessor, IWailaConfigHandler iWailaConfigHandler) {
        return list;
    }

    @Override
    public List<String> getWailaBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config)
    {
        return currenttip;
    }

    @Override
    public List<String> getWailaTail(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config)
    {
        return currenttip;
    }

}
