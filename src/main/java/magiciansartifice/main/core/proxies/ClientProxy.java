package magiciansartifice.main.core.proxies;

import cpw.mods.fml.client.registry.ClientRegistry;
import magiciansartifice.main.blocks.BlockRegistry;
import magiciansartifice.main.core.client.CustomItemRenderer;
import magiciansartifice.main.core.client.machines.*;
import magiciansartifice.main.tileentities.machines.*;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy {

    @Override
    public void initSounds() {
    }

    @Override
    public void initRenderers() {
        super.initRenderers();
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMysticAnvil.class, new RenderAnvil());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockRegistry.mysticAnvil), new CustomItemRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWandCarver.class, new RenderWandCarver());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockRegistry.wandCarver), new CustomItemRenderer());
        //MinecraftForgeClient.registerItemRenderer(ItemRegistry.magiciansWand, new CustomItemRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMagicTank.class, new RenderTank());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockRegistry.tank), new CustomItemRenderer());
    }

}