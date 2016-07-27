package com.moldfire.summoner.items;

import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class ItemMFSDebug extends ItemMFS
{
	public ItemMFSDebug(String name, int maxStack, boolean creativeTab) 
	{
		super(name, maxStack, creativeTab);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World worldIn, EntityPlayer playerIn)
	{
		return stack;
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean bool)
	{
		if(!stack.hasTagCompound())
		{
			stack.setTagCompound(new NBTTagCompound());
		}
		
		int count = stack.getTagCompound().getKeySet().size();
		
		list.add("Tag Count: "+ count);
    }
	
	@Override
	public boolean itemInteractionForEntity(ItemStack stack, EntityPlayer playerIn, EntityLivingBase target)
	{
		stack.setTagCompound(target.getNBTTagCompound());
		return true;
	}
	
	public void getNBTTag(ItemStack stack, NBTTagCompound compound)
	{
		stack.setTagCompound(compound);
	}

}
