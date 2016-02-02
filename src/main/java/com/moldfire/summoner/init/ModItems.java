package com.moldfire.summoner.init;

import com.moldfire.summoner.items.ItemBindingGem;
import com.moldfire.summoner.items.ItemGemDust;
import com.moldfire.summoner.items.ItemMFS;
import com.moldfire.summoner.items.ItemSummoningBook;
import com.moldfire.summoner.items.ItemSummoningStone;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems 
{
	public static final ItemMFS summoningStone = new ItemSummoningStone("summoningStone", 1, true);
	public static final ItemMFS bindingGem = new ItemBindingGem("bindingGem", 1, true);
	public static final ItemMFS summoningBook = new ItemSummoningBook("summoningBook", 1, true);
	public static final ItemMFS gemDust = new ItemGemDust("gemDust", 64, true);
	
	
	public static void init()
	{
		registerItem(summoningStone);
		registerItem(bindingGem);
		registerItem(summoningBook);
		registerItem(gemDust);
	}
	
	public static void registerRenders()
	{
		registerRender(summoningStone);
		registerRenderWOMeta(bindingGem);
		registerRender(gemDust);
		registerRender(summoningBook);
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
