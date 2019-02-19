package xyz.skynetcloud.cyberx;

import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class ChatMessage {
	
	
    @SubscribeEvent
    public void onLogin(PlayerEvent.PlayerLoggedInEvent event){
        event.player.sendMessage(new TextComponentString("[Cyber Reboot] Want to help make this mod better send me more ideas and I'll think about adding them CyberReboot.skynetcloud.xyz"));
   
    
    }
   
    
    
    
    
    @SubscribeEvent
    public void onLogoff(PlayerEvent.PlayerLoggedOutEvent event){
        System.out.println("[WeatherPlus] Player logged out: " + event.player.getName());
    }
}
