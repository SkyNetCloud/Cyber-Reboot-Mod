package xyz.skynetcloud.cyberx.init;


import net.minecraft.world.DimensionType;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.DimensionManager;
import xyz.skynetcloud.cyberx.util.ModConfig;
import xyz.skynetcloud.cyberx.world.dimensions.ModdedDimensionLibrary;

public class DimensionInit 
{
	public static final DimensionType CYBER = DimensionType.register("Cyber", "_cyber", ModConfig.DIMENSION_CYBER_ID, ModdedDimensionLibrary.class, false);
	
	public static void registerDimensions()
	{
		DimensionManager.registerDimension(ModConfig.DIMENSION_CYBER_ID, CYBER);
	}
		
}
