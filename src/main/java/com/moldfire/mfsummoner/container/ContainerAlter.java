package com.moldfire.mfsummoner.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import com.moldfire.mfsummoner.tileentity.TileEntityCoreStabiliser;

public class ContainerAlter extends Container 
{
	private TileEntityCoreStabiliser tileEntityAlter;
	
	//Players Inventory
	private final int HOTBAR_SLOT_COUNT = 9;
	private final int PLAYER_INV_ROWS = 3;
	private final int PLAYER_INV_COLS = 9;
	private final int PLAYER_INV_COUNT = PLAYER_INV_ROWS * PLAYER_INV_COLS;
	private final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INV_COUNT;
	
	private final int TE_SLOT_INDEX = VANILLA_SLOT_COUNT;
	
	public ContainerAlter(InventoryPlayer invPlayer, TileEntityCoreStabiliser tileEntityAlter)
	{
		this.tileEntityAlter = tileEntityAlter;
		
		final int X_SPACING = 18;
		final int Y_SPACING = 18;
		
		final int HOTBAR_XPOS = 8;
		final int HOTBAR_YPOS = 108;
		
		//add the hotbar to the container
		for(int x = 0; x < HOTBAR_SLOT_COUNT; ++x)
		{
			addSlotToContainer(new Slot(invPlayer, x, HOTBAR_XPOS + X_SPACING * x, HOTBAR_YPOS));
		}
		
		final int PLAYER_INV_XPOS = 8;
		final int PLAYER_INV_YPOS = 50;
		//add the rest of the players inventory
		for(int y = 0; y < PLAYER_INV_ROWS; y++)
		{
			for(int x = 0; x < PLAYER_INV_COLS; x++)
			{
				int xpos = PLAYER_INV_XPOS + x * X_SPACING;
				int ypos = PLAYER_INV_YPOS + y * Y_SPACING;
				addSlotToContainer(new Slot(invPlayer, HOTBAR_SLOT_COUNT+y * PLAYER_INV_COLS +x, xpos, ypos));
			}
		}
		
		//Add the container inventory
		//addSlotToContainer(new Slot(tileEntityAlter, 0, 52, 26));
		//addSlotToContainer(new Slot(tileEntityAlter, 1, 116, 26));
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer playerIn) 
	{
		return false;//tileEntityAlter.isUseableByPlayer(playerIn);
	}
	
	@Override
	public void onContainerClosed(EntityPlayer playerIn)
	{
		super.onContainerClosed(playerIn);
		//this.tileEntityAlter.closeInventory(playerIn);
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int slotIndex)
	{
		return null;
	}
}
