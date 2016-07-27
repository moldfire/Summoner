package com.moldfire.summoner.recipes;

import java.util.List;

import com.google.common.collect.Lists;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.item.ItemStack;

public class Summoning //implements IRecipe
{
	private final String entity;
	public final int cost;
	public final List<ItemStack> summoningItems;
	
	public Summoning(String entityClass, int cost, List<ItemStack> inputList)
	{
		this.entity = entityClass;
		this.cost = cost;
		this.summoningItems = inputList;
	}
	
	//@Override
	public boolean matches(List<ItemStack>inputList, int energy) 
	{
		List<ItemStack> list = Lists.newArrayList(this.summoningItems);
		
		if(inputList.size() == list.size())
		{
			for(ItemStack itemstack : inputList)
			{
				boolean flag = false;
				
				for(ItemStack itemstack1 : list)
				{
					if (itemstack.getItem() == itemstack1.getItem() && (itemstack1.getMetadata() == 32767 || itemstack.getMetadata() == itemstack1.getMetadata()))
                    {
                        flag = true;
                        list.remove(itemstack1);
                        break;
                    }
				}
				
				if (!flag)
                {
                    return false;
                }
			}
		}
		
		if(energy >= this.cost)
		{return list.isEmpty();}
		return false;
	}

	//@Override
	public String getRecipeOutput() 
	{
		return this.entity;
	}
	
	public int getCost()
	{
		return this.cost;
	}

}
