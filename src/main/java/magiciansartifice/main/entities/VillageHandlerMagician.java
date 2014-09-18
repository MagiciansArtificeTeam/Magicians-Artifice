package magiciansartifice.main.entities;

import java.util.Random;

import magiciansartifice.main.items.ItemRegistry;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import cpw.mods.fml.common.registry.VillagerRegistry.IVillageTradeHandler;

@SuppressWarnings("unchecked")
public class VillageHandlerMagician implements IVillageTradeHandler {//, IVillageCreationHandler {
	@Override
	public void manipulateTradesForVillager(EntityVillager villager, MerchantRecipeList recipeList, Random random) {
		recipeList.add(new MerchantRecipe(new ItemStack(Items.emerald, 1), new ItemStack(ItemRegistry.dustsMeta, 10, 2)));
		recipeList.add(new MerchantRecipe(new ItemStack(Items.emerald, 3), new ItemStack(ItemRegistry.magiciansWand)));
	}
}
