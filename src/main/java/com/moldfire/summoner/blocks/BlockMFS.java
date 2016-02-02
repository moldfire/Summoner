package com.moldfire.summoner.blocks;

import com.moldfire.summoner.creativetab.CreativeTabMFS;
import com.moldfire.summoner.reference.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockMFS extends Block
{
	public BlockMFS(String name, Material material, float hardness, boolean creativeTab)
	{
		super(material);
		this.setUnlocalizedName(name);
		if(creativeTab)this.setCreativeTab(CreativeTabMFS.MFSTab);
		this.setHardness(hardness);
	}
	
	@Override
	public String getUnlocalizedName()
	{
		return String.format("tile.%s%s", Reference.MOD_ID + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}
	
	private String getUnwrappedUnlocalizedName(String unlocalizedName) 
	{
		return unlocalizedName.substring(unlocalizedName.indexOf(".")+1);
	}
}
