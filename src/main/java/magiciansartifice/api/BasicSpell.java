package magiciansartifice.api;

import magiciansartifice.items.wand.Wand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

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
        this.setWandLevel(level);
        return this;
    }

    public int getWandLevelRequired() {
        return this.wandLevelRequired;
    }

    public void beginSpell(World world, int x, int y, int z, EntityPlayer player) {
        if (player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() instanceof Wand) {
            Wand wand = (Wand)player.getCurrentEquippedItem().getItem();
            if (isWandLevelMet(wand)) { performEffect(world,x,y,z,player); }
        }
    }

    public void performEffect(World world, int x, int y, int z, EntityPlayer player) {}

    public boolean isWandLevelMet(Wand wand) {
        return (wand.getWandLevel() >= this.getWandLevelRequired());
    }

}