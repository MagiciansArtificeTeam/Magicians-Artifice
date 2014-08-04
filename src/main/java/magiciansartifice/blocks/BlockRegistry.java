package magiciansartifice.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import magiciansartifice.blocks.machines.BlockMetalForge;
import magiciansartifice.blocks.machines.BlockMysticAnvil;
import magiciansartifice.blocks.machines.BlockWandCarver;
import magiciansartifice.blocks.metablocks.BlockOreStorageMeta;
import magiciansartifice.blocks.metablocks.BlockOresDustMeta;
import magiciansartifice.blocks.metablocks.BlockOresOreMeta;
import magiciansartifice.blocks.misc.BlockRitualCornerstone;
import magiciansartifice.blocks.wood.BlockLogs;
import magiciansartifice.blocks.wood.BlockPlanksMeta;
import magiciansartifice.items.itemblocks.*;
import net.minecraft.block.Block;

import java.util.ArrayList;

public class BlockRegistry {
    public static ArrayList<Block> blocks = new ArrayList<Block>();

    public static Block mysticAnvil;
    public static Block metalForge;
    public static Block wandCarver;
    public static Block ritualCornerStone;

    public static Block ores;
    public static Block oresOres;
    public static Block logs;
    public static Block planks;
    public static Block storage;

    public static void registerBlocks() {
        mysticAnvil = new BlockMysticAnvil();
        metalForge = new BlockMetalForge();
        wandCarver = new BlockWandCarver();
        ritualCornerStone = new BlockRitualCornerstone();

        oresOres = new BlockOresOreMeta().setBlockName("metaOresOre");
        GameRegistry.registerBlock(oresOres, ItemBlockOresOreMeta.class, oresOres.getUnlocalizedName());
        ores = new BlockOresDustMeta().setBlockName("metaOres");
        GameRegistry.registerBlock(ores, ItemBlockOresMeta.class, ores.getUnlocalizedName());
        logs = new BlockLogs().setBlockName("metaLogs");
        GameRegistry.registerBlock(logs, ItemBlockLogsMeta.class, logs.getUnlocalizedName());
        planks = new BlockPlanksMeta().setBlockName("metaPlanks");
        GameRegistry.registerBlock(planks, ItemBlockPlanks.class, planks.getUnlocalizedName());
        storage = new BlockOreStorageMeta().setBlockName("metaStorage");
        GameRegistry.registerBlock(storage, ItemBlockStorageMeta.class, storage.getUnlocalizedName());

        for (Block block : blocks) {
            GameRegistry.registerBlock(block, block.getUnlocalizedName().substring(5));
        }
    }
}
