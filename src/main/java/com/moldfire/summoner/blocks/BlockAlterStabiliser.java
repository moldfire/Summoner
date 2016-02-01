package com.moldfire.summoner.blocks;

import java.util.Random;

import com.moldfire.summoner.init.ModBlocks;
import com.moldfire.summoner.tileentity.TileEntityCoreStabiliser;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.World;


public class BlockAlterStabiliser extends BlockMFS implements ITileEntityProvider
{
	public static final PropertyEnum SHAPE = PropertyEnum.create("shape", BlockAlterStabiliser.EnumShape.class);
	
	public BlockAlterStabiliser(String name, Material material, float hardness, boolean creativeTab)
	{
		super(name, material, hardness, creativeTab);
		this.setStepSound(soundTypeStone);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F);
		this.isBlockContainer = true;
	}
	
	@Override
	public int tickRate(World worldIn)
    {
        return 10;
    }
	
	@Override
	public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        return this.getStateFromMeta(meta);
    }
	
	@Override
	public int quantityDropped(Random random)
    {
        return 0;
    }
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        return false;
    }
	
	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
	{
		super.breakBlock(worldIn, pos, state);
		worldIn.removeTileEntity(pos);
	}
	
	@Override
    public boolean onBlockEventReceived(World worldIn, BlockPos pos, IBlockState state, int eventID, int eventParam) 
	{
        super.onBlockEventReceived(worldIn, pos, state, eventID, eventParam);
        TileEntity tileentity = worldIn.getTileEntity(pos);
        return tileentity == null ? false : tileentity.receiveClientEvent(eventID, eventParam);
    }
	
	@Override
	public void randomDisplayTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
	  if(this.getMetaFromState(state) == 1)
      {
		for (int i = 0; i < 10; ++i)
        {
            double d0 = (double)((float)pos.getX() + rand.nextFloat());
            double d1 = (double)((float)pos.getY() + rand.nextFloat());
            double d2 = (double)((float)pos.getZ() + rand.nextFloat());
            double d3 = ((double)rand.nextFloat() - 0.5D) * 0.5D;
            double d4 = ((double)rand.nextFloat() - 0.5D) * 0.5D;
            double d5 = ((double)rand.nextFloat() - 0.5D) * 0.5D;
            
            worldIn.spawnParticle(EnumParticleTypes.PORTAL, d0, d1+0.5, d2, d3, d4, d5, new int[0]);
            worldIn.spawnParticle(EnumParticleTypes.ENCHANTMENT_TABLE, d0, d1+1, d2, d3, d4, d5, new int[0]);
         }
      }
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
	protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {SHAPE});
    }
	
	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return getDefaultState().withProperty(SHAPE, meta == 0 ? EnumShape.OUTER : EnumShape.INNER);
	}
	
	@Override
	public int getMetaFromState(IBlockState state)
	{
		EnumShape shape = (EnumShape)state.getValue(SHAPE);
		return shape.getID();
	}
	
	public static enum EnumShape implements IStringSerializable
	{
		OUTER(0, "outer"),
		INNER(1, "inner");
		private final int ID;
		private final String name;
		
		private EnumShape(int ID, String name)
		{
			this.ID = ID;
			this.name = name;
		}
		
		@Override
		public String toString()
		{
			return this.getName();
		}
		
		@Override
		public String getName() 
		{
			return this.name;
		}
		
		public int getID()
		{
			return this.ID;
		}
	
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) 
	{
		if(meta == 1)
		{
			return new TileEntityCoreStabiliser();
		}
		
		return null;
	}
}
