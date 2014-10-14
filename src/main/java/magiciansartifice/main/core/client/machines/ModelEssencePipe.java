package magiciansartifice.main.core.client.machines;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelEssencePipe extends ModelBase {
    //fields
    ModelRenderer Left;
    ModelRenderer Top;
    ModelRenderer Center;
    ModelRenderer Right;
    ModelRenderer Bottom;
    ModelRenderer Front;
    ModelRenderer Back;

    public ModelEssencePipe() {
        textureWidth = 64;
        textureHeight = 32;

        Left = new ModelRenderer(this, 0, 20);
        Left.addBox(0F, -1F, -1F, 7, 2, 2);
        Left.setRotationPoint(-8F, 16F, 0F);
        Left.setTextureSize(64, 32);
        Left.mirror = true;
        setRotation(Left, 0F, 0F, 0F);
        Top = new ModelRenderer(this, 0, 5);
        Top.addBox(0F, -1F, -1F, 7, 2, 2);
        Top.setRotationPoint(0F, 8F, 0F);
        Top.setTextureSize(64, 32);
        Top.mirror = true;
        setRotation(Top, 0F, 0F, 1.570796F);
        Center = new ModelRenderer(this, 0, 26);
        Center.addBox(-0.5F, -1.5F, -1.5F, 3, 3, 3);
        Center.setRotationPoint(0F, 16F, -1F);
        Center.setTextureSize(64, 32);
        Center.mirror = true;
        setRotation(Center, 0F, -1.570796F, 0F);
        Right = new ModelRenderer(this, 19, 0);
        Right.addBox(0F, -1F, -1F, 7, 2, 2);
        Right.setRotationPoint(1F, 16F, 0F);
        Right.setTextureSize(64, 32);
        Right.mirror = true;
        setRotation(Right, 0F, 0F, 0F);
        Bottom = new ModelRenderer(this, 0, 10);
        Bottom.addBox(0F, -1F, -1F, 7, 2, 2);
        Bottom.setRotationPoint(0F, 17F, 0F);
        Bottom.setTextureSize(64, 32);
        Bottom.mirror = true;
        setRotation(Bottom, 0F, 0F, 1.570796F);
        Front = new ModelRenderer(this, 0, 15);
        Front.addBox(1F, -1F, -1F, 7, 2, 2);
        Front.setRotationPoint(0F, 16F, 0F);
        Front.setTextureSize(64, 32);
        Front.mirror = true;
        setRotation(Front, 0F, 1.570796F, 0F);
        Back = new ModelRenderer(this, 0, 0);
        Back.addBox(1F, -1F, -1F, 7, 2, 2);
        Back.setRotationPoint(0F, 16F, 0F);
        Back.setTextureSize(64, 32);
        Back.mirror = true;
        setRotation(Back, 0F, -1.570796F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        Left.render(f5);
        Top.render(f5);
        Center.render(f5);
        Right.render(f5);
        Bottom.render(f5);
        Front.render(f5);
        Back.render(f5);
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
        Left.render(0.625F);
        Top.render(0.625F);
        Center.render(0.625F);
        Right.render(0.625F);
        Bottom.render(0.625F);
        Front.render(0.625F);
        Back.render(0.625F);
    }

}
