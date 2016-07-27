package com.moldfire.summoner.entity;

import com.moldfire.summoner.init.ModItems;
import com.moldfire.summoner.reference.Reference;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class EntityMFSImp extends EntityAnimal
{
    public EntityMFSImp(World worldIn)
    {
        super(worldIn);
        this.setSize(0.4F, 0.6F);
        ((PathNavigateGround)this.getNavigator()).setAvoidsWater(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 2.0D));
        this.tasks.addTask(3, new EntityAITempt(this, 1.25D, Items.wheat, false));
        this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.20000000298023224D);
    }

    /**
     * Returns the sound this mob makes while it's alive.
     */
    @Override
    protected String getLivingSound()
    {
        return Reference.MOD_ID+":mob.imp.say";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    @Override
    protected String getHurtSound()
    {
        return Reference.MOD_ID+":mob.imp.hurt";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    @Override
    protected String getDeathSound()
    {
        return Reference.MOD_ID+":mob.imp.hurt";
    }

    @Override
    protected void playStepSound(BlockPos pos, Block blockIn)
    {
        
    }

    /**
     * Returns the volume for the sounds this mob makes.
     */
    @Override
    protected float getSoundVolume()
    {
        return 0.2F;
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
    	ItemStack stack = player.inventory.getCurrentItem();
    	
    	if(stack != null && stack.getItem() == ModItems.bindingStone /*&& this.bound == null*/)
    	{
    		//this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(5.0D);
    		return true;	
    	}
    	
        return false;
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