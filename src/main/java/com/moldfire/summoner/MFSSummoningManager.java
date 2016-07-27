package com.moldfire.summoner;

import java.util.List;

import com.google.common.collect.Lists;
import com.moldfire.summoner.recipes.Summoning;
import com.moldfire.summoner.reference.Reference;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class MFSSummoningManager 
{
	private static final MFSSummoningManager instance = new MFSSummoningManager();
	private final List<Summoning> summonings = Lists.<Summoning>newArrayList();
	
	public static MFSSummoningManager getInstance()
    {
        /** The static instance of this class */
        return instance;
    }
	
	MFSSummoningManager()
	{
		System.out.println("adding summoning recipies");
		
		//addSummoning("Zombie", 0, Items.rotten_flesh, Items.rotten_flesh, Items.rotten_flesh, Items.bone, Items.bone);
		//addSummoning(EntityChicken.class, 0, Items.feather, Items.feather, Items.feather, Items.chicken);
		addSummoning(Reference.MOD_ID+".Imp", 15, Items.leather);
		
		addSummoning(Reference.MOD_ID+".Kelpie", 25, Items.water_bucket, Items.water_bucket, Items.iron_horse_armor);
		addSummoning(Reference.MOD_ID+".Kelpie", 25, Items.water_bucket, Items.water_bucket, Items.golden_horse_armor);
		addSummoning(Reference.MOD_ID+".Kelpie", 25, Items.water_bucket, Items.water_bucket, Items.diamond_horse_armor);
	}
	
	public void addSummoning(String entityClass, int cost, Object... summoningComponents)
	{
		System.out.println("adding recipe for: " + entityClass);
		
		List<ItemStack> list = Lists.<ItemStack>newArrayList();
		
		for(Object object : summoningComponents)
		{
			if (object instanceof ItemStack)
            {
                list.add(((ItemStack)object).copy());
            }
            else if (object instanceof Item)
            {
                list.add(new ItemStack((Item)object));
            }
            else
            {
                if (!(object instanceof Block))
                {
                    throw new IllegalArgumentException("Invalid summoning: unknown type " + object.getClass().getName() + "!");
                }

                list.add(new ItemStack((Block)object));
            }
			
			this.summonings.add(new Summoning(entityClass, cost, list));
		}
		
		System.out.println("added recipe for: " + entityClass);
	}
	
	
	public String findMatchingSummoning(List<ItemStack>inputList_, int energy)
	{
		for(Summoning summoning : this.summonings)
		{
			if(summoning.matches(inputList_, energy))
			{
				return summoning.getRecipeOutput();
			}
		}
		
		return null;
	}
	
	public int getCost(String entity)
	{
		for(Summoning summoning : this.summonings)
		{
			if(summoning.getRecipeOutput() == entity)
			{
				return summoning.getCost();
			}
		}
		
		return 0;
	}
}
