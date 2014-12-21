package magiciansartifice.main.core.client.magicalblocks;

import magiciansartifice.main.core.proxies.ClientProxy;
import magiciansartifice.main.tileentities.magic.TileEntityMerlinCircle;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class MerlinsCircleRenderer implements ISimpleBlockRenderingHandler {

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
		return;
	}

	@Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
            if(ClientProxy.renderPass == 0) {
            	if ((((TileEntityMerlinCircle)world.getTileEntity(x, y, z)).getItemStack() == null)) {
            		return false;
            	}
                renderer.renderStandardBlock(Block.getBlockFromItem(
                		((TileEntityMerlinCircle)world.getTileEntity(x, y, z)).getItemStack().getItem()), x, y, z);
            } else {
                renderer.renderStandardBlock(block, x, y, z);
            }
           
            return true;
    }

	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		return true;
	}

	@Override
	public int getRenderId() {
		return ClientProxy.merlinsCircleRenderer;
	}

}
