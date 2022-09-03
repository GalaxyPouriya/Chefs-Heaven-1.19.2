package net.pouriya_parsa.chefsheavenmod.item.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.UseOnContext;
import net.pouriya_parsa.chefsheavenmod.item.ModItems;

public class KnifeItem extends Item {
    public KnifeItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult onItemUseFirst(ItemStack stack, UseOnContext context) {
        if(!context.getLevel().isClientSide) {
            if(context.getPlayer().getItemInHand(InteractionHand.OFF_HAND).is(ModItems.BIG_BOTTLE.get())) {
                context.getPlayer().addItem(new ItemStack(Items.GLASS_BOTTLE));
                context.getPlayer().getInventory().offhand.remove(1);
                context.getPlayer().swing(InteractionHand.MAIN_HAND);
            }
        }
        return super.onItemUseFirst(stack, context);
    }
}
