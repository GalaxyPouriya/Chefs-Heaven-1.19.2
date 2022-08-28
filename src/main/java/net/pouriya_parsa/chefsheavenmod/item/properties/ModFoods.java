package net.pouriya_parsa.chefsheavenmod.item.properties;

import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties BEEF_SAUSAGE = (new FoodProperties.Builder()).nutrition((int) 3.5).saturationMod(0.2F).build();
    public static final FoodProperties CHICKEN_SAUSAGE = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.1F).build();
    public static final FoodProperties PORK_SAUSAGE = (new FoodProperties.Builder()).nutrition((int) 2.5).saturationMod(0.4F).build();
}
