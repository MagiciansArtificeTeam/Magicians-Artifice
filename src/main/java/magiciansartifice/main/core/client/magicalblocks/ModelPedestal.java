package magiciansartifice.main.core.client.magicalblocks;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelPedestal extends ModelBase
{
    //fields
    ModelRenderer Base;
    ModelRenderer Connector;
    ModelRenderer ConnectorTop;
    ModelRenderer Top;
  
    public ModelPedestal()
    {
        textureWidth = 128;
        textureHeight = 64;
    
        Base = new ModelRenderer(this, 0, 0);
        Base.addBox(0F, 0F, 0F, 14, 3, 14);
        Base.setRotationPoint(-7F, 21F, -7F);
        Base.setTextureSize(128, 64);
        Base.mirror = true;
        setRotation(Base, 0F, 0F, 0F);
        Connector = new ModelRenderer(this, 41, 18);
        Connector.addBox(0F, 0F, 0F, 8, 10, 8);
        Connector.setRotationPoint(-4F, 11F, -4F);
        Connector.setTextureSize(128, 64);
        Connector.mirror = true;
        setRotation(Connector, 0F, 0F, 0F);
        ConnectorTop = new ModelRenderer(this, 0, 19);
        ConnectorTop.addBox(0F, 0F, 0F, 10, 1, 10);
        ConnectorTop.setRotationPoint(-5F, 11F, -5F);
        ConnectorTop.setTextureSize(128, 64);
        ConnectorTop.mirror = true;
        setRotation(ConnectorTop, 0F, 0F, 0F);
        Top = new ModelRenderer(this, 57, 0);
        Top.addBox(0F, 0F, 0F, 12, 3, 12);
        Top.setRotationPoint(-6F, 8F, -6F);
        Top.setTextureSize(128, 64);
        Top.mirror = true;
        setRotation(Top, 0F, 0F, 0F);
    }
  
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        Base.render(f5);
        Connector.render(f5);
        ConnectorTop.render(f5);
        Top.render(f5);
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

    public void renderAll()
    {
        this.Base.render(0.625F);
        this.Connector.render(0.625F);
        this.ConnectorTop.render(0.625F);
        this.Top.render(0.625F);
    }
}
