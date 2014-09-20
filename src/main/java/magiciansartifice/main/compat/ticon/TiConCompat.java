package magiciansartifice.main.compat.ticon;

import magiciansartifice.main.blocks.BlockRegistry;
import magiciansartifice.main.compat.ticon.toolparts.ToolPartPickHead;
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
	private static ItemStack ingotcast = new ItemStack(TinkerSmeltery.metalPattern, 1, 0);
	
	public static Item starSteelHead;
	
    @Optional.Method(modid = "TConstruct")
    public static void registerStuff() {
    	TConstructRegistry.addToolMaterial(250, "starSteel", 5, 1200, 900, 4, 2.5F, 0, 0f, TextHelper.PURPLE, 0x7338A5);
    	TConstructClientRegistry.addMaterialRenderMapping(250, ModInfo.MODID, "starsteel", true);
    	
    	LiquidCasting basin = TConstructRegistry.getBasinCasting();
    	LiquidCasting table = TConstructRegistry.getTableCasting();
    	Smeltery.addMelting(new ItemStack(BlockRegistry.oresOres), 800, new FluidStack(LiquidRegistry.moltenStarSteel, ingot * 2));
    	Smeltery.addAlloyMixing(new FluidStack(LiquidRegistry.pureMoltenStarSteel, ingot * 2), new FluidStack(TinkerSmeltery.moltenSteelFluid, ingot * 2), new FluidStack(LiquidRegistry.moltenStarSteel, ingot));
    	basin.addCastingRecipe(new ItemStack(BlockRegistry.storage, 1, 3), new FluidStack(LiquidRegistry.pureMoltenStarSteel, block), null, true, 100);
    	table.addCastingRecipe(new ItemStack(ItemRegistry.ingotsMeta, 1, 0), new FluidStack(LiquidRegistry.pureMoltenStarSteel, ingot), ingotcast, false, 50);
    	
    	starSteelHead = new ToolPartPickHead();
    }
}