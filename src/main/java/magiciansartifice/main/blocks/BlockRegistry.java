package magiciansartifice.main.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import magiciansartifice.main.blocks.machines.BlockMetalForge;
import magiciansartifice.main.blocks.machines.BlockMysticAnvil;
import magiciansartifice.main.blocks.machines.BlockWandCarver;
import magiciansartifice.main.blocks.magicblocks.BlockEssenceHole;
import magiciansartifice.main.blocks.magicblocks.BlockTeleportReciever;
import magiciansartifice.main.blocks.metablocks.BlockOreStorageMeta;
import magiciansartifice.main.blocks.metablocks.BlockOresDustMeta;
import magiciansartifice.main.blocks.metablocks.BlockOresOreMeta;
import magiciansartifice.main.blocks.magicblocks.BlockRitualCornerstone;
import magiciansartifice.main.blocks.misc.BlockPotato;
import magiciansartifice.main.blocks.plants.BlockAngelOrchid;
import magiciansartifice.main.blocks.wood.BlockLeavesMeta;
import magiciansartifice.main.blocks.wood.BlockLogs;
import magiciansartifice.main.blocks.wood.BlockPlanksMeta;
import magiciansartifice.main.blocks.plants.BlockSaplingMeta;
import magiciansartifice.main.items.itemblocks.*;
import net.minecraft.block.Block;

import java.util.ArrayList;

public class BlockRegistry {
    public static ArrayList<Block> blocks = new ArrayList<Block>();

    public static Block mysticAnvil;
    public static Block metalForge;
    public static Block wandCarver;
    public static Block ritualCornerStone;
    public static Block teleportReciever;
    public static Block angelOrchid;
    public static Block essenceHole;

    public static Block ores;
    public static Block oresOres;
    public static Block logs;
    public static Block planks;
    public static Block storage;
    public static Block leaves;
    public static Block saplings;
    public static Block potatoBlock;

    public static void registerBlocks() {
        mysticAnvil = new BlockMysticAnvil();
        metalForge = new BlockMetalForge();
        wandCarver = new BlockWandCarver();
        ritualCornerStone = new BlockRitualCornerstone();
        teleportReciever = new BlockTeleportReciever();
        potatoBlock = new BlockPotato();
        angelOrchid = new BlockAngelOrchid();
        essenceHole = new BlockEssenceHole();

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
        leaves = new BlockLeavesMeta().setBlockName("metaLeaves");
        GameRegistry.registerBlock(leaves, ItemBlockLeaves.class, leaves.getUnlocalizedName());
        saplings = new BlockSaplingMeta().setBlockName("metaSapling");
        GameRegistry.registerBlock(saplings, ItemBlockSaplingMeta.class, saplings.getUnlocalizedName());

        for (Block block : blocks) {
            GameRegistry.registerBlock(block, block.getUnlocalizedName().substring(5));
            System.out.println(block.getUnlocalizedName());
        }
    }
}
