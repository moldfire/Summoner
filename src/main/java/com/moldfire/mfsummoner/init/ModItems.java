package com.moldfire.mfsummoner.init;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.moldfire.mfsummoner.items.ItemBindingGem;
import com.moldfire.mfsummoner.items.ItemGemDust;
import com.moldfire.mfsummoner.items.ItemMFS;
import com.moldfire.mfsummoner.items.ItemSummoningStone;

public class ModItems 
{
	//public static final ItemMFS DevHouse = new ItemDevWorkshop("DevHouse");
	public static final ItemMFS summoningStone = new ItemSummoningStone("summoningStone");
	public static final ItemMFS bindingGem = new ItemBindingGem("bindingGem");
	public static final ItemMFS gemDust = new ItemGemDust("gemDust");
	
	
	public static void init()
	{
		//registerItem(DevHouse);
		registerItem(summoningStone);
		registerItem(bindingGem);
		registerItem(gemDust);
	}
	
	public static void registerRenders()
	{
		registerRender(summoningStone);
		registerRenderWOMeta(bindingGem);
		registerRender(gemDust);
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
