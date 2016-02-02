package com.moldfire.summoner.event;

import com.moldfire.summoner.init.ModAchievments;
import com.moldfire.summoner.init.ModItems;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class MFEventHandler 
{
	@SubscribeEvent
	public void smeltedBindingGem(PlayerEvent.ItemSmeltedEvent e)
	{
		if(e.smelting.getItem().equals(ModItems.bindingGem))
		{
			e.player.addStat(ModAchievments.achievementBindingGem, 1);
		}
	}
}
