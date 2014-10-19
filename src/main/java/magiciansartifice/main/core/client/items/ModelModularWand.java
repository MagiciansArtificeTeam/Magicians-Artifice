package magiciansartifice.main.core.client.items;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelModularWand extends ModelBase {
    ModelRenderer wandHilt;
    ModelRenderer wandBase;
    ModelRenderer wandShaft;
  
    public ModelModularWand() {
          textureWidth = 64;
          textureHeight = 32;
    
          wandHilt = new ModelRenderer(this, 0, 0);
          wandHilt.addBox(0F, 0F, 0F, 3, 1, 3);
          wandHilt.setRotationPoint(-1F, 18F, -1F);
          wandHilt.setTextureSize(64, 32);
          wandHilt.mirror = true;
          setRotation(wandHilt, 0F, 0F, 0F);
          wandBase = new ModelRenderer(this, 0, 0);
          wandBase.addBox(0F, 0F, 0F, 3, 1, 3);
          wandBase.setRotationPoint(-1F, 23F, -1F);
          wandBase.setTextureSize(64, 32);
          wandBase.mirror = true;
          setRotation(wandBase, 0F, 0F, 0F);
          wandShaft = new ModelRenderer(this, 0, 7);
          wandShaft.addBox(0F, 0F, 0F, 1, 24, 1);
          wandShaft.setRotationPoint(0F, 0F, 0F);
          wandShaft.setTextureSize(64, 32);
          wandShaft.mirror = true;
          setRotation(wandShaft, 0F, 0F, 0F);
    }
  
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        wandHilt.render(f5);
        wandBase.render(f5);
        wandShaft.render(f5);
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
        this.wandHilt.render(0.625F);
        this.wandBase.render(0.625F);
        this.wandShaft.render(0.625F);
    }
}
