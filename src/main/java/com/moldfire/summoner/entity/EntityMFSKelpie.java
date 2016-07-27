package com.moldfire.summoner.entity;

import com.google.common.base.Predicate;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAIRunAroundLikeCrazy;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITargetNonTamed;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.potion.Potion;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityMFSKelpie extends EntityMFS
{
    public EntityMFSKelpie(World worldIn)
    {
        super(worldIn);
        
        ((PathNavigateGround)this.getNavigator()).setAvoidsWater(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 1.2D));
        this.tasks.addTask(2, new EntityAIWander(this, 0.7D));
        this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(4, new EntityAILookIdle(this));
     
        this.setTamed(false);
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(53.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.42499999403953552D);    
    }
    
    @Override
    public boolean canBreatheUnderwater()
    {
        return true;
    }
    
    @Override
    public void onLivingUpdate()
    {
    	super.onLivingUpdate();

    	for(int y = 0; y < 3; y++)
    	{
        	if(worldObj.getBlockState(getPosition().add(0, -y, 0)) == Blocks.air.getDefaultState())
        	{
        		continue;
        	}
        	if(worldObj.getBlockState(new BlockPos(getPosition().add(0, -y, 0))) == Blocks.water.getDefaultState())
        	{
        		this.inWater = true;
        		break;
        	}
        	else if(worldObj.getBlockState(getPosition().add(0, -y, 0)) != Blocks.air.getDefaultState() 
        			&& worldObj.getBlockState(new BlockPos(getPosition().add(0, -y, 0))) != Blocks.water.getDefaultState())
        	{
        		this.inWater = false;
        		break;
        	}

        	/*if(this.isTamed())
        	{
        		if(!this.inWater)
        		{
        			this.worldObj.spawnParticle(EnumParticleTypes.REDSTONE, this.posX, this.posY+2, this.posZ, 0, 0.1F, 0, 0);
        		}
        		else
        		{
        			this.worldObj.spawnParticle(EnumParticleTypes.REDSTONE, this.posX-1, this.posY+2, this.posZ, 0, 0.1F, 0, 0);
        		}
        	}*/
    	}
    	
    	
    	
    	if(this.isInWater())
    	{
    		this.setSize(1.4F, 1.6F);
    	}
    	else
    	{
    		this.setSize(0.6F, 1.8F);
    	}
    }
    
    private void mountTo(EntityPlayer player)
    {
        player.rotationYaw = this.rotationYaw;
        player.rotationPitch = this.rotationPitch;
        //this.setEatingHaystack(false);
        //this.setRearing(false);

        if (!this.worldObj.isRemote)
        {
            player.mountEntity(this);
        }
    }
    
    /**
     * Returns the sound this mob makes while it's alive.
     */
    @Override
    protected String getLivingSound()
    {
        return null;//Reference.MOD_ID+":mob.imp.say";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    @Override
    protected String getHurtSound()
    {
        return null;//Reference.MOD_ID+":mob.imp.hurt";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    @Override
    protected String getDeathSound()
    {
        return null;//Reference.MOD_ID+":mob.imp.hurt";
    }

    @Override
    protected void playStepSound(BlockPos pos, Block blockIn)
    {
        //this.playSound("mob.horse.step", 0.15F, 1.0F);
    }

    /**
     * Returns the volume for the sounds this mob makes.
     */
    @Override
    protected float getSoundVolume()
    {
        return 0.4F;
    }
    
    @Override
    protected Item getDropItem()
    {
        return null;
    }

    /**
     * Drop 0-2 items of this living's type
     */
    @Override
    protected void dropFewItems(boolean p_70628_1_, int p_70628_2_)
    {
        
    }

    /**
     * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
     */
    @Override
    public boolean interact(EntityPlayer player)
    {
    	super.interact(player);
    	
    	if(this.isTamed() && this.riddenByEntity == null)
    	{
    		this.mountTo(player);
            return true;
    	}
        return false;
    }

    @Override
    public void moveEntityWithHeading(float strafe, float forward)
    {
    	if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityLivingBase && this.isTamed())
        {
    		this.prevRotationYaw = this.rotationYaw = this.riddenByEntity.rotationYaw;
            this.rotationPitch = this.riddenByEntity.rotationPitch * 0.5F;
            this.setRotation(this.rotationYaw, this.rotationPitch);
            this.rotationYawHead = this.renderYawOffset = this.rotationYaw;
            strafe = ((EntityLivingBase)this.riddenByEntity).moveStrafing * 0.5F;
            forward = ((EntityLivingBase)this.riddenByEntity).moveForward;

            if (forward <= 0.0F)
            {
                forward *= 0.25F;
            }
            
            if (this.onGround)
            {
                strafe = 0.0F;
                forward = 0.0F;
                
                this.motionY = 0;

                this.isAirBorne = true;

                if (forward > 0.0F)
                {
                    float f = MathHelper.sin(this.rotationYaw * (float)Math.PI / 180.0F);
                    float f1 = MathHelper.cos(this.rotationYaw * (float)Math.PI / 180.0F);
                    this.motionX += (double)(-0.16F * f);
                    this.motionZ += (double)(0.16F * f1);
                }
            }
            
            this.stepHeight = 1.0F;
            
            if(!this.inWater && this.riddenByEntity != null)
            {
            	this.jumpMovementFactor = this.getAIMoveSpeed() * 0.1F;
            }
            else
            {
            	this.jumpMovementFactor = this.getAIMoveSpeed() * 2F;
            }
            
            if (!this.worldObj.isRemote)
            {
                this.setAIMoveSpeed((float)this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getAttributeValue());
                super.moveEntityWithHeading(strafe, forward);
            }
            
            this.prevLimbSwingAmount = this.limbSwingAmount;
            double d1 = this.posX - this.prevPosX;
            double d0 = this.posZ - this.prevPosZ;
            float f2 = MathHelper.sqrt_double(d1 * d1 + d0 * d0) * 4.0F;

            if (f2 > 1.0F)
            {
                f2 = 1.0F;
            }

            this.limbSwingAmount += (f2 - this.limbSwingAmount) * 0.4F;
            this.limbSwing += this.limbSwingAmount;
        }
    	else
        {
            this.stepHeight = 0.5F;
            this.jumpMovementFactor = 0.02F;
            super.moveEntityWithHeading(strafe, forward);
        }
    }

    
    @Override
    public float getEyeHeight()
    {
        return this.height;
    }

	@Override
	public EntityAgeable createChild(EntityAgeable ageable) 
	{
		return null;
	}
	
}