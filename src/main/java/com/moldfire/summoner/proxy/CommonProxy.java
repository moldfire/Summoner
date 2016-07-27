package com.moldfire.summoner.proxy;

import net.minecraftforge.fml.common.registry.GameRegistry;

import com.moldfire.summoner.tileentity.TileEntityAlter;
import com.moldfire.summoner.tileentity.TileEntityPlinth;


public class CommonProxy 
{
	public void registerRenders(){
	}
	
	public void registerTileEntitys()
	{
		GameRegistry.registerTileEntity(TileEntityAlter.class, TileEntityAlter.name);
		GameRegistry.registerTileEntity(TileEntityPlinth.class, TileEntityPlinth.name);
	}
}
