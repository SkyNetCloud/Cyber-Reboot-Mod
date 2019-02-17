package xyz.skynetcloud.cyberx.util.handlers;

import java.io.File;

import cofh.core.gui.GuiHandler;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import xyz.skynetcloud.cyberx.Main;
import xyz.skynetcloud.cyberx.blocks.container.ContainerCloudChest;
import xyz.skynetcloud.cyberx.blocks.container.ContainerDarkSteelChest;
import xyz.skynetcloud.cyberx.blocks.container.ContainerRubyChest;
import xyz.skynetcloud.cyberx.blocks.gui.GuiCloudChest;
import xyz.skynetcloud.cyberx.blocks.gui.GuiDarkSteelChest;
import xyz.skynetcloud.cyberx.blocks.gui.GuiRubyChest;
import xyz.skynetcloud.cyberx.init.BlockInit;
import xyz.skynetcloud.cyberx.init.ItemInit;
import xyz.skynetcloud.cyberx.init.RecipesInit;
import xyz.skynetcloud.cyberx.titles.TileEntityCloudChest;
import xyz.skynetcloud.cyberx.titles.TileEntityDarkSteelChest;
import xyz.skynetcloud.cyberx.titles.TileEntityRubyChest;
import xyz.skynetcloud.cyberx.util.ModConfig;
import xyz.skynetcloud.cyberx.util.interfaces.IHasModel;
import xyz.skynetcloud.cyberx.util.other.RenderChests.RenderingCloudChest;
import xyz.skynetcloud.cyberx.util.other.RenderChests.RenderingDarkSteelChest;
import xyz.skynetcloud.cyberx.util.other.RenderChests.RenderingRubyChest;
import xyz.skynetcloud.cyberx.world.generation.WorldGenOres;

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
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCloudChest.class, new RenderingCloudChest());
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRubyChest.class, new RenderingRubyChest());
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDarkSteelChest.class, new RenderingDarkSteelChest()); 
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
		
		GameRegistry.registerWorldGenerator(new WorldGenOres(), 0);
		
		NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new CloudRebootGuiHandler());
		
		
	}
	
	public static void initRegistries(FMLInitializationEvent event)
	{
	     RecipesInit.registerCrafting();
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
	
	
	
	public static class CloudRebootGuiHandler extends GuiHandler {
		
		@Override
		public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
		{
			if(ID == Main.CHEST_GUI_ID) return new ContainerCloudChest(player.inventory, (TileEntityCloudChest)world.getTileEntity(new BlockPos(x,y,z)), player);
			if(ID == Main.DARK_STEEL_GUI_ID) return new ContainerDarkSteelChest(player.inventory, (TileEntityDarkSteelChest)world.getTileEntity(new BlockPos(x,y,z)), player);
			if(ID == Main.RUBY_CHEST_GUI_ID) return new ContainerRubyChest(player.inventory, (TileEntityRubyChest)world.getTileEntity(new BlockPos(x,y,z)), player);
			return null;
		}
		
		@Override
		public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
		{
			if(ID == Main.CHEST_GUI_ID) return new GuiCloudChest(player.inventory, (TileEntityCloudChest)world.getTileEntity(new BlockPos(x,y,z)), player);
			if(ID == Main.DARK_STEEL_GUI_ID) return new GuiDarkSteelChest(player.inventory, (TileEntityDarkSteelChest)world.getTileEntity(new BlockPos(x,y,z)), player);
			if(ID == Main.RUBY_CHEST_GUI_ID) return new GuiRubyChest(player.inventory, (TileEntityRubyChest)world.getTileEntity(new BlockPos(x,y,z)), player);
			return null;
		}
	}

	
	
	
	
}
