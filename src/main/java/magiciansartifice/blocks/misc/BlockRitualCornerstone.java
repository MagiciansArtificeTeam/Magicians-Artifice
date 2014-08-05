package magiciansartifice.blocks.misc;

import magiciansartifice.MagiciansArtifice;
import magiciansartifice.blocks.BlockRegistry;
import magiciansartifice.libs.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.world.World;

import java.util.Random;

public class BlockRitualCornerstone extends Block {

    public BlockRitualCornerstone() {
        super(Material.iron);
        this.setBlockName("ritual.cornerStone");
        this.setBlockTextureName(ModInfo.MODID + ":misc/ritualCornerstone");
        this.setCreativeTab(MagiciansArtifice.tab);
        BlockRegistry.blocks.add(this);
    }


    public void updateTick(World world, int x, int y, int z,Random random) {
            world.addWeatherEffect(new EntityLightningBolt(world, x - 4, y, z - 4));
            world.addWeatherEffect(new EntityLightningBolt(world, x + 4, y, z + 4));
            world.addWeatherEffect(new EntityLightningBolt(world, x + 4, y, z - 4));
            world.addWeatherEffect(new EntityLightningBolt(world, x - 4, y, z + 4));
            world.addWeatherEffect(new EntityLightningBolt(world,x,y,z));
    }
}
