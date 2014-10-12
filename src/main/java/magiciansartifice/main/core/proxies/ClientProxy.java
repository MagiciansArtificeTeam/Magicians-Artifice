package magiciansartifice.main.core.proxies;

import magiciansartifice.main.blocks.BlockRegistry;
import magiciansartifice.main.core.client.CustomItemRenderer;
import magiciansartifice.main.core.client.entity.*;
import magiciansartifice.main.core.client.entity.boss.*;
import magiciansartifice.main.core.client.entity.pets.*;
import magiciansartifice.main.core.client.guis.wandui.WandGUIHandler;
import magiciansartifice.main.core.client.machines.*;
import magiciansartifice.main.core.client.magicalblocks.MerlinsCircleRenderer;
import magiciansartifice.main.core.client.magicalblocks.RenderDragonAltar;
import magiciansartifice.main.core.client.magicalblocks.TEContainmentCornerstoneRenderer;
import magiciansartifice.main.entities.*;
import magiciansartifice.main.entities.bosses.*;
import magiciansartifice.main.entities.pets.*;
import magiciansartifice.main.items.ItemRegistry;
import magiciansartifice.main.tileentities.machines.*;
import magiciansartifice.main.tileentities.magic.TileEntityContainmentCornerstone;
import magiciansartifice.main.tileentities.magic.TileEntityDragonAltar;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelVillager;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;
import net.minecraftforge.fluids.FluidRegistry;

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
        renderGuis();
    }
    
    private void renderGuis() { 
    	MinecraftForge.EVENT_BUS.register(new WandGUIHandler());
    }
    
    private void renderEntities() {
    	VillagerRegistry.instance().registerVillagerSkin(MAEntityRegistry.villagerID, MAEntityRegistry.texture);
    	
    	RenderingRegistry.registerEntityRenderingHandler(EntityMagician.class, new RenderEntityMagician(new ModelMagician(), 1F));
        RenderingRegistry.registerEntityRenderingHandler(EntitySoulFragment.class, new RenderEntitySoulFragment(new ModelBiped(), 1F));
        RenderingRegistry.registerEntityRenderingHandler(EntityBossOverworld.class, new RenderBossOverworld(new ModelOverworldBoss(), 1F));
        RenderingRegistry.registerEntityRenderingHandler(EntityBossNether.class, new RenderBossNether(new ModelNetherBoss(), 1F));
        RenderingRegistry.registerEntityRenderingHandler(EntityBossEnder.class, new RenderBossEnder(new ModelEndBoss(), 1F));
        RenderingRegistry.registerEntityRenderingHandler(EntityPetPheonix.class, new RenderPetPheonix(new ModelVillager(0.0F), 1F));
        RenderingRegistry.registerEntityRenderingHandler(EntityPetAppling.class, new RenderPetAppling(new ModelAppling(), 1F));
        RenderingRegistry.registerEntityRenderingHandler(EntityPetRat.class, new RenderPetRat(new ModelVillager(0.0F), 1F));
        RenderingRegistry.registerEntityRenderingHandler(EntityPetDragon.class, new RenderPetDragon(new ModelVillager(0.0F), 1F));
    }
    
    public static int merlinsCircleRenderer = 0;
	public static int renderPass;
    
    private void renderBlocks() {
    	merlinsCircleRenderer = RenderingRegistry.getNextAvailableRenderId();
    	RenderingRegistry.registerBlockHandler(new MerlinsCircleRenderer());
    	
    	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMysticAnvil.class, new RenderAnvil());
    	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWandCarver.class, new RenderWandCarver());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMagicTank.class, new RenderTank());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityContainmentCornerstone.class,new TEContainmentCornerstoneRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDragonAltar.class, new RenderDragonAltar());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWandMaker.class, new RenderWandMaker());
    }
    
    private void renderItems() {
    	//normal items
    	MinecraftForgeClient.registerItemRenderer(ItemRegistry.magiciansWand, new CustomItemRenderer());
    	MinecraftForgeClient.registerItemRenderer(ItemRegistry.magiciansWand2, new CustomItemRenderer());
    	MinecraftForgeClient.registerItemRenderer(ItemRegistry.magiciansWand3, new CustomItemRenderer());
        MinecraftForgeClient.registerItemRenderer(ItemRegistry.creativeWand, new CustomItemRenderer());
        MinecraftForgeClient.registerItemRenderer(ItemRegistry.beastClaws, new CustomItemRenderer());
        MinecraftForgeClient.registerItemRenderer(ItemRegistry.wand, new CustomItemRenderer());
    	
    	//block items
    	MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockRegistry.mysticAnvil), new CustomItemRenderer());
    	MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockRegistry.wandCarver), new CustomItemRenderer());
    	MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockRegistry.tank), new CustomItemRenderer());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockRegistry.wandMaker), new CustomItemRenderer());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockRegistry.wandMakerLit), new CustomItemRenderer());
    }
}