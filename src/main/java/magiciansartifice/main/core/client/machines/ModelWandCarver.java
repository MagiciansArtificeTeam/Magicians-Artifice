package magiciansartifice.main.core.client.machines;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelWandCarver extends ModelBase {
    //fields
    ModelRenderer Base;
    ModelRenderer Stand;
    ModelRenderer UpperStand;
    ModelRenderer Knife;
    ModelRenderer MagnifyingGlass;
    ModelRenderer SmallerKnife;
    ModelRenderer Wood;

    public ModelWandCarver() {
        textureWidth = 256;
        textureHeight = 256;

        Base = new ModelRenderer(this, 0, 0);
        Base.addBox(0F, 0F, 0F, 16, 2, 16);
        Base.setRotationPoint(-8F, 22F, -8F);
        Base.setTextureSize(256, 256);
        Base.mirror = true;
        setRotation(Base, 0F, 0F, 0F);
        Base.mirror = false;
        Stand = new ModelRenderer(this, 64, 0);
        Stand.addBox(0F, 0F, 0F, 1, 10, 1);
        Stand.setRotationPoint(-8F, 12F, 7F);
        Stand.setTextureSize(256, 256);
        Stand.mirror = true;
        setRotation(Stand, 0F, 0F, 0F);
        Stand.mirror = false;
        UpperStand = new ModelRenderer(this, 68, 0);
        UpperStand.addBox(0F, 0F, 0F, 7, 1, 1);
        UpperStand.setRotationPoint(-8F, 12F, 7F);
        UpperStand.setTextureSize(256, 256);
        UpperStand.mirror = true;
        setRotation(UpperStand, 0F, 0.669215F, -0.1487144F);
        UpperStand.mirror = false;
        Knife = new ModelRenderer(this, 28, 18);
        Knife.addBox(0F, 0F, 0F, 1, 1, 11);
        Knife.setRotationPoint(-7F, 21F, -5F);
        Knife.setTextureSize(256, 256);
        Knife.mirror = true;
        setRotation(Knife, 0F, 0.3717861F, 0F);
        Knife.mirror = false;
        MagnifyingGlass = new ModelRenderer(this, 68, 2);
        MagnifyingGlass.addBox(0F, 0F, 0F, 6, 1, 6);
        MagnifyingGlass.setRotationPoint(-5F, 11F, -1F);
        MagnifyingGlass.setTextureSize(256, 256);
        MagnifyingGlass.mirror = true;
        setRotation(MagnifyingGlass, 0F, 0.5948578F, 0F);
        MagnifyingGlass.mirror = false;
        SmallerKnife = new ModelRenderer(this, 28, 30);
        SmallerKnife.addBox(0F, 0F, 0F, 5, 1, 1);
        SmallerKnife.setRotationPoint(4F, 21F, 0F);
        SmallerKnife.setTextureSize(256, 256);
        SmallerKnife.mirror = true;
        setRotation(SmallerKnife, 0F, 1.115358F, 0F);
        SmallerKnife.mirror = false;
        Wood = new ModelRenderer(this, 0, 18);
        Wood.addBox(0F, 0F, 0F, 2, 2, 12);
        Wood.setRotationPoint(-1F, 20F, -6F);
        Wood.setTextureSize(256, 256);
        Wood.mirror = true;
        setRotation(Wood, 0F, 0.0743572F, 0F);
        Wood.mirror = false;
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        Base.render(f5);
        Stand.render(f5);
        UpperStand.render(f5);
        Knife.render(f5);
        MagnifyingGlass.render(f5);
        SmallerKnife.render(f5);
        Wood.render(f5);
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
        this.Base.render(0.625F);
        this.Stand.render(0.625F);
        this.UpperStand.render(0.625F);
        this.Knife.render(0.625F);
        this.MagnifyingGlass.render(0.625F);
        this.SmallerKnife.render(0.625F);
        this.Wood.render(0.625F);
    }
}