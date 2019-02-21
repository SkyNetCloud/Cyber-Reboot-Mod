package xyz.skynetcloud.cyberx.blocks.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import xyz.skynetcloud.cyberx.init.TypeInit;
import xyz.skynetcloud.cyberx.titles.TileEntityChestInit;

public class ContainerCyberChest extends Container
{
    private TypeInit type;

    private EntityPlayer player;

    private IInventory chest;

	private TileEntityChestInit chestInventory;

    public ContainerCyberChest(IInventory playerInventory, IInventory chestInventory, TypeInit type, int xSize, int ySize)
    {
        this.chest = chestInventory;
        this.player = ((InventoryPlayer) playerInventory).player;
        this.type = type;
        chestInventory.openInventory(this.player);
        
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn)
    {
        return this.chest.isUsableByPlayer(playerIn);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
    {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (index < this.type.size)
            {
                if (!this.mergeItemStack(itemstack1, this.type.size, this.inventorySlots.size(), true))
                {
                    return ItemStack.EMPTY;
                }
            }
            else if (!this.type.acceptsStack(itemstack1))
            {
                return ItemStack.EMPTY;
            }
            else if (!this.mergeItemStack(itemstack1, 0, this.type.size, false))
            {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty())
            {
                slot.putStack(ItemStack.EMPTY);
            }
            else
            {
                slot.onSlotChanged();
            }
        }

        return itemstack;
    }

    @Override
    public void onContainerClosed(EntityPlayer playerIn)
    {
        super.onContainerClosed(playerIn);

        this.chest.closeInventory(playerIn);
    }

    public EntityPlayer getPlayer()
    {
        return this.player;
    }

    public int getNumColumns()
    {
        return this.type.rowLength;
    }
    
	public TileEntityChestInit getChestInventory()
	{
		return this.chestInventory;
	}
    
}
