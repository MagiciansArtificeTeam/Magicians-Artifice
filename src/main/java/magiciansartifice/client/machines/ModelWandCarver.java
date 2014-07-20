package magiciansartifice.client.machines;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelWandCarver extends ModelBase {
    //fields
    ModelRenderer BaseShape;
    ModelRenderer WoodHolder2;
    ModelRenderer WoodHolder1;
    ModelRenderer Saw2;
    ModelRenderer Saw;
    ModelRenderer Saw2A;
    ModelRenderer SawA;
    ModelRenderer SawArmA;
    ModelRenderer SawArm2A;
    ModelRenderer SawArmB;
    ModelRenderer SawArm2B;

    public ModelWandCarver() {
        textureWidth = 64;
        textureHeight = 32;

        BaseShape = new ModelRenderer(this, 0, 0);
        BaseShape.addBox(0F, 0F, 0F, 14, 9, 14);
        BaseShape.setRotationPoint(-7F, 15F, -7F);
        BaseShape.setTextureSize(64, 32);
        BaseShape.mirror = true;
        setRotation(BaseShape, 0F, 0F, 0F);
        BaseShape.mirror = false;
        WoodHolder2 = new ModelRenderer(this, 0, 29);
        WoodHolder2.addBox(0F, 0F, 0F, 8, 1, 1);
        WoodHolder2.setRotationPoint(-4F, 14F, -3F);
        WoodHolder2.setTextureSize(64, 32);
        WoodHolder2.mirror = true;
        setRotation(WoodHolder2, 0F, 0F, 0F);
        WoodHolder2.mirror = false;
        WoodHolder1 = new ModelRenderer(this, 19, 29);
        WoodHolder1.addBox(-4F, 14F, 2F, 8, 1, 1);
        WoodHolder1.setRotationPoint(0F, 0F, 0F);
        WoodHolder1.setTextureSize(64, 32);
        WoodHolder1.mirror = true;
        setRotation(WoodHolder1, 0F, 0F, 0F);
        WoodHolder1.mirror = false;
        Saw2 = new ModelRenderer(this, 0, 24);
        Saw2.addBox(0F, 0F, 0F, 3, 3, 1);
        Saw2.setRotationPoint(-4F, 9F, 1F);
        Saw2.setTextureSize(64, 32);
        Saw2.mirror = true;
        setRotation(Saw2, 0F, 0F, 0F);
        Saw2.mirror = false;
        Saw = new ModelRenderer(this, 9, 24);
        Saw.addBox(0F, 0F, 0F, 3, 3, 1);
        Saw.setRotationPoint(-2.5F, 8.5F, 1F);
        Saw.setTextureSize(64, 32);
        Saw.mirror = true;
        setRotation(Saw, 0F, 0F, 0.7853982F);
        Saw.mirror = false;
        Saw2A = new ModelRenderer(this, 18, 24);
        Saw2A.addBox(0F, 0F, 0F, 3, 3, 1);
        Saw2A.setRotationPoint(1F, 9F, -2F);
        Saw2A.setTextureSize(64, 32);
        Saw2A.mirror = true;
        setRotation(Saw2A, 0F, 0F, 0F);
        Saw2A.mirror = false;
        SawA = new ModelRenderer(this, 27, 24);
        SawA.addBox(0F, 0F, 0F, 3, 3, 1);
        SawA.setRotationPoint(2.5F, 8.5F, -2F);
        SawA.setTextureSize(64, 32);
        SawA.mirror = true;
        setRotation(SawA, 0F, 0F, 0.7853982F);
        SawA.mirror = false;
        SawArmA = new ModelRenderer(this, 38, 24);
        SawArmA.addBox(0F, 0F, 0F, 1, 4, 1);
        SawArmA.setRotationPoint(-6F, 11F, 1F);
        SawArmA.setTextureSize(64, 32);
        SawArmA.mirror = true;
        setRotation(SawArmA, 0F, 0F, 0F);
        SawArmA.mirror = false;
        SawArm2A = new ModelRenderer(this, 48, 24);
        SawArm2A.addBox(0F, 0F, 0F, 1, 4, 1);
        SawArm2A.setRotationPoint(5F, 11F, -2F);
        SawArm2A.setTextureSize(64, 32);
        SawArm2A.mirror = true;
        setRotation(SawArm2A, 0F, 0F, 0F);
        SawArm2A.mirror = false;
        SawArmB = new ModelRenderer(this, 43, 24);
        SawArmB.addBox(0F, 0F, 0F, 1, 3, 1);
        SawArmB.setRotationPoint(-3.4F, 9.5F, 1F);
        SawArmB.setTextureSize(64, 32);
        SawArmB.mirror = true;
        setRotation(SawArmB, 0F, 0F, 1.047198F);
        SawArmB.mirror = false;
        SawArm2B = new ModelRenderer(this, 53, 24);
        SawArm2B.addBox(0F, 0F, 0F, 1, 3, 1);
        SawArm2B.setRotationPoint(2.9F, 10.3F, -2F);
        SawArm2B.setTextureSize(64, 32);
        SawArm2B.mirror = true;
        setRotation(SawArm2B, 0F, 0F, -1.047198F);
        SawArm2B.mirror = false;
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        BaseShape.render(f5);
        WoodHolder2.render(f5);
        WoodHolder1.render(f5);
        Saw2.render(f5);
        Saw.render(f5);
        Saw2A.render(f5);
        SawA.render(f5);
        SawArmA.render(f5);
        SawArm2A.render(f5);
        SawArmB.render(f5);
        SawArm2B.render(f5);
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
        this.BaseShape.render(0.625F);
        this.WoodHolder2.render(0.625F);
        this.WoodHolder1.render(0.625F);
        this.Saw2.render(0.625F);
        this.Saw.render(0.625F);
        this.SawA.render(0.625F);
        this.SawArmA.render(0.625F);
        this.SawArm2A.render(0.625F);
        this.SawArmB.render(0.625F);
        this.SawArm2B.render(0.625F);
    }

}
