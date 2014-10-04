package magiciansartifice.main.core.libs;

import magiciansartifice.main.core.utils.ConfigUtil;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class ConfigHandler {
    //Categories
    public static String general = "General";
    public static String dev = "Developer's Options";
    public static String ritual = "Rituals";

    //Options
    public static boolean debugMode;
    public static int receiverDistance;
    public static boolean useConnectedTextures;
    public static int obeliskRarity;

    public static void configOptions(Configuration config) {
        config.load();

        config.get(dev, "Turn debugger mode on", true).getBoolean(debugMode);
        useConnectedTextures = config.get(general, "Use connected textures", true).getBoolean(useConnectedTextures);
        Property recieverSearch = ConfigUtil.createPropertyInt(config, ritual, "How far should the teleport ritual search?", 50, "How far should the teleport ritual search? \n>=3: Off \nDefault: 50");
        receiverDistance = recieverSearch.getInt();
        Property obelisk = ConfigUtil.createPropertyInt(config, general, "How common should the obelisk spawn?", 90, "How common should the obelisk spawn? \n<0: Off \n>=100: Off \nDefault: 90 \nNOTE: the higher the number, the less they spawn");
        obeliskRarity = obelisk.getInt();

        config.save();
    }
}
