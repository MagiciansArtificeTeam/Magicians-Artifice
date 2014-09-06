package magiciansartifice.main.blocks.magicblocks;

import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.blocks.BlockRegistry;
import magiciansartifice.main.core.libs.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class BlockRitualContainmentCornerstone extends Block{

	public BlockRitualContainmentCornerstone() {
		super(Material.rock);
		this.setHardness(50.0F);
		this.setResistance(2000.0F);
		this.setCreativeTab(MagiciansArtifice.tab);
		this.setBlockName("ritualContainmentCornerstone");
		this.setBlockTextureName(ModInfo.MODID + ":magicalblocks/ritualContainmentTopTop");
		BlockRegistry.blocks.add(this);
	}

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float hitX, float hitY, float hitZ) {
        MagiciansArtifice.logger.info("Test!");
        for (int y2 = y-7; y2 < y;y2++) {
            MagiciansArtifice.logger.info(y2);
            for (int i = x - 8; i < x + 8; i++) {
                MagiciansArtifice.logger.info(i);
                if (world.getBlock(i, y2, z - 8) == null) {
                    world.setBlock(i, y2, z - 8, BlockRegistry.containmentBarrier);
                }
                if (world.getBlock(i, y2, z + 8) == null) {
                    world.setBlock(i, y2, z + 8, BlockRegistry.containmentBarrier);
                }
            }
            MagiciansArtifice.logger.info("Test1!");
            for (int ii = z - 8; ii < z + 8; ii++) {
                    if (world.getBlock(x - 8, y2, ii) == null) {
                        world.setBlock(x - 8, y2, ii, BlockRegistry.containmentBarrier);
                    }
                    if (world.getBlock(x + 8, y2, ii) == null) {
                        world.setBlock(x + 8, y2, ii, BlockRegistry.containmentBarrier);
                    }
            }
        }
        System.err.println("Test2!");

        return true;
    }

    }
