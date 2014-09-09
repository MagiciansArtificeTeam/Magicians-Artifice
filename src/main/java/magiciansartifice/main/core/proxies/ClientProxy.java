package magiciansartifice.main.core.proxies;

import cpw.mods.fml.client.registry.ClientRegistry;
import magiciansartifice.main.blocks.BlockRegistry;
import magiciansartifice.main.core.client.CustomItemRenderer;
import magiciansartifice.main.core.client.machines.*;
import magiciansartifice.main.core.client.te.TEContainmentCornerstoneRenderer;
import magiciansartifice.main.items.ItemRegistry;
import magiciansartifice.main.tileentities.machines.*;
import magiciansartifice.main.tileentities.magic.TileEntityContainmentCornerstone;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy {

    @Override
    public void initSounds() {
    }

    @Override
    public void initRenderers() {
        super.initRenderers();
        renderBlocks();
        renderItems();
    }
    
    private void renderBlocks() {
    	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMysticAnvil.class, new RenderAnvil());
    	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWandCarver.class, new RenderWandCarver());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMagicTank.class, new RenderTank());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityContainmentCornerstone.class,new TEContainmentCornerstoneRenderer());
    }
    
    private void renderItems() {
    	//normal items
    	MinecraftForgeClient.registerItemRenderer(ItemRegistry.magiciansWand, new CustomItemRenderer());
    	MinecraftForgeClient.registerItemRenderer(ItemRegistry.magiciansWand2, new CustomItemRenderer());
    	MinecraftForgeClient.registerItemRenderer(ItemRegistry.magiciansWand3, new CustomItemRenderer());
    	
    	//block items
    	MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockRegistry.mysticAnvil), new CustomItemRenderer());
    	MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockRegistry.wandCarver), new CustomItemRenderer());
    	MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockRegistry.tank), new CustomItemRenderer());
    }

}