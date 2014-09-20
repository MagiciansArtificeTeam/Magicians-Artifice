package magiciansartifice.main.compat.ticon;

import magiciansartifice.main.blocks.BlockRegistry;
import magiciansartifice.main.compat.ticon.toolparts.StarSteelPart;
import magiciansartifice.main.core.libs.ModInfo;
import magiciansartifice.main.core.utils.TextHelper;
import magiciansartifice.main.fluids.LiquidRegistry;
import magiciansartifice.main.items.ItemRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import tconstruct.library.TConstructRegistry;
import tconstruct.library.client.TConstructClientRegistry;
import tconstruct.library.crafting.LiquidCasting;
import tconstruct.library.crafting.Smeltery;
import tconstruct.smeltery.TinkerSmeltery;
import cpw.mods.fml.common.Optional;

/**
 * Created by Mitchellbrine on 2014.
 */
public class TiConCompat {
	private static int ingot = 144;
	private static int block = ingot * 9;
	private static ItemStack[] castArray = { new ItemStack(TinkerSmeltery.metalPattern, 1, 0), new ItemStack(TinkerSmeltery.metalPattern, 1, 1), new ItemStack(TinkerSmeltery.metalPattern, 1, 2)
	, new ItemStack(TinkerSmeltery.metalPattern, 1, 3), new ItemStack(TinkerSmeltery.metalPattern, 1, 4), new ItemStack(TinkerSmeltery.metalPattern, 1, 5), new ItemStack(TinkerSmeltery.metalPattern, 1, 6)
	, new ItemStack(TinkerSmeltery.metalPattern, 1, 7), new ItemStack(TinkerSmeltery.metalPattern, 1, 8), new ItemStack(TinkerSmeltery.metalPattern, 1, 9), new ItemStack(TinkerSmeltery.metalPattern, 1, 10)
	, new ItemStack(TinkerSmeltery.metalPattern, 1, 11), new ItemStack(TinkerSmeltery.metalPattern, 1, 12), new ItemStack(TinkerSmeltery.metalPattern, 1, 13), new ItemStack(TinkerSmeltery.metalPattern, 1, 14)
	, new ItemStack(TinkerSmeltery.metalPattern, 1, 15), new ItemStack(TinkerSmeltery.metalPattern, 1, 16), new ItemStack(TinkerSmeltery.metalPattern, 1, 17), new ItemStack(TinkerSmeltery.metalPattern, 1, 18)
	, new ItemStack(TinkerSmeltery.metalPattern, 1, 19), new ItemStack(TinkerSmeltery.metalPattern, 1, 20), new ItemStack(TinkerSmeltery.metalPattern, 1, 2), new ItemStack(TinkerSmeltery.metalPattern, 1, 21)
	, new ItemStack(TinkerSmeltery.metalPattern, 1, 22), new ItemStack(TinkerSmeltery.metalPattern, 1, 23)};
	
	public static final int starsteel_id = 200;
    public static StarSteelPart arrowhead;
    public static StarSteelPart axeHead;
    public static StarSteelPart battleSignHead;
    public static StarSteelPart binding;
    public static StarSteelPart broadAxeHead;
    public static StarSteelPart chiselHead;
    public static StarSteelPart chunk;
    public static StarSteelPart crossbar;
    public static StarSteelPart excavatorHead;
    public static StarSteelPart panHead;
    public static StarSteelPart fullGuard;
    public static StarSteelPart hammerHead;
    public static StarSteelPart handGuard;
    public static StarSteelPart knifeBlade;
    public static StarSteelPart wideGuard;
    public static StarSteelPart largeSwordBlade;
    public static StarSteelPart largePlate;
    public static StarSteelPart pickaxeHead;
    public static StarSteelPart scytheHead;
    public static StarSteelPart shovelHead;
    public static StarSteelPart swordBlade;
    public static StarSteelPart toolRod;
    public static StarSteelPart toughBinding;
    public static StarSteelPart toughRod;
	
	public static Item starSteelPart;
	
    @Optional.Method(modid = "TConstruct")
    public static void registerStuff() {
    	TConstructRegistry.addToolMaterial(starsteel_id, "starSteel", 5, 1200, 900, 4, 2.5F, 0, 0f, TextHelper.PURPLE, 0x7338A5);
    	TConstructClientRegistry.addMaterialRenderMapping(starsteel_id, ModInfo.MODID, "starsteel", true);
    	
    	addSmelteryRecipes();
    	addCastingBasinRecipes(TConstructRegistry.getBasinCasting());
    	addCastingTableRecipes(TConstructRegistry.getTableCasting());
    	
    	starSteelPart = new StarSteelPart();
    	addParts();
    }
    
