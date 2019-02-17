package xyz.skynetcloud.cyberx.util;



import java.io.File;
import java.util.logging.Logger;

import org.apache.logging.log4j.Level;

import akka.actor.FSM.Event;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import xyz.skynetcloud.cyberx.Main;
import xyz.skynetcloud.cyberx.proxy.CommonProxy;
import xyz.skynetcloud.cyberx.util.handlers.RegistryHandler;

public class ModConfig {
	
	
	public static int DIMENSION_CYBER_ID = 12;
	public static boolean CYBER = false;
	public Logger logger;


	public static Configuration config;

    private static final String CATEGORY_GENERAL = "general";
    private static final String CATEGORY_DIMENSIONS = "dimensions";
    private static final String CATEGORY_ITEMS = "items";
    private static final String CATEGORY_BLOCKS = "blocks";
    
	public static boolean spawnModdedBiomesInOverworld = true;

    // Call this from CommonProxy.preInit(). It will create our config if it doesn't
    // exist yet and read the values if it does exist.
    public static void readConfig() {
        Configuration cfg = RegistryHandler.config;
        try {
            cfg.load();
            initGeneralConfig(cfg);
            initDimensionConfig(cfg);
        } catch (Exception e1) {
            Main.logger.log(Level.ERROR, "Problem loading config file!", e1);
        } finally {
            if (cfg.hasChanged()) {
                cfg.save();
            }
        }
    }

    private static void initGeneralConfig(Configuration cfg) {
        cfg.addCustomCategoryComment(CATEGORY_GENERAL, "General configuration");
       
    }

    private static void initDimensionConfig(Configuration cfg) {
        cfg.addCustomCategoryComment(CATEGORY_DIMENSIONS, "Dimension configuration");
        
        DIMENSION_CYBER_ID = cfg.getInt("DIMID", CATEGORY_DIMENSIONS, DIMENSION_CYBER_ID, 3,120, "Change Id If You want to");
        
        
        spawnModdedBiomesInOverworld = cfg.getBoolean("spawnCustomBiomesInOverworld", CATEGORY_DIMENSIONS, true, "Decide to disable this if you want the my Biomes To spawn in the workd");

    }
    
    private static void initItemsConfig(Configuration cfg) {
    	 cfg.addCustomCategoryComment(CATEGORY_ITEMS, "Items configuration");
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    }
}