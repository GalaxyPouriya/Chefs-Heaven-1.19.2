package net.pouriya_parsa.chefsheavenmod.item.custom;

import net.minecraft.network.chat.Component;
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
    public InteractionResult useOn(UseOnContext pContext) {
        if(!pContext.getLevel().isClientSide) {
            if(pContext.getPlayer().getItemInHand(InteractionHand.OFF_HAND).is(ModItems.BIG_BOTTLE.get())) {
                pContext.getPlayer().addItem(new ItemStack(Items.GLASS_BOTTLE));
                pContext.getPlayer().getOffhandItem().shrink(1);
                pContext.getPlayer().swing(InteractionHand.MAIN_HAND);

            }
        }
        return super.useOn(pContext);
    }

}
