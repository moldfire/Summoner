package com.moldfire.summoner.entity.renderer;

import com.moldfire.summoner.entity.EntityMFSKelpie;
import com.moldfire.summoner.entity.model.ModelSummonerKelpie;
import com.moldfire.summoner.reference.Reference;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RendererMFSKelpie extends RenderLiving<EntityMFSKelpie>
{
	private static final ResourceLocation animalTexture = new ResourceLocation(Reference.MOD_ID+":"+ "textures/entities/entityKelpie.png");
	private static final ResourceLocation humanTexture = new ResourceLocation(Reference.MOD_ID+":"+ "textures/entities/entityKelpieHuman.png");
	private static final ResourceLocation animalBoundTexture = new ResourceLocation(Reference.MOD_ID+":"+ "textures/entities/entityKelpieBound.png");
	private static final ResourceLocation humanBoundTexture = new ResourceLocation(Reference.MOD_ID+":"+ "textures/entities/entityKelpieHumanBound.png");
	
	private final ModelBase kelpieModel = new ModelSummonerKelpie();
	
	public RendererMFSKelpie(RenderManager rendermanagerIn, ModelBase modelbaseIn,	float shadowsizeIn) 
	{
		super(rendermanagerIn, modelbaseIn, shadowsizeIn);
		this.addLayer(new RendererKelpieLayer(this));
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityMFSKelpie entity) 
	{
		if(entity.isInWater() || entity.riddenByEntity != null)
		{
			if(!entity.isBound())
			{return animalTexture;}
			else{return animalBoundTexture;}
		}
		else
		{
			if(!entity.isBound())
			{return humanTexture;}
			else{return humanBoundTexture;}
		}
	}
}
