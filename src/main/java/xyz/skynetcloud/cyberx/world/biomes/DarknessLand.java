package xyz.skynetcloud.cyberx.world.biomes;

import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.BiomeProperties;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import xyz.skynetcloud.cyberx.init.BlockInit;

public class DarknessLand extends Biome {

	public DarknessLand() {
		super(new BiomeProperties("Darkness_Biome").setBaseHeight(1.0F).setHeightVariation(1.0F).setRainDisabled().setTemperature(1.0F));
		
		
		topBlock = BlockInit.DARKBLOCK.getDefaultState();
		fillerBlock = BlockInit.DARK_STEEL_ORE.getDefaultState();
		
		
		this.spawnableCaveCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		
		this.spawnableCreatureList.add(new SpawnListEntry(EntityCow.class, 5, 1, 5));
		this.spawnableCreatureList.add(new SpawnListEntry(EntityChicken.class, 5, 1, 5));
		
		
	}

}
