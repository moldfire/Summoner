package com.moldfire.summoner.entity.model;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;

public class ModelSummonerKelpie extends ModelBase
{
	
    public ModelSummonerKelpie()
    {
    	
    }
    
    public void render(Entity entityIn, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float scale)
    {
    	
    }

    
    private void setBoxRotation(ModelRenderer p_110682_1_, float p_110682_2_, float p_110682_3_, float p_110682_4_)
    {
        p_110682_1_.rotateAngleX = p_110682_2_;
        p_110682_1_.rotateAngleY = p_110682_3_;
        p_110682_1_.rotateAngleZ = p_110682_4_;
    }
    
    public void setLivingAnimations(EntityLivingBase entitylivingbaseIn, float p_78086_2_, float p_78086_3_, float partialTickTime)
    {
       
    }
   
}