package xyz.skynetcloud.cyberx.init;

import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.ResourceLocation;
import xyz.skynetcloud.cyberx.titles.TileEntityChestInit;
import xyz.skynetcloud.cyberx.util.ValidatingChestSlot;


public enum TypeInit implements IStringSerializable
{   
	//@formatter:off
    VIBRANIUM(108, 12, true, "vibranium_chest.png", TileEntityChestInit.class, 184, 256);
  //@formatter:on
	
    public static final TypeInit VALUES[] = values();

    public final String name;

    public final int size;

    public final int rowLength;

    public final boolean tieredChest;

    public final ResourceLocation modelTexture;

    private String breakTexture;

    public final Class<? extends TileEntityChestInit> clazz;

    public final int xSize;

    public final int ySize;

    //@formatter:off
    TypeInit(int size, int rowLength, boolean tieredChest, String modelTexture, Class<? extends TileEntityChestInit> clazz, int xSize, int ySize)
    //@formatter:on
    {
        this.name = this.name().toLowerCase();
        this.size = size;
        this.rowLength = rowLength;
        this.tieredChest = tieredChest;
        this.modelTexture = new ResourceLocation("cx", "textures/blocks/" + modelTexture);
        this.clazz = clazz;
        this.xSize = xSize;
        this.ySize = ySize;
    }

    @Override
    public String getName()
    {
        return this.name;
    }

    public int getRowCount()
    {
        return this.size / this.rowLength;
    }

    public Slot makeSlot(IInventory chestInventory, int index, int x, int y)
    {
        return new ValidatingChestSlot(chestInventory, index, x, y, this);
    }

    private static final Item DIRT_ITEM = Item.getItemFromBlock(Blocks.DIRT);

    public boolean acceptsStack(ItemStack itemstack)
    {

        return true;
    }

    public void adornItemDrop(ItemStack item)
    {
 
    }

    public TileEntityChestInit makeEntity()
    {
        switch (this)
        {
        case VIBRANIUM:
            return new TileEntityChestInit();
        default:
            return null;
        }
    }
}