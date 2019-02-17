package xyz.skynetcloud.cyberx;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xyz.skynetcloud.cyberx.init.BlockInit;
import xyz.skynetcloud.cyberx.init.ItemInit;

public class CyberTab extends CreativeTabs {

	public CyberTab(String label) {
		super(label);
		
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(BlockInit.VIBRANIUM_BLOCK);
	}

}
