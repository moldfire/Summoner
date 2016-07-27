package com.moldfire.summoner.world;

import java.util.Random;

import com.moldfire.summoner.init.ModBlocks;

import net.minecraft.block.state.pattern.BlockHelper;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenMFS implements IWorldGenerator
{
	private WorldGenerator gen_OreLifestone;
	
	public WorldGenMFS()
	{
		this.gen_OreLifestone = new WorldGenMFSMinable(ModBlocks.oreLifestone.getDefaultState(), 4);
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator,	IChunkProvider chunkProvider) 
	{
		switch(world.provider.getDimensionId())
		{
		case 0: //Overworld
			this.runGenerator(this.gen_OreLifestone, world, random, chunkX, chunkZ, 15, 0, 256);
			break;
			
		default:
			break;
		}
	}
	
	private void runGenerator(WorldGenerator generator, World world, Random rand, int chunk_X, int chunk_Z, int chancesToSpawn, int minHeight, int maxHeight) 
	{
	    if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
	        throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");
	    
	    
	    int heightDiff = maxHeight - minHeight + 1;
	    for (int i = 0; i < chancesToSpawn; i ++) 
	    {
	        int x = chunk_X * 16 + rand.nextInt(16);
	        int y = minHeight + rand.nextInt(heightDiff);
	        int z = chunk_Z * 16 + rand.nextInt(16);
	        generator.generate(world, rand, new BlockPos(x, y, z));
	    }
	
	}
}
