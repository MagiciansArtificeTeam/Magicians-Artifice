package magiciansartifice.api;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import magiciansartifice.main.core.client.particles.SparkleParticle;
import magiciansartifice.main.core.libs.ModInfo;
import magiciansartifice.main.core.utils.PlayerHelper;
import magiciansartifice.main.items.magicalitems.ItemWand;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.Random;

public abstract class BasicSpell {

    private String unlocalizedName;
    private String magicWords;
    private boolean clickEntity;
    private boolean isRightClick;
    private int wandLevelRequired;
    private boolean isForbidden;
    private boolean isEaten;
    private boolean isCast;
    private boolean leftClickEntity;
    private boolean useParticles = false;

    private int earthEssenceRequired;
    private int netherEssenceRequiried;
    private int enderEssenceRequired;

    public BasicSpell() {
        this.unlocalizedName = "";
        magicWords = "";
        this.wandLevelRequired = 0;
        this.earthEssenceRequired = 0;
        this.netherEssenceRequiried = 0;
        this.enderEssenceRequired = 0;
    }

    public String getUnlocalizedName() {
        return this.unlocalizedName;
    }

    /**
     * Sets the unlocalized name
     * @param name - Unlocalized name
     * @return the spell
     */
    public BasicSpell setUnlocalizedName(String name) {
        this.unlocalizedName = name;
        return this;
    }

    /**
     * Sets the spell to use particles
     * @return the spell
     */
    public BasicSpell useParticles() {
    	this.useParticles = true;
    	return this;
    }

    public boolean doesUseParticles() {
        return this.useParticles;
    }

    @SideOnly(Side.CLIENT)
    public void particles(World world, int x, int y, int z, Random rand) {
    	float x1 = (float)x + 0.5F;
		float y1 = (y + 0.5F) + rand.nextFloat();
		float z1 = (float)z + 0.5F;
		float f1 = rand.nextFloat() * 0.6F - 0.3F;
    	for (int i = 0; i <= 64; i++) {
        	Minecraft.getMinecraft().effectRenderer.addEffect(new SparkleParticle(world, (double)(x1 - f1), (double)(y1), (double)(z1 + f1), -1F, 0.5F));
        }
    }

    /**
     * Makes it a right click spell (on self)
     * @return the spell
     */
    public BasicSpell canRightClick() {
        this.isRightClick = true;
        return this;
    }

    public boolean isRightClickSpell() {
        return this.isRightClick;
    }

    public BasicSpell setSpellBeginning(String spellBeginning) {
        this.magicWords = spellBeginning;
        return this;
    }

    public String getMagicWords() {
        return this.magicWords;
    }

    /**
     * Makes it an interact spell (on entity)
     * @return the spell
     */
    public BasicSpell canClickEntity() {
        this.clickEntity = true;
        return this;
    }

    /**
     * Makes it a left click spell (on entity)
     * @return the spell
     */
    public BasicSpell canLeftClickEntity() {
        this.leftClickEntity = true;
        return this;
    }

    public boolean isLeftClickEntitySpell() {
        return this.leftClickEntity;
    }

    /**
     * Makes it a forbidden spell
     * @return the spell
     */
    public BasicSpell isForbidden() {
        this.isForbidden = true;
        return this;
    }

    @Deprecated
    public BasicSpell isEatingSpell() {
        this.isEaten = true;
        return this;
    }

    public BasicSpell isCastSpell() {
        this.isCast = true;
        return this;
    }

    public boolean getCastSpell() { return this.isCast; }

    public boolean getEaten() {
        return this.isEaten;
    }

    public boolean getForbidden() {
        return this.isForbidden;
    }

    /**
     * Sets the amount of essence required
     * @param earthEssence - Amount of overworld essence
     * @param netherEssence - Amount of nether essence
     * @param enderEssence - Amount of ender essence
     * @return the spell
     */
    public BasicSpell setSpellRequirements(int earthEssence, int netherEssence, int enderEssence) {
        this.earthEssenceRequired = earthEssence;
        this.netherEssenceRequiried = netherEssence;
        this.enderEssenceRequired = enderEssence;
        return this;
    }

    public boolean isEntitySpell() {
        return this.clickEntity;
    }

    /**
     * Gets the localized name
     * @return the name localized in the system
     */
    public String getLocalizedName() {
        return StatCollector.translateToLocal(this.getUnlocalizedName());
    }

