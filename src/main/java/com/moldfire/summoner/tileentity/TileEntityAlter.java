package com.moldfire.summoner.tileentity;

import java.util.Arrays;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;

public class TileEntityAlter extends TileEntity implements ITickable
{
	public static final String name = "tileEntityAlter";
	private ItemStack itemStack[] = new ItemStack[1];
	
	@Override
	public void writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);
		
		NBTTagList slots = new NBTTagList();
		for(int i = 0; i < this.itemStack.length; ++i)
		{
			if(this.itemStack[i] != null)
			{
				NBTTagCompound slot = new NBTTagCompound();
				slot.setByte("Slot", (byte)i);
				this.itemStack[i].writeToNBT(slot);
				slots.appendTag(slot);
			}
		}
		compound.setTag("Items", slots);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);
		final byte NBT_TYPE_COMPOUND = 10;
		NBTTagList slots = compound.getTagList("Items", NBT_TYPE_COMPOUND);
		
		Arrays.fill(itemStack, null);
		for(int i = 0; i < slots.tagCount(); ++i)
		{
			NBTTagCompound slot = slots.getCompoundTagAt(i);
			int slotIndex = slot.getByte("Slot") & 255;
			
			if(slotIndex >=0 && slotIndex <= this.itemStack.length)
			{
				this.itemStack[slotIndex] = ItemStack.loadItemStackFromNBT(slot);
			}
		}
	}

	@Override
	public void update() 
	{
		
	}

}
