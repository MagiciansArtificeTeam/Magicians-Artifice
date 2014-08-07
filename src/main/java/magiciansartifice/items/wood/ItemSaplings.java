package magiciansartifice.items.wood;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import magiciansartifice.MagiciansArtifice;
import magiciansartifice.items.ItemRegistry;
import magiciansartifice.libs.ModInfo;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

/**
 * Created by poppypoppop on 8/08/2014.
 */
public class ItemSaplings extends Item {
    public IIcon[] icon = new IIcon[16];

    public ItemSaplings()
    {
        super();
        setCreativeTab(MagiciansArtifice.tab);
        setHasSubtypes(true);
        setMaxDamage(0);
        setUnlocalizedName("sapling");
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
                name = "ashSapling";
                break;
            }
            case 1:
            {
                name = "elmSapling";
                break;
            }
            case 2:
            {
                name = "rowanSapling";
                break;
            }
            case 3:
            {
                name = "alderSapling";
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
        icon[0] = ri.registerIcon(ModInfo.MODID + ":misc/saplingAsh");
        icon[1] = ri.registerIcon(ModInfo.MODID + ":misc/saplingElm");
        icon[2] = ri.registerIcon(ModInfo.MODID + ":misc/saplingRowan");
        icon[3] = ri.registerIcon(ModInfo.MODID + ":misc/saplingAlder");
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
