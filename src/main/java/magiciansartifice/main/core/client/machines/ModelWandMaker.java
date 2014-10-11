package magiciansartifice.main.core.client.machines;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelWandMaker extends ModelBase {
    //fields
    ModelRenderer TableTop;
    ModelRenderer TableLeg1;
    ModelRenderer TableLeg2;
    ModelRenderer TableLeg3;
    ModelRenderer TableLeg4;
    ModelRenderer LampBase;
    ModelRenderer LampBase2;
    ModelRenderer LampPart2;
    ModelRenderer LampPart1;

    public ModelWandMaker() {
        textureWidth = 128;
        textureHeight = 64;

        TableTop = new ModelRenderer(this, 0, 0);
        TableTop.addBox(0F, 0F, 0F, 16, 4, 16);
        TableTop.setRotationPoint(-8F, 12F, -8F);
        TableTop.setTextureSize(128, 64);
        TableTop.mirror = true;
        setRotation(TableTop, 0F, 0F, 0F);
        TableLeg1 = new ModelRenderer(this, 18, 21);
        TableLeg1.addBox(0F, 0F, 0F, 2, 8, 2);
        TableLeg1.setRotationPoint(-8F, 16F, -8F);
        TableLeg1.setTextureSize(128, 64);
        TableLeg1.mirror = true;
        setRotation(TableLeg1, 0F, 0F, 0F);
        TableLeg2 = new ModelRenderer(this, 0, 21);
        TableLeg2.addBox(0F, 0F, 0F, 2, 8, 2);
        TableLeg2.setRotationPoint(6F, 16F, -8F);
        TableLeg2.setTextureSize(128, 64);
        TableLeg2.mirror = true;
        setRotation(TableLeg2, 0F, 0F, 0F);
        TableLeg3 = new ModelRenderer(this, 9, 21);
        TableLeg3.addBox(0F, 0F, 0F, 2, 8, 2);
        TableLeg3.setRotationPoint(6F, 16F, 6F);
        TableLeg3.setTextureSize(128, 64);
        TableLeg3.mirror = true;
        setRotation(TableLeg3, 0F, 0F, 0F);
        TableLeg4 = new ModelRenderer(this, 27, 21);
        TableLeg4.addBox(0F, 0F, 6F, 2, 8, 2);
        TableLeg4.setRotationPoint(-8F, 16F, 0F);
        TableLeg4.setTextureSize(128, 64);
        TableLeg4.mirror = true;
        setRotation(TableLeg4, 0F, 0F, 0F);
        LampBase = new ModelRenderer(this, 36, 21);
        LampBase.addBox(0F, -1F, 0F, 1, 9, 1);
        LampBase.setRotationPoint(-8F, 4F, -8F);
        LampBase.setTextureSize(128, 64);
        LampBase.mirror = true;
        setRotation(LampBase, 0F, 0F, 0F);
        LampBase2 = new ModelRenderer(this, 42, 21);
        LampBase2.addBox(0F, 0F, 0F, 1, 8, 1);
        LampBase2.setRotationPoint(-3F, 2F, -3F);
        LampBase2.setTextureSize(128, 64);
        LampBase2.mirror = true;
        setRotation(LampBase2, -1.32645F, 0.7853982F, 0.2617994F);
        LampPart2 = new ModelRenderer(this, 53, 21);
        LampPart2.addBox(0F, 0F, 0F, 3, 3, 3);
        LampPart2.setRotationPoint(-4F, 3F, -4F);
        LampPart2.setTextureSize(128, 64);
        LampPart2.mirror = true;
        setRotation(LampPart2, 0F, 0F, 0F);
        LampPart1 = new ModelRenderer(this, 48, 21);
        LampPart1.addBox(0F, 0F, 0F, 1, 1, 1);
        LampPart1.setRotationPoint(-3F, 2F, -3F);
        LampPart1.setTextureSize(128, 64);
        LampPart1.mirror = true;
        setRotation(LampPart1, 0F, 0F, 0F);
    }
  
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        TableTop.render(f5);
        TableLeg1.render(f5);
        TableLeg2.render(f5);
        TableLeg3.render(f5);
        TableLeg4.render(f5);
        LampBase.render(f5);
        LampBase2.render(f5);
        LampPart2.render(f5);
        LampPart1.render(f5);
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
        TableTop.render(0.625F);
        TableLeg1.render(0.625F);
        TableLeg2.render(0.625F);
        TableLeg3.render(0.625F);
        TableLeg4.render(0.625F);
        LampBase.render(0.625F);
        LampBase2.render(0.625F);
        LampPart2.render(0.625F);
        LampPart1.render(0.625F);
    }
}
