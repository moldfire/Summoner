package com.moldfire.summoner.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.World;

import com.google.common.collect.Lists;
import com.moldfire.summoner.MFSSummoningManager;
import com.moldfire.summoner.init.ModItems;
import com.moldfire.summoner.tileentity.TileEntityAlter;
import com.moldfire.summoner.tileentity.TileEntityPlinth;


public class BlockMFSAlter extends BlockMFS implements ITileEntityProvider
{
	public static final PropertyEnum STATE = PropertyEnum.create("state", BlockMFSAlter.EnumShape.class);
	
	public BlockMFSAlter(String name, Material material, float hardness, boolean creativeTab)
	{
		super(name, material, hardness, creativeTab);
		this.setStepSound(soundTypeStone);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
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
		if(!worldIn.isRemote)
		{
			ItemStack stack = playerIn.getHeldItem();
			if(stack.getItem() == ModItems.summoningStone)
			{
				summonCreature(worldIn, playerIn, pos);
			}
		}
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
        return new BlockState(this, new IProperty[] {STATE});
    }
	
	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return getDefaultState().withProperty(STATE, meta == 0 ? EnumShape.UNACTIVATED : EnumShape.ACTIVATED);
	}
	
	@Override
	public int getMetaFromState(IBlockState state)
	{
		EnumShape shape = (EnumShape)state.getValue(STATE);
		return shape.getID();
	}
	
	public static enum EnumShape implements IStringSerializable
	{
		UNACTIVATED(0, "unactivated"),
		ACTIVATED(1, "activated");
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
			return new TileEntityAlter();
		}
		
		return null;
	}
	
	private void summonCreature(World worldIn, EntityPlayer playerIn, BlockPos pos)
	{
		String name = null;
		int energy = 0;
		List<ItemStack> list = Lists.<ItemStack>newArrayList();
		BlockPos position = new BlockPos(pos.getX()-3, pos.getY(), pos.getZ()-3);
		TileEntity te;
		
		for(int x = 0; x <= 6; x++)
		{
			for(int z = 0; z <= 6; z++)
			{
				BlockPos currentPos = position.add(x, 0, z);
				te = worldIn.getTileEntity(currentPos);
				if(te != null && te instanceof TileEntityPlinth)
				{
					ItemStack stack = ((TileEntityPlinth) te).getStackInSlot(0);
					if(stack != null)
					{	
						if(stack.getItem() == Items.name_tag)
						{
							if(name != null)
							{name = stack.getDisplayName();}
						}
						else if(stack.getItem() == ModItems.lifestoneShard)
						{
							energy += stack.getItemDamage();
						}
						else
						{
							list.add(stack);
						}
					}
				}
			}
		}
		
		String summon = MFSSummoningManager.getInstance().findMatchingSummoning(list, energy);
		int cost = MFSSummoningManager.getInstance().getCost(summon);
				
		if (summon != null)
		{
			for(int x = 0; x <= 6; x++)
			{
				for(int z = 0; z <= 6; z++)
				{
					BlockPos currentPos = position.add(x, 0, z);
					te = worldIn.getTileEntity(currentPos);
					if(te != null && te instanceof TileEntityPlinth)
					{
						ItemStack stack = ((TileEntityPlinth) te).getStackInSlot(0);
						if(stack != null)
						{
							if(stack.getItem() == ModItems.lifestoneShard)
							{
								if(cost > 0)
								{
									if(stack.getItemDamage() > cost)
									{
										stack.setItemDamage(stack.getItemDamage()-cost);
										cost = 0;
									}
									else if(stack.getItemDamage() <= cost)
									{
										cost -= stack.getItemDamage();
										((TileEntityPlinth) te).removeStackFromSlot(0);
									}
								}
							}
							else
							{
								((TileEntityPlinth) te).removeStackFromSlot(0);
							}
						}
					}
				}
			}
			
			Entity entity = ItemMonsterPlacer.spawnCreature(worldIn, summon, pos.getX(), pos.getY()+1, pos.getZ());
	        
	        if(name != null)
	        {
	        	entity.setCustomNameTag(name);
	        	playerIn.addChatMessage(new ChatComponentText("You have summoned a " +summon.substring(summon.indexOf(".")+1)+" named "+ entity.getName()));
	        }
	        else
	        {
	        	playerIn.addChatMessage(new ChatComponentText("You have summoned a " +summon.substring(summon.indexOf(".")+1)));
	        }
		}
		else
		{
			playerIn.addChatMessage(new ChatComponentText("Invalid Summoning"));
		}
	}
}
