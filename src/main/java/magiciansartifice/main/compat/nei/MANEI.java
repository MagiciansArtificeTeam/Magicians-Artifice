package magiciansartifice.main.compat.nei;

import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;
import magiciansartifice.main.blocks.BlockRegistry;
import net.minecraft.item.ItemStack;

public class MANEI implements IConfigureNEI {
    @Override
    public void loadConfig() {
        API.hideItem(new ItemStack(BlockRegistry.containmentBarrier));
        API.registerRecipeHandler(new WandCarverHandler());
    }

    @Override
    public String getName() {
        return "Magician's Artifice";
    }

    @Override
    public String getVersion() {
        return "1.0";
    }
}
