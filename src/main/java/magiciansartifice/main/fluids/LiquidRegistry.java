package magiciansartifice.main.fluids;

import magiciansartifice.main.compat.ticon.fluids.BlockFluidPureStarSteel;
import magiciansartifice.main.compat.ticon.fluids.BlockFluidStarSteel;
import magiciansartifice.main.fluids.fluidblocks.BlockFluidMagicWater;
import net.minecraft.block.Block;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Created by poppypoppop on 29/07/2014.
 */
public class LiquidRegistry {
    public static Fluid magicWater;
    public static Block magicWaterBlock;
    public static Fluid moltenStarSteel;
    public static Block moltenStarSteelBlock;
    public static Fluid pureMoltenStarSteel;
    public static Block pureMoltenStarSteelBlock;

    public static void registerFluids() {
        magicWater = new Fluid("magicWater");
        FluidRegistry.registerFluid(magicWater);
        magicWaterBlock = new BlockFluidMagicWater(magicWater);
        GameRegistry.registerBlock(magicWaterBlock, magicWaterBlock.getUnlocalizedName());
        magicWater.setUnlocalizedName(magicWaterBlock.getUnlocalizedName());
        
        moltenStarSteel = new Fluid("moltenStarSteel");
        FluidRegistry.registerFluid(moltenStarSteel);
        moltenStarSteelBlock = new BlockFluidStarSteel(moltenStarSteel);
        GameRegistry.registerBlock(moltenStarSteelBlock, moltenStarSteelBlock.getUnlocalizedName());
        moltenStarSteel.setUnlocalizedName(moltenStarSteelBlock.getUnlocalizedName());
        
        pureMoltenStarSteel = new Fluid("pureMoltenStarSteel");
        FluidRegistry.registerFluid(pureMoltenStarSteel);
        pureMoltenStarSteelBlock = new BlockFluidPureStarSteel(pureMoltenStarSteel);
        GameRegistry.registerBlock(pureMoltenStarSteelBlock, pureMoltenStarSteelBlock.getUnlocalizedName());
        pureMoltenStarSteel.setUnlocalizedName(pureMoltenStarSteelBlock.getUnlocalizedName());
    }
}
