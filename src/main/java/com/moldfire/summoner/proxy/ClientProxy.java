package com.moldfire.summoner.proxy;

import com.moldfire.summoner.init.ModBlocks;
import com.moldfire.summoner.init.ModEntitys;
import com.moldfire.summoner.init.ModItems;

public class ClientProxy extends CommonProxy
{
	public void registerRenders()
	{
		ModItems.registerRenders();
		ModBlocks.registerRenders();
		ModEntitys.registerRenders();
	}
}
