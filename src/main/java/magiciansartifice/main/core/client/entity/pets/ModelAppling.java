package magiciansartifice.main.core.client.entity.pets;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Created by poppypoppop on 4/10/2014.
 */
public class ModelAppling extends ModelBase {
    //fields
    ModelRenderer base1_4;
    ModelRenderer base2_4;
    ModelRenderer base3_4;
    ModelRenderer base4_4;
    ModelRenderer layer1;
    ModelRenderer layer2;
    ModelRenderer layer3;
    ModelRenderer layer4;
    ModelRenderer layer5;
    ModelRenderer layer6;
    ModelRenderer stem1_2;
    ModelRenderer stem2_2;
    ModelRenderer Shape1;
    ModelRenderer Shape2;

    public ModelAppling() {
        textureWidth = 128;
        textureHeight = 64;

        base1_4 = new ModelRenderer(this, 120, 61);
        base1_4.addBox(-1F, 0F, -1F, 2, 1, 2);
        base1_4.setRotationPoint(2F, 20F, -2F);
        base1_4.setTextureSize(128, 64);
        base1_4.mirror = true;
        setRotation(base1_4, 0F, 0F, 0F);
        base2_4 = new ModelRenderer(this, 120, 61);
        base2_4.addBox(-1F, 0F, -1F, 2, 1, 2);
        base2_4.setRotationPoint(-2F, 20F, -2F);
        base2_4.setTextureSize(128, 64);
        base2_4.mirror = true;
        setRotation(base2_4, 0F, 0F, 0F);
        base3_4 = new ModelRenderer(this, 120, 61);
        base3_4.addBox(-1F, 0F, -1F, 2, 1, 2);
        base3_4.setRotationPoint(-2F, 20F, 2F);
        base3_4.setTextureSize(128, 64);
        base3_4.mirror = true;
        setRotation(base3_4, 0F, 0F, 0F);
        base4_4 = new ModelRenderer(this, 120, 61);
        base4_4.addBox(-1F, 0F, -1F, 2, 1, 2);
        base4_4.setRotationPoint(2F, 20F, 2F);
        base4_4.setTextureSize(128, 64);
        base4_4.mirror = true;
        setRotation(base4_4, 0F, 0F, 0F);
        layer1 = new ModelRenderer(this, 96, 51);
        layer1.addBox(-4F, 0F, -4F, 8, 1, 8);
        layer1.setRotationPoint(0F, 19F, 0F);
        layer1.setTextureSize(128, 64);
        layer1.mirror = true;
        setRotation(layer1, 0F, 0F, 0F);
        layer2 = new ModelRenderer(this, 88, 39);
        layer2.addBox(-5F, -2F, -5F, 10, 2, 10);
        layer2.setRotationPoint(0F, 19F, 0F);
        layer2.setTextureSize(128, 64);
        layer2.mirror = true;
        setRotation(layer2, 0F, 0F, 0F);
        layer3 = new ModelRenderer(this, 80, 22);
        layer3.addBox(-6F, -5F, -6F, 12, 5, 12);
        layer3.setRotationPoint(0F, 17F, 0F);
        layer3.setTextureSize(128, 64);
        layer3.mirror = true;
        setRotation(layer3, 0F, 0F, 0F);
        layer4 = new ModelRenderer(this, 88, 10);
        layer4.addBox(-5F, -2F, -5F, 10, 2, 10);
        layer4.setRotationPoint(0F, 12F, 0F);
        layer4.setTextureSize(128, 64);
        layer4.mirror = true;
        setRotation(layer4, 0F, 0F, 0F);
        layer5 = new ModelRenderer(this, 96, 1);
        layer5.addBox(-4F, 0F, -4F, 8, 1, 8);
        layer5.setRotationPoint(0F, 9F, 0F);
        layer5.setTextureSize(128, 64);
        layer5.mirror = true;
        setRotation(layer5, 0F, 0F, 0F);
        layer6 = new ModelRenderer(this, 80, 1);
        layer6.addBox(-2F, 0F, -2F, 4, 1, 4);
        layer6.setRotationPoint(0F, 8F, 0F);
        layer6.setTextureSize(128, 64);
        layer6.mirror = true;
        setRotation(layer6, 0F, 0F, 0F);
        stem1_2 = new ModelRenderer(this, 115, 61);
        stem1_2.addBox(0F, 0F, 0F, 1, 2, 1);
        stem1_2.setRotationPoint(0F, 6F, 0F);
        stem1_2.setTextureSize(128, 64);
        stem1_2.mirror = true;
        setRotation(stem1_2, 0F, 0F, 0F);
        stem2_2 = new ModelRenderer(this, 115, 61);
        stem2_2.addBox(0F, 0F, 0F, 1, 2, 1);
        stem2_2.setRotationPoint(1F, 5F, 0F);
        stem2_2.setTextureSize(128, 64);
        stem2_2.mirror = true;
        setRotation(stem2_2, 0F, 0F, 0F);
        Shape1 = new ModelRenderer(this, 69, 0);
        Shape1.addBox(-1.5F, -2F, -2F, 3, 4, 2);
        Shape1.setRotationPoint(3F, 13F, -5F);
        Shape1.setTextureSize(128, 64);
        Shape1.mirror = true;
        setRotation(Shape1, 0F, 0F, 0F);
        Shape2 = new ModelRenderer(this, 56, 0);
        Shape2.addBox(-1.5F, -2F, -2F, 3, 4, 2);
        Shape2.setRotationPoint(-3F, 13F, -5F);
        Shape2.setTextureSize(128, 64);
        Shape2.mirror = true;
        setRotation(Shape2, 0F, 0F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        base1_4.render(f5);
        base2_4.render(f5);
        base3_4.render(f5);
        base4_4.render(f5);
        layer1.render(f5);
        layer2.render(f5);
        layer3.render(f5);
        layer4.render(f5);
        layer5.render(f5);
        layer6.render(f5);
        stem1_2.render(f5);
        stem2_2.render(f5);
        Shape1.render(f5);
        Shape2.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }
}