package com.moldfire.mfsummoner.blocks;

import com.moldfire.mfsummoner.creativetab.CreativeTabMFS;
import com.moldfire.mfsummoner.reference.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockMFS extends Block
{
	public BlockMFS(String name, Material material, float hardness)
	{
		super(material);
		this.setUnlocalizedName(name);
		this.setCreativeTab(CreativeTabMFS.MFSTab);
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
