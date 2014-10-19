package magiciansartifice.main.tileentities.magic;

import magiciansartifice.main.core.utils.EntityHelper;
import magiciansartifice.main.entities.pets.EntityPetDragon;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Vec3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by poppypoppop on 5/10/2014.
 */
public class TileEntityDragonAltar extends TileEntity {

    @Override
    @SuppressWarnings("unchecked")
    public void updateEntity() {
        super.updateEntity();
        List<Entity> entities = worldObj.loadedEntityList;
        for (Entity entity : entities) {
            if (entity instanceof EntityPetDragon) {
                Vec3 entityLoc = Vec3.createVectorHelper(entity.posX,entity.posY,entity.posZ);
                Vec3 loc = Vec3.createVectorHelper(this.xCoord,this.yCoord,this.zCoord);
                if (entityLoc.distanceTo(loc) <= 5) {
                    worldObj.setBlockMetadataWithNotify(xCoord,yCoord,zCoord,1,3);
                } else {
                    worldObj.setBlockMetadataWithNotify(xCoord,yCoord,zCoord,0,3);
                }
                break;
            }
        }
    }
}
