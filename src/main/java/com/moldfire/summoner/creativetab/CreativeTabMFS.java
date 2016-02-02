package com.moldfire.summoner.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.moldfire.summoner.init.ModItems;
import com.moldfire.summoner.reference.Reference;

public class CreativeTabMFS 
{
	public static final CreativeTabs MFSTab = new CreativeTabs(Reference.MOD_ID)
	{	
		@Override
		public Item getTabIconItem()
		{
			return ModItems.summoningStone;
		}
		
		@Override
		public String getTranslatedTabLabel()
		{
			return Reference.MOD_NAME;
		}
	};
}
