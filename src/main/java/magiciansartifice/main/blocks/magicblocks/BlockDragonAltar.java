package magiciansartifice.main.blocks.magicblocks;

import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.blocks.BlockRegistry;
import magiciansartifice.main.core.utils.EntityHelper;
import magiciansartifice.main.entities.pets.EntityPetDragon;
import magiciansartifice.main.tileentities.magic.TileEntityDragonAltar;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by poppypoppop on 5/10/2014.
 */
public class BlockDragonAltar extends BlockContainer {
    public BlockDragonAltar() {
        super(Material.rock);
        this.setCreativeTab(MagiciansArtifice.tab);
        this.setBlockBounds(0.25F,0.0F,0.25F,0.75F,1.0F,0.75F);
        this.setBlockName("dragonaltar");
        BlockRegistry.blocks.add(this);
    }

    @SuppressWarnings("unchecked")
    public float getEnchantPowerBonus(World world, int x, int y, int z) {
        if (world.getTileEntity(x,y,z) != null && world.getTileEntity(x,y,z) instanceof TileEntityDragonAltar) {
            List<Entity> entities = world.loadedEntityList;
            for (Entity entity : entities) {
                if (entity instanceof EntityPetDragon) {
                    Vec3 entityLoc = Vec3.createVectorHelper(entity.posX, entity.posY, entity.posZ);
                    Vec3 loc = Vec3.createVectorHelper(x, y, z);
                    if (entityLoc.distanceTo(loc) <= 5) {
                        return 30;
                    }
                }
            }
        }
        return 0;
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
