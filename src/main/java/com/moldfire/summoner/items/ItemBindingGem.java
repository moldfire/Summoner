package com.moldfire.summoner.items;

import java.util.List;

import com.moldfire.summoner.blocks.BlockAlterStabiliser;
import com.moldfire.summoner.init.ModAchievments;
import com.moldfire.summoner.init.ModBlocks;
import com.moldfire.summoner.utility.Formatting.color;
import com.moldfire.summoner.utility.Formatting.formatting;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

public class ItemBindingGem extends ItemMFS
{
	int maxEnergy0 = 200;
	
	public ItemBindingGem(String name, int maxStack, boolean creativeTab)
	{
		super(name, maxStack, creativeTab);
	}
	
	public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
    {
		
       if (!playerIn.canPlayerEdit(pos, side, stack))
        {
            return false;
        }
        else
        {   if(!worldIn.isRemote)
        	{
	    		IBlockState iblockstate = worldIn.getBlockState(pos);
	            Block block = iblockstate.getBlock();
	            
				if(!playerIn.isSneaking())
				{
					return spawnAlter(stack, playerIn, worldIn, pos, iblockstate, block);
				}
        	}
            return false;
        }
    }
	
	@Override
	public void onCreated(ItemStack stack, World world, EntityPlayer player)
	{
		if (!stack.hasTagCompound())
		{
			stack.setTagCompound(new NBTTagCompound());
			createNBT(stack);
		}
	}
	
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected)
	{
		if (!stack.hasTagCompound())
		{
			stack.setTagCompound(new NBTTagCompound());
			createNBT(stack);
		}
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean bool)
	{
		if (!stack.hasTagCompound())
		{
			stack.setTagCompound(new NBTTagCompound());
			createNBT(stack);
		}
		if(checkTags(stack, "stoneLevel"))
		{
			switch(stack.getTagCompound().getInteger("stoneLevel"))
			{
			case 0:
				list.add("Level: "+F.format(color.DarkRed)+"Imperfect");
				break;
				
			case 1:
				list.add("Level: "+F.format(color.Gold)+"Lesser");
				break;
				
			case 2:
				list.add("Level: "+F.format(color.DarkGreen)+"Greater");
				break;
			}
		}
		if(checkTags(stack, "maxEnergy"))
		{
			list.add(F.format(color.none, formatting.Italic)+"Capacity: "+((float)stack.getItemDamage()/stack.getTagCompound().getInteger("maxEnergy"))*100+"%");
		}
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World worldIn, EntityPlayer playerIn)
    {
        if(playerIn.isSneaking())
        {
			if(playerIn.capabilities.isCreativeMode)
			{
				stack.setItemDamage(stack.getTagCompound().getInteger("maxEnergy"));
			}
        }
        return stack;
    }
	
	@Override
	public boolean itemInteractionForEntity(ItemStack stack, EntityPlayer playerIn, EntityLivingBase target)
	{
		if(stack.getMetadata() < stack.getTagCompound().getInteger("maxEnergy"))
		{
			if (target instanceof EntityLiving)
	        {
				EntityLiving entityliving = (EntityLiving)target;
				
				switch(stack.getTagCompound().getInteger("StoneLevel"))
				{
				case 0:
					if(entityliving.isCreatureType(EnumCreatureType.CREATURE, false) || entityliving.isCreatureType(EnumCreatureType.WATER_CREATURE, false))
					{
			            entityliving.setDead();
			            stack.setItemDamage(stack.getMetadata()+(int)entityliving.getMaxHealth());
			            capEnergy(stack);
			            playerIn.addStat(ModAchievments.achievmentCapturedSoul, 1);
			            return true;
					}
				}
	        }
		}
		
		
		return false;
	}
	
	private void capEnergy(ItemStack stack)
	{
		if(stack.getMetadata() > stack.getTagCompound().getInteger("maxEnergy"))
        {
        	stack.setItemDamage(stack.getTagCompound().getInteger("maxEnergy"));
        }
	}
	
	private void createNBT(ItemStack stack)
	{
		if(!checkTags(stack,"playerName"))
		{	
			stack.getTagCompound().setString("playerName", "");
		}
		
		if(!checkTags(stack, "maxEnergy"))
		{	
			stack.getTagCompound().setInteger("maxEnergy", maxEnergy0);
		}
		
		if(!checkTags(stack, "stoneLevel"))
		{	
			stack.getTagCompound().setInteger("stoneLevel", 0);
		}
	}
	
	private boolean spawnAlter(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, IBlockState iblockstate, Block block)
	{
		if(stack.getMetadata() >= maxEnergy0)
    	{
			boolean flag = false;
			BlockPos currentPos = new BlockPos(pos.getX()-3, pos.getY(), pos.getZ()-3);
			Block block2 = null;
			
			//Check correct configuration of blocks
			for(int x = 0; x <= 6; x++)
			{
				for(int z = 0; z <= 6; z++)
				{
					BlockPos currentPos2 = new BlockPos(currentPos.getX()+x, currentPos.getY(), currentPos.getZ()+z);
					IBlockState iBlockState1 = worldIn.getBlockState(currentPos2);
					IBlockState iBlockState2 = worldIn.getBlockState(currentPos2.add(0, -1, 0));
					
					block = iBlockState1.getBlock();
					block2 = iBlockState2.getBlock();
					
					if(z == 0 && x == 3 || z == 3 && x == 0 || z == 3 && x == 6 || z == 6 && x == 3 ||z == 3 && x == 3)
					{
						if(block == Blocks.stone_slab && block.getMetaFromState(iblockstate) == 0)
						{
			            	if(block2 == Blocks.obsidian)
			            	{
			            		flag = true;
			            	}
						}
						else
						{
							return false;
						}
					}
				}
			}
			
			
			//If flag is true, build alter
			if(flag)
			{
				for(int x = 0; x <= 6; x++)
				{
					for(int z = 0; z <= 6; z++)
					{
						BlockPos currentPos2 = new BlockPos(currentPos.getX()+x, currentPos.getY(), currentPos.getZ()+z);
						IBlockState iBlockState1 = worldIn.getBlockState(currentPos2);
						IBlockState iBlockState2 = worldIn.getBlockState(currentPos2.add(0, -1, 0));
						
						block = iBlockState1.getBlock();
						block2 = iBlockState2.getBlock();
						
						if(z == 0 && x == 3 || z == 3 && x == 0 || z == 3 && x == 6 || z == 6 && x == 3)
						{

		            		worldIn.setBlockState(currentPos2.add(0, -1, 0), ModBlocks.alterStabiliser.getDefaultState().withProperty(BlockAlterStabiliser.SHAPE, BlockAlterStabiliser.EnumShape.OUTER));
		            		worldIn.setBlockToAir(currentPos2);
			            	worldIn.markBlockForUpdate(currentPos2);

						}
					
			            	worldIn.spawnParticle(EnumParticleTypes.EXPLOSION_HUGE, currentPos.getX()+0.5D, pos.getY()+0.5D, pos.getZ()+0.5D, 0.0D, 0.0D, 0.0D);
			               	stack.setItemDamage(0);
			            	playerIn.addStat(ModAchievments.achievmentSummoningAlter, 1);

							if(x == 3 && z == 3)
							{
								worldIn.setBlockToAir(currentPos2);
								worldIn.setBlockState(currentPos2.add(0,-1,0), ModBlocks.alterStabiliser.getDefaultState().withProperty(BlockAlterStabiliser.SHAPE, BlockAlterStabiliser.EnumShape.INNER));
							}
						}
					}
				}
				
				return true;
			}		
		return false;
	}

