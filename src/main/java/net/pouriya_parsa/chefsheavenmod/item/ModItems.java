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
import net.pouriya_parsa.chefsheavenmod.item.properties.ModFoods;

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
                    .food(new FoodProperties.Builder().nutrition(3).build())));

    public static final RegistryObject<Item> BEEF_SAUSAGE = ITEMS.register("beef_sausage", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEFS_HEAVEN_MOD_TAB).food(ModFoods.BEEF_SAUSAGE)));
    public static final RegistryObject<Item> CHICKEN_SAUSAGE = ITEMS.register("chicken_sausage", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEFS_HEAVEN_MOD_TAB).food(ModFoods.CHICKEN_SAUSAGE)));
    public static final RegistryObject<Item> PORK_SAUSAGE = ITEMS.register("pork_sausage", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEFS_HEAVEN_MOD_TAB).food(ModFoods.PORK_SAUSAGE)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
