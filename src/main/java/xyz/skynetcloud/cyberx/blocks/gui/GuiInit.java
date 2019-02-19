package xyz.skynetcloud.cyberx.blocks.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import xyz.skynetcloud.cyberx.blocks.container.ContainerCyberChest;
import xyz.skynetcloud.cyberx.init.TypeInit;
import xyz.skynetcloud.cyberx.titles.TileEntityChestInit;

public class GuiInit extends GuiContainer
{
    public enum ResourceList
    {
        //@formatter:off
    	DARKSTEEL(new ResourceLocation("ironchest", "textures/gui/dark_steel_container.png")),
    	RUBY(new ResourceLocation("ironchest", "textures/gui/ruby_container.png")),
    	VIBRANIUM(new ResourceLocation("ironchest", "textures/gui/vibranium_container.png"));
        //@formatter:on
        public final ResourceLocation location;

        ResourceList(ResourceLocation loc)
        {
            this.location = loc;
        }
    }

    public enum GUI
    {
        //@formatter:off
        DARKSTEEL(184, 202, ResourceList.DARKSTEEL, TypeInit.DARKSTEEL),
        RUBY(184, 256, ResourceList.RUBY, TypeInit.RUBY),
        VIBRANIUM(238, 256, ResourceList.VIBRANIUM, TypeInit.VIBRANIUM);
        //@formatter:on

        private int xSize;

        private int ySize;

        private ResourceList guiResourceList;

        private TypeInit mainType;

        GUI(int xSize, int ySize, ResourceList guiResourceList, TypeInit mainType)
        {
            this.xSize = xSize;
            this.ySize = ySize;
            this.guiResourceList = guiResourceList;
            this.mainType = mainType;
        }

        protected Container makeContainer(IInventory player, IInventory chest)
        {
            return new ContainerCyberChest(player, chest, this.mainType, this.xSize, this.ySize);
        }

        public static GuiInit buildGUI(TypeInit type, IInventory playerInventory, TileEntityChestInit chestInventory)
        {
            return new GuiInit(values()[chestInventory.getType().ordinal()], playerInventory, chestInventory);
        }
    }

    private GUI type;

    private GuiInit(GUI type, IInventory player, IInventory chest)
    {
        super(type.makeContainer(player, chest));
        this.type = type;
        this.xSize = type.xSize;
        this.ySize = type.ySize;
        this.allowUserInput = false;
    }

    /**
     * Draws the screen and all the components in it.
     */
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

        this.mc.getTextureManager().bindTexture(this.type.guiResourceList.location);

        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;

        this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);
    }
}