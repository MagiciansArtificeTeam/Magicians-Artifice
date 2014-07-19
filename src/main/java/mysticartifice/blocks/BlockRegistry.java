package mysticartifice.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import mysticartifice.blocks.machines.BlockMetalForge;
import mysticartifice.blocks.machines.BlockMysticAnvil;
import mysticartifice.items.itemblocks.ItemBlockOresMeta;
import net.minecraft.block.Block;

public class BlockRegistry {
    public static Block ores;
    public static Block mysticAnvil;
    public static Block metalForge;

    public static void registerBlocks() {
        ores = new BlockOresMeta().setBlockName("metaOres");
        GameRegistry.registerBlock(ores, ItemBlockOresMeta.class, "MetaOres");
        mysticAnvil = new BlockMysticAnvil();
        GameRegistry.registerBlock(mysticAnvil, mysticAnvil.getUnlocalizedName());
        metalForge = new BlockMetalForge();
        GameRegistry.registerBlock(metalForge, metalForge.getUnlocalizedName());
    }
}
