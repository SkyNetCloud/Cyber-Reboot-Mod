package xyz.skynetcloud.cyberx.blocks.ores;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import xyz.skynetcloud.cyberx.blocks.BlockBase;
import xyz.skynetcloud.cyberx.util.interfaces.IHasModel;

public class VibraniumOre extends BlockBase {

	public VibraniumOre(String name, Material materialIn, CreativeTabs tab) {
		super(name, materialIn, tab);
		setHardness(7.1f);
		setHarvestLevel("pickaxe", 50);
		setResistance(25.0F);
		setSoundType(SoundType.METAL);
		
	} 
	public static class EndVibraniumOre extends BlockBase
	{

		public EndVibraniumOre(String name, Material material, CreativeTabs tab) {
			super(name, material, tab);
			setHardness(7.1f);
			setHarvestLevel("pickaxe", 50);
			setResistance(25.0F);
			setSoundType(SoundType.METAL);
		}

		
	}
}
