package magiciansartifice.proxies;

import cpw.mods.fml.client.registry.ClientRegistry;
import magiciansartifice.blocks.BlockRegistry;
import magiciansartifice.client.CustomItemRenderer;
import magiciansartifice.client.machines.RenderAnvil;
import magiciansartifice.tileentities.TileEntityMysticAnvil;
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
    }

}