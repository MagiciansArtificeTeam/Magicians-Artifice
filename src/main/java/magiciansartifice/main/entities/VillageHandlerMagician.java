package magiciansartifice.main.entities;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.common.registry.VillagerRegistry;
import magiciansartifice.main.core.world.ComponentMageTower;
import magiciansartifice.main.items.ItemRegistry;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import cpw.mods.fml.common.registry.VillagerRegistry.IVillageTradeHandler;
import net.minecraft.world.gen.structure.StructureVillagePieces;

@SuppressWarnings({"unchecked", "rawtypes"})
public class VillageHandlerMagician implements IVillageTradeHandler , VillagerRegistry.IVillageCreationHandler{//, IVillageCreationHandler {
	@Override
	public void manipulateTradesForVillager(EntityVillager villager, MerchantRecipeList recipeList, Random random) {
		recipeList.add(new MerchantRecipe(new ItemStack(Items.emerald, random(25)), new ItemStack(ItemRegistry.dustsMeta, random(10), 2)));
        recipeList.add(new MerchantRecipe(new ItemStack(Items.emerald, random(15)),new ItemStack(ItemRegistry.dustsMeta, random(20), 0)));
        recipeList.add(new MerchantRecipe(new ItemStack(Items.emerald, random(20)), new ItemStack(ItemRegistry.dustsMeta, random(15),1)));
		recipeList.add(new MerchantRecipe(new ItemStack(Items.emerald, random(10)), new ItemStack(ItemRegistry.magiciansWand)));
        recipeList.add(new MerchantRecipe(new ItemStack(Items.emerald, random(20)), new ItemStack(ItemRegistry.magiciansWand2)));
        recipeList.add(new MerchantRecipe(new ItemStack(Items.emerald, random(10)),new ItemStack(ItemRegistry.dustsMeta, random(15),1),new ItemStack(ItemRegistry.magiciansWand2)));
	}

    @Override
    public StructureVillagePieces.PieceWeight getVillagePieceWeight(Random random, int i) {
        return new StructureVillagePieces.PieceWeight(ComponentMageTower.class, 5, 1);
    }

    public static int random(int maxValue) {
        int random = 0;
        do {
            Random rand = new Random();
            random = rand.nextInt(maxValue);
        } while (random == 0);
        return random;
    }

    @Override
    public Class<?> getComponentClass() {
        return ComponentMageTower.class;
    }

    @Override
    public Object buildComponent(StructureVillagePieces.PieceWeight villagePiece, StructureVillagePieces.Start startPiece, List pieces, Random random, int p1, int p2, int p3, int p4, int p5) {
        return ComponentMageTower.buildComponent(startPiece,pieces,random,p1,p2,p3,p4,p5);
        //return null;
    }
}
