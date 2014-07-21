package magiciansartifice.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import magiciansartifice.blocks.machines.BlockMetalForge;
import magiciansartifice.blocks.machines.BlockMysticAnvil;
import magiciansartifice.items.itemblocks.ItemBlockOresMeta;
import magiciansartifice.items.itemblocks.ItemBlockOresOreMeta;
import net.minecraft.block.Block;

public class BlockRegistry {
    public static Block ores;
    public static Block oresOres;
    public static Block mysticAnvil;
    public static Block metalForge;

    public static void registerBlocks() {
        ores = new BlockOresDustMeta().setBlockName("metaOres");
        GameRegistry.registerBlock(ores, ItemBlockOresMeta.class, "MetaOres");
        oresOres = new BlockOresOreMeta().setBlockName("metaOresOre");
        GameRegistry.registerBlock(oresOres, ItemBlockOresOreMeta.class, "MetaOresOre");
        mysticAnvil = new BlockMysticAnvil();
        GameRegistry.registerBlock(mysticAnvil, mysticAnvil.getUnlocalizedName());
        metalForge = new BlockMetalForge();
        GameRegistry.registerBlock(metalForge, metalForge.getUnlocalizedName());
    }
}
