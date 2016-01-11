package com.moldfire.mfsummoner.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.moldfire.mfsummoner.init.ModItems;
import com.moldfire.mfsummoner.reference.Reference;

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
