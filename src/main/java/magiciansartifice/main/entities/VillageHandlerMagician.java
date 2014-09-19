package magiciansartifice.main.entities;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.common.registry.VillagerRegistry;
import magiciansartifice.main.core.world.village.ComponentMageTower;
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
		recipeList.add(new MerchantRecipe(new ItemStack(Items.emerald, 1), new ItemStack(ItemRegistry.dustsMeta, 10, 2)));
		recipeList.add(new MerchantRecipe(new ItemStack(Items.emerald, 3), new ItemStack(ItemRegistry.magiciansWand)));
	}

    @Override
    public StructureVillagePieces.PieceWeight getVillagePieceWeight(Random random, int i) {
        return null;
    }

    @Override
    public Class<?> getComponentClass() {
        return ComponentMageTower.class;
    }

    @Override
    public Object buildComponent(StructureVillagePieces.PieceWeight villagePiece, StructureVillagePieces.Start startPiece, List pieces, Random random, int p1, int p2, int p3, int p4, int p5) {
        return null;
    }
}
