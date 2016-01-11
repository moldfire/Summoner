package com.moldfire.mfsummoner.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.moldfire.mfsummoner.creativetab.CreativeTabMFS;
import com.moldfire.mfsummoner.reference.Reference;
import com.moldfire.mfsummoner.utility.Formatting;

public class ItemMFS extends Item
{
	protected static Formatting F;
	public ItemMFS(String name)
	{
		super();
		this.setUnlocalizedName(name);
		this.setMaxStackSize(64);
		this.setCreativeTab(CreativeTabMFS.MFSTab);
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
