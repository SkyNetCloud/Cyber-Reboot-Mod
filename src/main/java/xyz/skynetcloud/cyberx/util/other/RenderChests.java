package xyz.skynetcloud.cyberx.util.other;

import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.model.ModelChest;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderEntityItem;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xyz.skynetcloud.cyberx.blocks.block.BlockCyberChest;
import xyz.skynetcloud.cyberx.init.BlockInit;
import xyz.skynetcloud.cyberx.init.TypeInit;
import xyz.skynetcloud.cyberx.titles.TileEntityChestInit;


public class RenderChests {

@SideOnly(Side.CLIENT)
public static class RenderingCloudChest extends TileEntitySpecialRenderer<TileEntityChestInit>
{
    private Random random;

    private RenderEntityItem itemRenderer;

    private ModelChest model;

    //@formatter:off
    private static float[][] shifts = { 
            { 0.3F, 0.45F, 0.3F }, 
            { 0.7F, 0.45F, 0.3F }, 
            { 0.3F, 0.45F, 0.7F }, 
            { 0.7F, 0.45F, 0.7F }, 
            { 0.3F, 0.1F, 0.3F }, 
            { 0.7F, 0.1F, 0.3F }, 
            { 0.3F, 0.1F, 0.7F }, 
            { 0.7F, 0.1F, 0.7F }, 
            { 0.5F, 0.32F, 0.5F } };
    //@formatter:on

    private static EntityItem customitem = new EntityItem(null);

    private static float halfPI = (float) (Math.PI / 2D);

    public RenderingCloudChest()
    {
        this.model = new ModelChest();
        this.random = new Random();
    }

    @Override
    public void render(TileEntityChestInit te, double x, double y, double z, float partialTicks, int destroyStage, float partial)
    {
        if (te == null || te.isInvalid())
        {
            return;
        }

        EnumFacing facing = EnumFacing.SOUTH;
        TypeInit type = te.getType();

        if (te.hasWorld() && te.getWorld().getBlockState(te.getPos()).getBlock() == BlockInit.VIBRANIUM_CHEST)
        {
            facing = te.getFacing();
            IBlockState state = te.getWorld().getBlockState(te.getPos());
            type = state.getValue(BlockCyberChest.VARIANT_PROP);
        }

        if (destroyStage >= 0)
        {
            this.bindTexture(DESTROY_STAGES[destroyStage]);
            GlStateManager.matrixMode(5890);
            GlStateManager.pushMatrix();
            GlStateManager.scale(4F, 4F, 1F);
            GlStateManager.translate(0.0625F, 0.0625F, 0.0625F);
            GlStateManager.matrixMode(5888);
        }
        else
        {
            this.bindTexture(type.modelTexture);
        }

        GlStateManager.pushMatrix();



        GlStateManager.color(1F, 1F, 1F, 1F);
        GlStateManager.translate((float) x, (float) y + 1F, (float) z + 1F);
        GlStateManager.scale(1F, -1F, -1F);
        GlStateManager.translate(0.5F, 0.5F, 0.5F);

        switch (facing)
        {
        case NORTH:
        {
            GlStateManager.rotate(180F, 0F, 1F, 0F);
            break;
        }
        case SOUTH:
        {
            GlStateManager.rotate(0F, 0F, 1F, 0F);
            break;
        }
        case WEST:
        {
            GlStateManager.rotate(90F, 0F, 1F, 0F);
            break;
        }
        case EAST:
        {
            GlStateManager.rotate(270F, 0F, 1F, 0F);
            break;
        }
        default:
        {
            GlStateManager.rotate(0F, 0F, 1F, 0F);
            break;
        }
        }

        GlStateManager.translate(-0.5F, -0.5F, -0.5F);

        float lidangle = te.prevLidAngle + (te.lidAngle - te.prevLidAngle) * partialTicks;

        lidangle = 1F - lidangle;
        lidangle = 1F - lidangle * lidangle * lidangle;


        this.model.chestLid.rotateAngleX = -lidangle * halfPI;
        // Render the chest itself
        this.model.renderAll();

        if (destroyStage >= 0)
        {
            GlStateManager.matrixMode(5890);
            GlStateManager.popMatrix();
            GlStateManager.matrixMode(5888);
        }



        GlStateManager.popMatrix();
        GlStateManager.color(1F, 1F, 1F, 1F);



    }
  }
}