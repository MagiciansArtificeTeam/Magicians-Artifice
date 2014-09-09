package magiciansartifice.main.magic.spells;

import magiciansartifice.api.BasicSpell;
import magiciansartifice.main.blocks.magicblocks.BlockRitualContainmentCornerstone;
import magiciansartifice.main.tileentities.magic.TileEntityContainmentCornerstone;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class ContainSpell extends BasicSpell{

    public void beginSpell(World world, int x, int y, int z, EntityPlayer player) {
        super.beginSpell(world, x, y, z, player);
    }

    @Override
    public void performEffect(World world, int x, int y, int z, EntityPlayer player) {
        for (int xx = x-10; xx < x + 10;xx++) {
            for (int yy = y-10; yy < y + 10; yy++) {
                for (int zz = z-10;zz < z + 10; zz++) {
                    if (world.getBlock(xx,yy,zz) instanceof BlockRitualContainmentCornerstone) {
                        super.performEffect(world, x, y, z, player);
                        TileEntityContainmentCornerstone te = (TileEntityContainmentCornerstone) world.getTileEntity(xx,yy,zz);
                        te.createField(world,player,xx,yy,zz);
                        break;
                    } else {
                    }
                }
            }
        }
    }
}
