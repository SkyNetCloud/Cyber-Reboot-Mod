package xyz.skynetcloud.cyberx.world.generation;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import xyz.skynetcloud.cyberx.init.BlockInit;

public class WorldGenOres implements IWorldGenerator {

	private WorldGenerator end_vibranium_ore, vibranium_ore;
	private WorldGenerator dark_steel_ore;
	private WorldGenerator ruby_ore, nether_ruby_ore;
	private WorldGenerator cloud_block;
	
    public WorldGenOres() 
	{
    	
      end_vibranium_ore = new WorldGenMinable(BlockInit.END_VIBRANIUM_ORE.getDefaultState(),9, BlockMatcher.forBlock(Blocks.END_STONE));
      vibranium_ore = new WorldGenMinable(BlockInit.VIBRANIUM_ORE.getDefaultState(),9, BlockMatcher.forBlock(Blocks.STONE));
      dark_steel_ore = new WorldGenMinable(BlockInit.DARK_STEEL_ORE.getDefaultState(), 9, BlockMatcher.forBlock(Blocks.STONE));
      nether_ruby_ore = new WorldGenMinable(BlockInit.RUBY_ORE.getDefaultState(), 9, BlockMatcher.forBlock(Blocks.NETHERRACK));
      ruby_ore = new WorldGenMinable(BlockInit.RUBY_ORE.getDefaultState(), 9, BlockMatcher.forBlock(Blocks.STONE));
     
      cloud_block = new WorldGenMinable(BlockInit.CLOUD_BLOCK.getDefaultState(), 5, BlockMatcher.forBlock(Blocks.WOOL));
      
	}
	
	@Override
	public void generate(Random rand, int X, int Z, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) 
	{
		switch(world.provider.getDimension())
		{
		//Nether
		case -1:
		
			runGenerator(nether_ruby_ore, world, rand, X, Z, 50, 0, 100);
		
			break;
		//OverWorld
		case 0:

			runGenerator(vibranium_ore, world, rand, X, Z, 1, 1, 15);
			runGenerator(dark_steel_ore, world, rand, X, Z, 10, 1, 15);
			runGenerator(ruby_ore, world, rand, X, Z, 15, 1, 15 );
			runGenerator(cloud_block, world, rand, X, Z, 4, 150, 200);
			break;
		//End
		case 1:
			runGenerator(end_vibranium_ore, world, rand, X, Z, 50, 0, 100);
			
		}
	}
	private void runGenerator(WorldGenerator gen, World world, Random rand, int X, int Z, int chance, int minHeight, int maxHeight)
	{
		if(minHeight > maxHeight || minHeight < 0 || maxHeight > 256) throw new IllegalArgumentException("Ore generated out of bounds");
	
		int heightDiff = maxHeight - minHeight + 1;
		for(int i = 0; i < chance; i++)
		{
			int x = X * 16 + rand.nextInt(16);
			int y = minHeight + rand.nextInt(heightDiff);
		    int z = Z * 16 + rand.nextInt(16);
		    
		    gen.generate(world, rand, new BlockPos(x,y,z));
		}
		
	}

}
