package xyz.skynetcloud.cyberx.util;

import javax.annotation.Nonnull;


import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent.MissingMappings;
import net.minecraftforge.event.RegistryEvent.MissingMappings.Mapping;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class MappingMissingHandler 
{
    @SubscribeEvent
    public void missingBlockMappings(MissingMappings<Block> event)
    {
        
    }

    @SubscribeEvent
    public void missingItemMappings(MissingMappings<Item> event)
    {
        
    }

    private static void replaceOldChestBlock(String path, Mapping<Block> mapping)
    {
      
    }

    private static void replaceOldChestItem(String path, Mapping<Item> mapping)
    {
       
    }

    private static void replaceOldUpgrades(String path, Mapping<Item> mapping)
    {
       
    }

    private static void replaceNewUpgrades(String path, Mapping<Item> mapping)
    {
    	
    }

    private static void replaceUpgradeItem(String path, Mapping<Item> mapping)
    {
       
    }
}