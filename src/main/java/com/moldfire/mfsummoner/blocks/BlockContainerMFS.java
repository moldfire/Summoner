package com.moldfire.mfsummoner.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.moldfire.mfsummoner.creativetab.CreativeTabMFS;
import com.moldfire.mfsummoner.reference.Reference;

public class BlockContainerMFS extends BlockContainer
{
	public BlockContainerMFS(String name, Material material, float hardness)
	{
		super(material);
		this.setUnlocalizedName(name);
		this.setCreativeTab(CreativeTabMFS.MFSTab);
		this.setHardness(hardness);
		this.isBlockContainer = true;
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
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) 
	{
		return null;
	}
	
	@Override
	public int getRenderType()
	{
		return 3;
	}


}
