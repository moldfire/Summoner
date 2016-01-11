package com.moldfire.mfsummoner.recipes;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.moldfire.mfsummoner.init.ModBlocks;
import com.moldfire.mfsummoner.init.ModItems;

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
	}
}
