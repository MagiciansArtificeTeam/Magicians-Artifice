package magiciansartifice.main.blocks.plants;

import java.util.Random;

import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.blocks.BlockRegistry;
import magiciansartifice.main.core.client.particles.SparkleParticle;
import magiciansartifice.main.core.libs.ModInfo;
import net.minecraft.block.BlockBush;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Created by poppypoppop on 18/08/2014.
 */
public class BlockAngelOrchid extends BlockBush {
    private IIcon icon;
    public BlockAngelOrchid() {
        super();
        this.setBlockName("angel.orchid");
        this.setStepSound(soundTypeGrass);
        this.setCreativeTab(MagiciansArtifice.tab);
        this.setBlockBounds(0.3F, 0.0F, 0.3F, 0.8F, 1, 0.8F);
        BlockRegistry.blocks.add(this);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
		super.randomDisplayTick(world, x, y, z, rand);
		float x1 = (float)x + 0.5F;
		float y1 = (float)y + rand.nextFloat();
		float z1 = (float)z + 0.5F;
		float f1 = rand.nextFloat() * 0.6F - 0.3F;
		Minecraft.getMinecraft().effectRenderer.addEffect(new SparkleParticle(world, (double)(x1 - f1), (double)(y1), (double)(z1 + f1), -1F, 0.5F));
	}

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister ir) {
        icon = ir.registerIcon(ModInfo.MODID + ":plants/angelOrchid");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return icon;
    }
}
