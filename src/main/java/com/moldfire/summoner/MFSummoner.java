package com.moldfire.summoner;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

import com.moldfire.summoner.event.MFEventHandler;
import com.moldfire.summoner.gui.GuiHandler;
import com.moldfire.summoner.init.ModAchievments;
import com.moldfire.summoner.init.ModBlocks;
import com.moldfire.summoner.init.ModItems;
import com.moldfire.summoner.proxy.CommonProxy;
import com.moldfire.summoner.recipes.Recipes;
import com.moldfire.summoner.reference.Reference;

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
		//Initialise Items/Blocks
		ModItems.init();
		ModBlocks.init();
		ModAchievments.init();
		
		MinecraftForge.EVENT_BUS.register(new MFEventHandler());
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		//Load Recipes
		Recipes.init();
		
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
