package xyz.skynetcloud.cyberx;

import cofh.CoFHCore;
import cofh.cofhworld.CoFHWorld;
import cofh.redstoneflux.RedstoneFluxProps;
import net.minecraft.creativetab.CreativeTabs;

public class References {

	public static final String MODID = "cx";
	public static final String MODNAME = "Cyber Reboot";
	public static final String VERSION = "1.12.2";
	public static final String MODJSON = "https://raw.githubusercontent.com/SkyNetCloud/Cloud-Reboot-Mod/master/update.json";
	
	public static final CreativeTabs CYBERTAB = new CyberTab("cybertab");
	
	public static final String DEPENDENCIES  = CoFHCore.VERSION_GROUP + CoFHWorld.VERSION_GROUP + RedstoneFluxProps.VERSION_GROUP;
	
	public static final String CLIENT = "xyz.skynetcloud.cyberx.proxy.ClientProxy";
	public static final String SERVER = "xyz.skynetcloud.cyberx.proxy.CommonProxy";
	
	
}
