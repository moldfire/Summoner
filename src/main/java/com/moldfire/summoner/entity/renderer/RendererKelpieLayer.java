package com.moldfire.summoner.entity.renderer;

import com.moldfire.summoner.entity.EntityMFSKelpie;
import com.moldfire.summoner.entity.model.ModelSummonerKelpieAnimalLayer;
import com.moldfire.summoner.entity.model.ModelSummonerKelpieHumanLayer;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;

public class RendererKelpieLayer implements LayerRenderer<EntityMFSKelpie>
{
	private final RendererMFSKelpie kelpieRenderer;
	private final ModelBase modelKelpie = new ModelSummonerKelpieAnimalLayer();
	private final ModelBase modelKelpieHuman = new ModelSummonerKelpieHumanLayer();
	
	public RendererKelpieLayer(RendererMFSKelpie kelpieRendererIn)
	{
		this.kelpieRenderer = kelpieRendererIn;
	}

	@Override
	public boolean shouldCombineTextures() 
	{
		return true;
	}

	@Override
	public void doRenderLayer(EntityMFSKelpie entitylivingbaseIn, float p_177141_2_, float p_177141_3_,	float partialTicks, float p_177141_5_, float p_177141_6_, float p_177141_7_, float scale) 
	{
        if (!entitylivingbaseIn.isInvisible())
        {
        	if(entitylivingbaseIn.isInWater() || entitylivingbaseIn.riddenByEntity != null)
        	{ GlStateManager.color(1.0F, 1.0F, 1.0F, 0.5F); }//Kelpie Form
        	else { GlStateManager.color(1.0F, 1.0F, 1.0F, 0.8F); }//Human Form
        	
            GlStateManager.enableNormalize();
            GlStateManager.enableBlend();
            GlStateManager.blendFunc(770, 771);

            if(entitylivingbaseIn.isInWater() || entitylivingbaseIn.riddenByEntity != null)
            {
            	this.modelKelpie.setModelAttributes(this.kelpieRenderer.getMainModel());
            	this.modelKelpie.render(entitylivingbaseIn, p_177141_2_, p_177141_3_, p_177141_5_, p_177141_6_, p_177141_7_, scale);
            }
            else
            {
				this.modelKelpieHuman.setModelAttributes(this.kelpieRenderer.getMainModel());
				this.modelKelpieHuman.render(entitylivingbaseIn, p_177141_2_, p_177141_3_, p_177141_5_, p_177141_6_, p_177141_7_, scale);
            }

            GlStateManager.disableBlend();
            GlStateManager.disableNormalize();
        }
	}

}
