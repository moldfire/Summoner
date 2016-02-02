package com.moldfire.summoner.init;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.StatBase;
import net.minecraftforge.common.AchievementPage;


public class ModAchievments 
{
	public static StatBase achievementBindingGem = new Achievement("achievment.BindingGem", "BindingGem", 0, 0, ModItems.bindingGem, null).initIndependentStat().registerStat();;
	public static StatBase achievmentCapturedSoul = new Achievement("achievment.CapturedSoul", "CapturedSoul", 1, 1, Items.spawn_egg, (Achievement) achievementBindingGem).registerStat();
	public static StatBase achievmentSummoningAlter = new Achievement("achievment.SummoningAlter", "SummoningAlter", -1, 1, ModBlocks.alterStabiliser, (Achievement) achievementBindingGem).setSpecial().registerStat();
	public static StatBase achievmentSummonImp = new Achievement("achievment.SummonImp", "SummonImp", -1, 2, Items.spawn_egg, (Achievement) achievmentSummoningAlter).initIndependentStat().registerStat();
	
	public static void init()
	{			
		AchievementPage.registerAchievementPage( new AchievementPage("Summoner", new Achievement[]
				{
				(Achievement) achievementBindingGem,
				(Achievement) achievmentCapturedSoul,
				(Achievement) achievmentSummoningAlter,
				(Achievement) achievmentSummonImp
				}));		 	
	}
}
