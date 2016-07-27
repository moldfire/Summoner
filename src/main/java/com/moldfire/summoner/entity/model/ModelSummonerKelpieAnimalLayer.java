package com.moldfire.summoner.entity.model;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;

public class ModelSummonerKelpieAnimalLayer extends ModelBase
{
	private ModelRenderer head;
    private ModelRenderer kelpieLeftEar;
    private ModelRenderer kelpieRightEar;
    private ModelRenderer neck;
    private ModelRenderer mane;
    private ModelRenderer body;
    private ModelRenderer tailBase;
    private ModelRenderer tailMiddle;
    private ModelRenderer tailTip;
    private ModelRenderer backLeftLeg;
    private ModelRenderer backLeftShin;
    private ModelRenderer backLeftHoof;
    private ModelRenderer backRightLeg;
    private ModelRenderer backRightShin;
    private ModelRenderer backRightHoof;
    private ModelRenderer frontLeftLeg;
    private ModelRenderer frontLeftShin;
    private ModelRenderer frontLeftHoof;
    private ModelRenderer frontRightLeg;
    private ModelRenderer frontRightShin;
    private ModelRenderer frontRightHoof;


    public ModelSummonerKelpieAnimalLayer()
    {
    	this.textureWidth = 128;
        this.textureHeight = 128;
        this.body = new ModelRenderer(this, 0, 34);
        this.body.addBox(-5.0F, -8.0F, -19.0F, 10, 10, 24);
        this.body.setRotationPoint(0.0F, 11.0F, 9.0F);
        this.tailBase = new ModelRenderer(this, 44, 0);
        this.tailBase.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 3);
        this.tailBase.setRotationPoint(0.0F, 3.0F, 14.0F);
        this.setBoxRotation(this.tailBase, -1.134464F, 0.0F, 0.0F);
        this.tailMiddle = new ModelRenderer(this, 38, 7);
        this.tailMiddle.addBox(-1.5F, -2.0F, 3.0F, 3, 4, 7);
        this.tailMiddle.setRotationPoint(0.0F, 3.0F, 14.0F);
        this.setBoxRotation(this.tailMiddle, -1.134464F, 0.0F, 0.0F);
        this.tailTip = new ModelRenderer(this, 24, 3);
        this.tailTip.addBox(-1.5F, -4.5F, 9.0F, 3, 4, 7);
        this.tailTip.setRotationPoint(0.0F, 3.0F, 14.0F);
        this.setBoxRotation(this.tailTip, -1.40215F, 0.0F, 0.0F);
        this.backLeftLeg = new ModelRenderer(this, 78, 29);
        this.backLeftLeg.addBox(-2.5F, -2.0F, -2.5F, 4, 9, 5);
        this.backLeftLeg.setRotationPoint(4.0F, 9.0F, 11.0F);
        this.backLeftShin = new ModelRenderer(this, 78, 43);
        this.backLeftShin.addBox(-2.0F, 0.0F, -1.5F, 3, 5, 3);
        this.backLeftShin.setRotationPoint(4.0F, 16.0F, 11.0F);
        this.backLeftHoof = new ModelRenderer(this, 78, 51);
        this.backLeftHoof.addBox(-2.5F, 5.1F, -2.0F, 4, 3, 4);
        this.backLeftHoof.setRotationPoint(4.0F, 16.0F, 11.0F);
        this.backRightLeg = new ModelRenderer(this, 96, 29);
        this.backRightLeg.addBox(-1.5F, -2.0F, -2.5F, 4, 9, 5);
        this.backRightLeg.setRotationPoint(-4.0F, 9.0F, 11.0F);
        this.backRightShin = new ModelRenderer(this, 96, 43);
        this.backRightShin.addBox(-1.0F, 0.0F, -1.5F, 3, 5, 3);
        this.backRightShin.setRotationPoint(-4.0F, 16.0F, 11.0F);
        this.backRightHoof = new ModelRenderer(this, 96, 51);
        this.backRightHoof.addBox(-1.5F, 5.1F, -2.0F, 4, 3, 4);
        this.backRightHoof.setRotationPoint(-4.0F, 16.0F, 11.0F);
        this.frontLeftLeg = new ModelRenderer(this, 44, 29);
        this.frontLeftLeg.addBox(-1.9F, -1.0F, -2.1F, 3, 8, 4);
        this.frontLeftLeg.setRotationPoint(4.0F, 9.0F, -8.0F);
        this.frontLeftShin = new ModelRenderer(this, 44, 41);
        this.frontLeftShin.addBox(-1.9F, 0.0F, -1.6F, 3, 5, 3);
        this.frontLeftShin.setRotationPoint(4.0F, 16.0F, -8.0F);
        this.frontLeftHoof = new ModelRenderer(this, 44, 51);
        this.frontLeftHoof.addBox(-2.4F, 5.1F, -2.1F, 4, 3, 4);
        this.frontLeftHoof.setRotationPoint(4.0F, 16.0F, -8.0F);
        this.frontRightLeg = new ModelRenderer(this, 60, 29);
        this.frontRightLeg.addBox(-1.1F, -1.0F, -2.1F, 3, 8, 4);
        this.frontRightLeg.setRotationPoint(-4.0F, 9.0F, -8.0F);
        this.frontRightShin = new ModelRenderer(this, 60, 41);
        this.frontRightShin.addBox(-1.1F, 0.0F, -1.6F, 3, 5, 3);
        this.frontRightShin.setRotationPoint(-4.0F, 16.0F, -8.0F);
        this.frontRightHoof = new ModelRenderer(this, 60, 51);
        this.frontRightHoof.addBox(-1.6F, 5.1F, -2.1F, 4, 3, 4);
        this.frontRightHoof.setRotationPoint(-4.0F, 16.0F, -8.0F);
        this.head = new ModelRenderer(this, 7, 0);
        this.head.addBox(-2.5F, -10.0F, -8F, 5, 5, 12);
        this.head.setRotationPoint(0.0F, 4.0F, -10.0F);
        this.setBoxRotation(this.head, 0.5235988F, 0.0F, 0.0F);
        this.kelpieLeftEar = new ModelRenderer(this, 0, 0);
        this.kelpieLeftEar.addBox(0.45F, -12.0F, 4.0F, 2, 3, 1);
        this.kelpieLeftEar.setRotationPoint(0.0F, 4.0F, -10.0F);
        this.setBoxRotation(this.kelpieLeftEar, 0.5235988F, 0.0F, 0.0F);
        this.kelpieRightEar = new ModelRenderer(this, 0, 0);
        this.kelpieRightEar.addBox(-2.45F, -12.0F, 4.0F, 2, 3, 1);
        this.kelpieRightEar.setRotationPoint(0.0F, 4.0F, -10.0F);
        this.setBoxRotation(this.kelpieRightEar, 0.5235988F, 0.0F, 0.0F);
        this.neck = new ModelRenderer(this, 0, 12);
        this.neck.addBox(-2.05F, -9.8F, -2.0F, 4, 14, 8);
        this.neck.setRotationPoint(0.0F, 4.0F, -10.0F);
        this.setBoxRotation(this.neck, 0.5235988F, 0.0F, 0.0F);
        this.mane = new ModelRenderer(this, 58, 0);
        this.mane.addBox(-1.0F, -11.5F, 5.0F, 2, 16, 4);
        this.mane.setRotationPoint(0.0F, 4.0F, -10.0F);
        this.setBoxRotation(this.mane, 0.5235988F, 0.0F, 0.0F);
       
        
    }
    
    public void render(Entity entityIn, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float scale)
    {
    	float bScale = scale;
    	
	     this.backLeftLeg.render(bScale);
	     this.backLeftShin.render(bScale);
	     this.backLeftHoof.render(bScale);
	     this.backRightLeg.render(bScale);
	     this.backRightShin.render(bScale);
	     this.backRightHoof.render(bScale);
	     this.frontLeftLeg.render(bScale);
	     this.frontLeftShin.render(bScale);
	     this.frontLeftHoof.render(bScale);
	     this.frontRightLeg.render(bScale);
	     this.frontRightShin.render(bScale);
	     this.frontRightHoof.render(bScale);
	
	     this.body.render(bScale);
	     this.tailBase.render(bScale);
	     this.tailMiddle.render(bScale);
	     this.tailTip.render(bScale);
	     this.neck.render(bScale);
	     this.mane.render(bScale);
	
	     this.kelpieLeftEar.render(bScale);
	     this.kelpieRightEar.render(bScale);
	     
	     this.head.render(bScale);

    }

    
    private void setBoxRotation(ModelRenderer p_110682_1_, float p_110682_2_, float p_110682_3_, float p_110682_4_)
    {
        p_110682_1_.rotateAngleX = p_110682_2_;
        p_110682_1_.rotateAngleY = p_110682_3_;
        p_110682_1_.rotateAngleZ = p_110682_4_;
    }
    
    private float updatekelpieRotation(float p_110683_1_, float p_110683_2_, float p_110683_3_)
    {
        float f;

        for (f = p_110683_2_ - p_110683_1_; f < -180.0F; f += 360.0F)
        {
            ;
        }

        while (f >= 180.0F)
        {
            f -= 360.0F;
        }

        return p_110683_1_ + p_110683_3_ * f;
    }
    
    public void setLivingAnimations(EntityLivingBase entitylivingbaseIn, float p_78086_2_, float p_78086_3_, float partialTickTime)
    {
        super.setLivingAnimations(entitylivingbaseIn, p_78086_2_, p_78086_3_, partialTickTime);
        float f = this.updatekelpieRotation(entitylivingbaseIn.prevRenderYawOffset, entitylivingbaseIn.renderYawOffset, partialTickTime);
        float f1 = this.updatekelpieRotation(entitylivingbaseIn.prevRotationYawHead, entitylivingbaseIn.rotationYawHead, partialTickTime);
        float f2 = entitylivingbaseIn.prevRotationPitch + (entitylivingbaseIn.rotationPitch - entitylivingbaseIn.prevRotationPitch) * partialTickTime;
        float f3 = f1 - f;
        float f4 = f2 / (180F / (float)Math.PI);

        if (f3 > 20.0F)
        {
            f3 = 20.0F;
        }

        if (f3 < -20.0F)
        {
            f3 = -20.0F;
        }

        if (p_78086_3_ > 0.2F)
        {
            f4 += MathHelper.cos(p_78086_2_ * 0.4F) * 0.15F * p_78086_3_;
        }
   
        float f5 = 0;
        float f6 = 0;
        float f7 = 1.0F - f6;
        float f8 = 0;
        boolean flag = false;
        boolean flag1 = false;
        boolean flag2 = false;
        float f9 = (float)entitylivingbaseIn.ticksExisted + partialTickTime;
        float f10 = MathHelper.cos(p_78086_2_ * 0.6662F + (float)Math.PI);
        float f11 = f10 * 0.8F * p_78086_3_;
        this.head.rotationPointY = 4.0F;
        this.head.rotationPointZ = -10.0F;
        this.tailBase.rotationPointY = 3.0F;
        this.tailMiddle.rotationPointZ = 14.0F;
 
        this.body.rotateAngleX = 0.0F;
        this.head.rotateAngleX = 0.5235988F + f4;
        this.head.rotateAngleY = f3 / (180F / (float)Math.PI);
        this.head.rotateAngleX = f6 * (0.2617994F + f4) + f5 * 2.18166F + (1.0F - Math.max(f6, f5)) * this.head.rotateAngleX;
        this.head.rotateAngleY = f6 * f3 / (180F / (float)Math.PI) + (1.0F - Math.max(f6, f5)) * this.head.rotateAngleY;
        this.head.rotationPointY = f6 * -6.0F + f5 * 11.0F + (1.0F - Math.max(f6, f5)) * this.head.rotationPointY;
        this.head.rotationPointZ = f6 * -1.0F + f5 * -10.0F + (1.0F - Math.max(f6, f5)) * this.head.rotationPointZ;
        this.tailBase.rotationPointY = f6 * 9.0F + f7 * this.tailBase.rotationPointY;
        this.tailMiddle.rotationPointZ = f6 * 18.0F + f7 * this.tailMiddle.rotationPointZ;
      
        this.body.rotateAngleX = f6 * -45.0F / (180F / (float)Math.PI) + f7 * this.body.rotateAngleX;
        this.kelpieLeftEar.rotationPointY = this.head.rotationPointY;
        this.kelpieRightEar.rotationPointY = this.head.rotationPointY;
      
        this.neck.rotationPointY = this.head.rotationPointY;
      
        this.mane.rotationPointY = this.head.rotationPointY;
        this.kelpieLeftEar.rotationPointZ = this.head.rotationPointZ;
        this.kelpieRightEar.rotationPointZ = this.head.rotationPointZ;
      
        this.neck.rotationPointZ = this.head.rotationPointZ;
       
        this.mane.rotationPointZ = this.head.rotationPointZ;
        this.kelpieLeftEar.rotateAngleX = this.head.rotateAngleX;
        this.kelpieRightEar.rotateAngleX = this.head.rotateAngleX;
       
        this.neck.rotateAngleX = this.head.rotateAngleX;
      
        this.mane.rotateAngleX = this.head.rotateAngleX;
        this.kelpieLeftEar.rotateAngleY = this.head.rotateAngleY;
        this.kelpieRightEar.rotateAngleY = this.head.rotateAngleY;
       
        this.neck.rotateAngleY = this.head.rotateAngleY;
       
        this.mane.rotateAngleY = this.head.rotateAngleY;
        
        float f12 = ((float)Math.PI / 2F);
        float f13 = ((float)Math.PI * 3F / 2F);
        float f14 = -1.0471976F;
        float f15 = 0.2617994F * f6;
        float f16 = MathHelper.cos(f9 * 0.6F + (float)Math.PI);
        this.frontLeftLeg.rotationPointY = -2.0F * f6 + 9.0F * f7;
        this.frontLeftLeg.rotationPointZ = -2.0F * f6 + -8.0F * f7;
        this.frontRightLeg.rotationPointY = this.frontLeftLeg.rotationPointY;
        this.frontRightLeg.rotationPointZ = this.frontLeftLeg.rotationPointZ;
        this.backLeftShin.rotationPointY = this.backLeftLeg.rotationPointY + MathHelper.sin(((float)Math.PI / 2F) + f15 + f7 * -f10 * 0.5F * p_78086_3_) * 7.0F;
        this.backLeftShin.rotationPointZ = this.backLeftLeg.rotationPointZ + MathHelper.cos(((float)Math.PI * 3F / 2F) + f15 + f7 * -f10 * 0.5F * p_78086_3_) * 7.0F;
        this.backRightShin.rotationPointY = this.backRightLeg.rotationPointY + MathHelper.sin(((float)Math.PI / 2F) + f15 + f7 * f10 * 0.5F * p_78086_3_) * 7.0F;
        this.backRightShin.rotationPointZ = this.backRightLeg.rotationPointZ + MathHelper.cos(((float)Math.PI * 3F / 2F) + f15 + f7 * f10 * 0.5F * p_78086_3_) * 7.0F;
        float f17 = (-1.0471976F + f16) * f6 + f11 * f7;
        float f18 = (-1.0471976F + -f16) * f6 + -f11 * f7;
        this.frontLeftShin.rotationPointY = this.frontLeftLeg.rotationPointY + MathHelper.sin(((float)Math.PI / 2F) + f17) * 7.0F;
        this.frontLeftShin.rotationPointZ = this.frontLeftLeg.rotationPointZ + MathHelper.cos(((float)Math.PI * 3F / 2F) + f17) * 7.0F;
        this.frontRightShin.rotationPointY = this.frontRightLeg.rotationPointY + MathHelper.sin(((float)Math.PI / 2F) + f18) * 7.0F;
        this.frontRightShin.rotationPointZ = this.frontRightLeg.rotationPointZ + MathHelper.cos(((float)Math.PI * 3F / 2F) + f18) * 7.0F;
        this.backLeftLeg.rotateAngleX = f15 + -f10 * 0.5F * p_78086_3_ * f7;
        this.backLeftShin.rotateAngleX = -0.08726646F * f6 + (-f10 * 0.5F * p_78086_3_ - Math.max(0.0F, f10 * 0.5F * p_78086_3_)) * f7;
        this.backLeftHoof.rotateAngleX = this.backLeftShin.rotateAngleX;
        this.backRightLeg.rotateAngleX = f15 + f10 * 0.5F * p_78086_3_ * f7;
        this.backRightShin.rotateAngleX = -0.08726646F * f6 + (f10 * 0.5F * p_78086_3_ - Math.max(0.0F, -f10 * 0.5F * p_78086_3_)) * f7;
        this.backRightHoof.rotateAngleX = this.backRightShin.rotateAngleX;
        this.frontLeftLeg.rotateAngleX = f17;
        this.frontLeftShin.rotateAngleX = (this.frontLeftLeg.rotateAngleX + (float)Math.PI * Math.max(0.0F, 0.2F + f16 * 0.2F)) * f6 + (f11 + Math.max(0.0F, f10 * 0.5F * p_78086_3_)) * f7;
        this.frontLeftHoof.rotateAngleX = this.frontLeftShin.rotateAngleX;
        this.frontRightLeg.rotateAngleX = f18;
        this.frontRightShin.rotateAngleX = (this.frontRightLeg.rotateAngleX + (float)Math.PI * Math.max(0.0F, 0.2F - f16 * 0.2F)) * f6 + (-f11 + Math.max(0.0F, -f10 * 0.5F * p_78086_3_)) * f7;
        this.frontRightHoof.rotateAngleX = this.frontRightShin.rotateAngleX;
        this.backLeftHoof.rotationPointY = this.backLeftShin.rotationPointY;
        this.backLeftHoof.rotationPointZ = this.backLeftShin.rotationPointZ;
        this.backRightHoof.rotationPointY = this.backRightShin.rotationPointY;
        this.backRightHoof.rotationPointZ = this.backRightShin.rotationPointZ;
        this.frontLeftHoof.rotationPointY = this.frontLeftShin.rotationPointY;
        this.frontLeftHoof.rotationPointZ = this.frontLeftShin.rotationPointZ;
        this.frontRightHoof.rotationPointY = this.frontRightShin.rotationPointY;
        this.frontRightHoof.rotationPointZ = this.frontRightShin.rotationPointZ;

        f12 = -1.3089F + p_78086_3_ * 1.5F;

        if (f12 > 0.0F)
        {
            f12 = 0.0F;
        }

        if (flag)
        {
            this.tailBase.rotateAngleY = MathHelper.cos(f9 * 0.7F);
            f12 = 0.0F;
        }
        else
        {
            this.tailBase.rotateAngleY = 0.0F;
        }

        this.tailMiddle.rotateAngleY = this.tailBase.rotateAngleY;
        this.tailTip.rotateAngleY = this.tailBase.rotateAngleY;
        this.tailMiddle.rotationPointY = this.tailBase.rotationPointY;
        this.tailTip.rotationPointY = this.tailBase.rotationPointY;
        this.tailMiddle.rotationPointZ = this.tailBase.rotationPointZ;
        this.tailTip.rotationPointZ = this.tailBase.rotationPointZ;
        this.tailBase.rotateAngleX = f12;
        this.tailMiddle.rotateAngleX = f12;
        this.tailTip.rotateAngleX = -0.2618F + f12;
    }
   
}