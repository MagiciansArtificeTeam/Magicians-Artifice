package magiciansartifice.main.entities;

import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.core.libs.ModInfo;
import magiciansartifice.main.core.world.village.ComponentMageTower;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;
import net.minecraft.world.gen.structure.MapGenStructureIO;

@SuppressWarnings("unchecked")
public class MAEntityRegistry {
	public static ResourceLocation texture = new ResourceLocation(ModInfo.MODID, "textures/entities/villager.png");
	
	public static int mageID = getUniqueEntityId();
	public static int villagerID = getUniqueEntityId();
	
	public static void init() {
		EntityRegistry.registerModEntity(EntityMagician.class, "entityMagician", mageID, MagiciansArtifice.instance, 80, 3, true);
		
		registerEntityEgg(EntityMagician.class, 0x000349, 0xFFE343);
		registerVillagers();
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
	
	private static void registerVillagers() {
        try
        {
            MapGenStructureIO.func_143031_a(ComponentMageTower.class, ModInfo.MODID + ":MageTower");
        }
        catch (Throwable e2)
        {
            MagiciansArtifice.logger.error("Error registering Magician's Artifice Structures with Vanilla Minecraft: this is expected in versions earlier than 1.7.2");
        }
        VillageHandlerMagician villageHandler = new VillageHandlerMagician();
		VillagerRegistry.instance().registerVillagerId(villagerID);
		VillagerRegistry.instance().registerVillagerSkin(villagerID, texture);
		VillagerRegistry.instance().registerVillageTradeHandler(villagerID, villageHandler);
        VillagerRegistry.instance().registerVillageCreationHandler(new VillageHandlerMagician());
	}
}
