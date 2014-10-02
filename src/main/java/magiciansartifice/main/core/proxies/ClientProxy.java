package magiciansartifice.main.core.proxies;

import magiciansartifice.main.blocks.BlockRegistry;
import magiciansartifice.main.core.client.CustomItemRenderer;
import magiciansartifice.main.core.client.entity.*;
import magiciansartifice.main.core.client.entity.boss.ModelOverworldBoss;
import magiciansartifice.main.core.client.entity.boss.RenderBossEnder;
import magiciansartifice.main.core.client.entity.boss.RenderBossNether;
import magiciansartifice.main.core.client.entity.boss.RenderBossOverworld;
import magiciansartifice.main.core.client.entity.pets.RenderPetPheonix;
import magiciansartifice.main.core.client.machines.*;
import magiciansartifice.main.core.client.magicalblocks.TEContainmentCornerstoneRenderer;
import magiciansartifice.main.entities.*;
import magiciansartifice.main.entities.bosses.*;
import magiciansartifice.main.entities.pets.EntityPetPheonix;
import magiciansartifice.main.items.ItemRegistry;
import magiciansartifice.main.tileentities.machines.*;
import magiciansartifice.main.tileentities.magic.TileEntityContainmentCornerstone;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelWolf;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;

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
    	VillagerRegistry.instance().registerVillagerSkin(MAEntityRegistry.villagerID, MAEntityRegistry.texture);
    	
    	RenderingRegistry.registerEntityRenderingHandler(EntityMagician.class, new RenderEntityMagician(new ModelMagician(), 1F));
        RenderingRegistry.registerEntityRenderingHandler(EntitySoulFragment.class, new RenderEntitySoulFragment(new ModelBiped(), 1F));
        RenderingRegistry.registerEntityRenderingHandler(EntityBossOverworld.class, new RenderBossOverworld(new ModelOverworldBoss(), 1F));
        RenderingRegistry.registerEntityRenderingHandler(EntityBossNether.class, new RenderBossNether(new ModelBiped(), 1F));
        RenderingRegistry.registerEntityRenderingHandler(EntityBossEnder.class, new RenderBossEnder(new ModelBiped(), 1F));
        RenderingRegistry.registerEntityRenderingHandler(EntityPetPheonix.class, new RenderPetPheonix(new ModelWolf(), 1F));
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
        MinecraftForgeClient.registerItemRenderer(ItemRegistry.beastClaw, new CustomItemRenderer());
    	
    	//block items
    	MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockRegistry.mysticAnvil), new CustomItemRenderer());
    	MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockRegistry.wandCarver), new CustomItemRenderer());
    	MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockRegistry.tank), new CustomItemRenderer());
    }
}