package magiciansartifice.main.core.world.village;

import java.util.List;
import java.util.Random;

import magiciansartifice.main.blocks.BlockRegistry;
import magiciansartifice.main.entities.MAEntityRegistry;
import magiciansartifice.main.entities.VillageHandlerMagician;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureVillagePieces;

public class ComponentMageTower extends StructureVillagePieces.Church 
{

    public ComponentMageTower() {

    }

    public void setBlock(World world, int x, int y, int z, Block block, int metadata)
    {
        Block b1 = world.getBlock(x, y, z);

        if(b1.isAir(world, x, y, z) || b1.isLeaves(world, x, y, z))
        {
            world.setBlock(x, y, z, block, metadata, 2);
        }
    }

    public ComponentMageTower(StructureVillagePieces.Start p_i2102_1_, int p_i2102_2_, Random p_i2102_3_, StructureBoundingBox p_i2102_4_, int p_i2102_5_)
    {
        super(p_i2102_1_, p_i2102_2_, p_i2102_3_, p_i2102_4_, p_i2102_5_);
        this.coordBaseMode = p_i2102_5_;
        this.boundingBox = p_i2102_4_;
    }

    public static ComponentMageTower buildComponent(StructureVillagePieces.Start p_74919_0_, List p_74919_1_, Random p_74919_2_, int p_74919_3_, int p_74919_4_, int p_74919_5_, int p_74919_6_, int p_74919_7_)
    {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_74919_3_, p_74919_4_, p_74919_5_, 0, 0, 0, 5, 12, 9, p_74919_6_);
        return canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(p_74919_1_, structureboundingbox) == null ? new ComponentMageTower(p_74919_0_, p_74919_7_, p_74919_2_, structureboundingbox, p_74919_6_) : null;
    }

    public boolean addComponentParts(World world, Random rand, StructureBoundingBox bb)
    {
        if (this.field_143015_k < 0)
        {
            this.field_143015_k = this.getAverageGroundLevel(world, bb);

            if (this.field_143015_k < 0)
            {
                return true;
            }

            this.boundingBox.offset(0, this.field_143015_k - this.boundingBox.maxY + 12 - 1, 0);
        }
        
        this.fillWithBlocks(world, bb, 1, 0, 1, 3, 9, 3, Blocks.air, Blocks.air, false);
        this.fillWithBlocks(world, bb, 1, 0, 1, 3, 9, 3, BlockRegistry.planks, BlockRegistry.planks, false);
        
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 0, 0, 0, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.log, 0, 1, 0, 0, bb);
        this.placeBlockAtCurrentPosition(world, BlockRegistry.planks, 0, 2, 0, 0, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.log, 0, 3, 0, 0, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 4, 0, 0, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.log, 0, 0, 0, 1, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 0, 0, 2, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.log, 0, 0, 0, 3, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 0, 0, 4, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.log, 0, 1, 0, 4, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 2, 0, 4, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.log, 0, 3, 0, 4, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 4, 0, 4, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.log, 0, 4, 0, 3, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 4, 0, 2, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.log, 0, 4, 0, 1, bb);
        
        this.fillWithBlocks(world, bb, 1, 1, 0, 3, 3, 0, Blocks.cobblestone, Blocks.cobblestone, false);
        this.fillWithBlocks(world, bb, 0, 1, 1, 0, 3, 3, Blocks.cobblestone, Blocks.cobblestone, false);
        this.fillWithBlocks(world, bb, 1, 1, 4, 3, 3, 4, Blocks.cobblestone, Blocks.cobblestone, false);
        this.fillWithBlocks(world, bb, 4, 1, 1, 4, 3, 3, Blocks.cobblestone, Blocks.cobblestone, false);
        
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 0, 4, 0, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.log, 0, 1, 4, 0, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 2, 4, 0, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.log, 0, 3, 4, 0, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 4, 4, 0, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.log, 0, 0, 4, 1, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 0, 4, 2, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.log, 0, 0, 4, 3, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 0, 4, 4, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.log, 0, 1, 4, 4, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 2, 4, 4, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.log, 0, 3, 4, 4, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 4, 4, 4, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.log, 0, 4, 4, 3, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 4, 4, 2, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.log, 0, 4, 4, 1, bb);
        
        this.fillWithBlocks(world, bb, 1, 5, 0, 3, 7, 0, Blocks.cobblestone, Blocks.cobblestone, false);
        this.fillWithBlocks(world, bb, 0, 5, 1, 0, 7, 3, Blocks.cobblestone, Blocks.cobblestone, false);
        this.fillWithBlocks(world, bb, 1, 5, 4, 3, 7, 4, Blocks.cobblestone, Blocks.cobblestone, false);
        this.fillWithBlocks(world, bb, 4, 5, 1, 4, 7, 3, Blocks.cobblestone, Blocks.cobblestone, false);
        
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 1, 8, 0, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.cobblestone, 0, 2, 8, 0, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 3, 8, 0, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 0, 8, 1, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.cobblestone, 0, 0, 8, 2, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 0, 8, 3, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 1, 8, 4, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.cobblestone, 0, 2, 8, 4, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 3, 8, 4, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 4, 8, 1, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.cobblestone, 0, 4, 8, 2, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 4, 8, 3, bb);
        
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 0, 9, 0, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.log, 0, 1, 9, 0, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 2, 9, 0, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.log, 0, 3, 9, 0, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 4, 9, 0, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.log, 0, 0, 9, 1, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 0, 9, 2, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.log, 0, 0, 9, 3, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 0, 9, 4, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.log, 0, 1, 9, 4, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 2, 9, 4, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.log, 0, 3, 9, 4, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 4, 9, 4, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.log, 0, 4, 9, 3, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 4, 9, 2, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.log, 0, 4, 9, 1, bb);
        
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 1, 10, 0, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.log, 0, 2, 10, 0, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 3, 10, 0, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 0, 10, 1, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.log, 0, 0, 10, 2, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 0, 10, 3, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 1, 10, 4, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.log, 0, 2, 10, 4, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 3, 10, 4, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 4, 10, 1, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.log, 0, 4, 10, 2, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 4, 10, 3, bb);
        
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 2, 11, 0, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 0, 11, 2, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 2, 11, 4, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 4, 11, 2, bb);
        
        /**
        this.fillWithBlocks(world, bb, 1, 1, 1, 3, 3, 7, Blocks.air, Blocks.air, false);
        this.fillWithBlocks(world, bb, 1, 5, 1, 3, 9, 3, Blocks.air, Blocks.air, false);
        this.fillWithBlocks(world, bb, 1, 0, 0, 3, 0, 8, BlockRegistry.planks, BlockRegistry.planks, false);
        this.fillWithBlocks(world, bb, 1, 1, 0, 3, 10, 0, BlockRegistry.logs, BlockRegistry.logs, false);
        this.fillWithBlocks(world, bb, 0, 1, 1, 0, 10, 3, BlockRegistry.logs, BlockRegistry.logs, false);
        this.fillWithBlocks(world, bb, 4, 1, 1, 4, 10, 3, BlockRegistry.logs, BlockRegistry.logs, false);
        this.fillWithBlocks(world, bb, 0, 0, 4, 0, 4, 7, BlockRegistry.planks, BlockRegistry.planks, false);
        this.fillWithBlocks(world, bb, 4, 0, 4, 4, 4, 7, BlockRegistry.planks, BlockRegistry.planks, false);
        this.fillWithBlocks(world, bb, 1, 1, 8, 3, 4, 8, BlockRegistry.planks, BlockRegistry.planks, false);
        this.fillWithBlocks(world, bb, 1, 5, 4, 3, 10, 4, BlockRegistry.planks, BlockRegistry.planks, false);
        this.fillWithBlocks(world, bb, 1, 5, 5, 3, 5, 7, BlockRegistry.planks, BlockRegistry.planks, false);
        this.fillWithBlocks(world, bb, 0, 9, 0, 4, 9, 4, BlockRegistry.planks, BlockRegistry.planks, false);
        this.fillWithBlocks(world, bb, 0, 4, 0, 4, 4, 4, BlockRegistry.planks, BlockRegistry.planks, false);
        this.placeBlockAtCurrentPosition(world, BlockRegistry.planks, 0, 0, 11, 2, bb);
        this.placeBlockAtCurrentPosition(world, BlockRegistry.planks, 0, 4, 11, 2, bb);
        this.placeBlockAtCurrentPosition(world, BlockRegistry.planks, 0, 2, 11, 0, bb);
        this.placeBlockAtCurrentPosition(world, BlockRegistry.planks, 0, 2, 11, 4, bb);
        this.placeBlockAtCurrentPosition(world, BlockRegistry.planks, 0, 1, 1, 6, bb);
        this.placeBlockAtCurrentPosition(world, BlockRegistry.planks, 0, 1, 1, 7, bb);
        this.placeBlockAtCurrentPosition(world, BlockRegistry.planks, 0, 2, 1, 7, bb);
        this.placeBlockAtCurrentPosition(world, BlockRegistry.planks, 0, 3, 1, 6, bb);
        this.placeBlockAtCurrentPosition(world, BlockRegistry.planks, 0, 3, 1, 7, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.stone_stairs, this.getMetadataWithOffset(Blocks.stone_stairs, 3), 1, 1, 5, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.stone_stairs, this.getMetadataWithOffset(Blocks.stone_stairs, 3), 2, 1, 6, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.stone_stairs, this.getMetadataWithOffset(Blocks.stone_stairs, 3), 3, 1, 5, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.stone_stairs, this.getMetadataWithOffset(Blocks.stone_stairs, 1), 1, 2, 7, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.stone_stairs, this.getMetadataWithOffset(Blocks.stone_stairs, 0), 3, 2, 7, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.stained_glass_pane, 10, 0, 2, 2, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.stained_glass_pane, 10, 0, 3, 2, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.stained_glass_pane, 10, 4, 2, 2, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.stained_glass_pane, 10, 4, 3, 2, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.stained_glass_pane, 10, 0, 6, 2, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.stained_glass_pane, 10, 0, 7, 2, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.stained_glass_pane, 10, 4, 6, 2, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.stained_glass_pane, 10, 4, 7, 2, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.stained_glass_pane, 10, 2, 6, 0, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.stained_glass_pane, 10, 2, 7, 0, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.stained_glass_pane, 10, 2, 6, 4, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.stained_glass_pane, 10, 2, 7, 4, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.stained_glass_pane, 10, 0, 3, 6, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.stained_glass_pane, 10, 4, 3, 6, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.stained_glass_pane, 10, 2, 3, 8, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 2, 4, 7, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 1, 4, 6, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 3, 4, 6, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 2, 4, 5, bb);
        int i = this.getMetadataWithOffset(Blocks.ladder, 4);
        int j;

        for (j = 1; j <= 9; ++j)
        {
            this.placeBlockAtCurrentPosition(world, Blocks.ladder, i, 3, j, 3, bb);
        }

        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 2, 1, 0, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 2, 2, 0, bb);
        **/
        this.placeDoorAtCurrentPosition(world, bb, rand, 2, 1, 0, this.getMetadataWithOffset(Blocks.wooden_door, 1));
        
        if (this.getBlockAtCurrentPosition(world, 2, 0, -1, bb).getMaterial() == Material.air && this.getBlockAtCurrentPosition(world, 2, -1, -1, bb).getMaterial() != Material.air)
        {
            this.placeBlockAtCurrentPosition(world, Blocks.stone_stairs, this.getMetadataWithOffset(Blocks.stone_stairs, 3), 2, 0, -1, bb);
        }
        
        /**
        for (j = 0; j < 9; ++j)
        {
            for (int k = 0; k < 5; ++k)
            {
                this.clearCurrentPositionBlocksUpwards(world, k, 12, j, bb);
                this.func_151554_b(world, BlockRegistry.planks, 0, k, -1, j, bb);
            }
        }
        **/
        this.spawnVillagers(world, bb, 2, 1, 2, 1);
        return true;
    }

    /**
     * Returns the villager type to spawn in this component, based on the number of villagers already spawned.
     */
    protected int getVillagerType(int p_74888_1_)
    {
        return MAEntityRegistry.villagerID;
    }
}