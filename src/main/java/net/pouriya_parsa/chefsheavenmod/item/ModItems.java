package net.pouriya_parsa.chefsheavenmod.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.pouriya_parsa.chefsheavenmod.ChefsHeavenMod;
import net.pouriya_parsa.chefsheavenmod.item.custom.BlackPepperItem;
import net.pouriya_parsa.chefsheavenmod.item.custom.GreenPepperItem;
import net.pouriya_parsa.chefsheavenmod.item.custom.KnifeItem;
import net.pouriya_parsa.chefsheavenmod.item.custom.RedPepperItem;
import net.pouriya_parsa.chefsheavenmod.item.properties.ModFoods;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ChefsHeavenMod.MOD_ID);

    public static final RegistryObject<Item> KNIFE = ITEMS.register("knife",
            () -> new KnifeItem(new Item.Properties().tab(ModCreativeModeTab.CHEFS_HEAVEN_MOD_TAB).durability(410)));

    public static final RegistryObject<Item> TOMATO = ITEMS.register("tomato",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEFS_HEAVEN_MOD_TAB)
                    .food(ModFoods.TOMATO)));
    public static final RegistryObject<Item> COOKED_TOMATO = ITEMS.register("cooked_tomato",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEFS_HEAVEN_MOD_TAB)
                    .food(ModFoods.COOKED_TOMATO)));

    public static final RegistryObject<Item> BEEF_SAUSAGE = ITEMS.register("beef_sausage", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEFS_HEAVEN_MOD_TAB)
            .food(ModFoods.BEEF_SAUSAGE)));
    public static final RegistryObject<Item> CHICKEN_SAUSAGE = ITEMS.register("chicken_sausage", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEFS_HEAVEN_MOD_TAB)
            .food(ModFoods.CHICKEN_SAUSAGE)));
    public static final RegistryObject<Item> PORK_SAUSAGE = ITEMS.register("pork_sausage", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEFS_HEAVEN_MOD_TAB)
            .food(ModFoods.PORK_SAUSAGE)));

    public static final RegistryObject<Item> BEEF_HAM = ITEMS.register("beef_ham", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEFS_HEAVEN_MOD_TAB)
            .food(ModFoods.BEEF_HAM)));
    public static final RegistryObject<Item> CHICKEN_HAM = ITEMS.register("chicken_ham", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEFS_HEAVEN_MOD_TAB)
            .food(ModFoods.CHICKEN_HAM)));
    public static final RegistryObject<Item> PORK_HAM = ITEMS.register("pork_ham", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEFS_HEAVEN_MOD_TAB)
            .food(ModFoods.PORK_HAM)));

    public static final RegistryObject<Item> COOKED_BEEF_SAUSAGE = ITEMS.register("cooked_beef_sausage", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEFS_HEAVEN_MOD_TAB)
            .food(ModFoods.COOKED_BEEF_SAUSAGE)));
    public static final RegistryObject<Item> COOKED_CHICKEN_SAUSAGE = ITEMS.register("cooked_chicken_sausage", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEFS_HEAVEN_MOD_TAB)
            .food(ModFoods.COOKED_CHICKEN_SAUSAGE)));
    public static final RegistryObject<Item> COOKED_PORK_SAUSAGE = ITEMS.register("cooked_pork_sausage", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEFS_HEAVEN_MOD_TAB)
            .food(ModFoods.COOKED_PORK_SAUSAGE)));

    public static final RegistryObject<Item> DISH = ITEMS.register("dish",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEFS_HEAVEN_MOD_TAB)));

    public static final RegistryObject<Item> RED_PEPPER = ITEMS.register("red_pepper", () -> new RedPepperItem(new Item.Properties().tab(ModCreativeModeTab.CHEFS_HEAVEN_MOD_TAB)
            .food(ModFoods.RED_PEPPER)));
    public static final RegistryObject<Item> GREEN_PEPPER = ITEMS.register("green_pepper", () -> new GreenPepperItem(new Item.Properties().tab(ModCreativeModeTab.CHEFS_HEAVEN_MOD_TAB)
            .food(ModFoods.GREEN_PEPPER)));
    public static final RegistryObject<Item> BLACK_PEPPER = ITEMS.register("black_pepper", () -> new BlackPepperItem(new Item.Properties().tab(ModCreativeModeTab.CHEFS_HEAVEN_MOD_TAB)
            .food(ModFoods.BLACK_PEPPER)));

    public static final RegistryObject<Item> BIG_BOTTLE = ITEMS.register("big_bottle",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEFS_HEAVEN_MOD_TAB)));

    public static final RegistryObject<Item> SUNFLOWER_OIL_BOTTLE = ITEMS.register("sunflower_oil_bottle",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEFS_HEAVEN_MOD_TAB)));

    public static final RegistryObject<Item> OLIVE_OIL_BOTTLE = ITEMS.register("olive_oil_bottle",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEFS_HEAVEN_MOD_TAB)));

    public static final RegistryObject<Item> SESAME_OIL_BOTTLE = ITEMS.register("sesame_oil_bottle",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHEFS_HEAVEN_MOD_TAB)));

    public static final RegistryObject<Item> TOMATO_SLICES = ITEMS.register("tomato_slices",
            () -> new Item(new Item.Properties().stacksTo(12).tab(ModCreativeModeTab.CHEFS_HEAVEN_MOD_TAB)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
