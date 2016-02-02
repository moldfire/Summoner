package com.moldfire.summoner.items;

import java.util.List;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemSummoningStone extends ItemMFS
{
	private int boundTo;
	private boolean bound = false;
	
	/*	Move to summoning stone
	 * 	
	 * else  
			{
				if(block == ModBlocks.summonersAlter)
				{
					if(worldIn.getTileEntity(pos) instanceof TileEntityAlter)
					{
						TileEntityAlter tileEntity = (TileEntityAlter) worldIn.getTileEntity(pos);
						if(tileEntity.getStackInSlot(0) != null)
						{
    						return summonCreature(tileEntity, stack, playerIn, pos, worldIn);
						}
					}
				}
			}*/
	
	public ItemSummoningStone(String name, int maxStack, boolean creativeTab)
	{	
		super(name, maxStack, creativeTab);
	}
	
	@Override
	public void onCreated(ItemStack stack, World world, EntityPlayer player)
	{
		if (!stack.hasTagCompound())
		{
			stack.setTagCompound(new NBTTagCompound());
		}
		
		stack.getTagCompound().setBoolean("isBound", bound);
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean bool)
	{
		if (!stack.hasTagCompound())
		{
			stack.setTagCompound(new NBTTagCompound());
		}
		
		if(stack.getTagCompound().hasKey("isBound"))
		{
			if(stack.getTagCompound().getBoolean("isBound") == true)
			{
				list.add("isBound = true");
			}
			else if(stack.getTagCompound().getBoolean("isBound") == false)
			{
				list.add("isBound = false");
			}
			list.add("ABC");
		}
		list.add("DEF");
	}
	
	public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
    {
		if (worldIn.isRemote)
        {
            return false;
        }
		else
		{
			IBlockState iBlockState = worldIn.getBlockState(pos);
	        
	       // if(Block.isEqualTo(iBlockState.getBlock(), ModBlocks.summonersAlter))
	      //  {	
	        	//stack.getTagCompound().setBoolean("isBound", true);
	        	
	        	if(stack.getMetadata() >= 49 && this.bound == false)
	        	{
		        	Entity entity = spawnCreature(worldIn, stack.getMetadata(), (double)pos.getX(), (double)pos.getY() + 1.5D, (double)pos.getZ());
		        	entity.setCustomNameTag(playerIn.getDisplayNameString()+"s bound"+entity.getName());
		        	return true;
	        	}
	        	else
	        	{
	        		return false;
	        	}
	      //  }
	       // else
	       // {
	        	//return false;
	       // }
		}
    }
	
    public static Entity spawnCreature(World worldIn, int entityID, double x, double y, double z)
    {
        if (!EntityList.entityEggs.containsKey(Integer.valueOf(entityID)))
        {
            return null;
        }
        else
        {
            Entity entity = null;

            for (int j = 0; j < 1; ++j)
            {
                entity = new EntityCow(worldIn);

                if (entity instanceof EntityLivingBase)
                {
                    EntityLiving entityliving = (EntityLiving)entity;
                    entity.setLocationAndAngles(x, y, z, MathHelper.wrapAngleTo180_float(worldIn.rand.nextFloat() * 360.0F), 0.0F);
                    entityliving.rotationYawHead = entityliving.rotationYaw;
                    entityliving.renderYawOffset = entityliving.rotationYaw;
                    //entityliving.func_180482_a(worldIn.getDifficultyForLocation(new BlockPos(entityliving)), (IEntityLivingData)null);
                    worldIn.spawnEntityInWorld(entityliving);
                    entityliving.playLivingSound();
                }
            }

            return entity;
        }
    }
}
