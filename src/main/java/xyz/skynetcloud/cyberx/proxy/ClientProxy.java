package xyz.skynetcloud.cyberx.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import xyz.skynetcloud.cyberx.blocks.gui.GuiInit;
import xyz.skynetcloud.cyberx.init.TypeInit;
import xyz.skynetcloud.cyberx.titles.TileEntityChestInit;

public class ClientProxy extends CommonProxy 
{

	@Override
	public void registerModel(Item item, int metadata) 
	{
		ModelLoader.setCustomModelResourceLocation(item, metadata, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}

	
	 public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	    {
	        TileEntity te = world.getTileEntity(new BlockPos(x, y, z));

	        if (te != null && te instanceof TileEntityChestInit)
	        {
	            return GuiInit.GUI.buildGUI(TypeInit.values()[ID], player.inventory, (TileEntityChestInit) te);
	        }
	        else
	        {
	            return null;
	        }
	    }

    @Override
    public World getClientWorld()
    {
        return Minecraft.getMinecraft().world;
    }
	
	
}
