package xyz.skynetcloud.cyberx.util.other;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xyz.skynetcloud.cyberx.Main;
import xyz.skynetcloud.cyberx.titles.TileEntityCloudChest;
import xyz.skynetcloud.cyberx.titles.TileEntityDarkSteelChest;
import xyz.skynetcloud.cyberx.titles.TileEntityRubyChest;
import xyz.skynetcloud.cyberx.util.other.ChestModels.CloudChestModel;
import xyz.skynetcloud.cyberx.util.other.ChestModels.DarkSteelChestModel;
import xyz.skynetcloud.cyberx.util.other.ChestModels.RubyChestModel;


public class RenderChests {

@SideOnly(Side.CLIENT)
public static class RenderingCloudChest extends TileEntitySpecialRenderer<TileEntityCloudChest>
{
	private static final ResourceLocation TEXTURE = new ResourceLocation(Main.MODID + ":textures/blocks/cloud_chest_block.png");
	private final CloudChestModel MODEL = new CloudChestModel();
	
	@Override
	public void render(TileEntityCloudChest te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) 
	{
		GlStateManager.enableDepth();
        GlStateManager.depthFunc(515);
        GlStateManager.depthMask(true);
    	
        CloudChestModel model = MODEL;
    	
    	if (destroyStage >= 0)
        {
            this.bindTexture(DESTROY_STAGES[destroyStage]);
            GlStateManager.matrixMode(5890);
            GlStateManager.pushMatrix();
            GlStateManager.scale(4.0F, 4.0F, 1.0F);
            GlStateManager.translate(0.0625F, 0.0625F, 0.0625F);
            GlStateManager.matrixMode(5888);
        }
    	else this.bindTexture(TEXTURE);
    	
    	GlStateManager.pushMatrix();
        GlStateManager.enableRescaleNormal();
        GlStateManager.translate((float)x, (float)y + 1.0F, (float)z + 1.0F);
        GlStateManager.scale(1.0F, -1.0F, -1.0F);
        GlStateManager.translate(0.5F, 0.5F, 0.5F);
        GlStateManager.translate(-0.5F, -0.5F, -0.5F);
       
        float f = te.prevLidAngle + (te.lidAngle - te.prevLidAngle) * partialTicks;
        f = 1.0F - f;
        f = 1.0F - f * f * f;
        model.chestLid.rotateAngleX = -(f * ((float)Math.PI / 2F));
        model.renderAll();
        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);

        if (destroyStage >= 0)
        {
            GlStateManager.matrixMode(5890);
            GlStateManager.popMatrix();
            GlStateManager.matrixMode(5888);
        }	
	}
}

@SideOnly(Side.CLIENT)
public static class RenderingDarkSteelChest extends TileEntitySpecialRenderer<TileEntityDarkSteelChest>
{
	private static final ResourceLocation TEXTURE = new ResourceLocation(Main.MODID + ":textures/blocks/dark_steel_chest.png");
	private final DarkSteelChestModel MODEL = new DarkSteelChestModel();
	
	@Override
	public void render(TileEntityDarkSteelChest te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) 
	{
		GlStateManager.enableDepth();
        GlStateManager.depthFunc(515);
        GlStateManager.depthMask(true);
    	
        DarkSteelChestModel model = MODEL;
    	
    	if (destroyStage >= 0)
        {
            this.bindTexture(DESTROY_STAGES[destroyStage]);
            GlStateManager.matrixMode(5890);
            GlStateManager.pushMatrix();
            GlStateManager.scale(4.0F, 4.0F, 1.0F);
            GlStateManager.translate(0.0625F, 0.0625F, 0.0625F);
            GlStateManager.matrixMode(5888);
        }
    	else this.bindTexture(TEXTURE);
    	
    	GlStateManager.pushMatrix();
        GlStateManager.enableRescaleNormal();
        GlStateManager.translate((float)x, (float)y + 1.0F, (float)z + 1.0F);
        GlStateManager.scale(1.0F, -1.0F, -1.0F);
        GlStateManager.translate(0.5F, 0.5F, 0.5F);
        GlStateManager.translate(-0.5F, -0.5F, -0.5F);
       
        float f = te.prevLidAngle + (te.lidAngle - te.prevLidAngle) * partialTicks;
        f = 1.0F - f;
        f = 1.0F - f * f * f;
        model.chestLid.rotateAngleX = -(f * ((float)Math.PI / 2F));
        model.renderAll();
        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);

        if (destroyStage >= 0)
        {
            GlStateManager.matrixMode(5890);
            GlStateManager.popMatrix();
            GlStateManager.matrixMode(5888);
        }	
	}
}
@SideOnly(Side.CLIENT)
public static class RenderingRubyChest extends TileEntitySpecialRenderer<TileEntityRubyChest>
{
	private static final ResourceLocation TEXTURE = new ResourceLocation(Main.MODID + ":textures/blocks/ruby_chest.png");
	private final RubyChestModel MODEL = new RubyChestModel();
	
	@Override
	public void render(TileEntityRubyChest te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) 
	{
		GlStateManager.enableDepth();
        GlStateManager.depthFunc(515);
        GlStateManager.depthMask(true);
    	
        RubyChestModel model = MODEL;
    	
    	if (destroyStage >= 0)
        {
            this.bindTexture(DESTROY_STAGES[destroyStage]);
            GlStateManager.matrixMode(5890);
            GlStateManager.pushMatrix();
            GlStateManager.scale(4.0F, 4.0F, 1.0F);
            GlStateManager.translate(0.0625F, 0.0625F, 0.0625F);
            GlStateManager.matrixMode(5888);
        }
    	else this.bindTexture(TEXTURE);
    	
    	GlStateManager.pushMatrix();
        GlStateManager.enableRescaleNormal();
        GlStateManager.translate((float)x, (float)y + 1.0F, (float)z + 1.0F);
        GlStateManager.scale(1.0F, -1.0F, -1.0F);
        GlStateManager.translate(0.5F, 0.5F, 0.5F);
        GlStateManager.translate(-0.5F, -0.5F, -0.5F);
       
        float f = te.prevLidAngle + (te.lidAngle - te.prevLidAngle) * partialTicks;
        f = 1.0F - f;
        f = 1.0F - f * f * f;
        model.chestLid.rotateAngleX = -(f * ((float)Math.PI / 2F));
        model.renderAll();
        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);

        if (destroyStage >= 0)
        {
            GlStateManager.matrixMode(5890);
            GlStateManager.popMatrix();
            GlStateManager.matrixMode(5888);
        }	
	}
}
}