package magiciansartifice.main.compat.waila;

import magiciansartifice.main.tileentities.magic.TileEntityRitualCornerstone;
import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;
import mcp.mobius.waila.api.IWailaDataProvider;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;

import java.util.List;
import java.util.Map;

public class CornerstoneProvider implements IWailaDataProvider
{

    @Override
    public ItemStack getWailaStack(IWailaDataAccessor accessor, IWailaConfigHandler config)
    {
        return null;
    }

    @Override
    public List<String> getWailaHead(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config)
    {
        return null;
    }

    @Override
    public List<String> getWailaBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config)
    {
        if (accessor.getTileEntity() instanceof TileEntityRitualCornerstone)
        {
            TileEntityRitualCornerstone te = (TileEntityRitualCornerstone) accessor.getTileEntity();
            if (te.getOwnerName() != null) {
                currenttip.add("Owner: " + te.getOwnerName());
            } else {
                if (te.getOwner() != null) {
                    currenttip.add("Owner: " + te.getOwner());
                } else {
                    currenttip.add("Not bound to any owner!");
                }
            }
        }
        return currenttip;
    }

    @Override
    public List<String> getWailaTail(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config)
    {
        return null;
    }
}