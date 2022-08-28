package net.pouriya_parsa.chefsheavenmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.pouriya_parsa.chefsheavenmod.ChefsHeavenMod;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ChefsHeavenMod.MOD_ID);

    public static final RegistryObject<Item> KNIFE = ITEMS.register("knife",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEFS_HEAVEN_MOD_TAB)));

    public static final RegistryObject<Item> TOMATO = ITEMS.register("tomato",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEFS_HEAVEN_MOD_TAB)
                    .food(new FoodProperties.Builder().nutrition(3).build())));

    public static final RegistryObject<Item> COOKED_TOMATO = ITEMS.register("cooked_tomato",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEFS_HEAVEN_MOD_TAB)
                    .food(new FoodProperties.Builder().nutrition(3).saturationMod(0.3F).effect(new MobEffectInstance(MobEffects.SATURATION, 60, 1), 2.0F).build())));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
