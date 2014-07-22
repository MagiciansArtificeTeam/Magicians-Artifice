package magiciansartifice.client.items;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Created by poppypoppop on 22/07/2014.
 */
public class ModelWand extends ModelBase {
    //fields
    ModelRenderer Shape1;

    public ModelWand() {
        textureWidth = 64;
        textureHeight = 32;

        Shape1 = new ModelRenderer(this, 0, 0);
        Shape1.addBox(-1F, 0F, -1F, 2, 16, 2);
        Shape1.setRotationPoint(0F, 8F, 0F);
        Shape1.setTextureSize(64, 32);
        Shape1.mirror = true;
        setRotation(Shape1, 0F, 0F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        Shape1.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }

    public void renderAll() {
        Shape1.render(0.625F);
    }
}
