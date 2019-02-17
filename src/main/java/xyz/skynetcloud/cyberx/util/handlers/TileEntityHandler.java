package xyz.skynetcloud.cyberx.util.handlers;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import xyz.skynetcloud.cyberx.References;
import xyz.skynetcloud.cyberx.titles.TileEntityCloudChest;

public class TileEntityHandler {
	
	public static void registerTileEntities()
	{
		GameRegistry.registerTileEntity(TileEntityCloudChest.class, new ResourceLocation(References.MODID + ":cloud_chest_block"));
		
	}

}
