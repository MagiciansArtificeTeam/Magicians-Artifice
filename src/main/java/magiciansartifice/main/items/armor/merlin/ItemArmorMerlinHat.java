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
public class ItemArmorMerlinHat extends ItemArmor {
    public int armorPiece;

    public ItemArmorMerlinHat(ArmorMaterial material, int render, int piece) {
        super(material, render, piece);
        armorPiece = piece;
        this.setUnlocalizedName("merlinHat");
        this.setCreativeTab(MagiciansArtifice.tab);
        ItemRegistry.items.add(this);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public ModelBiped getArmorModel(EntityLivingBase player, ItemStack stack, int slot) {
        ModelBiped model = new ModelMerlinRobes(0.5F);

        ((ModelMerlinRobes)model).Shape1.isHidden = true;
        ((ModelMerlinRobes)model).Shape2.isHidden = true;
        ((ModelMerlinRobes)model).Shape3.isHidden = true;
        ((ModelMerlinRobes)model).Shape4.isHidden = true;
        model.bipedBody.isHidden = true;
        model.bipedRightArm.isHidden = true;
        model.bipedLeftArm.isHidden = true;

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

