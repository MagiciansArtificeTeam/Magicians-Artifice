package magiciansartifice.main.core.client.magicalblocks;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelPedestal extends ModelBase {
    public ModelRenderer Connector;
    public ModelRenderer Top;
    public ModelRenderer ConnectorTop;
    public ModelRenderer Base;
    public ModelRenderer BaseStair1;
    public ModelRenderer BaseStair2;

    public ModelPedestal() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.Top = new ModelRenderer(this, 57, 0);
        this.Top.setRotationPoint(-6.0F, 8.0F, -6.0F);
        this.Top.addBox(0.0F, 0.0F, 0.0F, 12, 3, 12);
        this.Base = new ModelRenderer(this, 0, 0);
        this.Base.setRotationPoint(-7.0F, 21.0F, -7.0F);
        this.Base.addBox(0.0F, 0.0F, 0.0F, 14, 3, 14);
        this.BaseStair2 = new ModelRenderer(this, 0, 32);
        this.BaseStair2.setRotationPoint(-6.0F, 20.0F, -6.0F);
        this.BaseStair2.addBox(0.0F, 0.0F, 0.0F, 12, 1, 12);
        this.Connector = new ModelRenderer(this, 41, 18);
        this.Connector.setRotationPoint(-4.0F, 11.0F, -4.0F);
        this.Connector.addBox(0.0F, 0.0F, 0.0F, 8, 10, 8);
        this.ConnectorTop = new ModelRenderer(this, 0, 19);
        this.ConnectorTop.setRotationPoint(-5.0F, 11.0F, -5.0F);
        this.ConnectorTop.addBox(0.0F, 0.0F, 0.0F, 10, 1, 10);
        this.BaseStair1 = new ModelRenderer(this, 0, 19);
        this.BaseStair1.setRotationPoint(-5.0F, 19.0F, -5.0F);
        this.BaseStair1.addBox(0.0F, 0.0F, 0.0F, 10, 1, 10);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.Top.render(f5);
        this.Base.render(f5);
        this.BaseStair2.render(f5);
        this.Connector.render(f5);
        this.ConnectorTop.render(f5);
        this.BaseStair1.render(f5);
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
        this.BaseStair1.render(0.625F);
        this.BaseStair2.render(0.625F);
    }
}
