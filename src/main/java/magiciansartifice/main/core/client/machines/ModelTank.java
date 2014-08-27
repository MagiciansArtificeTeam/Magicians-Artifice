package magiciansartifice.main.core.client.machines;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelTank extends ModelBase
{
    //fields
    ModelRenderer TankBase;
    ModelRenderer TankTop;
    ModelRenderer TankCentre;

    public ModelTank()
    {
        textureWidth = 128;
        textureHeight = 64;

        TankBase = new ModelRenderer(this, 0, 0);
        TankBase.addBox(0F, 0F, 0F, 14, 1, 14);
        TankBase.setRotationPoint(-7F, 23F, -7F);
        TankBase.setTextureSize(128, 64);
        TankBase.mirror = true;
        setRotation(TankBase, 0F, 0F, 0F);
        TankTop = new ModelRenderer(this, 57, 0);
        TankTop.addBox(0F, 0F, 0F, 14, 1, 14);
        TankTop.setRotationPoint(-7F, 8F, -7F);
        TankTop.setTextureSize(128, 64);
        TankTop.mirror = true;
        setRotation(TankTop, 0F, 0F, 0F);
        TankCentre = new ModelRenderer(this, 0, 18);
        TankCentre.addBox(0F, 0F, 0F, 12, 14, 12);
        TankCentre.setRotationPoint(-6F, 9F, -6F);
        TankCentre.setTextureSize(128, 64);
        TankCentre.mirror = true;
        setRotation(TankCentre, 0F, 0F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        TankBase.render(f5);
        TankTop.render(f5);
        TankCentre.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
    {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }

    public void renderAll(){
        this.TankBase.render(0.625F);
        this.TankTop.render(0.625F);
        this.TankCentre.render(0.625F);
    }
}
