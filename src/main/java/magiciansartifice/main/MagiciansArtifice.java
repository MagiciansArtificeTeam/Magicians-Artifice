package magiciansartifice.main;

import magiciansartifice.main.blocks.BlockRegistry;
import magiciansartifice.main.compat.ticon.TiConCompat;
import magiciansartifice.main.core.client.guis.CreativeTab;
import magiciansartifice.main.core.client.guis.GuiHandler;
import magiciansartifice.main.core.events.EventRegistry;
import magiciansartifice.main.core.libs.ConfigHandler;
import magiciansartifice.main.core.libs.ModInfo;
import magiciansartifice.main.core.network.PacketHandler;
import magiciansartifice.main.core.proxies.CommonProxy;
import magiciansartifice.main.core.utils.OreDictHandler;
import magiciansartifice.main.core.utils.RecipeRegistry;
import magiciansartifice.main.core.world.GenerationHandler;
import magiciansartifice.main.core.world.WorldGenStructureObelisk;
import magiciansartifice.main.core.world.WorldGeneratorRegistry;
import magiciansartifice.main.entities.MAEntityRegistry;
import magiciansartifice.main.fluids.LiquidRegistry;
import magiciansartifice.main.items.ItemRegistry;
import magiciansartifice.main.magic.rituals.Rituals;
import magiciansartifice.main.magic.spells.Spells;
import magiciansartifice.main.tileentities.TileEntityRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

import java.io.File;

@Mod(modid = ModInfo.MODID, name = ModInfo.NAME, version = ModInfo.VERSION,dependencies = ModInfo.DEPENDENCIES)
public class MagiciansArtifice {
    @Instance(ModInfo.MODID)
    public static MagiciansArtifice instance;
    public static Logger logger = LogManager.getLogger(ModInfo.NAME);

    @SidedProxy(clientSide = ModInfo.CLIENT, serverSide = ModInfo.SERVER)
    public static CommonProxy proxy;

    public static CreativeTabs tab = new CreativeTab(ModInfo.MODID);
    public static CreativeTab partsTab = new CreativeTab(ModInfo.MODID + "Parts",new ItemStack(ItemRegistry.magiciansWand3));

    Configuration config;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        File configFolder = event.getModConfigurationDirectory();
        File newConfigFile = new File(configFolder, "MagiciansArtifice.cfg");
        config = new Configuration(newConfigFile);

        ConfigHandler.configOptions(config);

        Rituals.init();
        Spells.init();
        logger.info("Initialized Magic");
        BlockRegistry.registerBlocks();
        ItemRegistry.initItems();
        logger.info("Initialized Items and Blocks");
        TileEntityRegistry.registerTEs();
        LiquidRegistry.registerFluids();
        logger.info("Initialized Fluids and Tile Entities");

        OreDictHandler.registerOreDicts();
        EventRegistry.initEvents();
        logger.info("Initialized Events");
        WorldGeneratorRegistry.registerWorldGens();
        NetworkRegistry.INSTANCE.registerGuiHandler(MagiciansArtifice.instance, new GuiHandler());
        MAEntityRegistry.init();

        FMLInterModComms.sendMessage("Waila", "register", "magiciansartifice.main.compat.waila.WailaRegister.registerCallbacks");
        TiConCompat.registerStuff();

        proxy.load();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        PacketHandler.init();
        RecipeRegistry.registerModRecipes();
        logger.info("Initialized Mod Recipes");
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {}
}