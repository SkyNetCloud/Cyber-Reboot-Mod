package xyz.skynetcloud.cyberx.blocks.ores;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import xyz.skynetcloud.cyberx.blocks.BlockBase;
import xyz.skynetcloud.cyberx.util.interfaces.IHasModel;


public class RubyOre extends BlockBase implements IHasModel
{
	public RubyOre(String name, Material material, CreativeTabs tab) {
		super(name,material, tab);
		setSoundType(SoundType.STONE);
		setHardness(5.0F);
		setResistance(15.0F);
		setHarvestLevel("pickaxe", 10);
		setLightLevel(1.0F);
		
	}
	
}
