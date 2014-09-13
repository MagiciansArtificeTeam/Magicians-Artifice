package magiciansartifice.main.items.magicalitems;

import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.core.libs.ModInfo;
import magiciansartifice.main.items.ItemRegistry;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;

public class ItemSpiderFang extends Item {

    public ItemSpiderFang() {
        this.setUnlocalizedName("spiderFang");
        this.setTextureName(ModInfo.MODID + ":magical/spiderFang");
        this.setCreativeTab(MagiciansArtifice.tab);
        ItemRegistry.items.add(this);
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase entity, EntityLivingBase player) {
        entity.addPotionEffect(new PotionEffect(Potion.poison.id,600,0));
        entity.attackEntityFrom(DamageSource.causeMobDamage(player),2.0F);
        return true;
    }
}
