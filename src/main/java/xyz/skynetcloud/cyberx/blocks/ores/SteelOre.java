package xyz.skynetcloud.cyberx.blocks.ores;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import xyz.skynetcloud.cyberx.blocks.BlockBase;
import xyz.skynetcloud.cyberx.util.interfaces.IHasModel;

public class SteelOre extends BlockBase implements IHasModel {

	public SteelOre(String name, Material materialIn, CreativeTabs tab) {
		super(name, materialIn, tab);
		setSoundType(SoundType.STONE);
		setHardness(5.0F);
		setResistance(15.0F);
		setHarvestLevel("pickaxe", 9);
		setLightLevel(1.0F); 
		
	}
}
