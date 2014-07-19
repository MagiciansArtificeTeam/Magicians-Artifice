package mysticartifice.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import mysticartifice.items.itemblocks.ItemBlockOresMeta;
import net.minecraft.block.Block;

public class BlockRegistry {
    public static Block ores;

    public static void registerBlocks() {
        ores = new BlockOresMeta().setBlockName("metaOres");
        GameRegistry.registerBlock(ores, ItemBlockOresMeta.class, "MetaOres");
    }
}
