package com.moldfire.summoner.init;

import com.moldfire.summoner.items.ItemMFS;
import com.moldfire.summoner.items.ItemMFSBindingStone;
import com.moldfire.summoner.items.ItemMFSDebug;
import com.moldfire.summoner.items.ItemMFSLifestoneShard;
import com.moldfire.summoner.items.ItemMFSSummoningStone;
import com.moldfire.summoner.items.ItemSummoningBook;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems 
{
	public static final ItemMFS debugItem = new ItemMFSDebug("debugItem", 1, true);
	public static final ItemMFS summoningStone = new ItemMFSSummoningStone("summoningStone", 1, true);
	public static final ItemMFS summoningBook = new ItemSummoningBook("summoningBook", 1, true);
	public static final ItemMFS lifestoneShard = new ItemMFSLifestoneShard("lifestoneShard", 1, true);
	public static final ItemMFS bindingStone = new ItemMFSBindingStone("bindingStone", 1, true);
	
	
	public static void init()
	{
		registerItem(debugItem);
		registerItem(summoningStone);
		registerItem(summoningBook);
		registerItem(lifestoneShard);
		registerItem(bindingStone);
	}
	
	public static void registerRenders()
	{
		registerRender(debugItem);
		registerRender(summoningStone);
		registerRender(summoningBook);
		registerRenderWOMeta(lifestoneShard);
		registerRender(bindingStone);
	}
	
	private static void registerItem(Item item)
	{
		GameRegistry.registerItem(item,item.getUnlocalizedName().substring(5));
	}
	
	private static void registerRender(Item item)
	{
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getUnlocalizedName().substring(5), "inventory"));
	}
	
	private static void registerRenderWOMeta(Item item)
	{
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, new ItemMeshDefinition()
		{
			public ModelResourceLocation getModelLocation(ItemStack stack)
			{
				return new ModelResourceLocation(stack.getUnlocalizedName().substring(5), "inventory");
			}
		});
	}
	
	
}
