package magiciansartifice.main.core.libs;

import magiciansartifice.main.core.utils.ConfigUtil;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class ConfigHandler {
    //Categories
    public static String general = "General";
    public static String dev = "Developer's Options";
    public static String ritual = "Rituals";
    public static String rarities = "Spawning Options";

    //Options
    public static boolean debugMode;
    public static int receiverDistance;
    public static boolean useConnectedTextures;
    public static int obeliskRarity;
    public static int[] dimensionBlacklist;
    public static int essenceVoidRarity;

    public static void configOptions(Configuration config) {
        config.load();

        config.get(dev, "Turn debugger mode on", true).getBoolean(debugMode);
        useConnectedTextures = config.get(general, "Use connected textures", true).getBoolean(useConnectedTextures);
        Property recieverSearch = ConfigUtil.createPropertyInt(config, ritual, "How far should the teleport ritual search?", 50, "How far should the teleport ritual search? \n>=3: Off \nDefault: 50");
        receiverDistance = recieverSearch.getInt();
        Property obeliskRare = ConfigUtil.createPropertyInt(config, rarities, "How rare should the obelisk be?", 500, "How rare should the obelisk be? \n<0: Off \nDefault: 500");
        obeliskRarity = obeliskRare.getInt();
        Property dontSpawn = ConfigUtil.createPropertyInt(config, rarities, "What dimensions should the Essence Void NOT spawn in?", 1000);
        dimensionBlacklist = dontSpawn.getIntList();
        Property essenceVoidRare = ConfigUtil.createPropertyInt(config, rarities, "How often should the Essence Void spawn?", 75, "Min: 0\nMax: 100");
        essenceVoidRarity = essenceVoidRare.getInt();

        config.save();
    }
}
