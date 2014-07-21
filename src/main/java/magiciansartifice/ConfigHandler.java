package magiciansartifice;

import net.minecraftforge.common.config.Configuration;

public class ConfigHandler {
    //Categories
    public static String general = "General";
    public static String enchant = "Enchantments";
    public static String oreConfig = "Ore Configuration";
    public static String dev = "Developer's Options";

    //Options
    public static boolean debugMode;

    public static void configOptions(Configuration config) {
        config.get(dev, "Turn debugger mode on", true).getBoolean(debugMode);
    }
}
