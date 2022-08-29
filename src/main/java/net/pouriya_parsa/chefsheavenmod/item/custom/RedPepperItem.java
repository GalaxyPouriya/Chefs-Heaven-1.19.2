package net.pouriya_parsa.chefsheavenmod.item.custom;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.Random;

public class RedPepperItem extends Item {
    public RedPepperItem(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        Random r = new Random();
        if(r.nextDouble() > 0.5) {
            entity.setSecondsOnFire(4);
        }
        return super.finishUsingItem(stack, level, entity);
    }
}
