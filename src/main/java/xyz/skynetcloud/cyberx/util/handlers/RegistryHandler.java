package xyz.skynetcloud.cyberx.util.handlers;

import java.io.File;

import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import xyz.skynetcloud.cyberx.ChatMessage;
import xyz.skynetcloud.cyberx.init.BlockInit;
import xyz.skynetcloud.cyberx.init.ItemInit;
import xyz.skynetcloud.cyberx.init.TypeInit;
import xyz.skynetcloud.cyberx.util.ModConfig;
import xyz.skynetcloud.cyberx.util.interfaces.IHasModel;
import xyz.skynetcloud.cyberx.util.other.RenderChests.RenderingCloudChest;

@EventBusSubscriber
public class RegistryHandler 
{
	
	 public static Configuration config;
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll(ItemInit.ITEMS.toArray(new Item[0]));
	}
	
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event)
	{
		event.getRegistry().registerAll(BlockInit.BLOCKS.toArray(new Block[0]));
		
	}
	
	@SubscribeEvent
	public static void registerEnchantment(RegistryEvent.Register<Enchantment> event)
	{
		
	}
	
	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event)
	{		
		
		for(Item item : ItemInit.ITEMS)
		{
			if(item instanceof IHasModel)
			{
				((IHasModel)item).registerModels();
			}
		}
		
		for(Block block : BlockInit.BLOCKS)
		{
			if(block instanceof IHasModel)
			{
				((IHasModel)block).registerModels();
			}
		}
	}
	
	public static void preInitRegistries(FMLPreInitializationEvent event)
	{

		File directory = event.getModConfigurationDirectory();
        config = new Configuration(new File(directory.getPath(), "cyberReboot.cfg"));
        ModConfig.readConfig();
        
        
		
		//GameRegistry.registerWorldGenerator(new WorldGenOres(), 0);
		
		for (TypeInit type : TypeInit.values())
		{
			if (type.clazz != null)
				ClientRegistry.bindTileEntitySpecialRenderer(type.clazz, new RenderingCloudChest());
		}
		
		
	}
	
	public static void initRegistries(FMLInitializationEvent event)
	{
	     //RecipesInit.registerCrafting();
	     
	     MinecraftForge.EVENT_BUS.register(new ChatMessage());
	     
	}
	
	public static void postInitRegistries(FMLPostInitializationEvent event)
	{
        if (config.hasChanged()) {
            config.save();
        }
		
	}
	
	public static void serverRegistries(FMLServerStartingEvent event)
	{
	}
}
