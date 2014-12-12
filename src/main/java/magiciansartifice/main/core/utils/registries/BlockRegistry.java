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
import net.minecraft.item.ItemBlock;

public class BlockRegistry {
    public static ArrayList<Block> blocks = new ArrayList<Block>();

    public static Block mysticAnvil;
    public static Block metalForge;
    public static Block wandCarver;
    public static Block ritualCornerStone;
    public static Block teleportReciever;
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
    public static Block ruinSlabs;
    public static Block ruinInfused;
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

    public static void registerBlocks() {
        oresOres = new BlockOresOreMeta().setBlockName("metaOresOre");
        GameRegistry.registerBlock(oresOres, ItemBlockRuinsInfused.class, oresOres.getUnlocalizedName());
        ores = new BlockOresDustMeta().setBlockName("metaOres");
        GameRegistry.registerBlock(ores, ItemBlockRuinsInfused.class, ores.getUnlocalizedName());
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
        runes = new BlockRunesMeta().setBlockName("metaRunes");
        GameRegistry.registerBlock(runes, ItemBlockRunes.class, runes.getUnlocalizedName());
        ruinStoneBrick = new BlockRuinBrickMeta().setBlockName("metaRuinBrick");
        GameRegistry.registerBlock(ruinStoneBrick, ItemBlockRuinBrick.class, ruinStoneBrick.getUnlocalizedName());
        ruinPillar = new BlockRuinPillarMeta().setBlockName("metaRuinPillar");
        GameRegistry.registerBlock(ruinPillar, ItemBlockRuinPillar.class, ruinPillar.getUnlocalizedName());
        ruinSlabs = new BlockRuinSlabMeta(false).setBlockName("ruinSlab");
        GameRegistry.registerBlock(ruinSlabs, ItemBlockRuinsSlab.class, ruinSlabs.getUnlocalizedName());
        ruinInfused = new BlockRuinInfusedBricks().setBlockName("ruinInfused");
        GameRegistry.registerBlock(ruinInfused, ItemBlockRuinsInfused.class, ruinInfused.getUnlocalizedName());

        ruinStairsSmooth = new BlockRuinStairs(ruinStoneBrick, 0, "smooth");
        ruinStairsMossy = new BlockRuinStairs(ruinStoneBrick, 2, "mossy");
        ruinStairsCracked = new BlockRuinStairs(ruinStoneBrick, 1, "cracked");
        ruinStairsChiseled = new BlockRuinStairs(ruinStoneBrick, 3, "chiseled");
        mysticAnvil = new BlockMysticAnvil();
        metalForge = new BlockMetalForge();
        wandCarver = new BlockWandCarver();
        ritualCornerStone = new BlockRitualCornerstone();
        teleportReciever = new BlockTeleportReciever();
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
