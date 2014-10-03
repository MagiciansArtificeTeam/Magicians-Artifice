package magiciansartifice.main.core.client.entity.boss;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelOverworldBoss extends ModelBase {
	//fields
    ModelRenderer leftLeg;
    ModelRenderer rightLeg;
    ModelRenderer body;
    ModelRenderer leftArm;
    ModelRenderer rightArm;
    ModelRenderer head;
    ModelRenderer capeLeft;
    ModelRenderer capeRight;
    ModelRenderer hood;
    ModelRenderer belt;
    ModelRenderer staff;
    ModelRenderer beltPouch;
  
    public ModelOverworldBoss() {
	  	textureWidth = 128;
    	textureHeight = 64;
    
      	leftLeg = new ModelRenderer(this, 111, 44);
      	leftLeg.addBox(-2F, 0F, -2F, 4, 16, 4);
      	leftLeg.setRotationPoint(2F, 8F, 0F);
      	leftLeg.setTextureSize(128, 64);
      	leftLeg.mirror = true;
      	setRotation(leftLeg, 0F, 0F, 0F);
      	rightLeg = new ModelRenderer(this, 94, 44);
      	rightLeg.addBox(-2F, 0F, -2F, 4, 16, 4);
      	rightLeg.setRotationPoint(-2F, 8F, 0F);
      	rightLeg.setTextureSize(128, 64);
      	rightLeg.mirror = true;
      	setRotation(rightLeg, 0F, 0F, 0F);
      	body = new ModelRenderer(this, 103, 10);
      	body.addBox(-4F, -6F, -2F, 8, 12, 4);
      	body.setRotationPoint(0F, 2F, 0F);
      	body.setTextureSize(128, 64);
      	body.mirror = true;
      	setRotation(body, 0F, 0F, 0F);
      	leftArm = new ModelRenderer(this, 115, 27);
      	leftArm.addBox(-1.5F, 0F, -1.5F, 3, 13, 3);
      	leftArm.setRotationPoint(5.5F, -4F, 0F);
      	leftArm.setTextureSize(128, 64);
      	leftArm.mirror = true;
      	setRotation(leftArm, 0F, 0F, -0.1115358F);
      	rightArm = new ModelRenderer(this, 102, 27);
      	rightArm.addBox(-1.5F, 0F, -1.5F, 3, 13, 3);
      	rightArm.setRotationPoint(-5.5F, -4F, 0F);
      	rightArm.setTextureSize(128, 64);
      	rightArm.mirror = true;
      	setRotation(rightArm, -0.9294653F, 0F, 0.1115358F);
      	head = new ModelRenderer(this, 67, 51);
      	head.addBox(-3.5F, -7F, -3F, 7, 7, 6);
      	head.setRotationPoint(0F, -4F, 0F);
      	head.setTextureSize(128, 64);
      	head.mirror = true;
      	setRotation(head, 0F, 0F, 0F);
      	capeLeft = new ModelRenderer(this, 89, 13);
      	capeLeft.addBox(0F, 0F, 0F, 5, 28, 1);
      	capeLeft.setRotationPoint(0F, -4F, 2F);
      	capeLeft.setTextureSize(128, 64);
      	capeLeft.mirror = true;
      	setRotation(capeLeft, 0.2602503F, 0.3346075F, -0.0743572F);
      	capeRight = new ModelRenderer(this, 76, 13);
      	capeRight.addBox(-5F, 0F, 0F, 5, 28, 1);
      	capeRight.setRotationPoint(0F, -4F, 2F);
      	capeRight.setTextureSize(128, 64);
      	capeRight.mirror = true;
      	setRotation(capeRight, 0.2602503F, -0.2974289F, 0.0743572F);
      	hood = new ModelRenderer(this, 97, 1);
      	hood.addBox(-5F, 0F, 0F, 10, 3, 5);
      	hood.setRotationPoint(0F, -6F, 0F);
      	hood.setTextureSize(128, 64);
      	hood.mirror = true;
      	setRotation(hood, 0F, 0F, 0F);
      	belt = new ModelRenderer(this, 67, 2);
      	belt.addBox(-4.5F, -1F, -2.5F, 9, 2, 5);
      	belt.setRotationPoint(0F, 6F, 0F);
      	belt.setTextureSize(128, 64);
      	belt.mirror = true;
      	setRotation(belt, 0F, 0F, 0F);
      	staff = new ModelRenderer(this, 69, 16);
      	staff.addBox(0F, -10F, 0F, 1, 30, 1);
      	staff.setRotationPoint(-6F, 3F, -10F);
      	staff.setTextureSize(128, 64);
      	staff.mirror = true;
      	setRotation(staff, 0.4461433F, -0.2230717F, 0.1487144F);
      	beltPouch = new ModelRenderer(this, 83, 44);
      	beltPouch.addBox(0F, 0F, -1F, 1, 4, 2);
      	beltPouch.setRotationPoint(4F, 4F, 0F);
      	beltPouch.setTextureSize(128, 64);
      	beltPouch.mirror = true;
      	setRotation(beltPouch, 0F, 0F, 0F);
  	}
  
  	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
  		super.render(entity, f, f1, f2, f3, f4, f5);
    	setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    	leftLeg.render(f5);
    	rightLeg.render(f5);
    	body.render(f5);
    	leftArm.render(f5);
    	rightArm.render(f5);
    	head.render(f5);
    	capeLeft.render(f5);
    	capeRight.render(f5);
    	hood.render(f5);
    	belt.render(f5);
    	staff.render(f5);
    	beltPouch.render(f5);
  	}
  
  	private void setRotation(ModelRenderer model, float x, float y, float z) {
	  	model.rotateAngleX = x;
	  	model.rotateAngleY = y;
	  	model.rotateAngleZ = z;
  	}
  
  	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
  		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  		this.head.rotateAngleY = f4 / (180F / (float)Math.PI);
  	    this.head.rotateAngleX = f5 / (180F / (float)Math.PI);
  	    this.rightLeg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
  	    this.leftLeg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
  	    this.leftArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F;
  	    //this.rightArm.rotateAngleX = MathHelper.cos(f * 1.5F + (float)Math.PI) * 1.4F * f1;
  	    //this.staff.rotateAngleX = MathHelper.cos(f * 1.5F + (float)Math.PI) * 1.4F * f1;
  	}
}