    public static void addSmelteryRecipes() {
    	Smeltery.addMelting(new ItemStack(BlockRegistry.oresOres), 800, new FluidStack(LiquidRegistry.moltenStarSteel, ingot * 2));
    	Smeltery.addMelting(new ItemStack(BlockRegistry.storage, 1, 3), 800, new FluidStack(LiquidRegistry.pureMoltenStarSteel, block));
    	Smeltery.addMelting(new ItemStack(BlockRegistry.storage, 1, 4), 800, new FluidStack(TinkerSmeltery.moltenSteelFluid, block));
    	Smeltery.addMelting(new ItemStack(ItemRegistry.ingotsMeta, 1, 0), BlockRegistry.storage, 3, 400, new FluidStack(LiquidRegistry.pureMoltenStarSteel, ingot));
    	Smeltery.addMelting(new ItemStack(ItemRegistry.ingotsMeta, 1, 1), BlockRegistry.storage, 4, 400, new FluidStack(TinkerSmeltery.moltenSteelFluid, ingot));
    	Smeltery.addAlloyMixing(new FluidStack(LiquidRegistry.pureMoltenStarSteel, ingot * 2), new FluidStack(TinkerSmeltery.moltenSteelFluid, ingot * 2), new FluidStack(LiquidRegistry.moltenStarSteel, ingot));
    }
    
    public static void addParts() {
    	arrowhead = (StarSteelPart) new StarSteelPart().setUnlocalizedName("starsteel.arrow.head");
        axeHead = (StarSteelPart) new StarSteelPart().setUnlocalizedName("starsteel.axe.head");
        battleSignHead = (StarSteelPart) new StarSteelPart().setUnlocalizedName("starsteel.battlesign.head");
        binding = (StarSteelPart) new StarSteelPart().setUnlocalizedName("starsteel.binding");
        chiselHead = (StarSteelPart) new StarSteelPart().setUnlocalizedName("starsteel.chisel.head");
        chunk = (StarSteelPart) new StarSteelPart().setUnlocalizedName("starsteel.chunk");
        crossbar = (StarSteelPart) new StarSteelPart().setUnlocalizedName("starsteel.crossbar");
        excavatorHead = (StarSteelPart) new StarSteelPart().setUnlocalizedName("starsteel.excavator.head");
        panHead = (StarSteelPart) new StarSteelPart().setUnlocalizedName("starsteel.frypan.head");
        fullGuard = (StarSteelPart) new StarSteelPart().setUnlocalizedName("starsteel.full.guard");
        hammerHead = (StarSteelPart) new StarSteelPart().setUnlocalizedName("starsteel.hammer.head");
        knifeBlade = (StarSteelPart) new StarSteelPart().setUnlocalizedName("starsteel.knife.blade");
        wideGuard = (StarSteelPart) new StarSteelPart().setUnlocalizedName("starsteel.large.guard");
        largeSwordBlade = (StarSteelPart) new StarSteelPart().setUnlocalizedName("starsteel.large.sword.blade");
        largePlate = (StarSteelPart) new StarSteelPart().setUnlocalizedName("starsteel.large.plate");
        broadAxeHead = (StarSteelPart) new StarSteelPart().setUnlocalizedName("starsteel.lumberaxe.head");
        handGuard = (StarSteelPart) new StarSteelPart().setUnlocalizedName("starsteel.medium.guard");
        pickaxeHead = (StarSteelPart) new StarSteelPart().setUnlocalizedName("starsteel.pickaxe.head");
        scytheHead = (StarSteelPart) new StarSteelPart().setUnlocalizedName("starsteel.scythe.head");
        shovelHead = (StarSteelPart) new StarSteelPart().setUnlocalizedName("starsteel.shovel.head");
        swordBlade = (StarSteelPart) new StarSteelPart().setUnlocalizedName("starsteel.sword.blade");
        toolRod = (StarSteelPart) new StarSteelPart().setUnlocalizedName("starsteel.tool.rod");
        toughBinding = (StarSteelPart) new StarSteelPart().setUnlocalizedName("starsteel.tough.binding");
        toughRod = (StarSteelPart) new StarSteelPart().setUnlocalizedName("starsteel.tough.rod");
    }
    
    public static void addCastingBasinRecipes(LiquidCasting basin) {
    	basin.addCastingRecipe(new ItemStack(BlockRegistry.storage, 1, 3), new FluidStack(LiquidRegistry.pureMoltenStarSteel, block), null, true, 100);
    }
    
