package magiciansartifice.fluids;

import cpw.mods.fml.common.registry.GameRegistry;
import magiciansartifice.fluids.fluidblocks.BlockFluidMagicWater;
import net.minecraft.block.Block;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

/**
 * Created by poppypoppop on 29/07/2014.
 */
public class LiquidRegistry {
    public static Fluid magicWater;
    public static Block magicWaterBlock;

    public static void registerFluids() {
        magicWater = new Fluid("magicWater");
        FluidRegistry.registerFluid(magicWater);
        magicWaterBlock = new BlockFluidMagicWater(magicWater);
        GameRegistry.registerBlock(magicWaterBlock, magicWaterBlock.getUnlocalizedName());
        magicWater.setUnlocalizedName(magicWaterBlock.getUnlocalizedName());
    }
}
