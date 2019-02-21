package xyz.skynetcloud.cyberx.util;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import xyz.skynetcloud.cyberx.init.TypeInit;

public class ValidatingChestSlot extends Slot 
{
    private TypeInit type;

    public ValidatingChestSlot(IInventory inventoryIn, int slotIndex, int xPosition, int yPosition, TypeInit type)
    {
        super(inventoryIn, slotIndex, xPosition, yPosition);
        this.type = type;
    }

    @Override
    public boolean isItemValid(ItemStack stack)
    {
        return this.type.acceptsStack(stack);
    }
}