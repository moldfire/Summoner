package com.moldfire.summoner.recipes;

import com.moldfire.summoner.init.ModBlocks;
import com.moldfire.summoner.init.ModItems;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Recipes 
{
	public static void init()
	{
		/*-------------------------------------------------------------------------------------------------/
		/---Crafting--------------------------------------------------------------------------------------/
		/-------------------------------------------------------------------------------------------------*/
		GameRegistry.addRecipe(new ItemStack(ModBlocks.alter, 1), "sss", "olo", "ooo",  's', new ItemStack(Blocks.stone_slab, 1, 0), 'o', Blocks.obsidian, 'l', ModItems.lifestoneShard);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.alterBasin, 1), "s s", " b ", "sss",  's', new ItemStack(Blocks.stone_slab, 1, 0), 'b', Blocks.stone);
		GameRegistry.addRecipe(new ItemStack(ModItems.summoningStone, 1, 0), "lil", "idi", "lil", 'i', Items.iron_ingot, 'l', ModItems.lifestoneShard, 'd', Items.diamond);
		//GameRegistry.addRecipe(new ItemStack(ModBlocks.obsidianSlab, 6), "ooo", 'o', Blocks.obsidian);
		GameRegistry.addRecipe(new ItemStack(ModItems.bindingStone, 1), "d", 'd', Blocks.dirt);
		GameRegistry.addRecipe(new ItemStack(ModItems.summoningBook),"bs", 'b', Items.book, 's', ModItems.lifestoneShard);
		
		/*-------------------------------------------------------------------------------------------------/
		/---Furnace--------------------------------------------------------------------------------------/
		/-------------------------------------------------------------------------------------------------*/
		
		/*-------------------------------------------------------------------------------------------------/
		/---Summoning--------------------------------------------------------------------------------------/
		/-------------------------------------------------------------------------------------------------*/
		
	}
}