    /**
     * Wand Level Required for usage of the spell (0 = None, 1 = Basic, 2 = Nether, 3 = Master/Ender)
     * @param level - The level required for usage of a spell
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
            if (this.isWandLevelMet(wand) && this.areAllRequirementsMet(player.getCurrentEquippedItem())) {
                this.performEffect(world, x, y, z, player);
                if (this.doesUseParticles()) {
                    if (world.isRemote) this.particles(world, x, y, z, new Random());
            	}
            }
        }
    }

    public void beginSpell(World world, int x, int y, int z, EntityPlayer player, EntityLivingBase entity) {
        player.swingItem();
        if (player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() instanceof ItemWand) {
            ItemWand wand = (ItemWand)player.getCurrentEquippedItem().getItem();
            if (this.isWandLevelMet(wand) && this.areAllRequirementsMet(player.getCurrentEquippedItem())) {
                this.performEffect(world, x, y, z, player,entity);
                if (this.doesUseParticles()) {
                    int x2 = (int) Math.floor(entity.posX);
                    int y2 = (int) Math.floor(entity.posY);
                    int z2 = (int) Math.floor(entity.posZ);
                    if (world.isRemote) this.particles(world, x2, y2, z2, new Random());
                }
            }
        }
    }

    public void beginSpell(World world, int x, int y, int z, EntityPlayer player, Entity entity) {
        player.swingItem();
        if (player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() instanceof ItemWand) {
            ItemWand wand = (ItemWand)player.getCurrentEquippedItem().getItem();
            if (this.isWandLevelMet(wand) && this.areAllRequirementsMet(player.getCurrentEquippedItem())) {
                this.performEffect(world, x, y, z, player,entity);
                if (this.doesUseParticles()) {
                    int x2 = (int) Math.floor(entity.posX);
                    int y2 = (int) Math.floor(entity.posY);
                    int z2 = (int) Math.floor(entity.posZ);
                    if (world.isRemote) this.particles(world, x2, y2, z2, new Random());
                }
            }
        }
    }

    public void beginSpell(World world, int x, int y, int z, EntityPlayer player, String spell) {
        player.swingItem();
        if (player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() instanceof ItemWand) {
            ItemWand wand = (ItemWand) player.getCurrentEquippedItem().getItem();
            if (this.isWandLevelMet(wand) && this.areAllRequirementsMet(player.getCurrentEquippedItem())) {
                this.performEffect(world, x, y, z, player, spell);
                if (this.doesUseParticles()) {
                    int x2 = (int) Math.floor(player.posX);
                    int y2 = (int) Math.floor(player.posY);
                    int z2 = (int) Math.floor(player.posZ);
                    if (world.isRemote) this.particles(world,x2,y2,z2,new Random());
                }
            }
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
        if (player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() instanceof ItemWand) {
            if (((ItemWand) player.getCurrentEquippedItem().getItem()).getWandLevel() < 4) {
                this.payEssence(player);
            }
        }
    }

    public void performEffect(World world, int x, int y, int z, EntityPlayer player,EntityLivingBase entity) {
        Random random = new Random();
        if (this.getForbidden()) {
            world.playSoundAtEntity(player, ModInfo.MODID + ":magic", 1.0F, random.nextInt(5));
            PlayerHelper.broadcastSoundToRadius(player,world,ModInfo.MODID + ":magic_evil",1.0F,random.nextInt(5),50);
        } else {
            world.playSoundAtEntity(player, ModInfo.MODID + ":magic", 1.0F, random.nextInt(5));
        }
        if (player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() instanceof ItemWand) {
            if (((ItemWand) player.getCurrentEquippedItem().getItem()).getWandLevel() < 4) {
                this.payEssence(player);
            }
        }
    }

    public void performEffect(World world, int x, int y, int z, EntityPlayer player,Entity entity) {
        Random random = new Random();
        if (this.getForbidden()) {
            world.playSoundAtEntity(player, ModInfo.MODID + ":magic", 1.0F, random.nextInt(5));
            PlayerHelper.broadcastSoundToRadius(player,world,ModInfo.MODID + ":magic_evil",1.0F,random.nextInt(5),50);
        } else {
            world.playSoundAtEntity(player, ModInfo.MODID + ":magic", 1.0F, random.nextInt(5));
        }
        if (player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() instanceof ItemWand) {
            if (((ItemWand) player.getCurrentEquippedItem().getItem()).getWandLevel() < 4) {
                this.payEssence(player);
            }
        }
    }

    public void performEffect(World world, int x, int y, int z, EntityPlayer player, String spell) {
        Random random = new Random();
        if (this.getForbidden()) {
            world.playSoundAtEntity(player, ModInfo.MODID + ":magic", 1.0F, random.nextInt(5));
            PlayerHelper.broadcastSoundToRadius(player,world,ModInfo.MODID + ":magic_evil",1.0F,random.nextInt(5),50);
        } else {
            world.playSoundAtEntity(player, ModInfo.MODID + ":magic", 1.0F, random.nextInt(5));
        }
        if (player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() instanceof ItemWand) {
            if (((ItemWand) player.getCurrentEquippedItem().getItem()).getWandLevel() < 4) {
                this.payEssence(player);
            }
        }
    }

    public void payEssence(EntityPlayer player) {
        int earthEssence = player.getCurrentEquippedItem().stackTagCompound.getInteger("wandEssence");
        int netherEssence = player.getCurrentEquippedItem().stackTagCompound.getInteger("wandEssenceN");
        int enderEssence = player.getCurrentEquippedItem().stackTagCompound.getInteger("wandEssenceE");

        player.getCurrentEquippedItem().stackTagCompound.setInteger("wandEssence",earthEssence - this.earthEssenceRequired);
        player.getCurrentEquippedItem().stackTagCompound.setInteger("wandEssenceN",netherEssence - this.netherEssenceRequiried);
        player.getCurrentEquippedItem().stackTagCompound.setInteger("wandEssenceE",enderEssence - this.enderEssenceRequired);

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
