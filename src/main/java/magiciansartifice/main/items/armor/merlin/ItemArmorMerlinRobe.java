package magiciansartifice.main.items.armor.merlin;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.core.client.armor.ModelMerlinRobes;
import magiciansartifice.main.core.libs.ModInfo;
import magiciansartifice.main.core.utils.KeyHelper;
import magiciansartifice.main.core.utils.TextHelper;
import magiciansartifice.main.items.ItemRegistry;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import java.util.List;

/**
 * Created by poppypoppop on 2/10/2014.
 */
public class ItemArmorMerlinRobe extends ItemArmor {
    public int armorPiece;

    public ItemArmorMerlinRobe(ArmorMaterial material, int render, int piece) {
        super(material, render, piece);
        armorPiece = piece;
        this.setUnlocalizedName("merlinRobe");
        this.setCreativeTab(MagiciansArtifice.tab);
        ItemRegistry.items.add(this);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public ModelBiped getArmorModel(EntityLivingBase player, ItemStack stack, int slot) {
        ModelBiped model = new ModelMerlinRobes(/*0.5F*/);

        model.bipedHead.isHidden = true;
        model.bipedRightLeg.isHidden = true;
        model.bipedLeftLeg.isHidden = true;

        model.isSneak = player.isSneaking();
        model.isRiding = player.isRiding();
        model.isChild = player.isChild();

        if (player instanceof EntityPlayer) {
            EntityPlayer Player = (EntityPlayer) player;

            ItemStack ItemInUse = Player.getHeldItem();

            model.heldItemRight = ItemInUse != null ? 1 : 0;

            if (ItemInUse != null && Player.getItemInUseCount() > 0) {
                EnumAction Action = ItemInUse.getItemUseAction();

                if (Action == EnumAction.block) {
                    model.heldItemRight = 3;
                } else if (Action == EnumAction.bow) {
                    model.aimedBow = true;
                }
            }
        }

        return model;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public String getArmorTexture(ItemStack Stack, Entity entity, int Slot, String type) {
        return ModInfo.MODID + ":textures/armor/merlinRobes.png";
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
        if(!KeyHelper.isShiftKeyDown()) {
            list.add(TextHelper.SHIFTFORMORE);
        } else {
            list.add("More information should come soon.");
        }
    }
}