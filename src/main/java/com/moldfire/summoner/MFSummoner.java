package com.moldfire.summoner;
import com.moldfire.summoner.gui.GuiHandler;
import com.moldfire.summoner.init.ModBlocks;
import com.moldfire.summoner.init.ModEntitys;
import com.moldfire.summoner.init.ModItems;
import com.moldfire.summoner.proxy.CommonProxy;
import com.moldfire.summoner.recipes.Recipes;
import com.moldfire.summoner.reference.Reference;
import com.moldfire.summoner.world.WorldGenMFS;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid=Reference.MOD_ID, name=Reference.MOD_NAME, version=Reference.VERSION)
public class MFSummoner 
{
	@Instance
	public static MFSummoner instance;
	
	@SidedProxy(clientSide=Reference.CLIENT_PROXY, serverSide=Reference.SERVER_PROXY)
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		MFSSummoningManager summoningManager = new MFSSummoningManager();
		
		//Initialise Items/Blocks
		ModItems.init();
		ModBlocks.init();
		ModEntitys.init();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		//Load Recipes
		Recipes.init();
		
		//Load world gen
		GameRegistry.registerWorldGenerator(new WorldGenMFS(), 0);
		
		//Load Render
		proxy.registerRenders();
		proxy.registerTileEntitys();
		
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		
	}
}
