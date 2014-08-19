package magiciansartifice.main.core.proxies;

import cpw.mods.fml.client.registry.ClientRegistry;
import magiciansartifice.main.blocks.BlockRegistry;
import magiciansartifice.main.core.client.CustomItemRenderer;
import magiciansartifice.main.core.client.machines.RenderAnvil;
import magiciansartifice.main.core.client.machines.RenderWandCarver;
import magiciansartifice.main.tileentities.machines.TileEntityMysticAnvil;
import magiciansartifice.main.tileentities.machines.TileEntityWandCarver;
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
    }

}