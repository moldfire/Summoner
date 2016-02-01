package com.moldfire.summoner.proxy;

import com.moldfire.summoner.tileentity.TileEntityCoreStabiliser;

import net.minecraftforge.fml.common.registry.GameRegistry;


public class CommonProxy 
{
	public void registerRenders(){
	}
	
	public void registerTileEntitys()
	{
		GameRegistry.registerTileEntity(TileEntityCoreStabiliser.class, TileEntityCoreStabiliser.name);
	}
}
