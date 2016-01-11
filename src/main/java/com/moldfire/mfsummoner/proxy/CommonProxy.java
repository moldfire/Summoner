package com.moldfire.mfsummoner.proxy;

import net.minecraftforge.fml.common.registry.GameRegistry;

import com.moldfire.mfsummoner.tileentity.TileEntityCoreStabiliser;


public class CommonProxy 
{
	public void registerRenders(){
	}
	
	public void registerTileEntitys()
	{
		GameRegistry.registerTileEntity(TileEntityCoreStabiliser.class, TileEntityCoreStabiliser.name);
	}
}
