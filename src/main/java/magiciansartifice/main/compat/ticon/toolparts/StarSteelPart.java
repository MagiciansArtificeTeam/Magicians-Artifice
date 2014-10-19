package magiciansartifice.main.compat.ticon.toolparts;

import cpw.mods.fml.common.Optional;
import magiciansartifice.main.compat.ticon.TiConCompat;
import magiciansartifice.main.core.libs.ModInfo;
import magiciansartifice.main.items.ItemRegistry;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import tconstruct.library.TConstructRegistry;
import tconstruct.library.util.IToolPart;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class StarSteelPart extends Item implements IToolPart {
	public StarSteelPart() {
		super();
		this.setMaxStackSize(64);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
		this.setCreativeTab(TConstructRegistry.partTab);
		ItemRegistry.items.add(this);
	}
	
	@Override
    public Item setUnlocalizedName(String name) {
        super.setUnlocalizedName(name);
        GameRegistry.registerItem(this, name);
        return this;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister icon) { itemIcon = icon.registerIcon(ModInfo.MODID + ":parts/" + this.getUnlocalizedName().replace(".", "_").substring(5)); }
	
	@Override
	public int getMaterialID(ItemStack stack) { return TiConCompat.starsteel_id; }
}
