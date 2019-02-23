package xyz.skynetcloud.cyberx;



import java.io.File;

import org.apache.logging.log4j.Logger;

import cofh.CoFHCore;
import cofh.cofhworld.CoFHWorld;
import cofh.redstoneflux.RedstoneFluxProps;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.common.util.CompoundDataFixer;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.relauncher.Side;
import xyz.skynetcloud.cyberx.proxy.CommonProxy;
import xyz.skynetcloud.cyberx.titles.TileEntityChestInit;
import xyz.skynetcloud.cyberx.util.handlers.RegistryHandler;

@Mod(modid = Main.MODID, name = Main.MODNAME, version = Main.VERSION, dependencies = Main.DEPENDENCIES, updateJSON = "https://raw.githubusercontent.com/SkyNetCloud/Cyber-Reboot-Mod/master/update.json" )
public class Main
{
	public static final String MODID = "cx";
	public static final String MODNAME = "Cyber Reboot";
	public static final String VERSION = "1.12.2";
	
	public static final String DEPENDENCIES  = CoFHCore.VERSION_GROUP + CoFHWorld.VERSION_GROUP + RedstoneFluxProps.VERSION_GROUP;
	
	public static final String CLIENT = "xyz.skynetcloud.cyberx.proxy.ClientProxy";
	public static final String SERVER = "xyz.skynetcloud.cyberx.proxy.CommonProxy";
	
	public static final int CHEST_GUI_ID = 1;
	public static final int GUI_ENERGY_STORAGE = 5;
	
	@Instance
	public static Main instance;
	
	public static Logger logger;
	
	public static final CreativeTabs CYBERTAB = new CyberTab("cybertab");
	
    @SidedProxy(clientSide = CLIENT, serverSide = SERVER)
    public static CommonProxy proxy;
    
    public static File config;
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
       RegistryHandler.initRegistries(event);
    }
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
     RegistryHandler.preInitRegistries(event);
     
		if (event.getSide() == Side.CLIENT ) {
			OBJLoader.INSTANCE.addDomain("cx");
		}
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) 
    {
    	RegistryHandler.postInitRegistries(event);
    }
    
    @EventHandler
    public void serverinit(FMLServerStartingEvent event)
    {
     RegistryHandler.serverRegistries(event);
    }
}
