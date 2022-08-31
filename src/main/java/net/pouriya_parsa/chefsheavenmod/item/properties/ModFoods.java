package net.pouriya_parsa.chefsheavenmod.item.properties;

import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties TOMATO = (new FoodProperties.Builder().nutrition(2).saturationMod(0.1f).build());
    public static final FoodProperties COOKED_TOMATO = (new FoodProperties.Builder().nutrition(4).saturationMod(0.3f).build());

    public static final FoodProperties BEEF_SAUSAGE = (new FoodProperties.Builder().nutrition(5).saturationMod(0.2F).build());
    public static final FoodProperties CHICKEN_SAUSAGE = (new FoodProperties.Builder().nutrition(4).saturationMod(0.1F).build());
    public static final FoodProperties PORK_SAUSAGE = (new FoodProperties.Builder().nutrition(6).saturationMod(0.4F).build());

    public static final FoodProperties BEEF_HAM = (new FoodProperties.Builder().nutrition((int) 7).saturationMod(0.3F).build());
    public static final FoodProperties CHICKEN_HAM = (new FoodProperties.Builder().nutrition(6).saturationMod(0.2F).build());
    public static final FoodProperties PORK_HAM = (new FoodProperties.Builder().nutrition((int) 8).saturationMod(0.5F).build());

    public static final FoodProperties COOKED_BEEF_SAUSAGE = (new FoodProperties.Builder().nutrition((int) 7).saturationMod(0.5F).build());
    public static final FoodProperties COOKED_CHICKEN_SAUSAGE = (new FoodProperties.Builder().nutrition(6).saturationMod(0.4F).build());
    public static final FoodProperties COOKED_PORK_SAUSAGE = (new FoodProperties.Builder().nutrition((int) 9).saturationMod(0.7F).build());

    public static final FoodProperties RED_PEPPER = (new FoodProperties.Builder().nutrition(2).saturationMod(0.1F).build());
    public static final FoodProperties GREEN_PEPPER = (new FoodProperties.Builder().nutrition(2).saturationMod(0.1F).build());
    public static final FoodProperties BLACK_PEPPER = (new FoodProperties.Builder().nutrition(2).saturationMod(0.1F).build());
}
