package xyz.skynetcloud.cyberx.blocks.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import xyz.skynetcloud.cyberx.Main;
import xyz.skynetcloud.cyberx.blocks.container.ContainerCyberChest;
import xyz.skynetcloud.cyberx.titles.TileEntityChestInit;

public class GuiInit extends GuiContainer {

	
	private static final ResourceLocation GUI_CHEST = new ResourceLocation(Main.MODID + ":textures/gui/vibranium_container.png");
	private final InventoryPlayer playerInventory;
	private final TileEntityChestInit te;
	
	
	public GuiInit(InventoryPlayer playerInventory, TileEntityChestInit chestInventory, EntityPlayer player)
	{
		super(new ContainerCyberChest(playerInventory, chestInventory, player));
		this.playerInventory = playerInventory;
		this.te = chestInventory;
		
		this.xSize = 183; 
		this.ySize = 256;
	}
	
    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

    /**
     * Draws the background layer of this container (behind the items).
     */
    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);

        this.mc.getTextureManager().bindTexture(GUI_CHEST);

        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;

        this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);
    
   }
}