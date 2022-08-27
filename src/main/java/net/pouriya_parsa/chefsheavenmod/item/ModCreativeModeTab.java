package net.pouriya_parsa.chefsheavenmod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab CHEFS_HEAVEN_MOD_TAB = new CreativeModeTab("chefsheavenmodtab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.KNIFE.get());
        }
    };
}
