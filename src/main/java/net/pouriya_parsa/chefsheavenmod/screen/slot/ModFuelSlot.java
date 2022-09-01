package net.pouriya_parsa.chefsheavenmod.screen.slot;

import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractFurnaceMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.pouriya_parsa.chefsheavenmod.screen.screens.OilCreatorMenu;

public class ModFuelSlot extends SlotItemHandler {

    public ModFuelSlot(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
        super(itemHandler, index, xPosition, yPosition);
    }

    public boolean canInsert(ItemStack stack) {
        return AbstractFurnaceBlockEntity.isFuel(stack) || ModFuelSlot.isBucket(stack);
    }


    public int getMaxItemCount(ItemStack stack) {
        return ModFuelSlot.isBucket(stack) ? 1 : super.getMaxStackSize(stack);
    }

    public static boolean isBucket(ItemStack stack) {
        return stack.is(Items.BUCKET);
    }
}
