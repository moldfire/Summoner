package com.moldfire.summoner.blocks;

import java.util.Random;

import com.moldfire.summoner.init.ModItems;
import com.moldfire.summoner.items.ItemMFSLifestoneShard;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public class BlockMFSOreLifestone extends BlockMFS
{

	public BlockMFSOreLifestone(String name, Material material, float hardness, boolean creativeTab)
	{
		super(name, material, hardness, creativeTab);
		this.setHarvestLevel("pickaxe", 2);
		this.setLightLevel(2.0F);
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return ModItems.lifestoneShard;
    }
	
	@Override
	public int damageDropped(IBlockState state)
    {
        return (int)((Math.random()*10)+1);
    }
	
	@Override
	public int quantityDropped(Random random)
    {
        return 1 + random.nextInt(2);
    }
	
}
