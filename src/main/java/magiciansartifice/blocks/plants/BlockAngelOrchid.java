package magiciansartifice.blocks.plants;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import magiciansartifice.MagiciansArtifice;
import magiciansartifice.blocks.BlockRegistry;
import magiciansartifice.core.libs.ModInfo;
import net.minecraft.block.BlockBush;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created by poppypoppop on 18/08/2014.
 */
public class BlockAngelOrchid extends BlockBush {
    private IIcon icon;
    public BlockAngelOrchid() {
        super();
        this.setBlockBounds(0.3F, 0.0F, 0.3F, 0.8F, 1, 0.8F);
        this.setBlockName("angel.orchid");
        this.setCreativeTab(MagiciansArtifice.tab);
        BlockRegistry.blocks.add(this);
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

    @Override
    public void randomDisplayTick(World world, int x, int y, int z, Random random) {
        int meta = world.getBlockMetadata(x, y, z);
        float[] colour = EntitySheep.fleeceColorTable[meta];
        MagiciansArtifice.proxy.flowerParticle(world, x + 0.3 + random.nextFloat() * 0.5, y + 0.5 + random.nextFloat() * 0.5, z + 0.3 + random.nextFloat() * 0.5, colour[0], colour[1], colour[2], random.nextFloat(), 5);
    }
}
