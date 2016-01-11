package com.moldfire.mfsummoner.proxy;

import com.moldfire.mfsummoner.init.ModBlocks;
import com.moldfire.mfsummoner.init.ModItems;

public class ClientProxy extends CommonProxy
{
	public void registerRenders()
	{
		ModItems.registerRenders();
		ModBlocks.registerRenders();
	}
}
