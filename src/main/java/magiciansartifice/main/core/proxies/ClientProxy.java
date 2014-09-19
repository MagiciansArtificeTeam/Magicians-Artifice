package magiciansartifice.main.core.proxies;

import magiciansartifice.main.blocks.BlockRegistry;
import magiciansartifice.main.core.client.CustomItemRenderer;
import magiciansartifice.main.core.client.machines.RenderAnvil;
import magiciansartifice.main.core.client.machines.RenderTank;
import magiciansartifice.main.core.client.machines.RenderWandCarver;
import magiciansartifice.main.core.client.te.TEContainmentCornerstoneRenderer;
import magiciansartifice.main.entities.EntityMagician;
import magiciansartifice.main.entities.render.EntityMagicianRenderer;
import magiciansartifice.main.entities.render.ModelMagician;
import magiciansartifice.main.items.ItemRegistry;
import magiciansartifice.main.tileentities.machines.TileEntityMagicTank;
import magiciansartifice.main.tileentities.machines.TileEntityMysticAnvil;
import magiciansartifice.main.tileentities.machines.TileEntityWandCarver;
import magiciansartifice.main.tileentities.magic.TileEntityContainmentCornerstone;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {

    @Override
    public void initSounds() {
    }

    @Override
    public void initRenderers() {
        super.initRenderers();
        renderBlocks();
        renderItems();
        renderEntities();
    }
    
    private void renderEntities() {
    	RenderingRegistry.registerEntityRenderingHandler(EntityMagician.class, new EntityMagicianRenderer(new ModelMagician(), 1F));
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
        MinecraftForgeClient.registerItemRenderer(ItemRegistry.creativeWand, new CustomItemRenderer());
    	
    	//block items
    	MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockRegistry.mysticAnvil), new CustomItemRenderer());
    	MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockRegistry.wandCarver), new CustomItemRenderer());
    	MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockRegistry.tank), new CustomItemRenderer());
    }
}