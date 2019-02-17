package xyz.skynetcloud.cyberx.init;

import cofh.api.util.ThermalExpansionHelper;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RecipesInit {

	
    public static ItemStack Smelterinput2 = new ItemStack(BlockInit.END_VIBRANIUM_ORE);
    public static ItemStack Smelterinput1 = new ItemStack(ItemInit.DARK_STEEL);
    public static ItemStack Smelteroutput = new ItemStack(ItemInit.VIBRANIUM);
    public static ItemStack Smelterinput3 = new ItemStack(BlockInit.VIBRANIUM_ORE);
    
	public static int smelter = 1200;
	public static int furnace = 2500;
	public static int pulverizer = 2510;
    //
	public static void registerCrafting() {
		registerArmorCrafting(ItemInit.VIBRANIUM_CHESTPLATE,ItemInit.VIBRANIUM_BOOTS,ItemInit.VIBRANIUM_HELMET, ItemInit.VIBRANIUM_LEGGINGS,ItemInit.DARK_STEEL_HELMET, ItemInit.DARK_STEEL_CHESTPLATE, ItemInit.DARK_STEEL_LEGGINGS, ItemInit.DARK_STEEL_BOOTS, ItemInit.DARK_STEEL, ItemInit.RUBY_HELMET, ItemInit.RUBY_CHESTPLATE, ItemInit.RUBY_LEGGINGS, ItemInit.RUBY_BOOTS);
	    registerFurnaceRecipe(ItemInit.RUBY, ItemInit.DARK_STEEL, ItemInit.VIBRANIUM);
	    registerPulverizerRecipe(ItemInit.DARK_STEEL_DUST, ItemInit.RUBY_DUST, ItemInit.RUBY, ItemInit.DARK_STEEL);
	    registerBlockCrafting(BlockInit.CLOUD_CHEST, BlockInit.CLOUD_BLOCK ,BlockInit.DARK_STEEL_BLOCK,BlockInit.RUBY_BLOCK,BlockInit.VIBRANIUM_BLOCK);
	    registerToolCrafting(ItemInit.DARK_STEEL_AXE, ItemInit.DARK_STEEL_SWORD, ItemInit.DARK_STEEL_PICKAXE, ItemInit.DARK_STEEL_HOE, ItemInit.DARK_STEEL_SHOVEL, ItemInit.RUBY_AXE, ItemInit.RUBY_PICKAXE, ItemInit.RUBY_SHOVEL, ItemInit.RUBY_SWORD, ItemInit.RUBY_HOE);
	}
    private static void registerArmorCrafting(Item vibraniumChestplate, Item vibraniumBoots, Item vibraniumHelmet, Item vibraniumLeggings, Item darkSteelHelmet, Item darkSteelChestplate, Item darkSteelLeggings, Item darkSteelBoots, Item darkSteel, Item rubyHelmet, Item rubyChestplate, Item rubyLeggings,Item rubyBoots) {
		GameRegistry.addShapedRecipe(new ResourceLocation("" + darkSteelHelmet.getRegistryName()), new ResourceLocation("cx:dark_steel_helmet"), new ItemStack(darkSteelHelmet), new Object[]{"IRI","I I","   ", 'I', ItemInit.DARK_STEEL, 'R', Items.REDSTONE});
		GameRegistry.addShapedRecipe(new ResourceLocation("" + darkSteelChestplate.getRegistryName()), new ResourceLocation("cx:dark_steel_chestplate"), new ItemStack(darkSteelChestplate), new Object[]{"I I","IRI","IRI",'R', Items.REDSTONE, 'I', ItemInit.DARK_STEEL});
		GameRegistry.addShapedRecipe(new ResourceLocation("" + darkSteelLeggings.getRegistryName()), new ResourceLocation("cx:dark_steel_leggings"), new ItemStack(darkSteelLeggings), new Object[]{"III","IRI","IRI", 'R', Items.REDSTONE, 'I', ItemInit.DARK_STEEL});
		GameRegistry.addShapedRecipe(new ResourceLocation("" + darkSteelBoots.getRegistryName()), new ResourceLocation("cx:dark_steel_boots"), new ItemStack(darkSteelBoots), new Object[]{"IRI","IRI",'R', Items.REDSTONE, 'I', ItemInit.DARK_STEEL});
		GameRegistry.addShapedRecipe(new ResourceLocation("" + rubyHelmet.getRegistryName()), new ResourceLocation("cx:ruby_helmet"), new ItemStack(rubyHelmet), new Object[]{"III","I I","   ", 'I', ItemInit.RUBY});
		GameRegistry.addShapedRecipe(new ResourceLocation("" + rubyChestplate.getRegistryName()), new ResourceLocation("cx:ruby_chestplate"), new ItemStack(rubyChestplate), new Object[]{"I I","III","III", 'I', ItemInit.RUBY});
		GameRegistry.addShapedRecipe(new ResourceLocation("" + rubyLeggings.getRegistryName()), new ResourceLocation("cx:ruby_leggings"), new ItemStack(rubyLeggings), new Object[]{"III","I I","I I", 'I', ItemInit.RUBY});
		GameRegistry.addShapedRecipe(new ResourceLocation("" + rubyBoots.getRegistryName()), new ResourceLocation("cx:ruby_boots"), new ItemStack(rubyBoots), new Object[]{"I I","I I", "   ", 'I', ItemInit.RUBY});
		GameRegistry.addShapedRecipe(new ResourceLocation("" + vibraniumHelmet.getRegistryName()), new ResourceLocation("cx:ruby_helmet"), new ItemStack(vibraniumHelmet), new Object[]{"III","I I","   ", 'I', ItemInit.VIBRANIUM});
		GameRegistry.addShapedRecipe(new ResourceLocation("" + vibraniumChestplate.getRegistryName()), new ResourceLocation("cx:ruby_chestplate"), new ItemStack(vibraniumChestplate), new Object[]{"I I","III","III", 'I', ItemInit.VIBRANIUM});
		GameRegistry.addShapedRecipe(new ResourceLocation("" + vibraniumLeggings.getRegistryName()), new ResourceLocation("cx:ruby_leggings"), new ItemStack(vibraniumLeggings), new Object[]{"III","I I","I I", 'I', ItemInit.VIBRANIUM});
		GameRegistry.addShapedRecipe(new ResourceLocation("" + vibraniumBoots.getRegistryName()), new ResourceLocation("cx:ruby_boots"), new ItemStack(vibraniumBoots), new Object[]{"I I","I I", "   ", 'I', ItemInit.VIBRANIUM});
		
	}
	//ThermalExpansion Furnace Recipe
	private static void registerFurnaceRecipe(Item ruby, Item darkSteel, Item vibranium) {

	     ThermalExpansionHelper.addFurnaceRecipe(furnace, new ItemStack(BlockInit.RUBY_ORE), new ItemStack(ruby));
	     ThermalExpansionHelper.addFurnaceRecipe(furnace, new ItemStack(BlockInit.Nether_RUBY_ORE), new ItemStack(ruby));
	     ThermalExpansionHelper.addFurnaceRecipe(furnace, new ItemStack(ItemInit.DARK_STEEL_DUST), new ItemStack(darkSteel));
	     ThermalExpansionHelper.addFurnaceRecipe(furnace, new ItemStack(BlockInit.VIBRANIUM_ORE), new ItemStack(vibranium));
	     ThermalExpansionHelper.addFurnaceRecipe(furnace, new ItemStack(BlockInit.END_VIBRANIUM_ORE), new ItemStack(vibranium));
	}
	//ThermalExpansion Pulverizer Recipe
	private static void registerPulverizerRecipe(Item darkSteelDust, Item rubyDust, Item ruby, Item darkSteel) {
		ThermalExpansionHelper.addPulverizerRecipe(pulverizer, new ItemStack(ruby), new ItemStack(ItemInit.RUBY_DUST));
		ThermalExpansionHelper.addPulverizerRecipe(pulverizer, new ItemStack(rubyDust), new ItemStack(Items.REDSTONE));
		ThermalExpansionHelper.addPulverizerRecipe(pulverizer, new ItemStack(darkSteel), new ItemStack(ItemInit.DARK_STEEL_DUST));
		
	}

	//Block Crafting
	private static void registerBlockCrafting(Block darkSteelBlock, Block rubyBlock,Block vibraniumBlock, Block cloudChest, Block cloudBlock) 
	{
		GameRegistry.addShapedRecipe(new ResourceLocation("" + cloudChest.getRegistryName()), new ResourceLocation("cx:cloud_chest_block"), new ItemStack(cloudChest), new Object[] {"CCC","CVC","CCC", 'C', BlockInit.CLOUD_BLOCK, 'V', ItemInit.VIBRANIUM });
	    GameRegistry.addShapedRecipe(new ResourceLocation("" + darkSteelBlock.getRegistryName()), new ResourceLocation("cx:dark_steel_block"), new ItemStack(darkSteelBlock), new Object[] {"DDD","DDD","DDD", 'D', ItemInit.DARK_STEEL});
	    GameRegistry.addShapedRecipe(new ResourceLocation("" + rubyBlock.getRegistryName()), new ResourceLocation("cx:dark_steel_block"), new ItemStack(rubyBlock), new Object[] {"RRR","RRR","RRR", 'R', ItemInit.RUBY});
	    GameRegistry.addShapedRecipe(new ResourceLocation("" + vibraniumBlock.getRegistryName()), new ResourceLocation("cx:vibranium_block"), new ItemStack(vibraniumBlock), new Object[] {"VVV","VVV","VVV", 'V', ItemInit.VIBRANIUM});
	}

	//Tool Crafting
	private static void registerToolCrafting(Item darkSteelAxe, Item darkSteelSword, Item darkSteelPickaxe, Item darkSteelHoe, Item darkSteelShovel, Item rubyAxe, Item rubyPickaxe, Item rubyShovel, Item rubySword, Item rubyHoe) {
		GameRegistry.addShapedRecipe(new ResourceLocation("" + darkSteelPickaxe.getRegistryName()), new ResourceLocation("cx:dark_steel_pickaxe"), new ItemStack(darkSteelPickaxe), new Object[] {"RRR"," S "," S ",'S', Items.STICK, 'R', ItemInit.DARK_STEEL});
		GameRegistry.addShapedRecipe(new ResourceLocation("" + darkSteelAxe.getRegistryName()), new ResourceLocation("cx:dark_steel_axe"), new ItemStack(darkSteelAxe), new Object[] {"RR ","RS "," S ",'S', Items.STICK, 'R', ItemInit.DARK_STEEL});
		GameRegistry.addShapedRecipe(new ResourceLocation("" + darkSteelSword.getRegistryName()), new ResourceLocation("cx:dark_steel_sword"), new ItemStack(darkSteelSword), new Object[] {"DRD","DRD"," S ", 'S', Items.STICK, 'D', Items.DIAMOND, 'R', ItemInit.DARK_STEEL});
	    GameRegistry.addShapedRecipe(new ResourceLocation("" + darkSteelShovel.getRegistryName()), new ResourceLocation("cx:dark_steel_shovel"), new ItemStack(darkSteelShovel), new Object[] {" R "," D "," D ", 'D', Items.STICK,'R', ItemInit.DARK_STEEL});
	    GameRegistry.addShapedRecipe(new ResourceLocation("" + darkSteelHoe.getRegistryName()), new ResourceLocation("cx:dark_steel_hoe"), new ItemStack(darkSteelHoe), new Object[] {"RR "," S "," S ", 'S', Items.STICK, 'R', ItemInit.DARK_STEEL});
	
	    GameRegistry.addShapedRecipe(new ResourceLocation("" + rubyPickaxe.getRegistryName()), new ResourceLocation("cx:ruby_pickaxe"), new ItemStack(rubyPickaxe), new Object[] {"RRR"," S "," S ", 'R', ItemInit.RUBY, 'S', Items.STICK});
	    GameRegistry.addShapedRecipe(new ResourceLocation("" + rubyAxe.getRegistryName()), new  ResourceLocation("cx:ruby_axe"), new ItemStack(rubyAxe), new Object[] {"RR ","RS "," S ", 'R', ItemInit.RUBY, 'S', Items.STICK});
	    GameRegistry.addShapedRecipe(new ResourceLocation("" + rubySword.getRegistryName()), new ResourceLocation("cx:ruby_sword"), new ItemStack(rubySword), new Object[] {" R "," R "," S ", 'R', ItemInit.RUBY, 'S', Items.STICK});
	    GameRegistry.addShapedRecipe(new ResourceLocation("" + rubyShovel.getRegistryName()), new ResourceLocation("cx:ruby_shovel"), new ItemStack(rubyShovel), new Object[] {" R "," S "," S ", 'R', ItemInit.RUBY, 'S', Items.STICK});
	    GameRegistry.addShapedRecipe(new ResourceLocation("" + rubyHoe.getRegistryName()),new ResourceLocation("cx:ruby_hoe"), new ItemStack(rubyHoe), new Object[] {"RR "," S "," S ", 'R', ItemInit.RUBY, 'S', Items.STICK});       
	}
}
