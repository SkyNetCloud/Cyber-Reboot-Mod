package xyz.skynetcloud.cyberx.blocks.block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import xyz.skynetcloud.cyberx.blocks.BlockBase;
import xyz.skynetcloud.cyberx.util.interfaces.IHasModel;

public class CloudBlock extends BlockBase implements IHasModel {

	public CloudBlock(String name, Material material, CreativeTabs tab) {
		super(name, material, tab);
		setSoundType(SoundType.STONE);
		setHardness(1.0F);
		setResistance(0.1F);
		setHarvestLevel("pickaxe", 1);
	}

}
