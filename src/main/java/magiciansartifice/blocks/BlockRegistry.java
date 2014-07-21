package magiciansartifice.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import magiciansartifice.blocks.machines.BlockMetalForge;
import magiciansartifice.blocks.machines.BlockMysticAnvil;
import magiciansartifice.blocks.machines.BlockWandCarver;
import magiciansartifice.blocks.wood.BlockLogs;
import magiciansartifice.items.itemblocks.ItemBlockLogs1Meta;
import magiciansartifice.items.itemblocks.ItemBlockOresMeta;
import magiciansartifice.items.itemblocks.ItemBlockOresOreMeta;
import net.minecraft.block.Block;

public class BlockRegistry {
    public static Block ores;
    public static Block oresOres;
    public static Block mysticAnvil;
    public static Block metalForge;
    public static Block wandCarver;
    public static Block logs1;

    public static void registerBlocks() {
        ores = new BlockOresDustMeta().setBlockName("metaOres");
        GameRegistry.registerBlock(ores, ItemBlockOresMeta.class, "MetaOres");
        oresOres = new BlockOresOreMeta().setBlockName("metaOresOre");
        GameRegistry.registerBlock(oresOres, ItemBlockOresOreMeta.class, "MetaOresOre");
        mysticAnvil = new BlockMysticAnvil();
        GameRegistry.registerBlock(mysticAnvil, mysticAnvil.getUnlocalizedName());
        metalForge = new BlockMetalForge();
        GameRegistry.registerBlock(metalForge, metalForge.getUnlocalizedName());
        wandCarver = new BlockWandCarver();
        GameRegistry.registerBlock(wandCarver, wandCarver.getUnlocalizedName());
        logs1 = new BlockLogs().setBlockName("metaLogs1");
        GameRegistry.registerBlock(logs1, ItemBlockLogs1Meta.class, "MetaLogs1");
    }
}
