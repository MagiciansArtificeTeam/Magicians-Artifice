package magiciansartifice.main.blocks.magicblocks;

import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.blocks.BlockRegistry;
import magiciansartifice.main.core.utils.EntityHelper;
import magiciansartifice.main.tileentities.magic.TileEntityDragonAltar;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by poppypoppop on 5/10/2014.
 */
public class BlockDragonAltar extends BlockContainer {
    public BlockDragonAltar() {
        super(Material.rock);
        this.setCreativeTab(MagiciansArtifice.tab);
        this.setBlockName("dragonaltar");
        BlockRegistry.blocks.add(this);
    }

    public float getEnchantPowerBonus(World world, int x, int y, int z) {
        if (EntityHelper.getClosestEntity(world, x, y, z, 15, world.getClosestPlayer(x, y, z, 15)) instanceof EntityDragon) return 15;
        else return 0;
    }

    public TileEntity createNewTileEntity(World world, int meta) { return new TileEntityDragonAltar(); }

    public int getRenderType()
    {
        return -1;
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }
}
