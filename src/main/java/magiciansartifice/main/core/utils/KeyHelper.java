package magiciansartifice.main.core.utils;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import magiciansartifice.main.core.libs.ModInfo;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;

public class KeyHelper {

    public static KeyBinding showUI;

    public static boolean isCtrlKeyDown()
    {
        boolean isCtrlKeyDown = Keyboard.isKeyDown(Keyboard.KEY_LCONTROL) || Keyboard.isKeyDown(Keyboard.KEY_RCONTROL);
        if (!isCtrlKeyDown && Minecraft.isRunningOnMac)
            isCtrlKeyDown = Keyboard.isKeyDown(Keyboard.KEY_LMETA) || Keyboard.isKeyDown(Keyboard.KEY_RMETA);

        return isCtrlKeyDown;
    }

    public static boolean isShiftKeyDown()
    {
        return Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT);
    }

    public static boolean isKeyDown(int key) {
        return Keyboard.isKeyDown(key);
    }

    @SideOnly(Side.CLIENT)
    public static void init() {
        showUI = new KeyBinding("key.show.essence",Keyboard.KEY_G,"key.categories."+ModInfo.MODID);

        ClientRegistry.registerKeyBinding(showUI);
    }

}
