package magiciansartifice.main.entities;

import magiciansartifice.main.MagiciansArtifice;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;

@SuppressWarnings("unchecked")
public class MAEntityRegistry {
	public static int mageID = EntityRegistry.findGlobalUniqueEntityId();
	
	public static void init() {
		EntityRegistry.registerModEntity(EntityVillagerMagician.class, "entityMagician", mageID, MagiciansArtifice.instance, 80, 3, true);
		
		registerEntityEgg(EntityVillagerMagician.class, 0x000349, 0xFFE343);
		registerRecipeHandlers();
	}
	
	public static void registerEntityEgg(Class <? extends Entity> entity, int primaryColor, int secondaryColor)
    {
        int id = getUniqueEntityId();
        EntityList.IDtoClassMapping.put(Integer.valueOf(id), entity);
        EntityList.entityEggs.put(Integer.valueOf(id), new EntityList.EntityEggInfo(id, primaryColor, secondaryColor));
    }
	
	public static int getUniqueEntityId()
    {
    	int startEntityId = 400;
        do
        {
            ++startEntityId ;
        }
        while (EntityList.getStringFromID(startEntityId) != null);

        return startEntityId;
    }
	
	private static void registerRecipeHandlers() {
		VillageHandlerMagician villageHandler = new VillageHandlerMagician();
		VillagerRegistry.instance().registerVillagerId(mageID);
		VillagerRegistry.instance().registerVillageTradeHandler(mageID, villageHandler);
	}
}
