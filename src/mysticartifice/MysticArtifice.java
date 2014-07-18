package mysticartifice;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import mysticartifice.guis.CreativeTab;
import mysticartifice.items.ItemRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.config.Configuration;
import mysticartifice.blocks.BlockRegistry;

@Mod(modid = ModInfo.MODID, name = ModInfo.NAME, version = ModInfo.VERSION, dependencies = "after:NotEnoughItems")
public class MysticArtifice {
    @Instance("mysticartifice")
    public MysticArtifice instance;

    public static CreativeTabs tab = new CreativeTab("mysticartifice");

    Configuration config;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        config = new Configuration(event.getSuggestedConfigurationFile());

        BlockRegistry.registerBlocks();
        ItemRegistry.registerItems();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {

    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }
}
