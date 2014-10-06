package magiciansartifice.main.entities;

import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.core.events.DispenserSoulBehavior;
import magiciansartifice.main.core.libs.ModInfo;
import magiciansartifice.main.core.world.ComponentMageTower;
import magiciansartifice.main.entities.bosses.*;
import magiciansartifice.main.entities.pets.*;
import magiciansartifice.main.items.ItemRegistry;
import net.minecraft.block.BlockDispenser;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;

@SuppressWarnings("unchecked")
public class MAEntityRegistry {
	public static ResourceLocation texture = new ResourceLocation(ModInfo.MODID, "textures/entities/villager.png");
	
	public static int mageID = getUniqueEntityId();
	public static int villagerID = getUniqueEntityId() + 1;
    public static int soulID = getUniqueEntityId() + 2;
    public static int overworldBossID = getUniqueEntityId() + 3;
    public static int netherBossID = getUniqueEntityId() + 4;
    public static int enderBossID = getUniqueEntityId() + 5;
    public static int pheonixID = getUniqueEntityId() + 6;
    public static int applingID = getUniqueEntityId() + 7;
    public static int dragonID = getUniqueEntityId() + 8;
    public static int ratID = getUniqueEntityId() + 9;
	
	public static void init() {
		EntityRegistry.registerModEntity(EntityMagician.class, "entityMagician", mageID, MagiciansArtifice.instance, 80, 3, true);
        EntityRegistry.registerModEntity(EntitySoulFragment.class, "entitySoul", soulID, MagiciansArtifice.instance, 80, 3, true);
        EntityRegistry.registerModEntity(EntityBossOverworld.class, "bossOverworld", overworldBossID, MagiciansArtifice.instance, 80, 3, true);
        EntityRegistry.registerModEntity(EntityBossNether.class, "bossNether", netherBossID, MagiciansArtifice.instance, 80, 3, true);
        EntityRegistry.registerModEntity(EntityBossEnder.class, "bossEnder", enderBossID, MagiciansArtifice.instance, 80, 3, true);
        //EntityRegistry.registerModEntity(EntityPetPheonix.class, "petPheonix", pheonixID, MagiciansArtifice.instance, 80, 3, true);
        EntityRegistry.registerModEntity(EntityPetAppling.class, "petAppling", applingID, MagiciansArtifice.instance, 80, 3, true);
        EntityRegistry.registerModEntity(EntityPetDragon.class, "petDragon", dragonID, MagiciansArtifice.instance, 80, 3, true);
        //EntityRegistry.registerModEntity(EntityPetRat.class, "petRat", ratID, MagiciansArtifice.instance, 80, 3, true);

        BlockDispenser.dispenseBehaviorRegistry.putObject(ItemRegistry.horcrux, new DispenserSoulBehavior());

		registerEntityEgg(EntityMagician.class, 0x000349, 0xFFE343);
        registerEntityEgg(EntitySoulFragment.class, 0x000349, 0x000000);
        registerEntityEgg(EntityBossOverworld.class, 0xBBF2FF, 0xFFFFFF);
        registerEntityEgg(EntityBossNether.class, 0xDA0000, 0x3B0000);
        registerEntityEgg(EntityBossEnder.class, 0x3C0059, 0x2B0C36);
        registerEntityEgg(EntityPetAppling.class, 0xDE0101, 0xFFC8C8);
        registerEntityEgg(EntityPetDragon.class, 0xDE0101, 0xFFC8C8);
		registerVillagers();
	}
	
	public static void registerEntityEgg(Class <? extends Entity> entity, int primaryColor, int secondaryColor) {
        int id = getUniqueEntityId();
        EntityList.IDtoClassMapping.put(Integer.valueOf(id), entity);
        EntityList.entityEggs.put(Integer.valueOf(id), new EntityList.EntityEggInfo(id, primaryColor, secondaryColor));
    }
	
	public static int getUniqueEntityId() {
    	int startEntityId = 400;
        do {
            ++startEntityId;
        }
        while (EntityList.getStringFromID(startEntityId) != null);

        return startEntityId;
    }
	
	private static void registerVillagers() {
        try {
            MapGenStructureIO.func_143031_a(ComponentMageTower.class, ModInfo.MODID + ":MageTower");
        }
        catch (Throwable e2) {
            MagiciansArtifice.logger.error("Error registering Magician's Artifice Structures with Vanilla Minecraft: this is expected in versions earlier than 1.7.2");
        }
        VillageHandlerMagician villageHandler = new VillageHandlerMagician();
		VillagerRegistry.instance().registerVillagerId(villagerID);
		VillagerRegistry.instance().registerVillageTradeHandler(villagerID, villageHandler);
        VillagerRegistry.instance().registerVillageCreationHandler(new VillageHandlerMagician());
	}
}
