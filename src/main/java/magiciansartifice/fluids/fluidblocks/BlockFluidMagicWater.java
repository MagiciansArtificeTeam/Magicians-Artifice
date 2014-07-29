package magiciansartifice.fluids.fluidblocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import magiciansartifice.fluids.LiquidRegistry;
import magiciansartifice.libs.ModInfo;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

/**
 * Created by poppypoppop on 29/07/2014.
 */
public class BlockFluidMagicWater extends BlockFluidClassic {

    @SideOnly(Side.CLIENT)
    protected IIcon stillIcon;
    @SideOnly(Side.CLIENT)
    protected IIcon flowingIcon;

    public BlockFluidMagicWater(Fluid fluid) {
        super(fluid, Material.water);
        this.setTemperature(300);
        this.setBlockName(ModInfo.MODID + ".magicWaterBlock");
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int side, int meta) {
        return (side == 0 || side == 1)? stillIcon : flowingIcon;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister register) {
        stillIcon = register.registerIcon(ModInfo.MODID + ":fluids/stillMagicWater");
        flowingIcon = register.registerIcon(ModInfo.MODID + ":fluids/flowingMagicWater");
        LiquidRegistry.magicWater.setIcons(stillIcon, flowingIcon);
        this.blockIcon = stillIcon;
    }

    @Override
    public boolean canDisplace(IBlockAccess world, int x, int y, int z) {
        if (world.getBlock(x,  y,  z).getMaterial().isLiquid()) return false;
        return super.canDisplace(world, x, y, z);
    }

    @Override
    public boolean displaceIfPossible(World world, int x, int y, int z) {
        if (world.getBlock(x,  y,  z).getMaterial().isLiquid()) return false;
        return super.displaceIfPossible(world, x, y, z);
    }
}
