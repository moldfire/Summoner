package com.moldfire.summoner.items;

import com.moldfire.summoner.MFSummoner;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSummoningBook extends ItemMFS
{

	public ItemSummoningBook(String name, int maxStack, boolean creativeTab) 
	{
		super(name, maxStack, creativeTab);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World worldIn, EntityPlayer playerIn)
	{
		if(worldIn.isRemote)
		{
			System.out.println("Summon Book Right Clicked");
			playerIn.openGui(MFSummoner.instance, 0, worldIn, (int)playerIn.posX, (int)playerIn.posY, (int)playerIn.posZ);
		}
		
		System.out.println("Gui Called, Returning Stack");
		return stack;
	}

}
