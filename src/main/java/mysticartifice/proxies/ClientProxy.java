package mysticartifice.proxies;

import cpw.mods.fml.client.registry.ClientRegistry;
import mysticartifice.blocks.BlockRegistry;
import mysticartifice.client.CustomItemRenderer;
import mysticartifice.client.machines.RenderAnvil;
import mysticartifice.tileentities.TileEntityMysticAnvil;
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