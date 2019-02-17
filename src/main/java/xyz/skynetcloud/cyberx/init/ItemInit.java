package xyz.skynetcloud.cyberx.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import xyz.skynetcloud.cyberx.References;
import xyz.skynetcloud.cyberx.items.ItemBase;
import xyz.skynetcloud.cyberx.items.armor.ArmorBase;
import xyz.skynetcloud.cyberx.items.tools.ToolAxeBase;
import xyz.skynetcloud.cyberx.items.tools.ToolHoeBase;
import xyz.skynetcloud.cyberx.items.tools.ToolPickaxeBase;
import xyz.skynetcloud.cyberx.items.tools.ToolShovelBase;
import xyz.skynetcloud.cyberx.items.tools.ToolSwordBase;


public class ItemInit {

	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	//Armour Materials 
	public static final ArmorMaterial ARMOR_DARK_STEEL_MATERIAL = EnumHelper.addArmorMaterial("armor_dark_steel", References.MODID + ":dark_steel", 23, new int[] {2,5,7,3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 3.0F);
	public static final ArmorMaterial ARMOR_MATERIAL_RUBY = EnumHelper.addArmorMaterial("armor_material_ruby", References.MODID + ":ruby", 14, new int[] {2, 5, 7, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.0F);
	public static final ArmorMaterial ARMOR_MATERIAL_VIBRANIUM = EnumHelper.addArmorMaterial("armor_vibranium", References.MODID + ":vibranium",  14, new int[] {5, 7, 10, 12}, 25, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 15.0F);
	
	//Tool Materials 
	public static final ToolMaterial MATERIAL_DARK_STEEL = EnumHelper.addToolMaterial("material_dark_steel", 25, 250, 8.0F, 3.0F, 10);
	public static final ToolMaterial MATERIAL_RUBY = EnumHelper.addToolMaterial("material_ruby", 15, 250, 8.0F, 3.0F, 10);
	public static final ToolMaterial MATERIAL_VIBARNIUM = EnumHelper.addToolMaterial("masterial_vibarnium", 90, 600, 15.0F, 10.0F, 25);
	
	//Items
	public static final Item DARK_STEEL = new ItemBase("dark_steel", References.CYBERTAB);
	public static final Item DARK_STEEL_DUST = new ItemBase("dark_steel_dust", References.CYBERTAB);
	public static final Item RUBY = new ItemBase("ruby", References.CYBERTAB);
	public static final Item RUBY_DUST = new ItemBase("ruby_dust", References.CYBERTAB);
	public static final Item VIBRANIUM =  new ItemBase("vibranium", References.CYBERTAB);
	
	
	//Dark Steel Tools
	public static final Item DARK_STEEL_AXE = new ToolAxeBase("dark_steel_axe", MATERIAL_DARK_STEEL, References.CYBERTAB);
	public static final Item DARK_STEEL_PICKAXE = new ToolPickaxeBase("dark_steel_pickaxe", MATERIAL_DARK_STEEL, References.CYBERTAB);
	public static final Item DARK_STEEL_HOE = new ToolHoeBase("dark_steel_hoe", MATERIAL_DARK_STEEL, References.CYBERTAB);
	public static final Item DARK_STEEL_SWORD = new ToolSwordBase("dark_steel_sword", MATERIAL_DARK_STEEL, References.CYBERTAB);
	public static final Item DARK_STEEL_SHOVEL = new ToolShovelBase("dark_steel_shovel", MATERIAL_DARK_STEEL, References.CYBERTAB);
	
	// Ruby Tools
	public static final Item RUBY_SWORD = new ToolSwordBase("ruby_sword", MATERIAL_RUBY, References.CYBERTAB);
	public static final Item RUBY_SHOVEL = new ToolShovelBase("ruby_shovel", MATERIAL_RUBY, References.CYBERTAB);
	public static final Item RUBY_PICKAXE = new ToolPickaxeBase("ruby_pickaxe", MATERIAL_RUBY, References.CYBERTAB);
	public static final Item RUBY_AXE = new ToolAxeBase("ruby_axe", MATERIAL_RUBY, References.CYBERTAB);
	public static final Item RUBY_HOE = new ToolHoeBase("ruby_hoe", MATERIAL_RUBY, References.CYBERTAB);
	
	//Vibranium Tools
	public static final Item VIBRANIUM_SWORD = new ToolSwordBase("vibranium_sword", MATERIAL_VIBARNIUM, References.CYBERTAB);
	public static final Item VIBRANIUM_PICKAXE = new ToolPickaxeBase("vibranium_pickaxe", MATERIAL_VIBARNIUM, References.CYBERTAB);
	public static final Item VIBRANIUM_AXE = new ToolAxeBase("vibranium_axe", MATERIAL_VIBARNIUM, References.CYBERTAB);
	public static final Item VIBRANIUM_SHOVEL = new ToolShovelBase("vibranium_shovel", MATERIAL_VIBARNIUM, References.CYBERTAB);
	public static final Item VIBRANIUM_HOE = new ToolHoeBase("vibranium_hoe", MATERIAL_VIBARNIUM, References.CYBERTAB);
	
	
	//Dark Steel Armor
	public static final Item DARK_STEEL_HELMET = new ArmorBase("dark_steel_helmet", ARMOR_DARK_STEEL_MATERIAL, 1, EntityEquipmentSlot.HEAD);
	public static final Item DARK_STEEL_CHESTPLATE = new ArmorBase("dark_steel_chestplate", ARMOR_DARK_STEEL_MATERIAL, 1, EntityEquipmentSlot.CHEST);
	public static final Item DARK_STEEL_LEGGINGS = new ArmorBase("dark_steel_leggings", ARMOR_DARK_STEEL_MATERIAL, 2, EntityEquipmentSlot.LEGS);
	public static final Item DARK_STEEL_BOOTS = new ArmorBase("dark_steel_boots", ARMOR_DARK_STEEL_MATERIAL, 1, EntityEquipmentSlot.FEET);
	
	//Ruby Armour
	public static final Item RUBY_HELMET = new  ArmorBase("ruby_helmet", ARMOR_MATERIAL_RUBY, 1, EntityEquipmentSlot.HEAD);
	public static final Item RUBY_CHESTPLATE = new  ArmorBase("ruby_chestplate", ARMOR_MATERIAL_RUBY, 1, EntityEquipmentSlot.CHEST);
	public static final Item RUBY_LEGGINGS = new  ArmorBase("ruby_leggings", ARMOR_MATERIAL_RUBY, 2, EntityEquipmentSlot.LEGS);
	public static final Item RUBY_BOOTS = new  ArmorBase("ruby_boots", ARMOR_MATERIAL_RUBY, 1, EntityEquipmentSlot.FEET); 
	
	
	//Vibranium Armour
	public static final Item VIBRANIUM_HELMET = new  ArmorBase("vibranium_helmet", ARMOR_MATERIAL_VIBRANIUM, 1, EntityEquipmentSlot.HEAD);
	public static final Item VIBRANIUM_CHESTPLATE = new  ArmorBase("vibranium_chestplate", ARMOR_MATERIAL_VIBRANIUM, 1, EntityEquipmentSlot.CHEST);
	public static final Item VIBRANIUM_LEGGINGS = new  ArmorBase("vibranium_leggings", ARMOR_MATERIAL_VIBRANIUM, 2, EntityEquipmentSlot.LEGS);
	public static final Item VIBRANIUM_BOOTS = new  ArmorBase("vibranium_boots", ARMOR_MATERIAL_VIBRANIUM, 1, EntityEquipmentSlot.FEET); 
	
	
}
