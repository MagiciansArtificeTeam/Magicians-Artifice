package magiciansartifice.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import magiciansartifice.blocks.machines.BlockMetalForge;
import magiciansartifice.blocks.machines.BlockMysticAnvil;
import magiciansartifice.blocks.machines.BlockWandCarver;
import magiciansartifice.items.itemblocks.ItemBlockOresMeta;
import net.minecraft.block.Block;

public class BlockRegistry {
    public static Block ores;
    public static Block mysticAnvil;
    public static Block metalForge;
    public static Block wandCarver;

    public static void registerBlocks() {
        ores = new BlockOresMeta().setBlockName("metaOres");
        GameRegistry.registerBlock(ores, ItemBlockOresMeta.class, "MetaOres");
        mysticAnvil = new BlockMysticAnvil();
        GameRegistry.registerBlock(mysticAnvil, mysticAnvil.getUnlocalizedName());
        metalForge = new BlockMetalForge();
        GameRegistry.registerBlock(metalForge, metalForge.getUnlocalizedName());
        wandCarver = new BlockWandCarver();
        GameRegistry.registerBlock(wandCarver, wandCarver.getUnlocalizedName());
    }
}
