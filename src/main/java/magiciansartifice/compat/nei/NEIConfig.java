package magiciansartifice.compat.nei;

import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;
import magiciansartifice.libs.ModInfo;

/**
 * Created by James Hollowell on 8/8/2014.
 */
public class NEIConfig implements IConfigureNEI
{
    @Override
    public void loadConfig()
    {
        API.registerRecipeHandler(new MetalForgeMoltenHandler());
        API.registerUsageHandler(new MetalForgeMoltenHandler());
    }

    @Override
    public String getName()
    {
        return ModInfo.NAME;
    }

    @Override
    public String getVersion()
    {
        return ModInfo.VERSION;
    }
}
