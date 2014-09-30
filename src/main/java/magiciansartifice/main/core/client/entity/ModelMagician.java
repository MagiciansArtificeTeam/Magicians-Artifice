package magiciansartifice.main.core.client.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelMagician extends ModelBase
{
  //fields
    ModelRenderer rightLeg;
    ModelRenderer leftLeg;
    ModelRenderer body;
    ModelRenderer arms;
    ModelRenderer head;
    ModelRenderer nose;
    ModelRenderer hatBrim;
    ModelRenderer hatLayer1;
    ModelRenderer hatLayer2;
    ModelRenderer hatLayer3;
    ModelRenderer hatLayer4;
    ModelRenderer hatLayer5;
  
  public ModelMagician()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      rightLeg = new ModelRenderer(this, 16, 48);
      rightLeg.addBox(-2F, 0F, -2F, 4, 12, 4);
      rightLeg.setRotationPoint(-2F, 12F, 0F);
      rightLeg.setTextureSize(128, 64);
      rightLeg.mirror = true;
      setRotation(rightLeg, 0F, 0F, 0F);
      leftLeg = new ModelRenderer(this, 0, 48);
      leftLeg.addBox(-2F, 0F, -2F, 4, 12, 4);
      leftLeg.setRotationPoint(2F, 12F, 0F);
      leftLeg.setTextureSize(128, 64);
      leftLeg.mirror = true;
      setRotation(leftLeg, 0F, 0F, 0F);
      body = new ModelRenderer(this, 32, 40);
      body.addBox(-5F, 0F, -3F, 10, 18, 6);
      body.setRotationPoint(0F, 2F, 0F);
      body.setTextureSize(128, 64);
      body.mirror = true;
      setRotation(body, 0F, 0F, 0F);
      arms = new ModelRenderer(this, 64, 52);
      arms.addBox(-8F, -2F, -8F, 16, 4, 8);
      arms.setRotationPoint(0F, 5F, 0F);
      arms.setTextureSize(128, 64);
      arms.mirror = true;
      setRotation(arms, 0.8004762F, 0F, 0F);
      head = new ModelRenderer(this, 80, 34);
      head.addBox(-4F, -11F, -4F, 8, 10, 8);
      head.setRotationPoint(0F, 3F, 0F);
      head.setTextureSize(128, 64);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      nose = new ModelRenderer(this, 112, 58);
      nose.addBox(-1F, -1F, -2F, 2, 4, 2);
      nose.setRotationPoint(0F, 0F, -4F);
      nose.setTextureSize(128, 64);
      nose.mirror = true;
      setRotation(nose, 0F, 0F, 0F);
      hatBrim = new ModelRenderer(this, -1, 27);
      hatBrim.addBox(-7F, 0F, -7F, 14, 1, 14);
      hatBrim.setRotationPoint(0F, -6F, 0F);
      hatBrim.setTextureSize(128, 64);
      hatBrim.mirror = true;
      setRotation(hatBrim, 0F, 0F, 0F);
      hatLayer1 = new ModelRenderer(this, 0, 15);
      hatLayer1.addBox(-5F, -3F, -5F, 10, 2, 10);
      hatLayer1.setRotationPoint(0F, -5F, 0F);
      hatLayer1.setTextureSize(128, 64);
      hatLayer1.mirror = true;
      setRotation(hatLayer1, 0F, 0F, 0F);
      hatLayer2 = new ModelRenderer(this, 40, 15);
      hatLayer2.addBox(-4F, -3F, -4F, 8, 4, 8);
      hatLayer2.setRotationPoint(0F, -9F, 0F);
      hatLayer2.setTextureSize(128, 64);
      hatLayer2.mirror = true;
      setRotation(hatLayer2, 0F, 0F, 0F);
      hatLayer3 = new ModelRenderer(this, 0, 4);
      hatLayer3.addBox(-3F, -5F, -3F, 6, 5, 6);
      hatLayer3.setRotationPoint(0F, -11F, 0F);
      hatLayer3.setTextureSize(128, 64);
      hatLayer3.mirror = true;
      setRotation(hatLayer3, -0.0743572F, 0F, 0F);
      hatLayer4 = new ModelRenderer(this, 24, 6);
      hatLayer4.addBox(-2F, -5F, -2F, 4, 5, 4);
      hatLayer4.setRotationPoint(0F, -15F, 0F);
      hatLayer4.setTextureSize(128, 64);
      hatLayer4.mirror = true;
      setRotation(hatLayer4, -0.2230717F, 0F, 0F);
      hatLayer5 = new ModelRenderer(this, 40, 9);
      hatLayer5.addBox(-1F, -4F, -1F, 2, 4, 2);
      hatLayer5.setRotationPoint(0F, -19F, 1F);
      hatLayer5.setTextureSize(128, 64);
      hatLayer5.mirror = true;
      setRotation(hatLayer5, -0.6320364F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    rightLeg.render(f5);
    leftLeg.render(f5);
    body.render(f5);
    arms.render(f5);
    head.render(f5);
    nose.render(f5);
    hatBrim.render(f5);
    hatLayer1.render(f5);
    hatLayer2.render(f5);
    hatLayer3.render(f5);
    hatLayer4.render(f5);
    hatLayer5.render(f5);
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
    this.leftLeg.rotateAngleX = MathHelper.cos(f * 0.75F) * 0.7F * f1;
    this.rightLeg.rotateAngleX = MathHelper.cos(f * 0.75F + (float)Math.PI) * 0.7F * f1;
  }
}