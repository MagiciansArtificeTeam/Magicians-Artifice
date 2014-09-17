package magiciansartifice.main.compat.nei;

import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;
import magiciansartifice.main.blocks.BlockRegistry;
import magiciansartifice.main.core.client.guis.book.GuiAdvancedBook;
import magiciansartifice.main.core.client.guis.book.GuiMagicBook;
import magiciansartifice.main.core.client.guis.book.GuiRitualBook;
import magiciansartifice.main.core.client.guis.machines.GuiMetalForge;
import magiciansartifice.main.core.client.guis.machines.GuiWandCarver;
import net.minecraft.item.ItemStack;

public class NEIConfig implements IConfigureNEI {
    @Override
    public void loadConfig() {
        API.hideItem(new ItemStack(BlockRegistry.containmentBarrier));
        API.registerRecipeHandler(new WandCarverHandler());
        API.registerUsageHandler(new WandCarverHandler());
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
