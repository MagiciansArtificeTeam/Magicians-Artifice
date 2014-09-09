package magiciansartifice.api;

import magiciansartifice.main.core.libs.ModInfo;
import magiciansartifice.main.core.utils.PlayerHelper;
import magiciansartifice.main.items.magicalitems.ItemWand;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.Random;

public abstract class BasicSpell {

    private String unlocalizedName;
    private boolean clickEntity;
    private boolean isRightClick;
    private int wandLevelRequired;
    private boolean isForbidden;
    private boolean isEaten;

    private int earthEssenceRequired;
    private int netherEssenceRequiried;
    private int enderEssenceRequired;

    public BasicSpell() {
        this.unlocalizedName = "";
        this.wandLevelRequired = 0;
        this.earthEssenceRequired = 0;
        this.netherEssenceRequiried = 0;
        this.enderEssenceRequired = 0;
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

    public BasicSpell isForbidden() {
        this.isForbidden = true;
        return this;
    }

    public BasicSpell isEatingSpell() {
        this.isEaten = true;
        return this;
    }

    public boolean getEaten() {
        return this.isEaten;
    }

    public boolean getForbidden() {
        return this.isForbidden;
    }

    public BasicSpell setSpellRequirements(int earthEssence, int netherEssence, int enderEssence) {
        this.earthEssenceRequired = earthEssence;
        this.netherEssenceRequiried = netherEssence;
        this.enderEssenceRequired = enderEssence;
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
            if (this.isWandLevelMet(wand) && this.areAllRequirementsMet(player.getCurrentEquippedItem())) { performEffect(world,x,y,z,player); }
        }
    }

    public void beginSpell(World world, int x, int y, int z, EntityPlayer player, EntityLivingBase entity) {
        player.swingItem();
        if (player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() instanceof ItemWand) {
            ItemWand wand = (ItemWand)player.getCurrentEquippedItem().getItem();
            if (this.isWandLevelMet(wand) && this.areAllRequirementsMet(player.getCurrentEquippedItem())) { performEffect(world,x,y,z,player,entity); }
        }
    }

    public void performEffect(World world, int x, int y, int z, EntityPlayer player) {
        Random random = new Random();
        if (this.getForbidden()) {
            world.playSoundAtEntity(player, ModInfo.MODID + ":magic", 1.0F, random.nextInt(5));
            PlayerHelper.broadcastSoundToRadius(player,world,ModInfo.MODID + ":magic_evil",1.0F,random.nextInt(5),50);
        } else {
            world.playSoundAtEntity(player, ModInfo.MODID + ":magic", 1.0F, random.nextInt(5));
        }
        this.payEssence(player);
    }

    public void performEffect(World world, int x, int y, int z, EntityPlayer player,EntityLivingBase entity) {
        Random random = new Random();
        if (this.getForbidden()) {
            world.playSoundAtEntity(player, ModInfo.MODID + ":magic", 1.0F, random.nextInt(5));
            PlayerHelper.broadcastSoundToRadius(player,world,ModInfo.MODID + ":magic_evil",1.0F,random.nextInt(5),50);
        } else {
            world.playSoundAtEntity(player, ModInfo.MODID + ":magic", 1.0F, random.nextInt(5));
        }
        this.payEssence(player);
    }

    public void payEssence(EntityPlayer player) {
        int earthEssence = player.getCurrentEquippedItem().stackTagCompound.getInteger("wandEssence");
        int netherEssence = player.getCurrentEquippedItem().stackTagCompound.getInteger("wandEssenceN");
        int enderEssence = player.getCurrentEquippedItem().stackTagCompound.getInteger("wandEssenceE");

        player.getCurrentEquippedItem().stackTagCompound.setInteger("wandEssence",earthEssence - this.earthEssenceRequired);
        player.getCurrentEquippedItem().stackTagCompound.setInteger("wandEssenceN",netherEssence - this.netherEssenceRequiried);
        player.getCurrentEquippedItem().stackTagCompound.setInteger("wandEssenceE",enderEssence - this.enderEssenceRequired);
        System.err.println(this.getClass().getName());

        earthEssence = player.getCurrentEquippedItem().stackTagCompound.getInteger("wandEssence");
        netherEssence = player.getCurrentEquippedItem().stackTagCompound.getInteger("wandEssenceN");
        enderEssence = player.getCurrentEquippedItem().stackTagCompound.getInteger("wandEssenceE");

        System.err.println(earthEssence);
        System.err.println(netherEssence);
        System.err.println(enderEssence);

    }

    public boolean isWandLevelMet(ItemWand wand) {
        return (wand.getWandLevel() >= this.getWandLevelRequired());
    }

    private boolean areAllRequirementsMet(ItemStack stack) {
        if (stack.stackTagCompound.getInteger("wandEssence") >= this.earthEssenceRequired) {
            if (stack.stackTagCompound.getInteger("wandEssenceN") >= this.netherEssenceRequiried) {
                if (stack.stackTagCompound.getInteger("wandEssenceE") >= this.enderEssenceRequired) {
                    return true;
                }
            }
        }
        return false;
    }

}
