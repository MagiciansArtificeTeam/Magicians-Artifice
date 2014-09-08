package magiciansartifice.api;

import magiciansartifice.main.core.libs.ModInfo;
import magiciansartifice.main.items.magicalitems.ItemWand;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.Random;

public abstract class BasicSpell {

    private String unlocalizedName;
    private boolean clickEntity;
    private boolean isRightClick;
    private int wandLevelRequired;

    public BasicSpell() {
        this.unlocalizedName = "";
        this.wandLevelRequired = 0;
    }

    public String getUnlocalizedName() {
        return this.unlocalizedName;
    }

    public BasicSpell setUnlocalizedName(String name) {
        this.unlocalizedName = name;
        return this;
    }

    public BasicSpell canRightClick() {
        this.isRightClick = true;
        return this;
    }

    public boolean isRightClickSpell() {
        return this.isRightClick;
    }

    public BasicSpell canClickEntity() {
        this.clickEntity = true;
        return this;
    }

    public boolean isEntitySpell() {
        return this.clickEntity;
    }

    public String getLocalizedName() {
        return StatCollector.translateToLocal(this.getUnlocalizedName());
    }

    /**
     * Wand Level Required for usage of the spell (0 = None, 1 = Basic, 2 = Nether, 3 = Master/Ender)
     * @param level
     * @return The spell
     */
    public BasicSpell setWandLevel(int level) {
        this.wandLevelRequired = level;
        return this;
    }

    public int getWandLevelRequired() {
        return this.wandLevelRequired;
    }

    public void beginSpell(World world, int x, int y, int z, EntityPlayer player) {
        player.swingItem();
        if (player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() instanceof ItemWand) {
            ItemWand wand = (ItemWand)player.getCurrentEquippedItem().getItem();
            if (isWandLevelMet(wand)) { performEffect(world,x,y,z,player); }
        }
    }

    public void beginSpell(World world, int x, int y, int z, EntityPlayer player, EntityLivingBase entity) {
        player.swingItem();
        if (player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() instanceof ItemWand) {
            ItemWand wand = (ItemWand)player.getCurrentEquippedItem().getItem();
            if (isWandLevelMet(wand)) { performEffect(world,x,y,z,player,entity); }
        }
    }

    public void performEffect(World world, int x, int y, int z, EntityPlayer player) {
        Random random = new Random();
        world.playSoundAtEntity(player, ModInfo.MODID + ":magic",1.0F,random.nextInt(5));
    }

    public void performEffect(World world, int x, int y, int z, EntityPlayer player,EntityLivingBase entity) {
        Random random = new Random();
        world.playSoundAtEntity(player, ModInfo.MODID + ":magic",1.0F,random.nextInt(5));
    }

    public boolean isWandLevelMet(ItemWand wand) {
        return (wand.getWandLevel() >= this.getWandLevelRequired());
    }

}
