package com.moldfire.summoner.init;

import com.moldfire.summoner.blocks.BlockAlterPlinth;
import com.moldfire.summoner.blocks.BlockContainerMFS;
import com.moldfire.summoner.blocks.BlockMFS;
import com.moldfire.summoner.blocks.BlockMFSAlter;
import com.moldfire.summoner.blocks.BlockMFSOreLifestone;
import com.moldfire.summoner.blocks.BlockWorldFracture;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks 
{
	//WorldGen - Ores
	public static final BlockMFS oreLifestone = new BlockMFSOreLifestone("oreLifestone", Material.rock, 3.0F, true);
	
	//WorldGen - Misc
	public static final BlockMFS worldFracture = new BlockWorldFracture("worldFracture", Material.glass, 25.0F, false);
	
	//Blocks
	public static final BlockMFS alter = new BlockMFSAlter("alter", Material.glass, 50.0f, true);
	public static final BlockContainerMFS alterBasin = new BlockAlterPlinth("alterBasin", Material.rock, 10.0F, true);
	
	public static void init()
	{
		//WorldGen - Ores
		registerItem(oreLifestone);
		
		//WorldGen - Misc
		registerItem(worldFracture);
		
		//Blocks
		registerItem(alter);
		registerItem(alterBasin);
	}
	
	public static void registerRenders()
	{
		//WorldGen - Ores
		registerRender(oreLifestone);
		
		//Blocks
		registerRender(alter);
		registerRender(alterBasin);
	}
	
	private static void registerItem(Block block)
	{
		GameRegistry.registerBlock(block,block.getUnlocalizedName().substring(5));
	}
	
	private static void registerRender(Block block)
	{
		Item item = Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getUnlocalizedName().substring(5), "inventory"));
	}
}
