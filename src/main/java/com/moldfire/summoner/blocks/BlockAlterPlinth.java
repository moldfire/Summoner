package com.moldfire.summoner.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

import java.util.Random;

import com.moldfire.summoner.tileentity.TileEntityPlinth;

public class BlockAlterPlinth extends BlockContainerMFS
{

	public BlockAlterPlinth(String name, Material material, float hardness, boolean creativeTab) 
	{
		super(name, material, hardness);
	}
	
	public boolean isOpaqueCube()
    {
        return false;
    }
	
	public boolean isFullCube()
    {
        return false;
    }
	
	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState blockstate)
	{
		TileEntityPlinth te = (TileEntityPlinth)worldIn.getTileEntity(pos);
		InventoryHelper.dropInventoryItems(worldIn, pos, te);
		super.breakBlock(worldIn, pos, blockstate);
		worldIn.removeTileEntity(pos);
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) 
	{
		return new TileEntityPlinth();
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
    {
		if(!worldIn.isRemote)
		{
			ItemStack stack = playerIn.getHeldItem();
			TileEntityPlinth te = (TileEntityPlinth)worldIn.getTileEntity(pos);
			
			if(stack != null)
			{
				Item item = stack.getItem();
				
				if(te.getStackInSlot(0) == null)
				{
					te.setInventorySlotContents(0, playerIn.getHeldItem().copy());
					playerIn.inventory.consumeInventoryItem(playerIn.getHeldItem().getItem());
				}
				else
				{
					playerIn.addChatMessage(new ChatComponentText("Plinth is full"));
				}
				return true;
			}
			else
			{
				if(playerIn.isSneaking())
				{
					InventoryHelper.dropInventoryItems(worldIn, pos, te);
					te.clear();
				}
			}
			return false;
		}
		return false;
    }
}
