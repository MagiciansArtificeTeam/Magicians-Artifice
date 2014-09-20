package magiciansartifice.main.compat.ticon;

import magiciansartifice.main.blocks.BlockRegistry;
import magiciansartifice.main.fluids.LiquidRegistry;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import tconstruct.library.crafting.Smeltery;
import tconstruct.smeltery.TinkerSmeltery;
import cpw.mods.fml.common.Optional;

/**
 * Created by Mitchellbrine on 2014.
 */
public class TiConCompat {
    @Optional.Method(modid = "TConstruct")
    public static void registerStuff() {
    	Smeltery.addMelting(new ItemStack(BlockRegistry.oresOres), 800, new FluidStack(LiquidRegistry.moltenStarSteel, 2000));
    	Smeltery.addAlloyMixing(new FluidStack(LiquidRegistry.pureMoltenStarSteel, 2000), new FluidStack(TinkerSmeltery.moltenSteelFluid, 1000), new FluidStack(LiquidRegistry.moltenStarSteel, 1000));
    }
}