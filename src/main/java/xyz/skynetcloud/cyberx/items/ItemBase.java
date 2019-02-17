package xyz.skynetcloud.cyberx.items;

import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import xyz.skynetcloud.cyberx.Main;
import xyz.skynetcloud.cyberx.init.ItemInit;
import xyz.skynetcloud.cyberx.util.interfaces.IHasModel;

public class ItemBase extends Item implements IHasModel
{
	public ItemBase(String name, CreativeTabs tab) 
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(tab);
		
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() 
	{
		Main.proxy.registerModel(this, 0);
	}

	public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world, int x, int y, int z,
			int sideHit, float hitVecX, float hitVecY, float hitVecZ) {
		return false;
	}

	public void openMyGui() {
		// TODO Auto-generated method stub
		
	}

	public boolean onBlockActivated(World parWorld, BlockPos parBlockPos, IBlockState parIBlockState,
			EntityPlayer parPlayer, EnumFacing parSide, float hitX, float hitY, float hitZ) {
		// TODO Auto-generated method stub
		return false;
	}
}
