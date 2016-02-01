package com.moldfire.summoner.tileentity;

import java.util.Arrays;

import com.moldfire.summoner.init.ModBlocks;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityCoreStabiliser extends TileEntity //implements IUpdatePlayerListBox
{
	public static final String name = "tileEntityStabiliser";
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

	public void update() 
	{
		boolean flag = true;
		
		if(!this.worldObj.isRemote)
		{
			if(this.getWorld().getBlockState(this.pos.add(3, 0, 0)).getBlock() == ModBlocks.alterStabiliser)
			{
				if(this.getWorld().getBlockState(this.pos.add(-3, 0, 0)).getBlock() == ModBlocks.alterStabiliser)
				{
					if(this.getWorld().getBlockState(this.pos.add(0, 0, 3)).getBlock() == ModBlocks.alterStabiliser)
					{
						if(this.getWorld().getBlockState(this.pos.add(0, 0, -3)).getBlock() == ModBlocks.alterStabiliser)
						{
							flag = false;
						}
					}
				}
			}
			
			
		if(flag)
			{
				System.out.println("flag triggerd - stabiliser missing");
				if(this.getWorld().getBlockState(this.pos.add(3, 0, 0)).getBlock() == ModBlocks.alterStabiliser)
				{
					this.getWorld().destroyBlock(this.pos.add(3, 0, 0), false);
					this.getWorld().markBlockForUpdate(this.pos.add(3, 0, 0));
				}
				if(this.getWorld().getBlockState(this.pos.add(-3, 0, 0)).getBlock() == ModBlocks.alterStabiliser)
				{
					this.getWorld().destroyBlock(this.pos.add(-3, 0, 0), false);
					this.getWorld().markBlockForUpdate(this.pos.add(-3, 0, 0));
				}
				if(this.getWorld().getBlockState(this.pos.add(0, 0, 3)).getBlock() == ModBlocks.alterStabiliser)
				{
					this.getWorld().destroyBlock(this.pos.add(0, 0, 3), false);
					this.getWorld().markBlockForUpdate(this.pos.add(0, 0, 3));
				}
				if(this.getWorld().getBlockState(this.pos.add(0, 0, -3)).getBlock() == ModBlocks.alterStabiliser)
				{
					this.getWorld().destroyBlock(this.pos.add(0, 0, -3), false);
					this.getWorld().markBlockForUpdate(this.pos.add(0, 0, -3));
				}
				this.getWorld().destroyBlock(pos, false);
			}
		}
	}
}