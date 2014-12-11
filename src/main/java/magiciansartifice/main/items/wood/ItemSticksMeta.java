package magiciansartifice.main.items.wood;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.core.utils.registries.ItemRegistry;
import magiciansartifice.main.core.libs.ModInfo;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

public class ItemSticksMeta extends Item {
    public IIcon[] icon = new IIcon[16];

    public ItemSticksMeta()
    {
        super();
        setCreativeTab(MagiciansArtifice.tab);
        setHasSubtypes(true);
        setMaxDamage(0);
        setUnlocalizedName("stick");
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
                name = "ashStick";
                break;
            }
            case 1:
            {
                name = "elmStick";
                break;
            }
            case 2:
            {
                name = "rowanStick";
                break;
            }
            case 3:
            {
                name = "alderStick";
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
        icon[0] = ri.registerIcon(ModInfo.MODID + ":misc/stickAsh");
        icon[1] = ri.registerIcon(ModInfo.MODID + ":misc/stickElm");
        icon[2] = ri.registerIcon(ModInfo.MODID + ":misc/stickRowan");
        icon[3] = ri.registerIcon(ModInfo.MODID + ":misc/stickAlder");
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs par2CreativeTabs, List list)
    {
        for (int i = 0; i < 4; i++)
        {
            list.add(new ItemStack(this, 1, i));
        }
    }
}
