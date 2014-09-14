package magiciansartifice.main.items.magicalitems;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.core.libs.ModInfo;
import magiciansartifice.main.items.ItemRegistry;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

public class ItemSpiderFang extends Item {

    public ItemSpiderFang() {
        this.setUnlocalizedName("spiderFang");
        this.setTextureName(ModInfo.MODID + ":magical/spiderFang");
        this.setCreativeTab(MagiciansArtifice.tab);
        ItemRegistry.items.add(this);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase entity, EntityLivingBase player) {
        entity.addPotionEffect(new PotionEffect(Potion.poison.id,600,0));
        entity.attackEntityFrom(DamageSource.causeMobDamage(player),2.0F);
        return true;
    }

    @SubscribeEvent
    public void livingDrops(LivingDropsEvent event) {
        if (event.entityLiving instanceof EntityCaveSpider) {
            if (itemRand.nextInt(100) >= 90) {
                event.drops.add(new EntityItem(((EntityCaveSpider) event.entityLiving).worldObj,event.entity.posX,event.entity.posY,event.entity.posZ,new ItemStack(ItemRegistry.spiderFang)));
            }
        }
        if (event.entityLiving instanceof EntityEnderman) {
            if (itemRand.nextInt(100) > 80) {
                event.drops.add(new EntityItem(((EntityEnderman) event.entityLiving).worldObj,event.entity.posX,event.entity.posY,event.entity.posZ,new ItemStack(ItemRegistry.dustsMeta,1,2)));
            }
        }
    }
}
