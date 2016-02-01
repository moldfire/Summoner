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
		//Furnace
		GameRegistry.addSmelting(ModItems.gemDust, new ItemStack(ModItems.bindingGem, 1, 0), 0);
		
		//Crafting
		GameRegistry.addRecipe(new ItemStack(ModItems.gemDust, 1), "sgs", "gsg", "sgs", 's', Blocks.sand, 'g', Items.glowstone_dust);
		GameRegistry.addRecipe(new ItemStack(ModItems.summoningStone, 1, 0), " e ", "rbr", " e ", 'r', Items.redstone, 'e', Items.ender_eye, 'b', new ItemStack(ModItems.bindingGem, 0));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.obsidianSlab, 6), "ooo", "ooo", 'o', Blocks.obsidian);
		GameRegistry.addRecipe(new ItemStack(ModItems.summoningBook, 1), "sbz", 's', Items.skull, 'b', Items.book, 'z', new ItemStack(Items.skull, 1, 2));
	}
}
