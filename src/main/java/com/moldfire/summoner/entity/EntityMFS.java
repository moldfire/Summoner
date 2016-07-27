package com.moldfire.summoner.entity;

import com.google.common.base.Predicate;
import com.moldfire.summoner.init.ModItems;
import com.moldfire.summoner.items.ItemMFSDebug;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBeg;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITargetNonTamed;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityMFS extends EntityTameable
{	
    public EntityMFS(World worldIn)
    {
        super(worldIn);
    }

	@Override
	public EntityAgeable createChild(EntityAgeable ageable) 
	{
		return null;
	}
	
    public boolean isBound()
    {
    	return this.isTamed();
    }
    
    @Override
    public boolean interact(EntityPlayer player)
    {
        ItemStack itemstack = player.inventory.getCurrentItem();

        if (this.isTamed())
        {
            if (!this.worldObj.isRemote)
            {
                this.aiSit.setSitting(!this.isSitting());
                this.isJumping = false;
                this.navigator.clearPathEntity();
                this.setAttackTarget((EntityLivingBase)null);
            }
        }
        else if (itemstack != null && itemstack.getItem() == ModItems.bindingStone)
        {
            if (!player.capabilities.isCreativeMode)
            {
                //--itemstack.stackSize;
            }

            if (!this.worldObj.isRemote)
            {
                this.setTamed(true);
                this.navigator.clearPathEntity();
                this.setAttackTarget((EntityLivingBase)null);
                //this.aiSit.setSitting(true);
                this.setHealth(20.0F);
                this.setOwnerId(player.getUniqueID().toString());
                this.playTameEffect(true);
                this.worldObj.setEntityState(this, (byte)7);
            }

            return true;
        }

        return super.interact(player);
    }
}