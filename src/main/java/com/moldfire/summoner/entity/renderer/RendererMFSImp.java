package com.moldfire.summoner.entity.renderer;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import com.moldfire.summoner.entity.EntityMFSImp;
import com.moldfire.summoner.reference.Reference;

public class RendererMFSImp extends RenderLiving<EntityMFSImp>
{
	private static final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID+":"+ "textures/entities/entityImp.png");
	
	public RendererMFSImp(RenderManager rendermanagerIn, ModelBase modelbaseIn,	float shadowsizeIn) 
	{
		super(rendermanagerIn, modelbaseIn, shadowsizeIn);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityMFSImp entity) 
	{
		return texture;
	}
}