    public static void addCastingTableRecipes(LiquidCasting table) {
    	table.addCastingRecipe(new ItemStack(ItemRegistry.ingotsMeta, 1, 0), new FluidStack(LiquidRegistry.pureMoltenStarSteel, ingot), castArray[0], false, 50);
    	table.addCastingRecipe(new ItemStack(toolRod), new FluidStack(LiquidRegistry.pureMoltenStarSteel, ingot / 2), castArray[1], false, 25);
    	table.addCastingRecipe(new ItemStack(pickaxeHead), new FluidStack(LiquidRegistry.pureMoltenStarSteel, ingot), castArray[2], false, 50);
    	table.addCastingRecipe(new ItemStack(shovelHead), new FluidStack(LiquidRegistry.pureMoltenStarSteel, ingot), castArray[3], false, 50);
    	table.addCastingRecipe(new ItemStack(axeHead), new FluidStack(LiquidRegistry.pureMoltenStarSteel, ingot), castArray[4], false, 50);
    	table.addCastingRecipe(new ItemStack(swordBlade), new FluidStack(LiquidRegistry.pureMoltenStarSteel, ingot), castArray[5], false, 50);
    	table.addCastingRecipe(new ItemStack(wideGuard), new FluidStack(LiquidRegistry.pureMoltenStarSteel, ingot / 2), castArray[6], false, 25);
    	table.addCastingRecipe(new ItemStack(handGuard), new FluidStack(LiquidRegistry.pureMoltenStarSteel, ingot / 2), castArray[7], false, 25);
    	table.addCastingRecipe(new ItemStack(crossbar), new FluidStack(LiquidRegistry.pureMoltenStarSteel, ingot / 2), castArray[8], false, 25);
    	table.addCastingRecipe(new ItemStack(binding), new FluidStack(LiquidRegistry.pureMoltenStarSteel, ingot / 2), castArray[9], false, 25);
    	table.addCastingRecipe(new ItemStack(panHead), new FluidStack(LiquidRegistry.pureMoltenStarSteel, ingot), castArray[10], false, 50);
    	table.addCastingRecipe(new ItemStack(battleSignHead), new FluidStack(LiquidRegistry.pureMoltenStarSteel, ingot), castArray[11], false, 50);
    	table.addCastingRecipe(new ItemStack(knifeBlade), new FluidStack(LiquidRegistry.pureMoltenStarSteel, ingot), castArray[12], false, 50);
    	table.addCastingRecipe(new ItemStack(chiselHead), new FluidStack(LiquidRegistry.pureMoltenStarSteel, ingot), castArray[13], false, 50);
    	table.addCastingRecipe(new ItemStack(toughRod), new FluidStack(LiquidRegistry.pureMoltenStarSteel, ingot), castArray[14], false, 50);
    	table.addCastingRecipe(new ItemStack(toughBinding), new FluidStack(LiquidRegistry.pureMoltenStarSteel, ingot), castArray[15], false, 50);
    	table.addCastingRecipe(new ItemStack(largePlate), new FluidStack(LiquidRegistry.pureMoltenStarSteel, ingot), castArray[16], false, 50);
    	table.addCastingRecipe(new ItemStack(broadAxeHead), new FluidStack(LiquidRegistry.pureMoltenStarSteel, ingot), castArray[17], false, 50);
    	table.addCastingRecipe(new ItemStack(scytheHead), new FluidStack(LiquidRegistry.pureMoltenStarSteel, ingot), castArray[18], false, 50);
    	table.addCastingRecipe(new ItemStack(excavatorHead), new FluidStack(LiquidRegistry.pureMoltenStarSteel, ingot), castArray[19], false, 50);
    	table.addCastingRecipe(new ItemStack(largeSwordBlade), new FluidStack(LiquidRegistry.pureMoltenStarSteel, ingot), castArray[20], false, 50);
    	table.addCastingRecipe(new ItemStack(hammerHead), new FluidStack(LiquidRegistry.pureMoltenStarSteel, ingot), castArray[21], false, 50);
    	table.addCastingRecipe(new ItemStack(fullGuard), new FluidStack(LiquidRegistry.pureMoltenStarSteel, ingot), castArray[22], false, 50);
    	table.addCastingRecipe(new ItemStack(arrowhead), new FluidStack(LiquidRegistry.pureMoltenStarSteel, ingot), castArray[23], false, 50);
    }
}