package magiciansartifice.items.misc;

import magiciansartifice.MagiciansArtifice;
import magiciansartifice.items.ItemRegistry;
import magiciansartifice.libs.ModInfo;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;

/**
 * Created by poppypoppop on 21/07/2014.
 */
public class ItemLetterMerlin extends Item {
    public ItemLetterMerlin() {
        this.setTextureName(ModInfo.MODID + ":misc/merlinLetter");
        this.setUnlocalizedName("merlinLetter");
        this.setCreativeTab(MagiciansArtifice.tab);
        ItemRegistry.items.add(this);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        if (!world.isRemote) {
            player.addChatComponentMessage(new ChatComponentTranslation("merlin.letter.message"));
            stack.stackSize = 0;
            return stack;
        }
        return stack;
    }
}
