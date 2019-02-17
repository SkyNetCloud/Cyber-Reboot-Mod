package xyz.skynetcloud.cyberx.blocks.block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import xyz.skynetcloud.cyberx.blocks.BlockBase;
import xyz.skynetcloud.cyberx.util.interfaces.IHasModel;

public class RubyBlock extends BlockBase implements IHasModel {

	public RubyBlock(String name, Material materialIn, CreativeTabs tab) {
		super(name, materialIn, tab);
		setSoundType(SoundType.METAL);
		setHardness(5.0F);
		setResistance(14.0F);
		setHarvestLevel("pickaxe", 5);
	}

}
