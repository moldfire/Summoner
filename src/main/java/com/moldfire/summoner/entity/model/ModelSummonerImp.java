package com.moldfire.summoner.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelSummonerImp extends ModelBase
{
	ModelRenderer head;

    ModelRenderer body;

    ModelRenderer rightarm;

    ModelRenderer leftarm;

    ModelRenderer rightleg;

    ModelRenderer leftleg;

    ModelRenderer rightear;

    ModelRenderer leftear;
    
    int textureWidth = 64;
    int textureHeight = 32;
    
    public ModelSummonerImp()
    {
    	head = new ModelRenderer(this, 0, 0);
    	head.addBox(-4F, -8F, -4F, 6, 6, 6);
    	head.setRotationPoint(1F, 7F, 0F);
    	head.setTextureSize(64, 32);
    }

}
