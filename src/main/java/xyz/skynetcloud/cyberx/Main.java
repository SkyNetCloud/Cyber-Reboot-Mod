package xyz.skynetcloud.cyberx;

import java.io.File;

import org.apache.logging.log4j.Logger;

import cofh.CoFHCore;
import cofh.cofhworld.CoFHWorld;
import cofh.redstoneflux.RedstoneFluxProps;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.relauncher.Side;
import xyz.skynetcloud.cyberx.proxy.CommonProxy;
import xyz.skynetcloud.cyberx.util.handlers.RegistryHandler;

@Mod(modid = References.MODID, name = References.MODNAME, version = References.VERSION, dependencies = References.DEPENDENCIES , updateJSON = References.MODJSON) 
public class Main
{

	
	public static final int CHEST_GUI_ID = 1;
	public static final int GUI_ENERGY_STORAGE = 5;
	
	@Instance
	public static Main instance;
	
	public static Logger logger;
	
	public static final CreativeTabs CYBERTAB = new CyberTab("cybertab");
	
    @SidedProxy(clientSide = References.CLIENT, serverSide = References.SERVER)
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
