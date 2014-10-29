package magiciansartifice.main.items.armor.merlin;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.core.client.armor.ModelMerlinRobes;
import magiciansartifice.main.core.libs.ModInfo;
import magiciansartifice.main.items.ItemRegistry;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

/**
 * Created by poppypoppop on 2/10/2014.
 */
public class ItemArmorMerlinBoots extends ItemArmor {
    public int armorPiece;

    public ItemArmorMerlinBoots(ArmorMaterial material, int render, int piece) {
        super(material, render, piece);
        armorPiece = piece;
        this.setUnlocalizedName("merlinBoots");
        this.setCreativeTab(MagiciansArtifice.tab);
        ItemRegistry.items.add(this);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public ModelBiped getArmorModel(EntityLivingBase player, ItemStack stack, int slot) {
        ModelBiped model = new ModelMerlinRobes(/*0.5F*/);

        ((ModelMerlinRobes)model).legging1.isHidden = true;
        ((ModelMerlinRobes)model).legging2.isHidden = true;
        model.bipedBody.isHidden = true;
        model.bipedLeftLeg.isHidden = true;
        model.bipedRightLeg.isHidden = true;
        model.bipedHead.isHidden = true;
        model.bipedLeftArm.isHidden = true;
        model.bipedRightArm.isHidden = true;

        model.isSneak = player.isSneaking();
        model.isRiding = player.isRiding();
        model.isChild = player.isChild();

        return model;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public String getArmorTexture(ItemStack Stack, Entity entity, int Slot, String type) {
        return ModInfo.MODID + ":textures/armor/merlinRobes.png";
    }
}
