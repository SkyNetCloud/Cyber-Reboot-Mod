package xyz.skynetcloud.cyberx.blocks.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import xyz.skynetcloud.cyberx.Main;
import xyz.skynetcloud.cyberx.blocks.container.ContainerRubyChest;
import xyz.skynetcloud.cyberx.titles.TileEntityRubyChest;

public class GuiRubyChest extends GuiContainer {


	private static final ResourceLocation GUI_CHEST = new ResourceLocation(Main.MODID + ":textures/gui/ruby_chest_gui.png");
	private final InventoryPlayer playerInventory;
	private final TileEntityRubyChest te;
	
	
	public GuiRubyChest(InventoryPlayer playerInventory, TileEntityRubyChest chestInventory, EntityPlayer player) 
	{
		super(new ContainerRubyChest(playerInventory, chestInventory, player)); 
		this.playerInventory = playerInventory;
		this.te = chestInventory;
		
		this.xSize = 256;
		this.ySize = 256;
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) 
	{
		this.fontRenderer.drawString(this.te.getDisplayName().getUnformattedText(), 8, 6, 16086784);
		this.fontRenderer.drawString(this.playerInventory.getDisplayName().getUnformattedText(), 8, this.ySize - 92, 16086784);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
	{
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(GUI_CHEST);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
	}
}
