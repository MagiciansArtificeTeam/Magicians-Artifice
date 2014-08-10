package magiciansartifice.utils;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class ConfigUtil {

    public static Property addComment(Property property, String comment) {
        property.comment = comment;
        return property;
    }

    public static Property createPropertyInt(Configuration config, String category, String label, int value, String comment) {
        Property newProperty = config.get(category, label, value);
        newProperty.comment = comment;
        return newProperty;
    }

    public static Property createPropertyInt(Configuration config, String category, String label, int value) {
        Property newProperty = config.get(category, label, value);
        return newProperty;
    }

    public static Property createPropertyBoolean(Configuration config, String category, String label, boolean value, String comment) {
        Property newProperty = config.get(category, label, value);
        newProperty.comment = comment;
        return newProperty;
    }

    public static Property createPropertyBoolean(Configuration config, String category, String label, boolean value) {
        Property newProperty = config.get(category, label, value);
        return newProperty;
    }

    public static Property createPropertyString(Configuration config, String category, String label, String value, String comment) {
        Property newProperty = config.get(category, label, value);
        newProperty.comment = comment;
        return newProperty;
    }

    public static Property createPropertyString(Configuration config, String category, String label, String value) {
        Property newProperty = config.get(category, label, value);
        return newProperty;
    }

   public static boolean convertIntBoolean(Property property) {
        if (property.isIntValue()) {
            return property.getBoolean();
        }
        return false;
    }

}
