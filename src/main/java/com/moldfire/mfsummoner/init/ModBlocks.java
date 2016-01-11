package com.moldfire.mfsummoner.init;

import com.moldfire.mfsummoner.blocks.BlockAlterStabiliser;
import com.moldfire.mfsummoner.blocks.BlockMFS;
import com.moldfire.mfsummoner.blocks.BlockObsidianSlab;
import com.moldfire.mfsummoner.blocks.BlockSlabMFS;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks 
{
	public static final BlockMFS alterStabiliser = new BlockAlterStabiliser("alterStabiliser", Material.rock, 50.5F);
	public static final BlockSlabMFS obsidianSlab = new BlockObsidianSlab("obsidianSlab", Material.rock, 50.0F);
	
	public static void init()
	{
		registerItem(alterStabiliser);
		registerItem(obsidianSlab);
	}
	
	public static void registerRenders()
	{
		registerRender(alterStabiliser);
		registerRender(obsidianSlab);
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
