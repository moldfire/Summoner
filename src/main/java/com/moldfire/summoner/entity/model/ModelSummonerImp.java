package com.moldfire.summoner.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelSummonerImp extends ModelBase
{
	ModelRenderer Body;
    ModelRenderer Head;
    ModelRenderer RightLeg;
    ModelRenderer LeftLeg;
    ModelRenderer RightArm;
    ModelRenderer LeftArm;
    
    int textureWidth;
    int textureHeight;
    
    public ModelSummonerImp()
    {
    	textureWidth = 64;
        textureHeight = 32;
      
       this.Head = new ModelRenderer(this, 12, 0);
       this.Head.addBox(-1.5F, 0F, 0F, 3, 2, 2); //Head
       this.Head.setRotationPoint(0F, 14F, -1F);
       this.Head.setTextureOffset(22, 2).addBox(-1.5F, -1F, 0F, 1, 1, 1); //Right Horn
       this.Head.setTextureOffset(22, 2).addBox(0.5F, -1F, 0F, 1, 1, 1); //Left Horn
       
       this.Body = new ModelRenderer(this, 0, 0);
       this.Body.addBox(-2F, 0F, -1F, 4, 4, 2);
       this.Body.setRotationPoint(0F, 16F, 0F);
        
       this.RightArm = new ModelRenderer(this, 0, 6);
       this.RightArm.addBox(-1F, 0F, -0.5F, 1, 4, 1);
       this.RightArm.setRotationPoint(-2F, 16F, 0F);
        
       this.LeftArm = new ModelRenderer(this, 0, 6);
       this.LeftArm.addBox(1F, 0F, -0.5F, 1, 4, 1);
       this.LeftArm.setRotationPoint(1F, 16F, 0F);
  
        
       this.RightLeg = new ModelRenderer(this, 0, 6);
       this.RightLeg.addBox(-0.5F, 0F, -0.5F, 1, 4, 1);
       this.RightLeg.setRotationPoint(-1F, 20F, 0F);

       this.LeftLeg = new ModelRenderer(this, 0, 6);
       this.LeftLeg.addBox(-0.5F, 0F, -0.5F, 1, 4, 1);
       this.LeftLeg.setRotationPoint(1F, 20F, 0F);

    }
    
    @Override
    public void render(Entity entity, float time, float limbSwing, float f, float headYRot, float headXRot, float yTrans)
    {
      this.setRotationAngles(time, limbSwing, f, headYRot, headXRot, yTrans, entity);
      
      this.Head.render(yTrans);
      this.Body.render(yTrans);
      this.RightArm.render(yTrans);
      this.LeftArm.render(yTrans);
      this.RightLeg.render(yTrans);
      this.LeftLeg.render(yTrans);
    }
    
    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
    	model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
      
     
    
    @Override
    public void setRotationAngles(float time, float limbSwing, float f, float headYRot, float headXRot, float yTrans, Entity entity)
    {
    	this.Head.rotateAngleX = headXRot /(180F /(float)Math.PI);
    	this.Head.rotateAngleY = headYRot /(180F /(float)Math.PI);
    	
    	this.LeftLeg.rotateAngleX = MathHelper.cos(time * 0.6662F + (float)Math.PI) * 1.4F * limbSwing;
    	this.RightLeg.rotateAngleX = MathHelper.cos(time * 0.6662F) * 1.4F * limbSwing;
    	this.RightArm.rotateAngleX = MathHelper.cos(time * 0.6662F + (float)Math.PI) * 1.4F * limbSwing;
    	this.LeftArm.rotateAngleX = MathHelper.cos(time * 0.6662F) * 1.4F * limbSwing;
    }
}