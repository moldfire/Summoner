package com.moldfire.summoner.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.moldfire.summoner.creativetab.CreativeTabMFS;
import com.moldfire.summoner.reference.Reference;
import com.moldfire.summoner.utility.Formatting;

public class ItemMFS extends Item
{
	protected static Formatting F;
	public ItemMFS(String name, int maxStack, boolean creativeTab)
	{
		super();
		this.setUnlocalizedName(name);
		this.setMaxStackSize(maxStack);
		if(creativeTab)this.setCreativeTab(CreativeTabMFS.MFSTab);
	}
	
	@Override
	public String getUnlocalizedName()
	{
		return String.format("item.%s%s", Reference.MOD_ID + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemStack)
	{
		return String.format("item.%s%s", Reference.MOD_ID + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}
	
	protected boolean checkTags(ItemStack stack, String... key)
	{
		boolean hasTags = false;
		for(int i = 0; i < key.length; i++)
		{
			if(stack.getTagCompound().hasKey(key[i]))
			{
				//Do Nothing
			}
			else
			{
				return false;
			}
		}
		return true;
	}

	private String getUnwrappedUnlocalizedName(String unlocalizedName) 
	{
		return unlocalizedName.substring(unlocalizedName.indexOf(".")+1);
	}
	
	
}
