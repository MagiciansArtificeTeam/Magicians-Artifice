package magiciansartifice.main.core.client.entity.boss;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Created by poppypoppop on 4/10/2014.
 */
public class ModelEndBoss extends ModelBase {
    //fields
    ModelRenderer legRight;
    ModelRenderer legLeft;
    ModelRenderer body;
    ModelRenderer armRight;
    ModelRenderer armLeft;
    ModelRenderer shoulders;
    ModelRenderer head;
    ModelRenderer headTopper1;
    ModelRenderer headTopper2;
    ModelRenderer headArm1;
    ModelRenderer headArm2;
    ModelRenderer eyeball;
    ModelRenderer leftClaw1;
    ModelRenderer leftClaw2;
    ModelRenderer leftClaw3;
    ModelRenderer rightClaw1;
    ModelRenderer rightClaw2;
    ModelRenderer rightClaw3;

    public ModelEndBoss() {
        textureWidth = 128;
        textureHeight = 64;

        legRight = new ModelRenderer(this, 103, 28);
        legRight.addBox(-3F, 0F, -3F, 6, 30, 6);
        legRight.setRotationPoint(-4F, -6F, 0F);
        legRight.setTextureSize(128, 64);
        legRight.mirror = true;
        setRotation(legRight, 0F, 0F, 0F);
        legLeft = new ModelRenderer(this, 103, 28);
        legLeft.addBox(-3F, 0F, -3F, 6, 30, 6);
        legLeft.setRotationPoint(4F, -6F, 0F);
        legLeft.setTextureSize(128, 64);
        legLeft.mirror = true;
        setRotation(legLeft, 0F, 0F, 0F);
        body = new ModelRenderer(this, 68, 37);
        body.addBox(-6F, 0F, -2.5F, 12, 22, 5);
        body.setRotationPoint(0F, -26F, 0F);
        body.setTextureSize(128, 64);
        body.mirror = true;
        setRotation(body, 0F, 0F, 0F);
        armRight = new ModelRenderer(this, 110, 0);
        armRight.addBox(-4F, -2F, -2F, 4, 20, 4);
        armRight.setRotationPoint(-7F, -25F, 0F);
        armRight.setTextureSize(128, 64);
        armRight.mirror = true;
        setRotation(armRight, 0F, 0F, 0F);
        armLeft = new ModelRenderer(this, 110, 0);
        armLeft.addBox(0F, -2F, -2F, 4, 20, 4);
        armLeft.setRotationPoint(7F, -25F, 0F);
        armLeft.setTextureSize(128, 64);
        armLeft.mirror = true;
        setRotation(armLeft, 0F, 0F, 0F);
        shoulders = new ModelRenderer(this, 60, 27);
        shoulders.addBox(-7.5F, 0F, -3F, 15, 3, 6);
        shoulders.setRotationPoint(0F, -27F, 0F);
        shoulders.setTextureSize(128, 64);
        shoulders.mirror = true;
        setRotation(shoulders, 0F, 0F, 0F);
        head = new ModelRenderer(this, 77, 9);
        head.addBox(-4F, -8F, -4F, 8, 8, 8);
        head.setRotationPoint(0F, -27F, 0F);
        head.setTextureSize(128, 64);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);
        headTopper1 = new ModelRenderer(this, 84, 0);
        headTopper1.addBox(-3F, 0F, -3F, 6, 1, 6);
        headTopper1.setRotationPoint(0F, -36F, 0F);
        headTopper1.setTextureSize(128, 64);
        headTopper1.mirror = true;
        setRotation(headTopper1, 0F, 0F, 0F);
        headTopper2 = new ModelRenderer(this, 59, 20);
        headTopper2.addBox(-2F, 0F, -2F, 4, 1, 4);
        headTopper2.setRotationPoint(0F, -37F, 0F);
        headTopper2.setTextureSize(128, 64);
        headTopper2.mirror = true;
        setRotation(headTopper2, 0F, 0F, 0F);
        headArm1 = new ModelRenderer(this, 67, 0);
        headArm1.addBox(-1F, -10F, -1F, 2, 10, 2);
        headArm1.setRotationPoint(0F, -36F, 0F);
        headArm1.setTextureSize(128, 64);
        headArm1.mirror = true;
        setRotation(headArm1, -0.2974289F, 0F, 0F);
        headArm2 = new ModelRenderer(this, 67, 0);
        headArm2.addBox(-1F, -10F, -1F, 2, 10, 2);
        headArm2.setRotationPoint(0F, -44F, 2F);
        headArm2.setTextureSize(128, 64);
        headArm2.mirror = true;
        setRotation(headArm2, 1.189716F, 0F, 0F);
        eyeball = new ModelRenderer(this, 42, 0);
        eyeball.addBox(-3F, -3F, 0F, 6, 6, 6);
        eyeball.setRotationPoint(0F, -47F, -11F);
        eyeball.setTextureSize(128, 64);
        eyeball.mirror = true;
        setRotation(eyeball, 0F, 0F, 0F);
        leftClaw1 = new ModelRenderer(this, 35, 0);
        leftClaw1.addBox(0F, 0F, 0F, 1, 5, 1);
        leftClaw1.setRotationPoint(11F, -8F, -2F);
        leftClaw1.setTextureSize(128, 64);
        leftClaw1.mirror = true;
        setRotation(leftClaw1, -0.1858931F, -0.8179294F, -0.1487144F);
        leftClaw2 = new ModelRenderer(this, 30, 0);
        leftClaw2.addBox(0F, 0F, 0F, 1, 6, 1);
        leftClaw2.setRotationPoint(9F, -8F, -2F);
        leftClaw2.setTextureSize(128, 64);
        leftClaw2.mirror = true;
        setRotation(leftClaw2, -0.3346075F, 0F, 0F);
        leftClaw3 = new ModelRenderer(this, 35, 0);
        leftClaw3.addBox(0F, 0F, 0F, 1, 5, 1);
        leftClaw3.setRotationPoint(7F, -8F, -2F);
        leftClaw3.setTextureSize(128, 64);
        leftClaw3.mirror = true;
        setRotation(leftClaw3, -0.3346075F, -0.2867917F, 0.0743572F);
        rightClaw1 = new ModelRenderer(this, 35, 0);
        rightClaw1.addBox(0F, 0F, 0F, 1, 5, 1);
        rightClaw1.setRotationPoint(-11F, -8F, -2F);
        rightClaw1.setTextureSize(128, 64);
        rightClaw1.mirror = true;
        setRotation(rightClaw1, -0.2230717F, -0.4089647F, 0.3346075F);
        rightClaw2 = new ModelRenderer(this, 30, 0);
        rightClaw2.addBox(0F, 0F, 0F, 1, 6, 1);
        rightClaw2.setRotationPoint(-10F, -8F, -2F);
        rightClaw2.setTextureSize(128, 64);
        rightClaw2.mirror = true;
        setRotation(rightClaw2, -0.2974289F, 0F, 0F);
        rightClaw3 = new ModelRenderer(this, 35, 0);
        rightClaw3.addBox(0F, 0F, 0F, 1, 5, 1);
        rightClaw3.setRotationPoint(-8F, -8F, -2F);
        rightClaw3.setTextureSize(128, 64);
        rightClaw3.mirror = true;
        setRotation(rightClaw3, -0.1487144F, 0.1858931F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        legRight.render(f5);
        legLeft.render(f5);
        body.render(f5);
        armRight.render(f5);
        armLeft.render(f5);
        shoulders.render(f5);
        head.render(f5);
        headTopper1.render(f5);
        headTopper2.render(f5);
        headArm1.render(f5);
        headArm2.render(f5);
        eyeball.render(f5);
        leftClaw1.render(f5);
        leftClaw2.render(f5);
        leftClaw3.render(f5);
        rightClaw1.render(f5);
        rightClaw2.render(f5);
        rightClaw3.render(f5);
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
