package magiciansartifice.main.items.crafting;

import java.util.List;

import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.core.utils.registries.ItemRegistry;
import magiciansartifice.main.core.libs.ModInfo;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemDustMeta extends Item {

    public IIcon[] icon = new IIcon[3];

    public ItemDustMeta() {
        super();
        this.setCreativeTab(MagiciansArtifice.tab);
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
        this.setUnlocalizedName("dustsMeta");
        ItemRegistry.items.add(this);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemstack) {
        String name = "";
        switch (itemstack.getItemDamage()) {
            case 0: {
                name = "dustOverworld";
                break;
            }
            case 1: {
                name = "dustNether";
                break;
            }
            case 2: {
                name = "dustEnd";
                break;
            }

            default:
                name = "nothing";
                break;
        }
        return getUnlocalizedName() + "." + name;
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int meta) {
        return icon[meta];
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister ri) {
        icon[0] = ri.registerIcon(ModInfo.MODID + ":dusts/dustOverworld");
        icon[1] = ri.registerIcon(ModInfo.MODID + ":dusts/dustNether");
        icon[2] = ri.registerIcon(ModInfo.MODID + ":dusts/dustEnder");
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs par2CreativeTabs, List list) {
        for (int i = 0; i < 3; i++) {
            list.add(new ItemStack(this, 1, i));
        }
    }
}
