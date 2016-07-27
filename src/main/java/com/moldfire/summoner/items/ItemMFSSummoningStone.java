package com.moldfire.summoner.items;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

import com.moldfire.summoner.blocks.BlockMFSAlter;
import com.moldfire.summoner.init.ModBlocks;

public class ItemMFSSummoningStone extends ItemMFS
{
	public ItemMFSSummoningStone(String name, int maxStack, boolean creativeTab)
	{	
		super(name, maxStack, creativeTab);
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
    {
       if(worldIn.isRemote)
       {
    	   return false;
       }
       else
       {
    	   IBlockState iBlockState = worldIn.getBlockState(pos);
    	   Block block = iBlockState.getBlock();
    	   
    	   if(iBlockState == ModBlocks.alter.getStateFromMeta(0))
    	   {
    		 worldIn.setBlockState(pos, ModBlocks.alter.getStateFromMeta(1));
    		 //TODO - Add altar change particle
    		 worldIn.updateEntities();
    	   }
    	   return true;
       }
    }
	
	@Override
	public void onCreated(ItemStack stack, World world, EntityPlayer player)
	{
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean bool)
	{
    }
}
