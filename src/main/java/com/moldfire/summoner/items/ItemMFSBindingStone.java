package com.moldfire.summoner.items;

import java.util.List;

import com.moldfire.summoner.entity.EntityMFS;
import com.moldfire.summoner.entity.EntityMFSKelpie;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class ItemMFSBindingStone extends ItemMFS
{
	public ItemMFSBindingStone(String name, int maxStack, boolean creativeTab) 
	{
		super(name, maxStack, creativeTab);
	}
	
	@Override
	public void onCreated(ItemStack stack, World world, EntityPlayer player)
	{
		if(!stack.hasTagCompound())
		{
			stack.setTagCompound(new NBTTagCompound());
		}
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World worldIn, EntityPlayer playerIn)
	{
		if(!worldIn.isRemote)
		{
			if(playerIn.isSneaking())
			{
				if(!stack.hasTagCompound())
				{
					stack.setTagCompound(new NBTTagCompound());
				}
				
				stack.getTagCompound().setString("Owner", playerIn.getDisplayNameString());
				stack.getTagCompound().setString("OwnerUUID", playerIn.getUUID(playerIn.getGameProfile()).toString());
			}
		}
		return stack;
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean bool)
	{
		if(!stack.hasTagCompound())
		{
			stack.setTagCompound(new NBTTagCompound());
		}
		
		if(stack.getTagCompound().hasKey("Owner") && stack.getTagCompound().hasKey("OwnerUUID"))
		{
			list.add("Owner: "+stack.getTagCompound().getString("Owner"));
			list.add("UUID: "+stack.getTagCompound().getString("OwnerUUID"));
		}
    }
	
	@Override
	public boolean itemInteractionForEntity(ItemStack stack, EntityPlayer playerIn, EntityLivingBase target)
	{		
		return false;
	}
}
