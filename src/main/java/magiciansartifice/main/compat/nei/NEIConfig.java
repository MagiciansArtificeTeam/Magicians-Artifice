package magiciansartifice.main.compat.nei;

import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;
import magiciansartifice.main.core.utils.registries.BlockRegistry;
import magiciansartifice.main.core.utils.registries.ItemRegistry;
import net.minecraft.item.ItemStack;

public class NEIConfig implements IConfigureNEI {
    @Override
    public void loadConfig() {
        API.hideItem(new ItemStack(BlockRegistry.containmentBarrier));
        API.hideItem(new ItemStack(BlockRegistry.wandMakerLit));
        API.hideItem(new ItemStack(BlockRegistry.merlinscircle));
        API.hideItem(new ItemStack(ItemRegistry.wand));
        API.registerRecipeHandler(new WandCarverHandler());
        API.registerUsageHandler(new WandCarverHandler());
        API.registerRecipeHandler(new MysticAnvilHandler());
        API.registerUsageHandler(new MysticAnvilHandler());
    }

    @Override
    public String getName() {
        return "Magician's Artifice NEI";
    }

    @Override
    public String getVersion() {
        return "1.0";
    }
}
