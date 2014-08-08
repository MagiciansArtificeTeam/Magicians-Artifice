package magiciansartifice.libs;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class ConfigHandler {
    //Categories
    public static String general = "General";
    public static String enchant = "Enchantments";
    public static String oreConfig = "Ore Configuration";
    public static String dev = "Developer's Options";
    public static String ritual = "Rituals";

    //Options
    public static boolean debugMode;
    public static int receiverDistance;

    public static void configOptions(Configuration config) {
        config.load();

        config.get(dev, "Turn debugger mode on", true).getBoolean(debugMode);
        Property recieverSearch = config.get(ritual,"How far should the teleport ritual search?",50);
        recieverSearch.comment = "How far should the teleport ritual search? \n>=3: Off \nDefault: 50";
        receiverDistance = recieverSearch.getInt();

        config.save();
    }
}
