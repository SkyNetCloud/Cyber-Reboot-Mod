package xyz.skynetcloud.cyberx.proxy;


import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import xyz.skynetcloud.cyberx.blocks.container.ContainerCyberChest;
import xyz.skynetcloud.cyberx.titles.TileEntityChestInit;

public class CommonProxy implements IGuiHandler
{	
	public void registerModel(Item item, int metadata) {}
	

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        return null;
    }

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		TileEntity te = world.getTileEntity(new BlockPos(x, y, z));
		
		if (te != null && te instanceof TileEntityChestInit)
        {
			TileEntityChestInit icte = (TileEntityChestInit) te;

            return new ContainerCyberChest(player.inventory, icte, icte.getType(), 0, 0);
        }
        else
        {
            return null;
        }
	}
	

    public World getClientWorld()
    {
        return null;
    }
	
}
