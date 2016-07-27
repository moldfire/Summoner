package com.moldfire.summoner.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class ItemMFSLifestoneShard extends ItemMFS
{

	public ItemMFSLifestoneShard(String name, int maxStack, boolean creativeTab) 
	{
		super(name, maxStack, creativeTab);
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean bool)
	{
		list.add("Energy: "+stack.getItemDamage());
    }

}
