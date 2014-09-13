package magiciansartifice.compat.waila;

import magiciansartifice.tileentities.machines.TileEntityMetalForge;
import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;
import mcp.mobius.waila.api.IWailaDataProvider;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;

import java.util.List;
import java.util.Map;

/**
 * Created by James Hollowell on 8/12/2014.
 */
public class MetalForgeProvider implements IWailaDataProvider
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
        if (accessor.getTileEntity() instanceof TileEntityMetalForge)
        {
            TileEntityMetalForge te = (TileEntityMetalForge) accessor.getTileEntity();
            if (!te.isMaster())
                te = te.getMaster(); //look to the master if not master
            //These do not work because client only getting updated via the gui functions.. Might need to change...meh
//            if (te.metalBurnTime > 0)
//                currenttip.add(I18n.format("hud.metalBurn",(double)te.metalBurnTime/(double)TileEntityMetalForge.MAX_METAL_TIME*100D));
//            if(te.carbonBurnTime>0)
//                currenttip.add(I18n.format("hud.carbonBurn",(double)te.carbonBurnTime/(double)TileEntityMetalForge.MAX_CARBON_TIME*100D));
//            if(te.coolTime>0)
//                currenttip.add(I18n.format("hud.cooling", (double)te.coolTime/(double)TileEntityMetalForge.MAX_COOL_TIME*100D));
            if(te.fluids.keySet().size()>0)
            {
                currenttip.add(I18n.format("hud.moltenContains"));
                for(Map.Entry<String, Integer> entry: te.fluids.entrySet())
                {
                    currenttip.add(I18n.format(entry.getKey())+": "+I18n.format("nei.amount2",(int)entry.getValue()));
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