/* 	Move to summoning stone
 
  	private boolean summonCreature(TileEntityAlter tileEntity, ItemStack stack, EntityPlayer playerIn, BlockPos pos, World worldIn)
 
	{
		Entity entity = null;
		boolean spawn = false;
		
		//TODO Custom Creatures
		if(tileEntity.getStackInSlot(0).getItem() == Items.chicken)
		{
			entity = new EntityChicken(worldIn);
			playerIn.addStat(ModAchievments.achievmentSummonImp, 1);
			spawn = true;
		}
		
		if(spawn)
		{
			EntityLiving entityliving = (EntityLiving)entity;
	        entityliving.setLocationAndAngles(pos.getX(), pos.getY()+1, pos.getZ(), MathHelper.wrapAngleTo180_float(worldIn.rand.nextFloat() * 360.0F), 0.0F);
	        entityliving.rotationYawHead = entityliving.rotationYaw;
	        entityliving.renderYawOffset = entityliving.rotationYaw;
	        entityliving.func_180482_a(worldIn.getDifficultyForLocation(new BlockPos(entityliving)), (IEntityLivingData)null);
	        worldIn.spawnEntityInWorld(entityliving);
	        entityliving.playLivingSound();  
	        tileEntity.decrStackSize(0, 1);	
	        stack.setItemDamage(0);
			return true;
		}
		else
		{
			return false;
		}
		
	}
*/
}