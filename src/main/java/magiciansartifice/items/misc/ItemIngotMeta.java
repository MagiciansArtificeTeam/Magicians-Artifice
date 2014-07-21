package magiciansartifice.items.misc;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import magiciansartifice.MagiciansArtifice;
import magiciansartifice.libs.ModInfo;
import magiciansartifice.items.ItemRegistry;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

public class ItemIngotMeta extends Item
{
    public IIcon[] icon = new IIcon[3];

    public ItemIngotMeta()
    {
        super();
        setCreativeTab(MagiciansArtifice.tab);
        setHasSubtypes(true);
        setMaxDamage(0);
        setUnlocalizedName("ingotMeta");
        ItemRegistry.items.add(this);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemstack)
    {
        String name = "";
        switch (itemstack.getItemDamage())
        {
            case 0:
            {
                name = "ingotStarSteel";
                break;
            }

            default:
                name = "nothing";
                break;
        }
        return getUnlocalizedName() + "." + name;
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int meta)
    {
        return icon[meta];
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister ri)
    {
        icon[0] = ri.registerIcon(ModInfo.MODID + ":ingots/ingotStarSteel");
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs par2CreativeTabs, List list)
    {
        for (int i = 0; i < 1; i++)
        {
            list.add(new ItemStack(this, 1, i));
        }
    }
}
