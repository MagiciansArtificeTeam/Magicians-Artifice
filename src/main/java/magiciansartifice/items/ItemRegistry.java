package magiciansartifice.items;

import cpw.mods.fml.common.registry.GameRegistry;
import magiciansartifice.items.wand.Wand;
import net.minecraft.item.Item;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class ItemRegistry {
    public static Item dustsMeta;
    public static Item magiciansWand;

    static {
        try {
            for (Class clazz : getClasses("magiciansartifice.items")) {
                if (clazz.isAssignableFrom(Item.class))
                    System.out.println("Loading Item Class '" + clazz.getSimpleName() + "'");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void initItems() {
        dustsMeta = new ItemDustMeta();
        GameRegistry.registerItem(dustsMeta,"dustsMeta");
        magiciansWand = new Wand(1);
        GameRegistry.registerItem(magiciansWand,"magiciansWand");
    }

    public static void prepareForRegister(Item item) {
        final String itemName = item.getUnlocalizedName().substring(5);
        try {
            Field itemFeild = ItemRegistry.class.getField(itemName);
            itemFeild.set(null, item);
        } catch (NoSuchFieldException e) {
            System.err.println("Field for item '" + itemName + "' not yet created in ItemRegistry. Unable to register.");
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace(); // Print other messages?
        }
    }

    public static void registerItems() {
        for (final Field field : ItemRegistry.class.getFields()) {
            if (field.getType().isAssignableFrom(Item.class)) {
                try {
                    final Item item = (Item) field.get(null);
                        GameRegistry.registerItem(item, item.getUnlocalizedName().substring(5));
                } catch (IllegalAccessException e) {
                    e.printStackTrace(); // Print Other Messages?
                }
            }
        }
    }

    /**
     * Scans all classes accessible from the context class loader which belong to the given package and subpackages.
     *
     * @param packageName The base package
     * @return The classes
     * @throws ClassNotFoundException
     * @throws IOException
     */

    private static Class[] getClasses(String packageName) throws ClassNotFoundException, IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        assert classLoader != null;
        String path = packageName.replace('.', '/');
        Enumeration<URL> resources = classLoader.getResources(path);
        List<File> dirs = new ArrayList<File>();
        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            dirs.add(new File(resource.getFile()));
        }
        ArrayList<Class> classes = new ArrayList<Class>();
        for (File directory : dirs) {
            classes.addAll(findClasses(directory, packageName));
        }
        return classes.toArray(new Class[classes.size()]);
    }

    /**
     * Recursive method used to find all classes in a given directory and subdirs.
     *
     * @param directory   The base directory
     * @param packageName The package name for classes found inside the base directory
     * @return The classes
     * @throws ClassNotFoundException
     */
    private static List<Class> findClasses(File directory, String packageName) throws ClassNotFoundException {
        List<Class> classes = new ArrayList<Class>();
        if (!directory.exists()) {
            return classes;
        }
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                assert !file.getName().contains(".");
                classes.addAll(findClasses(file, packageName + "." + file.getName()));
            } else if (file.getName().endsWith(".class")) {
                classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
            }
        }
        return classes;
    }
}
