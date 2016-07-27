package com.moldfire.summoner.tileentity;

import java.util.Arrays;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IChatComponent;

public class TileEntityPlinth extends TileEntity implements IInventory
{
	public static final String name = "tileEntityPlinth";
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
	public String getName() 
	{
		return name;
	}

	@Override
	public boolean hasCustomName() 
	{
		return false;
	}

	@Override
	public IChatComponent getDisplayName() 
	{
		return null;
	}

	@Override
	public int getSizeInventory() 
	{
		return this.itemStack.length;
	}

	@Override
	public ItemStack getStackInSlot(int index) 
	{
		if( index < 0 || index >= this.getSizeInventory())
		return null;
		
		return this.itemStack[index];
	}

	@Override
	public ItemStack decrStackSize(int index, int count) 
	{
		if(this.getStackInSlot(index) != null)
		{
			ItemStack stack;
			
			if(this.getStackInSlot(index).stackSize <= count)
			{
				stack = this.getStackInSlot(index);
				this.setInventorySlotContents(index, null);
				this.markDirty();
				return stack;
			}
			else
			{
				stack = this.getStackInSlot(index).splitStack(count);
				
				if(this.getStackInSlot(index).stackSize <= 0)
				{
					this.setInventorySlotContents(index, null);
				}
				else
				{
					this.setInventorySlotContents(index, this.getStackInSlot(index));
				}
				
				this.markDirty();
				return stack;
			}
		}
		
		return null;
	}

	@Override
	public ItemStack removeStackFromSlot(int index) 
	{
		ItemStack stack = this.getStackInSlot(index);
		this.setInventorySlotContents(index, null);
		return stack;
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) 
	{
		if(index < 0 || index >= this.getSizeInventory())
		{
			return;
		}
		
		if( stack != null && stack.stackSize > this.getInventoryStackLimit())
		{
			stack.stackSize = this.getInventoryStackLimit();
		}
		
		if(stack != null && stack.stackSize == 0)
		{
			stack = null;
		}
		
		this.itemStack[index] = stack;
		this.markDirty();		
	}

	@Override
	public int getInventoryStackLimit() 
	{
		return 1;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) 
	{
		return this.worldObj.getTileEntity(this.getPos()) == this && player.getDistanceSq(this.pos.add(0.5, 0.5, 0.5)) <= 64;
	}

	@Override
	public void openInventory(EntityPlayer player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeInventory(EntityPlayer player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) 
	{
		return true;
	}

	@Override
	public int getField(int id) 
	{
		return 0;
	}

	@Override
	public void setField(int id, int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getFieldCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void clear() 
	{
		for(int i = 0; i < this.getSizeInventory(); i++)
		{
			this.setInventorySlotContents(i, null);
		}
	}
}
