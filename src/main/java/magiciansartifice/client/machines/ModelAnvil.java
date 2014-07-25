package magiciansartifice.client.machines;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelAnvil extends ModelBase {
    //fields
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;

    public ModelAnvil() {
        textureWidth = 64;
        textureHeight = 32;

        Shape1 = new ModelRenderer(this, 0, 0);
        Shape1.addBox(0F, 0F, 0F, 16, 6, 10);
        Shape1.setRotationPoint(-8F, 8F, -5F);
        Shape1.setTextureSize(64, 32);
        Shape1.mirror = true;
        setRotation(Shape1, 0F, 0F, 0F);
        Shape1.mirror = false;
        Shape2 = new ModelRenderer(this, 5, 16);
        Shape2.addBox(0F, 0F, 0F, 8, 5, 4);
        Shape2.setRotationPoint(-4F, 14F, -2F);
        Shape2.setTextureSize(64, 32);
        Shape2.mirror = true;
        setRotation(Shape2, 0F, 0F, 0F);
        Shape2.mirror = false;
        Shape3 = new ModelRenderer(this, 0, 23);
        Shape3.addBox(0F, 0F, 0F, 10, 1, 8);
        Shape3.setRotationPoint(-5F, 19F, -4F);
        Shape3.setTextureSize(64, 32);
        Shape3.mirror = true;
        setRotation(Shape3, 0F, 0F, 0F);
        Shape3.mirror = false;
        Shape4 = new ModelRenderer(this, 0, 16);
        Shape4.addBox(0F, 0F, 0F, 12, 4, 12);
        Shape4.setRotationPoint(-6F, 20F, -6F);
        Shape4.setTextureSize(64, 32);
        Shape4.mirror = true;
        setRotation(Shape4, 0F, 0F, 0F);
        Shape4.mirror = false;
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        Shape1.render(f5);
        Shape2.render(f5);
        Shape3.render(f5);
        Shape4.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }

    public void renderAll(){
        this.Shape1.render(0.625F);
        this.Shape2.render(0.625F);
        this.Shape3.render(0.625F);
        this.Shape4.render(0.625F);
    }

}
