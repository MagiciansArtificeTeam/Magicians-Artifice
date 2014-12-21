package magiciansartifice.main.core.utils.registries;

import java.util.ArrayList;

import magiciansartifice.main.blocks.machines.*;
import magiciansartifice.main.blocks.magicblocks.*;
import magiciansartifice.main.blocks.metablocks.*;
import magiciansartifice.main.blocks.misc.*;
import magiciansartifice.main.blocks.plants.*;
import magiciansartifice.main.blocks.ruins.*;
import magiciansartifice.main.blocks.wood.*;
import magiciansartifice.main.items.itemblocks.*;
import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockRegistry {
    public static ArrayList<Block> blocks = new ArrayList<Block>();

    public static Block mysticAnvil;
    public static Block metalForge;
    public static Block wandCarver;
    public static Block ritualCornerStone;
    public static Block teleportReceiver;
    public static Block angelOrchid;
    public static Block essenceHole;
    public static Block tank;
    public static Block containmentPillar;
    public static Block containmentTop;
    public static Block containmentRing;
    public static Block containmentBarrier;
    public static Block containmentCornerstone;
    public static Block merlinscircle;
    public static Block dragonAltar;
    public static Block potatoBlock;
    public static Block magicianGlass;
    public static Block wandMaker;
    public static Block wandMakerLit;
    public static Block essencePipe;
    public static Block disguiseBlock;
    public static Block pedestal;
    public static Block ruinStairsSmooth;
    public static Block ruinStairsCracked;
    public static Block ruinStairsMossy;
    public static Block ruinStairsChiseled;
    public static Block ruinStairsSmoothEnd;
    public static Block ruinStairsCrackedEnd;
    public static Block ruinStairsMossyEnd;
    public static Block ruinStairsChiseledEnd;
    public static Block ruinStairsSmoothNether;
    public static Block ruinStairsCrackedNether;
    public static Block ruinStairsMossyNether;
    public static Block ruinStairsChiseledNether;
    public static Block runeGlass;
    public static Block ores;

    public static Block oresOres;
    public static Block logs;
    public static Block planks;
    public static Block storage;
    public static Block leaves;
    public static Block saplings;
    public static Block runes;
    public static Block ruinStoneBrick;
    public static Block ruinPillar;
    public static Block ruinSlabs;
    public static Block ruinsDoubleSlab;
    public static Block ruinSlabs2;
    public static Block ruinsDoubleSlab2;
    public static Block ruinInfused;

    public static void registerBlocks() {
        oresOres = new BlockOresOreMeta().setBlockName("metaOresOre");
        ores = new BlockOresDustMeta().setBlockName("metaOres");
        logs = new BlockLogs().setBlockName("metaLogs");
        planks = new BlockPlanksMeta().setBlockName("metaPlanks");
        storage = new BlockOreStorageMeta().setBlockName("metaStorage");
        leaves = new BlockLeavesMeta().setBlockName("metaLeaves");
        saplings = new BlockSaplingMeta().setBlockName("metaSapling");
        runes = new BlockRunesMeta().setBlockName("metaRunes");
        ruinStoneBrick = new BlockRuinBrick().setBlockName("metaRuinBrick");
        ruinSlabs = new BlockRuinSlab(false).setBlockName("ruinSlab");
        ruinsDoubleSlab = new BlockRuinSlab(true).setBlockName("ruinsDoubleSlab");
        ruinSlabs2 = new BlockRuinSlab2(false).setBlockName("ruinSlab2");
        ruinsDoubleSlab2 = new BlockRuinSlab2(true).setBlockName("ruinsDoubleSlab2");
        ruinInfused = new BlockRuinInfusedBricks().setBlockName("ruinInfused");

        GameRegistry.registerBlock(oresOres, ItemBlockOresOreMeta.class, oresOres.getUnlocalizedName());
        GameRegistry.registerBlock(ores, ItemBlockOresMeta.class, ores.getUnlocalizedName());
        GameRegistry.registerBlock(logs, ItemBlockLogsMeta.class, logs.getUnlocalizedName());
        GameRegistry.registerBlock(planks, ItemBlockPlanks.class, planks.getUnlocalizedName());
        GameRegistry.registerBlock(storage, ItemBlockStorageMeta.class, storage.getUnlocalizedName());
        GameRegistry.registerBlock(leaves, ItemBlockLeaves.class, leaves.getUnlocalizedName());
        GameRegistry.registerBlock(saplings, ItemBlockSaplingMeta.class, saplings.getUnlocalizedName());
        GameRegistry.registerBlock(runes, ItemBlockRunes.class, runes.getUnlocalizedName());
        GameRegistry.registerBlock(ruinStoneBrick, ItemBlockRuinBrick.class, ruinStoneBrick.getUnlocalizedName());
        GameRegistry.registerBlock(ruinSlabs, ItemBlockRuinsSlab.class, ruinSlabs.getUnlocalizedName(), ruinSlabs, ruinsDoubleSlab, false);
        GameRegistry.registerBlock(ruinsDoubleSlab, ItemBlockRuinsSlab.class, ruinsDoubleSlab.getUnlocalizedName(), ruinSlabs, ruinsDoubleSlab, true);
        GameRegistry.registerBlock(ruinSlabs2, ItemBlockRuinsSlab2.class, ruinSlabs2.getUnlocalizedName(), ruinSlabs2, ruinsDoubleSlab2, false);
        GameRegistry.registerBlock(ruinsDoubleSlab2, ItemBlockRuinsSlab2.class, ruinsDoubleSlab2.getUnlocalizedName(), ruinSlabs2, ruinsDoubleSlab2, true);
        GameRegistry.registerBlock(ruinInfused, ItemBlockRuinsInfused.class, ruinInfused.getUnlocalizedName());

        ruinStairsSmooth = new BlockRuinStairs(ruinStoneBrick, 0, "smooth");
        ruinStairsCracked = new BlockRuinStairs(ruinStoneBrick, 1, "cracked");
        ruinStairsMossy = new BlockRuinStairs(ruinStoneBrick, 2, "mossy");
        ruinStairsChiseled = new BlockRuinStairs(ruinStoneBrick, 3, "chiseled");
        ruinStairsSmoothNether = new BlockRuinStairs(ruinStoneBrick, 4, "smooth.nether");
        ruinStairsCrackedNether = new BlockRuinStairs(ruinStoneBrick, 5, "cracked.nether");
        ruinStairsMossyNether = new BlockRuinStairs(ruinStoneBrick, 6, "mossy.nether");
        ruinStairsChiseledNether = new BlockRuinStairs(ruinStoneBrick, 7, "chiseled.nether");
        ruinStairsSmoothEnd = new BlockRuinStairs(ruinStoneBrick, 8, "smooth.end");
        ruinStairsCrackedEnd = new BlockRuinStairs(ruinStoneBrick, 9, "cracked.end");
        ruinStairsMossyEnd = new BlockRuinStairs(ruinStoneBrick, 10, "mossy.end");
        ruinStairsChiseledEnd = new BlockRuinStairs(ruinStoneBrick, 11, "chiseled.end");
        ruinPillar = new BlockRuinPillar();
        mysticAnvil = new BlockMysticAnvil();
        metalForge = new BlockMetalForge();
        wandCarver = new BlockWandCarver();
        ritualCornerStone = new BlockRitualCornerstone();
        teleportReceiver = new BlockTeleportReciever();
        potatoBlock = new BlockPotato();
        angelOrchid = new BlockAngelOrchid();
        essenceHole = new BlockEssenceHole();
        tank = new BlockMagicTank();
        containmentCornerstone = new BlockRitualContainmentCornerstone();
        containmentPillar = new BlockRitualContainmentPillar();
        containmentTop = new BlockRitualContainmentTop();
        containmentRing = new BlockRitualContainmentRing();
        containmentBarrier = new BlockRitualContainmentBarrier();
        magicianGlass = new BlockMagiciansGlass();
        dragonAltar = new BlockDragonAltar();
        merlinscircle = new BlockMerlinCircle();
        wandMaker = new BlockWandMaker();
        wandMakerLit = new BlockWandMaker("Lit").setLightLevel(0.75F);
        essencePipe = new BlockEssencePipe();
        disguiseBlock = new BlockMagicDisguiseBlock();
        pedestal = new BlockPedestal();
        runeGlass = new BlockRuneGlass();

        for (Block block : blocks) {
            GameRegistry.registerBlock(block, block.getUnlocalizedName().substring(5));
        }
    }
}