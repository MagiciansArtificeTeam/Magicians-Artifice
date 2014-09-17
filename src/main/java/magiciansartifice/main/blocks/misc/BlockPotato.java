package magiciansartifice.main.blocks.misc;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import magiciansartifice.main.MagiciansArtifice;
import magiciansartifice.main.blocks.BlockRegistry;
import magiciansartifice.main.core.libs.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;

public class BlockPotato extends Block {
    public BlockPotato() {
        super(Material.cactus);
        this.setBlockTextureName(ModInfo.MODID + ":misc/potatoBlock");
        this.setBlockName("potatoBlock");
        this.setCreativeTab(MagiciansArtifice.tab);
        BlockRegistry.blocks.add(this);
    }

}
