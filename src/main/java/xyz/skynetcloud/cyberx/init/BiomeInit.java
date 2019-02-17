package xyz.skynetcloud.cyberx.init;


import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import xyz.skynetcloud.cyberx.util.ModConfig;
import xyz.skynetcloud.cyberx.world.biomes.DarknessLand;
import xyz.skynetcloud.cyberx.world.biomes.GlassBiome;

public class BiomeInit 
{
	public static final Biome GLASSLANDS = new GlassBiome();
	public static final Biome DARKNESS = new DarknessLand();
	
	public static void registerBiomes()
	{
		initBiome(GLASSLANDS, "GlassLand", BiomeType.COOL, Type.FOREST, Type.COLD, Type.DRY);
		initBiome(DARKNESS, "Darkness_Land", BiomeType.COOL, Type.DENSE, Type.DRY, Type.LUSH);
	}
	
	private static Biome initBiome(Biome biome, String name, BiomeType biomeType, Type... types)
	{
		biome.setRegistryName(name);
		ForgeRegistries.BIOMES.register(biome);
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addBiome(biomeType, new BiomeEntry(biome, 10));
		
		if(ModConfig.spawnModdedBiomesInOverworld) 
		{
			BiomeManager.addSpawnBiome(biome);
		}
		return biome;
	}
}
