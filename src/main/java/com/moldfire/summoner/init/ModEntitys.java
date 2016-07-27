package com.moldfire.summoner.init;

import com.moldfire.summoner.MFSummoner;
import com.moldfire.summoner.entity.EntityMFSImp;
import com.moldfire.summoner.entity.EntityMFSKelpie;
import com.moldfire.summoner.entity.model.ModelSummonerImp;
import com.moldfire.summoner.entity.model.ModelSummonerKelpie;
import com.moldfire.summoner.entity.renderer.RendererMFSImp;
import com.moldfire.summoner.entity.renderer.RendererMFSKelpie;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class ModEntitys 
{
	//public static final ItemMFS summoningStone = new ItemMFSSummoningStone("summoningStone", 1, true);
	private static int modEntityID = 0;
	
	ModEntitys()
	{		
	}
	
	public static void init()
	{
		EntityRegistry.registerModEntity(EntityMFSImp.class, "Imp", ++modEntityID, MFSummoner.instance, 80, 3, false, 0x6B0C17, 0);
		EntityRegistry.registerModEntity(EntityMFSKelpie.class, "Kelpie", ++modEntityID, MFSummoner.instance, 80, 3, false, 0x438499, 0xADDDED);
	}
	
	public static void registerRenders()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityMFSImp.class, new RendererMFSImp(Minecraft.getMinecraft().getRenderManager(), new ModelSummonerImp(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityMFSKelpie.class, new RendererMFSKelpie(Minecraft.getMinecraft().getRenderManager(), new ModelSummonerKelpie(), 0.3F));
	}
	
	
}
