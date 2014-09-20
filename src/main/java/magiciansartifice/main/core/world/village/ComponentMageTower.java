package magiciansartifice.main.core.world.village;

import java.util.List;
import java.util.Random;

import magiciansartifice.main.blocks.BlockRegistry;
import magiciansartifice.main.entities.MAEntityRegistry;
import magiciansartifice.main.items.ItemRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureVillagePieces;

/*Girl do you know Java?
Cause that method body is sexy */
@SuppressWarnings("rawtypes")
public class ComponentMageTower extends StructureVillagePieces.Church 
{
	public static final WeightedRandomChestContent[] magiciansTowerContents = { new WeightedRandomChestContent(ItemRegistry.horcrux, 0, 1, 1, 1), 
		new WeightedRandomChestContent(ItemRegistry.magiciansWand3, 0, 1, 1, 1), new WeightedRandomChestContent(ItemRegistry.dustsMeta, 2, 8, 1, 1), 
		new WeightedRandomChestContent(ItemRegistry.dustsMeta, 1, 16, 5, 5), new WeightedRandomChestContent(ItemRegistry.dustsMeta, 0, 32, 10, 10), 
		new WeightedRandomChestContent(ItemRegistry.book, 0, 1, 10, 10) };
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

    public ComponentMageTower(StructureVillagePieces.Start start, int u, Random rand, StructureBoundingBox bb, int coord)
    {
        super(start, u, rand, bb, coord);
        this.coordBaseMode = coord;
        this.boundingBox = bb;
    }

	public static ComponentMageTower buildComponent(StructureVillagePieces.Start start, List list, Random rand, int x, int y, int z, int u, int v)
    {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, 5, 12, 9, u);
        return canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(list, structureboundingbox) == null ? new ComponentMageTower(start, v, rand, structureboundingbox, u) : null;
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
        
        this.fillWithAir(world, bb, 1, 1, 1, 3, 3, 3);
        this.fillWithAir(world, bb, 2, 4, 3, 2, 4, 3);
        this.fillWithAir(world, bb, 1, 5, 1, 3, 8, 3);
        this.fillWithAir(world, bb, 2, 9, 3, 2, 9, 3);
        
        int i = this.getMetadataWithOffset(Blocks.ladder, 3);
        int j;
        for (j = 1; j <= 9; ++j) {
            this.placeBlockAtCurrentPosition(world, Blocks.ladder, i, 2, j, 3, bb);
        }
        
        this.fillWithBlocks(world, bb, 0, 2, 2, 0, 3, 2, Blocks.glass_pane, Blocks.glass_pane, false);
        this.fillWithBlocks(world, bb, 4, 2, 2, 4, 3, 2, Blocks.glass_pane, Blocks.glass_pane, false);
        this.fillWithBlocks(world, bb, 0, 6, 2, 0, 7, 2, Blocks.glass_pane, Blocks.glass_pane, false);
        this.fillWithBlocks(world, bb, 4, 6, 2, 4, 7, 2, Blocks.glass_pane, Blocks.glass_pane, false);
        this.fillWithBlocks(world, bb, 2, 6, 0, 2, 7, 0, Blocks.glass_pane, Blocks.glass_pane, false);
        
        this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 1, 3, 1, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 3, 3, 1, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 1, 3, 3, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 3, 3, 3, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 1, 7, 1, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 3, 7, 1, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 1, 7, 3, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 3, 7, 3, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 1, 10, 1, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 3, 10, 1, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 1, 10, 3, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 3, 10, 3, bb);
        
        int ii = this.getMetadataWithOffset(Blocks.chest, 3);
        this.placeBlockAtCurrentPosition(world, Blocks.chest, ii, 1, 5, 1, bb);
        this.placeBlockAtCurrentPosition(world, Blocks.crafting_table, 0, 2, 5, 1, bb);
        
        this.placeDoorAtCurrentPosition(world, bb, rand, 2, 1, 0, this.getMetadataWithOffset(Blocks.wooden_door, 1));
        
        if (this.getBlockAtCurrentPosition(world, 2, 0, -1, bb).getMaterial() == Material.air && this.getBlockAtCurrentPosition(world, 2, -1, -1, bb).getMaterial() != Material.air) {
            this.placeBlockAtCurrentPosition(world, Blocks.stone_stairs, this.getMetadataWithOffset(Blocks.stone_stairs, 3), 2, 0, -1, bb);
        }
        
        //ChestGenHooks chestContents = new ChestGenHooks("magiciansTowerContents", magiciansTowerContents, 4, 9);
        //this.generateStructureChestContents(world, bb, rand, 1, 5, 1, chestContents.getItems(rand), chestContents.getCount(rand));
        this.spawnVillagers(world, bb, 2, 1, 2, 1);
        return true;
    }

    /**
     * Returns the villager type to spawn in this component, based on the number of villagers already spawned.
     */
    protected int getVillagerType(int type)
    {
        return MAEntityRegistry.villagerID;
    }
}